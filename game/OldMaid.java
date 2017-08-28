package game;

import oldmaid.*;
/**
 * ババ抜きを行うためのクラス
 * @author wakkky05
 *
 */
public class OldMaid {
	/**********************************
		定数
	**********************************/
	// 村田プレーヤーの名前です
	public static final String MURATAS_NAME = "村田";
	// 山田プレーヤーの名前です
	public static final String YAMADAS_NAME = "山田";
	// 斎藤プレーヤーの名前です
	public static final String SAITOS_NAME = "斎藤";
	// カウンターの初期値設定です
	public static final int START_COUNT = 0;
	// トランプの一番大きな数字です
	public static final int NUMBER_OF_KING = 13;
	// カードのカウンターを実際のカードの数字に変換する値です
	public static final int SHIFT_CARD_NUMBER = 1;
	
	
	/**********************************
		メインプロセス
	**********************************/
	/**
	 * ババ抜きに必要なクラスとプレーヤーを設定して
	 * ゲームをスタートします
	 */
	public static void main (String[] arg){
		// 進行役を作成します
		Master master = new Master();
		// テーブルを作成します
		Table table = new Table();
		// 村田プレーヤーを作成します
		Player murata = new Player(MURATAS_NAME, master, table);
		// 山田プレーヤーを作成します
		Player yamada = new Player(YAMADAS_NAME, master, table);
		// 斎藤プレーヤーを作成します
		Player saito = new Player(SAITOS_NAME, master, table);
		// 進行役に村田プレーヤーを登録してもらう
		master.registerPlayer(murata);
		// 進行役に山田プレーヤーを登録してもらう
		master.registerPlayer(yamada);
		// 進行役に斎藤プレーヤーを登録してもらう
		master.registerPlayer(saito);
		// トランプを作成します
		Hand trump = createTrump();
		// ゲームの準備をする
		master.prepareGame(trump);
		// ゲームを開始する
		master.startGame();
	}
	/*********************************
		メソッド
	**********************************/
	/**
	 * トランプを作成します
	 * 
	 * @return 53枚のトランプで構成したHand
	 */
	private static Hand createTrump(){
		// トランプの箱を示す変数です
		Hand trump = new Hand();
		
		// 各スート52枚のトランプを生成する
		for(int cardCount = START_COUNT; cardCount < NUMBER_OF_KING; cardCount++){
			// スペードの 1 ~ 13 をトランプの箱に入れる
			trump.addCard(new Card(Card.VALUE_OF_SPADE, cardCount + SHIFT_CARD_NUMBER));
			// ハートの 1 ~ 13 をトランプの箱に入れる
			trump.addCard(new Card(Card.VALUE_OF_HEART, cardCount + SHIFT_CARD_NUMBER));
			// ダイヤの 1 ~ 13 をトランプの箱に入れる
			trump.addCard(new Card(Card.VALUE_OF_DIAMOND, cardCount + SHIFT_CARD_NUMBER));
			// クラブの 1 ~ 13 をトランプの箱に入れる
			trump.addCard(new Card(Card.VALUE_OF_CLUB, cardCount + SHIFT_CARD_NUMBER));
		}
		// ジョーカーを1枚追加する
		trump.addCard(new Card(Card.VALUE_OF_JOKER, Card.VALUE_OF_JOKER));
		
		// 作成したトランプを返す
		return trump;

	}
	

}
