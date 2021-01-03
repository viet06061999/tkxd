package com.oms.app.user;

import javax.swing.JPanel;

import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.controller.UserBookPageController;

public class OMSUserController {
	private CartController cartController;
	
	public OMSUserController() {
		cartController = new CartController();
	}
	
	public JPanel getCartPane() {
		return cartController.getCartPane();
	}
}
