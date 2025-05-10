<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="categoryURL" value="/quan-tri/the-loai/danh-sach"/>
<c:url var="editCategoryURL" value="/quan-tri/the-loai/chinh-sua"/>
<c:url var="categoryAPI" value="/api/category"/>
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
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên thể loại</label>
								<div class="col-sm-9">
									<form:input path="categoryName" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Code thể loại</label>
								<div class="col-sm-9">
								    <form:input path="categoryCode" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>						
						<form:hidden path="id" id="categoryId"/>
						<div>
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật thể loại
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm thể loại
												</button>
											</c:if>
											&nbsp; &nbsp; &nbsp;																						
											<a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2 bigger-140" href="${categoryURL}?page=1&limit=2">
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
	    var id = $('#categoryId').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addNew(data) {
		$.ajax({
            url: '${categoryAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	 window.location.href = "${categoryURL}?page=1&limit=2&message=insert_success";            	            	
            },
            error: function (error) {
            	window.location.href = "${categoryURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${categoryAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${editCategoryURL}?id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editCategoryURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>