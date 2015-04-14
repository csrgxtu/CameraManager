<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
    <title>Player</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://jwpsrv.com/library/M_UDIFvXEeOnACIACqoGtw.js"></script>
  </head>
  <body class="bg-default">
    <br/>
    <br/>
    <center><div id="myvideo5">Loading the player...</div></center>

		<script type="text/javascript">
		    jwplayer("myvideo5").setup({
		        file: "rtmp://127.0.0.1:1935/live/what",
		        width: "480",
		        height: "320",
		    });
		</script>
		
    <script src="static/js/jquery-1.11.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
  </body>
</html>