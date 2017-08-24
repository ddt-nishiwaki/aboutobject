package kensyu03;

import rockpaperscissors.Judge;
import rockpaperscissors.Player;
import rockpaperscissors.Yamada;
import rockpaperscissors.Murata;

/*
 * Playerクラスの名前だけ Murata と Yamada に変えて作成したクラスで
 * じゃんけんが実行できるかどうかを試すクラス
 * (結果 エラー)
 * The method startJanken(Player, Player) in the type Judge is not applicable for the arguments (Murata, Yamada)
 */
public class E4_1_ErrorJudgeClass {
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
		// 一人目のプレーヤーを村田クラス作成します
		Murata firstPlayer = new Murata(FIRST_PLAYER_NAME);
		// 一人目のプレーヤーを山田クラス作成します
		Yamada secondPlayer = new Yamada(SECOND_PLAYER_NAME);
		
		// ジャンケンを開始します
		testJadge.startJanken(firstPlayer, secondPlayer);
	}

}
