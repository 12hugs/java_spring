<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// HTML 구조가 다 로딩이 된 후에 loadList()를 실행시키겠다는 말.
		loadList();
	});

	function loadList() {
		// BoardController에서 게시글 전체목록을 가져오는 기능
		// ajax 사용
		// Java Script Object Notation -> JS 객체표현 방식
		// {key : value, key : value, .....}
		$.ajax({
			url : "board/all",
			type : "get",
			dataType : "json",
			success : makeView, // callback함수
			error : function() {
				alert("에러");
			}
		});
	}

	// 성공 시 실행할 makeView 함수 만들기
	function makeView(data) { // data는 배열 형태로 넘어옴.
		console.log(data);

		var listHtml = "<table class='table table-bordered'>";

		listHtml += "<tr>";
		listHtml += "<td>번호</td>";
		listHtml += "<td>제목</td>";
		listHtml += "<td>작성자</td>";
		listHtml += "<td>작성일</td>";
		listHtml += "<td>조회수</td>";
		listHtml += "</tr>";

		// jQuery 반복문
		$.each(data, function(index, obj) {
			listHtml += "<tr>";
			listHtml += "<td>" + (index + 1) + "</td>"
			listHtml += "<td id='t"+obj.idx+"'><a href='javascript:goContent("+obj.idx+")'>" + obj.title + "</a></td>"
			listHtml += "<td>" + obj.writer + "</td>"
			listHtml += "<td>" + obj.indate.split(" ")[0] + "</td>"
			listHtml += "<td id='count"+obj.idx+"'>" + obj.count + "</td>"
			listHtml += "</tr>";
			
			// 상세 게시글 보여주기
			listHtml += "<tr id='c"+obj.idx+"' style='display:none';>";
			listHtml += "<td>내용</td>";
			listHtml += "<td colspan=4>"
			listHtml += "<textarea id='ta"+obj.idx+"' readonly class='form-control' rows='7'>";
			
			listHtml += "</textarea><br>";
			
			// 수정, 삭제 버튼 만들기
			listHtml += "<span id='up"+obj.idx+"'><button class='btn btn-primary' onclick='goUpdateForm("+obj.idx+")'>수정</button></span> &nbsp";
			listHtml += "<button class='btn btn-primary' onclick='goDelete("+obj.idx+")'>삭제</button>";
			listHtml += "</td>";
			listHtml += "</tr>";
		});
		
		listHtml += "</table>";

		// 글쓰기 버튼 추가하기
		listHtml += "<a href='#' class='btn btn-primary' onclick=goForm() >글쓰기</a>";

		$("#view").html(listHtml);
		
		goList(); // 글쓰기를 완료한 후에 다시 list를 보여줘야 하기 때문

	}
	
	// 글쓰기 버튼을 눌렀을 때 글쓰기 폼을 보여주는 함수
	function goForm() {
		$("#view").css("display","none");
		$("#wform").css("display","block")
	}
	
	// 목록 버튼 눌렀을 때 리스트 보여주는 함수
	function goList() {
		$("#view").css("display","block");
		$("#wform").css("display","none")
	}
	
	// 게시글 작성(등록) : goInsert 함수 만들기
	function goInsert() {
		// 제목, 내용, 작성을 DB에 등록
		var fData = $("#frm").serialize();
		console.log(fData);
		
		$.ajax({
			url : "board/new",
			type : 'post',
			data : fData,
			success : loadList,
			error : function(){
				alert("error");
			}
		});
		
		// 새로고침을 누르지 않는 이상 값이 계속 남아있기 때문에 
		// 초기화 버튼을 눌러주기 위한 코드
		$("#fclear").trigger("click"); 
				
	}
		
	// 게시물 상세보기 : goContent 함수 만들기
	function goContent(idx) {
		if($("#c"+idx).css("display") == "table-row"){
			$("#c"+idx).css("display","none");
			
		}else{
			// 내용 비동기 방식으로 가져온 다음 태그 형식으로 넣어주기
			$.ajax({
				url : 'board/'+idx,
				type : 'get',
				//data : {"idx" : idx},
				dataType : "json",
				success : function(data){
					console.log(data);
					$('#ta'+idx).text(data.content);
				},
				error : function(){
					alert('게시판 상세보기 에러')
				}
			})
			
			
			$("#c"+idx).css("display","table-row");
			
			// 조회수 올리기
			$.ajax({
				url : "board/count/"+idx,
				type : "put",
				success : function(){
					var count = $('#count'+idx).text();
					var con_count = parseInt(count)+1;
					$('#count'+idx).html(con_count);
					console.log(con_count);
				},
				error : function(){
					alert('error');
				}
			})
		}
	}
	
	// 게시글 삭제 기능 : goDelete 함수 만들기
	function goDelete(idx) {
		
		$.ajax({
			url : "board/"+idx,
			type : "Delete",
			//data : {"idx" : idx},
			success : loadList,
			error : function(){
				alert('error')
			}
		});
	}
	
	// 수정화면 만들어주는 부분
	function goUpdateForm(idx) {
		$('#ta'+idx).attr("readonly", false);
		
		var title = $("#t"+idx).text();
		var newInput = '<input type="text" id="nt'+idx+'" value="'+title+'" class="form-control">';
		$('#t'+idx).html(newInput);
		
		var newButton = '<button class="btn btn-success" onclick="goUpdate('+idx+')">등록</button>';
		$('#up'+idx).html(newButton);
	}
	
	// 게시글 수정 기능 : goUpdateForm 함수 만들기
	function goUpdate(idx){
		var title = $('#nt'+idx).val(); // 제목
		var content = $('#ta'+idx).val(); // 내용
		console.log(title);
		console.log(content);
		
		
		$.ajax({
			url : 'board/update',
			type : 'put', // put방식은 json 형식을 인식하지 못함
			contentType : "application/json; charset=UTF-8", // put방식에서 타입 명시
			// javascript에서 쓰이는 자바객체(클래스)를 활용해서 보내줘야함
			data : JSON.stringify ({'idx' : idx, 'title' : title, 'content' : content}),
			success : loadList,
			error : function(){
				alert('error');
			}
		})
	}
</script>

</head>
<body>

	<div class="container">
	<jsp:include page="../common/header.jsp"></jsp:include>
		<h2>SpringMVC02</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body" id="view"></div>

			<!-- 글쓰기 폼 -->
			<div class="panel-body" style="display: none;" id="wform">
				<form id="frm">
					<table class="table">

						<tr>
							<td>제목</td>
							<td><input type="text" name="title" id="title"
								class="form-control"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="content" id="content" rows="7" cols=""
									class="form-control"></textarea></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" name="writer" id="writer"
								class="form-control"></td>
						</tr>

					</table>
					<div class="d-flex justify-content-center">
						<button type="button" class="btn btn-primary mr-3" onclick="goInsert()">등록</button>
						<button type="reset" class="btn btn-primary" id="fclear">초기화</button>
						<button type="button" class="btn btn-primary ml-3" onclick="goList()">목록</button>
					</div>
				</form>
			</div>
			<div class="panel-footer">스프링게시판-진영준</div>
		</div>
	</div>


</body>
</html>
