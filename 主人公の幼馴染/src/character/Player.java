package character;

import java.util.NoSuchElementException;
import java.util.Scanner;

import game.Senario;
import item.Clock;
import item.Item;

/**
 * プレイヤー(主人公の幼馴染)
 */
public class Player {
	/**
	 * 名前
	 */
	protected String name;

	public Player() {
		this.name = "あなた";

	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * アイテムを渡す
	 * @param hero 渡す相手
	 * @throws NoSuchElementException Ctrl+Zが入力されたとき
	 */
	public void giftTo(Hero hero) throws NoSuchElementException {
		int i = 0;
		while (i < 5 && hero.getPocket().size() < 3) {
			Item item = Item.randomGenerate();
			System.out.println(item + "を渡す? Y/N");
			String command;
			while (true) {
				command = new Scanner(System.in).nextLine();
				if (command.equals("y") || command.equals("Y") || command.equals("ｙ")
						|| command.equals("Y")) {
					if (hero.getPocket().contains(item)) {
						System.out.println("それはもう渡してある");
						break;
					}
					hero.getPocket().add(item);
					System.out.println("渡した");
					break;
				}
				if (command.equals("n") || command.equals("N") || command.equals("ｎ")
						|| command.equals("N")) {
					System.out.println("渡さなかった");
					break;
				}
				i--;
				System.out.println("悩む……");
				continue;
			}
			i++;
		}
	}

	/**
	 * 時計を直す
	 * @param hero 主人公
	 * @throws NoSuchElementException Ctrl+Zが入力されたとき
	 */
	public void fixClock(Hero hero) throws NoSuchElementException {
		if (hero.getPocket().contains(new Clock())) {
			System.out.println("～その後～\n時計を直す？ Y/N");
			String command;
			while (true) {
				command = new Scanner(System.in).nextLine();
				if (command.equals("y") || command.equals("Y") || command.equals("ｙ")
						|| command.equals("Y")) {
					System.out.println("直した。\n時計は再び壊れる。\n\n");
					//時が戻る
					Hero hero1 = new Hero();
					Demon demon1 =new Demon();
					Senario tale = new Senario();
					tale.chapter1(this, hero1, demon1);
					tale.chapter2(hero1, demon1);
					tale.chapter3(this, hero1, demon1);
					break;
				}
				if (command.equals("n") || command.equals("N") || command.equals("ｎ")
						|| command.equals("N")) {
					System.out.println("直さなかった。\n～～～～～");
					break;
				}
				System.out.println("悩む……");
				continue;
			}
		}
	}

}
