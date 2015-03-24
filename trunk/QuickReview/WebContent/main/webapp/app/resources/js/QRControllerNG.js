var app = angular.module('QRApp',[]);


app.controller("QRControllerNG", function($scope){
	console.log("Initilizing the ControllerNG.....");
	
	$scope.update = function(){
		var x = false;
		if(x == true){
			window.location = window.open('sales-profile-dialog.html');
		}else{
			return false;
		}
	};
	
	$scope.item ={
			dob: '01-17-1985',
			ssn:'999-99-9999',
			military: 'No',
			eci: '234675788',
			priOfficer: 'Ran Gurung',
			secOfficer: 'No',
			segment: 'no',
			assign: 'Branch',
			
	};
	
	$scope.fullName = function(){
		var name = $scope.person;
		return name.firstName +" "+name.lastName;
	};	
	
	$scope.selections = [{value:'1', name:'HouseHold View'},
	                     {value:'2', name:'Customer View'},
	                     {value:'3', name:'Individual'}
	];
	
	$scope.data = {
			address1: '453 Radcliffe Dr',
			address2: '',
			city: 'Harrisburg',
			state: 'PA',
			zipCode: '17109-7120',
			country: 'USA',
	};
	
	$scope.phone = {
		type: 'Cell',
		number: '717-623-3337',
		best: 'Ok to Call',
		language: 'English',
	};
	
	$scope.profile = {
		since: '10-09-2005',
		established: '11-03-1999',
		employer: 'JP Morgan Chase',
		owner: 'Yes',
		note: ''
	};
	
	$scope.fup = {
		followUp: 'Test',
		date: '01-17-2015',
	};
	
	$scope.contactHistory = {
		historyType: 'Follow Up',

	};
	
	$scope.list = {
		type: 'JPT',
		date: '02-20-2015',
	};
	
	$scope.comment = {
		type: 'Expired',
		date: '01-20-2015',
	};
	
	$scope.account = {
		accountNumber: 'XXXXXXXX6536',
		type: 'Checking Account',
		status: 'ACTIVE',
		ownership: 'Ran Gurung',
		balance: '987,776,2166',
		open: '03-12-2002',
		maturity: '',
		limit: '',
		rate: '2.99',
	};
	
	
	
}); 