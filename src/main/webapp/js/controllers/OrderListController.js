// START - USED SERVICES
/*
 *	OrderService.delete
 *		PARAMS: 
 *		
 *
 *	OrderService.list
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


//CRUD LIST FOR [object Object]

app.controller('OrderListController', ['$scope', 'OrderService',
    function ($scope, OrderService ) {
		
    	$scope.list = OrderService.query();
    	
}]);