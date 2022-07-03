package finalexam;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;

class Time{
	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	public String getTime() {
		Date date = new Date();
		return formatter.format(date);
	}
}
public class Main extends Time{
	Scanner enter = new Scanner(System.in);
	Data[] Alldata = new Data[1000];
	
	public static void main(String[] args) {
		Main obj = new Main();
		boolean loop = false;
		int s1, s2;
		int i = 0;
		do {
			s1 = obj.show1();
			if(s1 == 1) {
				do {
					s2 = obj.show2();
					if(s2 == 1 || s2 == 2) {
						obj.Alldata[i] = new Data(obj.show3(), s2);
						obj.show4(i);
						i++;
						loop = false;
					}else {
						obj.show5();
						loop = true;
					}
				}while(loop);
				loop = true;
			}else if(s1 == 2) {
				do {
					int id = (obj.show6() - 100);
					if(id >= 0 && id < i) {
						obj.show7(id);
						loop = false;
					}else if(id == -100) {
						loop = false;
					}else {
						obj.show8();
						loop = true;
					}
				}while(loop);
				loop = true;
			}else if(s1 == 3) {
				obj.show9();
				loop = false;
			}else {
				obj.show10();
				loop = true;
			}
		}while(loop);
	}
	
	public int show1() {
		int a;
		System.out.println("\n\t==========================================");
		System.out.println("\t|| WELCOME TO PARKING PAYMENT SYSTEM\t||");
		System.out.println("\t==========================================");
		System.out.println("\t|| 1. Book Ticket\t\t\t||");
		System.out.println("\t|| 2. Pay Ticket\t\t\t||");
		System.out.println("\t|| 3. Finish\t\t\t\t||");
		System.out.print("\t|| Your choice: ");
		a = enter.nextInt();
		System.out.print("\t==========================================");
		return a;
	}
	public int show2() {
		int a;
		System.out.println("\n\t==========================================");
		System.out.println("\t|| 1. Car\t\t\t\t||");
		System.out.println("\t|| 2. Motorcycle\t\t\t||");
		System.out.print("\t|| Your choice: ");
		a = enter.nextInt();
		return a;
	}
	public String show3() {
		String a;
		System.out.println("\n\t==========================================");
		System.out.print("\t|| Enter your vehicle number: ");
		a = enter.next().toUpperCase();
		System.out.print("\t==========================================");
		return a;
	}
	public void show4(int i) {
		System.out.println("\n\t===============Your Ticket================");
		System.out.println("\t|| Time\t\t: " + Alldata[i].time);
		System.out.println("\t|| Ticket ID\t: " + (i+100));
		System.out.println("\t|| Vehicle Num.\t: " + Alldata[i].plat);
		System.out.println("\t|| Type\t\t: " + Alldata[i].type);
		System.out.println("\t==========================================");
	}
	public void show5() {
		System.out.println("\n\t==========================================");
		System.out.println("\t|| Please choose either 1 or 2 !\t||");
		System.out.println("\t==========================================");
	}
	public int show6() {
		int a;
		System.out.println("\n\t==========================================");
		System.out.println("\t|| Press 0 to go to the home menu ....");
		System.out.print("\t|| Enter your Ticket ID: ");
		a = enter.nextInt();
		System.out.println("\t==========================================");
		return a;
	}
	public void show7(int id) {
		String cTime = getTime();
		String cTimeIn = Alldata[id].time;
		String cPlat = Alldata[id].plat;
		String cType = Alldata[id].type;
		int cPrice = Alldata[id].price;
		
		int bSecond = Integer.parseInt((new StringBuilder()).append(cTimeIn.charAt(6)).append(cTimeIn.charAt(7)).toString());
		int aSecond = Integer.parseInt((new StringBuilder()).append(cTime.charAt(6)).append(cTime.charAt(7)).toString());
		int bMinute = Integer.parseInt((new StringBuilder()).append(cTimeIn.charAt(3)).append(cTimeIn.charAt(4)).toString());
		int aMinute = Integer.parseInt((new StringBuilder()).append(cTime.charAt(3)).append(cTime.charAt(4)).toString());
		int bHour = Integer.parseInt((new StringBuilder()).append(cTimeIn.charAt(0)).append(cTimeIn.charAt(1)).toString());
		int aHour = Integer.parseInt((new StringBuilder()).append(cTime.charAt(0)).append(cTime.charAt(1)).toString());
		
		System.out.println("\n\t===============Your Ticket================");
		System.out.println("\t|| Ticket ID\t: " + (id+100));
		System.out.println("\t|| In\t\t: " + cTimeIn);
		System.out.println("\t|| Out\t\t: " + cTime);
		System.out.println("\t|| Vehicle Num.\t: " + cPlat);
		System.out.println("\t|| Type\t\t: " + cType);
		calculate(aSecond, bSecond, aMinute, bMinute, aHour, bHour, cPrice);
		System.out.println("\t==========================================");
	}
	public void calculate(int aS, int bS, int aM, int bM, int aH, int bH, int p) {
		int s, m, h;
		h = (aH - bH < 0)? 0 : aH-bH;
		m = aM - bM;
		s = aS - bS;
		if(m < 0) {
			m = 60 - (m * -1);
			h = h - 1;
		}
		if(s < 0) {
			s = 60 - (s * -1);
			m = (m == 0)? 59 : (m - 1);
		}
		p = (m == 0 && s == 0)? (p * h) : (p * (h + 1));
		System.out.println("\t|| Total Time\t: " + h + "hour " + m + "min " + s + "sec");
		System.out.println("\t|| Total Price\t: Rp " + p);
	}
	public void show8() {
		System.out.println("\n\t==========================================");
		System.out.println("\t|| Your Ticket ID is not found!\t\t||");
		System.out.println("\t==========================================");
	}
	public void show9() {
		System.out.println("\n\t==========================================");
		System.out.println("\t|| THANK YOU ....\t\t\t||");
		System.out.println("\t==========================================");
	}
	public void show10() {
		System.out.println("\n\t==========================================");
		System.out.println("\t|| Please choose either 1 or 2 or 3 !\t||");
		System.out.println("\t==========================================");
	}
}