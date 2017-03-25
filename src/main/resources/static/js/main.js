var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
        /*.when("/", {
            templateUrl : "/views/home.html"
        })*/
        .when("/first", {
            templateUrl : "views/pageFirst.html"
        })
        .when("/second", {
            templateUrl : "views/pageSecond.html"
        }).otherwise(
            { redirectTo: '/' }
        );
});