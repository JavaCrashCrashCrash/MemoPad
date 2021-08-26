package com.memopad.controller;

import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import com.memopad.model.UiData;

public class ClearController {
	JTextArea ta;
	
	public ClearController(UiData uiData) {
		this.ta = uiData.getTa();
	}
	
	public void actionPerformed(ActionEvent e) {
//		ta.
	}
}
