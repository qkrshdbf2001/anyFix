<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script language="javascript"> 
	$(document).ready(function(){
		$('#noticeButton').click(function() {
			$title = $('#title');
			$content = $('#content1');
			
			var title = $title.val();
			var content = $content.val();
			
			if (title == "") {
				alert("제목을 입력해주세요");
				return;
			} 
			
			if (content == "") {
				alert("내용을 입력해주세요");
				return;
			}
			
			$('#noticeForm').submit();
		});
	});
</script>    


    
<section id="page-title" class="page-title-parallax page-title-dark" style="padding: 250px 0; background-image: url('images/about/parallax.jpg'); background-size: cover; background-position: center center;" data-bottom-top="background-position:0px 400px;" data-top-bottom="background-position:0px -500px;">

			<div class="container clearfix">
				<h1>ANIFIT</h1>
				<span>최고의 가성비로 누구나 건강을 관리할 수 있습니다.</span>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="main.do">Home</a></li>
					<li class="breadcrumb-item"><a href="#">ANIFIT</a></li>
					<li class="breadcrumb-item active" aria-current="page"><a href="qa.do">공지사항</a></li>
				</ol>
			</div>

		</section><!-- #page-title end -->

		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap">
				<div class="container clearfix" style="margin-bottom: 175px;">
					<h4>공지사항</h4>
					<div class="col_one">
						<form id="noticeForm" name="noticeForm" action="notice-write.do" method="post">
						<table class="table table-bordered">
						  <thead>
							<tr>
							 	<th colspan="2">공지사항 작성</th>
							</tr>
						  </thead>
						  <tbody>
							<tr>
							  <td>제목</td>
							  <td><input type="text" id="title" name="title" style="width:487px" autocomplete=off/></td>
							</tr>
							<tr>
							  <td>아이디</td>
							  <td>admin</td>
							</tr>
							<tr>
							  <td>내용</td>
							  <td style=" height: 386px; "><textarea rows="25" cols="61" style="resize: none;" id="content1" name="content"  autocomplete=off></textarea></td>
							</tr>
							<tr>
								<td colspan="2">
									<a id="noticeButton" href="#" class="btn btn-secondary btn-sm fright" style=" margin-left: 3px; ">작성</a>
									<a href="notice.do" class="btn btn-secondary btn-sm fright" style=" margin-left: 3px; ">취소</a>
								</td>
							</tr>
						  </tbody>
						</table>
						</form>
					</div>
				</div>
			</div>
		</section><!-- #content end -->