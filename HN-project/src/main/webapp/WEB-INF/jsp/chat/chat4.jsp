<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
$('#btnSend').on("click", function(){
	sendMessage();
	$("#chatMsg").val("");
});
let sock = new SockJS("http://localhost:9999/HN-project/chat/");
sock.onmessage = onMessage;
sock.onclose = onClose;


var userid='${param.id}'; 

	/* 웹소켓 객체 생성하는 부분, 핸들러 등록(연결생성 메시지 수신 연결종료) */
	/* url연결할 서버의 경로 */
	
	
	function sendMessage(){
		console.log('연결생성');
		sock.send($("chatMsg").val());
	};
	function onMessage(msg){
		var data = msg.data;
		$("#msgArea").append(data + "<br/>");
	};
	function onClose(evt){
		$("#msgArea").append("연결 끊김");
	};






//페이ㅣ가 로딩되면  connect 실행




</script>
<html class="no-js" lang="en">

<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
<jsp:include page="../header.jsp" />
<!-- header end -->
<!-- Start breadcumb Area -->
<div class="page-area">
	<div class="breadcumb-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="breadcrumb text-center">
					<div class="section-headline white-headline">
						<h3>Messaging</h3>
					</div>
					<ul class="breadcrumb-bg">
						<li class="home-bread">Home</li>
						<li>Messaging</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End breadcumb Area -->
<!-- Start Slider Area -->
<div class="login-area page-padding">
	<div class="container">
	<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						
                            <h3>${waggle.id}</h3>
                           
						</div>
					</div>
				</div>
		<div class="messaging">
			<div class="inbox_msg">
				<div class="inbox_people">
					<div class="headind_srch">
						<div class="recent_heading">
							<h4>Recent</h4>
						</div>
						<div class="srch_bar">
							<div class="stylish-input-group">
								<input type="text" class="search-bar" placeholder="Search">
								<span class="input-group-addon">
									<button type="button">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<div class="inbox_chat">
						<div class="chat_list active_chat">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
						<div class="chat_list">
							<div class="chat_people">
								<div class="chat_img">
									<img src="https://ptetutorials.com/images/user-profile.png"
										alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										Sunil Rajput <span class="chat_date">Dec 25</span>
									</h5>
									<p>Test, which is a new approach to have all solutions
										astrology under one roof.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="mesgs">
					<div class="msg_history" id="msgArea" >
						<div class="incoming_msg">
							<div class="incoming_msg_img">
								<img src="https://ptetutorials.com/images/user-profile.png"
									alt="sunil">
							</div>
							<div class="received_msg">
								<div class="received_withd_msg">
									<p>Test which is a new approach to have all solutions</p>
									<span class="time_date"> 11:01 AM | June 9</span>
								</div>
							</div>
						</div>
						<div class="outgoing_msg">
							<div class="sent_msg">
								<p>Test which is a new approach to have all solutions</p>
								<span class="time_date"> 11:01 AM | June 9</span>
							</div>
						</div>
						<div class="incoming_msg">
							<div class="incoming_msg_img">
								<img src="https://ptetutorials.com/images/user-profile.png"
									alt="sunil">
							</div>
							<div class="received_msg">
								<div class="received_withd_msg">
									<p>Test, which is a new approach to have</p>
									<span class="time_date"> 11:01 AM | Yesterday</span>
								</div>
							</div>
						</div>
						
						<div class="incoming_msg">
							<div class="incoming_msg_img">
								<img src="https://ptetutorials.com/images/user-profile.png"
									alt="sunil">
							</div>
							<div class="received_msg">
								<div class="received_withd_msg">
									<p>We work directly with our designers and suppliers, and
										sell direct to you, which means quality, exclusive products,
										at a price anyone can afford.</p>
									<span class="time_date"> 11:01 AM | Today</span>
								</div>
							</div>
						</div>
					</div>
					<div class="type_msg">
						<div class="input_msg_write">
							<input type="text" class="write_msg" placeholder="Type a message" id="chatMsg" />
							<br>
							<input type="button" value="전송"  id="btnSend">
								<!-- <i class="fa fa-paper-plane-o" aria-hidden="true"></i> -->
							
						</div>
					</div>
				</div>
			</div>




		</div>
	</div>
</div>

<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />


</body>


</html>