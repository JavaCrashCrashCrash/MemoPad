package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class AddMemoController implements ActionListener {
		ObjectManager objectManager;
		GUI gui;
		
	public AddMemoController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		gui.memoFrame.
	}
}
