// Script para hacer scroll automático cuando se enfoca en campos fuera de la vista
document.addEventListener('DOMContentLoaded', function() {
    const formContainer = document.querySelector('.form-section');
    const formInputs = document.querySelectorAll('input, select');

    formInputs.forEach(input => {
        input.addEventListener('focus', function() {
            const inputRect = this.getBoundingClientRect();
            const containerRect = formContainer.getBoundingClientRect();

            // Si el elemento está parcialmente fuera de la vista del contenedor
            if (inputRect.bottom > containerRect.bottom || inputRect.top < containerRect.top) {
                // Desplaza el scroll para centrar el elemento en el contenedor
                this.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        });
    });
});