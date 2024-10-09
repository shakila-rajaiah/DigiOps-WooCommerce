<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>WooCommerce Orders Report</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/digiops.css" type="text/css"/>
</head>

<style media="screen">
	.loader {
		top: 0px;
		left: 0px;
		width: 100%;
		height: 30px;
		background: #154360;
		display: block;
	}


</style>
<body>
<!-- 	<img src="/images/crds-long.jpg"> -->
	<img src="${pageContext.request.contextPath}/images/crds-long.jpg">
	
	<h1 style="border-bottom:#000000 solid medium">View WooCommerce Orders Report</h1>
	
	<p id="demo" style="padding-left:25px;font-size:15px; font-style: italic;"></p>
	<script>
		var d = new Date();
		document.getElementById("demo").innerHTML = d;
	</script>
		<div id="load2" class="loader hidden" style="display:block;" >
			<img style="height:30px; width:35px;" src="${pageContext.request.contextPath}/images/crossroads-x-logo.png" /> 
 			<p5 > <span> Report Completed....  </span></p5>  
		</div>
			
		<table width="100%" style="padding-top:5px;padding-left:5px;padding-right:5px;padding-bottom:10px;background-color:lightblue;border:5px outset black;border-bottom:1px #CCCCCC Solid;">
			<hr>
<!-- 			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<h2>Details Submitted as Follows: </h2> -->
			
				<div style="padding-left:25px;">		
						<h2 title="View Stripes report"> Details Submitted as Follows: </h2>
					     </br></br>
			      </div>
		
				  <div class="myDiv" >	
						  <p3 style="font-weight:bold;"> <span >Start Date: </span>The Start Date is ${startdate} </p3>
			      </div>
				</br>
<%-- 			&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<h5> End Date: The End Date is ${enddate}</h5> --%>
			
				<div class="myDiv">	
						<p3  style="font-weight:bold;"> End Date: The End Date is ${enddate} </p3>
			      </div>
			      <div class="myDiv">	
						<p3  style="font-weight:bold;"> Report: The Report is ${flag} </p3>
			      </div>
				</br>
<%-- 			&nbsp; &nbsp;<h3> Report Message: *** ${message}</h3> --%>
				<div class="myDiv">	
					<p3 style="font-weight:bold;" > Report Message: 
						<div style="font-weight:normal;padding-left:40px;font-size:15px;"> ${message} </div>
					</p3>
			      </div>
			
			</br>
			</br>

	</table>
	</br>
	<!-- 	adding page reloading information for ITPROD1 -->
	<script>
			setTimeout(() => {
			console.log("Reloading Check...")
			location.href = "http://10.2.48.17:8080/freedup/freedup"
					}, 1000 * 3600)  // 4 hour timer
	</script>
	
</body>
</html>