package oldmaid2;

import static oldmaid2.OldMaidConstants.*;
import cardgame.Card;
import cardgame.Hand;
import cardgame.Rule;
import cardgame.Table;
/**
 * i
 * @author wakkky05
 *
 */
public class OldMaidRule implements Rule{
	/*****************************************
		実装メソッド
	******************************************/
	/**
	 * テーブルに置けるカードを探す
	 * 手札とテーブルから出しうるカードの組み合わせを見つける
	 * 
	 * @param hand 手札
	 * @param table テーブル
	 * @return 見つかったカードの組み合わせ。ない場合はNULL
	 */
	public Card[] findCandidateCard(Hand hand, Table table ){
		// 手札の枚数を取得します
		int numberOfCards = hand.getNumberOfCards();
		// テーブルへ捨てるカードのペアを設定する変数です
		Card[] pairOfDropCard = new Card[NUMBER_OF_SET_PAIR];

	
		// 手札にカードが一枚もない場合は何もしない
		if(numberOfCards > 0){
			// 追加されたカードを確認するために手札の一番後ろのカードを取得します
			Card addedCard = hand.getCard(numberOfCards + SHIFT_INDEX);
			// 追加されたカードの数字を確認します
			int numberOfAddedCard = addedCard.getNumber();
		
			
			// 同じ数字のカードがあったら捨てるカードとして設定します
			for(int cardCount = START_INDEX; cardCount < numberOfCards + IGNORE_LAST_INDEX; cardCount++){
				// 比較のために各カードを取得します
				Card eachCard = hand.getCard(cardCount);
				// 取得したカードの数値を確認します
				int numberOfEachCard = eachCard.getNumber();
				// 追加したカードと現在のカードの数字が同じ場合の処理を行います
				if(numberOfAddedCard == numberOfEachCard){
					// 追加したカードを捨てるカードに設定します
					pairOfDropCard[FIRST_CARD_OF_PAIR] = hand.pickedCard(numberOfCards + SHIFT_INDEX);
					// 現在のカードを捨てるカードに設定します
					pairOfDropCard[SECOND_CARD_OF_PAIR] = hand.pickedCard(cardCount);
					// ペアが見つかったらその場で処理を抜けます
					break;
				}
			}
		}
		// 同じ数字があればそのカードのペアを、なければNULLを返します
		return pairOfDropCard;
	}
}
