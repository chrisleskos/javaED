function goToPlanet(){

    earth.classList.remove("earth");

    for(planet of planets) {
        offSet = 1.6*(planet.getBoundingClientRect().top - 180.5);
        console.log("Test: " + offSet);
        planet.style.setProperty('height', "calc(80% + " + offSet + "px)");
        planet.style.setProperty("left", "calc(15px - " + offSet +"px)");
    }
}

function setPlanetPhotos() {
    for(i=1; i<planets.length; i++) {
        planets[i].src = "../images/planet"+i+".png";
    }
}

function navigateToChapters(idx){
    document.querySelectorAll('.chapter-wrapper')[idx].scrollIntoView({ behavior: 'smooth', block: 'center'});
}

planets = document.getElementsByClassName("planet");

earth = document.getElementsByClassName("earth")[0];
contentWindow = document.getElementsByClassName("content-window")[0];

contentWindow.onscroll = function () {
    goToPlanet();
};




setPlanetPhotos();
console.log("Im working");