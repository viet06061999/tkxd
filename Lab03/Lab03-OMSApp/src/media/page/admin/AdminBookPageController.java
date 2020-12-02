package media.page.admin;

import abstractdata.IDataManageController;
import api.MediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;
import editdialog.BookEditDialog;
import media.pane.MediaSearchPane;
import media.pane.MediaSinglePane;
import media.pane.physical.book.BookSearchPane;
import media.pane.physical.book.BookSinglePane;

import java.util.List;
import java.util.Map;

public class AdminBookPageController extends AdminMediaPageController {

	public AdminBookPageController() {
		super(new IDataManageController<Book>() {
			@Override
			public void create(Book book) {

			}

			@Override
			public void read(Book book) {

			}

			@Override
			public void delete(Book book) {

			}

			@Override
			public void update(Book book) {
				new MediaApi().updateBook(book);
			}
		});
	}

	@Override
	public void showEditDialog(Media media) {
       new BookEditDialog(media, this.iDataManageController).isVisible();
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
