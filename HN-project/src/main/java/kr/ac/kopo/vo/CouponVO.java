package kr.ac.kopo.vo;

public class CouponVO {
	
	private int coupontype;
	private long couponid;
	private int no;
	private int heart;
	private String couponname;
	
	public int getCoupontype() {
		return coupontype;
	}
	public void setCoupontype(int coupontype) {
		this.coupontype = coupontype;
	}
	public long getCouponid() {
		return couponid;
	}
	public void setCouponid(long couponid) {
		this.couponid = couponid;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		
	}
	
	
	
	
	public String getCouponname() {
		return couponname;
	}
	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	@Override
	public String toString() {
		return "CouponVO [coupontype=" + coupontype + ", couponid=" + couponid + ", no=" + no + ", heart=" + heart
				+ ", couponname=" + couponname + "]";
	}
	
	
	

}
