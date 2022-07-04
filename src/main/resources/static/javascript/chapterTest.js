async function sendTest() {
    let inputs = document.querySelectorAll("input[type = radio]")
    scoreSpan = document.querySelector("#score");
    mistakeNotes = document.querySelector(".mistake-notes")

    answers = []
    for (inp of inputs) {

        if (inp.checked) {
            tmp = {
                id: inp.name,
                givenAnswer: inp.value
            }

            answers.push(tmp)
        }
    }


    const response = await fetch(window.location.href, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(answers)

    })

    response.json()
        .then(data => {

            totalScore = 0;
            sectionTitlesNoted = []
            for(answer of data){
                console.log(answer)
                for(inp of inputs) {
                    if (inp.name == answer.id.toString()) {
                        if (answer.correct) {
                            inp.parentElement.parentElement.classList.remove("incorrect");
                            inp.parentElement.parentElement.classList.add("correct");
                            totalScore++;
                        } else {
                            inp.parentElement.parentElement.classList.remove("correct");
                            inp.parentElement.parentElement.classList.add("incorrect");

                            if (answer.mistake_count > 5) {
                                if(!sectionTitlesNoted.includes(answer.section_title)) {
                                    mistakeNotes.innerHTML += "<div class='unhappy-note'>Seems like you have too many mistakes in " + answer.section_title + ". Try reading that section again.</div><br>";
                                    sectionTitlesNoted.push(answer.section_title);
                                }
                            }
                        }
                        break;
                    }

                }
            }
            submitButton = document.querySelector(".submit-button");
            submitButton.style.display = "none";
            submitButton.onclick = null;

            testForm = document.querySelector("form");
            testForm.style.pointerEvents = "none";

            scoreSpan.innerHTML = "<br>" + totalScore + "/" + data.length + "<br>";

            if (totalScore < data.length/2) {
                mistakeNotes.innerHTML = "<div class='unhappy-note'>Don't give up. Read the questions more carefully and do a revision.</div><br>" + mistakeNotes.innerHTML ;
            } else if (totalScore < data.length ) {
                mistakeNotes.innerHTML = "<div class='happy-note'>Good job. Do a revision so you can get a better score. Practice makes perfect!</div><br>" + mistakeNotes.innerHTML ;
            } else {
                mistakeNotes.innerHTML = "<div class='happy-note'>Amazing! Seems like you are ready for the next step!!!</div><br>" + mistakeNotes.innerHTML ;
            }

    })
}