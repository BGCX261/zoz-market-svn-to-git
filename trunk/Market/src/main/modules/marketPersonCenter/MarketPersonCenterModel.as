//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.marketPersonCenter
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncResponder;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import util.ModelLocator;
	
	import vo.AccountVO;
	import vo.AddressVO;
	import vo.OrderListVO;
	import vo.RecordsVO;

	public class MarketPersonCenterModel
	{
		private var controller:MarketPersonCenterController;
		
		private var remoteObject:RemoteObject;
		
		[Bindable]
		public var basicInfo:AccountVO;
		
		[Bindable]
		public var currentAddr:AddressVO = new AddressVO();
		
		[Bindable]
		public var addrAC:ArrayCollection;
		
		[Bindable]
		public var orders:ArrayCollection = new ArrayCollection();
		
		private var modelLocater:ModelLocator;

		public function MarketPersonCenterModel(controller:MarketPersonCenterController)
		{
			this.controller = controller;
			initRemoteObject();
			getBasicInfo();
			getAddrList();
			getAllOrders();
		}
		
		//初始化远程bean对象
		private function initRemoteObject():void
		{
			remoteObject = new RemoteObject();
			remoteObject.destination = "facade";
			remoteObject.showBusyCursor = true;
			
		}
		
		public function getBasicInfo():void{
			modelLocater = ModelLocator.newInstance();
			var token:AsyncToken = remoteObject.getBasicInfo(modelLocater.currentAccount);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				basicInfo = (event.result as AccountVO);
				
			}, onRemoteFaultHandler));
		}
		
		public function getAddrList():void{
			modelLocater = ModelLocator.newInstance();
			var token:AsyncToken = remoteObject.getAddrList(modelLocater.currentAccount);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				addrAC = (event.result as ArrayCollection);
				
			}, onRemoteFaultHandler));
		}
		
		public function saveAddr(addr:AddressVO):void{
			var token:AsyncToken = remoteObject.saveAddr(addr);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result == true){
					getAddrList();
				}else{
					Alert.show("save failed");
				}
			}, onRemoteFaultHandler));
		}
		
		public function delAddr(addrId:String):void{
			var token:AsyncToken = remoteObject.delAddr(addrId);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result == true){
					getAddrList();
				}else{
					Alert.show("delete failed");
				}
			}, onRemoteFaultHandler));
		}
		
		public function saveBasicInfo(basicInfo:AccountVO):void{
			var token:AsyncToken = remoteObject.saveBasicInfo(basicInfo);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result == true){
					getBasicInfo();
				}else{
					Alert.show("save failed");
					controller.view.resetBasicInfo(basicInfo);
				}
			}, onRemoteFaultHandler));
		}
		
		public function toOrder(accountId:String, receiveAddrId:String, ac:ArrayCollection, payType:String, record:RecordsVO):void{
			var token:AsyncToken = remoteObject.toOrder(accountId,receiveAddrId,ac,payType,record);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result == true){
					getAllOrders();
					ModelLocator.newInstance().cartList.removeAll();
				}else{
					Alert.show("To generate order failed");
				}
			}, onRemoteFaultHandler));
		}
		
		public function getAllOrders():void{
			modelLocater = ModelLocator.newInstance();
			var token:AsyncToken = remoteObject.getAllOrders(modelLocater.currentAccount);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				orders.removeAll();
				if(event.result != null){
					orders = event.result as ArrayCollection;
				}else{
					Alert.show("get all orders failed");
				}
			}, onRemoteFaultHandler));
		}
		
		public function payment(orderId:String):void{
			var token:AsyncToken = remoteObject.payment(orderId);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result==true){
					getAllOrders();
					modelLocater = ModelLocator.newInstance();
					modelLocater.refreshAccount();
				}else{
					modelLocater = ModelLocator.newInstance();
					Alert.show("Balance is insufficient, the current balance "+modelLocater.cash.toFixed(2)+"￥","tip");
				}
			}, onRemoteFaultHandler));
		}
		
		public function confirmReceipt(orderId:String):void{
			var token:AsyncToken = remoteObject.confirmReceipt(orderId);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result==true){
					getAllOrders();
				}else{
					
				}
			}, onRemoteFaultHandler));
		}
		
		public function delOrder(orderId:String):void{
			var token:AsyncToken = remoteObject.delOrder(orderId);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result==true){
					getAllOrders();
				}else{
					Alert.show("delete order fail!","tip");
				}
			}, onRemoteFaultHandler));
		}
		
		//远程调用出错，弹出栈信息
		private function onRemoteFaultHandler(e:FaultEvent, token:AsyncToken):void
		{
			Alert.show(e.message.toString());
			
		}
		
		
	}
}
