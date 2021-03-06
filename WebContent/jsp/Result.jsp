    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.time.LocalDateTime" %>
    <!DOCTYPE html>
    <html>
    	<head>
    		<title>Mandays</title>
    		
    		<!-- responzivní web -->
    		<meta name="viewport" content="width=device-width,initial-scale=1">
    		
    		<!-- můj vlastní CSS styl-->
        	<link rel="stylesheet" href="jsp/styles.css" type="text/css">
    		
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
  				<a class="navbar-brand" href="https://mandayscz.herokuapp.com/">Mandays</a>
			</nav>
		
		<div class="jumbotron text-center"> 
					<p>Výsledek</p>
				</div>

<!-- Začátek kontejneru sloupců -->
		<div class="container">
		
			<!-- první řádka -->
  			<div class="row">
  				<!-- Level prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-8 text-center">
    			<p>Ve zvoleném měsíci je pracovních </p>
      				<p><span class="text_background_yellow">${workingDaysWithoutHolidays}</span> dnů,</p>
    			</div>
   			 		<!-- Pravy prázdnej panel -->
    				<div class="col"></div>
  			</div>
  				
  			<div class="row">
  				<!-- Levy prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-8 text-center">
      				<p>resp. <span class="text_background_yellow">${workingHoursWithoutHOlidays}</span> hodin.</p>
    			</div>

   			 		<!-- Pravy prázdnej panel -->
    				<div class="col"></div>
  			</div>
  				
  			<div class="row">
  				<!-- Levy prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-8 text-center top-margin">
    				<p>Po započtení svátků jako pracovních</p>
      				<p><span class="text_background_yellow">${workingDays}</span> dnů,</p>
    			</div>

   			 		<!-- Pravy prázdnej panel -->
    				<div class="col"></div>
  			</div>
  				
  			<div class="row">
  				<!-- Levy prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-8 text-center">
      				<p>resp. <span class="text_background_yellow">${workingHours}</span> hodin.</p>
      				<br>
      				<form action="${pageContext.request.contextPath}">
						<input type="submit" class="btn btn-primary btn-sm" value="Zpět">
					</form>
    			</div>

   			 		<!-- Pravy prázdnej panel -->
    				<div class="col"></div>
  			</div>
		</div>
   	</body>
</html>