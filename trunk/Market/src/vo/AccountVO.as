package vo
{
	[Bindable]
	[RemoteClass(alias="com.digo.beans.AccountBean")]
	public class AccountVO
	{
		private var _account:String = "";
		private var _password:String = "";
		private var _power:String = "";
		private var _realName:String = "";
		private var _identityNumber:String = "";
		private var _email:String = "";
		private var _phone:String = "";
		private var _cash:Number;
		private var _type:String = "";
		
		public function AccountVO()
		{
		}

		public function get password():String
		{
			return _password;
		}

		public function set password(value:String):void
		{
			_password = value;
		}

		public function get account():String
		{
			return _account;
		}

		public function set account(value:String):void
		{
			_account = value;
		}

		public function get power():String
		{
			return _power;
		}

		public function set power(value:String):void
		{
			_power = value;
		}

		public function get realName():String
		{
			return _realName;
		}

		public function set realName(value:String):void
		{
			_realName = value;
		}

		public function get identityNumber():String
		{
			return _identityNumber;
		}

		public function set identityNumber(value:String):void
		{
			_identityNumber = value;
		}

		public function get email():String
		{
			return _email;
		}

		public function set email(value:String):void
		{
			_email = value;
		}

		public function get phone():String
		{
			return _phone;
		}

		public function set phone(value:String):void
		{
			_phone = value;
		}

		public function get cash():Number
		{
			return _cash;
		}

		public function set cash(value:Number):void
		{
			_cash = value;
		}

		public function get type():String
		{
			return _type;
		}

		public function set type(value:String):void
		{
			_type = value;
		}


	}
}