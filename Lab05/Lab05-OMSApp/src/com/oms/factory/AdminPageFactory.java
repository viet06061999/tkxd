package com.oms.factory;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.media.book.controller.AdminBookPageController;
import com.oms.components.media.cd.controller.AdminCDPageController;
import com.oms.serverapi.MediaApi;

import javax.swing.*;
import javax.ws.rs.client.ClientBuilder;

public class AdminPageFactory {
    private volatile static JPanel bookPage;
    private volatile static JPanel cdPage;
    private volatile static JPanel dvdPage;

    public static JPanel createPage(String type) {
        switch (type) {
            case "Book": {
                if (bookPage == null)
                    synchronized (AdminPageFactory.class) {
                        if (bookPage == null) {
                            ADataPageController<Media> controller = new AdminBookPageController(MediaApi.getInstance());
                            bookPage = controller.getDataPagePane();
                        }
                    }
                return bookPage;
            }
            case "CD":
                if (cdPage == null)
                    synchronized (AdminPageFactory.class) {
                        if (cdPage == null) {
                            ADataPageController<Media> controller = new AdminCDPageController(MediaApi.getInstance());
                            cdPage = controller.getDataPagePane();
                        }
                    }
                return cdPage;
            case "DVD":
                if (dvdPage == null)
                    synchronized (AdminPageFactory.class) {
                        if (dvdPage == null) {
                            dvdPage = new JPanel();
                        }
                    }
                return dvdPage;
            default:
                return null;
        }
    }
}
