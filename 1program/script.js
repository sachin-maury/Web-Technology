// Function to handle color button clicks
function color(color) {
    const messageElement = document.getElementById('message');
    messageElement.textContent = `You chose the color: ${color}`;
    document.body.style.backgroundColor = `${color}`; // Green
}

// Assign event handlers to buttons
document.getElementById('red').onclick = function() { color('Red'); };
document.getElementById('blue').onclick = function() { color('Blue'); };
document.getElementById('yellow').onclick = function() { color('Yellow'); };
document.getElementById('green').onclick = function() { color('Green'); };
document.getElementById('orange').onclick = function() { color('Orange'); };
