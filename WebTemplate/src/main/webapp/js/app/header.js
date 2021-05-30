app.controller("header", function($scope, $rootScope, $location, $http, $window) {
    $scope.brandName = [];
    $http.get('data.json').then(function(response){
        $scope.productList = response.data;
        
        {
            for(var i=0; i<$scope.productList.length; i++)
            {
                $scope.brandName.push($scope.productList[i].brand);
            }
        }
        $scope.res = [];
        
            $scope.brandNameUnique = $scope.brandName 
                .filter(function (item, pos) { 
                    
                return $scope.brandName.indexOf(item) == pos; 
            }) ;
        
        //console.log($scope.brandNameUnique);
    })  
    $scope.complete = function(string){  
        $scope.hidethis = false;  
        var output = [];  
        angular.forEach($scope.brandNameUnique, function(brand){
            if(brand!=null)
            {
                if(brand.toLowerCase().indexOf(string.toLowerCase()) >= 0)  
             {  
                  output.push(brand);  
             } 
            }  
              
        });  
        $scope.filterCountry = output;  
   } 
   $scope.fillTextbox = function(string){  
    $scope.country = string;  
    $scope.hidethis = true;  
}  

$scope.searchBrandNameInApi = function(brandName)
	{
		console.log('brandName'+ brandName);
	}
	


});
