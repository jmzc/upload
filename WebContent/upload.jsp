<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/style1.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/spin.js"></script>
<script src="js/jquery.spin.js"></script>

<script>

function cleaner() 
{
	
	$('#result').html("");
	$('#message').html("");
		
	var frame = $('#upload_target');
	frame.html("");
	frame.height(0);
	
	
}


//http://css-tricks.com/snippets/jquery/fit-iframe-to-content/
$(function()
{
		    
	var frame = $('#upload_target');

	frame.load(function() 
	{

		//Given a jQuery object that represents a set of DOM elements
		var t = $('#upload_target').contents().find("body").html();

		if (t.indexOf("table") >= 0 || t.indexOf("TABLE") >= 0)
		{
			var h = this.contentWindow.document.body.offsetHeight;
			if (this.contentWindow.document.body.offsetHeight > 380)
				h = 400;
			else
				h = h + 20;
			
		 	this.style.height = h + 'px';
		}
		else
		{
		 	this.style.height = 0 + 'px';
		}
		
	
	
	});

	
		    
});

	 
		 
function result(n,message)
{

	$('#result').spin(false);
	if (n == '0')
		$('#result').html('<img src="image/ok.png"/>');
	else if (n == '1')
	{
				
		// The text() method entity-escapes any HTML that is passed into it.
		$('#result').html('<img src="image/error.png"/>');
		$('#message').html( message);
	}
	else if (n == '2')
	{
				
		// The text() method entity-escapes any HTML that is passed into it.
		$('#result').html('<img src="image/warning.png"/>');
		$('#message').html( message);
	}
		
}
 
function execute() 
{
	 /*
		By default the spinner is centered within the target element. 
		Alternatively you may specify a top and left option to position the spinner relative to the target element.
	*/
	   
	 var val=$("#uploadfrm_upload").val();
	 
	 /*NULL and undefined types are == (but not ===)
	 */
	 if (val == '')
	 {
		 alert('Debe indicar un fichero');
		 return;
	 }

	  $('#result').spin('small');
	 
	  $('#uploadfrm').submit();
	 

}



</script>
</head>
<body>

<div class="upload-container">

	 <!-- target="upload_target" -->
	 <form id="uploadfrm" action="/upload/doupload.action" method="post" target="upload_target" enctype="multipart/form-data">
	 	<div>
	 		<input id="uploadfrm_upload"  type="file" name="upload" value="" onclick="javascript:cleaner();"/>
	 	</div>
	 	<div class="submit-container">
	 		<div class="submit">
	 			<input type="button" value="Enviar" name="enviar" onclick="execute();"/>
	 		</div>
	 		<div class="result" id="result"></div>
	 		<div class="message" id="message"></div>
	 		<div style="clear:both"></div>
	 	</div>
	 </form>
	 

	<!-- <iframe id="upload_target" name="upload_target" src="#" style="width:0;height:0;border:0px solid #fff;"></iframe>  -->
	<iframe id="upload_target" name="upload_target"  marginheight="0" marginwidth="0"  scrolling="yes" frameborder="0" style="width:100%;height:0px;border:0px solid #000;"></iframe>               
</div> 


</body>
</html>

 
 <!--  
File upload is not possible through ajax. 
You can upload file, without refreshing page by using IFrame. you can check further detail here
With XHR2, File upload through AJAX is supported. E.g. through FormData object, 
but unfortunately it is not supported by all/old browsers
-->