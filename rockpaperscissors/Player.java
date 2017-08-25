package rockpaperscissors;

import rockpaperscissors.Tactics;

/**
 * じゃんけんのプレイヤーを表すクラス。
 * 
 * 3-1 以下プレーヤクラスの回答 ① ~ ③ の内容を記述する
 */
public class Player {
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
	public static final int NUMBER_OF_ROCK = 0;
	// チョキを表す値です
	public static final int NUMBER_OF_SCISSORS = 1;
	// パーを表す値です
	public static final int NUMBER_OF_PAPER = 2;
	
	/****************************
		プレイヤークラスの属性
	/****************************/
	// プレーヤーの名前属性です
	private String name_;
	// プレイヤーの勝った回数属性です
	private int winCount_;
	// プレーヤーの戦略です
	private Tactics tactics_;

	/****************************
		コンストラクタ
	/****************************/
	public Player(String name){
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
		// 与えられた戦略を読んでジャンケンの手を決める
		int hand = tactics_.readTactics();
		// 決定した手を戻りとして返す
		return hand;
	}
	
	/**
	 * 審判から勝敗を聞く
	 * 
	 * @param result true:勝ち,false:負け
	 */
	public void notifyResult(boolean result){
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
	/**
	 * プレイヤーに戦略を渡す
	 * 
	 * @param tactics 戦略
	 */
	public void setTactics(Tactics tactics){
		tactics_ = tactics;
	}
}
