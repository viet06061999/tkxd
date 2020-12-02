package media.page.user;

import java.util.List;
import java.util.Map;

import com.oms.bean.Media;

import api.MediaApi;
import cart.CartController;
import media.pane.MediaSearchPane;
import media.pane.MediaSinglePane;
import media.pane.physical.book.BookSearchPane;
import media.pane.physical.book.BookSinglePane;

public class UserBookPageController extends UserMediaPageController {
	public UserBookPageController() {
		super();
	}
	public UserBookPageController(CartController cartController) {
		super(cartController);
	}
	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		return new MediaApi().getBooks(searchParams);
	}
	@Override
	public MediaSinglePane createSinglePane() {
		return new BookSinglePane();
	}
	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
}
