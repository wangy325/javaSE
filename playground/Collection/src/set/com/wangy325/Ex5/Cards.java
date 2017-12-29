package set.com.wangy325.Ex5;

/**
 * 
 * @author wangy325
 *
 * @date Dec 27, 2017  5:45:47 PM
 *
 * @decription 生成一副扑克牌  不能用 Map 保存牌 因为牌面与花色是一个 "多对多" 的映射关系
 * 				Map 中的映射关系是 "一对一" 或者 "多对一" 的; 
 * 
 */
public class Cards implements Comparable<Cards> {
	private String suit;
	private String face;
	/**
	 * 新建一个纸牌属性, value 存放牌的 "值"
	 * 例如,3 = 3, A = 14, joker = 16...
	 * 建立 value 和 face 属性之间的关系
	 */
	private int value;

	public Cards() {
	}

	public Cards(String suit, String face) {
		super();
		this.suit = suit;
		this.face = face;
		this.value = buildCom(face);
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int buildCom(String face) {
		switch(face) {
			case "3": value = 3; break;
			case "4": value = 4; break;
			case "5": value = 5; break;
			case "6": value = 6; break;
			case "7": value = 7; break;
			case "8": value = 8; break;
			case "9": value = 9; break;
			case "10": value = 10; break;
			case "J": value = 11; break;
			case "Q": value = 12; break;
			case "K": value = 13; break;
			case "A": value = 14; break;
			case "2": value = 15; break;
			case "joker": value = 16; break;
			case "JOKER": value = 17; break;
		}
		return value;
	}

	@Override
	public int compareTo(Cards o) {
		// TODO Auto-generated method stub
		// 这里就是按照斗地主的规则比较进行排序
		if (this.value > o.value)
			return 1;
		if (this.value < o.value)
			return -1;
		else
			return 0;
	}

}
