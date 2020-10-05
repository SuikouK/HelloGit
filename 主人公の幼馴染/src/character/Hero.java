package character;

import java.util.HashSet;

import item.Bread;
import item.Coin;
import item.Cookie;
import item.FrenchBread;
import item.Item;
import item.Knife;


public class Hero extends Fighter {

	/**
	 * ポケット
	 */
	private HashSet<Item> pocket = new HashSet<Item>();

	public Hero() {
		this.name = "主人公";
		this.hitPoint = 210;
		this.atkPoint = 50;
	}

	/**
	 * 武器を装備する
	 */
	public void equlipWeapon() {
		Knife knife = new Knife();
		FrenchBread frenchBread = new FrenchBread();
		if (this.getPocket().contains(knife)) {
			this.atkPoint *= knife.getRatio();
			System.out.println(this + "は" + knife + "を装備した。攻撃力が" + knife.getRatio() + "倍になった！");
		}
		if (this.getPocket().contains(frenchBread)) {
			this.atkPoint *= frenchBread.getRatio();
			System.out.println(this + "は" + frenchBread + "を装備した。攻撃力が" + frenchBread.getRatio() + "倍になった！");
		}
	}

	/**
	 * クッキーを食べて攻撃する
	 * @param enemy 攻撃相手
	 */
	public void eatCookieAndAttack(Fighter enemy) {
		Cookie cookie = new Cookie();
		if (this.pocket.contains(cookie)) {
			System.out.println(this + "は" + cookie + "を食べた。");
			this.attackTo(enemy);
			this.pocket.remove(cookie);
		}
	}

	/**
	 * パンを食べて継戦する
	 */
	public void eatAndContinueFight(Fighter enemy) {
		Bread bread = new Bread();
		FrenchBread frenchBread = new FrenchBread();
		if (this.pocket.contains(bread) && this.dyingBy(enemy)) {
			System.out.println(this + "は" + bread + "を食べた\n体力が" + bread.getHeal() + "回復した");
			this.hitPoint += bread.getHeal();
			this.pocket.remove(bread);
		}
		if (this.pocket.contains(frenchBread) && this.dyingBy(enemy)) {
			System.out.println(this + "は" + frenchBread + "を食べた\n体力が" + frenchBread.getHeal() + "回復し、攻撃力が元に戻った");
			this.hitPoint += frenchBread.getHeal();
			this.atkPoint /= frenchBread.getRatio();
			this.pocket.remove(frenchBread);
		}
	}

	/**
	 * 攻撃を避ける
	 * @param enemy 攻撃相手
	 */
	public void avoidAndAttack(Fighter enemy) {
		Coin coin = new Coin();
		if (this.pocket.contains(coin) && this.dyingBy(enemy)) {
			System.out.println(this + "は" + enemy + "の攻撃を避けた");
			this.attackTo(enemy);
			this.pocket.remove(coin);
		}
	}

	/**
	 * アイテムを返す
	 * @param player
	 */
	public void returnItemFor(Player player) {
		if (this.isAlive()) {
			System.out.print(this+"は帰ってきた。\n"+this+"は");
			if(!this.pocket.isEmpty()) {
			for (Item item:this.pocket) {
				System.out.print(item+" ");
			}
			System.out.print("を返し、");
			}
			System.out.println(player+"に礼を言った。");
		}
	}
	
	/**
	 * @return pocket
	 */
	public HashSet<Item> getPocket() {
		return pocket;
	}

}
