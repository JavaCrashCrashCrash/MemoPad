package com.memopad.controller;

import javax.swing.JButton;

import com.memopad.model.UiData;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn;
	
	UiData uiData = new UiData();
	GUI gui = new GUI(uiData);
	
	public ButtonController() {
		folderAddBtn = uiData.getFolderAddBtn();
		folderDeleteBtn = uiData.getFolderDeleteBtn();
		memoAddBtn = uiData.getMemoAddBtn();
		memoDeleteBtn = uiData.getMemoDeleteBtn();
				
		
//		btn1.addActionListener(null);
//		// ���� ��ư �̺�Ʈ
//		btn2.addActionListener(null);
//		// ���� ��ư �̺�Ʈ
//		btn3.addActionListener(null);
//		// �ҷ����� ��ư �̺�Ʈ
	}
}
