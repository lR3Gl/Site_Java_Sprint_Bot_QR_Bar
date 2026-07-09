async function generarQr() {
    const texto = document.getElementById('texto').value;
    const response = await fetch('/generarQr', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: 'texto=' + encodeURIComponent(texto)
    });

    if (response.ok) {
        const blob = await response.blob();
        document.getElementById('imgQr').src = URL.createObjectURL(blob);
    } else {
        alert('❌ Error al generar el QR');
    }
}

async function generarBarra() {
    const texto = document.getElementById('texto').value;
    const response = await fetch('/generarBarra', {
        method: 'POST',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: 'texto=' + encodeURIComponent(texto)
    });

    if (response.ok) {
        const blob = await response.blob();
        document.getElementById('imgBarra').src = URL.createObjectURL(blob);
    } else {
        alert('❌ Error al generar la Barra');
    }
}
