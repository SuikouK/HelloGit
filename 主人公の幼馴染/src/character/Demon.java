package character;

import item.Item;

public class Demon extends Fighter {
	public Demon() {
		this.name = "魔王的な敵";
		this.hitPoint = 300;
		this.atkPoint = 75;
	}

	/**
	 * 謝罪する
	 * @param player
	 * @param hero
	 */
	public void appologize(Player player, Hero hero) {
		if (this.isAlive() && !hero.isAlive()) {
			System.out.println(this + "は" + player + "のもとを訪れ、");
			if (!hero.getPocket().isEmpty()) {
				for (Item item : hero.getPocket()) {
					System.out.print(item + " ");
				}
				System.out.print("を返し、");
			}
			System.out.println("「すまない。」と言った。");
		}
	}
}
