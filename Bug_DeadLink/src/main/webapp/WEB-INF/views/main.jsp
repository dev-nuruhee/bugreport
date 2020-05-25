<!doctype html>
<html lang="en">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<link href="<c:url value="/css/basic_new.css" />" rel="stylesheet">
</head>
<script>
function Mainsearch(currentPage){
	var cate_result = $("select[name=cate]").val();
	var log_result = $("select[name=loglist]").val();
	var counting_result = $("select[name=countinglist]").val();
    $("#gubun").val(cate_result);
    $("#logtype").val(log_result);
    $("#counting").val(counting_result);
    $("#currentPage").val(currentPage);
    $("#sorting").val('correct');
    
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
	</form>
	
	<div class="result_right">

	<div class="restul_group fl_no" style="width:1200px;">
			<div class="result_opt clear2">
				<ul>
					<li><span>구분</span>
						<select name="cate" id="select02" class="sel_type1" title="구분">
									<option value="bill">의안</option>
									<option value="minutes">회의록</option>
									<option value="pollicy">정책자료</option>                                           
						</select>
					</li>
					<li><span>형태</span>
						<select name="loglist" id="select02" class="sel_type1" title="형태">
									<option value="deadlink">데드링크</option>
									<option value="errorlog">에러</option>
									<option value="recentcollect">최근수집 내역</option>                                           
						</select>
					</li>
				   <a href="#" class="btn_search" onclick="Mainsearch('1')")>검색</a>
				</ul>
		    </div>
			<div class="result_tit mt_40">의안<span>(0건)</span>
						<ul class="sorting">
						<li><a href="#" class="on">정확도순</a><span></span></li>
						<li><a href="#">최근순</a><span></span></li>
						<li><select name="countinglist" id="select02" class="sel_type2" title="10개">
									<option value="10" selected="selected">10개</option>
									<option value="20">20개</option>
									<option value="30">30개</option>                                           
							  </select></li>
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
						<th scope="col" width="5%;">번호</th>
						<th scope="col" width="15%;">지역</th>
						<th scope="col" width="20%;">RASBLY_ID</th>
						<th scope="col">url</th>
						<th scope="col" width="10%;">상태</th>
					</tr>
					</thead>

					<tbody>
                    </tbody>
                    </table>
                    <!--paging start-->
                    <div class="paging clear2 mt_25">
					<span class="btn_page first"><a title="처음" href="#"></a></span>
					<span class="btn_page prev"><a title="이전" href="#"></a></span>

					<span><a href="on">1</a></span>
					<!--  <span><a href="#">2</a></span>-->
					<span class="btn_page next"><a title="다음" href="#"></a></span>
					<span class="btn_page last"><a title="마지막" href="#"></a></span>
				</div>
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
