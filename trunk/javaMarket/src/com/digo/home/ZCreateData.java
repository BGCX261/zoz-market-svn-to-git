package com.digo.home;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.digo.pojo.Account;
import com.digo.pojo.Comment;
import com.digo.pojo.Goods;
import com.digo.pojo.Orderrelation;
import com.digo.pojo.Orders;
import com.digo.pojo.Power;
import com.digo.pojo.Receiveaddress;
import com.digo.pojo.Role;
import com.digo.pojo.Rolerelation;
import com.digo.pojo.User;
import com.util.CommonUtil;

public class ZCreateData {
	private UserHome userHome;
	private AccountHome accountHome;
	private ReceiveaddressHome raHome;
	private GoodsHome goodsHome;
	private OrdersHome ordersHome;
	private CommentHome commentHome;
	private OrderrelationHome orHome;
	private PowerHome powerHome;
	private RoleHome roleHome;
	private RolerelationHome rrHome;


	public void createUser() throws Exception{
		for(int i = 0 ; i < 10; i++){
			User user = new User();
			String itos = String.valueOf(i);
			user.setUserId(CommonUtil.md5("user" + itos));
			user.setUsername("userName" + itos);
			user.setUserpasswords(CommonUtil.md5(itos));
			user.setRoleId(CommonUtil.md5("role" + itos));
			user.setIdentityNumber("110228123456780000");
			user.setEmail("xxx@digo.com");
			user.setPhone("15810000000");
			user.setPoints(i + 100);
			user.setCreditLevel((short)i);
			user.setRealname("chen");
			userHome.persist(user);
		}
	}
	
	public void createAccount() throws Exception{
		
		for(int i = 0; i < 10; i++){
			Account account = new Account();
			String itos = String.valueOf(i);
			account.setAccountId(CommonUtil.md5("user" + itos));
			account.setAccountPasswords(CommonUtil.md5("account" + itos));
			account.setAccountStatus((char)i);
			account.setBalance(i);
			account.setRemark("");
			account.setUser(userHome.findById(CommonUtil.md5("user" + itos)));
			account.setInitTime(new Date());
			try {
				
				accountHome.persist(account);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createReceivAddress() {
		for(int i = 0; i < 100; i++){
			Receiveaddress ra = new Receiveaddress();
			String itos = String.valueOf(i);
			int r = new Random().nextInt(9);
			String rtos = String.valueOf(r);
			ra.setReceiveAddrId(CommonUtil.md5("ra" + itos));
			ra.setCity("Beijing");
			ra.setDeliveryType((char)r);
			ra.setEmail("xxx@digo.com");
			ra.setPayType('2');
			ra.setPhone("13800138000");
			ra.setReceiveName("name" + itos);
			ra.setStreet("StreetNo" + itos);
			ra.setUser(userHome.findById(CommonUtil.md5("user" + rtos)));
			ra.setZipCode("101500");
			raHome.persist(ra);
			try {
				
			} catch (Exception e) {
				raHome.persist(ra);
			}
			
		}
	}
	
	public void createGoods() throws Exception{
		String imageStr[] = {"2052958d-1388-41e6-b337-eb672d7592d0.jpg",
				"rBEHZ1BJSY8IAAAAAAE3zudE9vkAABEwwHSA4IAATfm774.jpg",
				"47728b61-5b6d-4321-98be-55fe200e888f.jpg",
				"rBEHZVC4csEIAAAAAAFpqVHm-98AADFiQDDkrgAAWnB245.jpg",
				"rBEGDFDAcscIAAAAAADqZ3ff-cgAAA2_gBaNekAAOp_872.jpg",
				"rBEIC0-_J5AIAAAAAAFXNd_SpUEAAAJ_wBRAXYAAVdN166.jpg",
				"rBEHZVBzltoIAAAAAAEnQsBllDEAABo-ADFP9kAASda345.jpg",
				"48bb38c2-e74b-4b5a-ac7d-8905f7a8d901.jpg",
				"rBEHaFCl2FUIAAAAAAHFWC5JCRoAAC1RgNAnZUAAcVw454.jpg",
				"rBEHZVA3HBMIAAAAAAGWT6nkdYIAAAH9wKzAj0AAZZn834.jpg"};
		for(int i = 0; i < 100; i++){
			Goods goods = new Goods();
			String itos = String.valueOf(i);
			int r = new Random().nextInt(9);
			String rtos = String.valueOf(r);
			goods.setGoodsId(CommonUtil.md5(UUID.randomUUID().toString()));
			goods.setGoodsCount(i*20);
			goods.setGoodsDes("测试商品-手机数码-简介");
			goods.setGoodsName("GoodsName手机数码" + itos);
			goods.setGoodsImage(imageStr[i%9]);
			goods.setGoodsInfo("goodsinfo");
			goods.setGoodsPrice(i*31.14F);
			goods.setGoodsType("0006000" + rtos);
			goods.setGoodsUnit("per");
			goods.setInitTime(new Date());
			goods.setPromotionKey('2');
			goods.setPromotionValue(itos);
			goods.setRemark("...");
			goods.setUser(userHome.findById(CommonUtil.md5("user" + rtos)));
			goodsHome.persist(goods);
		}
	}
	
	public void createOrder() throws Exception{
		for(int i = 0;i < 100; i++){
			Orders order = new Orders();
			String itos = String.valueOf(i);
			int r = new Random().nextInt(9);
			String rtos = String.valueOf(r);
			
			order.setOrderId(CommonUtil.md5("order" + itos));
			order.setOrderStatus('2');
			order.setOrderTime(new Date());
			order.setReceiveAddrId(CommonUtil.md5("ra" + itos));
			order.setUser(userHome.findById(CommonUtil.md5("user" + rtos)));
			ordersHome.persist(order);
		}
	}
	
	public void createComment() throws Exception{
		for(int i = 0; i < 100; i++){
			Comment comment = new Comment();
			String itos = String.valueOf(i);
			int r = new Random().nextInt(9);
			String rtos = String.valueOf(r);
			
			comment.setCommentId(CommonUtil.md5("com" + itos));
			comment.setCommentScore('5');
			comment.setCommentStatus('3');
			comment.setCommentTime(new Date());
			comment.setDisadvantage("bad");
			comment.setAdvantage("nice");
			comment.setCommentContent("hnnnemm just so so");
			comment.setGoods(goodsHome.findById(CommonUtil.md5("goods" + itos)));
			comment.setUser(userHome.findById(CommonUtil.md5("user" + rtos)));
			commentHome.persist(comment);
		}
	}
	
	public void createOrderrelation() throws Exception{
		for(int i = 0; i< 100 ; i++){
			Orderrelation or = new Orderrelation();
			Comment comment = new Comment();
			String itos = String.valueOf(i);
			int r = new Random().nextInt(9);
			String rtos = String.valueOf(r);
			
			or.setOrderRelationId(CommonUtil.md5("or" + itos));
			or.setOrders(ordersHome.findById(CommonUtil.md5("order" + itos)));
			or.setGoods(goodsHome.findById(CommonUtil.md5("goods" + itos)));
			or.setBuyCount(i*2);
			or.setSendAddrId(CommonUtil.md5("ra" + itos));
			or.setUnitPrice(20);
			orHome.persist(or);
		}
	}
	
	public void createPower() throws Exception{
		for(int i = 0; i < 10; i++){
			Power power = new Power();
			String itos = String.valueOf(i);
			
			power.setPowerId(CommonUtil.md5("power" + itos));
			power.setPowerDes("dexsxxxx");
			power.setPowerContent("content" + itos);
			power.setPowerType('2');
			powerHome.persist(power);
		}
	}
	
	public void createRole() throws Exception{
		for(int i = 0 ; i < 10; i++){
			Role role = new Role();
			String itos = String.valueOf(i);
			
			role.setRoleId(CommonUtil.md5("role" + itos));
			role.setRoleDes("xxxxx");
			role.setRoleName("god");
			role.setRoleStatus('1');
			roleHome.persist(role);
		}
	}
	
	public void createRolerelation() throws Exception{
		for(int i = 0; i<10; i++){
			Rolerelation rr = new Rolerelation();
			String itos = String.valueOf(i);
			
			rr.setRoleRelationId(CommonUtil.md5("rr" + itos));
			rr.setPower(powerHome.findById(CommonUtil.md5("power" + itos)));
			rr.setRole(roleHome.findById(CommonUtil.md5("role" + itos)));
			rrHome.persist(rr);
		}
	}
	
	public UserHome getUserHome() {
		return userHome;
	}

	public void setUserHome(UserHome userHome) {
		this.userHome = userHome;
	}

	public AccountHome getAccountHome() {
		return accountHome;
	}

	public void setAccountHome(AccountHome accountHome) {
		this.accountHome = accountHome;
	}

	public ReceiveaddressHome getRaHome() {
		return raHome;
	}

	public void setRaHome(ReceiveaddressHome raHome) {
		this.raHome = raHome;
	}
	public GoodsHome getGoodsHome() {
		return goodsHome;
	}

	public void setGoodsHome(GoodsHome goodsHome) {
		this.goodsHome = goodsHome;
	}

	public OrdersHome getOrdersHome() {
		return ordersHome;
	}

	public void setOrdersHome(OrdersHome ordersHome) {
		this.ordersHome = ordersHome;
	}

	public CommentHome getCommentHome() {
		return commentHome;
	}

	public void setCommentHome(CommentHome commentHome) {
		this.commentHome = commentHome;
	}

	public OrderrelationHome getOrHome() {
		return orHome;
	}

	public void setOrHome(OrderrelationHome orHome) {
		this.orHome = orHome;
	}

	public PowerHome getPowerHome() {
		return powerHome;
	}

	public void setPowerHome(PowerHome powerHome) {
		this.powerHome = powerHome;
	}

	public RoleHome getRoleHome() {
		return roleHome;
	}

	public void setRoleHome(RoleHome roleHome) {
		this.roleHome = roleHome;
	}

	public RolerelationHome getRrHome() {
		return rrHome;
	}

	public void setRrHome(RolerelationHome rrHome) {
		this.rrHome = rrHome;
	}
}
