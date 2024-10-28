const imageInput = document.getElementById('imageInput');
const image = document.getElementById('image');
const message = document.getElementById('message');

// Load the image when the file input changes
imageInput.addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            image.src = e.target.result;
            image.style.display = 'block';
        };
        reader.readAsDataURL(file);
    }
});

// Show message on mouseover and track mouse movement
image.addEventListener('mouseover', (event) => {
    message.style.display = 'block';
    message.style.left = `${event.pageX}px`;
    message.style.top = `${event.pageY}px`;
    message.textContent = 'You are hovering over the image!';
});

image.addEventListener('mousemove', (event) => {
    message.style.left = `${event.pageX}px`;
    message.style.top = `${event.pageY}px`;
});

// Hide the message on mouseout
image.addEventListener('mouseout', () => {
    message.style.display = 'none';
});

// Show coordinates when clicking on the message
message.addEventListener('click', (event) => {
    const x = event.clientX;
    const y = event.clientY;
    alert(`Mouse Coordinates: X: ${x}, Y: ${y}`);
});
