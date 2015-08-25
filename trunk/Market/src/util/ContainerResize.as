//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package util
{
	import mx.core.Container;
	import mx.core.ScrollPolicy;
	import mx.events.ResizeEvent;

	public class ContainerResize
	{
		/**
		 * 当容器resize时控制垂直滑动条的显示与消失，防止flexbug导致水平滑动条无故出现
		 * 控制水平滑动条的显示与消失，防止flexbug导致垂直滑动条无故出现
		 */
		static public function resize(event:ResizeEvent):void
		{
			if(event.target.height < event.target.measuredHeight)
			{
				(event.target as Container).verticalScrollPolicy = ScrollPolicy.ON;
			}
			else
			{
				(event.target as Container).verticalScrollPolicy = ScrollPolicy.OFF;
			}
			if(event.target.width < event.target.measuredWidth)
			{
				(event.target as Container).horizontalScrollPolicy = ScrollPolicy.ON;
			}
			else
			{
				(event.target as Container).horizontalScrollPolicy = ScrollPolicy.OFF;
			}

		}

		public function ContainerResize()
		{
		}
	}
}
