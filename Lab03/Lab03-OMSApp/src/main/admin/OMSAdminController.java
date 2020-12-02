package main.admin;

import media.page.admin.AdminBookPageController;

import javax.swing.*;

public class OMSAdminController {

	public JPanel getBookPage() {
		AdminBookPageController controller = new AdminBookPageController();
		return controller.getDataPagePane();
	}
}
