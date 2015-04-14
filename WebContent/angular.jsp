<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body>
<center><h3>JSP is fucking wired</h3></center>
<div ng-app="myApp" ng-controller="getCameraStatus"> 
{{ data }}
</div>

<script>
var app = angular.module('myApp', []);
app.controller('getCameraStatus', function($scope, $http) {
  //$http.get("http://localhost:1337/Test/getCameraStatus")
  $http.get("http://localhost:8080/CameraManager/CameraStatus")
  .success(function (response) {
	  $scope.data = response;
	  console.log("fuck");
	});
});
</script>

</body>
</html>