function ajustingHomeLayout() {
  var height = window.screen.height;
  var width = window.screen.width;

  if (width < 1200) {
    document.getElementById("sideMenuBar").style.width = "150px";
  } else {
    document.getElementById("sideMenuBar").style.width = "250px";
  }
}

function startTime() {
  const today = new Date();
  let hora = today.getHours();
  let minuto = today.getMinutes();
  let segundo = today.getSeconds();
  let dia = today.getDay();
  let mes = today.getMonth();
  let ano = today.getFullYear();

  minuto = checkTime(minuto);
  segundo = checkTime(segundo);

  dia = checkDate(dia);
  mes = checkDate(mes);

  document.getElementById("dataHoraAtual").innerHTML =
    dia + "/" + mes + "/" + ano + " - " + hora + ":" + minuto + ":" + segundo;
  setTimeout(startTime, 1000);
}

function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}

function checkDate(diaMes) {
  if (diaMes < 10) {
    diaMes = "0" + diaMes;
  }
  return diaMes;
}

function openViews(view) {
  var v = document.getElementById(view);

  if (view == "home") {
    document.getElementById("movements").style.visibility = "hidden";
    document.getElementById("profile").style.visibility = "hidden";
    document.getElementById("movements").style.width = "0px";
    document.getElementById("profile").style.width = "0px";
  } else {
    if (v.style.visibility == "visible") {
      var x = document.querySelectorAll("#" + view);
      x[0].style.setProperty("visibility", "hidden", "important");

      var x = document.querySelectorAll("#" + 'cadMovements');
      x[0].style.setProperty("visibility", "hidden", "important");
      // v.style.visibility = 'hidden'
      v.style.width = "0%";

      if (view == "profile") {
        document.getElementById("movements").style.visibility = "hidden";
        document.getElementById("movements").style.width = "0px";
      } else if (view == "movements") {
        document.getElementById("profile").style.visibility = "hidden";
        document.getElementById("profile").style.width = "0px";
      }
    } else {
      var x = document.querySelectorAll("#" + view);
      x[0].style.setProperty("visibility", "visible", "important");
      // v.style.visibility = 'visible'
      v.style.width = "90%";

      if (view == "profile") {
        document.getElementById("movements").style.visibility = "hidden";
        document.getElementById("movements").style.width = "0px";
      } else if (view == "movements") {
        document.getElementById("profile").style.visibility = "hidden";
        document.getElementById("profile").style.width = "0px";
      }
    }
  }
}

function showHideCadMovements() {
  var x = document.querySelectorAll("#" + "cadMovements");

  if (document.getElementById("cadMovements").style.visibility == "visible") {
    x[0].style.setProperty("visibility", "hidden", "important");
    x[0].style.setProperty("display", "none");

    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.animationDelay = "0.7s"
    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.transform = "rotate(90deg)";
  } else {
    x[0].style.setProperty("visibility", "visible", "important");
    x[0].style.setProperty("display", "block");

    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.animationDelay = "0.7s"
    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.transform = "rotate(-45deg)";
  }
}

function today() {
  var myDate = document.getElementById("edtData");
  var today = new Date();
  myDate.value = today.toISOString().substr(0, 10);
}
