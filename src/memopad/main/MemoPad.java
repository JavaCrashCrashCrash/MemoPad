package memopad.main;

import com.memopad.model.Folder;
import com.memopad.model.FolderManager;
import com.memopad.model.Memo;

public class MemoPad {
	public static void main(String[] args) {
//		ButtonController buttonController = new ButtonController();
		FolderManager folderManager = new FolderManager();
		
		
		Folder folder = new Folder("Fold", "C://users/jinseo/Desktop/");
		Memo memo = new Memo("hello", "hello My name is Jinseo");
		Memo memo2 = new Memo("bye", "bye bye");
		folder.addMemo(memo);
		folder.addMemo(memo2);
		folderManager.addFolder(folder);
		
		folder = new Folder("Fold2", "C://");
		memo = new Memo("hi", "hi jinseo");
		memo2 = new Memo("goodbye", "goodbye jinseo");
		folder.addMemo(memo);
		folder.addMemo(memo2);
		
		folderManager.addFolder(folder);
		
		
		folderManager.printFolderAll();
	}
}