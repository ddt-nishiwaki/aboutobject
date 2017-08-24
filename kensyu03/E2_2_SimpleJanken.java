package kensyu03;

/*
 * 書籍のコード例を組み合わせて
 * じゃんけんプログラムを作成します
 */
public class E2_2_SimpleJanken {
	// 処理内容を示すテキストです
	private static final String MESSAGE_PROCESS_DETAIL = "【ジャンケン開始】\n";
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
	// 「プレーヤー１」を示す文字列です
	private static final String PLAYER1 = "プレーヤー１";
	// 「プレーヤー2」を示す文字列です
	private static final String PLAYER2 = "プレーヤー２";
	// プレーヤー１が勝った際のメッセージです
	private static final String MESSAGE_WINNER_PLAYER1 = "\nプレイヤー１が勝ちました\n";
	// プレーヤー２が勝った際のメッセージです
	private static final String MESSAGE_WINNER_PLAYER2 = "\nプレイヤー２が勝ちました\n";
	// 引き分けの際のメッセージです
	private static final String MESSAGE_DRAW = "\n引き分けです\n";
	// ゲーム回数のカウンター初期値です
	private static final int INITIALIZE_COUNT = 0;
	// ゲームの回数を設定します
	private static final int NUMBER_OF_PLAYS = 3;
	// 数値型変数を 0 で初期化するための値です
	private static final int INITIALIZE_ZERO = 0;
	// 勝敗を表示するためのフォーマットです
	private static final String FORMAT_OUTPUT_RESULT_WINNER = "%d 対 %d で %s の勝ちです!\n";
	// 最終的に引き分けだったこと表示するためのフォーマットです
	private static final String FORMAT_OUTPUT_RESULT_DRAW = "%d 対 %d で 引き分けですです!\n";
	// ジャンケンが終了した際のメッセージです
	private static final String MESSAGE_END_GAME = "【ジャンケン終了】\n";
	// 表示仕様にある VS. の文字列です
	private static final String STRING_VERSUS = "VS.";
	/*
	 *  ２人のプレーヤーを作成しジャンケンを行います
	 */
	public static void main(String[] arg){
		// 乱数を格納するための変数です
		double HandDecider;
		// プレーヤ１の勝利回数をカウントする変数です
		int player1WinCount = INITIALIZE_ZERO;	
		// プレーヤ２の勝利回数をカウントする変数です
		int player2WinCount = INITIALIZE_ZERO;	
		
		// じゃんけん開始のメッセージを出力する
		System.out.println(MESSAGE_PROCESS_DETAIL);
		

		// ジャンケンを３回実行する
		for( int gameCount = INITIALIZE_COUNT; gameCount < NUMBER_OF_PLAYS; gameCount++){
			/****************************
				プレーヤ１が何を出すか決める
			*****************************/
			int player1Hand = 0;
			// 手を決定するために0以上3未満の少数として乱数を得る
			HandDecider = Math.random() * 3;
			// グーと判定して処理を行う
			if( HandDecider < 1 ){
				// プレーヤー1の手をグーに設定する
				player1Hand = NUMBER_OF_ROCK;
				// プレーヤー1の手を確認のため出力する
				System.out.print(STRING_OF_ROCK);
			} else if ( HandDecider < 2 ){
				// プレーヤー1の手をチョキに設定する
				player1Hand = NUMBER_OF_SCISSORS;
				// プレーヤー1の手を確認のため出力する
				System.out.print(STRING_OF_SCISSORS);
			} else if ( HandDecider < 3 ){
				// プレーヤー1の手をパーに設定する
				player1Hand = NUMBER_OF_PAPER;
				// プレーヤー1の手を確認のため出力する
				System.out.print(STRING_OF_PAPER);
			}
			
			// 表示仕様に沿って vs. を表示する
			System.out.print(STRING_VERSUS);
			
		
			/****************************
				プレーヤ2が何を出すか決める
			*****************************/
			int player2Hand = 0;
			// 手を決定するために0以上3未満の少数として乱数を得る
			HandDecider = Math.random() * 3;
			// グーと判定して処理を行う
			if( HandDecider < 1 ){
				// プレーヤー2の手をグーに設定する
				player2Hand = NUMBER_OF_ROCK;
				// プレーヤー2の手を確認のため出力する
				System.out.println(STRING_OF_ROCK);
			} else if ( HandDecider < 2 ){
				// プレーヤー2の手をチョキに設定する
				player2Hand = NUMBER_OF_SCISSORS;
				// プレーヤー2の手を確認のため出力する
				System.out.println(STRING_OF_SCISSORS);
			} else if ( HandDecider < 3 ){
				// プレーヤー2の手をパーに設定する
				player2Hand = NUMBER_OF_PAPER;
				// プレーヤー2の手を確認のため出力する
				System.out.println(STRING_OF_PAPER);
			}
			
			/************************************
				どちらが勝ちかを判定し、結果を表示する
			*************************************/
			
			// プレーヤ１が勝つ場合の処理を行う
			if(
				// グー vs チョキの場合か
				(player1Hand == NUMBER_OF_ROCK && player2Hand == NUMBER_OF_SCISSORS) ||
				// チョキ vs パーの場合か
				(player1Hand == NUMBER_OF_SCISSORS && player2Hand == NUMBER_OF_PAPER) ||
				// パー vs グーの場合で判定します
				(player1Hand == NUMBER_OF_PAPER && player2Hand == NUMBER_OF_ROCK)
			) {
				// プレーヤ１の勝利回数をカウントする
				player1WinCount++;
				// プレーヤ１が勝ったことを出力する
				System.out.println(MESSAGE_WINNER_PLAYER1);
			// プレーヤ２が勝つ場合の処理を行う
			} else if(
				// グー vs チョキの場合か
				(player2Hand == NUMBER_OF_ROCK && player1Hand == NUMBER_OF_SCISSORS) ||
				// チョキ vs パーの場合か
				(player2Hand == NUMBER_OF_SCISSORS && player1Hand == NUMBER_OF_PAPER) ||
				// パー vs グーの場合で判定します
				(player2Hand == NUMBER_OF_PAPER && player1Hand == NUMBER_OF_ROCK)
			) {
				// プレーヤ２の勝利回数をカウントする
				player2WinCount++;
				// プレーヤ２が勝ったことを出力する
				System.out.println(MESSAGE_WINNER_PLAYER2);
			// 引き分けの場合の処理を行う
			} else {
				// 引き分けであることを出力する
				System.out.println(MESSAGE_DRAW);
			}
		}
		
		/*****************************************
		 	最終的な勝者を判定し、画面表示する
		*****************************************/
		// じゃんけんが終了したことを出力します
		System.out.println(MESSAGE_END_GAME);
		// プレイヤー1勝ち数が多い場合の処理を行う
		if(player1WinCount > player2WinCount){
			// 勝敗の結果を出力する
			System.out.printf(FORMAT_OUTPUT_RESULT_WINNER,player1WinCount,player2WinCount,PLAYER1);
		// プレイヤー2勝ち数が多い場合の処理を行う
		} else if (player2WinCount > player1WinCount){
			// 勝敗の結果を出力する
			System.out.printf(FORMAT_OUTPUT_RESULT_WINNER,player1WinCount,player2WinCount,PLAYER2);
		// 引き分けの場合の処理を行う
		} else {
			// 結果が引き分けであることを出力する
			System.out.printf(FORMAT_OUTPUT_RESULT_DRAW,player1WinCount,player2WinCount,PLAYER2);
		}
		
		
	}
}
