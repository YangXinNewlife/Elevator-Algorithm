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
		Request r = new Request();
		ArrayList<Request> requestList = new ArrayList<Request>();
		Ctrl ctrl = new Ctrl();
		String flag = null;
		String input_complete;
		int local_floor;
		int dst_floor = 0;
		String state;
		double time;
		int now_floor = 1;
		double sum_time = 0;
		String input = "0";
		System.out.println("===============================");
		System.out.println("|                             |");
		System.out.println("|   Hi, Boy, Please input:    |");
		System.out.println("|                             |");
		System.out.println("===============================");
		System.out.println("                               ");
		System.out.println("#=:");
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
			input_complete = inputArr[j];  
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
			   requestList.add(r);
			   System.out.println("[" + input_complete +", " + time + "]");
			   sum_time = ctrl.sechdule(requestList, now_floor, 0);
			   System.out.println("[" + input_complete + "] / (" + local_floor + "," + state + "," + sum_time + "]");
			   now_floor = local_floor;
			}else if(input.matches(regex3)){
			   System.out.println("Flag is ER");
	        }/*
	        else{
	    	   System.out.print('['+input+']');
	        }*/
		}
		
		
		
		
	}
		
}


