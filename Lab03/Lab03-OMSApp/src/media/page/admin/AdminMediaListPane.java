package media.page.admin;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import com.oms.bean.Media;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AdminMediaListPane extends ADataListPane<Media>{

	public AdminMediaListPane(ADataPageController<Media> controller) {
		this.controller = controller;
	}

	@Override
	public void decorateSinglePane(ADataSinglePane<Media> singlePane) {
		JButton button = new JButton("Edit");
		singlePane.addDataHandlingComponent(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller instanceof AdminMediaPageController) {
					((AdminMediaPageController) controller).showEditDialog(singlePane.getData());
				}
			}
		});
	}
}
