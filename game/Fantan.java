package game;

import cardgame.*;
import fantan.*;

/**
 * 9-5
 * リスト9-10(以下コード)のmainメソッドにコメント文を参考にして必要な処理 ① ~ ⑧ をつかし、
 * 七並べプログラムを完成させてください。
 * また、完成したプログラムをコンパイル・実行して動作を確認してください。
 * なお、プレイヤーは「村田さん」「山田さん」「斎藤さん」の3名が参加するものとします。
 * 
 * 七並べを行うプログラム
 * @author wakkky05
 *
 */
public class Fantan {
	/****************************************
		メンバ変数
	*****************************************/
	// 配列の最初のインデックスです
	private static final int FIRST_INDEX = 0;
	// インデックスを実際のカード数字に変換するための値です
	private static final int SHIFT_CARD_NUMBER = 1;
	// 村田プレーヤーの名前です
	public static final String MURATAS_NAME = "村田";
	// 山田プレーヤーの名前です
	public static final String YAMADAS_NAME = "山田";
	// 斎藤プレーヤーの名前です
	public static final String SAITOS_NAME = "斎藤";
	/****************************************
		メインプロセス
	*****************************************/
	/**
	 * カードゲームフレームワークをりようした
	 * 七並べプログラムを実行します
	 * @param arg
	 */
	public static void main(String[] arg){
		// 進行役の生成
		/**
		 * ① この部分を実装
		 */
		Master master = new FantanMaster();

		// テーブルの生成
		/**
		 * ② この部分を実装
		 */
		Table table = new FantanTable();

		// ルールの生成
		/**
		 * ③ この部分を実装
		 */
		Rule rule = new FantanRule();

		// プレイヤーの生成
		/**
		 * ④ この部分を実装
		 */
		// 村田プレーヤーを作成します
		Player murata = new FantanPlayer(MURATAS_NAME, master, table, rule);
		// 山田プレーヤーを作成します
		Player yamada = new FantanPlayer(YAMADAS_NAME, master, table, rule);
		// 斎藤プレーヤーを作成します
		Player saito  = new FantanPlayer(SAITOS_NAME,  master, table, rule);

		// 進行役へプレイヤーを登録
		/**
		 * ⑤ この部分を実装
		 */
		// 進行役へ村田プレイヤーを登録
		master.registerPlayer(murata);
		// 進行役へ山田プレイヤーを登録
		master.registerPlayer(yamada);
		// 進行役へ斎藤プレイヤーを登録
		master.registerPlayer(saito);

		// トランプを生成する
		/**
		 * ⑥ この部分を実装
		 */
		Hand trump = createTrump();

		// ゲームの準備をする
		/**
		 * ⑦ この部分を実装
		 */
		// 進行役にトランプを渡してゲームの準備をしてもらう
		master.prepareGame(trump);

		// ゲームを開始する
		/**
		 * ⑧ この部分を実装
		 */
		master.startGame();
	}
	
	/****************************************
		メソッド
	*****************************************/
	/**
	 * 53枚のトランプを生成する
	 * 
	 * @return トランプを格納したDeal
	 */
	private static Hand createTrump(){
		// トランプを格納する変数です
		Hand trump = new Hand();
		// 各スート53枚のカードを生成する
		for(int cardCount = FIRST_INDEX; cardCount < Card.CARD_NUM; cardCount++){
			// クラブのカードを 1 ~ 13 まで作成してトランプの箱に入れます
			trump.addCard(new Card(Card.SUIT_CLUB, cardCount + SHIFT_CARD_NUMBER));
			// ダイヤのカードを 1 ~ 13 まで作成してトランプの箱に入れます
			trump.addCard(new Card(Card.SUIT_DIAMOND, cardCount + SHIFT_CARD_NUMBER));
			// ハートのカードを 1 ~ 13 まで作成してトランプの箱に入れます
			trump.addCard(new Card(Card.SUIT_HEART, cardCount + SHIFT_CARD_NUMBER));
			// スペードのカードを 1 ~ 13 まで作成してトランプの箱に入れます
			trump.addCard(new Card(Card.SUIT_SPADE, cardCount + SHIFT_CARD_NUMBER));
		}

		// 生成したトランプを返します
		return trump;
	}
}
