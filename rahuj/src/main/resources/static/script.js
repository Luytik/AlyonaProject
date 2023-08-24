console.log("sd");

document.getElementById("wiew").onclick = function () {

    var xhr = new XMLHttpRequest();  
    console.log(xhr.readyState)        // Создание объекта для HTTP запроса.
    xhr.open("GET", "https://minfin.com.ua/");  // Настройка объекта для отправки асинхронного GET запроса
    //console.log(xhr.readyState)
    // функция-обработчик срабатывает при изменении свойства readyState
    // Значения свойства readyState:
    // 0 - Метод open() еще не вызывался
    // 1 - Метод open() уже был вызван, но метод send() еще не вызывался.
    // 2 - Метод send() был вызван, но ответ от сервера еще не получен
    // 3 - Идет прием данных от сервера. Для значения 3 Firefox вызывает обработчик события несколько раз IE только один раз.
    // 4 - Ответ от сервера полностью получен (Запрос успешно завершен).

    xhr.onreadystatechange = function () {
    //    console.log(xhr.readyState)
        if (xhr.readyState == 4) { // если получен ответ
            if (xhr.status == 200) { // и если статус код ответа 200
                console.log(xhr.responseText);
                //document.getElementById("output").innerHTML += xhr.responseText; // responseText - текст ответа полученного с сервера.
            }
        }
    }
    xhr.send();
                    // Отправка запроса, так как запрос асинхронный сценарий продолжит свое выполнение. Когда с сервера придет ответ сработает событие onreadystatechange
}