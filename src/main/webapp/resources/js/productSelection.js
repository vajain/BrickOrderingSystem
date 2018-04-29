var myApp = angular.module('myApp', []);
myApp.controller('ShoppingAppController', function($scope, $http, $location){
    $scope.products = [];
    $http.get('http://localhost:8080/ShoppingApp/getProducts/3')
		.then(function (response){
			$scope.products = response.data;
			console.log("status:" + response.status);
		}).catch(function(response) {
		  console.error('Error occurred:', response.status, response.data);
		}).finally(function() {
			 console.log("Task Finished.");
		});
		
		$scope.selectedItems=[];    
		$scope.value=function(isSelected,item)
		{
			if(isSelected==true)
			{
				$scope.selectedItems.push(item);
			}
			else
			{
				console.log(item.product);              
				angular.forEach($scope.selectedItems,function(itemRmv,$index){
				if(itemRmv.product==item.product)
					{
						$scope.selectedItems.splice($index,1);
					}
				})
			}
		}
		
		$scope.clicked = function(){   
	        $location.path('/confirmation.html');
		}
});  