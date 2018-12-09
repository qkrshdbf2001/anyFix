<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script>
$(document).ready(function(){
	
	$('.ajaxButton').click(function() {
		var check = $(this).attr('data-check');
		$.ajax({
			type : 'POST',
			url  : 'qa11Ajax.do',
			data : {"check" : check},
			dataType: "JSON",
			success:function(data) {
				var html = "";
				var $tbody = $('tbody');
				$tbody.html(html);
				
				$.each(data, function() {
					html +="<tr>";
					html +=     "<td><span class='text-primary'>" + this.code + "</span></td>";
					html +=		"<td>" + this.id + "</td>";
					html +=		"<td>" + this.reg_date + "</td>";
					html +=		"<td class='td-actions'>";
					html +=			"<a href='adQa-Write11Form.do?code=" + this.code + "'><i class='la la-edit edit'></i></a>";
					html +=			"<a href='adQa-Delete11.do?originNo=" + this.originNo + "'><i class='la la-close delete'></i></a>";
					html +=		"</td>";
				
					if (this.ad_check == 1) {
						html +="<td>";
						html +=	"	<a href='adQa-Detail11.do?originNo=" + this.originNo + "'><button type='button' class='btn btn-danger ripple mr-1 mb-2'>보기</button></a>"
						html +="</td>"
					} else {
						html +="<td>";
						html +="</td>"
					}
			        html +="</tr>";
				});
				$tbody.html(html);
			},
			
			error:function() {
				alert("에러발생");
			}
		}) 
	});
});


</script>


<div class="container-fluid">
	<!-- Begin Page Header-->
	<div class="row">
	    <div class="page-header">
	     <div class="d-flex align-items-center">
	         <h2 class="page-header-title">1:1문의</h2>
	     </div>
	    </div>
	</div>
	
	<div class="row flex-row">
	    <div class="col-xl-12">
	        <!-- Begin Widget 07 -->
	        <div class="widget widget-07 has-shadow">
	            <!-- Begin Widget Header -->
	            <div class="widget-header bordered d-flex align-items-center">
	                <h2>1:1문의 리스트</h2>
	                <div class="row">
						<div class="col-sm-12 col-md-12 left">
							<div id="sorting-table_filter" class="dataTables_filter">
								<label>Search:<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="sorting-table"></label>
							</div>
						</div>
					</div>
	            </div>
	            <!-- End Widget Header -->
	            <!-- Begin Widget Body -->
	            <div class="widget-body">
	                <div class="table-responsive table-scroll padding-right-10" style="max-height:520px;">
	                    <table class="table table-hover mb-0">
	                        <thead>
	                            <tr>
	                                <th>번호</th>
	                                <th>아이디</th>
	                                <th>날짜</th>
	                                <th>답변작성 / 글삭제</th>
	                                <th>답변</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                        	<c:forEach var="list" items="${list }">
	                            <tr>
	                                <td><span class="text-primary">${list.code }</span></td>
	                                <td>${list.id }</td>
	                                <td>${list.reg_date }</td>
	                                <td class="td-actions">
	                                    <a href="adQa-Write11Form.do?code=${list.code }"><i class="la la-edit edit"></i></a>
	                                    <a href="adQa-Delete11.do?originNo=${list.originNo }"><i class="la la-close delete"></i></a>
	                                </td>
	                                <c:if test="${list.ad_check == 1 }">
	                                <td>
	                                	<a href="adQa-Detail11.do?originNo=${list.originNo }"><button type="button" class="btn btn-danger ripple mr-1 mb-2">보기</button></a>
	                                </td>
	                                </c:if>
	                            </tr>
	                            </c:forEach>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	            <!-- End Widget Body -->
	            <!-- Begin Widget Footer -->
	            <div class="widget-footer d-flex align-items-center">
	                <div class="mr-auto p-2">
	                    <span class="display-items">
	                    	<a class="ajaxButton" data-check=0><button type="button" class="btn btn-secondary btn-square mr-1 mb-2">전체보기</button></a>
	                    	<a class="ajaxButton" data-check=1><button class="btn btn-danger btn-square mr-1 mb-2">대기</button></a>
	                    	<a class="ajaxButton" data-check=2><button class="btn btn-success btn-square mr-1 mb-2">완료</button></a>
	                    </span>
	                </div>
	                <div class="p-2">
	                    <nav aria-label="...">
	                        <ul class="pagination justify-content-end">
	                            <li class="page-item disabled">
	                                <span class="page-link"><i class="ion-chevron-left"></i></span>
	                            </li>
	                            <li class="page-item"><a class="page-link" href="#">1</a></li>
	                            <li class="page-item active">
	                                <span class="page-link">2<span class="sr-only">(current)</span></span>
	                            </li>
	                            <li class="page-item"><a class="page-link" href="#">3</a></li>
	                            <li class="page-item">
	                                <a class="page-link" href="#"><i class="ion-chevron-right"></i></a>
	                            </li>
	                        </ul>
	                    </nav>
	                </div>
	            </div>
	            <!-- End Widget Footer -->
	        </div>
	        <!-- End Widget 07 -->
	    </div>
	</div>
</div>
