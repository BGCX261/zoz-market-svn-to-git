package vo
{
	[Bindable]
	[RemoteClass(alias="com.digo.beans.AddressBean")]
	public class AddressVO
	{
		public function AddressVO()
		{
		}
		
		private var _receiveAddrId:String;
		private var _username:String;
		private var _receiveName:String;
		private var _city:String;
		private var _street:String;
		private var _phone:String;
		private var _zipCode:String;
		private var _email:String;
		private var _deliveryType:String = "0";
		private var _payType:String = "0";
		
		public function get receiveAddrId():String
		{
			return _receiveAddrId;
		}

		public function set receiveAddrId(value:String):void
		{
			_receiveAddrId = value;
		}

		public function get username():String
		{
			return _username;
		}

		public function set username(value:String):void
		{
			_username = value;
		}

		public function get receiveName():String
		{
			return _receiveName;
		}

		public function set receiveName(value:String):void
		{
			_receiveName = value;
		}

		public function get city():String
		{
			return _city;
		}

		public function set city(value:String):void
		{
			_city = value;
		}

		public function get street():String
		{
			return _street;
		}

		public function set street(value:String):void
		{
			_street = value;
		}

		public function get phone():String
		{
			return _phone;
		}

		public function set phone(value:String):void
		{
			_phone = value;
		}

		public function get zipCode():String
		{
			return _zipCode;
		}

		public function set zipCode(value:String):void
		{
			_zipCode = value;
		}

		public function get email():String
		{
			return _email;
		}

		public function set email(value:String):void
		{
			_email = value;
		}

		public function get deliveryType():String
		{
			return _deliveryType;
		}

		public function set deliveryType(value:String):void
		{
			_deliveryType = value;
		}

		public function get payType():String
		{
			return _payType;
		}

		public function set payType(value:String):void
		{
			_payType = value;
		}


	}
}