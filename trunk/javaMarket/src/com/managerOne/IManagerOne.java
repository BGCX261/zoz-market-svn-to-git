package com.managerOne;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.digo.beans.AccountBean;
import com.digo.beans.AddressBean;
import com.digo.beans.CommentBean;
import com.digo.beans.GoodsBean;
import com.digo.beans.OneKindsGoods;
import com.digo.beans.OrderListBean;
import com.digo.beans.RecordsBean;
import com.digo.pojo.Receiveaddress;

public interface IManagerOne {
	public void getName();
	
	public List<OneKindsGoods> getListKinds();
	
	public OneKindsGoods getOneKind(String kind, int pageNum, int pageSize);
	
	public OneKindsGoods searchGoods(String value, int pageNum, int pageSize);
	
	public GoodsBean getDetailGood(String id);
	
	public List<CommentBean> getGoodComments(String id, int pageNum, int pageSize);

	public Boolean validateName(String name);
	
	public Boolean saveAccount(AccountBean ab, String role);
	
	public AccountBean logIn(AccountBean ab);
	
	public AccountBean getBasicInfo(String id);
	
	public List<AddressBean> getAddrList(String id);
	
	public Boolean saveAddr(AddressBean addr);
	
	public Boolean delAddr(String addrId);
	
	public Boolean saveBasicInfo(AccountBean ab);
	
	public Boolean toOrder(String accountId, String addrId, Collection<GoodsBean> goods, String payType, RecordsBean record);
	
	public List<OrderListBean> getAllOrders(String accountId);
	
	public List<OrderListBean> getAllOrders();
	
	public Boolean payment(String orderId);
	
	public Boolean confirmReceipt(String orderId);
	
	public Boolean confirmDelivery(String orderId);
	
	public Boolean delOrder(String orderId);
	
	public CommentBean addComment(CommentBean cb);
	
	public Boolean uploadGood(byte[] content, GoodsBean good, String userName);
	
	public Boolean saveDate(RecordsBean rb);
}
