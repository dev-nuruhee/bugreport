<!doctype html>
<html lang="en">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link href="<c:url value="/css/basic_new.css" />" rel="stylesheet">
</head>
<script>
function Mainsearch(currentPage){
	var cate_result = $("select[name=cate]").val();
	var counting_result = $("select[name=countinglist]").val();
	var log_result = $("select[name=loglist]").val();

	$("#gubun").val(cate_result);
    if($("#logtype").val()=='recentcollect'){
		$("#counting").val(10);
	}else{
	    $("#counting").val(counting_result);
	}
    $("#logtype").val(log_result);
    $("#currentPage").val(currentPage);

	if(cate_result == 'bill'){
		document.mainform.action='bill.do';
		document.mainform.submit();
	}else if(cate_result == 'minutes'){
		document.mainform.action='minutes.do';
		document.mainform.submit();
	}else if(cate_result == 'pollicy'){
		document.mainform.action='pollicy.do';
		document.mainform.submit();
	}
}

function MovingPage(movingPage, gubun, logtype, counting, sorting){
    $("#gubun").val(gubun);
    $("#logtype").val(logtype);
    $("#counting").val(counting);
    $("#currentPage").val(movingPage);
    $("#sorting").val(sorting);

    if(gubun == 'bill'){
		document.mainform.action='bill.do';
		document.mainform.submit();
	}else if(gubun == 'minutes'){
		document.mainform.action='minutes.do';
		document.mainform.submit();
	}else if(gubun == 'pollicy'){
		document.mainform.action='pollicy.do';
		document.mainform.submit();
	}
}

</script>

<title>국회지방의회 의정정보시스템</title>

<body class="bg_top">

<div id="wrapper" class="clear2">
<!--해더고정-->
<div class="header" id="myHeader">
<!-- search area start -->
<div class="search_area">			
<div class="search_wrap clear2">              
  <h1 class="logo" title="국회지방의회 의정정보시스템 관리도구"></h1>
</div>			
</div>
<!--// search area end -->
		
</div>
<!--//해더고정-->
<!-- content start -->
<div class="content">

	<!-- Parameter -->
	<form name="mainform" method="post">
	<input type="hidden" name="gubun" id="gubun" value="${gubun}">
	<input type="hidden" name="logtype" id="logtype" value="${logtype}">
	<input type="hidden" name="counting" id="counting" value="${counting}">
	<input type="hidden" name="sorting" id="sorting" value="${sorting}">
	<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
	<input type="hidden" name="resultlist" id="resultlist" value="${resultlist}">
	</form>
	
	<div class="result_right">
                                                                                                    
	<div class="restul_group fl_no" style="width:1200px;">
			<div class="result_opt clear2">
				<ul>
					<li>
					gubun : ${gubun}
					</li>
					<li>
					logtype : ${logtype}
					</li>
					<li>
					counting : ${counting}
					</li>
				
					<li><span>구분</span>
						<select name="cate" id="select02" class="sel_type1" title="구분">
									<option value="bill" selected="selected">의안</option>
									<option value="minutes">회의록</option>
									<option value="pollicy">정책자료</option>                                           
						</select>
					</li>
					<li><span>형태</span>
						<select name="loglist" id="select02" class="sel_type1" title="형태">
									<option value="deadlink" 
									<c:if test="${logtype eq 'deadlink'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>데드링크</option>
									<option value="errorlog"
									<c:if test="${logtype eq 'errorlog'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>에러</option>
									<option value="recentcollect"
									<c:if test="${logtype eq 'recentcollect'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>최근수집 내역</option>                                           
						</select>
					</li>
				   <a href="#" class="btn_search" onclick="Mainsearch('1')")>검색</a>
				</ul>
		    </div>
			<div class="result_tit mt_40">의안<span>(${totalsize}건)</span>
						<ul class="sorting">
						<c:choose>
						<c:when test="${logtype eq 'recentcollect'}">
									<li><a href="#" <c:if test="${sorting eq 'correct'}">
    								<c:out value="class=on" />
									</c:if> onclick="MovingPage('1', 'bill', '${logtype}', '10', 'correct')">지역순</a><span></span></li>
									<li><a href="#" <c:if test="${sorting eq 'recent'}">
    								<c:out value="class=on" />
									</c:if> onclick="MovingPage('1', 'bill', '${logtype}', '10', 'recent')">상태순</a><span></span></li>
									<%-- <li>
									<select name="countinglist" id="select02" class="sel_type2" title="10개">
									<option value="10" <c:if test="${counting eq '10'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>10개</option>
									<option value="20"<c:if test="${counting eq '20'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>20개</option>
									<option value="30"<c:if test="${counting eq '30'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>30개</option>                                           
							  		</select>
							  		</li> --%>
						</c:when>
						
						<c:otherwise>
									<li><a href="#" <c:if test="${sorting eq 'correct'}">
    								<c:out value="class=on" />
									</c:if> onclick="MovingPage('1', 'bill', '${logtype}', '10', 'correct')">정확도순</a><span></span></li>
									<li><a href="#" <c:if test="${sorting eq 'recent'}">
    								<c:out value="class=on" />
									</c:if> onclick="MovingPage('1', 'bill', '${logtype}', '10', 'recent')">개수순</a><span></span></li>
									<li>
									<select name="countinglist" id="select02" class="sel_type2" title="10개">
									<option value="10" <c:if test="${counting eq '10'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>10개</option>
									<option value="20"<c:if test="${counting eq '20'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>20개</option>
									<option value="30"<c:if test="${counting eq '30'}">
    								<c:out value="selected=\"selected\"" />
									</c:if>>30개</option>                                           
							  		</select>
							  		</li>
						</c:otherwise>
						</c:choose>
						</ul>
			</div>
			<div class="result_list">
					<table class="tbl_type04 mt_20 mb_20" summary="전자문서">
					<caption>정책자료</caption>
					<colgroup>
						<col>
						<col>
					</colgroup>

					<thead>
					<tr>
						<c:choose>
						<c:when test="${logtype eq 'recentcollect'}">
						<th scope="col" width="15%;">번호</th>
						<th scope="col" width="25%;">지역</th>
						<th scope="col" width="20%;">RASMBLY_ID</th>
						<th scope="col">개수</th>
						<th scope="col" width="20%;">상태</th>
						</c:when>
						
						<c:otherwise>
						<th scope="col" width="5%;">번호</th>
						<th scope="col" width="15%;">지역</th>
						<th scope="col" width="20%;">RASMBLY_ID</th>
						<th scope="col">url</th>
						<th scope="col" width="10%;">상태</th>
						</c:otherwise>
						</c:choose>
					</tr>
					</thead>
							<tbody>
							<c:choose>
								<c:when test="${fn:length(resultlist) eq 0}">
										검색 결과가 없습니다.
								</c:when>
								<c:otherwise>
									<c:forEach var="i" begin="0" end="${fn:length(resultlist)-1}">
										<tr>
											<td class="t_c">${resultlist[i].MAINSEQ}</td>
											<td class="t_c">${resultlist[i].RASMBLY_NM}</td>
											<td class="t_c">${resultlist[i].RASMBLY_ID}</td>
											<td class="t_c">${resultlist[i].URL}</td>
											<td class="t_c">
											<c:choose>
												<c:when test="${logtype eq 'recentcollect'}">
													<c:choose>
														<c:when test="${resultlist[i].ERROR_CODE eq '최근 한달내 수집 없음'}">
														<div style="color:red; font-weight:bold;">${resultlist[i].ERROR_CODE}</div>
														</c:when>
														<c:otherwise>
														<div style="font-weight:bold;">${resultlist[i].ERROR_CODE} </div>
														</c:otherwise>
											</c:choose>
												</c:when>
												<c:otherwise>
														<div style="font-weight:bold;">${resultlist[i].ERROR_CODE} </div>
												</c:otherwise>
											</c:choose> 
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
                    <!--paging start-->
                    ${paging}
                    <!--//paging end-->
			</div>


	</div>
	
	</div>
<div class="copyright">ⓒ 2020 국회도서관. All Rights Reserved.</div>	
</div>

<!--// content end -->

</div>
<script>
window.onscroll = function() {myFunction()};

var header = document.getElementById("myHeader");
var sticky = header.offsetTop;

function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}
</script>

</body>
</html>
