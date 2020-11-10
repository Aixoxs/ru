<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Web-Programming</title>

  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300;400;700&display=swap"
        rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css">
</head>
<body>
<div class="wrapper">
  <header class="header">
    <span>Variant 2805, Aleksandr Gurin, P3232</span>
  </header>
  <div class="content">
    <div class="svg-coordinates">
      <svg id="svg" width="300" height="300" class="svg-graph" xmlns="http://www.w3.org/2000/svg">

        <!--            Линии оси-->

        <line class="axis" x1="0" x2="300" y1="150" y2="150" stroke="black"></line>
        <line class="axis" x1="150" x2="150" y1="0" y2="300" stroke="black"></line>
        <polygon points="150,0 144,15 156,15" stroke="black"></polygon>
        <polygon points="300,150 285,156 285,144" stroke="black"></polygon>

        <line class="coor-line" x1="200" x2="200" y1="155" y2="145" stroke="black"></line>
        <line class="coor-line" x1="250" x2="250" y1="155" y2="145" stroke="black"></line>

        <line class="coor-line" x1="50" x2="50" y1="155" y2="145" stroke="black"></line>
        <line class="coor-line" x1="100" x2="100" y1="155" y2="145" stroke="black"></line>

        <line class="coor-line" x1="145" x2="155" y1="100" y2="100" stroke="black"></line>
        <line class="coor-line" x1="145" x2="155" y1="50" y2="50" stroke="black"></line>

        <line class="coor-line" x1="145" x2="155" y1="200" y2="200" stroke="black"></line>
        <line class="coor-line" x1="145" x2="155" y1="250" y2="250" stroke="black"></line>

        <text class="coor-text" x="195" y="140">R/2</text>
        <text class="coor-text" x="248" y="140">R</text>

        <text class="coor-text" x="40" y="140">-R</text>
        <text class="coor-text" x="90" y="140">-R/2</text>

        <text class="coor-text" x="160" y="105">R/2</text>
        <text class="coor-text" x="160" y="55">R</text>

        <text class="coor-text" x="160" y="205">-R/2</text>
        <text class="coor-text" x="160" y="255">-R</text>

        <!-- first figure-->
        <polygon class="svg-figure triangle-figure" points="50,150 150,150, 150,250"
                 fill="#F38524" fill-opacity="0.3" stroke="#C56C1A"></polygon>

        <!-- second figure circle-->
        <path class="svg-figure circle-figure" d="M 200 150 A 50 50, 90, 0, 1, 150 200 L 150 150 Z"
              fill="#FEF102" fill-opacity="0.3" stroke="#CEC101"></path>

        <!-- third figure-->
        <polygon class="svg-figure rectangle-figure" points="50,150 150,150 150,50 50,50"
                 fill="#22449E" fill-opacity="0.3" stroke="#182E82"></polygon>

      </svg>
    </div>

    <form class="coordinates-form" oninput="onInpChange()" id="coordinates-form">
      <div class="data-inputs">
        <div class="group">
          <input type="text" id="y-value-select" name="y_value" required>
          <span class="bar"></span>
          <label>Y Value</label>
        </div>

        <div class="checkboxes-inputs">
          <div class="check-r-input">
            R Value:
            <p class="checkbox">
              <input type="checkbox" name="r-value-1" id="r-value-1" value="1">
              <label for="r-value-1">1</label>
            </p>
            <p class="checkbox">
              <input type="checkbox" name="r-value-2" id="r-value-2" value="2">
              <label for="r-value-2">2</label>
            </p>
            <p class="checkbox">
              <input type="checkbox" name="r-value-3" id="r-value-3" value="3">
              <label for="r-value-3">3</label>
            </p>
            <p class="checkbox">
              <input type="checkbox" name="r-value-4" id="r-value-4" value="4">
              <label for="r-value-4">4</label>
            </p>
            <p class="checkbox">
              <input type="checkbox" name="r-value-5" id="r-value-5" value="5">
              <label for="r-value-5">5</label>
            </p>
          </div>

          <!--                <div class="range-input">-->
          <!--                    <label for="x-value-select">X Value: </label>-->
          <!--                    <span id="demo"></span>-->
          <!--                    <input id="x-value-select" name="x_value" type="range" min="-2" max="2" step="0.5" value="0">-->
          <!--                </div>-->

          <div class="check-x-input">
            X Value:
            <p class="checkbox">
                <select name="x-value" id="x-value">
                    <option value="3">3</option>
                    <option value="2">2</option>
                    <option value="1">1</option>
                    <option value="0">0</option>
                    <option value="-1">-1</option>
                    <option value="-2">-2</option>
                    <option value="-3">-3</option>
                    <option value="-4">-4</option>
                    <option value="-5">-5</option>
                </select>
            </p>
          </div>
        </div>

        <div class="form-buttons">
          <button id="send-button" type="submit">Send</button>
          <button id="clear-button" type="button">Clear</button>
        </div>

        <span id="error-log" style="color: red"> </span>
      </div>


    </form>

    <div id="table">
        <jsp:include page="WEB-INF/table.jsp" />
    </div>
  </div>
</div>
<script src="js/jquery-3.4.1.js"></script>
<script src="scripts/requester.js"></script>
<script src="scripts/form-valid.js"></script>
<script src="scripts/graph-draw.js"></script>
</body>
</html>
