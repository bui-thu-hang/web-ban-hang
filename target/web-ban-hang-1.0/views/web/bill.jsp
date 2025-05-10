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
<div class="container my-5">

 <div class="row">
    <div class="col-md-4 mb-5">
        <div class="container py-5">
                <h4>Mẫu liên hệ</h4>
                 <form id="frm1" method="get" action="/thanh-toan" onsubmit="return kiemtra()" >
                    <div class="form-group">
                      <label for="">Họ và tên</label>
                      <input type="text" name="name" id="name" class="form-control" placeholder="Không được để chống" value="${userDTO.userName}" >
                    </div>
                    <div class="form-group">
                        <label for="">Số điện thoại</label>
                        <input type="text" name="phone" id="phone" class="form-control" placeholder="Số điện thoại từ 9- 10 số" >
                    </div>
                    <div class="form-group">
                        <label for="">Đại chỉ nhận hàng</label>
                        <input type="text" name="address" id="address" class="form-control" placeholder="Không được để chống" >
                    </div> 
                     <p> <label></label> <span id="baoloi"></span> </p>                                                                                         
                    <button class="btn btn-success" id="btnAddOrUpdateNew" type="submit">Thanh toán</button>
                    <button type="reset" class="btn btn-danger">Hủy yêu cầu</button>
                </form> 
          </div>
    </div>
    
    <div class="col-md-1">
    </div>
    
    <div class="col-md-7 mb-5">
    <div class="container py-5">
        <h4 class="mb-5">Chi tiết của hóa đơn</h4>
      <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="post" >  
        <table class="table table-bordered table-striped">           
            <thead>
                <tr>                            
                    <th>Tên Sản phẩm</th>
                    <th>Ảnh Sản phẩm</th>
                    <th>Số Lượng hàng</th>                                                        
                </tr>
            </thead>  
            <tbody>         
                <c:forEach var="item" items="${models}">
                <tr>                                      
                    <td>${item.productName}</td>                                       
                    <td>                   
                        <img src="<c:url value='/template/web/images/${item.codeImg}'/>" alt="" width="60">
                    </td>                                                                                                                                                                                    
                    <td>
                        <input type="text" readonly="readonly" min="1" style="width:60px; text-align: center;" id="quantity_${item.id}" name="numberAdd[]" value="${item.numberAdd}">
                    </td>                                     				                                       
                </tr>
                </c:forEach>
            </tbody>
        </table>	
		</form>
    </div>
 </div>
    
 </div>    
</div>


<script>

function kiemtra() {
    var loi = "";
    // kiểm tra tên 
    var tdn = document.getElementById("name");
    if(tdn.value==""){
        tdn.className="loi";        
        loi += "Tên người nhận không được bỏ trống<br>";
    }
    else tdn.className="txt";  
    // kiểm tra số đt
    var mk = document.getElementById("phone");
    if(mk.value==""){
        mk.className="loi";        
        loi += "Số điện thoại không được bỏ trống<br>";
    }
    else if(mk.value.length<=8){
        mk.className="loi";       
        loi += "Số điện thoại quá ngắn<br>";        
    }
    else if(mk.value.length>10){
        mk.className="loi";       
        loi += "Số điện thoại quá dài<br>";        
    }
    else mk.className="txt";  
    // kiểm tra địa chỉ
    var hoten= document.getElementById("address");        
    if(hoten.value==""){ 
        hoten.className="loi"; 
        loi += "Địa chỉ không được bỏ trống.<br>"; 
    }
    else hoten.className="txt"; 
    
     
    if(loi!=""){
    	 var baoloi = document.getElementById('baoloi').innerHTML="<p>" + loi + "</p>";
    	 baoloi.className="alert alert-danger"; 
        return false;
    }
}

</script>
</body>

</html>