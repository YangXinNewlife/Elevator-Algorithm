package oo3;

public class Floor {
	private String  flag;
    
    public Floor(){
   	 flag = "FR";
    }
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public Request input(String flag,int local_floor,String state,double time){
       Request r =new Request();
       r.setFlag(flag);
       r.setLocal_floor(local_floor);
       r.setState(state);
       r.setTime(time);
		return r;
	}
}
