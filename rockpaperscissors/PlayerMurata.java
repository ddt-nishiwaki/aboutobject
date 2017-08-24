package rockpaperscissors;

import rockpaperscissors.Player;

/*
 * プレーヤーである村田クラスです
 */
public class PlayerMurata extends Player{
	// プレーヤーの名前設定です
	private static final String NAME_SETTING = "村田";

	/*
	 *  名前を設定するコンストラクタです
	 */
	public PlayerMurata(){
		// 名前を設定します
		super(NAME_SETTING);
	}
	
	// 手の出し方をグーだけ出すように変更します
	@Override public int showHand(){
		// 固定でグーの値を返します
		return NUMBER_OF_ROCK;
	}
}

