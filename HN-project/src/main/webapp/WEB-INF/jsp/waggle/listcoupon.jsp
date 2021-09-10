<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>

function set(btn) {
	var coupon = $("#couponname").attr('data-id') 
	$("#couponmodal").val(coupon)
	
	var couponid = $("#couponid").attr('data-id') 

	$("#bcTarget").barcode(couponid, "codabar");
} 

$(document).on("click", "#button-modal", function() {
	location.href="${pageContext.request.contextPath}/waggle/gitfcoupon"
});

 
</script>


<jsp:include page="../header.jsp" />


<div class="page-area">
	<div class="breadcumb-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="breadcrumb text-center">
					<div class="section-headline white-headline">
						<h3>쿠폰조회</h3>
					</div>
					<ul class="breadcrumb-bg">
						<li class="home-bread">Home</li>
						<li>와글와글</li>
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
                                            <th>쿠폰조회</th>                                        
                                        </tr>
                                        <c:forEach items="${requestScope.mycoupon}" var="mycoupon" varStatus="loop"> 
                                        <tr>
                                            <td id="couponname" data-id="${mycoupon.couponname}">${mycoupon.couponname}</td>                                           
                                            <td id="couponid" data-id="${mycoupon.couponid}">${mycoupon.couponid}</td>
                                       		<td><a href="#modalcode" onclick="set(this)" data-toggle="modal">보기</a></td>
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
				<button id="button-modal" onclick=""data-dismiss="modal">선물</button>
				<button id="button-modal2" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
        
        
<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />

<!-- End Footer area -->

<!-- all js here -->


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-barcode.js">
</script>
<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
</html>