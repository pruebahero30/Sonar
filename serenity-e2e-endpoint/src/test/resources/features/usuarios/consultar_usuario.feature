
Feature: Consulta de usuario por ID
  Scenario: Consultar un usuario existente
    Given que el servicio de usuarios está disponible
    When consulto el usuario con id 2
    Then el código de respuesta es 200
    And el email del usuario es "janet.weaver@reqres.in"
