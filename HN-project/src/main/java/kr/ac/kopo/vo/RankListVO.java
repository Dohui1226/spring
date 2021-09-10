package kr.ac.kopo.vo;

public class RankListVO {
	
	private int no;
	private String nickname;
	private int hart;
	private double rate;
	private int stockvalue;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getHart() {
		return hart;
	}
	public void setHart(int hart) {
		this.hart = hart;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getStockvalue() {
		return stockvalue;
	}
	public void setStockvalue(int stockvalue) {
		this.stockvalue = stockvalue;
	}
	@Override
	public String toString() {
		return "RankListVO [nickname=" + nickname + ", hart=" + hart + ", rate=" + rate + ", stockvalue=" + stockvalue
				+ "]";
	}
	
	

}
