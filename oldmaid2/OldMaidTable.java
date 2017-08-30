package oldmaid2;

import static oldmaid2.OldMaidConstants.*;
import cardgame.Card;
import cardgame.Table;

/**
 * ババ抜きのテーブルクラスです
 * @author wakkky05
 *
 */
public class OldMaidTable implements Table{
	/****************************************
		定数
	*****************************************/
	private static final int JOKER_NUM = 1;
	private static final int MAKING_VALUE_FIRST_INDEX = 1;
	/****************************************
		メンバ変数
	*****************************************/
	 // 捨てられたカードを保持するメンバ変数です  (53枚格納)
	private Card[][] mTable = new Card[MAKING_VALUE_FIRST_INDEX][Card.CARD_NUM * Card.SUIT_NUM + JOKER_NUM];
	// 捨てられた枚数を記録するメンバ変数です
	private int mNumberOfDrop = FIRST_INDEX;
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * カードを置く
	 * 置かれたカードの扱いはサブクラスに任せる
	 * 
	 * @param card カードの配列 
	 */
	public void putCard(Card[] card){
		// 置く対象のカードの数を確認する
		int numberOfCards = card.length;
		// 各カードを一枚ずつテーブルに置いていく
		for(int cardCount = START_INDEX; cardCount < numberOfCards; cardCount++){
			mTable[ FIRST_INDEX ][ mNumberOfDrop ] = card[ cardCount ];
			// 捨てた枚数を数えておきます
			mNumberOfDrop++;
		}

		// 置いたカードをそれぞれ表示します
		for(int cardCount = START_INDEX; cardCount < NUMBER_OF_SET_PAIR; cardCount++){
			System.out.printf(card[cardCount] + DELIMITER_SPACE);
		}
		// カードを捨てた際のメッセージを表示します
		System.out.println(MESSAGE_DROP_CARDS);
	}
	/**
	 * カードを見る
	 * 
	 * @return 置かれた各カードの文字列表現
	 */
	public Card[][] getCards(){
		// テーブル上のカードのコピーを作成するための変数です
		Card[][] copyCards = new Card[MAKING_VALUE_FIRST_INDEX][Card.CARD_NUM * Card.SUIT_NUM + JOKER_NUM];
		// テーブル上のカードの状況をコピーする
		for(int cardCount = START_INDEX; cardCount < mNumberOfDrop; cardCount++){
			// 各カードをコピーします
			copyCards[FIRST_INDEX][cardCount] = mTable[FIRST_INDEX][cardCount];
		}
		// コピーしたカードを返します
		return copyCards;
	}
}
