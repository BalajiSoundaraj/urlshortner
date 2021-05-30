var app = angular.module('shoppingApp', [
    'ngRoute', 
    ]);
    
    /**
    * Configure the Routes
    */
    app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
    // Home
    .when("/home",
     {templateUrl: "templates/dashboard.html",
      controller: "dashboardController"
    })
     
    
    
    }]);

    