// Get elements
const imageInput = document.getElementById('imageInput');
const image = document.getElementById('image');
const message = document.getElementById('message');

// Function to load image
imageInput.addEventListener('change', (event) => {
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

// Mouseover event for the image
image.addEventListener('mouseover', () => {
    message.textContent = "Mouse is over the image!";
    message.style.display = 'block';
});

// Mouseout event to hide the message
image.addEventListener('mouseout', () => {
    message.style.display = 'none';
});

// Click event for the message to display coordinates
message.addEventListener('click', (event) => {
    const rect = message.getBoundingClientRect();
    const x = event.clientX - rect.left;
    const y = event.clientY - rect.top;
    alert(`Mouse clicked at coordinates: (${x}, ${y})`);
});

// Position the message
image.addEventListener('mousemove', (event) => {
    const x = event.clientX;
    const y = event.clientY;
    message.style.left = `${x}px`;
    message.style.top = `${y}px`;
});
