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


    const response = await fetch("http://localhost:8091/chapter/test/submit" + window.location.search, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(answers)

    })

    return answers
}