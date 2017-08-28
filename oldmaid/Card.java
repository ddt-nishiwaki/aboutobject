package oldmaid;

/**
 * トランプのカードクラス
 * @author wakkky05
 *
 */
public class Card {
	/**********************************
		定数	
	**********************************/
	// トランプのジョーカーを示す値です
	public static final int VALUE_OF_JOKER = 0;
	// トランプのスペードを示す値です
	public static final int VALUE_OF_SPADE = 1;
	// トランプのダイヤを示す値です
	public static final int VALUE_OF_DIAMOND = 2;
	// トランプのクラブを示す値です
	public static final int VALUE_OF_CLUB = 3;
	// トランプのハートを示す値です
	public static final int VALUE_OF_HEART = 4;
	// トランプのジョーカーを示す文字です
	private static final String CARACTER_OF_JOKER = "JK";
	// トランプのスペードを示す文字です
	private static final String CARACTER_OF_SPADE = "S";
	// トランプのダイヤを示す文字です
	private static final String CARACTER_OF_DIAMOND = "D";
	// トランプのクラブを示す文字です
	private static final String CARACTER_OF_CLUB = "C";
	// トランプのハートを示す文字です
	private static final String CARACTER_OF_HEART = "H";
	// スートの値に対応する文字表現です
	private static final String[] CHARACTER_OF_SUIT = {
		CARACTER_OF_JOKER,			// 0 はジョーカーです
		CARACTER_OF_SPADE,			// 1 はスペードです
		CARACTER_OF_DIAMOND,		// 2 はダイヤです
		CARACTER_OF_CLUB,			// 3 はクラブです
		CARACTER_OF_HEART			// 4 はハートです
	};
	// カードの数字 1 に対応する値です
	private static final int CARD_NUMBER_ONE = 1; 
	// カードの数字 10 に対応する値です
	private static final int CARD_NUMBER_TEN = 10; 
	// カードの数字 11 に対応する値です
	private static final int CARD_NUMBER_ELEVEN = 11; 
	// カードの数字 12 に対応する値です
	private static final int CARD_NUMBER_TWELVE = 12; 
	// カードの数字 13 に対応する値です
	private static final int CARD_NUMBER_THIRTEEN = 13; 
	// 1を示す文字表現です
	private static final String CHARACTER_CARD_NUMBER_ONE = "A"; 
	// 10を示す文字表現です
	private static final String CHARACTER_CARD_NUMBER_TEN = "T"; 
	// 11を示す文字表現です
	private static final String CHARACTER_CARD_NUMBER_ELEVEN = "J"; 
	// 12を示す文字表現です
	private static final String CHARACTER_CARD_NUMBER_TWELVE = "Q"; 
	// 13を示す文字表現です
	private static final String CHARACTER_CARD_NUMBER_THIRTEEN = "K"; 
	/**********************************
		メンバ変数	
	**********************************/
	// スートを表すフィールドです
	private int mSuit;
	// 数字を表すフィールドです
	private int mNumber;
	/**********************************
		コンストラクタ	
	**********************************/
	/**
	 * 数字とスートを設定してカードを作成します
	 * 
	 * @param suit スート
	 * @param number 数字(0の場合はジョーカーを表します)
	 */
	public Card(int suit, int number){
		// スートを設定します
		mSuit = suit;
		// 数字を設定します
		mNumber = number;
	}
	/**********************************
		メソッド
	**********************************/
	/**
	 * 数字を確認する
	 * 
	 * @return 数字
	 */
	protected int getNumber(){
		// 数字を返します
		return mNumber;
	}
	/**
	 * カードを文字列で表現する
	 * 
	 * @return カードの文字列表現
	 */
	@Override public String toString(){
		// カードを示す文字表現を設定する変数です
		StringBuffer cardExpression = new StringBuffer();
		// スート設定から文字を設定します
		cardExpression.append(getSuitExpression());
		// 数字設定から文字を設定します
		cardExpression.append(getNumberExpression());
		// カードを示す文字表現として返す
		return cardExpression.toString();
	}
	/**
	 * スートを示す文字を返します
	 * 
	 * @return スートの文字表現
	 */
	protected String getSuitExpression(){
		// スート設定に対応する文字表現を返します
		return CHARACTER_OF_SUIT[mSuit];
	}
	/**
	 * トランプでの数字表現を返します
	 * 1 なら A
	 * 11 なら J
	 * 12 なら Q
	 * 13 なら K
	 * それ以外なら そのまま数字として表現
	 * 
	 * @return トランプでの数字表現
	 */
	protected String getNumberExpression(){
		// 数字表現を設定する変数です
		String cardNumber;
		// 数字の設定に対応する表現を設定します
		switch (mNumber){
			// 数字が 1 の場合の設定を行います
			case CARD_NUMBER_ONE :
				// 1 をしめす文字を設定します
				cardNumber = CHARACTER_CARD_NUMBER_ONE;
				// 処理を抜けます
				break;
			// 数字が 10 の場合の設定を行います
			case CARD_NUMBER_TEN :
				// 10 をしめす文字を設定します
				cardNumber = CHARACTER_CARD_NUMBER_TEN;
				// 処理を抜けます
				break;
			// 数字が 11 の場合の設定を行います
			case CARD_NUMBER_ELEVEN :
				// 11 をしめす文字を設定します
				cardNumber = CHARACTER_CARD_NUMBER_ELEVEN;
				// 処理を抜けます
				break;
			// 数字が 12 の場合の設定を行います
			case CARD_NUMBER_TWELVE :
				// 12 をしめす文字を設定します
				cardNumber = CHARACTER_CARD_NUMBER_TWELVE;
				// 処理を抜けます
				break;
			// 数字が 13 の場合の設定を行います
			case CARD_NUMBER_THIRTEEN :
				// 13 をしめす文字を設定します
				cardNumber = CHARACTER_CARD_NUMBER_THIRTEEN;
				// 処理を抜けます
				break;
			// そのほかの数字の場合の設定を行います
			default :
				// 設定された数値を文字で設定します
				cardNumber = String.valueOf(mNumber);
				// 処理を抜けます
				break;
		}
		// 数字設定に対応する文字表現を返します
		return cardNumber;
	}
}
