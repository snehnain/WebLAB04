'use strict';

App.factory('StaffService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllStaffs: function() {
					return $http.get('http://localhost:8080/staff/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching staffs');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    
		    loginStaff: function(staff){
     	    	    console.log("Staff Details are", staff);
     	    	    //var userName=staff.userName;
     	    	    //var Password=staff.password;
     	    	    //console.log("username",staff.userName);
     	    	   return $http.post('http://localhost:8080/staffLogin/', staff)
     	    	   /*$http
     	    	   ({
     	    		   url: 'http://localhost:8080/staffLogin/',
     	    		   method: 'POST',
     	    		   headers: {
     	    			   'Content-Type': undefined
     	    		   },
     	    		   data: 'username='+userName+'& password='+Password
     	    	   })*/.then(
									function(response){
										console.log(response.data);
										window.location.href = "http://localhost:8080/CustomerManagement.html"
										//$location.path='http://localhost:8080/CustomerManagement2.html';
										return response.data;
									}, 
									function(errResponse){
										console.error('Error occurred in staff login');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
