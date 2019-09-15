function predictNumber(inputNum, correctNum, interval) {
	inputNum = parseInt(inputNum);
	correctNum = parseInt(correctNum);
	interval = parseInt(interval);
	
	if (isNaN(inputNum) || isNaN(correctNum) || isNaN(interval)) {
	return 5;
	}

	let checkInterval = Math.abs(correctNum-num);
	if (num > correctNum && checkInterval > interval){
		return 1;
	} else if (num < correctNum && checkInterval > interval) {
		return 2;
	} else if ( (0 < checkInterval) && (checkInterval <= interval)){
		return 3;
	} else if (checkInterval == 0){
		return 4;
	}
}

var result = {
	1: "Too high, try again",
	2: "Too low, try again",
	3: "almost, try again",
	4: "Bingo",
	5: "Invalid input"
}

var CORRECT_NUMBER = "10";
var INTERVAL = "2";

do {
	var num = prompt ("What is your number ?");
	
	var predictedNumber = predictNumber(num, CORRECT_NUMBER, INTERVAL);
	console.log(predictedNumber);
	alert(result[predictedNumber]);
}
while (predictedNumber != 4);