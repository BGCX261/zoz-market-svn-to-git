//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.market
{
	import comp.HelpPanel;
	import comp.LoginPanel;
	
	import flash.display.DisplayObject;
	import flash.sampler.NewObjectSample;
	
	import main.Market;
	import main.modules.MarketHomePage;
	import main.modules.MarketPersonCenter;
	
	import mx.binding.utils.BindingUtils;
	import mx.controls.Alert;
	import mx.core.Application;
	import mx.events.DynamicEvent;
	import mx.events.FlexEvent;
	import mx.events.ModuleEvent;
	
	import util.ModelLocator;
	import util.PopUpUtil;
	import util.StaticTool;

	public class MarketController
	{
		private var model:MarketModel;

		public var popUpLogin:LoginPanel;
		
		private var popUpHelp:HelpPanel;

		public var view:Market;
		
		private var tempKey:String;
		
		private var modelLocater:ModelLocator;

		public function MarketController(view:Market)
		{
			this.view = view;
			model = new MarketModel(this);
			initBinding();
			addListener();
		}

		private function addListener():void
		{
			view.menu1.addEventListener(StaticTool.LINK, redirectModel);
			view.search.addEventListener(StaticTool.Search, searchModel);
			view.search.addEventListener(StaticTool.LINK, redirectModel);
		}

		private function initBinding():void
		{
			BindingUtils.bindProperty(view.menu1, "dataNode", model, "menuRoot");

		}

		//跳转模块
		private function redirectModel(e:DynamicEvent):void
		{
			loadModel(e.data);

		}
		
		private function searchModel(e:DynamicEvent):void
		{
			tempKey = e.searchValue as String;
			if(view.moduleLoader.child is MarketHomePage){
				(view.moduleLoader.child as MarketHomePage).controller.searchGoods(tempKey);
			}else{
				view.moduleLoader.addEventListener(ModuleEvent.READY,doSearch);
				loadModel(e.data);
			}
			
		}
		
		private function doSearch(e:ModuleEvent):void{
			(view.moduleLoader.child as MarketHomePage).addEventListener(FlexEvent.CREATION_COMPLETE,doSearch2);
			view.moduleLoader.removeEventListener(ModuleEvent.READY,doSearch);
		}
		
		private function doSearch2(e:FlexEvent):void{
			(e.target as MarketHomePage).vs.selectedIndex = 1;
			(e.target as MarketHomePage).controller.searchGoods(tempKey);
			(view.moduleLoader.child as MarketHomePage).removeEventListener(FlexEvent.CREATION_COMPLETE,doSearch2);
		}

		//载入模块
		public function loadModel(moduleName:String):void
		{
			modelLocater = ModelLocator.newInstance();
			switch(moduleName){
				case "MarketCenter":
					if(modelLocater.type == "role1"){
						moduleName = "MarketPersonCenter";
					}
					if(modelLocater.type == "role2"){
						moduleName = "MarketSupplierCenter";
					}
					break;
			}
			if(moduleName != "MarketHomePage" && !modelLocater.hasPower(moduleName))
			{
				if(modelLocater.currentAccount!=null){
					Alert.show("you have no power!","tip");
					return;
				}
				login("login");
				return;
			}
			if(moduleName == "MarketHomePage")
			{
				view.moduleLoader.addEventListener(ModuleEvent.READY,addE);
			}
			
			var moduleURL:String = "main/modules/" + moduleName + ".swf";
			view.moduleLoader.unloadModule();
			view.moduleLoader.url = "";
			view.moduleLoader.url = moduleURL;

		}
		
		private function addE(e:ModuleEvent):void{
			if(view.moduleLoader.child is MarketHomePage){
				view.moduleLoader.removeEventListener(ModuleEvent.READY,addE);
				(view.moduleLoader.child as MarketHomePage).addEventListener("loginn",loginner);
				(view.moduleLoader.child as MarketHomePage).addEventListener("cart_crash",toMyCart);
			}
		}

		//弹出登录框
		public function login(status:String):void
		{
			if(popUpLogin == null)
			{
				popUpLogin = new LoginPanel();
			}
			popUpLogin.init(null);
			popUpLogin.currentState = status;
			popUpLogin.addEventListener(StaticTool.LOGIN, loginBack);
			PopUpUtil.popUp(popUpLogin, DisplayObject(Application.application));

		}
		
		private function loginner(e:DynamicEvent):void{
			login("login");
		}
		
		private function toMyCart(e:DynamicEvent):void{
			view.moduleLoader.addEventListener(ModuleEvent.READY,toCart);
			loadModel("MarketPersonCenter");
		}
		
		private function toCart(e:ModuleEvent):void{
			if(view.moduleLoader.child is MarketPersonCenter){
				view.moduleLoader.removeEventListener(ModuleEvent.READY,toCart);
				(view.moduleLoader.child as MarketPersonCenter).toMyCart();
			}
		}
		
		public function displayHelp(flag:int):void
		{
			if(popUpHelp == null)
			{
				popUpHelp = new HelpPanel();
			}
			switch(flag)
			{
				case 0:
					popUpHelp.txt = view.menuXML..h1[0].toString();
					popUpHelp.title = "User instructions";
					popUpHelp.width = 600;
					popUpHelp.height = 400;
					break;
					
			}
			
			PopUpUtil.popUp(popUpHelp, DisplayObject(Application.application));
		}

		public function loginBack(e:DynamicEvent):void
		{
			model.loginBack(e);

		}

		public function moduleReady():void
		{
			view.moduleLoader.child.addEventListener(StaticTool.LINK, redirectModel);

		}
	}
}
