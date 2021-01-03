package com.oms.components.media.cd.gui;

import com.oms.components.media.gui.PhysicalMediaSearchPane;

import javax.swing.*;
import java.util.Map;

@SuppressWarnings("serial")
public class CDSearchPane extends PhysicalMediaSearchPane {
	private JTextField artistField;
	private JTextField languageField;

	public CDSearchPane() {
		super();
	}
	
	@Override
	public void buildControls() {
		super.buildControls();
		JLabel artistLabel = new JLabel("Artist");
		artistField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(artistLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(artistField, c);
	}
	
	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		
		if (!artistField.getText().trim().equals("")) {
			res.put("artist", artistField.getText().trim());
		}

		return res;
	}
}
