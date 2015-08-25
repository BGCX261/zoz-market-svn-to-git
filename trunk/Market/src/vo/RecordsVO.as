package vo
{
	[Bindable]
	[RemoteClass(alias="com.digo.beans.RecordsBean")]
	public class RecordsVO
	{
		public function RecordsVO()
		{
		}
		
		private var _recordsId:String;
		private var _orderId:String;
		private var _recordsType:String;
		private var _recordsNumber:int;
		private var _recordsTime:Date;
		private var _remark:String;

		public function get recordsId():String
		{
			return _recordsId;
		}

		public function set recordsId(value:String):void
		{
			_recordsId = value;
		}

		public function get orderId():String
		{
			return _orderId;
		}

		public function set orderId(value:String):void
		{
			_orderId = value;
		}

		public function get recordsType():String
		{
			return _recordsType;
		}

		public function set recordsType(value:String):void
		{
			_recordsType = value;
		}

		public function get recordsNumber():int
		{
			return _recordsNumber;
		}

		public function set recordsNumber(value:int):void
		{
			_recordsNumber = value;
		}

		public function get recordsTime():Date
		{
			return _recordsTime;
		}

		public function set recordsTime(value:Date):void
		{
			_recordsTime = value;
		}

		public function get remark():String
		{
			return _remark;
		}

		public function set remark(value:String):void
		{
			_remark = value;
		}


	}
}