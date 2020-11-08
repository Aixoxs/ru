"use strict"

let svg = document.querySelector("#svg");

$("#svg").click(function (event) {
    if(checkBox("r")) {
        document.querySelector("#error-log").textContent = "";
        let rect = svg.getBoundingClientRect();
        let relativeX = (event.clientX - rect.left);
        let relativeY = (event.clientY - rect.top);
        const arrayCheckedR = [];
        $('.check-r-input input:checked').each(function () {
            arrayCheckedR.push($(this).val());
        });
        svg.insertAdjacentHTML("beforeend", `<circle r="4" cx="${relativeX}" cy="${relativeY}" fill-opacity="0.7" fill="grey" stroke="black"></circle>`);
        sendRequest(relativeX,arrayCheckedR,relativeY,"svg");
    }else document.querySelector("#error-log").textContent = "Значение R должно быть выбрано";

});
