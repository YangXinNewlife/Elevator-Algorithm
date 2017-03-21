package oo3;

public class Lift {
	private int nowFloor;
	private int button_floor;
	private String state;
	private String flag;
	private boolean open;
    private boolean close;
    
    public Lift(){
	  	  nowFloor = 1;
	  	  state = "STILL";
	  	  flag="ER";
    }
    
    public double up(int floor, int nowFloor){
	     double T;
	  	 T = (floor - nowFloor) * 0.5+1;
	     return T;
    }
    
    public double down(int floor, int nowFloor){
  	  double T;
  	  T=(nowFloor - floor) * 0.5+1;
  	  return T;
    } 
    
    public double still(int floor, int nowFloor){
  	  double T;
  	  T=(nowFloor - floor) * 0.5+1;
  	  nowFloor = floor;
  	  return T;
    }
   
    public int getNowFloor() {
		return nowFloor;
	}
	  public void setNowFloor(int nowFloor) {
		this.nowFloor = nowFloor;
	} 
	 public int getButton_floor() {
		return button_floor;
	}

	public void setButton_floor(int button_floor) {
		this.button_floor = button_floor;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Request input(String flag,int dst_floor,double time){
		Request r =new Request();
      r.setFlag(flag);
      r.setDst_floor(dst_floor);
  
      r.setTime(time);
      return r;
	}
}

