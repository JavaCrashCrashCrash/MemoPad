package memopad.main;

import com.memopad.model.Memo;

public class MemoPad {
	public static void main(String[] args) {
//		ButtonController buttonController = new ButtonController();
		Memo memo = new Memo("title", "content");
		System.out.println(memo.title memo.content);
	}
}