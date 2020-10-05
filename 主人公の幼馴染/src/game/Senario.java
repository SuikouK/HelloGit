package game;

import java.util.NoSuchElementException;
import java.util.Scanner;

import character.Demon;
import character.Fighter;
import character.Hero;
import character.Player;
import item.Dog;

public class Senario {

	/**
	 * 第1章 (出掛けるまで)
	 * @param player プレイヤー
	 * @param hero 主人公
	 * @param demon 魔王的な敵
	 */
	public void chapter1(Player player, Hero hero, Demon demon) {
		this.introduction(player, hero, demon);
		player.giftTo(hero);
		System.out.println(hero + "は" + demon + "の家へと向かった…\n");
	}

	/**
	 * 第2章(戦闘)
	 * @param hero 主人公
	 * @param demon 魔王的な敵
	 */
	public void chapter2(Hero hero, Demon demon) {
		if (hero.getPocket().contains(new Dog())) {
			System.out.println(demon + "は" + new Dog() + "が好き。決着は持ち越しになった。");
		} else {
			hero.equlipWeapon();
			this.startBattle(hero, demon);
			hero.eatCookieAndAttack(demon);
			while (hero.isAlive() && demon.isAlive()) {
				hero.avoidAndAttack(demon);
				demon.attackTo(hero);
				hero.eatAndContinueFight(demon);
				hero.attackTo(demon);
				demon.isDead();
				hero.isDead();
			}
			System.out.println();
		}
	}

	/**
	 * 第3章 (その後)
	 * @param player プレイヤー
	 * @param hero 主人公
	 * @param demon 魔王的な敵
	 */
	public void chapter3(Player player, Hero hero, Demon demon) {
		hero.returnItemFor(player);
		demon.appologize(player, hero);
		System.out.println("          end");
		player.fixClock(hero);
		
	}

	/**
	 * エンターで進む
	 * @param s 表示する文
	 * @throws NoSuchElementException Ctrl+Zが入力されたとき
	 */
	private static void enterNext(String s) throws NoSuchElementException {
		System.out.println(s + "\nenter↓");
		String c = new Scanner(System.in).nextLine();
	}

	/**
	 * 導入部
	 * @throws NoSuchElementException Ctrl+Zが入力されたとき
	 */
	private void introduction(Player player, Hero hero, Demon demon) throws NoSuchElementException {
		enterNext("\n" + "             press enter to START");
		enterNext(player + "は" + hero + "の幼馴染\n" + hero + "はもうすぐ"
				+ demon + "との決着を付けに行く");
		enterNext(player + "はアイテムを5個持っていて、" + hero + "に3個まで渡せる");
		enterNext("アイテムはランダムで、同じものを2つ以上渡すことはできない");
	}

	/**
	 * 戦闘開始メッセージ
	 * @param c1 戦闘するキャラ1
	 * @param c2 戦闘するキャラ2
	 * @throws NoSuchElementException Ctrl+Zが入力されたとき
	 */
	private void startBattle(Fighter c1, Fighter c2) throws NoSuchElementException {
		enterNext("戦闘がはじまる!");
		c1.dispStatus();
		c2.dispStatus();
	}

}
