import DefaultService from "./default_service.js";

export default class CajaService extends DefaultService {
    constructor(baseUrl) {
        super(baseUrl);
        this._URL = `${this.BASE_URL}cajas`;
    }
}
