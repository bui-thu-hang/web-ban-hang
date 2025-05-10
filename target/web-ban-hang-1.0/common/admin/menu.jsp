<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Giám đốc quản lý
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/user/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách người dùng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>      
        
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Trưởng phòng quản lý
                <b class="arrow fa fa-angle-down"></b>
            </a>
            
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/the-loai/danh-sach?page=1&limit=2'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách thể loại
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li> 
        
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
                Nhân viên quản lý
                <b class="arrow fa fa-angle-down"></b>
            </a>
             <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/san-pham/danh-sach?page=1&limit=5'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách sản phẩm
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
             <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/binh-luan/danh-sach?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bình luận
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/gio-hang/danh-sach?page=1&limit=5'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách giỏ hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/don-hang/danh-sach?page=1&limit=5'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách đơn hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href="<c:url value='/quan-tri/chi-tiet-don-hang/danh-sach?page=1&limit=10'/>">
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách chi tiết đơn hàng
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>                                                                                                 
    </ul>
</div>