    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.time.LocalDateTime" %>
    <!DOCTYPE html>
    <html>
    	<head>
    		<title>Mandays</title>
    		
    		<!-- responzivní web -->
    		<meta name="viewport" content="width=device-width,initial-scale=1">
    		
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
    		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  				<a class="navbar-brand" href="#">Mandays</a>
  				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    				<span class="navbar-toggler-icon"></span>
  				</button>

  				<div class="collapse navbar-collapse" id="navbarSupportedContent">
    				<ul class="navbar-nav mr-auto">
				      <li class="nav-item">
				        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="#">API</a>
				      </li>
    				</ul>
  				</div>
			</nav>
		
		<!-- uvodni sedy pruh -->
		<div class="jumbotron text-center"> 
					<p>Kalkulačka spočítá počet dnů a hodin v zadaném měsíci a roce včetně a bez svátků.</p>
		</div>
		
		<!-- Začátek kontejneru sloupců -->
		<div class="container">
			<!-- první řádka -->
  			<div class="row">
  				<!-- Level prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-6 text-center">
    			<form action="compute" method="POST">
            		<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1">Měsíc</span>
  						</div>
  						<input type="text" class="form-control" name="month" value="${data.month}" placeholder="Zadejte měsíc" aria-label="Month" aria-describedby="basic-addon1">
					</div>

					<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1">Rok</span>
  						</div>
  						<input type="text" class="form-control" name="year" value="${data.year}" placeholder="Zadejte rok" aria-label="Year" aria-describedby="basic-addon1">
					</div>

					<div class="input-group mb-3 input-group-sm">
  						<div class="input-group-prepend">
    						<span class="input-group-text" id="basic-addon1" >Hodin</span>
  						</div>
  						<input type="text" class="form-control" name="hours" value="${data.hours}" placeholder="Zadejte počet hodin (např. 7.5)" aria-label="Hours" aria-describedby="basic-addon1" data-toggle="tooltip" data-placement="right" title="Použijte desetinnou tečku.">
					</div>
						<input type="submit" class="btn btn-primary btn-sm" value="Spočítej">	
						
					</form>
    				</div>
   			 		<!-- Level prázdnej panel -->
    				<div class="col"></div>
  				</div>
			</div>
   		</body>
</html>