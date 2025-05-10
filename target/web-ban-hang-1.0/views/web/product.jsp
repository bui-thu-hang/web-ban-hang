<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Thái minh</title>
</head>

<body>

	<div id="banner" class="carousel slide" data-ride="carousel">   
        <img src="<c:url value='/template/web/images/banner7.jpg'/>" alt="">
    </div>
   <div class="row">
     <div class="container py-5">
        <div class="col-md-2 mb-5">
        
             <form action="<c:url value='/san-pham'/>" id="formSubmit" method="get">
                     <h4>Chọn theo giá</h4>
                    <div class="form-group">
                      <label for="">Từ</label>
                      <input type="text" name="down" id="down" class="form-control" value="" >
                    </div>
                    <div class="form-group">
                        <label for="">Đến</label>
                        <input type="text" name="up" id="up" class="form-control" value="" >
                    </div> 
                     <input type="hidden" value="${category}" id="category" name="category"/>                                                                                                      
                    <button class="btn btn-success" id="btnSort" type="submit">Tìm kiếm</button>
             </form>
           </div>
       </div>
    </div> 
    
    <div class="container my-5">
        <div class="row">
        <c:forEach var="item" items="${model}">
          <div class="col-md-4 col-sm-6 mb-3">
            <div class="card text-center my-border">
                <img class="card-img-top" src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="">    
                      <h3 class="card-title my-chu ">${item.productName}</h3>
                      <h4 class="card-text my-chu"> giá: ${item.productPrice}đ</h4> 
                       <c:url var="detailURL" value="/chi-tiet">
						   <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-info mx-2" href='${detailURL}'>Chi tiết</a>                     
                       <c:url var="cartURL" value="/gio-hang">
						  <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2" href='${cartURL}'>Thêm và đi đến giỏ hàng</a> 
            </div>  
          </div>
        </c:forEach>	                 
        </div>
    </div>
    
    <!-- footer -->
   
   
   
<!-- <script>  
  
   $('#btnSort').click(function(e) {										    
		
	     $('#name').val();
	     $('#category').val();
		 $('#formSubmit').submit();
	});
</script>  -->   
</body>

</html>