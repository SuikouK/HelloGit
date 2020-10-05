package game;

import java.util.NoSuchElementException;

import character.Demon;
import character.Hero;
import character.Player;
/**
 * game1
 */
public class Main {

	public static void main(String[] args) {

		Player player = new Player();
		Hero hero = new Hero();
		Demon demon = new Demon();

		Senario tale = new Senario();
		try {
			tale.chapter1(player, hero, demon);
			tale.chapter2(hero, demon);
			tale.chapter3(player, hero, demon);
		}catch (NoSuchElementException e) {
			System.out.println("ゲームを終了します");
			return;
		}

	}

}

