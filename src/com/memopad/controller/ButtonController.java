package com.memopad.controller;

import javax.swing.JButton;

import com.memopad.model.UiData;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton btn1, btn2, btn3;
	
	UiData uiData = new UiData();
	GUI gui = new GUI(uiData);
	
	public ButtonController() {
		btn1 = uiData.getBtn1();
		btn2 = uiData.getBtn2();
		btn3 = uiData.getBtn3();
		
		btn1.addActionListener(null);
		// ���� ��ư �̺�Ʈ
		btn2.addActionListener(null);
		// ���� ��ư �̺�Ʈ
		btn3.addActionListener(null);
		// �ҷ����� ��ư �̺�Ʈ
	}
}
