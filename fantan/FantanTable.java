package fantan;

import cardgame.Card;
import cardgame.Table;

/**
 * 9-2 リスト9-1(以下コード)の各メソッド（①〜③の部分)を実装し、
 * FantanTable.javaを完成させてください。
 * toStringメソッドでは、テーブルに置かれたカードの状態を以下のように画面に表示するものとします。
 * ※ テーブルの上で現在カードが置かれていない場所は「..」で表します。
 * 
 * 7並べのテーブルを表すクラス
 * @author wakkky05
 *
 */
public class FantanTable implements Table{

	/****************************************
		定数
	*****************************************/
	// カウンターの初期値です
	private static final int START_INDEX = 0;
	// カードの属性値を対応するインデックスに変換するための値です
	private static final int SHIFT_INDEX = -1;
	// カウンターの初期値です
	private static final int FIRST_INDEX = 0;
	// テーブルの上にカードが置かれていない箇所の文字列表現です
	private static final String EXPRESSION_CARD_NULL = "..";
	// 文字列表現を見やすくするための区切りスペースです
	private static final String DELIMITER_SPACE = " ";
	// 次のスートであることを示す改行です
	private static final String NEW_LINE = "\n";
	/****************************************
		メンバ変数
	*****************************************/
	 // カードを並べるテーブルを表す二次元配列です
	private Card[][] mTable = new Card[Card.SUIT_NUM][Card.CARD_NUM];
	/****************************************
		メソッド
	*****************************************/
	/**
	 * カードを置く
	 * 
	 * @param card カード
	 */
	public void putCard(Card[] card){
		/**
		 * 解答① この部分を実装
		 */
		// カードの枚数を確認する
		int numberOfCards = card.length;
		// 各カードを確認していきます
		for(int cardCount = START_INDEX; cardCount < numberOfCards; cardCount++){
			// 各カードのスートを確認します
			int suitOfCard = card[cardCount].getSuit();				 
			// 各カードの数字を確認します
			int valueOfCard = card[cardCount].getNumber();				 
			// テーブル上にカードが置けるか
			mTable[suitOfCard + SHIFT_INDEX][valueOfCard + SHIFT_INDEX] = card[cardCount];
		}
	}
	
	/**
	 * カードを見る
	 * 
	 * @return テーブルに置かれたカードを表す配列
	 */
	public Card[][] getCards(){
		/**
		 * 解答② この部分を実装
		 */
		// テーブル上のカードのコピーを作成するための変数です
		Card[][] copyCards = new Card[Card.SUIT_NUM][Card.CARD_NUM];
		// テーブル上のカードの状況をコピーする
		for(int suitCount = START_INDEX; suitCount < Card.SUIT_NUM; suitCount++){
			System.arraycopy(mTable[suitCount], FIRST_INDEX, copyCards[suitCount], FIRST_INDEX, Card.CARD_NUM);
		}
		return copyCards;
	}
	
	/**
	 * テーブルを文字列で表現する
	 * ObjectクラスのtoStringメソッドをオーバライドしたメソッド
	 * 
	 * @return テーブルの文字列表現
	 */
	@Override public String toString(){
		/**
		 * 解答③ この部分を実装
		 */
		// テーブルの文字列表現を設定する変数です
		StringBuffer expressionString = new StringBuffer();
		// テーブルの各スートの列について確認していく
		for(int suitCount = START_INDEX; suitCount < Card.SUIT_NUM; suitCount++){
			// 各数字があればそのカード情報を、なければ仕様通り .. を表示する
			for(int cardCount = START_INDEX; cardCount < Card.CARD_NUM; cardCount++){
				// カードが存在する場合の処理を行う
				if(mTable[suitCount][cardCount] != null){
					// カードの文字列表現を設定します
					expressionString.append(mTable[suitCount][cardCount]);
				// カードが存在しない場合の処理を行う
				}else {
					// 表示仕様通り .. を表示するように設定する
					expressionString.append(EXPRESSION_CARD_NULL);
				}
				// 表示を見やすくするための区切りスペースを設定する
				expressionString.append(DELIMITER_SPACE);
			}
			// 次のスート列だとわかるように開業を設定する
			expressionString.append(NEW_LINE);
		}
		// 作成したテーブルの文字列表現を返します
		return expressionString.toString();
	}
}
