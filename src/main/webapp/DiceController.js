function DiceController() {
    // Gir oss et rando heltall mellom 0-5, så plusser vi på 1 for å få et tall tilsvarende terningen
    const randomNumber = Math.floor(Math.random() * 6) + 1;

    // Bilde som gir terning tilsvarende terningkast
    const diceImage = 'Dice-' + randomNumber + '.png';

    //
    document.querySelectorAll('img')[0].setAttribute('src', diceImage);
    // Skriver ut teksten og verdien fra RandomNumber i <h1> i HTML-dokumentet
    document.querySelector('h1').innerHTML = 'Du trillet ' + randomNumber;

}