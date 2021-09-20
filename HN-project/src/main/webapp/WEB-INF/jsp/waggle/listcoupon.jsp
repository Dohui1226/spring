<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


<jsp:include page="../header.jsp" />


<div class="page-area">
	<div class="breadcumb-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="breadcrumb text-center">
					<!-- <div class="section-headline white-headline">
						<h3>쿠폰조회</h3>
					</div> -->
					<ul class="breadcrumb-bg">
						
						<li>쿠폰관리</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End breadcumb Area -->
<!-- Start Slider Area -->
<div class="invest-area bg-color page-padding-2">
            <div class="container">
               <div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
                            <h3>나의 쿠폰조회</h3>
                            <p>내가 가진 모든 쿠폰조회, 쿠폰등록, 쿠폰선물이 가능합니다.</p>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="deposite-content">
                            <div class="diposite-box">
                                <div class="deposite-table">
                                    <table>
                                        <tr>
                                            <th>쿠폰명</th>                                          
                                         	<th>쿠폰번호</th>                                     
                                            <th>쿠폰 나누기</th>                                        
                                        </tr>
                                        <c:forEach items="${requestScope.mycoupon}" var="mycoupon" varStatus="loop"> 
                                        <tr>
                                            <td >&nbsp;&nbsp;&nbsp;&nbsp;${mycoupon.couponname} <input type="hidden" id="couponname" value="${mycoupon.couponname}" /></td>                                           
                                            <td >${mycoupon.couponid} <input type="hidden" id="couponcode" value="${mycoupon.couponid}" /></td>
                                           
                                       
                                       		<td><a href="#modalcode" onclick="set()" data-toggle="modal">보기</a></td>
                                       		
                                       	</tr>
                                       </c:forEach>
                         
                                    </table>
                                </div>
                            </div>
                           
                       
                        </div>
                    </div>
                </div>
            </div>
          
        </div>
        
<div class="modal fade" id="modalcode" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">쿠폰확인하기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" align="center">
				&nbsp;&nbsp;<input type="text" style="border:none;" id="couponmodal" value="" readonly>	
			 	<div id="bcTarget" style="margin-top:30px;"></div> 

			
			</div>
			<div class="modal-footer">
				<button id="button-modal" onclick="sendLinkCustom()">카카오톡 공유</button>
				<button id="button-modal2" onclick="giftfollow()">선물하기</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="giftfollow" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">쿠폰확인하기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" align="center">
				&nbsp;&nbsp;<input type="text" style="border:none;" id="couponmodal" value="" readonly>	
			 	<div id="bcTarget" style="margin-top:30px;"></div> 

			
			</div>
			<div class="modal-footer">
				<button id="button-modal" onclick="giftfollow(id)">선물</button>
				<button id="button-modal2" >닫기</button>
			</div>
		</div>
	</div>
</div>
        
        
<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />

<!-- End Footer area -->


</body>
<script>

function giftfollow(id){
	$.ajax({
		url : '${pageContext.request.contextPath}/gift/coupon',
		type : 'get',
		data : {no : id},
		success : function(result) {			
			alert('쿠폰 선물을 완료하였습니다.')
		}
	})		
	
}

function set() {
	
	let coupon = $("#couponname").val() 
	$("#couponmodal").val(coupon)
	alert(coupon)
	let couponid = $("#couponcode").val()
	$("#bcTarget").barcode(couponid, "codabar");
} 


function sendLinkCustom() {
    Kakao.init("f54b29040061ba185ecba85fddaf2c24");
    Kakao.Link.sendCustom({
        templateId: 62031 
    });
}
</script>

<script type="text/JavaScript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-barcode.js">
</script>
<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
</html>