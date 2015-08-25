//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package util
{
	import flash.display.DisplayObject;
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;

	public class PopUpUtil
	{
		static public function popUp(panel:IFlexDisplayObject, parent:DisplayObject, modal:Boolean
			= true):void
		{
			PopUpManager.addPopUp(panel, parent, modal);
			PopUpManager.centerPopUp(panel);

		}

		static public function remove(panel:IFlexDisplayObject):void
		{
			PopUpManager.removePopUp(panel);

		}

		public function PopUpUtil()
		{
		}
	}
}
