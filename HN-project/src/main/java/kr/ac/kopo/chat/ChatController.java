package kr.ac.kopo.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	
	@GetMapping("/chat")
	public String chatList() {
		System.out.println("채팅");
		return "chat/chat";
	}

}
