package kr.ac.kopo.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.chat.service.ChatService;
import kr.ac.kopo.member.service.MemberService;

@Controller
public class ChatController {
	//@Autowired
	//private ChatService service;
	
	@GetMapping("/chat")
	public String chatList() {
		
		System.out.println("채팅");
		
		return "chat/chat";
	}
	
//	@PostMapping("/chat/newChat")
//	public String newChat(@RequestParam("receiver") String user1, @RequestParam("sender") String user2) {
//		String chatRoomId = service.newRoom(user1, user2); //채팅룸 개설하여채팅 룸아이디 받기 
//		System.out.println("채팅");
		
//		return "redirect:/personalChat/"+chatRoomId;
//	}

}
