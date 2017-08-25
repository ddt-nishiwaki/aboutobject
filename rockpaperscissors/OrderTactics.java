package rockpaperscissors;

/**
 * 
 * ジャンケンにおいて
 * グー、チョキ、パーと順番に出す戦略ロジックです
 * 
 * @author wakkky05
 *
 */
public class OrderTactics implements Tactics{
	/****************************
		定数
	*****************************/
	// ジャンケンの手の種類です
	private static final int NUMBER_OF_TYPE_HANDS = 3;
	// カウンターの初期値です
	private static final int NUMBER_START_COUNT = 0;
	 
	/****************************
		メンバ変数
	*****************************/
	private int playTimes;		// ゲーム回数をカウントする変数です

	/****************************
		初期化子
	*****************************/
	{
		// プレイ回数のカウントに初期値をセットします
		playTimes = NUMBER_START_COUNT;
	}
	/**
	 * 実行するたびに以下順番でジャンケンの手を設定して返します
	 * 1. グー
	 * 2. チョキ
	 * 3. パー
	 */
	public int readTactics(){
		// ジャンケンの手を設定する変数です
		int handOfGame;
		
		// ジャンケンの手を現在のプレイ回数に応じて設定します
		handOfGame = playTimes % NUMBER_OF_TYPE_HANDS;

		// プレイ回数をカウントします
		playTimes++;
		
		// 設定したジャンケンの手を返します
		return handOfGame;
	}
}
