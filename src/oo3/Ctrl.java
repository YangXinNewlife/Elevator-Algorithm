package oo3;

import java.util.ArrayList;

public class Ctrl implements Algorithm {
	
	public double sechdule(ArrayList<Request> requestList, int now_floor, int dst_floor){
	  double sum_temp = 0.0;
  	  for(int i=0; i < requestList.size(); i++){
  		  sum_temp = command(requestList.get(i), now_floor, dst_floor);	
  	  }
  	  return sum_temp;
    }
  	 
    public double command(Request request_obj, int now_floor, int dst_floor){
      Lift l = new Lift();
  	  double T = 0;
  	  if(dst_floor == 0){
  		if(request_obj.getLocal_floor() == now_floor){
	  	  	T = l.still(request_obj.getLocal_floor(), now_floor);
	  	}else if(request_obj.getLocal_floor() > now_floor){
	  		T = l.up(request_obj.getLocal_floor(), now_floor);
	  	}else if(request_obj.getLocal_floor() < now_floor){
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

	public Request sechdule1(ArrayList<Request> requestList) {
		// TODO Auto-generated method stub
		return null;
	}
}
