package main.admin;

import admin.page.AdminBookPageController;
import cart.CartController;
import user.page.UserBookPageController;

import javax.swing.*;

public class OMSAdminController {

	public JPanel getBookPage() {
		AdminBookPageController controller = new AdminBookPageController();
		return controller.getDataPagePane();
	}
}
