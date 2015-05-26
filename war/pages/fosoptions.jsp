<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>FOS Admin Options</title>
<style>
.form, .add-appointment-form, .unlock-entry-form {
	display: none;
}
</style>
</head>

<body>

	<input type="button" value="Add User" class="add-user-btn">
	<input type="button" value="Delete User" class="delete-user-btn">
	<input type="button" value="Add Appointment"
		class="add-appointment-btn">
	<input type="button" value="Unlock Entries"
		class="unlock-entry-btn">

	<form class="form">

		<div class="form-group">
			<label for="username">FOS Username</label> <input type="text"
				name="username" class="form-control" id="username"
				placeholder="Enter username">
		</div>

		<div class="add-user-form">
			<div class="form-group">
				<label for="password">FOS Password</label> <input type="password"
					name="password" class="form-control" id="password"
					placeholder="Enter Password">
			</div>

			<div class="form-group">
				<label for="deviceId">FOS Device Id</label> <input type="text"
					name="deviceId" class="form-control" id="deviceId"
					placeholder="Enter Device ID">
			</div>

			<button type="submit" class="add-user-button">Add User</button>
		</div>

		<div class="delete-user-form">
			<button type="submit" class="delete-user-button">Delete User</button>
		</div>

	</form>

	<form class="add-appointment-form">

		<div class="form-group">
			<label for="username">FOS Username</label> <input type="text"
				name="username" class="form-control" id="username"
				placeholder="Enter username" required>
		</div>
		<div class="form-group">
			<label for="propertyId">Property Id</label> <input type="text"
				name="propertyId" class="form-control" id="propertyId"
				placeholder="Enter Property Id">
		</div>
		<div class="form-group">
			<label for="propertyName">Property Name</label> <input type="text"
				name="propertyName" class="form-control" id="propertyName"
				placeholder="Enter Property Name" required>
		</div>
		<div class="form-group">
			<label for="propertyType">Property Type</label> 
				<input type="radio" name="propertyType" value="PG" checked>PG
				<input type="radio" name="propertyType" value="Building">Building
		</div>
		<div class="form-group">
			<label for="addressline1">Address Line 1 </label> <input type="text"
				name="addressline1" class="form-control" id="addressline1"
				placeholder="Enter Address Line 1" required>
		</div>
		<div class="form-group">
			<label for="addressline2">Address Line 2</label> <input type="text"
				name="addressline2" class="form-control" id="addressline2"
				placeholder="Enter Address Line 2" required>
		</div>

		<div class="form-group">
			<label for="appointmentStDate">Appointment Start Date</label> <input
				type="date" name="appointmentStDate" class="form-control"
				id="appointmentStDate" placeholder="Enter Appointment Start Date" required>
		</div>
		<div class="form-group">
			<label for="appointmentStTime">Appointment Start Time</label> <input
				type="time" name="appointmentStTime" class="form-control"
				id="appointmentStTime" placeholder="Enter Appointment Start Time" required>
		</div>

		<div class="form-group">
			<label for="appointmentEndDate">Appointment End Date</label> <input
				type="date" name="appointmentEndDate" class="form-control"
				id="appointmentEndDate" placeholder="Enter Appointment End Date" required>
		</div>
		<div class="form-group">
			<label for="appointmentEndTime">Appointment End Time</label> <input
				type="time" name="appointmentEndTime" class="form-control"
				id="appointmentEndTime" placeholder="Enter Appointment End Time" required>
		</div>
		<div class="form-group">
			<label for="notes">Notes</label> <input type="text" name="notes"
				class="form-control" id="notes" placeholder="Enter notes (if any)">
		</div>
		<div class="form-group">
			<label for="location">Location</label>
			<div id="location" style="width: 500px; height: 380px;" ></div>
			<div>
				Lat clicked: <input type="number" step="any" id="latclicked"
					name="latclicked" required>
			</div>
			<div>
				Long clicked: <input type="number" step="any" id="longclicked"
					name="longclicked" required>
			</div>
		</div>
		<button type="submit" class="add-appointment-button">Add
			Appointment</button>
	</form>
	
	<form class="unlock-entry-form">

		<div class="form-group">
			<label for="propertyId">PropertyId</label> <input type="text"
				name="propertyId" class="form-control" id="propertyId"
				placeholder="Enter propertyId" required>
		</div>
		<div class="form-group">
			<label for="propertyType">Property Type</label> 
				<input type="radio" name="propertyType" value="PG" checked>PG
				<input type="radio" name="propertyType" value="Building">Building
		</div>
		<button type="submit" class="unlock-entry-button">Unlock Entry</button>
		</form>

	<script src="https://maps.googleapis.com/maps/api/js"></script>
	<script src="loadGoogleMap.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>
		$(function() {
			$('.add-user-btn').click(
					function() {
						$('.form, .add-user-form').css('display', 'block');
						$('.delete-user-form, .add-appointment-form').css(
								'display', 'none');
					});
			$('.delete-user-btn').click(
					function() {
						$('.form, .delete-user-form').css('display', 'block');
						$('.add-user-form, .add-appointment-form').css(
								'display', 'none');
					});

			$('.add-user-button').click(
					function() {
						$('.form').attr('action',
								'http://localhost:8080/dcapi/adduser');
						$('.form').attr('method', 'post');
					});

			$('.delete-user-button').click(
					function() {
						$('.form').attr('action',
								'http://localhost:8080/dcapi/deleteuser');
						$('.form').attr('method', 'post');
					});

			$('.add-appointment-btn').click(
					function() {
						$('.add-appointment-form').css('display', 'block');
						$('.form, .add-user-form, .delete-user-form').css(
								'display', 'none');
						fillGoogleMap();
					});
			$('.add-appointment-button').click(
					function() {
						$('.add-appointment-form').attr('action',
								'http://localhost:8080/dcapi/addappointment');
						$('.add-appointment-form').attr('method', 'post');
					});
			$('.unlock-entry-btn').click(
					function() {
						$('.unlock-entry-form').css('display', 'block');
						$('.add-user-form, .add-appointment-form').css(
								'display', 'none');
					});
			$('.unlock-entry-button').click(
					function() {
						$('.unlock-entry-form').attr('action',
								'http://localhost:8080/dcapi/unlockentry');
						$('.unlock-entry-form').attr('method', 'post');
					});


		});
	</script>



</body>
</html>