
function runProgram() {

    let result = "";

    // 1. FOR LOOP
    console.log("----- FOR LOOP -----");
    result += "FOR LOOP:\n";

    for (let i = 1; i <= 5; i++) {
        let message = "For loop iteration " + i;
        console.log(message);
        result += message + "\n";
    }

    // 2. WHILE LOOP
    console.log("----- WHILE LOOP -----");
    result += "\nWHILE LOOP:\n";

    let j = 1;

    while (j <= 5) {
        let message = "While loop iteration " + j;
        console.log(message);
        result += message + "\n";
        j++;
    }

    // 3. DO-WHILE LOOP
    console.log("----- DO-WHILE LOOP -----");
    result += "\nDO-WHILE LOOP:\n";

    let k = 1;

    do {
        let message = "Do-while loop iteration " + k;
        console.log(message);
        result += message + "\n";
        k++;
    } while (k <= 5);

    // 4. ARITHMETIC OPERATORS
    console.log("----- ARITHMETIC OPERATORS -----");
    result += "\nARITHMETIC OPERATORS:\n";

    let a = 10;
    let b = 5;

    console.log("Addition: " + (a + b));
    console.log("Subtraction: " + (a - b));
    console.log("Multiplication: " + (a * b));
    console.log("Division: " + (a / b));
    console.log("Modulus: " + (a % b));

    result += "Addition: " + (a + b) + "\n";
    result += "Subtraction: " + (a - b) + "\n";
    result += "Multiplication: " + (a * b) + "\n";
    result += "Division: " + (a / b) + "\n";
    result += "Modulus: " + (a % b) + "\n";

    // 5. COMPARISON OPERATORS
    console.log("----- COMPARISON OPERATORS -----");
    result += "\nCOMPARISON OPERATORS:\n";

    console.log("a > b: " + (a > b));
    console.log("a < b: " + (a < b));
    console.log("a == b: " + (a == b));
    console.log("a != b: " + (a != b));

    result += "a > b: " + (a > b) + "\n";
    result += "a < b: " + (a < b) + "\n";
    result += "a == b: " + (a == b) + "\n";
    result += "a != b: " + (a != b) + "\n";

    // 6. LOGICAL OPERATORS
    console.log("----- LOGICAL OPERATORS -----");
    result += "\nLOGICAL OPERATORS:\n";

    let age = 21;

    console.log("Age >= 18 AND age <= 60: " +
        (age >= 18 && age <= 60));

    console.log("Age < 18 OR age > 60: " +
        (age < 18 || age > 60));

    console.log("NOT (age >= 18): " + !(age >= 18));

    result += "Age >= 18 AND age <= 60: " +
        (age >= 18 && age <= 60) + "\n";

    result += "Age < 18 OR age > 60: " +
        (age < 18 || age > 60) + "\n";

    result += "NOT (age >= 18): " +
        !(age >= 18) + "\n";

    // 7. IF-ELSE CONDITION
    console.log("----- IF-ELSE CONDITION -----");
    result += "\nIF-ELSE CONDITION:\n";

    let marks = 85;

    if (marks >= 90) {
        console.log("Grade: A+");
        result += "Grade: A+\n";
    } else if (marks >= 80) {
        console.log("Grade: A");
        result += "Grade: A\n";
    } else if (marks >= 70) {
        console.log("Grade: B");
        result += "Grade: B\n";
    } else {
        console.log("Grade: C");
        result += "Grade: C\n";
    }

    // 8. SWITCH CONDITION
    console.log("----- SWITCH CONDITION -----");
    result += "\nSWITCH CONDITION:\n";

    let day = 3;

    switch (day) {
        case 1:
            console.log("Sunday");
            result += "Sunday\n";
            break;

        case 2:
            console.log("Monday");
            result += "Monday\n";
            break;

        case 3:
            console.log("Tuesday");
            result += "Tuesday\n";
            break;

        default:
            console.log("Invalid day");
            result += "Invalid day\n";
    }

    document.getElementById("output").textContent = result;
}
