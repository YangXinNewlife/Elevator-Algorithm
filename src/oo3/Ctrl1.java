package oo3;

import java.util.ArrayList;

import oo3.Request;
public class Ctrl1 extends Ctrl{
	
	@Override
	public double sechdule(ArrayList<Request> requestList, int now_floor, int dst_floor){
		  //the dst_floor is not used
		  String sort_flag = "false";
		  double pre_time = 0.0;
		  double temp = 0.0;
		  double sum_temp = 0.0;
		  int local_floor = 1;
		  //sort
		  if(requestList.size() >= 3){
			  for(int i = 1; i < requestList.size() - 1; i++){
				  if((requestList.get(i + 1).getDst_floor() < requestList.get(i).getDst_floor()) && (requestList.get(i + 1).getFlag().equals(requestList.get(i).getFlag()))){
					  sort_flag = "true";
					  Request req = new Request();
					  req = requestList.get(i);
					  requestList.set(i, requestList.get(i + 1));
					  requestList.set(i + 1, req);
					  requestList.get(i + 1).setIs_sort("true");
					  
				  }else if((!requestList.get(i + 1).getFlag().equals(requestList.get(i).getFlag())) && ((requestList.get(i + 1).getLocal_floor() < requestList.get(i).getDst_floor()) || (requestList.get(i + 1).getDst_floor() < requestList.get(i).getLocal_floor()))){
					  sort_flag = "true";
					  Request req = new Request();
					  req = requestList.get(i);
					  requestList.set(i, requestList.get(i + 1));
					  requestList.set(i + 1, req);
					  requestList.get(i + 1).setIs_sort("true");
				  }
			  }
		  }
		  
		  Request r = new Request();
		  for(int i = 0; i < requestList.size(); i++){
			  if(requestList.get(i).getFlag().equals("FR")){
				  temp = command(requestList.get(i), now_floor, requestList.get(i).getLocal_floor());
				  now_floor = requestList.get(i).getLocal_floor();
				  pre_time = r.toString(requestList.get(i), now_floor, local_floor, temp, pre_time, sort_flag);
				  local_floor = now_floor;
			  }else if(requestList.get(i).getFlag().equals("ER")){
				  temp = command(requestList.get(i), now_floor, requestList.get(i).getDst_floor());
				  now_floor = requestList.get(i).getDst_floor();
				  pre_time = r.toString(requestList.get(i), now_floor, local_floor, temp, pre_time, sort_flag);
				  local_floor = now_floor;
			  }
		  }
	  	  return 0;
	    }
	  	 
	    public double command(Request request_obj, int now_floor, int dst_floor){
	    	Lift l = new Lift();
    	    double T = 0;
    	    if(request_obj.getDst_floor() == 0){
	    		 if(request_obj.getLocal_floor() == now_floor){
	    			System.out.println("STILL");
	    			System.out.println(request_obj.getLocal_floor());
	    			System.out.println(now_floor);
	  	  	  	 	T = l.still(request_obj.getLocal_floor(), now_floor);
		  	  	 }else if(request_obj.getLocal_floor() > now_floor){
		  	  		System.out.println("UP");
	    			System.out.println(request_obj.getLocal_floor());
	    			System.out.println(now_floor);
		  	  		T = l.up(request_obj.getLocal_floor(), now_floor);
		  	  	}else if(request_obj.getLocal_floor() < now_floor){
		  	  		System.out.println("DOWN");
	    			System.out.println(request_obj.getLocal_floor());
	    			System.out.println(now_floor);
		  	  		T= l.down(request_obj.getLocal_floor(), now_floor);
		  	  	}
	    	}else{
    		    if((dst_floor - now_floor) > 0){
    		    	
    		    	T= l.up(request_obj.getDst_floor(), now_floor);
    		    	
    		    }else if((dst_floor - now_floor) < 0){
    		    	T= l.down(request_obj.getDst_floor(), now_floor);
    		    }else{
    		    	T = l.still(request_obj.getDst_floor(), now_floor);
    		    }
	    	}
    	    return T;
	    }

}
