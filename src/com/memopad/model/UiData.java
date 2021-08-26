package com.memopad.model;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UiData {
	private JButton btn1,btn2,btn3;
	private JTextArea ta;
	
	public UiData() {
		ta = new JTextArea();
		btn1 = new JButton("clear");
		btn2 = new JButton("save");
		btn3 = new JButton("load");
	}
	
	public JTextArea getTa() {
		return ta;
	}
	
	public void setTa(JTextArea ta) {
		this.ta = ta;
	}
	
	public JButton getBtn1() {
		return btn1;
	}
	
	public JButton getBtn2() {
		return btn2;
	}	
	
	public JButton getBtn3() {
		return btn3;
	}
}
