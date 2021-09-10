<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                                <h3>종목조회</h3>
                            </div>
                            <ul class="breadcrumb-bg">
                                <li class="home-bread">STOCK</li>
                                <li>종목조회</li>
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
                            <h3>종목조회</h3>
                        
                          
                           <c:forEach items="${requestScope.stocklist}" var="stocklist" varStatus="loop" end="0"> 
                        
  						    <p>기준 날짜 : &nbsp;${stocklist.close_date} &nbsp; 종가</p> 
							</c:forEach>


                         
                      
                            
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
                                            <th>전일대비</th>
                                            <th>보고서</th>
                                            <th>주문</th>
                                        </tr>
                                          <c:forEach items="${requestScope.stocklist}" var="stocklist" varStatus="loop"> 
                                        <tr>
                                            <td>${stocklist.stock_name}</td>                                           
                                           <%--  <td><fmt:formatNumber value="${stocklist.stock_close}" pattern="###,###,###,###"/></td> --%>
                                            
                                            <c:if test="${stocklist.stock_diff lt 0}" >
                                            <td style="color:blue"><fmt:formatNumber value="${stocklist.stock_close}" pattern="###,###,###,###"/></td>
                                            </c:if>
                                             <c:if test="${stocklist.stock_diff gt 0}" >
                                          		 <td style="color:red"><fmt:formatNumber value="${stocklist.stock_close}" pattern="###,###,###,###"/></td>
                                            </c:if>
                                             <c:if test="${stocklist.stock_diff eq 0}" >
                                        	    <td><fmt:formatNumber value="${stocklist.stock_close}" pattern="###,###,###,###"/></td>
                                            </c:if>
                                            
                                            
                                  
                                  
                                  
                                  
                                            <c:if test="${stocklist.stock_diff lt 0}" >
                                            <td style="color:blue">▼<fmt:formatNumber value="${Math.abs(stocklist.stock_diff)}" pattern="###,###,###,###"/></td>
                                            </c:if>
                                             <c:if test="${stocklist.stock_diff gt 0}" >
                                          		 <td style="color:red">▲ <fmt:formatNumber value="${stocklist.stock_diff}" pattern="###,###,###,###"/></td>
                                            </c:if>
                                             <c:if test="${stocklist.stock_diff eq 0}" >
                                        	    <td>${stocklist.stock_diff}</td>
                                            </c:if>
                                           
                               <td>	 <a class="blue" href="${pageContext.request.contextPath}/stock/report/${stocklist.stock_code}">바로가기</a>
                               		</td>
                                            <td><div class="price-btn blue">
                                    <a class="blue" href="${pageContext.request.contextPath}/stock/buysell/${stocklist.stock_code}">주문</a>
                               </div></td>
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
		<!-- all js here -->
        <!-- Start Footer Area -->
   <jsp:include page="../footer.jsp"/>
   
        <!-- End Footer area -->
		
		
	</body>
</html>