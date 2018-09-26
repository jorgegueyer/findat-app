<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Financial Application</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="../css/styles.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
  		<script src="../js/app.js"></script>  		
	</head>
	<body>		
		<div class="container">
			<header><div class="row">
				<div class="co-lg-12" style="background-color:lavenderblush;">					
						<h1 class="text-info">Financial Concepts <small>Private Information</small></h1>
				</div>				
			</div></header>				
			<div class="row">
				<div class="col-lg-6" style="background-color:lightcyan;">
					<form action="#"><div class="form-group">
						<table class="table table-hover">
							<thead><tr>
									<th>#</th>
									<th>Concept</th>
									<th>Date</th>
									<th>Amount</th>
							</tr></thead>
							<tbody><tr>
									<td>0</td>
							        <td>Food</td>
		        					<td pattern=/^\d{2}-\d{2}-\d{4}$/>01-01-1970</td>
		        					<td>700€</td>
		      				</tr></tbody>
						</table>
					</div></form>
				</div>
				<div class="col-lg-6" style="background-color:lightgray;">
					<form class="form-horizontal" action="#">
						<div class="form-inline">
							<div class="row_add_info"><label for="sel1">Concepts</label></div>
							<div class="row_add_info"><select class="form-control" id="sel1">
								<option> </option>
								<option>Food</option>
							    <option>Travels</option>
							    <option>Fixed Expense</option>
							    <option>Services</option>
							</select></div>							
						</div>															
						<div class="form-inline">
							<div class="row_add_info"><label for="date">Date: </label></div>						
							<div class="row_add_info"><input type="date" class="form-control" id="date"></div>
						</div>
						<div class="form-inline">
							<div class="row_add_info"><label for="amount">Amount: </label></div>
							<div class="row_add_info"><input type="text" class="form-control" id="amount"></div>
						</div>
						<div class="form-inline">
							<button type="button" class="btn btn-success">Add</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</form>
				</div>				
			</div>
			<footer><div class="row">
				<div class="co-lg-12" style="background-color:lavenderblush;">
				</div>	
			</div></footer>
		</div>
	</body>
</html>