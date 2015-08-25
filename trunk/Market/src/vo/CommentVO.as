package vo
{
	[Bindable]
	[RemoteClass(alias="com.digo.beans.CommentBean")]
	public class CommentVO
	{
		private var _userName:String;
		private var _score:String;
		private var _advantage:String;
		private var _disadvantage:String;
		public var goodsId:String;
		private var _content:String;
		private var _commentTime:Date;
		public function CommentVO()
		{
		}

		public function get userName():String
		{
			return _userName;
		}

		public function set userName(value:String):void
		{
			_userName = value;
		}

		public function get score():String
		{
			return _score;
		}

		public function set score(value:String):void
		{
			_score = value;
		}

		public function get advantage():String
		{
			return _advantage;
		}

		public function set advantage(value:String):void
		{
			_advantage = value;
		}

		public function get disadvantage():String
		{
			return _disadvantage;
		}

		public function set disadvantage(value:String):void
		{
			_disadvantage = value;
		}

		public function get content():String
		{
			return _content;
		}

		public function set content(value:String):void
		{
			_content = value;
		}

		public function get commentTime():Date
		{
			return _commentTime;
		}

		public function set commentTime(value:Date):void
		{
			_commentTime = value;
		}


	}
}