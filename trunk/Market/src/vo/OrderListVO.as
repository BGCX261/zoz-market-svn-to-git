package vo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.digo.beans.OrderListBean")]
	public class OrderListVO
	{
		public function OrderListVO()
		{
		}
		
		private var _orderId:String;
		private var _receiveName:String;
		private var _total:String;
		private var _orderTime:String;
		private var _orderStatus:String;
		private var _goodsList:ArrayCollection;
		private var _record:RecordsVO;
		
		public function get orderId():String
		{
			return _orderId;
		}

		public function set orderId(value:String):void
		{
			_orderId = value;
		}

		public function get receiveName():String
		{
			return _receiveName;
		}

		public function set receiveName(value:String):void
		{
			_receiveName = value;
		}

		public function get total():String
		{
			return _total;
		}

		public function set total(value:String):void
		{
			_total = value;
		}

		public function get orderTime():String
		{
			return _orderTime;
		}

		public function set orderTime(value:String):void
		{
			_orderTime = value;
		}

		public function get orderStatus():String
		{
			return _orderStatus;
		}

		public function set orderStatus(value:String):void
		{
			_orderStatus = value;
		}

		public function get goodsList():ArrayCollection
		{
			return _goodsList;
		}

		public function set goodsList(value:ArrayCollection):void
		{
			_goodsList = value;
		}

		public function get record():RecordsVO
		{
			return _record;
		}

		public function set record(value:RecordsVO):void
		{
			_record = value;
		}


	}
}