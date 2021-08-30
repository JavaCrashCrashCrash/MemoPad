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
//		// 비우기 버튼 이벤트
//		btn2.addActionListener(null);
//		// 저장 버튼 이벤트
//		btn3.addActionListener(null);
//		// 불러오기 버튼 이벤트
	}
}
