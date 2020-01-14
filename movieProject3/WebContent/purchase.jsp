<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery选座</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css" />
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="css/svwp_style.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.slideViewerPro.1.0.js" type="text/javascript"></script>

    <!-- Optional plugins  -->
    <script src="js/jquery.timers.js" type="text/javascript"></script>
    <style type="text/css">
        .front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #ff8542;text-align: center;padding: 3px;border-radius: 5px;}
        .booking_area {float: right;position: relative;width:200px;height: 450px; }
        .booking_area h3 {margin: 5px 5px 0 0;font-size: 16px;}
        .booking_area p{line-height:26px; font-size:16px; color:#999}
        .booking_area p span{color:#666}
        div.seatCharts-cell {color: #ff8542;height: 25px;width: 25px;line-height: 25px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}
        div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}
        div.seatCharts-row {height: 35px;}
        div.seatCharts-seat.available {background-color:RGB(52,40,64);}
        div.seatCharts-seat.focused {background-color: #b47036;border: none;}
        div.seatCharts-seat.selected {background-color: #E6CAC4;}
        div.seatCharts-seat.unavailable {background-color: RGB(192,89,46);cursor: not-allowed;}
        div.seatCharts-container {border-right: 1px dotted #adadad;width: 400px;padding: 20px;float: left;}
        div.seatCharts-legend {padding-left: 0px;position: absolute;bottom: 16px;}
        ul.seatCharts-legendList {padding-left: 0px;}
        .seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}
        span.seatCharts-legendDescription {margin-left: 5px;line-height: 30px;}
        .checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}
        #seats_chose {max-height: 150px;overflow-y: auto;overflow-x: none;width: 200px;}
        #seats_chose li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}
    </style>

</head>
<body>
<%@include file="blocktop.jsp" %>
<!-- end of templatemo_header -->
<div id="templatemo_header_wrapper">
    <div id="templatemo_header">

        <div id="site_title">
            <h1><a href="index.html"><img alt="logo" src="images/logo.png" width="250" height="60"><span>Welcome To The I'm Movie Theater</span></a></h1>
        </div> <!-- end of site_title -->

    </div>
</div>
<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu">
        <ul>
            <li><a href="allmovie.do" >home</a></li>
            	<li><a href="Movie.jsp" >movie</a></li>
            	<li><a href="order.do" >order</a></li>
            	<li><a href="wishlist.do" >wishlist</a></li>
        </ul>
    </div> <!-- end of templatemo_menu -->
</div>
<div class="demo clearfix">
    <!---左边座位列表----->
    <div id="seat_area">
        <div class="front">屏幕</div>
    </div>
    <!---右边选座信息----->
    <div class="booking_area">
    	<form action="buy.do" method="get">
        <p>电影：<span id="mvname">${movie.name}</span></p>
        <p>时间：<span>${movie.date}</span></p>
        <p>座位：</p>
        <ul id="seats_chose"></ul>
        <p>票数：<span id="tickects_num">${movie.amount}</span></p>
        <p>总价：<b>￥<span id="total_price">0</span></b></p>
        <input id="movieid" type="hidden" name="movieid" value="${movie.id}"/>
		<input id="movieseat" type="hidden" name="movieseat" value=""/>
		<input id="moviename" type="hidden" name="moviename" value=""/>
		<input id="moviemoney" type="hidden" name="moviemoney" value=""/>
		<input id="movieticket" type="hidden" name="movieticket" value=""/>
        <input type="submit" class="btn" value="确定购买"/>

        <div id="legend"></div>
        </form>
    </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.seat-charts.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function() {
	$('#moviename').attr("value","111");
	
}); */
</script type>
<script type="text/javascript">
    var price = ${movie.price}; //电影票价
    $(document).ready(function() {
        var $cart = $('#seats_chose'), //座位区
            $tickects_num = $('#tickects_num'), //票数
            $total_price = $('#total_price'); //票价总额
            $mvname = $('#mvname');

        var sc = $('#seat_area').seatCharts({
            map: [//座位结构图 a 代表座位; 下划线 "_" 代表过道
                'cccccccc',
                'cccccccc',
                'cccccccc',
                'cccccccc',
                'cccccccc',
                'cccccccc',
                'cccccccc',
                'cccccccc'
            ],
            naming: {//设置行列等信息
                top: false, //不显示顶部横坐标（行）
                getLabel: function(character, row, column) { //返回座位信息
                    return column;
                }
            },
            legend: {//定义图例
                node: $('#legend'),
                items: [
                    ['c', 'available', '可选座'],
                    ['c', 'unavailable', '已售出']
                ]
            },
            click: function() {
                if (this.status() == 'available') { //若为可选座状态，添加座位
                	$('#moviename').attr("value",$mvname.text());
                    $('<li>' + (this.settings.row + 1) + '_' + this.settings.label + ' </li>')
                        .attr('id', 'cart-item-' + this.settings.id)
                        .data('seatId', this.settings.id)
                        .appendTo($cart);
                  	//alert($cart.text());
                    $('#movieseat').attr("value",$cart.text());

                    $tickects_num.text(sc.find('selected').length + 1); //统计选票数量
                    $('#movieticket').attr("value",$tickects_num.text());
                    
                    $total_price.text(getTotalPrice(sc) + price);//计算票价总金额
                    //alert($total_price.text());
                    $('#moviemoney').attr("value",$total_price.text());
                    return 'selected';
                } else if (this.status() == 'selected') { //若为选中状态

                    $tickects_num.text(sc.find('selected').length - 1);//更新票数量
                    $('#movieticket').attr("value",$tickects_num.text());
                    
                    $total_price.text(getTotalPrice(sc) - price);//更新票价总金额
                    //alert($total_price.text());
                    $('#moviemoney').attr("value",$total_price.text());
                    $('#cart-item-' + this.settings.id).remove();//删除已预订座位

                    return 'available';
                } else if (this.status() == 'unavailable') { //若为已售出状态
                    return 'unavailable';
                } else {
                    return this.style();
                }
                
            }
            
        });
        //设置已售出的座位
        sc.get(['1_3', '1_4', '4_4', '4_5']).status('unavailable');
        
        
        /*
        
        $('#moviename').attr("value",text);
        
        var b = JSON.stringify($cart);
        alert(b); 
        
        var re = new RegExp('<[^<>]+>','g');
        var text = $total_price.replace(re,"");
        */

    });

    function getTotalPrice(sc) { //计算票价总额
        var total = 0;
        sc.find('selected').each(function() {
            total += price;
        });
        return total;
    }
</script>
<div id="templatemo_copyright_wrapper">
    <div id="templatemo_copyright">
        Copyright © 2048 <a href="#">wyxddnwfjwlt</a>
    </div>
</div>
</body>
</html>
