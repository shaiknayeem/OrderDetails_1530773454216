// START - USED SERVICES
/*
 *	OrderService.create
 *		PARAMS: 
 *		
 *
 *	OrderService.get
 *		PARAMS: 
 *		
 *
 *	OrderService.update
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * OrderService  
 */
// END - REQUIRED RESOURCES

app.controller('OrderEditController', ['$scope', '$location', '$routeParams', '$q', 'OrderService', 'ItemService', 'CustomerService',
    function ($scope, $location, $routeParams, $q, OrderService , ItemService, CustomerService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = OrderService.get({_id: $scope.id});
        	$scope.external._CustomerOrders = CustomerService.findByOrders({key: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new OrderService();
        	$scope.external._CustomerOrders = [];
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/orders/');
    		});
    	}
    	
    	$scope.remove = function(){
    		OrderService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/orders/');
    		});
    	}
    	
    		
        //manage relation Items
        		
    	$scope.list_Item = ItemService.query();

    		
        //manage External relation Orders
        		
    	$scope.list_CustomerOrders = CustomerService.query();
    	
}]);