
// Function to turn ON the bulb
function turnOn() {

    document.getElementById("bulb").classList.add("on");

    document.getElementById("status").innerHTML =
        "Bulb is ON";

}

// Function to turn OFF the bulb
function turnOff() {

    document.getElementById("bulb").classList.remove("on");

    document.getElementById("status").innerHTML =
        "Bulb is OFF";

}
