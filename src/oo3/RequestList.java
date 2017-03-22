package oo3;
import java.util.ArrayList;
import oo3.Request;

public class RequestList {
	private String sort_flag;
	
	public RequestList(){
		sort_flag = "false";
	}
	ArrayList<Request> requestList = new ArrayList<Request>();
	public ArrayList<Request> add(Request r){
    	 requestList.add(r);
    	 return requestList;
     }
	
	public String getSort_flag() {
		return sort_flag;
	}
	public void setSort_flag(String sort_flag) {
		this.sort_flag = sort_flag;
	}

}
