//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.marketHomePage
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.DynamicEvent;
	import mx.rpc.AsyncResponder;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import util.StaticTool;
	import util.XmlTool;
	
	import vo.CommentVO;
	import vo.GoodsBeanVO;
	import vo.OneKindsGoodsVO;
	import vo.TreeNodeVO_TypeChildren;

	public class MarketHomePageModel
	{
		private var controller:MarketHomePageController;

		private var fieldAC:ArrayCollection;

		private var remoteObject:RemoteObject;

		public var detailAC:ArrayCollection;

		public var titleImageAC:ArrayCollection;
		
		public var listKinds:ArrayCollection;
		
		public var listComments:ArrayCollection;
		
		public var oneKindGoods:OneKindsGoodsVO;
		
		public var currentGood:GoodsBeanVO;
		
		public var pageSize:int = 20;
		
		public var pageNum:int = 1;
		
		public var commentPageSize:int = 5;
		
		public var commentPageNum:int = 1;

		public function MarketHomePageModel(controller:MarketHomePageController)
		{
			this.controller = controller;
			initRemoteObject();
			initDetailMenu();
			initTitleImage();
			getListKinds();

		}

		//初始化远程bean对象
		private function initRemoteObject():void
		{
			remoteObject = new RemoteObject();
			remoteObject.destination = "facade";
			remoteObject.showBusyCursor = true;

		}

		private function initTitleImage():void
		{
			titleImageAC = new ArrayCollection(["image00001.png", "image00002.png", "image00003.png",
				"image00004.png"])

		}

		//远程调用出错，弹出栈信息
		private function onRemoteFaultHandler(e:FaultEvent, token:AsyncToken):void
		{
			Alert.show(e.message.toString());

		}

		//获取Manager1
		public function getManager1():void
		{
//			var o:Object = new Object();
//			o["key01"] = "value01";
//			o["key02"] = "value02";
//			var token:AsyncToken = remoteObject.getManagerOneName(o);
//			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
//			{
//
//			}, onRemoteFaultHandler));

		}

		//初始化左侧分类菜单，读取l1节点为数据源。
		public function initDetailMenu():void
		{
			fieldAC = new ArrayCollection(["label", "value"]);
			var tempNode:TreeNodeVO_TypeChildren = TreeNodeVO_TypeChildren(XmlTool.getXmlWithNode((controller.
				view.menuXML as XML).elements("l1")[0], "vo.TreeNodeVO_TypeChildren", fieldAC));
			detailAC = tempNode.children;

		}
		
		public function getListKinds():void{
			var token:AsyncToken = remoteObject.getListKinds();
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				listKinds = (event.result as ArrayCollection);
				controller.seperateListKinds(listKinds);
			}, onRemoteFaultHandler));
		}
		
		public function getOneKind(kind:String):void{
			var token:AsyncToken = remoteObject.getOneKind(kind,pageNum,pageSize);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				oneKindGoods = (event.result as OneKindsGoodsVO);
				controller.seperateOneKindGoods(oneKindGoods);
			}, onRemoteFaultHandler));
		}
		
		public function getDetailGood(id:String):void{
			var token1:AsyncToken = remoteObject.getDetailGood(id);
			
			token1.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				currentGood = (event.result as GoodsBeanVO);
				controller.seperateCurrentGoods(currentGood);
				getGoodComments(id,commentPageNum,commentPageSize);
			}, onRemoteFaultHandler));
		}
		
		public function getGoodComments(id:String,commentPageNum:int,commentPageSize:int):void{
			var token2:AsyncToken = remoteObject.getGoodComments(id,commentPageNum,commentPageSize);
			token2.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				listComments = (event.result as ArrayCollection);
				controller.seperateCurrentComments(listComments);
			}, onRemoteFaultHandler));
		}
		
		public function searchGoods(value:String):void{
			var token:AsyncToken = remoteObject.searchGoods(value,pageNum,pageSize);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				oneKindGoods = (event.result as OneKindsGoodsVO);
				controller.seperateOneKindGoods(oneKindGoods);
			}, onRemoteFaultHandler));
		}
		
		public function addComment(cvo:CommentVO):void{
			var token:AsyncToken = remoteObject.addComment(cvo);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				getGoodComments((event.result as CommentVO).goodsId,commentPageNum,commentPageSize);
			}, onRemoteFaultHandler));
		}
	}
}
