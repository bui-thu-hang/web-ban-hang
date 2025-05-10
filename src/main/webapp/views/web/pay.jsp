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
        <img src="<c:url value='/template/web/images/banner2.png'/>" alt="">
    </div>

    <!-- chia lưới -->

    <div class="container py-5">
        <h2 class="mb-5">Lịch sử mua hàng của bạn</h2>
      <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="post" >  
        <table class="table table-bordered table-striped">           
            <thead>
                <tr>                  
                    <th>Mã hóa đơn</th>
                    <th>Người mua</th>
                    <th>Tổng tiền</th>
                    <th>Ngày đặt hàng</th>
                    <th>Số điện thoại</th>
                    <th>Nơi nhận</th>
                    <th>Trạng thái</th> 
                    <th>Chi tiết hóa đơn</th>                      
                </tr>
            </thead>  
            <tbody>         
                <c:forEach var="item" items="${models}">
                <tr>                  
                    <td>${item.paycode}</td>
                    <td>${item.name}</td>
                    <td>${item.totalPrice}</td>
                    <td>${item.datePay}</td>                    
                    <td>${item.phone}</td> 
                    <td>${item.address}</td>                       
                    <td>${item.statusName}</td>        
                    <td>
                        <c:url var="detailURL" value="/hoa-don-detail">
						    <c:param name="id" value="${item.id}"/>															
				        </c:url>
                        <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-success mx-2" href='${detailURL}'>Chi tiết Hóa Đơn</a>  
                    </td>                                        
                </tr>
                </c:forEach>
            </tbody>
        </table>	
		</form>
        <div class="row">        
        </div>
    </div>

</body>

</html>