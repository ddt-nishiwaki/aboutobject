package fantan;

import cardgame.*;
/**
 * 9-3 トランプゲームフレームワークのRuleインターフェースを実装するクラス
 * FantanRule(以下コード)を作成してください
 * なお、候補となるカードが複数見つかった場合、最初の一枚を返すものとします。
 * 
 * 七並べのルールクラスです
 * @author wakkky05
 *
 */
public class FantanRule implements Rule{
	/****************************************
		定数
	*****************************************/
	// 配列の最初のインデックスです
	private static final int START_COUNT = 0;
	// 配列のインデックスに変換するための値です
	private static final int SHIFT_INDEX = -1;
	// 一つ前(左)の数字のカードを参照するための値です
	private static final int SHIFT_PREVIOUS_CARD = -1;
	// 一つ後ろ(右)の数字のカードを参照するための値です
	private static final int SHIFT_NEXT_CARD = 1;
	// カードの数字範囲の始点、終点を確認する際に使う値です
	private static final int NOT_AVAILABLE_ZERO = 0;
	/****************************************
		メソッド
	*****************************************/
	/**
	 * テーブルにおけるカードがあるかどうか探します
	 * 
	 * 1. プレーヤの手札確認
	 * 2. テーブル上のカードを確認
	 * 3. 同じスートで隣り合う数字があるか確認
	 * 4. 2~3を手札全てのカードに対して繰り返す
	 * 5. 見つかった場合はそのカードをテーブルに置く対象として設定
	 * 6. ループを抜ける
	 * 
	 * @param hand プレーヤの手札
	 * @param table 置きに行くテーブル
	 */
	public Card[] findCandidateCard(Hand hand, Table table){
		// 置けるカードを設定するための変数です
		Card[] availableCard = null;
		// テーブルのカードの状況を確認のために取得します
		Card[][] tableSituation = table.getCards();
		// 全てのカードを確認するために手札の枚数を取得します
		int numberOfCards = hand.getNumberOfCards();
		// 手札の各カードについてそれぞれテーブルに置けるか確認します
		for(int cardCount = START_COUNT; cardCount < numberOfCards; cardCount++){
			// 対象のカードを取得します
			Card targetCard = hand.getCard(cardCount);
			// カードのスートを確認します
			int targetSuit = targetCard.getSuit();
			// カードの数字を確認します
			int targetNumber = targetCard.getNumber();
			// 対象のカードの左隣のカードを求めます
			int leftCardNumber = (targetNumber + SHIFT_PREVIOUS_CARD == NOT_AVAILABLE_ZERO) ? Card.CARD_NUM : targetNumber + SHIFT_PREVIOUS_CARD;
			// 対象のカードの右隣のカードを求めます
			int rightCardNumber = (targetNumber + SHIFT_NEXT_CARD > Card.CARD_NUM) ? Card.CARD_NUMBER_ONE : targetNumber + SHIFT_NEXT_CARD;
			// テーブルに左隣か右隣のカードが存在するか確認します
			if( tableSituation[targetSuit + SHIFT_INDEX][leftCardNumber + SHIFT_INDEX] != null  ||  tableSituation[targetSuit + SHIFT_INDEX][rightCardNumber + SHIFT_INDEX] != null){
				// どちらかにカードが存在したら現在の対象カードを"置ける"カードとして設定します
				availableCard = new Card[] { hand.pickedCard(cardCount) };
				// その後ループ処理を終了します
				break;
			}
		}
		// 設定した置けるカードを返します(なければNullを返します)
		return availableCard;
	}
}
