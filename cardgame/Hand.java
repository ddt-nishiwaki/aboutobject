package cardgame;

import java.util.ArrayList;

/**
 * カードゲームの手札クラスです
 * @author wakkky0
 *
 */
public class Hand {
	/*****************************************
		定数
	******************************************/
	// 配列の最初のインデックスを示す値です
	private static int START_INDEX = 0;
	// カードがないことを示す値です
	private static int NOT_IS_CARD = 0;
	// 表示を調整するための区切りスペースです
	private static String DELIMITER_SPACE = " ";
	/*****************************************
		メンバ変数
	******************************************/
	// 手札を構成するカードオブジェクトのリストです
	private ArrayList mHand = new ArrayList();
	/*****************************************
		メソッド
	******************************************/
	/**
	 * カードを手札に加えます
	 * @param card 加えるカード
	 */
	public void addCard(Card card){
		// カードを一番後ろに追加する
		mHand.add(card);
	}
	/**
	 * カードを見る
	 * positionは 0 から getNumberOfCards() の範囲で指定すること
	 * 
	 * @param position 手札の中での位置(インデックス) 
	 * @return position で指定されたカードオブジェクト 範囲外ではNULL
	 */
	public Card getCard(int position){
		// カードを取得するための変数です
		Card lookingCard = null;
		// 引数で指定された位置が妥当かチェックします
		if( ( START_INDEX <= position ) && ( position < mHand.size() ) ){
			// みるためのカードを設定します
			lookingCard = (Card)mHand.get(position);
		}
		// 設定したカードを返します
		return lookingCard;
	}
	/**
	 * カードを引く
	 * 引いたカードは手札から削除される
	 * 
	 * @param position 手札の中での位置(インデックス) 
	 * @return position で指定されたカードオブジェクト 範囲外ではNULL
	 */
	public Card pickedCard(int position){
		// 引くカードを設定する変数です
		Card pickedCard = null;
		// 引数の設定の妥当性チェックを行います
		if( ( START_INDEX <= position ) && ( position < mHand.size() ) ){
			// 手札から指定位置のカードを抜き、保持する
			pickedCard = (Card)mHand.remove(position);
		}
		// 引いたカードを返す(ない場合はNULL
		return pickedCard;
		
	}
	
	/**
	 * シャッフルする
	 */
	public void shuffle(){
		// カードを抜き出す位置を設定する変数です
		int position;
		// 手札の枚数を取得する
		int numberOfCards = mHand.size();
		// カードをシャッフルするために全てのカードにたいして処理を行う
		for(int cardCount = START_INDEX; cardCount < numberOfCards; cardCount++){
			// ランダムな位置を設定します
			position = (int) (Math.random() * numberOfCards);
			// 設定した位置のカードを抜き取る
			Card pickedCard = (Card)mHand.remove(position);
			// 抜き取ったカードを最後に加える
			mHand.add(pickedCard);
		}
	}
	/**
	 * 枚数を数える
	 * 
	 * @return 手札にあるカードの枚数
	 */
	public int getNumberOfCards(){
		// 手札の枚数を返します
		return mHand.size();
	}
	/**
	 * 手札にあるカードを文字列で表現する
	 * 手持ちのカードを全て toString() で表現する
	 */
	public String toString(){
		// 文字列表現を設定するための偏すです
		StringBuffer string = new StringBuffer();
		// 全てのカードを対象とするために手札の枚数を取得する
		int size = mHand.size();
		// カードを持っている場合の処理を行う
		if(size > NOT_IS_CARD){
			// 全てのカードを確認して出力用の表現に設定していきます
			for(int cardCount = START_INDEX; cardCount <  size; cardCount++){
				// 各カードを対象とします
				Card eachCard = (Card)mHand.get(cardCount);
				// 文字列にカードの文字列表現を加えます
				string.append(eachCard);
				// 次のカード表現との区切りスペースを設定します
				string.append(DELIMITER_SPACE);
			}
		}
		// 手札の出力用表現を返します
		return string.toString();
	}
}
