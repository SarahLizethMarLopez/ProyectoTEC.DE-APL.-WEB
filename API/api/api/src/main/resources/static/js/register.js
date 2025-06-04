
    function generateCaptcha() {
    const characters = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789';
    let captcha = '';
    for (let i = 0; i < 6; i++) {
    captcha += characters.charAt(Math.floor(Math.random() * characters.length));
}
    document.getElementById('captchaText').innerText = captcha;
}

    // Generar uno al cargar la página
    window.onload = generateCaptcha;
