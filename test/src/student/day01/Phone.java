package student.day01;

public class Phone {
	protected String pname;
	protected int one;
	
	public Phone() {
	}
	public Phone(String pname, int one) {
		super();
		this.pname = pname;
		this.one = one;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	
	
}
