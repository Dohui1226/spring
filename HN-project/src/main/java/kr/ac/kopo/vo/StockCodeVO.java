package kr.ac.kopo.vo;

public class StockCodeVO {
	private String stock_code;
	private String stock_name;
	private String stock_index;
	private String stock_type;
	public String getStock_code() {
		return stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getStock_index() {
		return stock_index;
	}
	public void setStock_index(String stock_index) {
		this.stock_index = stock_index;
	}
	public String getStock_type() {
		return stock_type;
	}
	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
	}
	@Override
	public String toString() {
		return "StockCodeVO [stock_code=" + stock_code + ", stock_name=" + stock_name + ", stock_index=" + stock_index
				+ ", stock_type=" + stock_type + "]";
	}

	
	
}
