package rockpaperscissors;

import rockpaperscissors.Player;

/*
 * プレーヤーである山田クラスです
 */
public class PlayerYamada extends Player{
	// プレーヤーの名前設定です
	private static final String NAME_SETTING = "山田";

	/*
	 *  名前を設定するコンストラクタです
	 */
	public PlayerYamada(){
		// 名前を設定します
		super(NAME_SETTING);
	}
	
	// 手の出し方をパーだけ出すように変更します
	@Override public int showHand(){
		// 固定でグーの値を返します
		return NUMBER_OF_PAPER;
	}
	
	
}
