package oldmaid;

import java.util.ArrayList;
import java.util.Random;

/**
 * ババ抜きの手札を表すクラス
 * @author wakkky05
 *
 */
public class Hand {
	/**********************************
		定数
	**********************************/
	// 最初のインデックスを示す値です
	private static final int START_INDEX = 0;
	// インデックスを表す値に変換するための値です
	private static final int SHIFT_INDEX = -1;
	// カードのペアを設定する際の値です
	private static final int NUMBER_OF_SET_PAIR = 2;
	// 1枚目のカードを設定するための値です
	private static final int FIRST_CARD_OF_PAIR = 0;
	// 2枚目のカードを設定するための値です
	private static final int SECOND_CARD_OF_PAIR = 1;
	// 文字列の区切りとなる半角スペースです
	private static final String DELIMITER_SPACE  = " ";
	/**********************************
		メンバ変数
	**********************************/
	// 手札のカードリストを示すフィールドです
	private ArrayList handOfCards = new ArrayList();
	/**********************************
		メソッド
	**********************************/
	/**
	 * カードを加えます
	 * 
	 * @param card 加えるカード
	 */
	public void addCard(Card card){
		// カードを手札に追加します
		handOfCards.add(card);
	}
	/**
	 * カードを引く
	 * 
	 * @return 引いたカード
	 */
	public Card pickCard(){
		// 手札の先頭のカードを削除して、返値として渡します
		return (Card)handOfCards.remove(START_INDEX);
	}
	/**
	 * シャッフルする
	 */
	public void shuffleCard(){
		// カードを抜き出す位置を設定する変数です
		int pickPosition;
		// 手札の枚数を取得します
		int numberOfCards = handOfCards.size();
		// カードをランダムで抜き取るためのオブジェクトを作成します
		Random pickerHandOfCard = new Random();
		// カードをランダムで抜き取って最後に加える処理を行います
		for(int shuffleCount = START_INDEX; shuffleCount < numberOfCards; shuffleCount++){
			// カードを抜き取る位置をランダムで決定します
			pickPosition = pickerHandOfCard.nextInt(numberOfCards);
			// 設定した位置のカードを削除して、一番後ろに追加し直します
			handOfCards.add( (Card)handOfCards.remove(pickPosition) );
		}
	}
	/**
	 * 枚数を数える
	 * 
	 * @return 枚数
	 */
	public int getNumberOfCards(){
		// 手札の枚数を返す
		return handOfCards.size();
	}
	/**
	 * 同じ数のカードを探す
	 * 同じ数のカードがない場合はNULLを返します
	 */
	public Card[] findSameNumberCard(){
		// 手札の枚数を取得します
		int numberOfCards = handOfCards.size();
		// テーブルへ捨てるカードのペアを設定する変数です
		Card[] pairOfDropCard = new Card[NUMBER_OF_SET_PAIR];

	
		// 手札にカードが一枚もない場合は何もしない
		if(numberOfCards > 0){
			// 最後に追加されたカードの位置を取得する
			int lastIndex = getNumberOfCards() + SHIFT_INDEX;
			// 追加されたカードを確認するために手札の一番後ろのカードを取得します
			Card addedCard = (Card)handOfCards.get( lastIndex );
			// 追加されたカードの数字を確認します
			int numberOfAddedCard = addedCard.getNumber();
		
			// 同じ数字のカードがあったら捨てるカードとして設定します
			for(int cardCount = START_INDEX; cardCount < lastIndex; cardCount++){
				// 比較のために各カードを取得します
				Card eachCard = (Card)handOfCards.get(cardCount);
				// 取得したカードの数値を確認します
				int numberOfEachCard = eachCard.getNumber();
				// 追加したカードと現在のカードの数字が同じ場合の処理を行います
				if(numberOfAddedCard == numberOfEachCard){
					// 追加したカードを捨てるカードに設定します
					pairOfDropCard[FIRST_CARD_OF_PAIR] = (Card)handOfCards.remove(lastIndex);
					// 現在のカードを捨てるカードに設定します
					pairOfDropCard[SECOND_CARD_OF_PAIR] = (Card)handOfCards.remove(cardCount);
					// ペアが見つかったらその場で処理を抜けます
					break;
				}
			}
		}
		// 同じ数字があればそのカードのペアを、なければNULLを返します
		return pairOfDropCard;
	}
	/**
	 * 手札のカードを文字列で表現する
	 * 
	 * @return カードリストの各カードの文字列表現
	 */
	@Override public String toString(){
		// 各カードの文字表現を出力用文字列に設定する変数です
		StringBuffer expressionCards = new StringBuffer();
		// 各カードを表示するために手札の枚数を取得します
		int numberOfCards = handOfCards.size();
		// 手札に枚数がある場合は各カードを確認します
		for(int cardCount = START_INDEX; cardCount < numberOfCards; cardCount++){
			// 各カードを確認のため取得します
			Card eachCard = (Card)handOfCards.get(cardCount);
			// 出力用文字表現に追加していきます
			expressionCards.append(eachCard);
			// 区切り用のスペースを追加します
			expressionCards.append(DELIMITER_SPACE);
		}
		// 設定した文字表現を返します
		return expressionCards.toString();
	}
	
	
}
