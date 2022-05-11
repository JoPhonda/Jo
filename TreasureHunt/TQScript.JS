$('#map').click(play);
let clicks = $('#clicks');
let message = $('#message');

let width = 1000;
let height = 500;
let clickCounter = 15;
let game = true;

function getRandomNumber(value) {
    return Math.random() * value
}

let treasure = {
    x:getRandomNumber(width),
    y:getRandomNumber(height)
}
function play(event) {
    if(game){
    let distance = Math.floor(getDistance(event, treasure));
    clickCounter--;
    clicks.text(clickCounter);
    let userMessage = getMessage(distance);
    message.text(userMessage);
    checkForLoss();
    }
}

function getDistance(event, target) {
    let diffX = event.offsetX - target.x;
    let diffY = event.offsetY - target.y;
    return Math.sqrt(diffX**2 + diffY**2);
}

function getMessage(value) {
   if (value<50){
       game = false;
       return "You can see the treasure "+ value + " ft away, congrats" 
}
    else
    return "Closer, treasure is " + value + " ft away"
}

function checkForLoss() {
    if(clickCounter === 0){
        message.text("Out of clicks, you lose.")
        game = false;
    }
}

function replay() {
    game = true;
    clickCounter = 15
    clicks.text(clickCounter)
    message.text("Game reset.");
    treasure.x = getRandomNumber(width);
    treasure.y = getRandomNumber(height);
}



