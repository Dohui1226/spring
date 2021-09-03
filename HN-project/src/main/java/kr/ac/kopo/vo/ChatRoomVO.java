package kr.ac.kopo.vo;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomVO {
	
	private Long id; //챗방 아이디
	private List<ChatMessageVO> messages = new ArrayList<ChatMessageVO>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ChatMessageVO> getMessages() {
		return messages;
	}
	public void setMessages(List<ChatMessageVO> messages) {
		this.messages = messages;
	}
	
	@Override
	public String toString() {
		return "ChatRoomVO [id=" + id + ", messages=" + messages + "]";
	}
	
	
	
}
