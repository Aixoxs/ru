function sendRequest(xVal, arrayCheckedR, yVal, key) {
    fetch("control",{
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
        },
        body: "x=" + encodeURIComponent(xVal) + "&y=" + encodeURIComponent(yVal) +
            "&r=" + encodeURIComponent(arrayCheckedR) + "&key=" + encodeURIComponent(key)
    }).then(response => response.text()).then(function (serverAnswer) {
        document.getElementById("table").innerHTML = serverAnswer;
    })
}