package propra.grpproj.quiz.SocketDataObjects;

import java.io.Serializable;
import java.util.ArrayList;

public class PubList implements Serializable{
	public ArrayList<Pub> list = new ArrayList<Pub>();
	
	PubList(ArrayList<Pub> list){
		this.list= list;
	}
	public ArrayList<Pub> getList () {
		
		ArrayList<Pub> plist = this.list;
		
		return plist;
	}

	public void setList(ArrayList<Pub> list) {
		this.list = list;
	}
}
