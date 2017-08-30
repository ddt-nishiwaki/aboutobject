package fantan;

import cardgame.Master;

/**
 * 7並べ用進行役クラス
 * @author wakkky05
 *
 */
public class FantanMaster extends Master{
	
	/*****************************************
		定数
	******************************************/
	// パスできる制限回数
	public static final int PASS_LIMIT = 3;
	// パスした際の回数確認フォーマットです
	public static final String FORMAT_OUTPUT_PATH_TIMES = "　%s さんは %d 回目のパスをしました!\n";
	/*****************************************
		メソッド
	******************************************/
	/**
	 * パスを宣言する
	 * 
	 * @param player パスするプレイヤー
	 */
	public void pass(FantanPlayer player){
		// 何回パスしたかを表示する
		System.out.printf(FORMAT_OUTPUT_PATH_TIMES, player.toString(), (player.getPass()) );
	}
}
