package rockpaperscissors;

/**
 * ジャンケン戦略インターフェース
 * @author wakkky05
 *
 */
public interface Tactics {
	
	/**
	 * 戦略を読み、ジャンケンの手を得る
	 * グー・チョキ・パーのいずれかをPlayerクラスに定義された
	 * 以下の定数で返す。
	 * Player.NUMBER_OF_ROCK
	 * Player.NUMBER_OF_SCISSORS
	 * Player.NUMBER_OF_PAPER
	 * 
	 * @return ジャンケンの手
	 */
	public int readTactics();
}
