/** Respuesta paginada que devuelve el cliente REST. */
export default class DefaultResponse {
    constructor(datos = [], totales = -1) {
        this.datos = datos;
        this.totales = totales;
    }
}
