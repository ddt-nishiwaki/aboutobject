package kensyu03;

import rockpaperscissors.Player;
/*
 * 演習3-2で作成したplayerクラスの確認を行うクラス
 */
public class E3_2_CheckPlayerClass {

	// プレイヤーの手を確認する際のメッセージです
	private static final String MESSAGE_CHECK_PLAYER_HAND = "(プレイヤーの手を確認します)";
	// 勝利回数を確認する際のメッセージです
	private static final String MESSAGE_CHECK_WIN_COUNT = "(勝利回数を確認します)";
	// 勝利回数を変更する際のメッセージです
	private static final String MESSAGE_NOTIFY_WIN_DICISION = "(勝利回数を変更するために勝利判定を与えます)";
	// 勝利回数がカウントされているか確認する際のメッセージです
	private static final String MESSAGE_CHECK_CHANGE_COUNT = "(勝利回数がカウントされているか確認します)";
	// 勝利回数を確認する際のフォーマットです
	private static final String FORMAT_OUTPUT_WIN_COUNT = "勝利回数 : %d 回\n";
	/*************************
		テスト設定
	**************************/
	// プレイヤーに与える勝利判定です
	private static final boolean DECISION_WIN = true;
	
	/*
	 * プレーヤクラスに設定した以下のメソッドを確認します
	 * 
	 * showHand()
	 * notifyResult()
	 * getWinCount()
	 */
	public static void main(String[] arg){
		// テストプレーヤを作成します
		Player testPlayer = new Player();

		// プレーヤーの手を確認する際のメッセージを出力します
		System.out.println(MESSAGE_CHECK_PLAYER_HAND);
		// プレーヤーの手を確認します
		testPlayer.showHand();
		// 表示をみやすくするための改行です
		System.out.println();

		// 勝利回数を確認する際のメッセージを出力します
		System.out.println(MESSAGE_CHECK_WIN_COUNT);
		// 勝利回数を確認します
		System.out.printf(FORMAT_OUTPUT_WIN_COUNT, testPlayer.getWinCount());
		// 勝利判定を与える際のメッセージを出力します
		System.out.println(MESSAGE_NOTIFY_WIN_DICISION);
		// 勝利回数を変更するために勝利判定を与えます
		testPlayer.notifyResult(DECISION_WIN);
		// 勝利回数がカウントされているか確認する際のメッセージです
		System.out.println(MESSAGE_CHECK_CHANGE_COUNT);
		// 勝利回数がカウントされているか確認します
		System.out.printf(FORMAT_OUTPUT_WIN_COUNT, testPlayer.getWinCount());
	}
}
