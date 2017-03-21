package oo3;

public class Request {
	private String flag;
    
    private int dst_floor;
	

	private int local_floor;
     private String state;
     private double time;
     
     public void toString(int now_floor,String state,double time){
    	 System.out.print('('+now_floor+','+state+','+time+')');
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
}
