package kr.ac.kopo.vo;

import java.time.LocalDateTime;

public class ChatMessageVO {

	private Long id;
	private String message;
	private LocalDateTime time;
	private ChatRoomVO chatRoom;
	private MemberVO writer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public ChatRoomVO getChatRoom() {
		return chatRoom;
	}
	public void setChatRoom(ChatRoomVO chatRoom) {
		this.chatRoom = chatRoom;
	}
	public MemberVO getWriter() {
		return writer;
	}
	public void setWriter(MemberVO writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ChatMessageVO [id=" + id + ", message=" + message + ", time=" + time + ", chatRoom=" + chatRoom
				+ ", writer=" + writer + "]";
	}
	
	
	
	
}
