package oo3;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex1 = "\\(+FR+\\,+\\p{Digit}{1,2}+\\,+DOWN+\\,+\\p{Digit}{1,}+\\)";
		String regex2 = "\\(+FR+\\,+\\p{Digit}{1,2}+\\,+UP+\\,+\\p{Digit}{1,}+\\)";
		String regex3 = "\\(+ER+\\,+\\p{Digit}{1,2}+\\,+\\p{Digit}{1,}+\\)";
		String[] inputArr = new String[1000];
		Floor f = new Floor();
		Lift  l = new Lift();
		ArrayList<Request> requestList = new ArrayList<Request>();
		Ctrl ctrl = new Ctrl();
		Ctrl1 ctrl2 = new Ctrl1();
		String flag = null;
		String input_complete;
		int local_floor = 1;
		int dst_floor = 0;
		String state = null;
		double time;
		int now_floor = 1;      /*lift floor*/
		double sum_time = 0;
		String input = "0";

		int lit = 0;
		while(!input.equals("run")){
			Scanner sc = new Scanner(System.in);
			input =  sc.nextLine();
			if(input.equals("run")){
				break;
			}else{
				inputArr[lit] = input;
				lit++;
			}	
		}
		for(int j = 0; j < lit; j++){
			Request r = new Request();
			if(inputArr[j].matches(regex1) || inputArr[j].matches(regex2)){
			   System.out.println("Flag is FR");
			   inputArr[j] = inputArr[j].replace("(", "");
			   inputArr[j] = inputArr[j].replace(")", "");
			   String[] temp = inputArr[j].split(",");
			   flag = temp[0];
			   local_floor = Integer.parseInt(temp[1]);
			   state = temp[2];
			   time = Double.parseDouble(temp[3]);
			   r.setFlag(flag);
			   r.setLocal_floor(local_floor);
			   r.setState(state);
			   r.setTime(time);
			   requestList.add(j,r);
			}else if(inputArr[j].matches(regex3)){
			   System.out.println("Flag is ER");
			   inputArr[j] = inputArr[j].replace("(", "");
			   inputArr[j] = inputArr[j].replace(")", "");
			   String[] temp = inputArr[j].split(",");
			   flag = temp[0];
			   dst_floor = Integer.parseInt(temp[1]);
			   time = Double.parseDouble(temp[2]);
			   r.setFlag(flag);
			   r.setDst_floor(dst_floor);
			   r.setState(state);
			   r.setTime(time);
			   requestList.add(j,r);
	        }
		}
		//ctrl.sechdule(requestList, now_floor, 0);
		ctrl2.sechdule(requestList, now_floor, 0);
	}
}


