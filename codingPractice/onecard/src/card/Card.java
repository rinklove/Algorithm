package card;

public class Card {

	//하트, 스페이드, 클로버, 다이아
	private String shape; 
	//1(A) ~ 11(j), 12(Q), 13(k),
	private int value;
	
	public Card(String shape, int value) {
		this.shape = shape;
		this.value = value;
	}

	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[shape=" + shape + ", value=" + value + "]";
	}
	
}
