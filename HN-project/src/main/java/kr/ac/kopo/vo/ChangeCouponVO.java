package kr.ac.kopo.vo;

public class ChangeCouponVO {
	
	private int no;
	private int heart;
	private String couponid;
	private int coupontype;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public String getCouponid() {
		return couponid;
	}
	public void setCouponid(String couponid) {
		this.couponid = couponid;
	}
	public int getCoupontype() {
		return coupontype;
	}
	public void setCoupontype(int coupontype) {
		this.coupontype = coupontype;
	}
	@Override
	public String toString() {
		return "ChangeCouponVO [no=" + no + ", heart=" + heart + ", couponid=" + couponid + ", coupontype="
				+ coupontype + "]";
	}
	
	

}
