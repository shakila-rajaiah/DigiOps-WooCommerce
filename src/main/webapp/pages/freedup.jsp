<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>WooCommerce OrdersReport</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/digiops.css" />
</head>

<style media="screen">
	.loader {
		//Position: fixed;
		z-index: 99;
		top: 0px;
		left: 0px;
		width: 100%;
		height: 100%;
		background: #003366;
		display: flex;
		justify-content: left;
		align-items:center;	
	}

</style>
<body>


<!-- <img src="/images/crds-long.jpg"> -->
<img src="${pageContext.request.contextPath}/images/crds-long.jpg">
<div>
	<h1 style="padding-left:25px;">WooCommerce Orders Report</h1>
</div>	
	<p id="demo" style="padding-left:25px;font-size:15px; font-style: italic;"></p>
	<script>
		var d = new Date();
		document.getElementById("demo").innerHTML = d;
	</script>
	
		<div id="load2" class="loader hidden" style="display:none;" >
			<img src="${pageContext.request.contextPath}/images/loading-2.gif" alt="Loading..." /> 
			 <p2 id="p2" > <span>Your report is being processed.....  Please wait....  </span></p2>  
		</div>
	
<!-- 		<script type="text/javascript">
			window.addEventListner("load". function(){
				const loader = document.querySelector(".loader");
				console.log(loader);
				loader.classname +=" hidden"; //class "loader hidden"
				document.getElementById('load2').style.display = 'none';
			})	
		
		})
		</script> -->


	<table width="100%" style="padding-top:5px;padding-left:5px;padding-right:5px;padding-bottom:10px;background-color:lightblue;border:5px outset black;border-bottom:1px #CCCCCC Solid;">
		
		<form method="post" action="viewfreedup" id="form1" >

			<hr>
			&nbsp; &nbsp;<a style="padding-left:15px;" href="<%= request.getRequestURI() %>">BACK</a>
			<hr>

				  <div style="padding-left:25px;">		
						<h2 title="Create a Freed-Up report"> Run FreedUp Report:  </h2>
					     </br></br>
			      </div>	
			      <div class="myDiv" style="font-weight:bold;"  >	
			            Enter Start Date : <input type="date" name="startdate"> 
			      </div>	
			      <div class="myDiv" style="font-weight:bold;">	
			      		Enter End Date &nbsp;: <input type="date" name="enddate">  
			      		<p1 id="warn">
			      			<span>The end date must be before today  </span>
			      		</p1>
			      </div>
			      
			       <div id = "stay" class="st" name="log">	

 						
			       </div>	
<!-- 			       	<div class="myDiv" style="font-weight:bold;">	
						Select Company :
			      		<select name="flag" >
				      		<option>weekly</option>
				      		<option>monthly</option>	      		
			      		</select>
			      </div> -->
			       <br/>
			       <div class="myDiv1" id="myDiv1">
				       <div class="myDiv2">   
				      		<input type="submit" id="d3"> <span style="padding-left:30px;"><input type="reset" value="Clear"></span>
				       </div> 
						<!-- submit form, write to console, display new post -->	
						<script type="text/javascript">	
							//  var rpt = document.getElementById('form1');  
							document.getElementById('form1').addEventListener('submit', function(evt){
								
					         var div = document.getElementById("warn");  
					         var gif = document.getElementById("load2");  
			
					         if (div.style.display !== "none") 
					         {  
					             div.style.display = "none";  
					         }  
					         else
					         {  
					             div.style.display = "block";  
					         } 
					         
					         if (gif.style.display !== "none") 
					         {  
					             gif.style.display = "none";  
					         }  
					         else
					         {  
					             gif.style.display = "block";  
					         }  	         
						    evt.preventDefault();
						    console.log('Report has been submitted');
						    document.getElementById('form1').submit();		
					})
					</script>
					</br></br>
				</div>			
			</br>
		</form>
		
	</table>	
</br>
</br>
</br>		


<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/js/fmx.js" type="text/css"/> --%>
		<!-- 	adding page reloading information for ITPROD1 -->
	<script>
			setTimeout(() => {
				console.log("Reloading freedup...")
				location.href = "http://10.2.48.17:8080/freedup/freedup"
		   }, 1000 * 3600)  // 1 hour timer
	</script>

</body>
</html>