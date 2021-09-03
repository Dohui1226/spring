package kr.ac.kopo.vo;

public class ChatRoomJoinVO {

	private Long id;
	private MemberVO user;
	private ChatRoomVO chatRoom;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MemberVO getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "ChatRoomJoinVO [id=" + id + ", user=" + user + ", chatRoom=" + chatRoom + "]";
	}
	public void setUser(MemberVO user) {
		this.user = user;
	}
	public ChatRoomVO getChatRoom() {
		return chatRoom;
	}
	public void setChatRoom(ChatRoomVO chatRoom) {
		this.chatRoom = chatRoom;
	}
	
	
	
}
