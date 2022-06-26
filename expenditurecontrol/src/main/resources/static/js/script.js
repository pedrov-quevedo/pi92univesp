function ajustingHomeLayout() {
  var height = window.screen.height;
  var width = window.screen.width;

  if (width < 1200) {
    document.getElementById("sideMenuBar").style.width = "150px";
  } else {
    document.getElementById("sideMenuBar").style.width = "250px";
  }
}

function openViews(view) {
  var show = document.querySelectorAll("#" + view);

  if (view == "initial") {
    var hide1 = document.querySelectorAll("#" + "profile");
    var hide2 = document.querySelectorAll("#" + "movements");

    show[0].style.setProperty("display", "block", "important");
    hide1[0].style.setProperty("display", "none", "important");
    hide2[0].style.setProperty("display", "none", "important");
  }

  if (view == "profile") {
    var hide1 = document.querySelectorAll("#" + "initial");
    var hide2 = document.querySelectorAll("#" + "movements");

    if (document.getElementById("profile").style.display == "none") {
      hide1[0].style.setProperty("display", "none", "important");
      show[0].style.setProperty("display", "block", "important");
    } else {
      show[0].style.setProperty("display", "none", "important");
      hide1[0].style.setProperty("display", "block", "important");
    }

    hide2[0].style.setProperty("display", "none", "important");
  }

  if (view == "movements") {
    var hide1 = document.querySelectorAll("#" + "initial");
    var hide2 = document.querySelectorAll("#" + "profile");

    if (document.getElementById("movements").style.display == "none") {
      hide1[0].style.setProperty("display", "none", "important");
      show[0].style.setProperty("display", "block", "important");
    } else {
      show[0].style.setProperty("display", "none", "important");
      hide1[0].style.setProperty("display", "block", "important");
    }

    hide2[0].style.setProperty("display", "none", "important");
  }
}

function showHideCadMovements() {
  var x = document.querySelectorAll("#" + "cadMovements");

  if (document.getElementById("cadMovements").style.visibility == "visible") {
    x[0].style.setProperty("visibility", "hidden", "important");
    x[0].style.setProperty("display", "none");

    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.animationDelay = "0.7s";
    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.transform = "rotate(90deg)";
  } else {
    x[0].style.setProperty("visibility", "visible", "important");
    x[0].style.setProperty("display", "block");

    document
      .getElementById("movements")
      .getElementsByTagName("button")[1].style.animationDelay = "0.7s";
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
