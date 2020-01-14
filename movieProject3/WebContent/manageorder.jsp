<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>managerorder</title>
<link href="css/manage.css" rel="stylesheet" type="text/css">
<link href="css/bt.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
<script src="js/jquery.timers.js" type="text/javascript"></script>
</head>
<body>
	<%@include file="blocktop.jsp" %>
	<!--header页头标题  -->
	<div id="templatemo_header_wrapper">
    	<div id="templatemo_header">
        	<div id="site_title">
            	<h1><a href="index.jsp"><img alt="logo" src="images/logo.png" width="250" height="60"><span>I'm Movie 后台管理</span></a></h1>
        	</div> <!-- end of site_title -->
    	</div>
	</div> <!-- end of templatemo_header -->

	<!--menu页头导航  -->
	<div id="templatemo_menu_wrapper">
    	<div id="templatemo_menu">
        	<ul>
            	<li><a href="managemovie.do" >manage movie</a></li>
            	<li><a href="manageorder.do" class="current">manage order</a></li>
        	</ul>
    	</div> <!-- end of templatemo_menu -->
	</div>
	
	<div id="templatemo_middle_wrapper_outer">
		<div id="templatemo_middle_wrapper_inner">
        <div id="templatemo_middle_top"></div>
        	<div id="templatemo_middle">
            	<div id="templatemo_content">
						<table class="tableorder">
							<tr id="tablemenu">
								<th>order id</th>
								<th>movie</th>
								<th>user</th>
								<th>seat</th>
								<th>amount</th>
								<th>date</th>
								<!-- <th>operation</th> -->
							</tr>
							<c:forEach items="${order}" var="key">
								<tr>
									<td>${key.id}</td>
									<td>${key.movie.name }</td>
									<td>${key.user.name }</td>
									<td>${key.seat }</td>
									<td>${key.amount }</td>
									<td>${key.date}</td>
									<%-- <td><button dataid="${key.id }"
										class="btn_operation">alter</button>  
										<button dataid="${key.id }"
										class="btn_operation">delete</button>
									</td> --%>
								</tr>
						</c:forEach>
						</table>
            	</div> <!-- end of content -->
            	<div class="cleaner"></div>
        	</div> <!-- end of templatemo_middle -->
        	<div id="templatemo_middle_bottom"></div>
        	      <!-- end of footer -->
	    </div>
	</div>

<div id="templatemo_copyright_wrapper">
    <div id="templatemo_copyright">
        Copyright © 2048 <a href="#">wyxddnwfjwlt</a>
    </div>
</div>

</body>
</html>