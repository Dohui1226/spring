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


<div class="invest-area bg-color page-padding-2">
            <div class="container">
               <div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
                            <h3>쿠폰 선물하기</h3>
                            <p>보유한 쿠폰을 선물 할 수 있습니다.</p>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="deposite-content">
                            <div class="diposite-box">
                                <div class="deposite-table">
                                  
                                      
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
				<button id="button-modal" data-dismiss="modal">선물</button>
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