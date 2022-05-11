let output = document.getElementById("output");
let input = document.getElementById("input");
let button = document.getElementById("button");
output.innerHTML = "Type a color:";
function changeColor(){
    let color = input.value;
    output.style.color = color;
}
input.onchange = changeColor;
function changeColor2(){
    let color = input2.value;
    output.style.color = color;
}
button.onclick = changeColor2;