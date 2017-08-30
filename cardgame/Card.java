package cardgame;

/**
 * カードゲームのカードクラスです
 * @author wakkky05
 *
 */
public class Card {
	/*****************************************
		定数
	******************************************/
	// スートの数です
	public static final int SUIT_NUM = 4;
	// 数字の種類の数を示す値です
	public static final int CARD_NUM = 13;
	/*** スート の表示に関わる設定です ***/
	// スペードを示す値です
	public static final int SUIT_SPADE = 1;
	// ダイヤを示す値です
	public static final int SUIT_DIAMOND = 2;
	// クラブを示す値です
	public static final int SUIT_CLUB = 3;
	// ハートを示す値です
	public static final int SUIT_HEART = 4;
	// スペードを示す値です
	public static final String CHAR_SUIT_SPADE = "S";
	// ダイヤを示す値です
	public static final String CHAR_SUIT_DIAMOND = "D︎";
	// クラブを示す値です
	public static final String CHAR_SUIT_CLUB = "C︎";
	// ハートを示す値です
	public static final String CHAR_SUIT_HEART = "H";

	// カードの数字 1 に対応する値です
	public static final int CARD_NUMBER_ONE = 1; 
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
	/*****************************************
		メンバ変数
	******************************************/
	// カードのスート設定フィールドです
	protected int mSuit;
	// カードの数字設定フィールドです
	protected int mNumber;
	/*****************************************
		コンストラクタ
	******************************************/
	/**
	 *  スートと数を指定してカードを作成します
	 *  
	 *  @param suit スート
	 *  @param number 数字
	 */
	public Card(int suit, int number){
		// スートを設定します
		mSuit = suit;
		// 数字を設定します
		mNumber = number;
	}
	/*****************************************
		メソッド
	******************************************/
	/**
	 * カードの数字を返します
	 * 
	 * @return カードの数字
	 */
	public int getNumber(){
		// カード数字を返します
		return mNumber;
	}
	/**
	 * カードのスートを返します
	 * 
	 * @return カードのスート
	 */
	public int getSuit(){
		// スートを示す値を返します
		return mSuit;
	}
	/**
	 * カードを文字列で表現します
	 * toStringのオーバーライド
	 */
	@Override public String toString(){
		// 文字列設定用の変数です
		StringBuffer string = new StringBuffer();
		
		// スートの表現を設定します
		switch (mSuit){
			// スペードの場合の設定を行います
			case SUIT_SPADE :
				// スペードを示す文字を設定します
				string.append(CHAR_SUIT_SPADE);
				// 処理を抜けます
				break;
			// ダイヤの場合の設定を行います
			case SUIT_DIAMOND :
				// ダイヤを示す文字を設定します
				string.append(CHAR_SUIT_DIAMOND);
				// 処理を抜けます
				break;
			// クラブの場合の設定を行います
			case SUIT_CLUB :
				// クラブを示す文字を設定します
				string.append(CHAR_SUIT_CLUB);
				// 処理を抜けます
				break;
			// ハートの場合の設定を行います
			case SUIT_HEART :
				// ハートを示す文字を設定します
				string.append(CHAR_SUIT_HEART);
				// 処理を抜けます
				break;
			// その他の場合の設定を行います
			default :
				// 何も設定せず処理を抜けます
				break;
		}
		
		// 数字の値を文字列表現に追加します
		switch (mNumber){
			// 1 の場合の設定を行います
			case CARD_NUMBER_ONE :
				// エースを示す文字列を設定します
				string.append(CHARACTER_CARD_NUMBER_ONE);
				// 処理を抜けます
				break;
			// 10 の場合の設定を行います
			case CARD_NUMBER_TEN :
				// 10 を示す文字列を設定します
				string.append(CHARACTER_CARD_NUMBER_TEN);
				// 処理を抜けます
				break;
			// 11 の場合の設定を行います
			case CARD_NUMBER_ELEVEN :
				// ジャックを示す文字列を設定します
				string.append(CHARACTER_CARD_NUMBER_ELEVEN);
				// 処理を抜けます
				break;
			// 12 の場合の設定を行います
			case CARD_NUMBER_TWELVE :
				// クイーンを示す文字列を設定します
				string.append(CHARACTER_CARD_NUMBER_TWELVE);
				// 処理を抜けます
				break;
			// 13 の場合の設定を行います
			case CARD_NUMBER_THIRTEEN :
				// キングを示す文字列を設定します
				string.append(CHARACTER_CARD_NUMBER_THIRTEEN);
				// 処理を抜けます
				break;
			// その他 の場合の設定を行います
			default :
				// 数字をそのまま表現に設定します
				string.append(mNumber);
				// 処理を抜けます
				break;
		}
		// 設定したカードの文字列表現を返します
		return string.toString();
	}
}
