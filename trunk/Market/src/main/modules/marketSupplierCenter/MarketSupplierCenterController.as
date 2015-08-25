package main.modules.marketSupplierCenter
{
	import main.modules.MarketSupplierCenter;
	
	import mx.binding.utils.BindingUtils;
	import mx.collections.ArrayCollection;
	import mx.formatters.DateFormatter;
	
	import util.ModelLocator;
	
	import vo.AccountVO;
	import vo.OrderListVO;
	import vo.RecordsVO;

	public class MarketSupplierCenterController
	{
		public var view:MarketSupplierCenter;
		private var model:MarketSupplierCenterModel;
		private var modelLocator:ModelLocator;
		private var term:ArrayCollection = new ArrayCollection();
		
		public function MarketSupplierCenterController(v:MarketSupplierCenter)
		{
			view = v;
			model = new MarketSupplierCenterModel(this);
			initBinding();
		}
		
		private function initBinding():void{
			BindingUtils.bindProperty(view, "basicInfo", model, "basicInfo");
			BindingUtils.bindProperty(view.dg1, "dataProvider", model, "orders");
		}
		
		public function saveBasicInfo(basicInfo:AccountVO):void{
			modelLocator = ModelLocator.newInstance();
			basicInfo.account = modelLocator.currentAccount;
			model.saveBasicInfo(basicInfo);
		}
		
		public function confirmDelivery(orderId:String):void{
			model.confirmDelivery(orderId);
		}
		
		public function search():void{
			var s:String = view.cmb2.selectedLabel;
			
			term.removeAll();
			switch(s){
				case "All":
					term.addItem("All");
					break;
				case "Waiting for payment":
					term.addItem("0");
					break;
				case "The buyer has to pay":
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
		
		public function saveDate(item:RecordsVO):void{
			model.saveDate(item);
		}
	}
}