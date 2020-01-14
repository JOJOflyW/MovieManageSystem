<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I'm Movie</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="css/svwp_style.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
    <script src="js/jquery.timers.js" type="text/javascript"></script>
</head>
<body>
<%@include file="blocktop.jsp" %>
<div id="templatemo_header_wrapper">
    <div id="templatemo_header">

        <div id="site_title">
            <h1><a href="index.jsp"><img alt="logo" src="images/logo.png" width="250" height="60"><span>Welcome To The I'm Movie Theater</span></a></h1>
        </div> <!-- end of site_title -->

    </div>
</div> <!-- end of templatemo_header -->

<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu">
        <ul>
            <li><a href="allmovie.do" class="current">home</a></li>
            	<li><a href="Movie.jsp" >movie</a></li>
            	<li><a href="order.do" >order</a></li>
            	<li><a href="wishlist.do" >wishlist</a></li>
        </ul>
    </div> <!-- end of templatemo_menu -->
</div>

<div id="templatemo_middle_wrapper_outer">
    <div id="templatemo_middle_wrapper_inner">
        <div id="templatemo_middle_top"></div>
        <div id="templatemo_middle">

            <div id="templatemo_content">
                    <div id="templatemo_slider">
                        <div id="featuredslideshow">
                            <ul>
                                <li><img width="600" height="300" alt="photo one" src="images/slideshow/timg.jpg" /></li>
                                <li><img width="600" height="300" alt="photo two" src="images/slideshow/timg03.jpg" /></li>
                                <li><img width="600" height="300" alt="photo three" src="images/slideshow/timg06.jpg" /></li>
                                <li><img width="600" height="300" alt="photo four" src="images/slideshow/timg05.jpg" /></li>
                                <li><img width="600" height="300" alt="photo five" src="images/slideshow/timg07.jpg" /></li>
                                <!-- eccetera -->
                            </ul>
                        </div>
                    <script type="text/javascript">
                        $("div#featuredslideshow").slideViewerPro({
                            thumbs: 4,
                            thumbsPercentReduction: 15,
                            galBorderWidth: 0,
                            galBorderColor: "#666",
                            thumbsTopMargin: 10,
                            thumbsRightMargin: 10,
                            thumbsBorderWidth: 1,
                            thumbsActiveBorderColor: "#000",
                            thumbsActiveBorderOpacity: 0.8,
                            thumbsBorderOpacity: 0,
                            buttonsTextColor: "#707070",
                            autoslide: true,
                            typo: true
                        });
                    </script>
                </div>

                <div class="cleaner"></div>

                <div class="post_box">
					<c:forEach items="${movie}" var="key">
                    	<h2><a href="Movie01.jsp">${key.name}</a></h2>
                    	<div class="post_meta"><strong>Date:</strong> ${key.date} | <strong>Price:</strong> ${key.price} | <strong>Author:</strong> WyxWltDdnWfj </div>
                    	<a href="#"><img alt="image" src="images/pict0${key.id}.jpg"></a>
                    	<p>${key.info}</p>
                    	<div class="cleaner_h20"></div>
                    	<div class="category"><strong>Category: </strong><a href="#">Love</a>, <a href="#">Panic</a></div> <div class="btn_more float_r"><a href="movie01.do?id=${key.id}">Read more <span>»</span></a></div>
                    	<div class="cleaner"></div>
					</c:forEach>
                </div>

             <!--    <div class="post_box post_box_last">

                    <h2><a href="Movie01.jsp">Loving Vincent</a></h2>

                    <div class="post_meta"><strong>Date:</strong> December 6th, 2019 | <strong>Author:</strong> Wlt</div>
                    <a href="#"><img alt="image" src="images/pict02.jpg"></a>

                    <p>“Loving Vincent” is the upcoming biographical animated film from newcomer directors Dorota Kobiela and Hugh Welchman. The movie follows Armand Roulin (Douglas Booth), the son of an acquaintance of Vincent van Gogh, as he attempts to deliver a letter from the painter following van Gogh’s death. Armand soon finds himself retracing the steps taken by Vincent in his final days in an attempt to unravel the mysterious circumstances surrounding his death. A film unlike any other, “Loving Vincent” is entirely hand painted – each of the movie’s 65,000 frames is an oil painting on a canvas created using the same techniques as Vincent van Gogh. Good Deed Entertainment is releasing “Loving Vincent” on September 22nd in New York before expanding to Los Angeles on September 29th and nationally on October 6th. In addition to being a wonder for the eyes, “Loving Vincent” is a treat for the ears.  consequat lacinia. Vivamus elit erat, tincidunt eget scelerisque vitae.</p>

                    <div class="cleaner_h20"></div>
                    <div class="category"><strong>Category: </strong><a href="#">Art</a>, <a href="#">documentary</a></div> <div class="btn_more float_r"><a href="Movie01.jsp">Read more <span>»</span></a></div>
                    <div class="cleaner"></div>

                </div>
 -->
            </div> <!-- end of content -->

            <div id="templatmeo_sidebar">

                <div class="sidebar_box">
                    <ul class="ads_125">
                        <li><a href="#"><img alt="CSS Templates" src="images/01.jpg"></a></li>
                        <li class="odd"><a href="#"><img alt="banner" src="images/02.jpg"></a></li>
                        <li class="last_row"><a href="#"><img alt="banner" src="images/04.jpg"></a></li>
                        <li class="odd last_row"><a href="#"><img alt="banner" src="images/03.jpg"></a></li>
                    </ul>
                    <div class="cleaner"></div>
                </div>

                <div class="sidebar_box">
                    <h4>Categories</h4>
                    <ul class="tmo_list">
                        <li><a href="Movie.jsp">Love Movies</a></li>
                        <li><a href="Movie.jsp">Art Movies</a></li>
                        <li><a href="Movie.jsp">Action Movies</a></li>
                        <li><a href="Movie.jsp">Thriller Movies</a></li>
                        <li><a href="Movie.jsp">Cartoon</a></li>
                        <li><a href="Movie.jsp">Comedy</a></li>
                    </ul>
                </div>

                <div class="sidebar_box">
                    <h4>Recent Films</h4>
                    <div class="recent_comment_box">
                        <a href="#">Loving Vincent</a>
                        <p>The movie follows Armand Roulin (Douglas Booth), the son of an acquaintance of Vincent van Gogh, as he attempts to deliver a letter from the painter following van Gogh’s death.</p>
                    </div>

                    <div class="recent_comment_box">
                        <a href="#">The Twilight Saga </a>
                        <p>
                            a smart young girl with a heart of fire, and this incredibly and deadly attractive vampire, they life intersect at this small rainy and cloudy town. something that is destined is about to happen.

                        </p>
                    </div>

                    <div class="recent_comment_box">
                        <a href="#">The Queen's corky</a>
                        <p> a smart young girl with a heart of fire, and this incredibly and deadly attractive vampire, they life intersect at this small rainy and cloudy town. something that is destined is about to happen.
                        </p>
                    </div>

                    <div class="recent_comment_box">
                        <a href="#">Maleficent</a>
                        <p>The story begins with the love and murder between human beings and elves. Human beings steal the wings of elves because of greed and become kings. Elves become black wizards. The Princess born by the king is a sleeping beauty.</p>
                    </div>

                </div>
                <div class="cleaner"></div>

            </div>

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