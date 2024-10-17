// Function to handle color button clicks
function colorButtonHandler(color) {
    const messageElement = document.getElementById('message');
    messageElement.textContent = `You chose the color: ${color}`;
}

// Assign event handlers to buttons
document.getElementById('red').onclick = function() { colorButtonHandler('Red'); };
document.getElementById('blue').onclick = function() { colorButtonHandler('Blue'); };
document.getElementById('yellow').onclick = function() { colorButtonHandler('Yellow'); };
document.getElementById('green').onclick = function() { colorButtonHandler('Green'); };
document.getElementById('orange').onclick = function() { colorButtonHandler('Orange'); };
