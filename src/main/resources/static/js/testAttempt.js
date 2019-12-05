console.log(message);
message = message.replace(/&quot;/g, '"');
console.log(message);
var queTable = document.getElementById("questionTab");
var testTitle = document.getElementById("testTitle");
var obj = JSON.parse(message);
console.log("PP " + " FF " + obj.totalQuestions + " "
		+ obj.questionListWithAnswers[0].question);
// queTable.innerHTML = "<table border='1'>";
testTitle.innerHTML = obj.testTitle;
var i;
for (i = 0; i < obj.totalQuestions; i++) {
	queTable.innerHTML = queTable.innerHTML
			+ "<tr style='margin-top:100px'><td style='width:1%'><b>"
			+ (i + 1)
			+ ").</b></td><td colspan='3'><b>"
			+ obj.questionListWithAnswers[i].question
			+ "</b></td></tr><tr><td style='width:1%'><input type='radio' name='"
			+ obj.questionListWithAnswers[i].qId + "' value='A'></td><td>"
			+ obj.questionListWithAnswers[i].optionA
			+ "</td><td style='width:1%'><input type='radio' name='"
			+ obj.questionListWithAnswers[i].qId + "' value='B'></td><td>"
			+ obj.questionListWithAnswers[i].optionB
			+ "</td></tr><tr><td style='width:1%'><input type='radio' name='"
			+ obj.questionListWithAnswers[i].qId + "' value='C'></td><td>"
			+ obj.questionListWithAnswers[i].optionC
			+ "</td><td style='width:1%'><input type='radio' name='"
			+ obj.questionListWithAnswers[i].qId + "' value='D'></td><td>"
			+ obj.questionListWithAnswers[i].optionD + "</td></tr>";
}
// queTable.innerHTML=queTable.innerHTML+ "</table>";
