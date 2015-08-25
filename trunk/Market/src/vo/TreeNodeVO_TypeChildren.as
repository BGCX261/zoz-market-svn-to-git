//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package vo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	public class TreeNodeVO_TypeChildren
	{
		private var _children:ArrayCollection;

		private var _flag:Boolean;

		private var _groups:ArrayCollection;

		private var _label:String;

		private var _num:Number;

		private var _value:String;

		public function TreeNodeVO_TypeChildren()
		{
			this.children = new ArrayCollection();

		}

		public function get children():ArrayCollection
		{
			return _children;

		}

		public function set children(value:ArrayCollection):void
		{
			_children = value;

		}

		public function get flag():Boolean
		{
			return _flag;

		}

		public function set flag(value:Boolean):void
		{
			_flag = value;

		}

		public function get groups():ArrayCollection
		{
			return _groups;

		}

		public function set groups(value:ArrayCollection):void
		{
			_groups = value;

		}

		public function get label():String
		{
			return _label;

		}

		public function set label(value:String):void
		{
			_label = value;

		}

		public function get num():Number
		{
			return _num;

		}

		public function set num(value:Number):void
		{
			_num = value;

		}

		public function get value():String
		{
			return _value;

		}

		public function set value(value:String):void
		{
			_value = value;

		}
	}
}
