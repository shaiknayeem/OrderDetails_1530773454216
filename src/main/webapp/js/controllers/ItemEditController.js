// START - USED SERVICES
/*
 *	ItemService.create
 *		PARAMS: 
 *		
 *
 *	OrderService.findByItems
 *		PARAMS: 
 *					Objectid key - Id della risorsa Items da cercare
 *		
 *
 *	ItemService.get
 *		PARAMS: 
 *					ObjectId id - Id 
 *		
 *
 *	ItemService.update
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * ItemService  
 * OrderService  
 */
// END - REQUIRED RESOURCES

app.controller('ItemEditController', ['$scope', '$location', '$routeParams', '$q', 'ItemService', 'OrderService', 'OrderService',
    function ($scope, $location, $routeParams, $q, ItemService , OrderService , OrderService) {

    	//manage create and save
		$scope.external = {};
		
    	if ($routeParams.id != 'new')
    	{
        	$scope.id = $routeParams.id;
        	$scope.obj = ItemService.get({_id: $scope.id});
        	$scope.external._OrderItems = OrderService.findByItems({key: $scope.id});
        	
    	}
    	else{
    		$scope.obj = new ItemService();
        	$scope.external._OrderItems = [];
        	
    	}
    	
    	$scope.save = function(){
    		$scope.obj.$save().then(function(data){
    			$scope.obj=data;
        		$location.path('/items/');
    		});
    	}
    	
    	$scope.remove = function(){
    		ItemService.remove({_id: $scope.obj._id}).$promise.then(function(){
				$('#removeModal').modal('hide');
				$('.modal-backdrop').remove();
				$('.modal-open').removeClass("modal-open");
        		$location.path('/items/');
    		});
    	}
    	
    		
        //manage External relation Items
        		
    	$scope.list_OrderItems = OrderService.query();
    	
}]);