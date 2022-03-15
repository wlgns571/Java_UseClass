package java_day16.pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import java_day16.cafe.Constants;

public class PokemonMain {
	public static void main(String[] args) {
		ArrayList<Pokemon> pokemonPool = new ArrayList<Pokemon>();
		
		pokemonPool.add(new Pokemon("피카츄", "백만볼트", 50, 200, Constants.TYPE_THUNDER, 50));
		pokemonPool.add(new Pokemon("라이츄", "천만볼트", 70, 300, Constants.TYPE_THUNDER, 75));
		pokemonPool.add(new Pokemon("파이리", "불꽃발사", 50, 200, Constants.TYPE_FIRE, 50));
		pokemonPool.add(new Pokemon("리자드", "할퀴기", 70, 300, Constants.TYPE_FIRE, 75));
		pokemonPool.add(new Pokemon("리자몽", "용의숨결", 90, 400, Constants.TYPE_FIRE, 100));
		pokemonPool.add(new Pokemon("꼬부기", "물대포", 50, 200, Constants.TYPE_WATER, 50));
		pokemonPool.add(new Pokemon("어니부기", "물대포x2", 70, 300, Constants.TYPE_WATER, 75));
		pokemonPool.add(new Pokemon("거북왕", "하이드로펌프", 90, 400, Constants.TYPE_WATER, 100));
		pokemonPool.add(new Pokemon("이상해씨", "씨앗발싸", 50, 200, Constants.TYPE_PLANT, 50));
		pokemonPool.add(new Pokemon("이상해꽃", "솔라빔", 70, 300, Constants.TYPE_PLANT, 75));
		
		Trainer minwoo = new Trainer("민우", 1000);
		Trainer jihye = new Trainer("지혜", 1000);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("                                  ,'\\\n" + 
				"    _.----.        ____         ,'  _\\   ___    ___     ____\n" + 
				"_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" + 
				"\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" + 
				" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" + 
				"   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" + 
				"    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" + 
				"     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" + 
				"      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" + 
				"       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" + 
				"        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" + 
				"                                `'                            '-._|");
		
		// 경매 6번 진행
		for ( int i = 0; i < 6; i++ ) {
			// 0부터 pool 사이즈의 -1 까지 중 랜덤하게 나온다.
			int randInt = (int) (Math.random() * pokemonPool.size());
			
			System.out.println("포켓몬 경매 ===========================");
			System.out.println(pokemonPool.get(randInt));
			System.out.println("=======================================");
			
			int bet = 0;
			while(true) {
//				System.out.println("보유 현황 ------------------------");
//				minwoo.showPokemonList();	
//				jihye.showPokemonList();
//				System.out.println("------------------------------");
		// 민우 턴
		System.out.println("현재 입찰 금액: " + bet);
		System.out.println(minwoo.getName() + "님, " + "소지금(" + minwoo.getMoney() + ")");
		System.out.print("입찰 가격 입력: ");
		
		int inputBet = Integer.parseInt(sc.nextLine());
		minwoo.setBet(inputBet);
		
		// 입찰 포기시 -1 입력 
		if(inputBet != -1) {
			bet = minwoo.getBet();
		}else {
			break;
		}
		
		
		// 지혜 턴
		System.out.println("현재 입찰 금액: " + bet);
		System.out.println(jihye.getName() + "님, " + "소지금(" + jihye.getMoney() + ")");
		System.out.print("입찰 가격 입력: ");
		
		inputBet = Integer.parseInt(sc.nextLine());
		jihye.setBet(inputBet);	
		
		// 입찰 포기시 -1 입력
		if(inputBet != -1) {
			bet = jihye.getBet();
		}else {
			break;
		}
		
		}
		
		if(minwoo.getBet() != -1) {
			System.out.println(minwoo.getName() + "님이 " 
					+ pokemonPool.get(randInt).getName() + "을(를) " 
						+ minwoo.getBet() + "원에 구매하셨습니다.");
			minwoo.buyPokemon(pokemonPool.get(randInt));
		}
		
		if(jihye.getBet() != -1) {
			System.out.println(jihye.getName() 
					+ "님이 " + pokemonPool.get(randInt).getName() 
						+ "을(를) " + jihye.getBet() + "원에 구매하셨습니다.");
			jihye.buyPokemon(pokemonPool.get(randInt));
		}
			
	}
		System.out.println("================================");
		minwoo.showPokemonList();	
		jihye.showPokemonList();
		System.out.println("================================");
		
		while(true) {		
		
				
			for(int i = 0; i < 3; i++) {
				Pokemon one = minwoo.getPokemonList().get(i);
				Pokemon two = jihye.getPokemonList().get(i);
				
				one.attack(two);
				two.attack(one);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("============================");
			minwoo.showPokemonList();	
			jihye.showPokemonList();
			System.out.println("============================");
			
			if(minwoo.checkPokemon() >= 2 && jihye.checkPokemon() >= 2) {
				System.out.println("무승부");
				break;
			}else if(minwoo.checkPokemon() >= 2) {
				System.out.println(jihye.getName() + "승리!!");
				break;
			}else if(jihye.checkPokemon() >= 2) {
				System.out.println(minwoo.getName() + "승리!!");
				break;
			}
		}
	}

}
