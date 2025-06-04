document.addEventListener("DOMContentLoaded", () => {
    const navLinks = document.querySelectorAll("#mainNav .nav-link");

    // Marcar el enlace activo según la URL actual
    const currentPath = window.location.pathname;
    navLinks.forEach(link => {
        if (link.getAttribute("href") === currentPath) {
            link.classList.add("active");
        } else {
            link.classList.remove("active");
        }
    });

    // Redireccionar al hacer clic en el logo o nombre
    const homeLink = document.getElementById("homeLink");
    if (homeLink) {
        homeLink.addEventListener("click", (e) => {
            e.preventDefault();
            window.location.href = "/";
        });
    }
});
