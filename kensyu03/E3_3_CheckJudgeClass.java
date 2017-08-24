package kensyu03;

import rockpaperscissors.Judge;
import rockpaperscissors.Player;
/*
 * 審判クラスの確認を行うクラス
 */
public class E3_3_CheckJudgeClass {
	// 一人目の確認用プレーヤ１の名前です
	public static final String FIRST_PLAYER_NAME = "ファーストプレーヤー";
	// 一人目の確認用プレーヤ２の名前です
	public static final String SECOND_PLAYER_NAME = "セカンドプレーヤー";
	
	/**
	 * 審判を作成し、動作を確認します
	 */
	public static void main(String[] arg){
		// 審判を作成します
		Judge testJadge = new Judge();
		// 一人目のプレーヤーを作成します
		Player firstPlayer = new Player(FIRST_PLAYER_NAME);
		// 一人目のプレーヤーを作成します
		Player secondPlayer = new Player(SECOND_PLAYER_NAME);
		
		// ジャンケンを開始します
		testJadge.startJanken(firstPlayer, secondPlayer);
	}

}
