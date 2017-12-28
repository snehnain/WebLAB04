'use strict';

App.controller('StaffController', ['$scope','StaffService',function($scope, StaffService) {
			var self = this;
			self.staff = {
				username : '',
				password : ''
			};
			self.staffs = [];

			self.fetchAllStaffs = function() {
				StaffService.fetchAllStaffs().then(function(d) {
					self.staffs = d;
				}, function(errResponse) {
					console.error('Error while fetching Staffs member');
				});
			};

			self.loginStaff = function(staff) {
				console.log("staff details are ",staff);
				//console.log("username is ", self.staff.userName);
				//console.log("password is ", self.staff.password);
				StaffService.loginStaff(staff)
				.then(self.fetchAllStaffs,
						function(errResponse) {
							console.error('Error in staff login.');
						});
			};

			self.fetchAllStaffs();

			self.submit = function() {
				console.log('Staff has username ', self.staff.username);
				console.log('Staff password: ', self.staff.password);
				self.loginStaff(self.staff);
				self.reset();
			};

			self.reset = function() {
				self.staff = {
					username : '',
					password : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};

		} ]);
