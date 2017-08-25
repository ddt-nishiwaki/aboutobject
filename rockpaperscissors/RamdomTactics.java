package rockpaperscissors;

public class RamdomTactics implements Tactics{
	/****************************
	じゃんけんの手を表す定数
	/****************************/
	// グーを表す値です
	public static final int NUMBER_OF_ROCK = 0;
	// チョキを表す値です
	public static final int NUMBER_OF_SCISSORS = 1;
	// パーを表す値です
	public static final int NUMBER_OF_PAPER = 2;

	/**
	 * プレイヤーに戦略を渡す
	 * 
	 * @param tactics 戦略
	 */
	public int readTactics(){
		// 手の値を設定する変数です
		int playerHand = 0;
		// 手を決定するために0以上3未満の少数として乱数を得る
		double handDecider = Math.random() * 3;
		// グーと判定して処理を行う
		if( handDecider < 1 ){
			// プレーヤーの手をグーに設定する
			playerHand = NUMBER_OF_ROCK;
		} else if ( handDecider < 2 ){
			// プレーヤーの手をチョキに設定する
			playerHand = NUMBER_OF_SCISSORS;
		} else if ( handDecider < 3 ){
			// プレーヤーの手をパーに設定する
			playerHand = NUMBER_OF_PAPER;
		}
		// 設定した手を返す
		return playerHand;

	}

}
