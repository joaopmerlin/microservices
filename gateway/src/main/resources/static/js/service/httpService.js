angular.module("app").service("httpService", ["$http", "$log", function (http, log) {

    this.get = function (url) {
        return http({
            method: 'GET',
            url: url,
            contentType: "application/json"
        }).error(function (e, status) {
            log.error(e);
        });
    };

    this.post = function (url, obj) {
        return http({
            method: 'POST',
            url: url,
            data: JSON.stringify(obj),
            contentType: "application/json"
        }).error(function (e, status) {
            log.error(e);
        });
    };

}]);
