<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
<link href="css/svwp_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/bt.css" />
<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>
<script src="js/jquery.timers.js" type="text/javascript"></script>
</head>
<body>
<%@include file="blocktop.jsp" %>
<div id="templatemo_header_wrapper">
	<div id="templatemo_header">
    
    	<div id="site_title">
            <h1><a href="index.jsp"><img src="images/logo.png"width="250" height="60"><span>Welcome To The I'm Movie Theater</span></a></h1>
        </div> <!-- end of site_title -->
        
    </div>
</div> <!-- end of templatemo_header -->

<div id="templatemo_menu_wrapper">
	<div id="templatemo_menu">
        <ul>
            <li><a href="allmovie.do" >Home</a></li>
            <li><a href="Movie.jsp" class="current">Movie</a></li>
            <li><a href="order.jsp">Order</a></li>
            <li><a href="wishlist.jsp">Wishlist</a></li>
        </ul>    	
    </div> <!-- end of templatemo_menu -->
</div>

<div id="templatemo_middle_wrapper_outer">
	<div id="templatemo_middle_wrapper_inner">
		<div id="templatemo_middle_top"></div>
		<div id="templatemo_middle"> 
    		<div id="templatemo_content">
           		<div class="post_box">
           		         
                	<h2>${movie.name}</h2>               
                	<div class="post_meta"><strong>Date:</strong> ${movie.date} | <strong>Price:</strong> ${movie.price} | <strong>Author:</strong> WyxWltDdnWfj </div>
                	<a href="#"><img alt="image" src="images/pict0${movie.id}.jpg"></a>
                	<p>${movie.info}</p>
                	<div class="cleaner_h20"></div>             	
                	<div class="category"><strong>Category: </strong><a href="#">Love</a>, <a href="#">Panic</a></div>
                	<!--购买  -->
                	<div id="shopping_box">
                    	<ul id="shopping_line">
                        <li><a href="search.do?id=${movie.id}"> <input class="btn_shopping"  type="button" value="Purchase Now"></a></li>
                        <li ><a href="wish.add?id=${movie.id}"> <input class="btn_shopping" type="button" value="Add Wishlist"></a></li>
                    </ul>
                	</div>
                	<div class="cleaner"></div>
                
				</div>
				<!-- 用户评论 -->            
                <h2>128 comments</h2>                                
            	<div id="comment_section">
                	<ol class="comments first_level">
                        <li>
                        	<div class="comment_box commentbox1">                                   
                                <div class="gravatar">
                                <img src="images/comments/people1.jpg" alt="author" />
                                </div>
                                <div class="comment_text">
                                	<div class="comment_author">Wfj<span class="date">May 28, 2048</span><span class="time">11:40 PM</span></div>
                                    <p>So long as there are people, there will be love stories -- I hope they all feel as lush and lively as this one.
                                    <div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                </div>
                                <div class="cleaner"></div>
                                </div>
						</li>                       
                        <li>
                            <ol class="comments">                         
                            <li>
                           		<div class="comment_box commentbox2">
									<div class="gravatar">
                                   	<img src="images/comments/people2.jpg" alt="author 5" />
                                    </div>
                                    <div class="comment_text">
                                    	<div class="comment_author">Wyx<span class="date">May 29, 2048</span><span class="time">10:15 AM</span></div>
                                        <p>If only director Chris Weitz had managed to tease out the real drama -- Bella's fear of aging -- instead of a tired one.</p>
                                       	<div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                   	</div>
									<div class="cleaner"></div>
								</div>
							</li>
							<li>
								<ol class="comments">
									<li>
										<div class="comment_box commentbox1">
											<div class="gravatar">
                                            <img src="images/comments/people3.jpg" alt="author 4" />
                                            </div>
                                            <div class="comment_text">
                                           		<div class="comment_author">Wlt <span class="date">May 29, 2048</span><span class="time">08:50 PM</span></div>
                                                <p> Suicidal tendencies have been a classic feature of romantic tales since time immemorial. But they are hardly a good model for tweens and teens.</p>
                                                <div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                         	</div>
											<div class="cleaner"></div>
										</div>                        
									</li>
								</ol>
							</li>
							</ol>
						</li>
						<li>
                            <ol class="comments">
                            <div class="comment_box commentbox1">
                                <div class="gravatar">
                                	<img src="images/comments/people4.jpg" alt="author 2" />
                                </div>
                                <div class="comment_text">
                                    <div class="comment_author">Dannny<span class="date">May 30, 2048</span><span class="time">11:34 AM</span></div>
                                    <p>The film's saving grace, by a long chalk, is Kristen Stewart, who once again manages to make the insufferable Bella far more interesting on the screen than she is on the page.</p>
                                    <div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                </div>     
                                <div class="cleaner"></div>
							</div>
                            </ol>
                        </li>
                        <li>
                            <div class="comment_box commentbox1">
                                <div class="gravatar">
                                <img src="images/comments/people5.jpg" alt="author 3" />
                            	</div>
                                <div class="comment_text">
                                    <div class="comment_author">Jw<span class="date">May 31, 2048</span><span class="time">06:45 AM</span></div>
                                    <p>While the sequel should have fans squealing, New Moon probably won't convert too many holdouts.</p>
                                    <div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                </div>
                                <div class="cleaner"></div>
                            </div>
                        </li>
                        <li>
                            <div class="comment_box commentbox1">
                                <div class="gravatar">
                                	<img src="images/comments/people6.jpg" alt="author 3" />
                                </div>
                                <div class="comment_text">
                                    <div class="comment_author">Dxl<span class="date">May 31, 2048</span><span class="time">06:45 AM</span></div>
                                    <p>Two hours and 10 minutes of rambling, pointless drivel, where nothing of any real interest happens.</p>
                                    <div class="btn_more float_r"><a href="#"><span>+</span> Reply</a></div>
                                </div>
                                <div class="cleaner"></div>
                            </div>
                        </li>
                    </ol>
            	</div>
				<div id="movie_forter"><div class="btn_more"><a href="Movie01.jsp">Read more <span>&raquo;</span></a></div></div>
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
    </div>
</div>
</body>
</html>