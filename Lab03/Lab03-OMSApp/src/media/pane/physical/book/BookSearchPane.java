package media.pane.physical.book;

import media.pane.physical.PhysicalMediaSearchPane;

import javax.swing.*;
import java.util.Map;

@SuppressWarnings("serial")
public class BookSearchPane extends PhysicalMediaSearchPane {
	private JTextField publisherField;
	private JTextField languageField;

	public BookSearchPane() {
		super();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		JLabel publisherLabel = new JLabel("Publisher");
		JLabel languageLabel = new JLabel("Language");
		publisherField = new JTextField(15);
		languageField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(publisherLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(publisherField, c);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(languageLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(languageField, c);
	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		if (!publisherField.getText().trim().equals("")) {
			res.put("publisher", publisherField.getText().trim());
		}
		if (!languageField.getText().trim().equals("")) {
			res.put("language", languageField.getText().trim());
		}
		return res;
	}
}
