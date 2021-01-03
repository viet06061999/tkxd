package com.oms.components.media.cd.controller;

import com.oms.bean.Media;
import com.oms.components.cart.controller.CartController;
import com.oms.components.media.book.gui.BookSearchPane;
import com.oms.components.media.book.gui.BookSinglePane;
import com.oms.components.media.cd.gui.CDSearchPane;
import com.oms.components.media.cd.gui.CDSinglePane;
import com.oms.components.media.controller.UserMediaPageController;
import com.oms.components.media.gui.MediaSearchPane;
import com.oms.components.media.gui.MediaSinglePane;
import com.oms.serverapi.MediaApi;
import com.oms.serverapi.cd.CDApi;

import java.util.List;
import java.util.Map;

public class UserCDPageController extends UserMediaPageController{

	public UserCDPageController() {
		super();
	}
	public UserCDPageController(CartController cartController) {
		super(cartController);
	}

	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		System.out.println("cds" + new CDApi().getCds(searchParams));
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
}
