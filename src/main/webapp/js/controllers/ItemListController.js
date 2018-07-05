// START - USED SERVICES
/*
 *	ItemService.delete
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 *	ItemService.list
 *		PARAMS: 
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * ItemService  
 */
// END - REQUIRED RESOURCES


//CRUD LIST FOR [object Object]

app.controller('ItemListController', ['$scope', 'ItemService',
    function ($scope, ItemService ) {
		
    	$scope.list = ItemService.query();
    	
}]);