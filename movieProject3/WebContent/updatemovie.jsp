<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add new movie</title>
<link href="css/manage.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
<script src="js/jquery.timers.js" type="text/javascript"></script>
</head>
<style>
       #addbox{
       margin-left:200px;
       width:600px;
       box-sizing: content-box;
        text-align: left;
       }
/*        div.container{
       margin: auto;
       text-align: left;
       } */
.btn_add{
		-webkit-border-radius:3px;-moz-border-radius:3px;-ms-border-radius:3px;-o-border-radius:3px;border-radius:3px;
    background-color: #e95a00;color: #fff;display: inline-block;height: 40px;line-height: 28px;text-align: center;
    transition: background-color 0.2s linear 0s;border:none;cursor:pointer;
    margin-top: 30px;
    font-size: 15px;;
    font-weight: bold;
}
        input[type="text"], input[type="password"]{ 
        /*边框*/border-radius: 10px; 
        /*阴影*/box-shadow: inset 0 5px 5px #eee; 
        padding: 7px; 
        /*边框阴影宽度*/
        border: 1px solid #D4D4D4; 
         margin-top: 5px;
          }
.area{
          width: 380px; 
          height: 100px;
         /*边框*/border-radius: 10px; 
        /*阴影*/box-shadow: inset 0 5px 5px #eee; 
        padding: 7px; 
        /*边框阴影宽度*/
        border: 1px solid #D4D4D4; 
         margin-top: 5px;
          }
.movielable{
	font-size: 20px;
}

#moviebt{
display:inline-block;
margin-left: 130px;
}
</style>
<body>
	<%@include file="blocktop.jsp" %>
	<!--header页头标题  -->
	<div id="templatemo_header_wrapper">
    	<div id="templatemo_header">
        	<div id="site_title">
            	<h1><a href="index.jsp"><img alt="logo" src="images/logo.png" width="250" height="60"><span>Welcome To The I'm Movie Theater</span></a></h1>
        	</div> <!-- end of site_title -->
    	</div>
	</div> <!-- end of templatemo_header -->

	<!--menu页头导航  -->
	<div id="templatemo_menu_wrapper">
    	<div id="templatemo_menu">
        	<ul>
            	<li><a href="managemovie.jsp"  class="current">manage movie</a></li>
            	<li><a href="manageorder.jsp">manage order</a></li>
        	</ul>
    	</div> <!-- end of templatemo_menu -->
	</div>
	
	<div id="templatemo_middle_wrapper_outer">
		<div id="templatemo_middle_wrapper_inner">
        <div id="templatemo_middle_top"></div>
        	<div id="templatemo_middle">
            	<div id="addbox" class="container">
            	    <p style="font-size: 25px;color: #e95a00;margin-left: 80px;"><strong>add new movie</strong></p>
					<p id="header-wrapper"></p>
        			<form action = "foodServlet" method = "POST" id="movieform" >
        			<table>
        			<tr class="movielable"><td>Movie ID：</td>
		   			<td><input type="text"  style="font-size: 15px" placeholder="电影号" name="id" value="id"></input></td></tr>
		  			<tr class="movielable"><td>Movie Name：</td>
		   			<td><input type="text"  style="font-size: 15px" placeholder="电影名" name="name" ></input></td></tr>
		   			<tr class="movielable"><td>Movie Time：</td>
		   			<td><input type="text"  style="font-size: 15px" placeholder="电影上映时间" name="date" ></input></td></tr>
		     		<tr class="movielable"><td>Movie Price：</td>
		     		<td><input type="text"  style="font-size: 15px" placeholder="电影票价格" name="price" ></input></td></tr>
		     		<tr class="movielable"><td>Movie Amount：</td>
		     		<td><input type="text"  style="font-size: 15px" placeholder="电影票数量"  name="amount" ></input></td></tr>
		     		<tr class="movielable"><td>Movie Info：</td>
		     		<td><textarea class="area"  form="movieform"  name="movieinfo" style="font-size: 15px" placeholder="电影详情信息" ></textarea></td></tr>		     		
		 		
			</table>
			<input type="hidden" class="btn_add" name = "action" value="update">
				<p id="moviebt"><input type="button" class="btn_add" value="Add It Now"></p>
			</form>		

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