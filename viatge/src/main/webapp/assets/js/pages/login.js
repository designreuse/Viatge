angular.module('myApp',[])
    .controller('loginController', function($scope, $location){
        var url = "" + $location.$$absUrl;
        $scope.displayLoginError = (url.indexOf("error") >= 0);
        $scope.displayLogoutMessage = (url.indexOf("logout") >= 0);
    });