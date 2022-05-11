const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
let width = canvas.width;
let height = canvas.height;

let blockSize = 20;
let widthInBlocks = width/blockSize;
let heightInBlocks = height/blockSize;

let variable = 0;
const keyAction ={
    ArrowUp: 'up',
    ArrowDown: 'down',
    ArrowLeft: 'left',
    ArrowRight: 'right'
}
let score = $("#scoreArea");
function drawScore(){
    score.text(variable);
}
$("body").keydown(function(event){
    let newDirection = keyAction[event.code];
    if(newDirection !== undefined){
        snake.setDirection(newDirection);
    }
});
function gameOver(){
    clearInterval(intervalId);
    this.direction = "";
    this.nextDirection = "";

}
function drawBorder(){
    ctx.fillStyle = "gray";
    ctx.fillRect(0,0,width,blockSize);
    ctx.fillRect(0,0,blockSize,height)
    ctx.fillRect(400,400,-blockSize,-height)
    ctx.fillRect(400,400,-width,-blockSize);
}
drawBorder();
function circle(x,y,radius){
    ctx.beginPath();
    ctx.arc(x,y,radius, 0, 2*Math.PI);
    ctx.fill();
}

let Block = function(col,row){
    this.col = col;
    this.row = row;
}
Block.prototype.drawSquare = function(color){
    let x = this.col * blockSize;
    let y = this.row * blockSize;
    ctx.fillStyle = color;
    ctx.fillRect(x,y,blockSize,blockSize);
}
Block.prototype.drawCircle = function(color){
    let centerX = this.col * blockSize + blockSize/2;
    let centerY = this.row * blockSize + blockSize/2;
    ctx.fillStyle = color;
    circle(centerX, centerY, blockSize/2);
}
Block.prototype.equal = function(otherBlock){
    return this.col=== otherBlock.col && this.row === otherBlock.row
}

let Snake = function(){
    this.segments = [
        new Block(7,5),
        new Block(6,5),
        new Block(5,5)
    ];
    this.direction = 'right';
    this.nextDirection = 'right';
};
Snake.prototype.draw = function(){
    for (let i=0; i<this.segments.length; i++){
        this.segments[i].drawSquare('blue');
    }
};
Snake.prototype.move = function(){
    let head = this.segments[0];
    let newHead;
    this.direction = this.nextDirection;
    if(this.direction === 'right'){
        newHead = new Block(head.col + 1, head.row);
    }
    if(this.direction === 'down'){
        newHead = new Block(head.col, head.row + 1);
    }
    if(this.direction === 'left'){
        newHead = new Block(head.col - 1, head.row);
    }
    if(this.direction === 'up'){
        newHead = new Block(head.col, head.row - 1);
    }

    if(this.checkCollision(newHead)){
        gameOver();
        return;
    }
    this.segments.unshift(newHead);
    if(newHead.equal(apple.position)){
        variable++;
        apple.move();
    }
    else{
        this.segments.pop()
    }
};
Snake.prototype.checkCollision = function(head){
    let leftCollision = head.row === 0;
    let topCollision = head.col === 0;
    let rightCollision = head.row === 39;
    let bottomCollision = head.col === 39;

    let wallCollision = (leftCollision || topCollision || rightCollision || bottomCollision);

    let selfCollision = false;
    for(let i=0; i<this.segments.length; i++){
        if(head.equal(this.segments[i])){
            selfCollision = true;
        }
    }
    return wallCollision || selfCollision;
};
Snake.prototype.setDirection = function(newDirection){
    if (this.direction === 'up' && newDirection === 'down'){
    return;
} else if(this.direction === 'down' && newDirection === 'up'){
    return;
} else if(this.direction === 'left' && newDirection === 'right'){
    return;
} else if(this.direction === 'right' && newDirection === 'left'){
    return;
}this.nextDirection = newDirection;
};

let Apple = function() {
    this.position = new Block (10,10);
};
Apple.prototype.draw = function (){
    this.position.drawCircle('red');
};
Apple.prototype.move = function(){
    let randomCol = Math.floor(Math.random() * 38)+1;
    let randomRow = Math.floor(Math.random() * 38)+1;
    this.position = new Block(randomCol, randomRow);
};
let snake = new Snake();
snake.draw();
let apple = new Apple()

let intervalId = setInterval(function(){
    ctx.clearRect(0,0,width,height);
    drawScore();
    snake.move();
    snake.draw();
    apple.draw()
    drawBorder();
    
}, 150)