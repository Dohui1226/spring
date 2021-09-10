package kr.ac.kopo.vo;

public class AccountDailyVO {
	
	private String acc_num;
	private int no;
	private float rate;
	private int tstock;
	private int tcash;
	private String wdate;
	private int stockvalue;
	public String getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getTstock() {
		return tstock;
	}
	public void setTstock(int tstock) {
		this.tstock = tstock;
	}
	public int getTcash() {
		return tcash;
	}
	public void setTcash(int tcash) {
		this.tcash = tcash;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getStock_value() {
		return stockvalue;
	}
	public void setStock_value(int stock_value) {
		this.stockvalue = stock_value;
	}
	@Override
	public String toString() {
		return "AccountDailyVO [acc_num=" + acc_num + ", no=" + no + ", rate=" + rate + ", tstock=" + tstock
				+ ", tcash=" + tcash + ", wdate=" + wdate + ", stockvalue=" + stockvalue + "]";
	}
	
	
	

}
