package oo3;
import java.util.ArrayList;
import oo3.Request;

public class RequestList {
	ArrayList<Request> requestList = new ArrayList<Request>();
	public ArrayList<Request> add(Request r){
    	 requestList.add(r);
    	 return requestList;
     }

}
