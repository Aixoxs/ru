const checkBox = function (val) {
    document.querySelector("#error-log").textContent = $(".check-" + val + "-input input:checked");

    return (Number($(".check-" + val + "-input input:checked").length) > 0);
}

const onInpChange = function () {
    let elemY = $("#y-value-select");

    let value = Number(elemY.val().replace(",", "."));
    return !(value <= -5 || value >= 5 || isNaN(value) || /[\s]+/.test(elemY.val()) || elemY.val() === "");
}

const submit = function (e) {
    e.preventDefault();
    if (!onInpChange()) {
        document.querySelector('#error-log').textContent = "Значение Y должно быть в диапазоне (-5;5)";
        return;
    } else {
        document.querySelector('#error-log').textContent = "";
    }

    if (!checkBox("r")) {
        document.querySelector("#error-log").textContent = "Значение R должно быть выбрано";
        return;
    } else {
        document.querySelector("#error-log").textContent = "";
    }

    const arrayCheckedR = [];

    $('.check-r-input input:checked').each(function () {
        arrayCheckedR.push($(this).val());
    });

    const xVal = $('#x-value').val();

    const yVal = $('#y-value-select').val();

    sendRequest(xVal,arrayCheckedR,yVal,"form");
};

document.addEventListener('DOMContentLoaded', function () {
    document.querySelector('#send-button').addEventListener('click', submit);
});

const clear = function (e) {
    $("circle").remove();
    sendRequest(0,[0],0,"clear");
};

document.addEventListener('DOMContentLoaded', function () {
    document.querySelector('#clear-button').addEventListener('click', clear);
});