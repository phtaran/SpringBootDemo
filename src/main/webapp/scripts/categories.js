/**
 * Created by ph on 29.11.2016.
 */

var categories = {
    items: [],
    getItems: function () {
        return this.items;
    },
    addItem: function (item) {
        this.items.push(item);
    },
    setItems: function (new_items) {
        this.items = new_items
    },
    onChange: null,
    update: function () {
        this.onChange();
    }
};

function makeHtmlList(rootContent, items) {
    var list = "";

    items.forEach(function (item) {
        list += "<li>" + item + "</li>";
    });
    rootContent.innerHTML = list;
}

function getCategories(callback) {
    doGetRequest(HOST + CATEGORY_GET, callback);
}

function doGetRequest(url, success_callback) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var res = JSON.parse(xhttp.responseText);
            success_callback(res)
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}