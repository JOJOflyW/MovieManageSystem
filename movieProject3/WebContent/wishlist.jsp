<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>I'm Movie Theater</title>
    <meta name="keywords" content="Neo Blog Theme, Free HTML CSS Template, 2 column, header artwork">
    <meta name="description" content="Neo Blog Theme - Free HTML CSS Template brought to you by templatemo.com">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/bt.css" />
    <link href="css/svwp_style.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
    <script src="js/popup.js" type="text/javascript"></script>

    <!-- Optional plugins  -->
    <script src="js/jquery.timers.js" type="text/javascript"></script>


</head>
<body>
<%@include file="blocktop.jsp" %>
<script src="/gg_bd_temp_ad_720x90.js" type="text/javascript"></script>
<div id="templatemo_header_wrapper">
    <div id="templatemo_header">

        <div id="site_title">
            <h1><a href="index.html"><img alt="logo" src="images/logo.png" width="250" height="60"><span>Welcome To The I'm Movie Theater</span></a></h1>
        </div> <!-- end of site_title -->

    </div>
</div> <!-- end of templatemo_header -->

<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu">
        <ul>
            <li><a href="allmovie.do" >home</a></li>
            	<li><a href="Movie.jsp" >movie</a></li>
            	<li><a href="order.do" >order</a></li>
            	<li><a href="wishlist.do" class="current">wishlist</a></li>
        </ul>
    </div> <!-- end of templatemo_menu -->
</div>

<div id="templatemo_middle_wrapper_outer">
<div id="templatemo_middle_wrapper_inner">
	<div id="templatemo_middle_top"></div>
	<div id="templatemo_middle">
            <div class="post_box">
            
<ul>
<h1>WishList</h1>
	<c:forEach items="${movieList}" var="p">
		<li>
		<div class="post_box">
            <h2><a href="Movie01.html">${p.movie.name}</a></h2>
			<div class="post_meta"><strong>Date:</strong> ${p.movie.date} | <!-- <strong>Author:</strong> WyxWltDdnWfj --> </div>
                    <a href="#"><img alt="image" src="images/pict0${p.movie.id}.jpg"></a>
				 <p><em>${p.movie.name}</em></p>
				 <p>${p.movie.info}</p>
				  <div class="cleaner_h20"></div>
                    <div class="category"><strong>Category: </strong><a href="#">Love</a>, <a href="#">Panic</a></div> 
                    <div class="cleaner"></div>
                    <div id="shopping_box">
                    	<ul id="shopping_line">
                        <a href="wish.del?id=${p.id}"> <input id="dltwish" class="btn_shopping" type="button" value="Delete"></a>
                    </ul>
                	</div>
                	</div>
               </li>
	</c:forEach>
<div id="templatemo_copyright_wrapper">
    <div id="templatemo_copyright">
        Copyright © 2048 <a href="#">wyxddnwfjwlt</a>
    </div>
</div>
</body>
</html>