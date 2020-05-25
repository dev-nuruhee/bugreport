<!doctype html>
<html lang="en">
<head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/basic_new.css" />" rel="stylesheet">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
</head>
<title>국회지방의회 의정정보시스템 관리도구</title>



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
	
	<div class="result_right">

	<div class="restul_group fl_no" style="width:1200px;">
			<div class="result_opt clear2">
				<ul>
					<li><span>구분</span>
						<select id="select02" class="sel_type1" title="구분">
									<option>의안</option>
									<option>회의록</option>
									<option>정책자료</option>                                           
						</select>
					</li>
					<li><span>형태</span>
						<select id="select02" class="sel_type1" title="형태">
									<option>데드링크</option>
									<option>에러</option>
									<option>최근수집 내역</option>                                           
						</select>
					</li>
				   <a href="#" class="btn_search">검색</a>
				</ul>
		    </div>
			<div class="result_tit mt_40">정책자료<span>(130건)</span>
						<ul class="sorting">
						<li><a href="#" class="on">정확도순</a><span></span></li>
						<li><a href="#">최근순</a><span></span></li>
						<li><select id="select02" class="sel_type2" title="10개">
									<option>10개</option>
									<option>20개</option>
									<option>30개</option>                                           
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
						<th scope="col" width="15%;">기관명</th>
						<th scope="col" width="20%;">게시판명</th>
						<th scope="col">url</th>
						<th scope="col" width="10%;">상태</th>
					</tr>
					</thead>

					<tbody>
					<tr>
						<td class="t_c">1</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">2</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">3</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">4</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">5</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">5</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">6</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">7</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">8</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">9</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
					<tr>
						<td class="t_c">10</td>
						<td class="t_c">경상남도청</td>
						<td class="t_c">홍보/보도/소식</td>
						<td class="t_c">http://www.gyeongnam.go.kr/board/view.gyeong?boardId=BBS_0000060&menuCd=DOM_000000104001003000&paging=ok&startPage=2&categoryCode1=A&dataSid=41251216</td>
						<td class="t_c">D</td>
					</tr>
                    </tbody>
                    </table>
                    <!--paging start-->
                    <div class="paging clear2 mt_25">
					<span class="btn_page first"><a title="처음" href="#"></a></span>
					<span class="btn_page prev"><a title="이전" href="#"></a></span>

					<span><a href="#">1</a></span>
					<span><a href="#">2</a></span>
					<span class="on">3</span>
					<span><a href="#">4</a></span>
					<span><a href="#">5</a></span>
					<span><a href="#">6</a></span>
					<span><a href="#">7</a></span>
					<span><a href="#">8</a></span>
					<span><a href="#">9</a></span>
					<span><a href="#">10</a></span>

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
