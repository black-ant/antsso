var rest = {
    typeInsert: function (url, date) {
        restUtil.post(url, date)
    }
}

var defaultValue = {
    url: "http://localhost:8089/"
}
var restUtil = {
    post: function (url, date, backFunction) {
        $.post(defaultValue.url + url, date, backFunction);
    }
}
