$(".card-columns").each(function () {
    let i;
    const divs = $(this).find('div');
    for (i = 0; i < divs.length; i++) $(divs[i]).remove();

    shuffle(divs);

    for (i = 0; i < divs.length; i++) $(divs[i]).appendTo(this);
});

function shuffle(array) {
    let currentIndex = array.length, temporaryValue, randomIndex;

    // While there remain elements to shuffle...
    while (0 !== currentIndex) {

        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;

        // And swap it with the current element.
        temporaryValue = array[currentIndex];
        array[currentIndex] = array[randomIndex];
        array[randomIndex] = temporaryValue;
    }

    return array;
}