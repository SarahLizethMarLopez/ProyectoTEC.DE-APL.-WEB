let captchaCode = "";

function generateCaptcha() {
    captchaCode = Math.random().toString(36).substring(2, 8).toUpperCase();
    document.getElementById("captchaText").innerText = captchaCode;
}

document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita el envío automático

    const userCaptcha = document.getElementById("captchaInput").value.toUpperCase();

    if (userCaptcha !== captchaCode) {
        alert("Captcha incorrecto. Inténtalo de nuevo.");
        generateCaptcha();
    } else {
        // Redirigir a la pagina de menu después de un login exitoso
        window.location.href = "Menu.html";
    }
});

// Generar captcha al cargar la página
generateCaptcha();