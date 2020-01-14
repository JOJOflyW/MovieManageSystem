$(document).ready(function() {

	/* open the popup window */
	$('#register').click(function() {
		popup_checkin_win();
		$('#signin_wrap').hide();
		return false;
	});

	$('#signin').click(function() {
		popup_signin_win();
		$('#checkin_wrap').hide();
		return false;
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

});

function popup_checkin_win() {
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
