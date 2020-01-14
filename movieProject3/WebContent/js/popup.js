$(document).ready(function() {

	/* open the popup window */
	$('#register').click(function() {
		popup_checkin_win();
		return false;
	});

	$('#signin').click(function() {
		popup_signin_win();
		return false;
	});

	/* close the popup window */
	$('#checkin_close').click(function() {
		$('#black_overlay').hide();
		$('#checkin_wrap').stop().slideUp();
	});

	$('#signin_close').click(function() {
		$('#black_overlay').hide();
		$('#signin_wrap').stop().slideUp();
	});

	/* submit */
	$('#btn_checkin').click(function() {
		checkin_submit();
		return false;
	});

	$('#btn_signin').click(function() {
		signin_submit();
		return false;
	});

	/* close the popup window */
	$('.popup_wrap').click(function(e) {
		e.stopPropagation();
	});

	$('#black_overlay').click(function() {
		$('#black_overlay').hide();
		$('.popup_wrap').slideUp();
	});

});

function popup_checkin_win() {
	$('#black_overlay').show();
	$('#checkin_wrap').slideDown();
}

function checkin_submit() {
	var username = $('#checkin_username');

	if ( username==" "|| username.length>10) {
		$('#checkin_wrap .message').show();
		username.select().focus();
	} else {
		$('#checkin_wrap .message').hide();
		$('#checkin_form').submit();
		return false;
	}
}

function popup_signin_win() {
	$('#black_overlay').show();
	$('#signin_wrap').slideDown();
}


function signin_submit() {
	var username = $('#signin_username');

	if (username==" "|| username.length>10) {
		$('#signin_wrap .message').show();
		username.select().focus();
	} else {
		$('#signin_wrap .message').hide();
		$('#signin_form').submit();
		return false;
	}
}
