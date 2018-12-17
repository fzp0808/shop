package ajax.day02;

public class Sales {
	private int tId;
	private String tName;
	private double tPrice;
	private int tNum;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(int tId, String tName, double tPrice, int tNum) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tPrice = tPrice;
		this.tNum = tNum;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public double gettPrice() {
		return tPrice;
	}

	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}
	
}
