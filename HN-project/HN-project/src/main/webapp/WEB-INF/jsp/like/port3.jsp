<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>


<meta charset="UTF-8">
<jsp:include page="../header.jsp" />

 
	
		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
		
		
		
					<div id="recc">
					<script>
					
					
		
								var hdata = new Array();
								var hipeLabels = new Array();
							
								<c:forEach var="list1" items="${port2}" varStatus="listIdx"  >
								hipeLabels.push("${list1.key}");
							
								  <c:set var="i" value="0" />
								<c:forEach var="list2" items="${list1.value}" varStatus="listIdx"  >
								
								<c:if test="${i == 1 }"> 
								hdata.push("${list2}");
								</c:if>
								<c:set var="i" value="${i+1 }" />
								</c:forEach>
							</c:forEach>
									
									var ctx4 = document.getElementById("myPieChart8");
									var myPieChart = new Chart(
											ctx4,
											{
												type : 'pie',
												data : {
													labels : hipeLabels,
													datasets : [ {
														data : hdata,
														backgroundColor : [
																'#5093ce',
																"#7fc77f",
																'#36b9cc',
																'#35a1cc',
																"#dd6864", ],
														hoverBackgroundColor : [
																"#78acd9",
																"#a3d7a3",
																'#2c9faf',
																'#a3d7a3',
																
																"#e6918e" ],
														hoverBorderColor : "rgba(234, 236, 244, 1)",
													} ],
												},
												options : {
													maintainAspectRatio : false,
													tooltips : {
														backgroundColor : "rgb(255,255,255)",
														bodyFontColor : "#858796",
														borderColor : '#dddfeb',
														borderWidth : 1,
														xPadding : 15,
														yPadding : 15,
														displayColors : false,
														caretPadding : 10,
														
													},
													legend : {
														display : true
													},
													pieceLabel: { 
														mode:"label",
														position:"outside",
														fontSize: 11,
														fontStyle: 'bold' 
														}

													
												}
											});
									var money ;
									function change(param){
										 
										if(param==2){
											
											  document.getElementById('add').
											  innerHTML='<input type="text" style="height: 40px; padding: 6px 12px;width:280px; font-size: 14px; line-height: 1.42857143; color: #555; background-color: #fff; background-image: none; border: 1px solid #ccc; border-radius: 4px;" id="selmoney">&nbsp;&nbsp; <button id="button-modal2" style="float:right;height:40px;" onclick="inputmoney()">??????</button>'
											
										}
										if(param!=2){
											
											 $.ajax({
													type:"post",
													url:"${pageContext.request.contextPath}/money/select",
													data:{stock_type :hipeLabels, money:param, percent:hdata},
													traditional : true,
													 dataType : "text"
												}).done(function(result){
													 let html = $('<div>').html(result) 
													
													 let content =html.find('div#tta');
													let contents =content.html();
													$("#kbc").html(contents); 
												
												})
										}
									}
									function inputmoney(){
										money =$("#selmoney").val()
									
										 $.ajax({
												type:"post",
												url:"${pageContext.request.contextPath}/money/select",
												data:{stock_type :hipeLabels, money:money, percent:hdata},
												traditional : true,
												 dataType : "text"
											}).done(function(result){
												 let html = $('<div>').html(result) 
												
												 let content =html.find('div#tta');
												let contents =content.html();
												
											
												$("#kbc").html(contents); 
											}).fail(function (jqXHR, textStatus, errorThrown) {
												console.log("??????"); 
												console.log(jqXHR);
												console.log(textStatus);
												console.log(errorThrown);
											});
										 }
					

					 
					
					
		</script>
					 <div class="support-services-red">
			
					<div>
                          <p>  <strong>${nickname}</strong>??? ????????? ???????????????.</p>
				
					  <select style="float:middle;height:40px;border-radius: 4px" name="money"  id="select" onchange="change(this.value)">
					 <option value="1" selected>?????? ?????????</option>
					 <option value="1000000">100??????</option>
					 <option value="3000000">300??????</option>
					 <option value="5000000">500??????</option>
					 <option value="2">????????? ??????</option>
					 </select>
					 <div style="float:right;height:40px" id="add"></div><br>
					 <hr>
				
					 	 
				<div class="min-height: 182.75px;">
					<canvas id="myPieChart8" height="300vh" width="480vh"></canvas>
				</div>
			</div><br>
			<br>
			<div id="kbc">
			?????? ?????? ??????/????????? <strong><fmt:formatNumber value="${balance}" pattern="###,###,###,###"/>???</strong>?????? <br>
            
					 ?????? ?????????????????? ????????? ????????? ?????? ?????? ??? ????????? ????????? ????????????.<br>
						 <table width="70%" class="table table-striped" border="1px">
                         	<thead>
                         	<tr style="background-color: #ddd">
                         	<th width="15%" align="center">????????????</th>
                         	<th width="20%" align="center">?????????</th>
                         	<!-- <th width="15%" align="center">??????(%)</th> -->
  							<th width="15%" align="center">??????(???)</th>
  						
                         	</tr>
                         	</thead>
                                <tbody>
                                <c:set var="i" value="0" />
                                <c:set var="j" value="3" />
                            
                             
                                 <c:forEach items="${requestScope.port2}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                      <td style="vertical-align:middle;text-align: center" rowspan="${fn:length(ranklist.value)/3}" >
                                        <strong>${ranklist.key}</strong>
                                  
                                        </td>
                                   			
                                   		 <c:forEach items="${ranklist.value}" var="ranklist1" varStatus="loop"> 
                                   			<c:if test="${i%j == 0 }"> 
                                   			<td style="vertical-align: middle;text-align: center">${ranklist1}</td> 
                                   			</c:if>
                                   			 
                                   			<%--  <c:if test="${i%j == 1 }">        
                                   			
                                   			                        			 
                                   			<td style="vertical-align: middle;text-align: center">${ranklist1}</td>
                                   			 
                                   			</c:if>
                                   			 --%>
                                   		 <c:if test="${i%j == 2 }">  
                                   		 	<td style="vertical-align: middle;text-align: center" >${ranklist1}</td>
                                   		 	</tr>
                                   		 	
                                   		 </c:if>      
                                   		<c:set var="i" value="${i+1 }" />

                                   		</c:forEach>
                                   			<br>
                                   			
                                    
                                    </c:forEach>
                                </tbody>
                            </table>
                            </div>
						</div>
					</div>
			
					
				
					
				
					</div>
					

</html>