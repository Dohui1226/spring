<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<jsp:include page="../header.jsp"/>
<script>

$(document).on("click", "#paymodal", function () {
    var myBookId = $(this).data('id');
    $(".modal-body #addheartmodal").val( myBookId );
    // As pointed out in comments, 
    // it is superfluous to have to manually call the modal.
    // $('#addBookDialog').modal('show');
});






function paymodal() {
	document.getElementById("addheartmodal").value
	 = document.getElementById("paymodal").value 
	
};
</script>

        <!-- header end -->
        <!-- Start breadcumb Area -->
        <div class="page-area">
            <div class="breadcumb-overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="breadcrumb text-center">
                            <div class="section-headline white-headline">
                                <h3>Coupon</h3>
                            </div>
                            <ul class="breadcrumb-bg">
                                <li class="home-bread">Waggle</li>
                                <li>Coupon</li>
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
                            <h3>하트 충전</h3>
                            <p>하트가 부족하다면 충전할 수 있습니다.</p>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="pricing-content">
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices" id="paymodal" value="50">50개</span>
                                    </div>
                                    <span class="per-day">월 정액권</span>
                                </div>
                                <ol class="pricing-text">
                                    <li class="check">매월 1일 하트 50개 충전</li>
                                    <li class="check">매월 1900원</li>
                                 
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">신청하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">50개</span>
                                    </div>
                                    <span class="per-day">1회</span>
                                </div>
                               <ol class="pricing-text">
                                    <input type="text" style="border:none" class="check" id="paymodal" value="50">하트 50개 충전</li>
                                    <li class="check">가격 2500원</li>
                                	
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" onclick="paymodal()" data-toggle="modal" href="#modal">신청하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <div class="top-price-inner">
                                   <span class="base">Popular</span>
                                   <div class="rates">
                                        <span class="prices">100개</span>
                                    </div>
                                    <span class="per-day">1회</span>
                                </div>
                                <ol class="pricing-text">
                                    <li class="check">하트 100개 충전</li>
                                    <li class="check">가격 3000원</li>
                                
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">신청하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <span class="base">Best sale</span>
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">200개
                                    </div>
                                    <span class="per-day">1회</span>
                                </div>
                               <ol class="pricing-text">
                                    <li class="check">하트 200개 충전</li>
                                    <li class="check">가격: 5000원 </li>
   
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">신청하기</a>
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
                            <h3>하트 교환</h3>
                            <p>보유한 하트를 통하여 혜택을 받을 수 있습니다.</p>
						</div>
					</div>
                        
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">100%</span>
                                    </div>
                                    <span class="per-day">1 Day</span>
                                </div>
                              <ol class="pricing-text">
                                    <li class="check">수수료 100% 절감 쿠폰</li>
                                    <li class="check">필요 하트 500개</li>
                                
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">교환하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                               <span class="base">Best plan</span>
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">100%
                                    </div>
                                    <span class="per-day">5 days</span>
                                </div>
                                 <ol class="pricing-text">
                                    <li class="check">수수료 100% 절감 쿠폰</li>
                                    <li class="check">필요 하트 1000개</li>
                                
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">교환하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">100%</span>
                                    </div>
                                    <span class="per-day">4 weeks</span>
                                </div>
                                <ol class="pricing-text">
                                    <li class="check">수수료 100% 절감 쿠폰</li>
                                    <li class="check">필요 하트 2000개</li>
                                
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">교환하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12">
                            <div class="pri_table_list">
                                <span class="base">Top plan</span>
                                <div class="top-price-inner">
                                   <div class="rates">
                                        <span class="prices">주식뽑기</span>
                                    </div>
                                    <span class="per-day">1 회</span>
                                </div>
                                 <ol class="pricing-text">
                                    <li class="check"> 주식뽑기</li>
                                    <li class="check">필요 하트 1000개</li>
                                
                                </ol>
                                <div class="price-btn blue">
                                    <a class="blue" href="#">교환하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">하트결제</h4>
					
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<a class="support-images" href="#"><i class="flaticon-035-savings"></i></a>
				<div class="support-content">	
				보유 하트 갯수 : <input type="text" style="border:none" readonly value="${myheart}"><br>	
				충전 하트 갯수 :<input type="text" id="addheartmodal" style="border:none" readonly>	<br>	
				충전 후 하트 갯수 : 		</p>
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" id="button-modal" onclick="pay()" data-dismiss="modal" value="결제">
				<button id="button-modal2" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
        
		<!-- all js here -->
        <!-- Start Footer Area -->
   <jsp:include page="../footer.jsp"/>
   
        <!-- End Footer area -->
		
		
	</body>
</html>