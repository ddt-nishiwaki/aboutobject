package oldmaid;

/**
 * ババ抜きのプレーヤークラス
 */
public class Player {
	// 最後の一枚を示す値です
	private static final int NUMBER_OF_LAST_ONE = 1;
	private static final int NOT_IS_CARD = 0;
	private static final String FORMAT_MESSAGE_DISPOSE_CARD = "%s : ";
	private static final String FORMAT_OUTPUT_DETAIL_PICK = "%s : %sさんから %s を引きました\n";
	private static final String FORMAT_OUTPUT_NOW_HAND = "%s : 残りの手札は %s です\n";
	/**********************************
		メンバ変数	
	**********************************/
	// アガリを報告する進行役を示すフィールドです
	private Master mMaster;
	// カードを捨てるテーブルを示すフィールドです
	private Table mTable;
	// 自分の手札を示すフィールドです
	private Hand mMyHand = new Hand();
	// 自分の名前を示すフィールドです
	private String mName;
	/**********************************
		コンストラクタ
	**********************************/
	/**
	 * 名前とアガリを報告する進行役、カードを破棄するテーブルを決めてユーザを設定する
	 * 
	 * @param name 名前
	 * @param master 進行役
	 * @param table テーブル
	 */
	public Player(String name, Master master, Table table){
		// 名前を設定します
		mName = name;
		// 状態を報告するための進行役を設定します
		mMaster = master;
		// カードを捨てるためのテーブルを設定します
		mTable = table;
	}
	/**********************************
		メソッド
	**********************************/
	/**
	 * 指名する
	 * 
	 * @param nextPlayer 次のプレーヤー
	 */
	public void play(Player nextPlayer){
		// 次のプレーヤーの手札を取得します
		Hand nextHand = nextPlayer.showHand();
		// 相手の手札から一枚引く
		Card pickedCard = nextHand.pickCard();
		// 引いた結果を表示
		System.out.printf(FORMAT_OUTPUT_DETAIL_PICK, this.toString(), nextPlayer.toString(), pickedCard.toString());
		// 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(pickedCard);
		// 手札が0になったかどうか調べる
		if(mMyHand.getNumberOfCards() == NOT_IS_CARD){
			// 0だったらアガリを伝える
			mMaster.declareWin(this);
		// 手札がまだある場合の処理を行う
		} else {
			// 現在の手札を表示する
			System.out.printf(FORMAT_OUTPUT_NOW_HAND, this.toString(), mMyHand.toString());
		}
	}
	/**
	 * 手札を見せる
	 * 
	 * @return 自分の手札
	 */
	public Hand showHand(){
		// 残り一枚の場合は相手にカードを渡した時点で上がり宣言する
		if( mMyHand.getNumberOfCards() == NUMBER_OF_LAST_ONE ){
			// 進行役にアガリを伝える
			mMaster.declareWin(this);
		}
		// 見せる前に手札をシャッフルする
		mMyHand.shuffleCard();
		// 手札を返す
		return mMyHand;
	}
	/**
	 * カードを受け取る
	 * [同じ数を持っていた場合]テーブルへカードを捨てる
	 * [同じ数がない場合]手札にカードを加える
	 * 
	 * @return 受け取ったカード
	 */
	public void receiveCard(Card card){
		// 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(card);
	}
	/**
	 * 手札を整理する
	 */
	private void dealCard(Card card){
		// カードを自分の手札に加える
		mMyHand.addCard(card);
		// 今加えたカードと同じ数のカードを探す
		Card[] sameCards = mMyHand.findSameNumberCard();
		// 同じカードの組み合わせが存在した場合
		if(  sameCards[0] != null ){
			// テーブルへカードを捨てる際のメッセージを出力する
			System.out.printf(FORMAT_MESSAGE_DISPOSE_CARD, this);
			// テーブルへカードを捨てる
			mTable.dropCards(sameCards);
		}
	}
	/**
	 * プレーヤーの名前を返します
	 * 
	 * @return プレーヤーの名前
	 */
	@Override public String toString(){
		return mName;
	}
}
