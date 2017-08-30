package cardgame;

/**
 * ルールのインターフェースです
 * @author wakkky05
 *
 */
public interface Rule {
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * テーブルに置けるカードを探す
	 * 手札とテーブルから出しうるカードの組み合わせを見つける
	 * 
	 * @param hand 手札
	 * @praram table テーブル
	 * @return 見つかったカードの組み合わせ。ない場合はNULL
	 */
	public Card[] findCandidateCard(Hand hand, Table table );
}
