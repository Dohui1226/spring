<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="bsc-tbl-st">
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					<div id="recc">
		
						 <table width="70%" class="table table-striped">
                         	<thead>
                         	<tr>
                         	<th width="15%" align="center">종목타입</th>
                         	<th width="15%" align="center">종목명</th>
  							<th width="15%" align="center">수량</th>
  						
                         	</tr>
                         	</thead>
                                <tbody>
                                 <c:forEach items="${requestScope.port2}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                        <td style="vertical-align:middle" rowspan="${fn:length(ranklist.value)}" >
                                        <strong>${ranklist.key}</strong><br><br>&nbsp;&nbsp;
                                        </td>
                                   			
                                   		 <c:forEach items="${ranklist.value}" var="ranklist1" varStatus="loop"> 
                                   			 <td>${ranklist1.key}</td>
                                   			 <td>${ranklist1.value} 주</td> </tr> 
                                   		
                                   		</c:forEach>
                                   			
                                    
                                    </c:forEach>
                                </tbody>
                            </table>
                            <p>${nickname}</p>님<br>
					 현재 현금/예수금 <fmt:formatNumber value="${balance}" pattern="###,###,###,###"/>원으로 <br>
            
					 해당 금액 및 포트폴리오와 알맞은 최적의 매수 종목 및 타입은 아래와 같습니다.
						</div>
					</div>
					</div>
</body>
</html>