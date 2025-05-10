<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="cartAPI" value="/api/productAdd"/>
<c:url var="cartURL" value="/gio-hang"/>
<c:url var="buyURL" value="/buying"/>
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

    <!-- chia lưới -->

    <div class="container py-5">
        <h2 class="mb-5">Giỏ hàng của bạn</h2>
      <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="post" >  
        <table class="table table-bordered table-striped">           
            <thead>
                <tr>
                    <th>Chọn xóa</th> 
                    <th>Mã sản phẩm</th>
                    <th>Tên Sản phẩm</th>
                    <th>Ảnh Sản phẩm</th>
                    <th>Số Lượng hàng</th>
                    <th>Giá Sản phẩm</th>
                    <th>Tổng giá</th>
                    <th>Thao tác</th>
                </tr>
            </thead>  
            <tbody>         
                <c:forEach var="item" items="${model.listResult}">
                <tr>
                    <td><input type="checkbox" id="checkbox_${item.id}" name="checkbox" value="${item.id}"></td>
                    <td>${item.productCode}</td>
                    <td>${item.productName}</td>                                       
                    <td>                   
                        <img src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="" width="80">
                    </td>                                                                                                                                                                                    
                    <td>
                        <input type="number" min="1" style="width:60px; text-align: center;" id="quantity_${item.id}" name="numberAdd[]" value="${item.numberAdd}">
                    </td>
                                     
					<td>
					    <input type="text"  readonly="readonly" value="${item.productPrice} đ" style="width:80px; text-align: center;" id="price_${item.id}" name="productPrice[]" />
					</td>
                    <td><input type="number" readonly="readonly" style="width:100px; text-align: center;" id="total_${item.id}" name="totalItem[]" value="${item.numberAdd*item.productPrice}"></td>                                                           
                    <td>
                        <c:url var="detailURL" value="/chi-tiet">
						    <c:param name="id" value="${item.productId}"/>															
				        </c:url>
                        <a data-toggle="tooltip" data-target="#modelId" class="btn btn-sm btn-success mx-2" href='${detailURL}'>Chi tiết sản phẩm</a>           
                    </td>                   
                </tr>
               <%--  <input type="hidden" value="${item.productName}" id="productname_${item.id}"/>
                <input type="hidden" value="${item.codeImg}" id="codeimg_${item.id}"/> --%>
                </c:forEach>
            </tbody>
        </table>
        <hr>		
		<button type="button" onclick="warningBeforeDelete()" class="btn btn-sm btn-danger mx-2" data-toggle="tooltip">	
              Xóa khỏi giỏ hàng														
		</button>
		<a class="btn btn-sm btn-success mx-2" href="<c:url value='/trang-chu'/>">Tiếp tục mua hàng</a>		
		<button class="btn btn-success mx-2" type="button" id="upDate">Cập nhật</button>
		<hr>	
		</form>
        <div class="row">
            <div class="col-md-7">
            </div>
            <div class="col-md-5">
                <h4>Tổng tiền: <input type="number" readonly="readonly" style="width:100px; text-align: center;" id="total" name="total" value=" Đ"></h4>
                <button class=" btn btn-success" type="button" id="btnPay">Mua hàng</button>
            </div>
        </div>
    </div>
    
<script>			
			function warningBeforeDelete() {
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
		            url: '${cartAPI}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {		            	
		               window.location.href = "${cartURL}"; 	         
		            },
		            error: function (error) {
		               window.location.href = "${cartURL}"; 
		            }
		        });
		    }
			
			
			$('#upDate').click(function(e) {										    
				var quantities = document.getElementsByName('numberAdd[]');
 				var prices = document.getElementsByName('productPrice[]');
 				var totalItems = document.getElementsByName('totalItem[]');
 				var total=0;
				for (var i = 0; i <quantities.length; i++) {
					var quantity = parseInt(quantities[i].value);
				    var price = parseInt(prices[i].value);
				    totalItems[i].value = quantity*price;
				    total = total + quantity*price;
				}
				$('#total').val(total);
				
			});
			
			
		    $("#btnPay").click(function(){
				  var arr = document.getElementsByName("checkbox");
				  var arr_data = [];				  
				  for(var i = 0; i<arr.length; i++){					 
							var obj = {};
							obj['id'] = arr[i].value;
						   /*  obj['productId'] = $("#productId_"+arr[i].value).val();  */
							obj['numberAdd'] = $("#quantity_"+arr[i].value).val();
							arr_data[i] = obj;												  
				  }
				    $.ajax({
						url : '${cartAPI}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(arr_data),
						dataType: 'json',
						success : function(result) {
							if (result != null) {								
								window.location.href = "${buyURL}";
							} else {
								window.location.href = "${buyURL}";
							}							
						},
						error : function(error) {
						}
					});  
			 });
			
</script>
</body>

</html>