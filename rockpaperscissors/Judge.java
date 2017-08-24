package rockpaperscissors;

import rockpaperscissors.Player;

/**
 * ジャンケンの審判を表すクラス
 */
public class Judge {
	// カウントを出力用の値に変換するための値です
	private static final int SHIFT_OUTPUT_NUMBER = 1;
	// 処理内容を示すテキストです
	private static final String MESSAGE_PROCESS_DETAIL = "【ジャンケン開始】\n";
	// 何戦目かを表示する際のフォーマットです
	private static final String FORMAT_OUTPUT_PLAY_TIMES = "【%d回戦目です】\n";
	// 「グー」を示す値です
	private static final int NUMBER_OF_ROCK = 0;
	// 「チョキ」を示す値です
	private static final int NUMBER_OF_SCISSORS = 1;
	// 「パー」を示す値です
	private static final int NUMBER_OF_PAPER = 2;
	// 「グー」を示す文字列です
	private static final String STRING_OF_ROCK = "グー";
	// 「チョキ」を示す文字列です
	private static final String STRING_OF_SCISSORS = "チョキ";
	// 「パー」を示す文字列です
	private static final String STRING_OF_PAPER = "パー";
	// プレーヤーが勝った際のメッセージフォーマットです
	private static final String FORMAT_WINNER_PLAYER = "%sが勝ちました\n\n";
	// 引き分けの際のメッセージです
	private static final String MESSAGE_DRAW = "引き分けです\n";
	// ゲーム回数のカウンター初期値です
	private static final int INITIALIZE_COUNT = 0;
	// ゲームの回数を設定します
	private static final int NUMBER_OF_PLAYS = 3;
	// 最終的な勝ち数を比較するためのフォーマットです
	private static final String FORMAT_COMPARE_RESULT_WIN = "%d 対 %d で ";
	// 勝敗を表示する際のフォーマットです
	private static final String FORMAT_OUTPUT_RESULT_WINNER = "%s の勝ちです!\n";
	// 最終的に引き分けだったことを示すメッセージです
	private static final String MESSAGE_OUTPUT_RESULT_DRAW = "引き分けです!\n";
	// ジャンケンが終了した際のメッセージです
	private static final String MESSAGE_END_GAME = "\n【ジャンケン終了】";
	// 表示仕様にある VS. の文字列です
	private static final String STRING_VERSUS = "VS.";
	// 勝利を示す値を設定する
	private static final boolean DECISION_WINNER = true;

	/**
	 * じゃんけんを開始する
	 * 
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 */
	public void startJanken(Player player1, Player player2){
		// ジャンケンの開始を宣言する
		System.out.println(MESSAGE_PROCESS_DETAIL);
		
		// ジャンケンを3回行う
		for(int gameCount = INITIALIZE_COUNT; gameCount < NUMBER_OF_PLAYS; gameCount++){
			// 何戦目かを表示する
			System.out.printf(FORMAT_OUTPUT_PLAY_TIMES, gameCount + SHIFT_OUTPUT_NUMBER);
			
			// プレイヤーの手を見てどちらが勝ちかを判定する
			Player winner = jadgeJanken(player1, player2);
			
			// あいこでない場合の処理を行う
			if(winner != null){
				// 勝者を表示する
				System.out.printf(FORMAT_WINNER_PLAYER, (winner.getName()) );
				// 勝ったプレーヤに結果を伝える
				/*
				 * 回答３
				 */
				winner.notifyResult(DECISION_WINNER);
			} else {
				// 引き分けの場合のメッセージを出力します
				System.out.println(MESSAGE_DRAW);
			}
		}
		
		// ジャンケンの終了を宣言する
		System.out.println(MESSAGE_END_GAME);
		
		//最終的な勝者を判定する
		Player finalWinner = jadgeFinalWinner(player1, player2);
		
		// 結果の表示を行う
		System.out.printf(FORMAT_COMPARE_RESULT_WIN, (player1.getWinCount()), (player2.getWinCount()) );
		// 勝敗が引き分けじゃなかった場合の処理を行う
		if(finalWinner != null){
			// 勝者の名前を出力します
			System.out.printf(FORMAT_OUTPUT_RESULT_WINNER, (finalWinner.getName()));
		} else {
			// 引き分けであることを出力します
			System.out.println(MESSAGE_OUTPUT_RESULT_DRAW);
		}
	}
	
	/**
	 *  「ジャンケン・ポン!」と声をかけ、
	 *  プレイヤーの手を見て、どちらが勝ちかを判定する
	 *  
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 * @return 勝ったプレーヤー。引き分けの場合は null を返す
	 */
	private static Player jadgeJanken(Player player1, Player player2){
		// 勝者を設定するための変数です
		Player winner = null;

		/*
		 * 回答1
		 */
		// プレーヤ１の手を取得します
		int player1Hand = player1.showHand();
		/*
		 * 回答2
		 */
		// プレーヤ２の手を取得します
		int player2Hand = player2.showHand();
		
		// プレーヤー１の手を表示します
		printHand(player1Hand);
		// 表示仕様に沿って vs. を出力します
		System.out.print(STRING_VERSUS);
		// プレーヤー２の手を表示します
		printHand(player2Hand);
		// 表示を調整するための改行を出力します
		System.out.println();
		
		
		// プレーヤ１が勝つ場合の処理を行う
		if(
			// グー vs チョキの場合か
			(player1Hand == NUMBER_OF_ROCK && player2Hand == NUMBER_OF_SCISSORS) ||
			// チョキ vs パーの場合か
			(player1Hand == NUMBER_OF_SCISSORS && player2Hand == NUMBER_OF_PAPER) ||
			// パー vs グーの場合で判定します
			(player1Hand == NUMBER_OF_PAPER && player2Hand == NUMBER_OF_ROCK)
		) {
			// 勝者をプレーヤー１に設定します
			winner = player1;
		// プレーヤ２が勝つ場合の処理を行う
		} else if(
			// グー vs チョキの場合か
			(player2Hand == NUMBER_OF_ROCK && player1Hand == NUMBER_OF_SCISSORS) ||
			// チョキ vs パーの場合か
			(player2Hand == NUMBER_OF_SCISSORS && player1Hand == NUMBER_OF_PAPER) ||
			// パー vs グーの場合で判定します
			(player2Hand == NUMBER_OF_PAPER && player1Hand == NUMBER_OF_ROCK)
		) {
			// 勝者をプレーヤー２に設定します
			winner = player2;
		// 引き分けの場合の処理を行う
		}
		
		// 勝者を返します(引き分けの場合はnull)
		return winner;
	}
	
	/**
	 * 最終的な勝者を判定する。
	 * 
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 * @return 勝ったプレイヤー。引き分けの場合は null を返す
	 */
	private static Player jadgeFinalWinner(Player player1, Player player2){
		// 勝者を設定するための変数です
		Player winner = null;
		
		/*
		 * 回答4
		 */
		// プレーヤー１から勝ち数を取得する
		int player1WinCount = player1.getWinCount();
		/*
		 * 回答5
		 */
		// プレーヤー２から勝ち数を取得する
		int player2WinCount = player2.getWinCount();
		
		
		// 最終的にプレーヤー１がかった場合の処理を行います
		if ( player1WinCount > player2WinCount ){
			winner = player1;
		// 最終的にプレーヤー２がかった場合の処理を行います
		} else if ( player1WinCount < player2WinCount ) {
			winner = player2;
		}

		// 最終的な勝者を返す(引き分けの場合は null)
		return winner;
	}
	
	/**
	 * ジャンケンの手を表示します
	 * 
	 * @param hand ジャンケンの手
	 */
	private static void printHand(int hand){
		// 取得した手の値に応じて処理を行う
		switch(hand){
			// グーの値だった場合の処理を行う
			case NUMBER_OF_ROCK :
				// グーを出力します
				System.out.print(STRING_OF_ROCK);
				// 処理を抜けます
				break;
			// チョキの値だった場合の処理を行う
			case NUMBER_OF_SCISSORS :
				// グーを出力します
				System.out.print(STRING_OF_SCISSORS);
				// 処理を抜けます
				break;
			// グーの値だった場合の処理を行う
			case NUMBER_OF_PAPER :
				// グーを出力します
				System.out.print(STRING_OF_PAPER);
				// 処理を抜けます
				break;
			// 想定外の値だった場合の処理をおこなう
			default :
				// 処理を抜けます
				break;
		}
	}
}
