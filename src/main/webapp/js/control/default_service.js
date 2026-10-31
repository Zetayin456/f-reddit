import DefaultError from "../entity/default_error.js";
import DefaultResponse from "../entity/default_response.js";

/** Servicio REST base. Los recursos concretos heredan findRange(). */
export default class DefaultService {
    constructor(baseUrl = new URL("resources/v1/", document.baseURI).href) {
        this.BASE_URL = baseUrl.endsWith("/") ? baseUrl : `${baseUrl}/`;
        this._URL = this.BASE_URL;
    }

    async findRange(first = 0, max = 20) {
        if (!Number.isInteger(first) || first < 0 || !Number.isInteger(max) || max < 1) {
            throw new DefaultError("La paginación requiere first ≥ 0 y max ≥ 1.");
        }

        const url = new URL(this._URL, document.baseURI);
        url.searchParams.set("first", first);
        url.searchParams.set("max", max);

        let response;
        try {
            response = await fetch(url, { method: "GET", headers: { Accept: "application/json" } });
        } catch (error) {
            throw new DefaultError("No se pudo conectar con el repositorio REST.", error);
        }

        if (!response.ok) {
            throw new DefaultError(`Error al obtener los datos: ${response.status}`, response);
        }

        try {
            const datos = await response.json();
            if (!Array.isArray(datos)) {
                throw new TypeError("La respuesta REST debe ser un arreglo JSON.");
            }
            return new DefaultResponse(datos, response.headers.get("total-registros") ?? "-1");
        } catch (error) {
            throw new DefaultError("Error al procesar los datos de respuesta.", error);
        }
    }
}
