package cardgame;

/**
 * ジョーカーを表すクラス
 * ジョーカーを判定する方法を数字やスートで設定するより
 * 別のクラスにすることで判別することにする
 * また、オールマイティカードとしての利用もあるため
 * 数字、スートを自由に変更できることにする
 * 
 * @see Card カードクラスの継承
 * @author wakkky05
 *
 */
public class Joker extends Card{
	/*****************************************
		定数
	******************************************/
	// トランプのジョーカーを示す文字です
	private static final String CARACTER_OF_JOKER = "JK";
	/*****************************************
		コンストラクタ
	******************************************/
	/**
	 * デフォルトでは
	 * 数字0, スート0
	 */
	public Joker(){
		// スートと数字にジョーカーのデフォルト値を設定します
		super(0,0);
	}
	/*****************************************
		メソッド
	******************************************/
	/**
	 * 数を変更する
	 * 
	 * @param number 数
	 */
	public void setNumber(int number){
		// 数字を変更します
		mNumber = number;
	}
	/**
	 * スートを変更する
	 * 
	 * @param suit スート
	 */
	public void setSuit(int suit){
		// スートを変更します
		mSuit = suit;
	}
	/**
	 * カードを文字列表現する
	 * toStringオーバライド
	 * ジョーカー用の表現を設定しています
	 * 
	 * @return カードの文字列表現
	 */
	public String toString(){
		// ジョーカーの文字列表現を返します
		return CARACTER_OF_JOKER;
	}
}
