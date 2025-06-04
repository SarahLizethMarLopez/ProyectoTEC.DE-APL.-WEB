document.addEventListener('DOMContentLoaded', () => {
    document
        .querySelectorAll('button[data-bs-toggle="collapse"]')
        .forEach(btn => {
            const targetSelector = btn.getAttribute('data-bs-target');
            const collapseEl = document.querySelector(targetSelector);

            if (!collapseEl) return;

            collapseEl.addEventListener('shown.bs.collapse', () => {
                btn.querySelector('.when-collapsed')?.classList.add('d-none');
                btn.querySelector('.when-expanded')?.classList.remove('d-none');
            });

            collapseEl.addEventListener('hidden.bs.collapse', () => {
                btn.querySelector('.when-collapsed')?.classList.remove('d-none');
                btn.querySelector('.when-expanded')?.classList.add('d-none');
            });
        });
});
