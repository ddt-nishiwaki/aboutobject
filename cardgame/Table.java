package cardgame;

/**
 * テーブルインターフェースです
 */
public interface Table {
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * カードを置く
	 * 置かれたカードの扱いはサブクラスに任せる
	 * 
	 * @param card カードの配列 
	 */
	public void putCard(Card[] card);
	/**
	 * カードを見る
	 * 
	 * @return 置かれた各カードの文字列表現
	 */
	public Card[][] getCards();
}
