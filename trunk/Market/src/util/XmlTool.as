//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package util
{
	import flash.utils.getDefinitionByName;
	import mx.collections.ArrayCollection;

	public class XmlTool
	{
		static public function getXmlWithNode(xmlRoot:XML, className:String, fieldAC:ArrayCollection):Object
		{
			var voClass:Class = getDefinitionByName(className) as Class;
			var vo:Object = new voClass();
			for each(var f:String in fieldAC)
			{
				vo[f] = xmlRoot.attribute(f);
			}
			if(xmlRoot.elements("child").length() > 0)
			{
				vo["children"] = new ArrayCollection();
				for each(var childItem:XML in xmlRoot.elements("child"))
				{
					(vo["children"] as ArrayCollection).addItem(getXmlWithNode(childItem, className,
						fieldAC));
				}
			}
			else
			{
				vo["children"] = null;
			}
			if(xmlRoot.elements("group").length() > 0)
			{
				vo["groups"] = new ArrayCollection();
				for each(var groupItem:XML in xmlRoot.elements("group"))
				{
					(vo["groups"] as ArrayCollection).addItem(getXmlWithNode(groupItem, className,
						fieldAC));
				}
			}
			else
			{
				vo["groups"] = null;
			}
			return vo;

		}

		public function XmlTool()
		{
		}
	}
}
