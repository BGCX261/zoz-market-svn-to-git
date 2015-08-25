//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package main.modules.marketPersonCenter
{
	import main.modules.MarketPersonCenter;
	
	import mx.binding.utils.BindingUtils;
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import util.ModelLocator;
	
	import vo.AccountVO;
	import vo.AddressVO;
	import vo.OrderListVO;
	import vo.RecordsVO;

	public class MarketPersonCenterController
	{
		private var model:MarketPersonCenterModel;
		private var modelLocator:ModelLocator;
		public var view:MarketPersonCenter;
		private var term:ArrayCollection = new ArrayCollection();

		public function MarketPersonCenterController(view:MarketPersonCenter)
		{
			this.view = view;
			model = new MarketPersonCenterModel(this);
			initBinding();
		}
		
		private function initBinding():void
		{
			BindingUtils.bindProperty(view, "basicInfo", model, "basicInfo");
			BindingUtils.bindProperty(view, "currentAddr", model, "currentAddr");
			BindingUtils.bindProperty(view.dg2, "dataProvider", model, "addrAC");
			BindingUtils.bindProperty(view.rp1, "dataProvider", model, "addrAC");
			BindingUtils.bindProperty(view.dg1, "dataProvider", model, "orders");
		}
		
		public function saveCurrentAddr(addr:AddressVO):void{
			modelLocator = ModelLocator.newInstance();
			addr.username = modelLocator.currentAccount;
			model.saveAddr(addr);
		}
		
		public function delAddr(addr:AddressVO):void{
			model.delAddr(addr.receiveAddrId);
		}
		
		public function saveBasicInfo(basicInfo:AccountVO):void{
			modelLocator = ModelLocator.newInstance();
			basicInfo.account = modelLocator.currentAccount;
			model.saveBasicInfo(basicInfo);
		}
		
		public function toOrder():void{
			modelLocator = ModelLocator.newInstance();
			if(modelLocator.cartList.length == 0){
				Alert.show("please add some goods to cart","tip");
				return;
			}
			if(modelLocator.currentAccount == null || modelLocator.currentAccount == ""){
				Alert.show("please logIn first","tip");
				return;
			}
			if(model.addrAC.length == 0){
				Alert.show("please add a receiveAddr first","tip");
				return;
			}
			if(view.addrRBG.selectedValue == null){
				Alert.show("please choice a receiveAddr first","tip");
				return;
			}
			Alert.show("Now generate order？","tip", Alert.OK | Alert.CANCEL, null, function(event:CloseEvent):void{
				if(event.detail == Alert.OK){
					var record:RecordsVO = new RecordsVO();
					record.recordsType = view.rbgTime.selectedValue.toString();
					record.recordsNumber = view.ckbNight.selected==true?1:0;
					record.remark = "0"
					model.toOrder(modelLocator.currentAccount,view.addrRBG.selectedValue.toString(),modelLocator.cartList,view.rbgPayType.selectedValue.toString()
					,record);
				}
			});
		}
		
		public function payment(orderId:String):void{
			model.payment(orderId);
		}
		
		public function confirmReceipt(orderId:String):void{
			model.confirmReceipt(orderId);
		}
		
		public function delOrder(orderId:String):void{
			Alert.show("delete the order？","tip", Alert.OK | Alert.CANCEL, null, function(event:CloseEvent):void{
				if(event.detail == Alert.OK){
					model.delOrder(orderId);
				}
			});
		}
		
		public function search():void{
			var s:String = view.cmb2.selectedLabel;
			
			term.removeAll();
			switch(s){
				case "All":
					term.addItem("All");
					break;
				case "Pending payment":
					term.addItem("0");
					break;
				case "Waiting for delivery":
					term.addItem("1");
					break;
				case "The seller has shipped":
					term.addItem("2");
					break;
				case "Transaction has completed":
					term.addItem("3");
					break;
			}
			(view.dg1.dataProvider as ArrayCollection).filterFunction = doSearch;
			(view.dg1.dataProvider as ArrayCollection).refresh();
		}
		
		private function doSearch(o:Object):Boolean{
			var item:OrderListVO = o as OrderListVO;
			if(term.getItemAt(0) == "All"){
				return true;
			}
			if(term.getItemAt(0) == item.orderStatus){
				return true;
			}
			return false;
		}
	}
}
