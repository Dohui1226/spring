<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
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
                            <h3>Deposite and withdrawals history</h3>
                            <p>Help agencies to define their new business objectives and then create professional software.</p>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="deposite-content">
                            <div class="diposite-box">
                                	<div class="subs-feilds">
                                	
                                	
									<form action="#">
										<div class="blog-search-option">
											<input type="text" placeholder="종목명 검색">
											<button class="button" type="submit">
												<i class="fa fa-search"></i>
											</button>
											
										</div>
									</form>
								<!-- 	 <span>내 계좌 잔액 <i class="flaticon-005-savings"></i></span> -->
									
								</div>
                              
                                <div class="deposite-table">
                                    <table>
                                        <tr>
                                            <th>종목명</th>                                          
                                            <th>현재가</th>
                                            <th>전일비</th>
                                            <th>보고서</th>
                                            <th>주문</th>
                                        </tr>
                                        <tr>
                                            <td>${company.name}</td>                                           
                                            <td>${company.price}</td>
                                            <td>${company.diff}</td>
                               <td>	 <a class="blue" href="${pageContext.request.contextPath}/stock/report?code=${company.code}">바로가기</a>
                               		</td>
                                            <td><div class="price-btn blue">
                                    <a class="blue" href="${pageContext.request.contextPath}/stock/buysell">주문</a>
                               </div></td>
                                        </tr>
                                        <tr>
                                             <td>LG전자</td>                                           
                                            <td>820000</td>
                                             <td>바로가기</td>
                                            <td>바로가기</td>
                                            <td><button>매수</button> <button>매도</button></td>
                                        </tr>
                                        <tr>
                                            <td>엑시콘</td>
                                            <td>18000</td>
                                             <td>바로가기</td>
                                            <td>바로가기</td>                                         
                                            <td><button>매수</button> <button>매도</button></td>
                                        </tr>
                                        <tr>
                                            <td>Admond sayhel</td>
                                            <td>Jan 02, 2020</td>
                                            <td>바로가기</td>
                                             <td>바로가기</td>                                   
                                            <td>Bitcoin</td>
                                        </tr>
                                        <tr>
                                            <td>Anjel july</td>
                                            <td>Jan 05, 2020</td>
                                            <td>바로가기</td>
                                             <td>바로가기</td>                                        
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Lagisha</td>
                                            <td>Jan 12, 2020</td>
                                             <td>바로가기</td>
                                            <td>$5000</td>
                                            <td>Bitcoin</td>                                        
                                        </tr>
                                    </table>
                                </div>
                            </div>
                           
                       
                        </div>
                    </div>
                </div>
            </div>
          
        </div>
<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />

<!-- End Footer area -->

<!-- all js here -->


</body>

<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
</html>