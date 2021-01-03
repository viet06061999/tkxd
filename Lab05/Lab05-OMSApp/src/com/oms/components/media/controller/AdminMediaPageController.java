package com.oms.components.media.controller;

import com.oms.bean.Media;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.media.book.gui.BookEditDialog;
import com.oms.components.media.gui.AdminMediaListPane;
import com.oms.serverapi.IMediaApi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
    public AdminMediaPageController(IMediaApi api) {
        super(api);
    }

    @Override
    public ADataListPane<Media> createListPane() {
        return new AdminMediaListPane(this) {
            @Override
            public void decorateSinglePane(ADataSinglePane<Media> singlePane) {
                JButton button = new JButton("Edit");
                singlePane.addDataHandlingComponent(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((AdminMediaPageController) controller).onEdit(singlePane);
                    }
                });
            }
        };
    }

    public abstract Media updateMedia(Media media);

    public void onEdit(ADataSinglePane<Media> singlePane) {
        IDataManageController<Media> manageController = new IDataManageController<Media>() {
            @Override
            public void onAct(Media media) {
                updateMedia(media);
                singlePane.updateData(media);
            }
        };
        new BookEditDialog(singlePane.getData(), manageController);
    }
}
