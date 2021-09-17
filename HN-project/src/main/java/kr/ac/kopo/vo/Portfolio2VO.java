package kr.ac.kopo.vo;

import java.util.List;

public class Portfolio2VO {
	
	private int seq_no;
	private int me;
	private String nickname;
	private List<PortfolioVO> ft;
	
	
	
	
	public int getMe() {
		return me;
	}
	public void setMe(int me) {
		this.me = me;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public List<PortfolioVO> getFt() {
		return ft;
	}
	public void setFt(List<PortfolioVO> ft) {
		this.ft = ft;
	}
	@Override
	public String toString() {
		return "Portfolio2VO [seq_no=" + seq_no + ", me=" + me + ", nickname=" + nickname + ", ft=" + ft + "]";
	}
	

}
