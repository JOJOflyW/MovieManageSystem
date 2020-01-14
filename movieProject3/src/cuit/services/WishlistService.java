package cuit.services;

import java.util.List;

import cuit.pojos.Wishlist;
import cuit.daos.WishlistDAO;

public class WishlistService {
	private WishlistDAO wishlistDAO = new  WishlistDAO();
	
	public List<Wishlist> getWishlistByid(int user_id) {
		return wishlistDAO.getWishlistByid(user_id);
	}
	
	public void addWishlist(Wishlist wishlist) {
		wishlistDAO.addWishlist(wishlist);
	}
	
	public void deletWishlist(int wishlistid) {
		wishlistDAO.deletWishlist(wishlistid);
	}
}
