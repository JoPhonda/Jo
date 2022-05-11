//takes pieces of HTML to store for later
let directions = document.getElementById('directions');
let input = document.getElementById('input');
let button = document.getElementById("button");
let output = document.getElementById("output");
let service = document.getElementById("service");

//change the text on the page for directions.
directions.innerHTML = "Enter the cost of the meal.\nPress 'calculate' to get tip"
/*write the function that will calculate the tip amount from the cost of the meal at 15%*/
function calculateTip(){
    let cost = parseFloat(input.value);
    let percent = service.value;
    let tip = cost * percent / 100;
    let outputText = "The tip at " + percent+ "% will be $" + tip;
    let total = cost + parseFloat(tip);
    total = total.toFixed(2);
    outputText += "\nThe total cost with tip is $" + total;
    output.innerHTML = outputText;
}
/*Write the function to select the tip rate for the service*/
    function selectTipRate(){
        let percent = parseFloat(service.input)
        return percent/100;
    }
    button.onclick = calculateTip;