package java_day16.bingo;

import java.util.ArrayList;
import java.util.Scanner;

public class BingoMain {
	public static void main(String[] args) {
		ArrayList<Bingo> bingoBoard1 = new ArrayList<Bingo>();
		ArrayList<Bingo> bingoBoard2 = new ArrayList<Bingo>();
		
		for(int i = 0; i < 25; i++) {
			int rand1 = (int)(Math.random()*20) + 1;
			bingoBoard1.add(new Bingo(rand1));
			
			int rand2 = (int)(Math.random()*20) + 1;
			bingoBoard2.add(new Bingo(rand2));
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printBingo(bingoBoard1);
			System.out.print("1팀 숫자를 불러주세요: ");
			int num = Integer.parseInt(sc.nextLine());
			
			int count = 0;
			for(int i = 0; i < bingoBoard1.size(); i++) {
				if(bingoBoard1.get(i).num == num) {
					bingoBoard1.get(i).front = num + "";
					count++;
				}
			}
			printBingo(bingoBoard1);
			System.out.println(count + "개 일치합니다.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < 20; i++) {
				System.out.println();
			}
			
			printBingo(bingoBoard2);
			System.out.print("2팀 숫자를 불러주세요: ");
			num = Integer.parseInt(sc.nextLine());
			count = 0;
			for(int i = 0; i < bingoBoard2.size(); i++) {
				if(bingoBoard2.get(i).num == num) {
					bingoBoard2.get(i).front = num + "";
					count++;
				}
			}
			printBingo(bingoBoard2);
			System.out.println(count + "개 일치합니다.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < 20; i++) {
				System.out.println();
			}
			
			if(countBingo(bingoBoard1) && countBingo(bingoBoard2)) {
				System.out.println("무승부");
				break;
			}
			
			if(countBingo(bingoBoard1)) {
				System.out.println("1팀이 승리하였습니다.");
				break;
			}
			
			if(countBingo(bingoBoard2)) {
				System.out.println("2팀이 승리하였습니다.");
				break;
			}
		}
		
		
	}
	
	static boolean countBingo(ArrayList<Bingo> bingoBoard) {
		// 1. 0~4, 5~9, 10~14, 15~19, 20~24
		// 2. (0,5,10,15,20) (1,6,11,16,21) (2,7,12,17,22)
		// 	  (3,8,13,18,23) (4,9,14,19,24)
		// 3. (0, 6, 12, 18, 24)
		// 4. (4, 8, 12, 16, 20)
		
		int bingoCount = 0;
		
		for(int i = 0; i < 5; i++) {
			int count = 0;
			for(int j = i*5; j < i*5+5; j++) {
				if(!bingoBoard.get(j).front.equals("[]")) {
					count++;
				}
			}
			if(count == 5) {
				bingoCount++;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			int count = 0;
			for(int j = i; j <= 20+i; i += 5) {
				if(!bingoBoard.get(j).front.equals("[]")) {
					count++;
				}
			}
			if(count == 5) {
				bingoCount++;
			}
		}
		
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(!bingoBoard.get(i*6).front.equals("[]")) {
				count++;
			}
		}
		if(count == 5) {
			bingoCount++;
		}
		
		count = 0;
		for(int i = 1; i <= 5; i++) {
			if(!bingoBoard.get(i*4).front.equals("[]")) {
				count++;
			}
		}
		if(count == 5) {
			bingoCount++;
		}
		
		return (bingoCount >= 3);
		
	}
	
	static void printBingo(ArrayList<Bingo> bingoBoard) {
		for(int i = 0; i < bingoBoard.size(); i++) {
			
			if(bingoBoard.get(i).front.length() == 1) {
				System.out.print(" " + bingoBoard.get(i).front + " ");
			}else {
				System.out.print(bingoBoard.get(i).front + " ");
			}
			
			if(i % 5 == 4) {
				System.out.println();
			}
		}
	}
	
}
