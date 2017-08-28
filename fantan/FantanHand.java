package fantan;

import java.util.ArrayList;
import oldmaid.Card;
import oldmaid.Hand;

/**
 * 7-3 ババ抜きプログラムにある仕様変更が発生し、その結果Handクラスの「カードを引く」操作の処理内容を変更する必要が出てきました。
 * しかし、Work7-2でサブクラスとして作成したFantanHandクラスの「カードを引く」操作では、今まで通りの処理を行うようにしなくてはなりません
 * FantanHandクラスの機能に影響を与えずにHandクラスを修正するには、どのようにすればいいでしょうか?
 * 
 * 七並べ用の手札クラス
 * ババ抜き用手札クラスを継承する
 * @author wakkky05
 *
 */
public class FantanHand extends Hand{
	/**********************************
		定数
	**********************************/
	// 最初のインデックスを示す値です
	private static final int START_INDEX = 0;
	/**********************************
		メンバ変数
	**********************************/
	// 手札のカードリストを示すフィールドです
	private ArrayList handOfCards = new ArrayList();
	/**********************************
		メソッド
	**********************************/
	/**
	 * カードを見る
	 */
	public void lookCard(){
		// 実際の処理
	}
	/**
	 * 回答
	 * 元々の「カードを引く」メソッドの内容でオーバーライドを行う
	 */
	public Card pickCard(){
		// 手札の先頭のカードを削除して、返値として渡します
		return (Card)handOfCards.remove(START_INDEX);
	}
}
