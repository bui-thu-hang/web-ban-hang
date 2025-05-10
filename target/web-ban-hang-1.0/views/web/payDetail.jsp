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
        <img src="<c:url value='/template/web/images/banner8.jpg'/>" alt="">
    </div>

    <!-- chia lưới -->
    <div class="container py-5">
        <h2 class="mb-5">Chi tiết của hóa đơn</h2>
      <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="post" >  
        <table class="table table-bordered table-striped">           
            <thead>
                <tr>                  
                    <th>Mã hóa đơn</th>
                    <th>Tên sản phẩm</th>
                    <th>Ảnh sản phẩm</th>
                    <th>Giá sản phẩm</th>
                    <th>Số lượng</th>                                         
                </tr>
            </thead>  
            <tbody>         
                <c:forEach var="item" items="${models}">
                <tr>                  
                    <td>${item.paycode}</td>
                    <td>${item.productName}</td>                   
                    <td><img src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="" width="80"></td>                   
                    <td>${item.price}</td>  
                    <td>${item.number}</td>                                              
                </tr>
                </c:forEach>
            </tbody>
        </table>	
		</form>
    </div>
</body>

</html>