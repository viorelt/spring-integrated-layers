function AccountController($scope,AccountService){
    AccountService.list({},function(data){
        $scope.accountList = data;
        console.log(data);
    });
    $scope.add = function(){}
}