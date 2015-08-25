package com;

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
import com.managerOne.IManagerOne;

public class Facade {
	IManagerOne iManagerOne;

	public IManagerOne getiManagerOne() {
		return iManagerOne;
	}

	public void setiManagerOne(IManagerOne iManagerOne) {
		this.iManagerOne = iManagerOne;
	}

	public void getManagerOneName(){
		iManagerOne.getName();
	}
	
	public List<OneKindsGoods> getListKinds(){
		return iManagerOne.getListKinds();
	}
	
	public OneKindsGoods getOneKind(String kind, int pageNum, int pageSize){
		return iManagerOne.getOneKind(kind, pageNum, pageSize);
	}
	
	public OneKindsGoods searchGoods(String value, int pageNum, int pageSize){
		return iManagerOne.searchGoods(value, pageNum, pageSize);
	}
	
	public GoodsBean getDetailGood(String id){
		return iManagerOne.getDetailGood(id);
	}
	
	public List<CommentBean> getGoodComments(String id, int pageNum, int pageSize){
		return iManagerOne.getGoodComments(id,pageNum,pageSize);
	}
	
	public Boolean validateName(String name){
		return iManagerOne.validateName(name);
	}
	
	//注册消费者/商家
	public Boolean saveAccount(AccountBean ab){
		return iManagerOne.saveAccount(ab, ab.getType());
	}
	
	public AccountBean logIn(AccountBean ab){
		return iManagerOne.logIn(ab);
	}
	
	public AccountBean getBasicInfo(String id){
		return iManagerOne.getBasicInfo(id);
	}
	
	public List<AddressBean> getAddrList(String id){
		return iManagerOne.getAddrList(id);
	}
	
	public Boolean saveAddr(AddressBean addr){
		return iManagerOne.saveAddr(addr);
	}
	
	public Boolean delAddr(String addrId){
		return iManagerOne.delAddr(addrId);
	}
	
	public Boolean saveBasicInfo(AccountBean ab){
		return iManagerOne.saveBasicInfo(ab);
	}
	
	public Boolean toOrder(String accountId, String addrId, Collection<GoodsBean> goods, String payType, RecordsBean record){
		return iManagerOne.toOrder(accountId,addrId,goods,payType,record);
	}
	
	public List<OrderListBean> getAllOrders(String accountId){
		return iManagerOne.getAllOrders(accountId);
	}
	
	public List<OrderListBean> getAllOrders(){
		return iManagerOne.getAllOrders();
	}
	
	public Boolean payment(String orderId){
		return iManagerOne.payment(orderId);
	}
	
	public Boolean confirmReceipt(String orderId){
		return iManagerOne.confirmReceipt(orderId);
	}
	
	public Boolean confirmDelivery(String orderId){
		return iManagerOne.confirmDelivery(orderId);
	}
	
	public Boolean delOrder(String orderId){
		return iManagerOne.delOrder(orderId);
	}
	
	public CommentBean addComment(CommentBean cb){
		return iManagerOne.addComment(cb);
	}
	
	public Boolean uploadGood(byte[] content, GoodsBean good, String userName){
		return iManagerOne.uploadGood(content, good, userName);
	}
	
	public Boolean saveDate(RecordsBean rb){
		return iManagerOne.saveDate(rb);
	}
}
