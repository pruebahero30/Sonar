
package com.ejemplo.steps;

import com.ejemplo.model.UsuarioResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsultarUsuarioSteps {

    private Response response;

    @Given("que el servicio de usuarios está disponible")
    public void queElServicioDeUsuariosEstaDisponible() {}

    @When("consulto el usuario con id {int}")
    public void consultoElUsuarioConId(Integer id) {
        response = SerenityRest
                .given()
                    .baseUri("https://reqres.in")
                    .basePath("/api/users/{id}")
                    .pathParam("id", id)
                .when()
                    .get();
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("el email del usuario es {string}")
    public void elEmailDelUsuarioEs(String emailEsperado) {
        UsuarioResponse usuario =
                response.jsonPath().getObject("data", UsuarioResponse.class);

        assertThat(usuario.getEmail()).isEqualTo(emailEsperado);
    }
}
