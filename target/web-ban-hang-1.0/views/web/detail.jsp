<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.webbanhang.util.SecurityUtils"%>
<c:url var="detailURL" value="/chi-tiet" />
<c:url var="commentAPI" value="/api/comment" />
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Thái minh</title>
</head>

<body>

	<div id="banner" class="carousel slide" data-ride="carousel">
		<img src="<c:url value='/template/web/images/banner3.jpg'/>" alt="">
	</div>

	<!-- chia lưới -->


	<div class="modal-dialog modal-xl" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">chi tiết sản phẩm</h5>
			</div>

			<div class="modal-body">
				<div class="row">
					<div class="col-md-10">
						<img src="<c:url value='/template/web/images/${model.codeImg}'/>"
							alt="" class="w-100">
					</div>
					<div class="col-md-12">
						<div>
							<h3>Tên sản phẩm: ${model.productName}</h3>
						</div>
						<div>
							<h4>Giá sản phẩm: ${model.productPrice} đ</h4>
						</div>
						<div>
							<h4>Nội dung sản phẩm: ${model.productContent}</h4>
						</div>
						<a href="cart.html" class="btn btn-sm btn-success">thêm vào
							giỏ hàng</a>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="mb-5 mt-5 container modal-content">
	
		<security:authorize access="isAuthenticated()">
			<form role="form" id="formSubmit" class="form-inline my-2 my-lg-0 ">
				<input type="hidden" value="${model.id}" id="productId"
					name="productId" /> <label>Viết bình luận</label>
				<textarea class="mx-3" name="commentContent" id="commentContent"
					style="width: 820px; height: 40px"></textarea>
				<button class="btn bg-success my-2 my-sm-2" type="button"
					id="commentProduct">Gửi</button>
			</form>
		</security:authorize>		   	
		<div class="modal-body">		 	
			<div id="contentView">				   	
				<c:forEach var="item" items="${comments}">
				   <%--  <input type="checkbox" id="checkbox_${item.id}" value="${item.id}"> --%>
					<b>${item.userName}: </b>${item.commentContent}<br />
				</c:forEach>						
			</div>		 
		</div>		
		<hr>
	</div>

	<script>
		$('#commentProduct').click(function(e) {
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addComment(data);

		});

		function addComment(data) {
			$.ajax({
				url : '${commentAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					var content = document.getElementById("contentView");
					content.innerHTML += "<b>" + result.userName + ":</b>"
							+ result.commentContent + "<br/>";
				},
				error : function(error) {

				}
			});
		}
		
		/* function warningBeforeDelete() {
			 swal({
					  title: "Xác nhận xóa",
					  text: "Bạn có chắc chắn muốn xóa hay không",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonClass: "btn-success",
					  cancelButtonClass: "btn-danger",
					  confirmButtonText: "Xác nhận",
					  cancelButtonText: "Hủy bỏ",					  
					}).then(function(isConfirm) {								
					  if (isConfirm && isConfirm.dismiss !=='cancel' && isConfirm.dismiss !=='overlay') {
							var ids = $('tbody input[type=checkbox]:checked').map(function () {
					            return $(this).val();
					        }).get();														
							if (ids != "") {
								deleteNew(ids);
						  }else {
							    swal("Hủy xóa", "Do chưa lựa chọn", "error");
						  }
							
					  } else {
						    swal("Hủy xóa", "Do bạn lựa chọn hủy", "error");
					  }
					}); 
															
			} 
			function deleteNew(data) {
		        $.ajax({
		            url: '${commentAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {		            	
		               window.location.href = "${detailURL}"; 	         
		            },
		            error: function (error) {
		               window.location.href = "${detailURL}"; 
		            }
		        });
		    } */
	</script>
</body>

</html>