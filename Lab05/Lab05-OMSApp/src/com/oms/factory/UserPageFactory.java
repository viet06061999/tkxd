package com.oms.factory;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.media.book.controller.UserBookPageController;
import com.oms.components.media.cd.controller.UserCDPageController;
import com.oms.serverapi.MediaApi;

import javax.swing.*;

public class UserPageFactory {
    private volatile static JPanel bookPage;
    private volatile static JPanel cdPage;
    private volatile static JPanel dvdPage;

    public static JPanel createPage(String type) {
        switch (type) {
            case "Book": {
                if (bookPage == null)
                    synchronized (UserPageFactory.class) {
                        if (bookPage == null) {
                            ADataPageController<Media> controller = new UserBookPageController();
                            bookPage = controller.getDataPagePane();
                        }
                    }
                return bookPage;
            }
            case "CD":
                if (cdPage == null)
                    synchronized (UserPageFactory.class) {
                        if (cdPage == null) {
                            System.out.println("tao cd o day");
                            ADataPageController<Media> controller = new UserCDPageController();
                            cdPage = controller.getDataPagePane();
                        }
                    }
                return cdPage;
            case "DVD":
                if (dvdPage == null)
                    synchronized (UserPageFactory.class) {
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
