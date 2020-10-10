package character;

/**
 * 戦うキャラクター
 */
public abstract class Fighter {

	/**
	 * 名前
	 */
	protected String name;
	/**
	 * 体力
	 */
	protected int hitPoint;
	/**
	 * 攻撃力
	 */
	protected int atkPoint;

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * ステータスを表示する
	 */
	public void dispStatus() {
		System.out.print(this.name);
		for (int i = 0; i < 7 - this.name.length(); i++) {
			System.out.print("　");
		}
		System.out.print("体力:" + this.hitPoint + "  攻撃力:" + this.atkPoint + "\n");
	}

	/**
	 * 攻撃する
	 * @param enemy 攻撃対象
	 */
	public void attackTo(Fighter enemy) {
		if (this.isAlive() && enemy.isAlive()) {
			System.out.println(this.name + "の攻撃! " + enemy.name + "に" + this.atkPoint + "のダメージ!");
			enemy.hitPoint -= this.atkPoint;
		}
	}

	/**
	 * 生存判定
	 * @return
	 */
	public boolean isAlive() {
		return this.hitPoint > 0;
	}

	/**
	 * 瀕死かどうか(回復アイテムを使うかどうかの判定に使う)
	 * @param c1
	 * @return
	 */
	public boolean dyingBy(Fighter enemy) {
		if (this.isAlive()) {
			return this.hitPoint <= enemy.atkPoint;
		} else {
			return false;
		}

	}

	/**
	 * 死んだことを表示する
	 */
	public void isDead() {
		if (!this.isAlive()) {
			System.out.println(this.name + "は敗れた");
		}
	}

}
