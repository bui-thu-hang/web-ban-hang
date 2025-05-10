<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="loginAPI" value="/api/login" />
<c:url var="loginURL" value="/dang-nhap" />
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Thái minh</title>
</head>

<body>

    <!-- chia lưới -->

    <div class="container my-5">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Dược Phẩm Thái Minh</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">                  
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Bootstrap CSS -->
                    <!-- jQuery first, then Bootstrap JS. -->
                    <!-- Nav tabs -->

                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" href="#login" data-toggle="tab">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#register" data-toggle="tab">Đăng ký</a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active show" id="login">
                            <h3>Login Form</h3>
                            <c:if test="${param.incorrectAccount != null}">
					             <div class="alert alert-danger">	
							      Username hoặc password không đúng
					              </div>
				            </c:if>
				            <c:if test="${param.accessDenied != null}">
					               <div class="alert alert-danger">	
							       Bạn không có quyền vào trang này. Mời đang nhập lại
					               </div>
				            </c:if>
				            <c:if test="${login != null}">
				                 <div class="alert alert-danger">	
							       ${login}
					             </div>
					         </c:if>
                            <form action="j_spring_security_check" id="formLogin" method="post">
                                <div class="form-group">
                                    <label for="">Tên đăng nhập</label>
                                    <input type="text" name="j_username" id="userName" class="form-control"
                                        placeholder="Tên tài khoản">
                                </div>
                                <div class="form-group">
                                    <label for="">Mật khẩu</label>
                                    <input type="password" name="j_password" id="password" class="form-control"
                                        placeholder="Mật khẩu">
                                </div>
                                <div class="form-group">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input type="checkbox" class="form-check-input" value="true" checked>
                                            Ghi nhớ mật khẩu
                                        </label>
                                    </div>
                                </div> 
                                <button type="submit" class="btn btn-success">Đăng nhập</button>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="register">
                            <h3>Register Form</h3>
                            <form role="form" id="formSubmit" >
                                <div class="form-group">
                                    <label for="">Địa chỉ email/Số điện thoại</label>
                                    <input type="text" name="phoneEmail" id="phoneEmail" class="form-control"
                                        placeholder="Địa chỉ email">
                                </div>

                                <div class="form-group">
                                    <label for="">Tên đăng nhập</label>
                                    <input type="text" name="userName" id="userName" class="form-control"
                                        placeholder="Tên tài khoản">
                                </div>

                                <div class="form-group">
                                    <label for="">Họ và Tên</label>
                                    <input type="text" name="fullName" id="fullName" class="form-control"
                                        placeholder="Tên tài khoản">
                                </div>
                                
                                <div class="form-group">
                                    <label for="">Mật khẩu</label>
                                    <input type="password" name="passWord" id="passWord" class="form-control"
                                        placeholder="Mật khẩu">
                                </div>
                                <div class="form-group">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input type="checkbox" class="form-check-input" value="true" checked>
                                            Ghi nhớ mật khẩu
                                        </label>
                                    </div>
                                </div>
                                <button class="btn bg-success" type="button" id="registration">Đăng ký</button>
                                <!-- <button class="btn btn-success">Đăng ký</button> -->
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    
<script>
		$('#registration').click(function(e) {
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			addComment(data);

		});

		function addComment(data) {
			$.ajax({
				url : '${loginAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					if (result.tru == "khong") {
						window.location.href = "${loginURL}?login=khong";   
				    } else {
				    	window.location.href = "${loginURL}?login=duoc";   
				    }
				},
				error : function(error) {

				}
			});
		}
</script>
</body>

</html>