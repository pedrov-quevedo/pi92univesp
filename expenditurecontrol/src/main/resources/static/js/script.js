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