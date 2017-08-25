package kensyu03;


import rockpaperscissors.*;

/*
 * ジャンケンの手の出し方をインターフェースで実装したプレーヤーでジャンケンができるか検証するクラス
 */
public class E5_1_CheckJudgeClassWithTactics {
	public static final String MURATA_PLAYER_NAME = "村田さん";
	public static final String YAMADA_PLAYER_NAME = "山田さん";
	/**
	 * 審判とプレーヤを作成し、動作を確認します
	 */
	public static void main(String[] arg){
		// 審判を作成します
		Judge testJadge = new Judge();
		// 一人目のプレーヤーに村田クラス作成します
		Player murataPlayer = new Player(MURATA_PLAYER_NAME);
		// 二人目のプレーヤーに山田クラス作成します
		Player yamadaPlayer = new Player(YAMADA_PLAYER_NAME);
		// 村田プレーヤーの戦略を作成します
		Tactics murataTactics = new RamdomTactics();
		// 山田プレーヤーの戦略を作成します
		Tactics yamadaTactics = new RamdomTactics();
		// 村田プレーヤーに戦略を設定します
		murataPlayer.setTactics(murataTactics);
		// 山田プレーヤーに戦略を設定します
		yamadaPlayer.setTactics(yamadaTactics);
		
		
		// ジャンケンを開始します
		testJadge.startJanken(murataPlayer, yamadaPlayer);
	}
}
