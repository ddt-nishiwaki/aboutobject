package oldmaid2;

import static oldmaid2.OldMaidConstants.*;
/**
 * ババ抜きの定数クラスです
 * @author wakkky05
 *
 */
public class OldMaidConstants {

	/*****************************************
		定数
	******************************************/
	// 配列の最初のインデックスを示す値です
	public static int FIRST_INDEX = 0;
	// カードがないことを示す値です
	public static int NOT_IS_CARD = 0;
	// 表示を調整するための区切りスペースです
	public static String DELIMITER_SPACE = " ";
	// 最初のインデックスを示す値です
	public static final int START_INDEX = 0;
	// インデックスを表す値に変換するための値です
	public static final int SHIFT_INDEX = -1;
	// カードのペアを設定する際の値です
	public static final int NUMBER_OF_SET_PAIR = 2;
	// 1枚目のカードを設定するための値です
	public static final int FIRST_CARD_OF_PAIR = 0;
	// 2枚目のカードを設定するための値です
	public static final int SECOND_CARD_OF_PAIR = 1;
	// 手札の操作を最後のカードだけ除外するための値です
	public static final int IGNORE_LAST_INDEX = -1;
	// 最後の一枚を示す値です
	public static final int NUMBER_OF_LAST_ONE = 1;
	

	public static final String FORMAT_MESSAGE_DISPOSE_CARD = "%s : ";
	public static final String FORMAT_OUTPUT_DETAIL_PICK = "%s : %sさんから %s を引きました\n";
	public static final String FORMAT_OUTPUT_NOW_HAND = "%s : 残りの手札は %s です\n";

	// カードを捨てる際のメッセージフォーマットです
	public static final String MESSAGE_DROP_CARDS = "を捨てました。";

}
