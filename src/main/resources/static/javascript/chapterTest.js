async function sendTest() {
    let inputs = document.querySelectorAll("input[type = radio]")

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
            console.log(data[0])

            for(ans of data){
                for(inp of inputs) {
                    if (inp.name == ans.id.toString()) {
                        if (ans.correct) {
                            inp.parentElement.parentElement.classList.remove("incorrect");
                            inp.parentElement.parentElement.classList.add("correct");
                        } else {
                            inp.parentElement.parentElement.classList.remove("correct");
                            inp.parentElement.parentElement.classList.add("incorrect");
                        }

                    }

                }
            }

    })
}