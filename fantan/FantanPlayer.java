package fantan;

import cardgame.*;
import fantan.*;
/**
 * 9-4 リスト9-7(以下コード)のreceiveCardメソッドとplayメソッド(① ~ ② の部分)を実装し、
 * FantanPlayerクラスを完成させてください
 * 各メソッドの処理は以下のようなものになります。
 * 
 * ・receiveCardメソッド
 * 	受け取ったカードの数が７出会った場合は直ちにテーブルに置く。
 * 	そうでない場合は手札に追加する。
 * 
 * ・playメソッド
 * 	現在の手札からテーブルにおけるカードを探し、見つかったカードをテーブルに置く。
 * 	テーブルに置けるカードがなかった場合は進行役にパスを宣言する。
 * 	パスした解すが４回以上となった場合は負けとなるため、手持ちのカードを全てテーブルに置く。
 * 
 * 七並べ用プレイヤークラス
 * @author wakkky05
 *
 */
public class FantanPlayer extends Player {
	/*************************************
		定数
	**************************************/
	// カードの数字が 7 かどうかを調べるための値です
	private static final int FANTAN_SEVEN = 7;
	// 配列の最初のインデックスです
	private static final int FIRST_INDEX = 0;
	// カードを持っていないことを示す値です
	private static final int NOT_HAVE_CARD = 0;
	// カードを置く際のメッセージフォーマットです
	private static final String FORMAT_MESSAGE_PUT_CARD = "　%sを置きました。\n";
	// 手札を確認する際のフォーマットです
	private static final String FORMAT_OUTPUT_PLAYERS_HAND = "%sさんの手札 : %s\n";
	/*************************************
		メンバ変数
	**************************************/
	// パスした回数です
	private int mNumberOfPath;
	/*************************************
		コンストラクタ
	**************************************/
	/**
	 * 以下4つの引数で初期化します
	 * 
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 * @param rule ルール
	 */
	public FantanPlayer(String name, Master master, Table table, Rule rule){
		// 以下引数でインスタンスを作成します
		super(name, master, table, rule);
	}
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * 順番を指名する
	 * 実際の処理はサブクラスで記述すること
	 * ※指名された時に行う処理はゲームによって異なるため
	 * 
	 * @param nextPlayer 次のプレーヤー
	 */
	public void play(Player nextPlayer){
		/**
		 * 解答② この部分を実装
		 */
		// 現在の手札を表示する
		System.out.printf(FORMAT_OUTPUT_PLAYERS_HAND,mName, mHand.toString());
		// 現在の手札からテーブルに出せるものを探す
		Card[] candidate = mRule.findCandidateCard(mHand, mTable);
		// 候補がある場合はテーブルに出す
		if( candidate != null){
			// カードを取り出す
			Card candidateCard = candidate[FIRST_INDEX];
			// カードを置く際のメッセージを出力する
			System.out.printf(FORMAT_MESSAGE_PUT_CARD,candidateCard.toString());
			// テーブルにカードを置く
			mTable.putCard(candidate);
			// テーブルの状態を表示する
			System.out.println(mTable);
		// 候補がない場合の処理を行う
		} else {
			// 手札がなくなった場合の処理を行う
			if(mHand.getNumberOfCards() == NOT_HAVE_CARD){
				// 進行役に上がりを伝える
				mMaster.declareWin(this);
			// テーブルに出せない場合はパスする
			} else {
				// パス回数をカウントする
				mNumberOfPath++;
				// 進行役にパスを宣言する
				( (FantanMaster)mMaster ).pass(this);
				// パス回数が制限回数以上なら
				if(mNumberOfPath >= FantanMaster.PASS_LIMIT){
					// 手札を全てテーブルに置くために数を確認する
					int numberOfHands = mHand.getNumberOfCards();
					// 手札を全てテーブルに置く
					for(int cardCount = FIRST_INDEX; cardCount < numberOfHands; cardCount++){
						// 各カード一枚づつを全てテーブルに置く
						mTable.putCard(new Card[] { mHand.pickedCard(FIRST_INDEX) });
					}
				}
			}
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
		/**
		 * 解答①　この部分を実装
		 */
		// カードの数字が7だった場合はテーブルに置く
		if(card.getNumber() == FANTAN_SEVEN){
			// テーブルにカードを置く
			mTable.putCard(new Card[] { card });
		// それ以外だった場合手札に加える
		} else {
			// カードを手札に加える
			mHand.addCard(card);
		}
		
	}
	/*************************************
		メソッド
	**************************************/
	/**
	 * パス回数を数える
	 * 
	 * @return パス回数
	 */
	public int getPass(){
		// パス回数を返す
		return mNumberOfPath;
	}
}
