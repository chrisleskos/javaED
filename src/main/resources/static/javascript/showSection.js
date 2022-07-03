sectionsContainer = document.querySelector(".sections");
sectionsContent = document.querySelectorAll(".section-content-wrapper");

for(content of sectionsContent) {
    contentPlatform = document.querySelector(".content-aligning-platform");
    contentPlatform.appendChild(content)
}

function showSection(button) {

    sectionButtons = document.querySelectorAll(".section");

    for(b of sectionButtons) {
        b.classList.remove("selected-section");
    }

    button.classList.add("selected-section");

    sectionsContainer.classList.add("side-sections");

    for (content of sectionsContent) {
        if (button.title == content.title){
            content.style.display = "flex";
        } else {
            content.style.display = "none";
        }
    }
}