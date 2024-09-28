document.getElementById('validationForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const unit1 = document.querySelector('#unit1').value;
    const unit2 = document.querySelector('#unit2').value;
    const value = document.querySelector('#value').value;
    const convertedValue = document.querySelector('#converted-value');

    const message = document.getElementById('message');
    
    // Clear previous results
    message.innerHTML = '';

    const messageFragment = document.createDocumentFragment('');
    
    const local = 'http://localhost'
    const port = '8080'
    let success = true

    try {
        // Fetch conversion result
        const response = await fetch(`${local}:${port}/convert/${value}/${unit1}/${unit2}/`);
        const result = await response.json();

        if (response.ok) {
            convertedValue.value = result.to.value;
            const successMessage = document.createElement('p');
            successMessage.style.color = 'green';
            successMessage.textContent = 'Conversion successful!';
            messageFragment.appendChild(successMessage);
        } else {
            const errorMessage = document.createElement('p');
            errorMessage.style.color = 'red';
            errorMessage.textContent = `${result.error}`;
            messageFragment.appendChild(errorMessage);
            success = false;
        }
    } catch (error) {
        const errorMessage = document.createElement('p');
        errorMessage.style.color = 'red';
        errorMessage.textContent = `${error.error}`;
        messageFragment.appendChild(errorMessage);
        success = false;
    }

    message.appendChild(messageFragment);
});