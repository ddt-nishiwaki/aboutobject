package kensyu03;

import rockpaperscissors.Judge;
import rockpaperscissors.Player;
import rockpaperscissors.PlayerYamada;
import rockpaperscissors.PlayerMurata;

/*
 * Playerを継承したプレーヤーでじゃんけんができるか検証するクラス
 */
public class E4_2_CheckJudgeClassWithExtendsPlayer {
	/**
	 * 審判とプレーヤを作成し、動作を確認します
	 */
	public static void main(String[] arg){
		// 審判を作成します
		Judge testJadge = new Judge();
		// 一人目のプレーヤーを村田クラス作成します
		Player firstPlayer = new PlayerMurata();
		// 一人目のプレーヤーを山田クラス作成します
		Player secondPlayer = new PlayerYamada();
		
		// ジャンケンを開始します
		testJadge.startJanken(firstPlayer, secondPlayer);
	}

}
