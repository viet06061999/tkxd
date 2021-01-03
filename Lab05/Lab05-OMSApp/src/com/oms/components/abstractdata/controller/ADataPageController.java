package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataPagePane;
import com.oms.components.abstractdata.gui.ADataSearchPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.serverapi.IMediaApi;

public abstract class ADataPageController<T> {
    private ADataPagePane<T> pagePane;
    protected IMediaApi api;

    public ADataPageController(IMediaApi api) {
        this.api = api;
        ADataSearchPane searchPane = createSearchPane();

        ADataListPane<T> listPane = createListPane();

        searchPane.setController(new IDataSearchController() {
            @Override
            public void search(Map<String, String> searchParams) {
                System.out.println("search o dau");
                List<? extends T> list = ADataPageController.this.search(searchParams);
                listPane.updateData(list);
            }
        });

        searchPane.fireSearchEvent();

        pagePane = new ADataPagePane<T>(searchPane, listPane);
    }

    public JPanel getDataPagePane() {
        return pagePane;
    }


    public abstract ADataSearchPane createSearchPane();

    public abstract List<? extends T> search(Map<String, String> searchParams);

    public abstract ADataSinglePane<T> createSinglePane();

    public abstract ADataListPane<T> createListPane();
}
