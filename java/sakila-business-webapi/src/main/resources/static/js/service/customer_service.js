'use strict';

App.factory('CustomerService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllCustomers: function() {
					return $http.get('http://localhost:8080/customer/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching customers');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createCustomer: function(customer){
					return $http.post('http://localhost:8080/customer/', customer)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating customer');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateCustomer: function(customer, customerId){
     	    	    console.log("Update customer ", customer);
					return $http.post('http://localhost:8080/customerUpdate/', customer)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating customer');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteCustomer: function(customerId){
					return $http.get('http://localhost:8080/customerDelete/'+customerId)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting customer');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
