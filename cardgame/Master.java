package cardgame;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * カードゲームの進行役です
 * ゲームの準備
 * ゲーム進行
 * 
 * @author wakkky05
 *
 */
public class Master {
	/*****************************************
		定数
	******************************************/

	private static final String MESSAGE_PREPARE_GAME = "【カードを配ります】";
	private static final String MESSAGE_START_GAME = "\n【ゲームを開始します】";
	private static final String MESSAGE_END_GAME = "【ゲームを終了しました】";
	private static final String FORMAT_OUTPUT_WINNER = "%sさんが上がりました!\n";
	private static final String FORMAT_OUTPUT_LOSER = "%sさんの負けです!\n";
	private static final int START_INDEX = 0;
	private static final int NUMBER_OF_LAST_PLAYER = 1;
	private static final int SHIFT_NEXT_PLAYER = 1;
	/*****************************************
		メンバ変数
	******************************************/
	// プレーヤーを登録する変数です
	private ArrayList mPlayers = new ArrayList();
	/*****************************************
		メソッド (ゲームの準備)
	******************************************/
	/**
	 * ゲームを準備します
	 * 1 トランプをシャッフルします
	 * 2 各プレーヤーに等しく配ります
	 * 
	 * @param cards トランプを進行役の手札として渡す
	 */
	public void prepareGame(Hand cards){
		// 準備する際のメッセージを表示します
		System.out.println(MESSAGE_PREPARE_GAME);
		// トランプをシャッフルします
		cards.shuffle();
		// トランプの枚数を数えます
		int numberOfCards = cards.getNumberOfCards();
		// プレイヤーの人数を数えます
		int numberOfPlayers = mPlayers.size();
		// プレイヤーそれぞれに均等にカードを配っていきます
		for(int cardCount = START_INDEX; cardCount < numberOfCards; cardCount++){
			// カードを一枚取ります
			Card pickedCard = cards.pickedCard(START_INDEX);
			// カードがなくなるまで順番にプレーヤを対象にします
			Player targetPlayer = (Player)mPlayers.get(cardCount % numberOfPlayers);
			// 対象プレーヤーにカードを配ります
			targetPlayer.receiveCard(pickedCard);
		}
	}

	/*****************************************
		メソッド (ゲームの進行)
	******************************************/
	/**
	 * ゲームを開始します
	 * 1 プレーヤーを順番に指名します
	 */
	public void startGame(){
		System.out.println(MESSAGE_START_GAME);
		//プレイヤーの人数を確認しながらゲームを進めます
		for(int playCount = START_INDEX; mPlayers.size() < 	NUMBER_OF_LAST_PLAYER; playCount++){
			// 順にプレイヤーを指名するためのインデックスです
			int playerIndex = playCount % mPlayers.size();
			// 順に隣のプレイヤーを指名するためのインデックスです
			int nextPlayerIndex = (playCount + SHIFT_NEXT_PLAYER) % mPlayers.size();
			// 指名するプレイヤーを取得します
			Player targetPlayer = (Player)mPlayers.get(playerIndex);
			// 次のプレイヤーの取得
			Player nextPlayer = (Player)mPlayers.get(nextPlayerIndex);
			// プレイヤーを指名する(プレイしてもらう)
			targetPlayer.play(nextPlayer);
		}
		// プレーヤーが一人になったらゲーム終了メッセージを表示させる
		System.out.println(MESSAGE_END_GAME);
		
	}
	/*****************************************
		メソッド (上がりを宣言する)
	******************************************/
	/**
	 * 上がりを宣言したプレーヤーをゲームから外します
	 */
	public void declareWin(Player winner){
		// 上がったプレイヤー
		System.out.printf(FORMAT_OUTPUT_WINNER, winner.toString());
		// 上がったプレイヤーをリストから外す
		deregisterPlayer(winner);
	}
	/**
	 * ゲームに参加するプレイヤーを登録する
	 * 
	 * @param player 参加するプレイヤー
	 */
	public void registerPlayer(Player player){
		// リストに参加者を追加する
		mPlayers.add(player);
	}
	/**
	 * ゲームに参加するプレイヤーを登録から削除する
	 * 勝ったプレイヤーをゲームから抜く時に使用する
	 * 
	 * @param player 削除するプレイヤー
	 */
	public void deregisterPlayer(Player player){
		// 対象プレーヤーを登録から外す
		mPlayers.remove(mPlayers.indexOf(player));
		// 残り人数が1人になった時は敗者として表示する
		if(mPlayers.size() == NUMBER_OF_LAST_PLAYER){
			Player loser = (Player)mPlayers.get(START_INDEX);
			System.out.printf(FORMAT_OUTPUT_LOSER, loser.toString());
		}
	}
}
