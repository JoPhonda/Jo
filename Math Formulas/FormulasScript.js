//functions which take replace inputs with the variables and calculates
function areaSquare(side){
    let area = side**2;
    return area;
}
function areaRectangle(height, base){
    let area = height*base;
    return area;
}
function areaTriangle(height, base){
    let area = height*base/2;
    return area;
}
function areaCircle(radius){
    let area = radius**2*Math.PI;
    return area;
}
function perimeterSquare(side){
    let perimeter = side*4;
    return perimeter;
}
function perimeterRectangle(height, base){
    let perimeter = height*2+base*2;
    return perimeter;
}
function perimeterTriangle(side1, side2, side3){
    let perimeter = side1+side2+side3;
    return perimeter;
}
function circumferenceCircle(radius){
    let perimeter =2*Math.PI*radius;
    return perimeter;
}
function volumeCube(side){
    let volume = side**3;
    return volume;
}
function volumeRectPrism(height, length, width){
    let volume = height*width*length;
    return volume;
}
function volumeCone(radius, height){
    Math.PI*radius**2*height/3;
    return volume;
}
function volumeSphere(radius){
    let volume = 4/3*Math.PI*radius**3;
    return volume;
}
let select = document.getElementById("select");
let inputs = document.getElementById("inputs");
let output = document.getElementById("output");
let button = document.getElementById("button");

let formulas = {
    perimeterRectangle: ["Height", "Base"],
    perimeterSquare: ["Side"],
    perimeterTriangle: ["Side A","Side B", "Side C"],
    circumferenceCircle: ["Radius"]
}
function updateInputs(){
    let neededInputs = select.value;
    let dimentions = formulas[neededInputs];

    inputs.innerHTML = "";
    output.innerHTML = "";
    for(let i=0; i < dimentions.length; i++){
        let text = dimentions[i];
        text +=": <input id='input"+i+"'><br>";
        inputs.innerHTML += text;
    }
}
function calculate(){
    let formula = select.value;
    let input0 = document.getElementById("input0");
    let input1 = document.getElementById("input1");
    let input2 = document.getElementById("input2");
    let param0, param1, param2;
    param0 = input0 ? parseFloat(input0.value): 0;
    param1 = input1 ? parseFloat(input1.value): 0;
    param2 = input2 ? parseFloat(input2.value): 0;
    let answer = 0;
    switch(formula){
    case "perimeterRectangle":
        answer = perimeterRectangle(param0, param1);
        break
    case "perimeterSquare":
        answer = perimeterSquare(param0);
        break
    case "perimeterTriangle":
        answer = perimeterTriangle(param0, param1, param2);
        break
    case "circumferenceCircle":
        answer = circumferenceCircle(param0);
        break
    }
    output.innerHTML = "Answer: "+answer;
}

button.onclick = calculate;
select.onchange = updateInputs;