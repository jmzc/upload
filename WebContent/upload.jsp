<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Showcase - fileupload - multiple fileupload using List</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/spin.js"></script>
<script src="js/jquery.spin.js"></script>
<script>

function result(n,message)
{

	$('#result').spin(false);
	if (n == 0)
		$('#result').html('<img src="image/ok.png"/>');
	else
	{
		// The text() method entity-escapes any HTML that is passed into it.
		$('#result').html('<img src="image/error.png" title="' + message + '"/>');
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

function cleaner() 
{
	
	$('#result').html("");
	$('#message').html("");

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
	 

	<iframe id="upload_target" name="upload_target" src="#" style="width:0;height:0;border:0px solid #fff;"></iframe>                 
</div>

</body>
</html>

 
 <!--  
File upload is not possible through ajax. 
You can upload file, without refreshing page by using IFrame. you can check further detail here
With XHR2, File upload through AJAX is supported. E.g. through FormData object, 
but unfortunately it is not supported by all/old browsers
-->