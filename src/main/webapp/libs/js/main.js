function findUser() {
    $('#jsontotable-str').empty();
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'users/'+document.getElementById("search").value, false);
    xhr.send();
    if (xhr.status != 200) {
        $("#jsontotable-str")
            .append($("<h1></h1>").html("Not Found"));
        return null

    } else {
        $("#jsontotable-str")
            .append($("<h1></h1>").html("User"));

        return "[{\"id\":\"\",\"username\":\"\",\"email\":\"\",\"roles\":\"\"},"+xhr.responseText+"]";
    }
}
function getAllUser() {
    $('#jsontotable-str').empty();
    var xhr = new XMLHttpRequest();

    // 2. Конфигурируем его: GET-запрос на URL 'phones.json'
    xhr.open('GET', 'users/alluser', false);

    // 3. Отсылаем запрос
    xhr.send();

    // 4. Если код ответа сервера не 200, то это ошибка
    if (xhr.status != 200) {
        // обработать ошибку
        alert( xhr.status + ': ' + xhr.statusText ); // пример вывода: 404: Not Found
    } else {
        $("#jsontotable-str")
            .append($("<h1></h1>").html("All Users"));

        return xhr.responseText;

    }
}
function JsonConverter(str) {
    $(document).ready(function() {
        if(str != null)
        {
            $.jsontotable(str, {
                id: "#jsontotable-str",
                className: "table table-hover"
            });}
    });

}
function DeleteUser() {
    if (confirm("Delete user " + document.getElementById("delete").value + "?"))
        $('#jsontotable-str').empty();
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'users/' + document.getElementById("delete").value, false);
    xhr.send();
    if (xhr.status != 200) {
        $("#jsontotable-str");
        alert("User not found");

    } else {
        $("#jsontotable-str")
            .append($("<h1></h1>").html(xhr.responseText + " delete"));
    }
}
function clickEvent(event) {
    var target;
    if (!event) {
        var event = window.event;
    }
    if (event.target) {
        target = event.target;
    } else if (event.srcElement) {
        target = event.srcElement;
    }
    if (target) {
        if (target.nodeType == 3) {
            target = target.parentNode;
        }
        if (target.tagName.toLowerCase() == "td") {
            var row = target.parentNode;
            var str = row.getElementsByTagName("td").item(1).innerHTML;
            document.getElementById("delete").value = str;

        }

    }
}