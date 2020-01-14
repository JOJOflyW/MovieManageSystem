package cuit.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import cuit.daos.OrderDAO;
import cuit.pojos.Order;


public class OrderDAOTest {
	/*
	@Test
	public void TestfindAllOrder() {
		List<Order> orders = new ArrayList<Order>();
		OrderDAO orderDAO = new OrderDAO();
		orders = orderDAO.findAllOrder();
		for (Order order : orders) {
			System.out.println(order.toString());
		}
	}
    */
	@Test
	public void TestgetOrderByUserNo() {
		List<Order> orders = new ArrayList<Order>();
		OrderDAO orderDAO = new OrderDAO();
		orders = orderDAO.getOrderByUserNo(1);
		orders  = orderDAO.findAllOrder();
		for (Order order : orders) {
			System.out.println(order.toString());
		}
	}
	
	/*
	@Test
	public void TestaddOrder() {
		List<Order> orders = new ArrayList<Order>();
		//Order order = new Order(1,3,2,"2-2",30,"2019-12-25 17:00:30");
		Order order = new Order();
		order.setId(2);
		order.setMovieid(2);
		order.setUserid(1);
		order.setSeat("3-5");
		order.setAmount(30);
		order.setDate("2019-12-25 17:22:45");
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.addOrder(order);
		orders  = orderDAO.findAllOrder();
		for (Order orderr : orders) {
			System.out.println(orderr.toString());
		}
	}
	*/
	/*
    @Test
	public void TestdeleteOrder() {
		int orderid = 1;
		List<Order> orders = new ArrayList<Order>();
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.deleteOrder(orderid);
		orders = orderDAO.findAllOrder();
		for (Order order : orders) {
			System.out.println(order.toString());
		}
	}
	*/
}
