package cuit.tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import cuit.daos.WishlistDAO;
import cuit.pojos.Wishlist;

public class WishlistDAOTest {
	
	@Test
	public void TestgetWishlistByid() {
		int user_id = 1;
		List<Wishlist> wishLists = new ArrayList<Wishlist>();
		WishlistDAO wishlistdao = new WishlistDAO();
		wishLists = wishlistdao.getWishlistByid(user_id);
		for (Wishlist wishlist : wishLists) {
			System.out.println(wishlist.toString());
		}
		
	}

	/*
	@Test
	public void TestaddWishlist() {
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		Wishlist wishlist = new Wishlist();
		Movie movie = new Movie();
		movie.setId(3);
		User user = new User();
		user.setId(4);
		wishlist.setId(3);
		wishlist.setUser(user);
		wishlist.setMovie(movie);
		
		WishlistDAO wishlistdao = new WishlistDAO();
		wishlistdao.addWishlist(wishlist);
		System.out.println(wishlist.toString());
	}
	
	
	@Test
	public void TestdeleteWishlist() {
		int wishlistid = 2;
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		WishlistDAO wishlistdao = new WishlistDAO();
		wishlistdao.deletWishlist(wishlistid);
		System.out.println("已删除！");
	}
	*/
}
