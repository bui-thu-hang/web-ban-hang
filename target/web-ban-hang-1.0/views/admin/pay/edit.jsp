<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="payURL" value="/quan-tri/don-hang/danh-sach"/>
<c:url var="editPayURL" value="/quan-tri/don-hang/chinh-sua"/>
<c:url var="payAPI" value="/api/payAmin"/>
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
							  <label for="userPhoneEmail" class="col-sm-3 control-label no-padding-right">Đơn hàng của</label>
							  <div class="col-sm-9">
							  	<form:select path="userPhoneEmail" id="userPhoneEmail">
							  	 	<form:option value="" label="-- Chọn người đặt hàng --"/>
							  	 	<form:options items="${users}"/>
							  	 </form:select>
							  </div>
						</div>                    																	
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên người mua</label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tổng tiền</label>
								<div class="col-sm-9">
								    <form:input path="totalPrice" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Số điện thoại</label>
								<div class="col-sm-9">
								    <form:input path="phone" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>	
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Nơi nhận hàng</label>
								<div class="col-sm-9">
								    <form:input path="address" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>	
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Trạng thái</label>								                               
                                <div class="col-sm-9">
                                  <select id="status" name="status">                                     
                                       <option value="0" <c:if test="${model.status == 0}">selected="selected"</c:if>>Chưa thanh toán</option>
                                       <option value="1" <c:if test="${model.status == 1}">selected="selected"</c:if>>Đã thanh toán</option>                                                
                                  </select>              
                                 </div>                                                                                                    																			
						</div>	
												
						<form:hidden path="id" id="newId"/>
						<div>
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật hóa đơn
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm hóa đơn
												</button>
											</c:if>
											&nbsp; &nbsp; &nbsp;																						
											<a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2 bigger-140" href="${payURL}?page=1&limit=5">
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
            url: '${payAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	 window.location.href = "${payURL}?page=1&limit=5&message=insert_success";            	            	
            },
            error: function (error) {
            	window.location.href = "${payURL}?page=1&limit=5&message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${payAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editPayURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editPayURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>