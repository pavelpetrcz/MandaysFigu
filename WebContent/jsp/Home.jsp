    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.time.LocalDateTime" %>
    <!DOCTYPE html>
    <html>
    	<head>
    		<title>Mandays</title>
    		
    		<!-- responzivní web -->
    		<meta name="viewport" content="width=device-width,initial-scale=1">
    		
    		<!-- vlastní styl -->
    		<link rel="stylesheet" href="jsp/styles.css" type="text/css">
    		
    		<!-- Ikonky -->
    		<script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
    		
    		<!-- CDN Bootstrap -->
    		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
			
			<!-- JS -->
			<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
			
			<!-- jQuery -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			
			<script>
				$(document).ready(function(){
    			$('[data-toggle="tooltip"]').tooltip();   
				});
			</script>
				
    	</head>
    	<body class="text-monospace">
    		<!-- Navigační lišta -->
			<nav class="navbar navbar-dark bg-dark sticky-top">
  				<a class="navbar-brand" href="Home.jsp">Mandays</a>
			</nav>
		
		<!-- Jumbotron -->
		<div class="jumbotron text-center"> 
			<p>Kalkulačka spočítá počet dnů a&nbsp;hodin v&nbsp;zadaném měsíci a&nbsp;roce včetně a&nbsp;bez svátků.</p> 
			<p>Dobrý pomocníček pro živnostníky a&nbsp;ostatní.</p>
		</div>
		
		<!-- Kontejner 1 -->
		<div class="container mt-4 py-4">
  			<div class="row">
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-6 text-center">
    			<form action="compute" method="POST">
            		<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1">Měsíc</span>
  						</div>
  						<input type="text" class="form-control" name="month" value="${data.month}" placeholder="např. 10" aria-label="Month" aria-describedby="basic-addon1">
					</div>

					<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1">Rok</span>
  						</div>
  						<input type="text" class="form-control" name="year" value="${data.year}" placeholder="např. 2020" aria-label="Year" aria-describedby="basic-addon1">
					</div>

					<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1" >Hodin</span>
  						</div>
  						<input type="text" class="form-control" name="hours" value="${data.hours}" placeholder="např. 8.0" aria-label="Hours" aria-describedby="basic-addon1" data-toggle="tooltip" data-placement="right" title="Použijte desetinnou tečku.">
					</div>
						<input type="submit" class="btn btn-primary btn-sm" value="Spočítej">	
						
					</form>
    				</div>
    				<div class="col"></div>
  				</div>
  			</div>
		<!-- Kontejner API-->
		<div class="container-fluid mt-4 bg-light py-4">
  				<div class="row">
				    <div class="col"></div>
				    
				    <!-- Obsahový sloupec -->
				    <div class="col-8 text-center">
				    	<ion-icon name="git-branch-outline" size="large"></ion-icon>
				      	<h5>API</h5>
				      	<p>Nevyhovuje vám přístup přes formulář? Data můžete získat i strojově.</p>
				      	<a href="https://app.swaggerhub.com/apis-docs/pavelpetrcz/Mandays/1.0.0#/default/searchInventory" target="_blank" type="button" class="btn btn-primary btn-sm" role="button">Dokumentace API</a>
				      	<a href="https://github.com/pavelpetrcz/MandaysFigu" target="_blank" type="button" class="btn btn-primary btn-sm" role="button">GitHub</a>
				    </div>
				    
				    <div class="col"></div>
			  </div>
		  </div>
		  
		<!-- Kontejner 3-->
		<div class="container-fluid mt-4 py-4">
  				<div class="row">
				    <div class="col"></div>
				    
				    <!-- Obsahový sloupec -->
				    <div class="col-8 text-center">
				    	<ion-icon name="person-outline" size="large"></ion-icon>
				      	<h5>Kontakty</h5>
				      	<p>Využijte těchto odkazů.</p>
				      	
				      	<a href="mailto:pavelpetrcz@gmail.com" target="_blank"><ion-icon name="mail-outline"  class="ion-icon"></ion-icon></a>
				      	<a href="https://www.linkedin.com/in/pavelpetr/" target="_blank"><ion-icon name="logo-linkedin" class="ion-icon"></ion-icon></a>
				      	<a href="http://www.twitter.com/pavelpetrcz" target="_blank"><ion-icon name="logo-twitter"  class="ion-icon"></ion-icon></a>
				    </div>
				    <div class="col"></div>
				  </div>
		  </div>
   		</body>
</html>