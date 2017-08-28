package oldmaid;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * ババ抜きの進行をするクラス
 */
public class Master {
	/**********************************
		定数
	**********************************/
	// カードを配る際のメッセージです
	private static final String MESSAGE_DEAL_CARD = "【カードを配ります】";
	private static final String MESSAGE_START_GAME = "【ババ抜きを開始します】";
	private static final String MESSAGE_END_GAME = "【ババ抜きを開始します】";
	// インデックスのカウントを 1 からの値に変換するための値です
	private static final int SHIFT_PLAYERS_NUMBER = 1;
	private static final int END_PLAYERS_NUMBER = 1;
	private static final int START_COUNT = 0;
	private static final int SHIFT_NEXT_INDEX = 1;
	private static final int FIRST_INDEX = 0;
	private static final String MESSAGE_PLAY_PLAYER = "さんの番です";
	private static final String FORMAT_OUTPUT_WINNER = "%sさんが上がりました!\n";
	private static final String FORMAT_OUTPUT_LOSER = "%sさんの負けです!\n";
	/**********************************
		メンバ変数
	**********************************/
	// プレイヤーのリストを示すフィールドです
	private ArrayList mPlayers = new ArrayList();
	/**********************************
		メソッド
	**********************************/
	/**
	 * ゲームの準備をします
	 * 
	 * @param cards 配る前のトランプ(手札扱い)
	 */
	public void prepareGame(Hand cards){
		// カードを配る際のメッセージを出力する
		System.out.println(MESSAGE_DEAL_CARD);
		// トランプをシャッフルする
		cards.shuffleCard();
		// トランプの枚数を取得する
		int numberOfCards = cards.getNumberOfCards();
		// プレイヤーの人数を取得する
		int numberOfPlayers = mPlayers.size();
		// 各プレイヤーに順番にカードを配る
		for(int indexCount = 0; indexCount < numberOfCards; indexCount++){
			// カードから1枚引く
			Card card = cards.pickCard();
			// 各プレイヤーを順番に設定します
			Player player = (Player)mPlayers.get(indexCount % mPlayers.size());
			// プレーヤーにカードを渡します
			player.receiveCard(card);
		}
	}
	/**
	 * ゲームを開始します
	 */
	public void startGame(){
		// ゲームを開始する際のメッセージを出力する
		System.out.println(MESSAGE_START_GAME);
		// プレイヤーが一人になるまでゲームを繰り返します
		for(int playCount = START_COUNT; mPlayers.size() > END_PLAYERS_NUMBER; playCount++){
			// プレイヤーを指名するための値を設定する
			int playerIndex = playCount % mPlayers.size();
			// 次に指名するプレイヤーを設定するための値を設定する
			int nextPlayerIndex = (playCount + SHIFT_NEXT_INDEX) % mPlayers.size();
			// 指名するプレイヤーの取得
			Player player = (Player)mPlayers.get(playerIndex);
			// 次のプレーヤーの取得
			Player nextPlayer = (Player)mPlayers.get(nextPlayerIndex);
			// プレーヤーを指名する際のメッセージを出力する
			System.out.println(player + MESSAGE_PLAY_PLAYER);
			// プレイヤーを指名する
			player.play(nextPlayer);
		}
		// プレーヤーが1人になったらババ抜きを終了する際のメッセージを出力する
		System.out.println(MESSAGE_END_GAME);
	}
	/**
	 * アガリを宣言します
	 * 
	 * @param winner 上がったプレーヤー
	 */
	public void declareWin(Player winner){
		// 上がったプレイヤーを表示します
		System.out.printf(FORMAT_OUTPUT_WINNER, winner.toString());
		// 上がったプレーヤーをリストから外す
		mPlayers.remove(mPlayers.indexOf(winner));
		// 残りプレイヤーが一人になった時は敗者を表示する
		if(mPlayers.size() == END_PLAYERS_NUMBER){
			// 一人になったプレイヤーを敗者に指定します
			Player loser = (Player)mPlayers.get(FIRST_INDEX);
			// 敗者を表示します
			System.out.printf(FORMAT_OUTPUT_LOSER,loser);
		}
	}
	/**
	 * ゲームに参加するプレイヤーを登録する
	 * 
	 * @param player 参加するプレーヤー
	 */
	public void registerPlayer(Player player){
		// プレーヤーリストに参加プレーヤーをを登録する
		mPlayers.add(player);
	}
}
