package kr.ac.kopo.vo;

public class StockBuySellVO {
	private String member_account;
	private String stock_code;
	private int stock_num;
	private int fee;
	
	public String getMember_account() {
		return member_account;
	}
	public void setMember_account(String member_account) {
		this.member_account = member_account;
	}
	public String getStock_code() {
		return stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	public int getStock_num() {
		return stock_num;
	}
	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "StockBuySellVO [member_account=" + member_account + ", stock_code=" + stock_code + ", stock_num="
				+ stock_num + ", fee=" + fee + "]";
	}
	
	
	
}
