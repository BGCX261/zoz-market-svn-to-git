package util
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.AsyncResponder;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.AccountVO;

	[Bindable]
	public class ModelLocator
	{
		private static var modelLocator:ModelLocator;
		
		private var _currentAccount:String;
		//菜单名组成的权限字符串
		private var _currentPower:String;
		
		private var _type:String;
		
		private var _currentPassword:String;
		
		private var _cartList:ArrayCollection;

		private var _cash:Number;
		
		private var _remoteObject:RemoteObject;
		
		public static function newInstance():ModelLocator{
			if(modelLocator==null)
			{
				modelLocator = new ModelLocator();
				modelLocator._cartList = new ArrayCollection();
			}
			return modelLocator;
		}

		public function get currentAccount():String
		{
			return _currentAccount;
		}

		public function set currentAccount(value:String):void
		{
			_currentAccount = value;
		}

		public function set currentPower(value:String):void
		{
			_currentPower = value;
		}
		
		public function get currentPower():String
		{
			return _currentPower;
		}
		
		public function get cartList():ArrayCollection
		{
			return _cartList;
		}
		
		public function set cartList(value:ArrayCollection):void
		{
			_cartList = value;
		}
		
		public function hasPower(menuName:String):Boolean{
			if(_currentPower!=null && _currentPower.indexOf(menuName)!=-1)
			{
				return true;
			}else{
				return false;
			}
		}

		public static function logOut():void{
			modelLocator = null;
		}

		public function get cash():Number
		{
			return _cash;
		}

		public function set cash(value:Number):void
		{
			_cash = value;
		}
		
		private function initRemote():void{
			_remoteObject = new RemoteObject();
			_remoteObject.destination = "facade";
			_remoteObject.showBusyCursor = true;
		}

		public function refreshAccount():void{
			if(_remoteObject==null){
				initRemote();
			}
			var ab:AccountVO = new AccountVO();
			ab.account = this._currentAccount;
			ab.password = this._currentPassword;
			var token1:AsyncToken = _remoteObject.logIn(ab);
			token1.addResponder(new AsyncResponder(function(event:ResultEvent, token:AsyncToken):void
			{
				if(event.result)
				{
					var e:AccountVO = event.result as AccountVO;
					if(e.account != null)
					{
						var modelLocator:ModelLocator = ModelLocator.newInstance();
						modelLocator.currentAccount = e.account;
						modelLocator.currentPower = e.power;
						modelLocator.cash = e.cash;
						modelLocator.currentPassword = e.password;
						Alert.show("The current balance "+_cash.toFixed(2)+"￥","tip");
					}else{
						
					}
				}else{
					
				}
			}, onRemoteFaultHandler));
		}
		
		//远程调用出错，弹出栈信息
		private function onRemoteFaultHandler(e:FaultEvent, token:AsyncToken):void
		{
			Alert.show(e.message.toString());
			
		}

		public function get currentPassword():String
		{
			return _currentPassword;
		}

		public function set currentPassword(value:String):void
		{
			_currentPassword = value;
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