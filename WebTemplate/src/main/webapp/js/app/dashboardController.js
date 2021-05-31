app.controller("dashboardController", function($scope, $rootScope, $location, $http, $window) {
	
	
	$http.get('/fetchExistingShortURL').then(function(response){
		$scope.listOfExistingURL = response.data;
	})
	$scope.getList = function()
	{
		$http.get('/fetchExistingShortURL').then(function(response){
			$scope.listOfExistingURL = response.data;
		})
	}

		
	
	
	
$scope.generateShortenedURL = function(url)
{

	
	var data = {};
	data.inputURL = url;

	$http.post('generateShortenedURL', JSON.stringify(data)).then(function(response){

		console.log('response sent');


		$window.alert('Duplicate URL Generated');

		$scope.getList();
		$scope.longUrl = '';
	});
}
	
	


});


