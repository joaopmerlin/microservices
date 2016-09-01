angular.module("app").controller("finalizarCadastroController", ["httpService", "$scope", "$log", function (httpService, scope, log) {

    scope.filial = {};

    scope.buscaCnpj = function (cnpj) {
        httpService.get("api/cnpj/" + cnpj).then(function (data) {
            scope.filial.razao = data.data.nome;
            scope.filial.fantasia = data.data.fantasia;
        });
    };

    scope.save = function (filial) {
        httpService.post("api/finalizar-cadastro", filial).then(function (data) {
            log.info(data.data);
        });
    };

}]);