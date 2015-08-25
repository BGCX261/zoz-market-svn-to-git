package main.modules.marketSupplierCenter
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
	import vo.RecordsVO;

	public class MarketSupplierCenterModel
	{
		private var controller:MarketSupplierCenterController;
		
		private var remoteObject:RemoteObject;
		
		private var modelLocater:ModelLocator;
		
		[Bindable]
		public var orders:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public var basicInfo:AccountVO;
		
		public function MarketSupplierCenterModel(c:MarketSupplierCenterController)
		{
			controller = c;
			initRemoteObject();
			getBasicInfo();
			getAllOrders();
		}
		
		//初始化远程bean对象
		private function initRemoteObject():void
		{
			remoteObject = new RemoteObject();
			remoteObject.destination = "facade";
			remoteObject.showBusyCursor = true;
			
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
		
		public function getBasicInfo():void{
			modelLocater = ModelLocator.newInstance();
			var token:AsyncToken = remoteObject.getBasicInfo(modelLocater.currentAccount);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				basicInfo = (event.result as AccountVO);
				
			}, onRemoteFaultHandler));
		}
		
		public function getAllOrders():void{
			var token:AsyncToken = remoteObject.getAllOrders();
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
		
		public function confirmDelivery(orderId:String):void{
			var token:AsyncToken = remoteObject.confirmDelivery(orderId);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result==true){
					getAllOrders();
				}else{
					Alert.show("confirmFail","tip");
				}
			}, onRemoteFaultHandler));
		}
		
		//远程调用出错，弹出栈信息
		private function onRemoteFaultHandler(e:FaultEvent, token:AsyncToken):void
		{
			Alert.show(e.message.toString());
			
		}
		
		public function saveDate(item:RecordsVO):void{
			var token:AsyncToken = remoteObject.saveDate(item);
			token.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result==true){
					getAllOrders();
				}else{
					Alert.show("Save Date Fail","tip");
				}
			}, onRemoteFaultHandler));
		}
	}
}