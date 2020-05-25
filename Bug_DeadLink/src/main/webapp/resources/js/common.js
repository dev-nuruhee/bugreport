
$(function(){


	
//옵션
	$('.left_opt > li:has(div) > a').addClass('parent');
	$('.left_opt > li > a.parent').click(function(){
		$('.left_opt > li > a').not($(this)).removeClass('off');
		$(this).toggleClass('off');
		$('.left_opt').find('div.left_opt_wrap').not($(this).next('div')).slideUp();
		$(this).next('div.left_opt_wrap').slideToggle();
		return false;
	});

//검색조건

	$('.left_opt_wrap ul li:has(div.opt_sub) > input').addClass('hassub');
	$('.left_opt_wrap ul li:has(input:checked) div.opt_sub').show();

	$('.left_opt_wrap ul li input:radio').click(function() {
//		if($(this).val()==0 && this.checked==true){
		if($(this).is('.hassub') && this.checked==true){
			$(this).next().next('.opt_sub').slideDown(); 
		}else{
			$(this).closest('ul').find('.opt_sub').slideUp(); 
		};
	});


//정확도 슬라이드
		$('.opt_sub ul li .slider_sort').each(function() {
			 var value = parseInt( $( this ).text(), 10 );
			$( this ).empty().slider({
			  range: 'min',
			  value:value,
			  min: 0,
			  max: 10,
			  step: 1, 
			  slide: function( event, ui ) {
				   $(this).prev('.amount').val(ui.value );
		      }
			});
		   $(this).prev('.amount').val($( this ).slider('value') );
		});

//자동완성 
	$('.btn_auto').toggle(function(){
		$(this).parent().next('.auto_complete').show();	
		$(this).addClass('on');
		$(this).attr('title','자동완성 닫기');
		return false;

	},function(){
		$(this).parent().next('.auto_complete').hide();	
		$(this).removeClass('on');
		$(this).attr('title','자동완성 펼치기');
		return false;
	});

	

//첨부파일
	$('.result_file_list').hide();
	
	$('.file_view').click(function(){
		
		if($(this).hasClass('on')){
			$(this).siblings('.result_file_list').slideUp("slow");
			$(this).attr('title','첨부파일 열기');
			
		}else{
			$(this).siblings('.result_file_list').slideDown("slow");
			$(this).attr('title','첨부파일 닫기');
			
		};

		$(this).toggleClass('on');
		return false;
	});

	$('.result_file_list2').hide();
	
	$('.file_view2').click(function(){
		
		if($(this).hasClass('on')){
			$(this).siblings('.result_file_list2').slideUp("slow");
			$(this).attr('title','첨부파일 열기');
			
		}else{
			$(this).siblings('.result_file_list2').slideDown("slow");
			$(this).attr('title','첨부파일 닫기');
			
		};

		$(this).toggleClass('on');
		return false;
	});

	
//직접입력
	
	$('.date').click(function(){
		
	$('.date_in').addClass("on");

	});
	  
//도움말
	$('.help_btn').click(function(){
		
	$('.help_view').addClass("on");

	});
	$('.helpCloseImg').click(function(){
		
	$('.help_view').removeClass("on");

	});




	//상세검색
	$('#detail_search1').hide();
	
	$('.detail_search').click(function(){
		
		if($(this).hasClass('on')){
			$('#detail_search1').slideUp("fast");
			$(this).attr('title','상세검색 열기');
			
		}else{
			$('#detail_search1').slideDown("fast");
			$(this).attr('title','상세검색 닫기');
			
		};

		$(this).toggleClass('on');
		return false;
	});
	
	$('.detailclose').click(function(){
		$('.detail_search.on').click();
		return false;
	});


	
//레이아웃
	//$('.tbl_type01 tr:even').addClass('tr_bg'); //even, odd
	$('.relation_keyword ul li:last-child').css('background','none');
	$('.result_date span:last-child').css('background','none');
});	
//미리보기
function file_preview(preview){
	if(document.getElementById(preview).style.display == "block"){
		document.getElementById(preview).style.display = "none";
	}
	else{
		document.getElementById(preview).style.display = "block";
	}
}

