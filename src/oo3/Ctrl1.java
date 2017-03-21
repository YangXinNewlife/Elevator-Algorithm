package oo3;

import java.util.ArrayList;

import oo3.Request;

public class Ctrl1 extends Ctrl{
	
	@Override
	public double sechdule(ArrayList<Request> requestList, int now_floor, int dst_floor){
		  double temp = 0.0;
		  double sum_temp = 0.0;
	  	  for(int i=0; i < requestList.size(); i++){
	  		  temp = command(requestList.get(i), now_floor, dst_floor);
	  		  sum_temp += temp;
	  	  }
	  	  return sum_temp;
	    }
	  	 
	    public double command(Request request_obj, int now_floor, int dst_floor){
	      Lift l = new Lift();
	  	  double T = 0;
	  	  if(dst_floor == 0){
	  		if(request_obj.getState().equals("UP")){
	  	  	  	 System.out.println("Stat is up");
	  	  		 T= l.down(request_obj.getLocal_floor(), now_floor);
	  	  	  }
	  	  	  else if(request_obj.getState().equals("DOWN")){
	  	  	  	 System.out.println("State is DOWN");
	  	  	  	 T = l.up(request_obj.getLocal_floor(), now_floor);
	  	  	  }else{}
	  		  
	  	  }else{
	  		  if((dst_floor - now_floor) > 0){
	  			System.out.println("Stat is up");
	  			T= l.up(request_obj.getDst_floor(), now_floor);
	  		  }else if((dst_floor - now_floor) < 0){
	  			System.out.println("Stat is DOWN");
	  			T= l.down(request_obj.getDst_floor(), now_floor);
	  		  }else{
	  			T = l.still(request_obj.getDst_floor(), now_floor);
	  		  }
	  	  }
		 return T;
	    }

}
