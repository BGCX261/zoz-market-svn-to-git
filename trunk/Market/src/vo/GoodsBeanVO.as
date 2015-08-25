//------------------------------------------------------------------------------
//
//   Copyright 2012 
//   All rights reserved. 
//
//------------------------------------------------------------------------------
package vo
{

	[Bindable]
	[RemoteClass(alias="com.digo.beans.GoodsBean")]
	public class GoodsBeanVO
	{
//信用等级
		private var _creditLevel:Number;
//商品数量
		private var _goodsCount:Number;
//商品描述
		private var _goodsDes:String;
//商品ID
		private var _goodsId:String;
//商品图片
		private var _goodsImage:String;
//商品信息
		private var _goodsInfo:String;
//商品名称
		private var _goodsName:String;
//商品价格
		private var _goodsPrice:Number;
//商品类别
		private var _goodsType:String;
//商品单位
		private var _goodsUnit:String;
//上架时间
		private var _initTime:Date;
//供应商名称
		private var _merName:String;
//供应商ID
		private var _merId:String;
//促销类别
		private var _promotionKey:String;
//促销方式
		private var _promotionValue:String;
//备注
		private var _remark:String;
//评论数量
		private var _commentCount:int;
//综合评分
		private var _averageScore:Number;
//当前评论页数
		private var _currentPage:int;
		
		public function GoodsBeanVO()
		{
		}

		public function get creditLevel():Number
		{
			return _creditLevel;

		}

		public function set creditLevel(value:Number):void
		{
			_creditLevel = value;

		}

		public function get goodsCount():Number
		{
			return _goodsCount;

		}

		public function set goodsCount(value:Number):void
		{
			_goodsCount = value;

		}

		public function get goodsDes():String
		{
			return _goodsDes;

		}

		public function set goodsDes(value:String):void
		{
			_goodsDes = value;

		}

		public function get goodsId():String
		{
			return _goodsId;

		}

		public function set goodsId(value:String):void
		{
			_goodsId = value;

		}

		public function get goodsImage():String
		{
			return _goodsImage;

		}

		public function set goodsImage(value:String):void
		{
			_goodsImage = value;

		}

		public function get goodsInfo():String
		{
			return _goodsInfo;

		}

		public function set goodsInfo(value:String):void
		{
			_goodsInfo = value;

		}

		public function get goodsName():String
		{
			return _goodsName;

		}

		public function set goodsName(value:String):void
		{
			_goodsName = value;

		}

		public function get goodsPrice():Number
		{
			return _goodsPrice;

		}

		public function set goodsPrice(value:Number):void
		{
			_goodsPrice = value;

		}

		public function get goodsType():String
		{
			return _goodsType;

		}

		public function set goodsType(value:String):void
		{
			_goodsType = value;

		}

		public function get goodsUnit():String
		{
			return _goodsUnit;

		}

		public function set goodsUnit(value:String):void
		{
			_goodsUnit = value;

		}

		public function get initTime():Date
		{
			return _initTime;

		}

		public function set initTime(value:Date):void
		{
			_initTime = value;

		}

		public function get merName():String
		{
			return _merName;

		}

		public function set merName(value:String):void
		{
			_merName = value;

		}

		public function get promotionKey():String
		{
			return _promotionKey;

		}

		public function set promotionKey(value:String):void
		{
			_promotionKey = value;

		}

		public function get promotionValue():String
		{
			return _promotionValue;

		}

		public function set promotionValue(value:String):void
		{
			_promotionValue = value;

		}

		public function get remark():String
		{
			return _remark;

		}

		public function set remark(value:String):void
		{
			_remark = value;

		}

		public function get commentCount():int
		{
			return _commentCount;
		}

		public function set commentCount(value:int):void
		{
			_commentCount = value;
		}

		public function get averageScore():Number
		{
			return _averageScore;
		}

		public function set averageScore(value:Number):void
		{
			_averageScore = value;
		}

		public function get currentPage():int
		{
			return _currentPage;
		}

		public function set currentPage(value:int):void
		{
			_currentPage = value;
		}

		public function get merId():String
		{
			return _merId;
		}

		public function set merId(value:String):void
		{
			_merId = value;
		}


	}
}
