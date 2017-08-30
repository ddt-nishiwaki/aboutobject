package game;

import cardgame.Card;
import cardgame.Hand;
import cardgame.Master;
import cardgame.Player;
import cardgame.Rule;
import cardgame.Table;
import cardgame.Joker;
import oldmaid2.OldMaidMaster;
import oldmaid2.OldMaidPlayer;
import oldmaid2.OldMaidRule;
import oldmaid2.OldMaidTable;

public class OldMaidWithFrameWork {
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
		Master master = new Master();

		// テーブルの生成
		Table table = new OldMaidTable();

		// ルールの生成
		Rule rule = new OldMaidRule();

		// プレイヤーの生成
		// 村田プレーヤーを作成します
		Player murata = new OldMaidPlayer(MURATAS_NAME, master, table, rule);
		// 山田プレーヤーを作成します
		Player yamada = new OldMaidPlayer(YAMADAS_NAME, master, table, rule);
		// 斎藤プレーヤーを作成します
		Player saito  = new OldMaidPlayer(SAITOS_NAME,  master, table, rule);

		// 進行役へ村田プレイヤーを登録
		master.registerPlayer(murata);
		// 進行役へ山田プレイヤーを登録
		master.registerPlayer(yamada);
		// 進行役へ斎藤プレイヤーを登録
		master.registerPlayer(saito);

		// トランプを生成する
		Hand trump = createTrump();

		// 進行役にトランプを渡してゲームの準備をしてもらう
		master.prepareGame(trump);

		// ゲームを開始する
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
		// ジョーカーを一枚入れます
		trump.addCard( new Joker() );

		// 生成したトランプを返します
		return trump;
	}
}
