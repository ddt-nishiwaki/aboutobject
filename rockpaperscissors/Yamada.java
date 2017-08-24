package rockpaperscissors;

/**
 * じゃんけんのプレイヤーを表すクラス。
 * 
 */
public class Yamada {
	// 「グー」を示す文字列です
	public static final String STRING_OF_ROCK = "グー";
	// 「チョキ」を示す文字列です
	public static final String STRING_OF_SCISSORS = "チョキ";
	// 「パー」を示す文字列です
	public static final String STRING_OF_PAPER = "パー";

	/****************************
		じゃんけんの手を表す定数
	/****************************/
	// グーを表す値です
	private static final int NUMBER_OF_ROCK = 0;
	// チョキを表す値です
	private static final int NUMBER_OF_SCISSORS = 1;
	// パーを表す値です
	private static final int NUMBER_OF_PAPER = 2;
	
	/****************************
		プレイヤークラスの属性
	/****************************/
	// プレーヤーの名前属性です
	private String name_;
	// プレイヤーの勝った回数属性です
	private int winCount_;

	/****************************
		コンストラクタ
	/****************************/
	public Yamada(String name){
		name_ = name;
	}
	
	/****************************
		プレイヤークラスの操作
	/****************************/
	/**
	 * ジャンケンの手を出す
	 * 
	 * @return ジャンケンの手
	 */
	public int showHand(){
		/*
		 * 回答1
		 */
		// 手の値を設定する変数です
		int playerHand = 0;
		// 手を決定するために0以上3未満の少数として乱数を得る
		double handDecider = Math.random() * 3;
		// グーと判定して処理を行う
		if( handDecider < 1 ){
			// プレーヤーの手をグーに設定する
			playerHand = NUMBER_OF_ROCK;
		} else if ( handDecider < 2 ){
			// プレーヤーの手をチョキに設定する
			playerHand = NUMBER_OF_SCISSORS;
		} else if ( handDecider < 3 ){
			// プレーヤーの手をパーに設定する
			playerHand = NUMBER_OF_PAPER;
		}
		// 設定した手を返す
		return playerHand;
	}
	
	/**
	 * 審判から勝敗を聞く
	 * 
	 * @param result true:勝ち,false:負け
	 */
	public void notifyResult(boolean result){
		/*
		 * 回答2
		 */
		// 勝ちだった場合
		if(result == true){
			//勝った回数を1カウントする
			winCount_++;
		}
	}
	
	/**
	 * 自分の勝った回数を答える
	 * 
	 * @return 勝った回数
	 */
	public int getWinCount(){
		/*
		 * 回答3
		 */
		// 勝った回数を返す
		return winCount_;
	}
	/*
	 * 自分の名前を答える
	 * 
	 * @return 自分の名前
	 */
	public String getName(){
		return name_;
	}
}

