package oldmaid2;

import static oldmaid2.OldMaidConstants.*;

import java.util.Random;

import cardgame.*;


/**
 * ババ抜きのプレーヤクラスです
 * @author wakkky05
 *
 */
public class OldMaidPlayer extends Player{
	/*****************************************
		コンストラクラ
	******************************************/
	/**
	 * 以下4つの引数で初期化します
	 * 
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 * @param rule ルール
	 */
	public OldMaidPlayer(String name, Master master, Table table, Rule rule){
		// 以下引数でインスタンスを作成します
		super(name, master, table, rule);
	}
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * 1 カードを一枚引く
	 * 2 カードを手札に加える
	 * 3 カードが捨てられるか確認する
	 * 4 捨てられる場合は捨てる
	 * 実際の処理はサブクラスで記述すること
	 * ※指名された時に行う処理はゲームによって異なるため
	 * 
	 * @param nextPlayer 次のプレーヤー
	 */
	public void play(Player nextPlayer){
		OldMaidPlayer nextOldMaidPlayer = (OldMaidPlayer)nextPlayer;
		// 次のプレーヤーの手札を取得します
		Hand nextHand = ((OldMaidPlayer)nextOldMaidPlayer).showHand();
		// 相手の手札から一枚引く
		Card pickedCard = nextHand.pickedCard(FIRST_INDEX);
		// 引いたカードを自分の手札に加える
		mHand.addCard(pickedCard);
		// 引いた結果を表示
		System.out.printf(FORMAT_OUTPUT_DETAIL_PICK, this.toString(), nextOldMaidPlayer.toString(), pickedCard.toString());
		// 手札から捨てられるカードがあった場合取得する(なければnull)
		Card[] candidateCards = mRule.findCandidateCard(mHand, mTable);
		// 捨てられるカードがあった場合の処理を行う
		if( candidateCards[FIRST_INDEX] != null ){
			mTable.putCard(candidateCards);
		}
		// 手札が0になったかどうか調べる
		if(mHand.getNumberOfCards() == NOT_IS_CARD){
			// 0だったらアガリを伝える
			mMaster.declareWin(this);
		// 手札がまだある場合の処理を行う
		} else {
			// 現在の手札を表示する
			System.out.printf(FORMAT_OUTPUT_NOW_HAND, this.toString(), mHand.toString());
		}
	}
	/**
	 * カードを配る
	 * カードを受け取った時の処理を拡張したい場合は
	 * 本メソッドをサブクラスでオーバーライドすること
	 * 
	 * @param card 受け取ったカード
	 */
	public void receiveCard(Card card){
		// 受け取ったカードを手札に加える
		mHand.addCard(card);
		// 今加えたカードと同じ数のカードを探す
		Card[] sameCards = mRule.findCandidateCard(mHand, mTable);
		// 同じカードの組み合わせが存在した場合
		if(  sameCards[0] != null ){
			// テーブルへカードを捨てる際のメッセージを出力する
			System.out.printf(FORMAT_MESSAGE_DISPOSE_CARD, this);
			// テーブルへカードを捨てる
			mTable.putCard(sameCards);
		}
	}
	/**
	 * 手札を渡す
	 * 
	 */
	public Hand showHand(){
		// 残り一枚の場合は相手にカードを渡した時点で上がり宣言する
		if( mHand.getNumberOfCards() == NUMBER_OF_LAST_ONE ){
			// 進行役にアガリを伝える
			mMaster.declareWin(this);
		}
		/**  見せる前に手札をシャッフルする **/
		// カードを抜き出す位置を設定する変数です
		int pickPosition;
		// 手札の枚数を取得します
		int numberOfCards = mHand.getNumberOfCards();
		// カードをランダムで抜き取るためのオブジェクトを作成します
		Random pickerHandOfCard = new Random();
		// カードをランダムで抜き取って最後に加える処理を行います
		for(int shuffleCount = START_INDEX; shuffleCount < numberOfCards; shuffleCount++){
			// カードを抜き取る位置をランダムで決定します
			pickPosition = pickerHandOfCard.nextInt(numberOfCards);
			// 設定した位置のカードを削除して、一番後ろに追加し直します
			mHand.addCard( mHand.pickedCard(pickPosition) );
		}
		

		// 手札を返す
		return mHand;
	}
}
		
