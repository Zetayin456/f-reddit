import CajaService from "../../../js/control/caja_service.js";
import DefaultResponse from "../../../js/entity/default_response.js";

mocha.setup("bdd");
const { expect } = chai;

describe("Integración CajaService con Jakarta REST", function () {
    this.timeout(10000);
    // Override with ?api=http://host:port/context/resources/v1/ when the
    // OpenLiberty server uses a different host, port, or context root.
    const apiUrl = new URLSearchParams(window.location.search).get("api")
            ?? "http://localhost:9080/cafeteria_pos/resources/v1/";
    const service = new CajaService(apiUrl);

    it("se instancia como servicio de cajas", function () {
        expect(service).to.be.instanceOf(CajaService);
    });

    it("lee las cajas paginadas y la cabecera total-registros", async function () {
        const response = await service.findRange(0, 10);

        expect(response).to.be.instanceOf(DefaultResponse);
        expect(response.datos).to.be.an("array");
        expect(response.datos.length).to.be.at.most(10);
        expect(Number(response.totales)).to.be.at.least(response.datos.length);
    });
});

mocha.run();
