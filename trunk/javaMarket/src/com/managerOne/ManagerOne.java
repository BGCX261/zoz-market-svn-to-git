package com.managerOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.digo.beans.AccountBean;
import com.digo.beans.AddressBean;
import com.digo.beans.CommentBean;
import com.digo.beans.GoodsBean;
import com.digo.beans.OneKindsGoods;
import com.digo.beans.OrderListBean;
import com.digo.beans.RecordsBean;
import com.digo.home.AccountHome;
import com.digo.home.CommentHome;
import com.digo.home.GoodsHome;
import com.digo.home.OrderrelationHome;
import com.digo.home.OrdersHome;
import com.digo.home.ReceiveaddressHome;
import com.digo.home.RecordsHome;
import com.digo.home.RoleHome;
import com.digo.home.UserHome;
import com.digo.home.ZCreateData;
import com.digo.pojo.Account;
import com.digo.pojo.Comment;
import com.digo.pojo.Goods;
import com.digo.pojo.Orderrelation;
import com.digo.pojo.Orders;
import com.digo.pojo.Receiveaddress;
import com.digo.pojo.Records;
import com.digo.pojo.User;
import com.util.CommonUtil;
import com.util.Constant;
public class ManagerOne implements IManagerOne {
	private static String name = "manager1";
	private RoleHome roleHome;
	private AccountHome accountHome;
	private CommentHome commentHome;
	private GoodsHome goodsHome;
	private UserHome userHome;
	private ReceiveaddressHome receiveaddressHome;
	private OrdersHome ordersHome;
	private OrderrelationHome orderrelationHome;
	private RecordsHome recordsHome;
	
	public RecordsHome getRecordsHome() {
		return recordsHome;
	}

	public void setRecordsHome(RecordsHome recordsHome) {
		this.recordsHome = recordsHome;
	}

	public OrderrelationHome getOrderrelationHome() {
		return orderrelationHome;
	}
	
	public void setOrderrelationHome(OrderrelationHome orderrelationHome) {
		this.orderrelationHome = orderrelationHome;
	}
	
	public OrdersHome getOrdersHome() {
		return ordersHome;
	}
	
	public void setOrdersHome(OrdersHome ordersHome) {
		this.ordersHome = ordersHome;
	}
	
	public UserHome getUserHome() {
		return userHome;
	}
	
	public void setUserHome(UserHome userHome) {
		this.userHome = userHome;
	}
	
	public void setReceiveaddressHome(ReceiveaddressHome receiveaddressHome) {
		this.receiveaddressHome = receiveaddressHome;
	}
	
	public ReceiveaddressHome getReceiveaddressHome() {
		return receiveaddressHome;
	}
	
	public GoodsHome getGoodsHome() {
		return goodsHome;
	}
	
	public void setGoodsHome(GoodsHome goodsHome) {
		this.goodsHome = goodsHome;
	}
	
	public CommentHome getCommentHome() {
		return commentHome;
	}
	
	public void setCommentHome(CommentHome commentHome) {
		this.commentHome = commentHome;
	}

	private ZCreateData zCreateData;
	public ZCreateData getzCreateData() {
		return zCreateData;
	}

	public void setzCreateData(ZCreateData zCreateData) {
		this.zCreateData = zCreateData;
	}

	public AccountHome getAccountHome() {
		return accountHome;
	}

	public void setAccountHome(AccountHome accountHome) {
		this.accountHome = accountHome;
	}

	public static void setName(String name) {
		ManagerOne.name = name;
	}

	public RoleHome getRoleHome() {
		return roleHome;
	}

	public void setRoleHome(RoleHome roleHome) {
		this.roleHome = roleHome;
	}

	Logger logger = LoggerFactory.getLogger(ManagerOne.class);

	public void getName(){
		
		try {
//			zCreateData.createUser();
//			zCreateData.createAccount();
//			zCreateData.createReceivAddress();
//			zCreateData.createGoods();
//			zCreateData.createOrder();
//			zCreateData.createOrderrelation();
//			zCreateData.createPower();
//			zCreateData.createRole();
//			zCreateData.createRolerelation();
//			zCreateData.createComment();
			List<Goods> lg = goodsHome.refreshgoods();
			Iterator<Goods> tg = lg.iterator();
			int i = 0;
			while(tg.hasNext()){
				Goods g = tg.next();
				g.setGoodsName(g.getGoodsName()+i++);
				goodsHome.attachDirty(g);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<OneKindsGoods> getListKinds(){
		String a[] = {"0001","0002","0003","0004","0005","0006"};
		List<OneKindsGoods> rg = new ArrayList<OneKindsGoods>();
		for (String item : a){
			List<Goods> gNum = goodsHome.findByBigKindAndPage(item, 5, 1);
			OneKindsGoods newKindsGoods = new OneKindsGoods();
			Iterator<Goods> it = gNum.iterator();
			newKindsGoods.setKindNum(item);
			newKindsGoods.setKind(Constant.BigkindsMap.get(item));
			while(it.hasNext()){
				Goods g = it.next();
				GoodsBean gb = new GoodsBean();
				gb.setGoodsId(g.getGoodsId());
				gb.setGoodsName(g.getGoodsName());
				gb.setGoodsDes(g.getGoodsDes());
				gb.setGoodsPrice(g.getGoodsPrice());
				gb.setGoodsImage(g.getGoodsImage());
				gb.setCommentCount(commentHome.getCountByGoodsId(g.getGoodsId()));
				newKindsGoods.getList().add(gb);
			}
			rg.add(newKindsGoods);
		}
		
		return rg;
	}

	public OneKindsGoods getOneKind(String kind, int pageNum, int pageSize){
		List<Goods> gNum = goodsHome.findByBigKindAndPage(kind, pageSize, pageNum);
		OneKindsGoods newKindsGoods = new OneKindsGoods();
		Iterator<Goods> it = gNum.iterator();
		newKindsGoods.setKindNum(kind);
		newKindsGoods.setKind(Constant.BigkindsMap.get(kind));
		while(it.hasNext()){
			Goods g = it.next();
			GoodsBean gb = new GoodsBean();
			gb.setGoodsId(g.getGoodsId());
			gb.setGoodsName(g.getGoodsName());
			gb.setGoodsDes(g.getGoodsDes());
			gb.setGoodsPrice(g.getGoodsPrice());
			gb.setGoodsImage(g.getGoodsImage());
			gb.setCommentCount(commentHome.getCountByGoodsId(g.getGoodsId()));
			newKindsGoods.getList().add(gb);
		}
		return newKindsGoods;
	}

	public OneKindsGoods searchGoods(String value, int pageNum, int pageSize){
		List<Goods> gNum = goodsHome.findByKeyWords(value, pageSize, pageNum);
		OneKindsGoods newKindsGoods = new OneKindsGoods();
		Iterator<Goods> it = gNum.iterator();
		newKindsGoods.setKind(value);
		while(it.hasNext()){
			Goods g = it.next();
			GoodsBean gb = new GoodsBean();
			gb.setGoodsId(g.getGoodsId());
			gb.setGoodsName(g.getGoodsName());
			gb.setGoodsPrice(g.getGoodsPrice());
			gb.setGoodsCount(g.getGoodsCount());
			gb.setGoodsUnit(g.getGoodsUnit());
			gb.setMerName(g.getUser().getUsername());
			gb.setGoodsDes(g.getGoodsDes());
			gb.setGoodsImage(g.getGoodsImage());
			gb.setCommentCount(commentHome.getCountByGoodsId(g.getGoodsId()));
			newKindsGoods.getList().add(gb);
		}
		return newKindsGoods;
	}

	public GoodsBean getDetailGood(String id){
		Goods g = goodsHome.findById(id);
		GoodsBean gb = new GoodsBean();
		gb.setGoodsId(g.getGoodsId());
		gb.setGoodsType(g.getGoodsType());
		gb.setGoodsName(g.getGoodsName());
		gb.setGoodsPrice(g.getGoodsPrice());
		gb.setGoodsCount(g.getGoodsCount());
		gb.setGoodsUnit(g.getGoodsUnit());
		gb.setMerName(g.getUser().getUsername());
		gb.setMerId(g.getUser().getUserId());
		gb.setGoodsDes(g.getGoodsDes());
		gb.setGoodsInfo(g.getGoodsInfo());
		gb.setGoodsImage(g.getGoodsImage());
		gb.setInitTime(g.getInitTime());
		gb.setPromotionValue(g.getPromotionValue());
		gb.setPromotionKey(g.getPromotionKey() + "");
		gb.setRemark(g.getRemark());
		return gb;
	}
	
	public List<CommentBean> getGoodComments(String id, int pageNum, int pageSize){
		List<Comment> gNum = commentHome.findByGoodsId(id, pageNum, pageSize);
		List<CommentBean> newCommentBean = new ArrayList<CommentBean>();
		Iterator<Comment> it = gNum.iterator();
		while(it.hasNext()){
			Comment g = it.next();
			CommentBean gb = new CommentBean();
			gb.setUserName(g.getUser().getUsername());
			gb.setAdvantage(g.getAdvantage());
			gb.setCommentTime(g.getCommentTime());
			gb.setContent(g.getCommentContent());
			gb.setDisadvantage(g.getDisadvantage());
			gb.setScore(g.getCommentScore()+"");
			
			newCommentBean.add(gb);
		}
		return newCommentBean;
	}
	
	public Boolean validateName(String name){
		User u = userHome.findByProperty("username", name);
		if(u==null){
			return false;
		}else{
			return true;
		}
	}
	
	public Boolean saveAccount(AccountBean ab, String role){
		User u = new User();
		u.setUsername(ab.getAccount());
		u.setUserpasswords(ab.getPassword());
		u.setUserId(CommonUtil.md5(UUID.randomUUID().toString()));
		u.setCreditLevel((short) 0);
		u.setEmail("");
		u.setIdentityNumber("");
		u.setPhone("");
		u.setPoints(0);
		u.setRealname("");
		u.setRoleId(role);
		Boolean result = userHome.persist(u);
		Account ac = new Account();
		ac.setAccountPasswords(u.getUserpasswords());
		ac.setBalance(10000);
		ac.setInitTime(new Date());
		ac.setUser(u);
		ac.setAccountStatus('0');
		ac.setRemark("");
		ac.setAccountStatus('0');
		accountHome.persist(ac);
		return result;
	}
	
	public AccountBean logIn(AccountBean ab){
		User u = userHome.findByProperty("username", ab.getAccount());

		if(u != null && u.getUserpasswords().equals(ab.getPassword()))
		{
			AccountBean result = new AccountBean();
			result.setAccount(u.getUsername());
			result.setPower(userHome.findPowerByRoleId(u.getRoleId()));
			result.setCash(u.getAccount().getBalance());
			result.setPassword(u.getUserpasswords());
			result.setType(u.getRoleId());
			return result;
		}
		else if(u == null)
		{
			return null;
		}
		else
		{
			return new AccountBean();
		}
	}
	
	public AccountBean getBasicInfo(String id){
		User u = userHome.findByProperty("username", id);
		AccountBean result = new AccountBean();
		result.setRealName(u.getRealname());
		result.setEmail(u.getEmail());
		result.setIdentityNumber(u.getIdentityNumber());
		result.setPhone(u.getPhone());
		return result;
	}
	
	public List<AddressBean> getAddrList(String id){
		List<Receiveaddress> lra =  receiveaddressHome.findListByProperty("user.username", id);
		List<AddressBean> result = new ArrayList<AddressBean>();
		if(lra != null)
		{
			Iterator<Receiveaddress> it = lra.iterator();
			while(it.hasNext())
			{
				Receiveaddress ra = it.next();
				if("0".equals(""+ra.getDeliveryType())){
					AddressBean ab = new AddressBean();
					ab.setCity(ra.getCity());
					ab.setDeliveryType(ra.getDeliveryType());
					ab.setEmail(ra.getEmail());
					ab.setPhone(ra.getPhone());
					ab.setReceiveAddrId(ra.getReceiveAddrId());
					ab.setReceiveName(ra.getReceiveName());
					ab.setStreet(ra.getStreet());
					ab.setZipCode(ra.getZipCode());
					ab.setUsername(ra.getUser().getUsername());
					result.add(ab);
				}
			}
		}
		return result;
	}
	
	public Boolean saveAddr(AddressBean addr){
		Receiveaddress ra = new Receiveaddress();
		
		ra.setCity(addr.getCity());
		ra.setDeliveryType(addr.getDeliveryType());
		ra.setEmail(addr.getEmail());
		ra.setPayType(addr.getPayType());
		ra.setPhone(addr.getPhone());
		ra.setReceiveName(addr.getReceiveName());
		ra.setStreet(addr.getStreet());
		ra.setUser(userHome.findByProperty("username", addr.getUsername()));
		ra.setZipCode(addr.getZipCode());
		if(addr.getReceiveAddrId() == null){
			ra.setReceiveAddrId(CommonUtil.md5(UUID.randomUUID().toString()));
			return receiveaddressHome.persist(ra);
		}else{
			ra.setReceiveAddrId(addr.getReceiveAddrId());
			return receiveaddressHome.attachDirty(ra);
		}
	}
	
	public Boolean delAddr(String addrId){
		Receiveaddress ra =  receiveaddressHome.findById(addrId);
		return receiveaddressHome.delete(ra);
	}
	
	public Boolean saveBasicInfo(AccountBean ab){
		User u = userHome.findByProperty("username", ab.getAccount());
		u.setEmail(ab.getEmail());
		u.setIdentityNumber(ab.getIdentityNumber());
		u.setPhone(ab.getPhone());
		u.setRealname(ab.getRealName());
		return userHome.attachDirty(u);
	}
	
	public Boolean toOrder(String accountId, String addrId, Collection<GoodsBean> goods, String payType, RecordsBean record){
		String orderId = CommonUtil.md5(UUID.randomUUID().toString());
		Date orderTime = new Date();
		Orders od = new Orders();
		Boolean result;
		
		Receiveaddress ra = receiveaddressHome.findById(addrId);
		Receiveaddress za = new Receiveaddress();
		za.setCity(ra.getCity());
		za.setDeliveryType('1');
		za.setEmail(ra.getEmail());
		if(payType.equals("0")){
			za.setPayType('0');
			od.setOrderStatus('1');
		}else if(payType.equals("1")){
			za.setPayType('1');
			od.setOrderStatus('0');
		}
		za.setPhone(ra.getPhone());
		za.setReceiveAddrId(CommonUtil.md5(UUID.randomUUID().toString()));
		za.setReceiveName(ra.getReceiveName());
		za.setStreet(ra.getStreet());
		za.setUser(ra.getUser());
		za.setZipCode(ra.getZipCode());
		receiveaddressHome.persist(za);
		
		od.setReceiveAddrId(za.getReceiveAddrId());
		od.setOrderId(orderId);
		
		od.setOrderTime(orderTime);
		User theU = userHome.findByProperty("username", accountId);
		od.setUser(theU);
		result = ordersHome.persist(od);
		if(result == false){
			return false;
		}
		
		Records rc = new Records();
		rc.setAccount(accountHome.findById(theU.getUserId()));
		rc.setOrderId(orderId);
		rc.setRecordsId(CommonUtil.md5(UUID.randomUUID().toString()));
		rc.setRecordsNumber(record.getRecordsNumber());
		rc.setRecordsTime(new Date());
		rc.setRecordsType(record.getRecordsType().charAt(0));
		rc.setRemark(record.getRemark());
		result = recordsHome.persist(rc);
		if(result == false){
			return false;
		}
		
		Iterator<GoodsBean> it = goods.iterator();
		while(it.hasNext())
		{
			GoodsBean gb = it.next();
			Orderrelation ol = new Orderrelation();
			ol.setBuyCount(gb.getGoodsCount());
			ol.setGoods(goodsHome.findById(gb.getGoodsId()));
			ol.setOrderRelationId(CommonUtil.md5(UUID.randomUUID().toString()));
			ol.setSendAddrId("");
			ol.setUnitPrice(gb.getGoodsPrice());
			ol.setOrders(od);
			result = orderrelationHome.persist(ol);
			if(result == false){
				return false;
			}
		}
		return true;
	}
	
	public List<OrderListBean> getAllOrders(String accountId){
		List<OrderListBean> ordersMap = new ArrayList<OrderListBean>();
		List<Orders> orders = ordersHome.findByProperty("user.username", accountId);
		Iterator<Orders> ordersIt = orders.iterator();
		while(ordersIt.hasNext())
		{
			Orders or = ordersIt.next();
			OrderListBean orMap = new OrderListBean();
			orMap.setOrderId(or.getOrderId());
			Receiveaddress ra = receiveaddressHome.findById(or.getReceiveAddrId());
			orMap.setReceiveName(ra.getReceiveName()+" "+ra.getCity()+" "+ra.getStreet()+" "+ra.getPhone());
			orMap.setOrderTime(DateFormat.getInstance().format(or.getOrderTime()));
			orMap.setOrderStatus(or.getOrderStatus()+"");
			List<Orderrelation> orList =  orderrelationHome.findByProperty("orders.orderId", or.getOrderId());
			List<GoodsBean> gbList = new ArrayList<GoodsBean>();
			Float orderPrice = Float.valueOf("0");
			Iterator<Orderrelation> orIt = orList.iterator();
			while(orIt.hasNext())
			{
				Orderrelation orr = orIt.next();
				GoodsBean gb = new GoodsBean();
				gb.setGoodsImage(orr.getGoods().getGoodsImage());
				gb.setGoodsName(orr.getGoods().getGoodsName());
				gb.setGoodsPrice(orr.getUnitPrice());
				gb.setGoodsCount(orr.getBuyCount());
				orderPrice += orr.getUnitPrice() * orr.getBuyCount();
				gbList.add(gb);
			}
			orMap.setTotal(orderPrice.toString());
			orMap.setGoodsList(gbList);
			Records rc = recordsHome.findByProperty("orderId", orMap.getOrderId());
			RecordsBean rb = new RecordsBean();
			if(rc!=null){
				rb.setOrderId(rc.getOrderId());
				rb.setRecordsId(rc.getRecordsId());
				rb.setRecordsNumber(rc.getRecordsNumber());
				rb.setRecordsTime(rc.getRecordsTime());
				rb.setRecordsType(rc.getRecordsType()+"");
				rb.setRemark(rc.getRemark());
			}
			orMap.setRecord(rb);
			
			ordersMap.add(orMap);
		}
		return ordersMap;
	}
	
	public List<OrderListBean> getAllOrders(){
		List<OrderListBean> ordersMap = new ArrayList<OrderListBean>();
		List<Orders> orders = ordersHome.findAll();
		Iterator<Orders> ordersIt = orders.iterator();
		while(ordersIt.hasNext())
		{
			Orders or = ordersIt.next();
			OrderListBean orMap = new OrderListBean();
			orMap.setOrderId(or.getOrderId());
			Receiveaddress ra = receiveaddressHome.findById(or.getReceiveAddrId());
			orMap.setReceiveName(ra.getReceiveName()+" "+ra.getCity()+" "+ra.getStreet()+" "+ra.getPhone());
			orMap.setOrderTime(DateFormat.getInstance().format(or.getOrderTime()));
			orMap.setOrderStatus(or.getOrderStatus()+"");
			List<Orderrelation> orList =  orderrelationHome.findByProperty("orders.orderId", or.getOrderId());
			List<GoodsBean> gbList = new ArrayList<GoodsBean>();
			Float orderPrice = Float.valueOf("0");
			Iterator<Orderrelation> orIt = orList.iterator();
			while(orIt.hasNext())
			{
				Orderrelation orr = orIt.next();
				GoodsBean gb = new GoodsBean();
				gb.setGoodsImage(orr.getGoods().getGoodsImage());
				gb.setGoodsName(orr.getGoods().getGoodsName());
				gb.setGoodsPrice(orr.getUnitPrice());
				gb.setGoodsCount(orr.getBuyCount());
				orderPrice += orr.getUnitPrice() * orr.getBuyCount();
				gbList.add(gb);
			}
			orMap.setTotal(orderPrice.toString());
			orMap.setGoodsList(gbList);
			
			Records rc = recordsHome.findByProperty("orderId", orMap.getOrderId());
			RecordsBean rb = new RecordsBean();
			if(rc!=null){
				rb.setOrderId(rc.getOrderId());
				rb.setRecordsId(rc.getRecordsId());
				rb.setRecordsNumber(rc.getRecordsNumber());
				rb.setRecordsTime(rc.getRecordsTime());
				rb.setRecordsType(rc.getRecordsType()+"");
				rb.setRemark(rc.getRemark());
			}
			orMap.setRecord(rb);
			
			ordersMap.add(orMap);
		}
		return ordersMap;
	}
	
	public Boolean saveDate(RecordsBean rb){
		Records rc = recordsHome.findByProperty("orderId", rb.getOrderId());
		rc.setRemark("1");
		rc.setRecordsTime(rb.getRecordsTime());
		return recordsHome.attachDirty(rc);
	}
	
	public Boolean payment(String orderId){
		Orders od = ordersHome.findById(orderId);
		List<Orderrelation> orList =  orderrelationHome.findByProperty("orders.orderId", od.getOrderId());
		Float orderPrice = Float.valueOf("0");
		Iterator<Orderrelation> orIt = orList.iterator();
		while(orIt.hasNext())
		{
			Orderrelation orr = orIt.next();
			orderPrice += orr.getUnitPrice() * orr.getBuyCount();
		}
		int nb = od.getUser().getAccount().getBalance();
		if(nb>orderPrice){
			od.setOrderStatus('1');
			ordersHome.attachDirty(od);
			Account ac = od.getUser().getAccount();
			ac.setBalance(nb-orderPrice.intValue());
			accountHome.attachDirty(ac);
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean confirmReceipt(String orderId){
		Orders od = ordersHome.findById(orderId);
		if(od == null){
			return false;
		}
		od.setOrderStatus('3');
		ordersHome.attachDirty(od);
		return true;
	}
	
	public Boolean confirmDelivery(String orderId){
		Orders od = ordersHome.findById(orderId);
		if(od == null){
			return false;
		}
		od.setOrderStatus('2');
		ordersHome.attachDirty(od);
		return true;
	}
	
	public Boolean delOrder(String orderId){
		Orders od = ordersHome.findById(orderId);
		List<Orderrelation> orList =  orderrelationHome.findByProperty("orders.orderId", od.getOrderId());
		Iterator<Orderrelation> orIt = orList.iterator();
		while(orIt.hasNext())
		{
			Orderrelation orr = orIt.next();
			orderrelationHome.delete(orr);
		}
		return ordersHome.delete(od);
	}
	
	public CommentBean addComment(CommentBean cb){
		Comment com = new Comment();
		com.setAdvantage(cb.getAdvantage());
		com.setCommentContent(cb.getContent());
		com.setCommentScore('5');
		com.setCommentStatus('3');
		com.setCommentTime(new Date());
		com.setDisadvantage(cb.getDisadvantage());
		com.setCommentId(CommonUtil.md5(UUID.randomUUID().toString()));
		com.setGoods(goodsHome.findById(cb.goodsId));
		com.setUser(userHome.findByProperty("username", cb.getUserName()));
		commentHome.persist(com);
		return cb;
	}
	
	public Boolean uploadGood(byte[] content, GoodsBean good, String userName){
		Boolean result = false;
		String dir1 = ManagerOne.class.getResource("/").getPath().substring(1, ManagerOne.class.getResource("/").getPath().indexOf("WEB-INF"))+"assets/image/";
		String dir2 = ManagerOne.class.getResource("/").getPath().substring(1, ManagerOne.class.getResource("/").getPath().indexOf(".metadata"))+"javaMarket/javaMarket/assets/image/";
		String dir3 = ManagerOne.class.getResource("/").getPath().substring(1, ManagerOne.class.getResource("/").getPath().indexOf(".metadata"))+"Market/src/assets/image/";
		String fileName = CommonUtil.md5(UUID.randomUUID().toString())+".jpg";
		Goods g = new Goods();
		g.setGoodsCount(good.getGoodsCount());
		g.setGoodsDes(good.getGoodsDes());
		g.setGoodsId(CommonUtil.md5(UUID.randomUUID().toString()));
		g.setGoodsImage(fileName);
		g.setGoodsInfo(good.getGoodsInfo());
		g.setGoodsName(good.getGoodsName());
		g.setGoodsPrice(good.getGoodsPrice());
		g.setGoodsType(good.getGoodsType());
		g.setGoodsUnit("per");
		g.setInitTime(new Date());
		g.setPromotionKey('2');
		g.setPromotionValue("10");
		g.setRemark("...");
		g.setUser(userHome.findByProperty("username", userName));
		
		good.setGoodsImage(fileName);
		
		FileOutputStream stream;
		
		File file1 = new File(dir1+fileName);
		File file2 = new File(dir2+fileName);
		File file3 = new File(dir3+fileName);
		try {
			if(file1.createNewFile()){
				stream = new FileOutputStream(file1);
				if(content != null){
					stream.write(content);
					stream.close();
				}
			}
			if(file2.createNewFile()){
				stream = new FileOutputStream(file2);
				if(content != null){
					stream.write(content);
					stream.close();
				}
			}
			if(file3.createNewFile()){
				stream = new FileOutputStream(file3);
				if(content != null){
					stream.write(content);
					stream.close();
				}
			}
			result = goodsHome.persist(g);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
