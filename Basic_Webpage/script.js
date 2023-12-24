function submitForm() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var message = document.getElementById('message').value;
    var gender = document.getElementById('gender').value;

    var interests = [];
    var checkboxes = document.getElementsByName('interests');
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            interests.push(checkbox.value);
        }
    });

    var result = document.getElementById('result');
    result.innerHTML = `
        <p><strong>Name:</strong> ${name}</p>
        <p><strong>Email:</strong> ${email}</p>
        <p><strong>Message:</strong> ${message}</p>
        <p><strong>Gender:</strong> ${gender}</p>
        <p><strong>Interests:</strong> ${interests.join(', ')}</p>
    `;
}
