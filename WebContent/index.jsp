<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
    <title>Overview</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
  </head>
  <script type="text/javascript">
      function getCameraStatus(){
        $.ajax({
          contentType:"UTF-8",
          type:"post",
          url:"http://localhost:8080/CameraManager/CameraStatus",
          success : function(data){
         	 console.log(data);
         	 genRows(data.split(' '));
          },error:function(req,msg){
         	 console.log(msg);
          }
        });
      }
      
      function genRows(list) {
    	  var html = '';
    	  for (var i = 0; i < list.length; i++) {
    		  var tmpList = list[i].split(',');
    		  console.log(tmpList);
    		  html += '<tr>';
    		  html += '<td>' + tmpList[0] + '</td>'; // cameraID
    		  html += '<td>' + tmpList[1] + '</td>'; // mac
    		  html += '<td>' + tmpList[2] + '</td>'; // ip
    		  if (tmpList[4] === 'ON') {
    			  html += '<td class="text-success">ON</td>';
    			  html += '<td><a class="btn btn-success" href="player.jsp?name=' + tmpList[0] + '" role="button" target="_blank">Preview</a></td>';
    			  html += '<td><button type="button" class="btn btn-success" onclick="onPush(\'' + tmpList[2] + '\', \'' + tmpList[0] + '\')">Push</td>';
    		  } else {
    			  // unclickable
    			  html += '<td class="text-danger">OFF</td>';
    			  html += '<td><button type="button" class="btn btn-warning">Preview</button></td>'
    			  html += '<td><button type="button" class="btn btn-warning" onclick="onPush()">Push</button></td>'
    		  }
    		  html += '</tr>';
    	  }
    	  
    	  $("#test").append(html);
      }
      
      function onPush(ip, cameraID) {
    	  if (ip && cameraID) {
    		  alert('with params');
 	        $.ajax({
 	            contentType:"UTF-8",
 	            type:"post",
 	            url:"http://localhost:8080/CameraManager/Rtsp2Rtmp",
 	            success : function(data){
 	            	// TO-DO
 	            },error:function(req,msg){
 	             console.log(msg);
 	            }
 	          });
    	  } else {
    		  alert('without params');
    	  }
      }

      </script>
  <body onload="javascript: getCameraStatus()">
    <div>
      <center><h3>Overview</h3></center>
      <br/>
      <table class="table .table-condensed">
        <tbody id="test">
          <tr>
            <td>CameraNumbers</td>
            <td>MacAddress</td>
            <td>IPAddress</td>
            <td>Status</td>
            <td>Preview</td>
            <td>Push</td>
          </tr>
          <tr>
            <td>Hisen#1</td>
            <td>01:f3:45:67:89:ab</td>
            <td>192.168.10.97</td>
            <td class="text-danger">OFF</td>
            <td><a class="btn btn-warning" href="player.jsp" role="button" target="_blank">Preview</a></td>
            <td><button type="button" class="btn btn-warning">Push</button></td>
          </tr>
          <tr>
            <td>Hisen#2</td>
            <td>rt:23:45:67:89:ab</td>
            <td>192.168.10.98</td>
            <td class="text-success">ON</td>
            <td><button type="button" class="btn btn-success">Preview</button></td>
            <td><button type="button" class="btn btn-success">Push</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>