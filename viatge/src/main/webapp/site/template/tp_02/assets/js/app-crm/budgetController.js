/**
 * Arquivo responsavel pela funcionalidade de "Orcamentos(Budget)" .
 */

	var app = angular.module('JooceboxSite', []);
	
	
	myApp.controller('BudgetController', ['$https', function($http) {
		  var store;
		  
		  $hhto.get('http://seventur.lvh.me:8080/viatge/teste').success(function(data){
			  store = data;
		  }
				  )

		}]);
	
	
//	app.controller('BudgetController', function($scope, $http) {

		
		
		
		
		
		
		
//		var itens = $resources('/teste')
//		 $http.get("http://seventur.lvh.me:8080/viatge/teste").
//		     success(function(data, status, header, config) {
//		     $scope.x = data;
//		     });
		
//		 var app = angular.module("MyApp", []);

//		 app.controller("PostsCtrl", function($scope, $http) {
//		   $http.get('data/posts.json').
//		     success(function(data, status, headers, config) {
//		       $scope.posts = data;
//		     }).
//		     error(function(data, status, headers, config) {
//		       // log error
//		     });
//		 });		 
		 
		 
		// Criando lista de itens
//	    $scope.itens = [
//	        	        {produto: 'Leite', quantidade: 2, comprado: false},
//	        	        {produto: 'Cerveja', quantidade: 12, comprado: false}
//	        	    ];
//
//	    
//	    //Exemplo adicionando Itens
//	    $scope.adicionaItem = function () {
//	        $scope.itens.push({produto: $scope.item.produto,
//	                           quantidade: $scope.item.quantidade,
//	                           comprado: false});
//	        $scope.item.produto = $scope.item.quantidade = '';
//	    };
//    
//});