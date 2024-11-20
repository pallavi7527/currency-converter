document.getElementById('convert-button').addEventListener('click', function() {
    const amount = document.getElementById('amount').value;

    if (!amount || amount <= 0) {
        document.getElementById('result').innerText = 'Please enter a valid amount.';
        return; // Exit if input is invalid
    }

    fetch(`/convert?amount=${amount}`)
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(data => {
            document.getElementById('result').innerText = `${data.originalAmount} USD = ${data.convertedAmount.toFixed(2)} INR`;
        })
        .catch(error => {
            document.getElementById('result').innerText = 'Error in conversion. Please try again.';
            console.error('Error:', error);
        });
});