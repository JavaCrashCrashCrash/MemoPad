package memopad.main;

import com.memopad.model.Memo;

public class MemoPad {
	public static void main(String[] args) {
//		ButtonController buttonController = new ButtonController();
		Memo memo = new Memo("hello", "hello My name is Jinseo");
		memo.printMemo();
	}
}