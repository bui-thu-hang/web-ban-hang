<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="userURL" value="/quan-tri/user/danh-sach"/>
<c:url var="editUserURL" value="/quan-tri/user/chinh-sua"/>
<c:url var="userAPI" value="/api/user"/>
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
							  <label for="roleCode" class="col-sm-3 control-label no-padding-right">Vai trò:</label>
							  <div class="col-sm-9">
							  	 <form:select path="roleCode" id="roleCode">
							  	 	<form:option value="" label="-- Chọn thể loại --"/>
							  	 	<form:options items="${roles}"/>
							  	 </form:select>
							  </div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên đăng nhập</label>
								<div class="col-sm-9">
									<form:input path="userName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Họ và Tên</label>
								<div class="col-sm-9">
									<form:input path="fullName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Mật khẩu người dùng</label>
								<div class="col-sm-9">
								    <form:input path="passWord" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Số điện thoại/email</label>
								<div class="col-sm-9">
								    <form:input path="phoneEmail" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Trạng thái</label>
								<div class="col-sm-9">
                                  <select id="status" name="status">                                     
                                       <option value="0" <c:if test="${model.status == 0}">selected="selected"</c:if>>Chưa duyệt người dùng</option>
                                       <option value="1" <c:if test="${model.status == 1}">selected="selected"</c:if>>Đã duyệt người dùng</option>                                                
                                  </select>              
                                 </div>   
						</div>
						<form:hidden path="id" id="userId"/>
						<div>
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật người dùng
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm người dùng
												</button>
											</c:if>
											&nbsp; &nbsp; &nbsp;																						
											<a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2 bigger-140" href="${userURL}?page=1&limit=2">
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
	    var id = $('#userId').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addNew(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	 window.location.href = "${userURL}?page=1&limit=2&message=insert_success";            	            	
            },
            error: function (error) {
            	window.location.href = "${userURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${userAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editUserURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>