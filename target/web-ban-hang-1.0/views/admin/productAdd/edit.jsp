<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="productAddURL" value="/quan-tri/gio-hang/danh-sach"/>
<c:url var="editProductAddURL" value="/quan-tri/gio-hang/chinh-sua"/>
<c:url var="productAddAPI" value="/api/productAddAmin"/>
<html>
<head>
<title>Thái Minh</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/quan-tri/trang-chu">Home</a>
				</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">										
						<div class="form-group">
							  <label for="productCode" class="col-sm-3 control-label no-padding-right">Sản phẩm</label>
							  <div class="col-sm-9">
							  	 <form:select path="productCode" id="productCode">
							  	 	<form:option value="" label="-- Chọn sản phẩm --"/>
							  	 	<form:options items="${products}"/>
							  	 </form:select>
							  </div>
						</div>
						<div class="form-group">
							  <label for="userPhoneEmail" class="col-sm-3 control-label no-padding-right">Thuộc giỏ hàng của</label>
							  <div class="col-sm-9">
							  	 <form:select path="userPhoneEmail" id="userPhoneEmail">
							  	 	<form:option value="" label="-- Chọn người sở hữu --"/>
							  	 	<form:options items="${users}"/>
							  	 </form:select>
							  </div>
						</div>												
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Số lượng thêm giỏ hàng</label>
								<div class="col-sm-9">
									<form:input path="numberAdd" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Số lượng đã mua</label>
								<div class="col-sm-9">
								    <form:input path="numberShopp" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>						
						<form:hidden path="id" id="newId"/>
						<div>
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật sản phẩm
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm sản phẩm
												</button>
											</c:if>
											&nbsp; &nbsp; &nbsp;																						
											<a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2 bigger-140" href="${productAddURL}?page=1&limit=5">
											<i class="ace-icon fa fa-undo bigger-90"></i>
											Hủy </a> 
											
							</div>		
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>	

<script>
	$('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#newId').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addNew(data) {
		$.ajax({
            url: '${productAddAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	 window.location.href = "${productAddURL}?page=1&limit=5&message=insert_success";            	            	
            },
            error: function (error) {
            	window.location.href = "${productAddURL}?page=1&limit=5&message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${productAddAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editProductAddURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editProductAddURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>