var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        /*.when("/", {
            templateUrl : "/views/home.html"
        })*/
        .when("/first", {
            templateUrl : "views/pageFirst.html",
            controller: 'usersController'
        })
        .when("/second", {
            templateUrl : "views/pageSecond.html",
            controller: 'mailController'
        }).otherwise(
            { redirectTo: '/' }
        );
});

app.controller('usersController', function($scope, $http) {
    $scope.headingTitle = "User List";

    $http.get("first/resource").then(function (response) {
        if (response.status == 200) {
            $scope.Users = response.data;
        }
    });
});

app.controller('mailController', function($scope, $http) {
    $scope.sendMail = function() {
        $http.get("second/sendMail").then(function (response) {
            if (response.status == 200) {
                console.log('Email was send');
            }
        });
    };
});