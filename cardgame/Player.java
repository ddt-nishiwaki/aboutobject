package cardgame;

import cardgame.Hand;
/**
 * カードゲームのプレーヤークラスです
 * @author wakkky05
 *
 */
public abstract class Player {
	/*****************************************
		メンバ変数
	******************************************/
	// 名前の設定です
	protected String mName;
	// カードを置くテーブルの設定です
	protected Table mTable;
	// 配られる手札を保持するフィールドです(from Master)
	public Hand mHand = new Hand();
	// 状況を伝える進行役の設定です
	protected Master mMaster;
	// ゲームのルール設定です
	protected Rule mRule;
	/*****************************************
		コンストラクタ
	******************************************/
	/**
	 * 名前、進行役、テーブル、ルールを設定します
	 * 
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 * @param rule ルール
	 */
	public Player (String name, Master master, Table table, Rule rule){
		// 名前を設定します
		mName = name;
		// 進行役を設定します
		mMaster = master;
		// テーブルを設定します
		mTable = table;
		// ルールを設定します
		mRule = rule;
	}
	/*****************************************
		抽象メソッド
	******************************************/
	/**
	 * 順番を指名する
	 * 実際の処理はサブクラスで記述すること
	 * ※指名された時に行う処理はゲームによって異なるため
	 * 
	 * @param nextPlayer 次のプレーヤー
	 */
	public abstract void play(Player nextPlayer);
	/**
	 * カードを配る
	 * カードを受け取った時の処理を拡張したい場合は
	 * 本メソッドをサブクラスでオーバーライドすること
	 * 
	 * @param card 受け取ったカード
	 */
	public void receiveCard(Card card){
		// 受け取ったカードを手札に加える
		mHand.addCard(card);
	}
	/*****************************************
		メソッド
	******************************************/
	/**
	 * プレーヤーの名前を返す
	 * toStringのオーバーライド
	 * 
	 * @return プレーヤーの名前
	 */
	public String toString(){
		// 名前を返します
		return mName;
	}

}
