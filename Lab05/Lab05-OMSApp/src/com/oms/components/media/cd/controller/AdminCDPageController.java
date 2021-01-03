package com.oms.components.media.cd.controller;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;
import com.oms.bean.Media;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSinglePane;
import com.oms.components.media.cd.gui.CDSearchPane;
import com.oms.components.media.cd.gui.CDSinglePane;
import com.oms.components.media.controller.AdminMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;
import com.oms.serverapi.IMediaApi;

import java.util.List;
import java.util.Map;

public class AdminCDPageController extends AdminMediaPageController {
    public AdminCDPageController(IMediaApi api) {
        super(api);
    }

    @Override
    public List<? extends Media> search(Map<String, String> searchParams) {
        return api.getCds(searchParams);
    }

    @Override
    public MediaSinglePane createSinglePane() {
        return new CDSinglePane();
    }

    @Override
    public MediaSearchPane createSearchPane() {
        return new CDSearchPane();
    }

    @Override
    public Media updateMedia(Media media) {
        return api.updateCD((CompactDisc) media);
    }
}
