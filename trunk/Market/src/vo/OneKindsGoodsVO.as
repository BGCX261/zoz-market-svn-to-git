package vo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.digo.beans.OneKindsGoods")]
	public class OneKindsGoodsVO
	{
		private var _kind:String;
		
		private var _kindNum:String;
		
		private var _list:ArrayCollection = new ArrayCollection();
		
		public function OneKindsGoodsVO()
		{
		}

		public function get list():ArrayCollection
		{
			return _list;
		}

		public function set list(value:ArrayCollection):void
		{
			_list = value;
		}

		public function get kind():String
		{
			return _kind;
		}

		public function set kind(value:String):void
		{
			_kind = value;
		}

		public function get kindNum():String
		{
			return _kindNum;
		}

		public function set kindNum(value:String):void
		{
			_kindNum = value;
		}


	}
}