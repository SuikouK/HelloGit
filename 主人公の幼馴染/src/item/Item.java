package item;

import java.util.Random;

/**
 * アイテム
 */
public abstract class Item {

	/**
	 * 存在するアイテムの数
	 */
	static final int COUNT_ITEM = 7;

	/**
	 * 名前
	 */
	protected String name;

	/**
	 * 装備したときの攻撃力の増加倍率
	 */
	protected double atkRatio;

	/**
	 * 回復量
	 */
	protected int heal;

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * アイテムのランダム生成
	 * @return アイテム
	 */
	public static Item randomGenerate() {
		Random random = new Random();
		int itemNumber = random.nextInt(COUNT_ITEM);
		switch (itemNumber) {
		case 0:
			return new Knife();
		case 1:
			return new Cookie();
		case 2:
			return new Bread();
		case 3:
			return new FrenchBread();
		case 4:
			return new Coin();
		case 5:
			return new Dog();
		case 6:
			return new Clock();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @return ratio
	 */
	public double getRatio() {
		return atkRatio;
	}

	/**
	 * @return heal
	 */
	public int getHeal() {
		return heal;
	}

}
