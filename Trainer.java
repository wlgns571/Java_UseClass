package java_day16.pokemon;

import java.util.ArrayList;

public class Trainer {
	
	private String name;
	private int money;
	private int bet = 0;
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	public Trainer(String name, int money) {
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Trainer [name=" + name + ", money=" + money + ", bet=" + bet + ", pokemonList=" + pokemonList + "]";
	}
	
	public String getName() {
		return name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}
	public void setPokemonList(ArrayList<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}
	public void buyPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
		this.money -= this.bet;
	}
	
	public void showPokemonList() {
		if(pokemonList.size() > 0) {
			System.out.println(this.name + "님의 포켓몬 현황");
			for(Pokemon pm : pokemonList) {
				System.out.println(pm);
			}			
		}		
	}
	
	public int checkPokemon() {
		int deathCount = 0;
		for(Pokemon pm : pokemonList) {
			if(pm.getHp() <= 0) {
				deathCount ++;
			}
		}
		return deathCount;
	}
	
}
