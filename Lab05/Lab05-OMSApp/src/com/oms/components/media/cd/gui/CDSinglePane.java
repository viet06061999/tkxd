package com.oms.components.media.cd.gui;

import com.oms.bean.CompactDisc;
import com.oms.bean.Media;
import com.oms.components.media.gui.PhysicalMediaSinglePane;

import javax.swing.*;

@SuppressWarnings("serial")
public class CDSinglePane extends PhysicalMediaSinglePane {
	private JLabel labelArtist;
	private JLabel labelLength;
	private JLabel labelTracks;
	private JLabel labelDateOfIssue;

	public CDSinglePane() {
		super();
	}
	
	public CDSinglePane(Media media) {
		this();
		this.t = media;
		displayData();
	}
	
	@Override
	public void buildControls() {
		super.buildControls();

		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelArtist = new JLabel();
		add(labelArtist, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelLength = new JLabel();
		add(labelLength, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelTracks = new JLabel();
		add(labelTracks, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelDateOfIssue = new JLabel();
		add(labelDateOfIssue, c);
	}
	
	
	@Override
	public void displayData() {
		super.displayData();
		
		if (t instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) t;
			labelArtist.setText("Artist: " + cd.getArtist());
			labelLength.setText("Length: " + cd.getLength());
			labelTracks.setText("Tracks: " + cd.getTracks().toString());
			labelDateOfIssue.setText("Date Of Issue: " + cd.getDateOfIssue());
		}
	}
}
