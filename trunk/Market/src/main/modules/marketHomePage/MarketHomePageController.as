//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.marketHomePage
{
	import comp.DetailGood;
	import comp.GoodsTip;
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.utils.setTimeout;
	
	import main.modules.MarketHomePage;
	
	import mx.binding.utils.BindingUtils;
	import mx.collections.ArrayCollection;
	import mx.containers.Box;
	import mx.containers.HBox;
	import mx.containers.Panel;
	import mx.containers.VBox;
	import mx.controls.Label;
	import mx.core.UIComponent;
	import mx.events.DynamicEvent;
	
	import util.StaticTool;
	
	import vo.CommentVO;
	import vo.GoodsBeanVO;
	import vo.OneKindsGoodsVO;

	/**
	 *
	 * @author crash
	 */
	public class MarketHomePageController
	{
		private var model:MarketHomePageModel;

		public var view:MarketHomePage;
		
		private var lastIndex:int;
		
		private var tempS:Number;

		public function MarketHomePageController(view:MarketHomePage)
		{
			this.view = view;
			model = new MarketHomePageModel(this);
			initListener();
			initBinding();

		}

		private function initBinding():void
		{
			BindingUtils.bindProperty(view.detailList, "dataNodeAC", model, "detailAC");
			BindingUtils.bindProperty(view, "listImageAC", model, "titleImageAC");
			

		}
		
		//接收子控件事件并向外派发
		private function initListener():void
		{
			view.detailList.addEventListener(StaticTool.MENUCLICK, function(e:DynamicEvent):void
			{
				model.getOneKind(e.data);
			});

		}

		/**
		 *
		 */
		public function getManager1():void
		{
			model.getManager1();

		}
		
		public function searchGoods(value:String):void{
			model.searchGoods(value);
		}
		
		/**
		 * 生成分类首页商品
		 * @param listKinds
		 */
		public function seperateListKinds(listKinds:ArrayCollection):void
		{
			var tempAC:ArrayCollection = new ArrayCollection();
			for each(var okg:OneKindsGoodsVO in listKinds)
			{
				var hb:HBox = new HBox();
				var vb:VBox = new VBox();
				var lb:Label = new Label();
				vb.percentWidth = 100;
				vb.setStyle("borderStyle","solid");
				vb.setStyle("borderSides","top");
				
				vb.setStyle("paddingTop",10);
				vb.setStyle("paddingBottom",10);
				vb.setStyle("paddingLeft",10);
				vb.setStyle("paddingRight",10);
				
				hb.percentWidth = 100;
				
				lb.setStyle("fontWeight","bold");
				for each(var item:GoodsBeanVO in okg.list)
				{
					var gb:GoodsTip = new GoodsTip();
					gb.goodsNode = item;
					gb.addEventListener(MouseEvent.CLICK,getDetailGood);
					hb.addChild(gb);
				}
				lb.text = okg.kind;
				vb.addChild(lb);
				vb.addChild(hb);
				view.listKinds.addChild(vb);
			}
		}
		
		/**
		 * 生成单类列表商品
		 * @param oneKindGoods
		 */
		public function seperateOneKindGoods(oneKindGoods:OneKindsGoodsVO):void{
			var hb:HBox = new HBox();
			var vb:VBox = new VBox();
			var lb:Label = new Label();
			vb.percentWidth = 100;
			vb.setStyle("borderStyle","solid");
			vb.setStyle("borderSides","top");
			
			vb.setStyle("paddingTop",10);
			vb.setStyle("paddingBottom",10);
			vb.setStyle("paddingLeft",10);
			vb.setStyle("paddingRight",10);
			
			hb.percentWidth = 100;
			
			lb.setStyle("fontWeight","bold");
			
			lb.text = oneKindGoods.kind;
			vb.addChild(lb);
			for each(var item:GoodsBeanVO in oneKindGoods.list)
			{
				if(hb.getChildren().length == 5){
					vb.addChild(hb);
					hb = new HBox();
					hb.percentWidth = 100;
				}
				var gb:GoodsTip = new GoodsTip();
				gb.goodsNode = item;
				gb.addEventListener(MouseEvent.CLICK,getDetailGood);
				hb.addChild(gb);
			}
			
			vb.addChild(hb);
			view.searchView.removeAllChildren();
			view.searchView.addChild(vb);
			view.vs.selectedIndex = 1;
		}
		
		public function getDetailGood(e:Event):void{
			model.getDetailGood((e.currentTarget as GoodsTip).goodsNode.goodsId);
		}
		
		/**
		 * 生成详细商品页面
		 * @param item
		 */
		public function seperateCurrentGoods(item:GoodsBeanVO):void{
			var dg:DetailGood = new DetailGood();
			dg.goodsNode = item;
			view.detailView.removeAllChildren();
			view.detailView.addChild(dg);
			dg.addEventListener("cancel_crash",cancel);
			dg.addEventListener("cart_crash",toMyCart);
			dg.addEventListener("comment",addComment);
			dg.addEventListener("loginn",loginn);
			lastIndex = view.vs.selectedIndex;
			tempS = view.parentApplication.can.verticalScrollPosition;
			view.vs.selectedIndex = 2;
			view.parentApplication.can.verticalScrollPosition = 0;
		}
		
		private function loginn(e:DynamicEvent):void{
			view.dispatchEvent(e);
		}
		
		private function cancel(e:DynamicEvent):void{
			view.vs.selectedIndex = lastIndex;
			setTimeout(function():void{view.parentApplication.can.verticalScrollPosition = tempS;},10);
		}
		
		private function toMyCart(e:DynamicEvent):void{
			view.dispatchEvent(e);
		}
		
		private function addComment(e:DynamicEvent):void{
			var cvo:CommentVO = e.data as CommentVO;
			model.addComment(cvo);
		}
		
		/**
		 * 生成商品评论
		 * @param item
		 */
		public function seperateCurrentComments(ac:ArrayCollection):void{
			(view.detailView.getChildAt(0) as DetailGood).rp1.dataProvider = ac;
			
		}
	}
}
