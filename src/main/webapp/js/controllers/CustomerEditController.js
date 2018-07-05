// START - USED SERVICES
/*
 *	CustomerService.create
 *		PARAMS: 
 *		
 *
 *	CustomerService.get
 *		PARAMS: 
 *		
 *
 *	OrderService.list
 *		PARAMS: 
 *		
 *
 *	CustomerService.update
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * CustomerService  
 * OrderService  
 */
// END - REQUIRED RESOURCES

app.controller('CustomerEditController', ['$scope', '$location', '$routeParams', '$q', 'CustomerService', 'OrderService', 'OrderService',
    function ($scope, $location, $routeParams, $q, CustomerService , OrderService , OrderService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = CustomerService.get({_id: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new CustomerService();
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/customers/');
    		});
    	}
    	
    	$scope.remove = function(){
    		CustomerService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/customers/');
    		});
    	}
    	
    		
        //manage relation Orders
        		
    	$scope.list_Order = OrderService.query();

}]);