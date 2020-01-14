package cuit.services;

import java.util.List;
import cuit.daos.OrderDAO;
import cuit.pojos.Order;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();
	
	public List<Order> findAllOrder() {
		return orderDAO.findAllOrder() ;
	}
	
	public List<Order> getOrderByUserNo(int userid){
		return orderDAO.getOrderByUserNo(userid);
	}
	
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}
	
	public void deleteOrder(int orderid) {
		orderDAO.deleteOrder(orderid);
	}
}
