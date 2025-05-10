<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="cartAPI" value="/api/productAdd" />
<!DOCTYPE html>

<html>
<head>
  <meta charset="UTF-8">
  <title>Thái minh</title>
</head>

<body>

	<div id="banner" class="carousel slide " data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#banner" data-slide-to="0" class="active"></li>
            <li data-target="#banner" data-slide-to="1"></li>
            <li data-target="#banner" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img src="<c:url value='/template/web/images/banner1.png'/>" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/template/web/images/banner8.jpg'/>" alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value='/template/web/images/banner2.png'/>" alt="Third slide">
                <div class="carousel-caption d-none d-md-block">
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#banner" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#banner" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <!-- chia lưới -->

    <div class="container my-chu">
        <div class="mb-5 mt-5 text-center">
            <h2>Sản phẩm về Xương Khớp</h2>
        </div>
    </div>
    
    <div class="container "> 
        <div class="row">
          <c:forEach var="item" items="${model1}">
          <div class="col-md-6 col-sm-12 mb-4">
           <div class="card text-center my-border">
             <img class="card-img-top" src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="">
             <div class="row">
                <div class="col-md-6 my-2">
                    <h3 class="card-title my-chu ">${item.productName}</h3>
                    <h4 class="card-text my-chu"> giá: ${item.productPrice}đ</h4>
                </div>
                <div class="col-md-6 my-3">               
                    <c:url var="detailURL" value="/chi-tiet">
						<c:param name="id" value="${item.id}"/>															
				    </c:url>
                    <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-info mx-2" href='${detailURL}'>Chi tiết</a>             
                    <c:url var="cartURL" value="/gio-hang">
						<c:param name="id" value="${item.id}"/>						    								   			        													
				    </c:url>
                    <a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2" href='${cartURL}'>Thêm và đi đến giỏ hàng</a>                                                                					         			         
			         <button class="btn btn-success mx-2 my-2" type="button" id="addProduct" onclick="warningBeforeAdd(${item.id})" >Thêm vào giỏ hàng</button>  
                </div>                              																																																
             </div>
           </div>
          </div> 
		   </c:forEach>		 		 
        </div>
    </div>

    <div class="container my-chu">
        <h2 class="mb-5 mt-5 text-center">Sản phẩm về Đại Tràng</h2>
    </div>
    
    <div class="container my-5">
        <div class="row">
        
        <c:forEach var="item" items="${model2}">
          <div class="col-md-3 col-sm-6 mb-3">
            <div class="card text-center my-border">
                <img class="card-img-top" src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="">   
                      <p class="card-title my-chu ">${item.productName}</p>
<%--                  <s class="card-text my-chu"> giá cũ: ${item.productPriceOld}đ</s> --%>
                      <p class="card-text my-chu"> giá khuyến mại: ${item.productPrice}đ</p> 
                     <div>
                       <c:url var="detailURL" value="/chi-tiet">
						   <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-info mx-2" href='${detailURL}'>Chi tiết</a>                      
                       <c:url var="cartURL" value="/gio-hang">
						  <c:param name="id" value="${item.id}"/>															
				       </c:url>
                       <a data-toggle="tooltip" class="btn btn-sm btn-success mx-2 my-2" href='${cartURL}'>Thêm và đi đến giỏ hàng</a> 
                       <button class="btn btn-success mx-2 my-2" type="button" id="addProduct" onclick="warningBeforeAdd(${item.id})" >Thêm vào giỏ hàng</button>  
                     </div>  
              </div>  
           </div>
         </c:forEach>		                          
        </div>
    </div>

    <div class="container my-chu">
        <h2 class="mb-5 mt-5 text-center">Sản phẩm về Não</h2>
    </div>
    
    <div class="container my-5">
        <div class="row">
        <c:forEach var="item" items="${model3}">
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
                       <button class="btn btn-success mx-2 my-2" type="button" id="addProduct" onclick="warningBeforeAdd(${item.id})" >Thêm vào giỏ hàng</button>  
            </div>  
          </div>
        </c:forEach>	                 
        </div>
    </div>
    
    <!-- footer -->
 
 <script>
       
      function warningBeforeAdd(id) {    	  						
			$.ajax({
				url : '${cartAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(id),
				dataType : 'json',
				success : function(result) {				
				},
				error : function(error) {
				}
			});
      }
		
			
		
</script> 
</body>

</html>