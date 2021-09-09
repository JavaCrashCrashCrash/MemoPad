package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.memopad.view.GUI;

public class AddMemoUIController implements ActionListener {
	GUI gui;
	
	public AddMemoUIController(GUI gui) {
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gui.memoAddUI();
	}

}
