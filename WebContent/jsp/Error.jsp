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
			
    	</head>
    	<body class="text-monospace">
    		<!-- Navigační lišta -->
    		<nav class="navbar navbar-dark bg-dark sticky-top">
  				<a class="navbar-brand" href="Home.jsp">Mandays</a>
			</nav>
		
		<div class="jumbotron"> 
			<h3 class="jumbotron-fluid text-center">Jejda ... něco je špatně.</h3>
		</div>
		
		<div class="alert alert-primary text-center" role="alert">${errorMessage}</div>
		
		<!-- Začátek kontejneru sloupců -->
		<div class="container">
  			<div class="row">
  				<!-- Levy prázdnej panel -->
    			<div class="col"></div>
    
    			<!-- prostření obsahovej panel -->
    			<div class="col-4 text-center">
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