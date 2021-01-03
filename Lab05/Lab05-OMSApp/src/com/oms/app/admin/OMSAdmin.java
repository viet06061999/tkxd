package com.oms.app.admin;

import com.oms.factory.AdminPageFactory;

import java.awt.BorderLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin(OMSAdminController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		JTabbedPane tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, BorderLayout.CENTER);

		JPanel bookPage = AdminPageFactory.createPage("Book");
		tabbedPane.addTab("Books", null, bookPage, "Books");
		JPanel cdPage = AdminPageFactory.createPage("CD");
		tabbedPane.addTab("Compact Discs", null, cdPage, "Compact Discs");
		JPanel dvdPage = AdminPageFactory.createPage("DVD");
		tabbedPane.addTab("Digital Video Discs", null, dvdPage, "Digital Video Discs");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Online Media System for Administrator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OMSAdmin(new OMSAdminController());
			}
		});
	}
}