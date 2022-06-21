function ajustingHomeLayout(){
    var height = window.screen.height;
    var width = window.screen.width;

    if(width < 1200){
        document.getElementById('sideMenuBar').style.width = '150px';
    }
        
    else{
        document.getElementById('sideMenuBar').style.width = '250px';
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

    document.getElementById('dataHoraAtual').innerHTML =  dia + "/" + mes + "/" + ano + " - " + hora + ":" + minuto + ":" + segundo;
    setTimeout(startTime, 1000);
  }
  
  function checkTime(i) {
    if (i < 10) {
        i = "0" + i
    }
    return i;
  }

  function checkDate(diaMes) {
    if (diaMes < 10) {
        diaMes = "0" + diaMes
    }
    return diaMes;
  }