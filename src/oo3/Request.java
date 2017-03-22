package oo3;

public class Request {
	private String flag;
    
    private int dst_floor;
	

	private int local_floor;
     private String state;
     private double time;
	private String is_sort;
     public Request(){
    	 state = "STILL";
    	 is_sort = "false";
     }
     
     public double toString(Request req_obj,int now_floor,int local_floor, double time, double pre_time, String sort_flag){
    	 if(sort_flag.equals("true")){
    		 String input_complete = null;
        	 if(req_obj.getFlag().equals("FR")){
        		 input_complete = "(" + req_obj.getFlag() + "," + req_obj.getLocal_floor() + "," + req_obj.getState() + "," + req_obj.getTime() + ")";
        	 }else{
        		 input_complete = "(" + req_obj.getFlag() + "," + req_obj.getDst_floor() + "," + req_obj.getTime() + ")";
        	 }
    		 if(local_floor == now_floor){
    			   state = "STILL";
    		 }else if(local_floor > now_floor){
    			  state = "DOWN";
    		 }else
    		 {
    			 state = "UP";
    		 }
    		 if (req_obj.getIs_sort().equals("true")){
    			 time += pre_time;
    			 time += 1;
    		 }else{
    			 time += pre_time;
    		 }
    		 System.out.println("[" + input_complete + "] / (" + now_floor + "," + state + "," + time + ")");
    		 now_floor = local_floor;
    	 }else{
    		 String input_complete = null;
        	 if(req_obj.getFlag().equals("FR")){
        		 input_complete = "(" + req_obj.getFlag() + "," + req_obj.getLocal_floor() + "," + req_obj.getState() + "," + req_obj.getTime() + ")";
        	 }else{
        		 input_complete = "(" + req_obj.getFlag() + "," + req_obj.getDst_floor() + "," + req_obj.getTime() + ")";
        	 }
    		 if(local_floor == now_floor){
    			   state = "STILL";
    		 }else if(local_floor > now_floor){
    			  state = "DOWN";
    		 }else
    		 {
    			 state = "UP";
    		 }
    		 time += req_obj.getTime();
    		 System.out.println("[" + input_complete + "] / (" + now_floor + "," + state + "," + time + ")");
    		 now_floor = local_floor;
    	 }
    	 return time;
     }
     public String getFlag() {
 		return flag;
 	}

 	public void setFlag(String flag) {
 		this.flag = flag;
 	}

 	public int getLocal_floor() {
 		return local_floor;
 	}

 	public void setLocal_floor(int local_floor) {
 		this.local_floor = local_floor;
 	}

 	public String getState() {
 		return state;
 	}

 	public void setState(String state) {
 		this.state = state;
 	}

 	public double getTime() {
 		return time;
 	}

 	public void setTime(double time) {
 		this.time = time;
 	}
 	public int getDst_floor() {
		return dst_floor;
	}

	public void setDst_floor(int dst_floor) {
		this.dst_floor = dst_floor;
	}
	 public String getIs_sort() {
			return is_sort;		}

		public void setIs_sort(String is_sort) {
			this.is_sort = is_sort;
		}


}
