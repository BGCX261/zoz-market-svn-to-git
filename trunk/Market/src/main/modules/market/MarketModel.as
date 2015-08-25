//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.market
{
	import mx.collections.ArrayCollection;
	import mx.events.DynamicEvent;
	
	import util.ModelLocator;
	import util.PopUpUtil;
	import util.XmlTool;
	
	import vo.AccountVO;
	import vo.TreeNodeVO_TypeChildren;

	public class MarketModel
	{
		private var controller:MarketController;

		//读取xml文件时，读入每个节点时的属性，该属性必须保证as节点类中有所有属性
		//如TreeNodeVO_TypeChildren中必须有label和value和children和group
		private var fieldAC:ArrayCollection;

		public var menuRoot:TreeNodeVO_TypeChildren;
		
		public var modelLocater:ModelLocator;

		public function MarketModel(controller:MarketController)
		{
			this.controller = controller;
			initTitle();
		}

		//初始化最上面的控制条控件Title,包括里面的一个菜单按钮，xml文件中第一个m1节点
		private function initTitle():void
		{
			fieldAC = new ArrayCollection(["label", "value"]);
			menuRoot = TreeNodeVO_TypeChildren(XmlTool.getXmlWithNode((controller.view.menuXML
				as XML).elements("m1")[0], "vo.TreeNodeVO_TypeChildren", fieldAC));

		}

		public function loginBack(e:DynamicEvent):void
		{
			PopUpUtil.remove(controller.popUpLogin);
			modelLocater = ModelLocator.newInstance();
			controller.view.label1.text = "welcome to Digo," + modelLocater.currentAccount + "!";
			controller.view.currentState = "login";
		}
	}
}
