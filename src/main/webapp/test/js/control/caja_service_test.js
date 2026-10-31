import CajaService from "../../../js/control/caja_service.js";
import DefaultResponse from "../../../js/entity/default_response.js";

mocha.setup("tdd");

const { expect } = chai;
const cajasPrueba = [
    { idCaja: "caja-1", nombre: "Caja principal", activo: true, observaciones: "Turno mañana" },
    { idCaja: "caja-2", nombre: "Caja terraza", activo: false, observaciones: "" }
];
const stubFetch = sinon.stub(window, "fetch").callsFake(async (input) => {
    const requestUrl = new URL(input, window.location.href);
    expect(requestUrl.searchParams.get("first")).to.equal("0");
    expect(requestUrl.searchParams.get("max")).to.equal("10");
    return new Response(JSON.stringify(cajasPrueba), {
        status: 200,
        headers: { "Content-Type": "application/json", "total-registros": "2" }
    });
});

suite("CajaService", function () {
    teardown(function () {
        stubFetch.restore();
    });

    test("findRange devuelve datos y total en una DefaultResponse", async function () {
        const service = new CajaService("http://localhost:9080/cafeteria_pos/resources/v1/");
        const response = await service.findRange(0, 10);

        expect(response).to.be.instanceOf(DefaultResponse);
        expect(response.datos).to.deep.equal(cajasPrueba);
        expect(response.totales).to.equal("2");
        expect(stubFetch.calledOnce).to.equal(true);
    });
});

mocha.run();
