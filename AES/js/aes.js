function cifrar() {
    let cadena = document.getElementById("contenido-archivo").value;
    const clave = document.getElementById("demo1").value;

    var cifrado = CryptoJS.AES.encrypt(cadena, clave);
    var descifrado = CryptoJS.AES.decrypt(cifrado, clave);

    document.getElementById("demo32").innerHTML = cadena;
    document.getElementById("saldjp").innerHTML = cifrado;
    document.getElementById("caso").innerHTML = descifrado;
    document.getElementById("demo32").innerHTML = descifrado.toString(CryptoJS.enc.Utf8);
}

function leerArchivo(e) {
    var archivo = e.target.files[0];
    if (!archivo) {
        return;
    }

    var lector = new FileReader();
    lector.onload = function (e) {
        var contenido = e.target.result;
        mostrarContenido(contenido);
    };
    lector.readAsText(archivo);
}

function mostrarContenido(contenido) {
    var elemento = document.getElementById('contenido-archivo');
    elemento.innerHTML = contenido;
}

document.getElementById('file-input').addEventListener('change', leerArchivo, false);
function validar() {
    var cadena = document.getElementById("contenido-archivo").value;
    var clave = document.getElementById("demo1").value;
    if (cadena == "" || clave == "") {
        alert("Rellena todos los campos antes de continuar.");
    } else if (clave.length < 16 || clave.length > 256) {
        alert("La llave debe tener más de 16 y menos de 256 caracteres.");
    } else {
        cifrar();
        leerArchivo();
        descargar();
    }
}

document.getElementById('file-input').addEventListener('change', leerArchivo, false);
function validar2() {
    var cadena = document.getElementById("contenido-archivo").value;
    var clave = document.getElementById("demo1").value;
    if (cadena == "" || clave == "") {
        alert("Rellena todos los campos antes de continuar.");
    } else if (clave.length < 24 || clave.length > 256) {
        alert("La llave debe tener más de 16 y menos de 256 caracteres.");
    } else {
        cifrar();
        leerArchivo();
        descargar();
    }
}

document.getElementById('file-input').addEventListener('change', leerArchivo, false);
function validar3() {
    var cadena = document.getElementById("contenido-archivo").value;
    var clave = document.getElementById("demo1").value;
    if (cadena == "" || clave == "") {
        alert("Rellena todos los campos antes de continuar.");
    } else if (clave.length < 32 || clave.length > 256) {
        alert("La llave debe tener más de 16 y menos de 256 caracteres.");
    } else {
        cifrar();
        leerArchivo();
        descargar();
    }

}

function dfv() {
    let hj = document.getElementById("contenido-archivo").value;
    const nmbh = document.getElementById("demo1").value;
    var descifrado = CryptoJS.AES.decrypt(hj, nmbh);
    if (hj == "" || nmbh == "") {
        alert("No se eligió nungún archivo.")
    } else {
        document.getElementById("caso").innerHTML = descifrado;
        document.getElementById("saldjp").innerHTML = descifrado.toString(CryptoJS.enc.Utf8);
    }
}
