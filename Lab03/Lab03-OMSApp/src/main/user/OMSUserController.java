package main.user;

import javax.swing.JPanel;

import cart.CartController;
import media.page.user.UserBookPageController;

public class OMSUserController {
	private CartController cartController;
	
	public OMSUserController() {
		cartController = new CartController();
	}
	
	public JPanel getCartPane() {
		return cartController.getCartPane();
	}
	
	public JPanel getBookPage() {
		UserBookPageController controller = new UserBookPageController();
		controller.setCartController(cartController);
		return controller.getDataPagePane();
	}
}
