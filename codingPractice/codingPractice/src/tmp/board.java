package tmp;

import java.util.Objects;

public class board {

	

	public String getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	String date;
	String content;
	String menuName;
	String storeNo;
	String reviewNo;
	
	public board(String date, String content, String menuName, String storeNo, String reviewNo) {
		super();
		this.date = date;
		this.content = content;
		this.menuName = menuName;
		this.storeNo = storeNo;
		this.reviewNo = reviewNo;
	}
	
	@Override
	public String toString() {
		return "board [date=" + date + ", content=" + content + ", storeNo=" + storeNo + ", reviewNo=" + reviewNo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, reviewNo, storeNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		board other = (board) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
				 && Objects.equals(reviewNo, other.reviewNo)
				&& Objects.equals(storeNo, other.storeNo);
	}


}