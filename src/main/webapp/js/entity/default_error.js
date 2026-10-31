/** Estructura común para errores de red, HTTP y formato. */
export default class DefaultError {
    constructor(mensaje = "", error = null) {
        this.mensaje = mensaje;
        this.error = error;
    }
}
