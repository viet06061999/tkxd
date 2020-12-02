package media.page.admin;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.IDataManageController;
import com.oms.bean.Media;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	IDataManageController iDataManageController;
	public AdminMediaPageController() {
		super();
	}
	public AdminMediaPageController( IDataManageController iDataManageController){
		this();
		this.iDataManageController = iDataManageController;
	}
	@Override
	public ADataListPane<Media> createListPane() {
		return new AdminMediaListPane(this);
	}

	abstract public void showEditDialog(Media media);
}
