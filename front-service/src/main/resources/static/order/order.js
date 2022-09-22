angular.module('market-front').controller('orderController', function ($scope, $rootScope, $http, $localStorage) {
    //const contextPath = 'http://localhost:8189/app/api/v1';
    const contextPath = 'http://localhost:5555/gateway/app/api/v1';

    $scope.checkOut = function () {
            $http({
                url: contextPath + '/orders/' + $localStorage.cartName,
                method: 'POST',
                data: {orderDetailsDto: $scope.orderDetails}
            }).then(function (response) {
                    $scope.loadCart();
                    $scope.orderDetails = null
                });
        };

    $scope.disabledCheckOut = function () {
        alert("Для оформления заказа необходимо войти в учетную запись");
    }