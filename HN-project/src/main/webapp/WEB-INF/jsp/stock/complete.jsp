<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
	
<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
<jsp:include page="../header.jsp"/>
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
                                <li class="home-bread">STOCK</li>
                                <li>주문완료</li>
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
                            <h3>주문완료 페이지</h3>
                            <p>Help agencies to define their new business objectives and then create professional software.</p>
						</div>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="deposite-content">
                            <div class="diposite-box">
                                <h4>Last deposite</h4>
                                <span><i class="flaticon-005-savings"></i></span>
                                <div class="deposite-table">
                                    <table>
                                        <tr>
                                            <th>종목명</th>
                                            <td></td>
                                         
                                        </tr>
                                        <tr>
                                            <th>종목코드</th>
                                            <td>${buysell.stock_code}</td>
                                            
                                        </tr>
                                        <tr>
                                            <th>주문수량</th>
                                            <td>${buysell.stock_num}</td>
                                          
                                        </tr>
                                        <tr>
                                            <th>주문금액</th>
                                            <td>${buysell.close}</td>                                      
                                        </tr>
                                        <tr>
                                            <td>수수료비용</td>
                                            <td>${buysell.fee}</td>                                       
                                        </tr>
                                       
                                    </table>
                                </div>
                            </div>
                            <div class="diposite-box">
                                <h4>Last withdrawals</h4>
                                <span><i class="flaticon-042-wallet"></i></span>
                                <div class="deposite-table">
                                    <table>
                                        <tr>
                                            <th>Name</th>
                                            <th>Date</th>
                                            <th>Amount</th>
                                            <th>Currency</th>
                                        </tr>
                                        <tr>
                                            <td>Arnold</td>
                                            <td>Jan 04, 2020</td>
                                            <td>$1000</td>
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Jhon Abra</td>
                                            <td>Jan 07, 2020</td>
                                            <td>$6000</td>
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Lanisha</td>
                                            <td>Jan 13, 2020</td>
                                            <td>$5000</td>
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Gongales</td>
                                            <td>Jan 12, 2020</td>
                                            <td>$2000</td>
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Admond sayhel</td>
                                            <td>Jan 10, 2020</td>
                                            <td>$1000</td>
                                            <td>USD</td>
                                        </tr>
                                        <tr>
                                            <td>Remond</td>
                                            <td>Jan 02, 2020</td>
                                            <td>$3000</td>
                                            <td>USD</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
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