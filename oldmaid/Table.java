package oldmaid;

import java.util.ArrayList;

/**
 * カードゲームを行うテーブルを表すクラス
 * @author wakkky05
 *
 */
public class Table {
	/**********************************
		定数
	**********************************/
	// 最初のインデックスを示す値です
	private static final int START_INDEX = 0;
	// ペアをしめすカードの枚数です
	private static final int NUMBER_OF_SET_PAIR = 2;
	// カードを捨てる際のメッセージフォーマットです
	private static final String MESSAGE_DROP_CARDS = "を捨てました。";
	// 文字列を区切るためのスペースです
	private static final String DELIMITER_SPACE = " ";
	/**********************************
		メンバ変数
	**********************************/
	// 捨てられたカードを保持するフィールドです
	private ArrayList dropCards = new ArrayList();

	/**********************************
		メソッド
	**********************************/
	/**
	 * カードを捨てる
	 * 
	 * @param card 捨てるカードの配列(かならず2枚)
	 */
	public void dropCards(Card cardPair[]){

		// 捨てられたカードをそれぞれ表示します
		for(int cardCount = START_INDEX; cardCount < NUMBER_OF_SET_PAIR; cardCount++){
			System.out.printf(cardPair[cardCount] + DELIMITER_SPACE);
		}
		// カードを捨てた際のメッセージを表示します
		System.out.println(MESSAGE_DROP_CARDS);
		
		// 捨てられたカードをテーブルに保持しておく
		dropCards.add(cardPair);
	}
	/**
	 * 捨てられたカードを表示します
	 * 
	 * return カードの文字表現
	 */
	/**
	 * 捨てられたカードを保持します
	 */
}
