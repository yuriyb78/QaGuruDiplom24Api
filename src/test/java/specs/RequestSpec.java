package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class RequestSpec {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification successfulResponseCode200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification errorResponseCode404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(STATUS)
            .log(BODY)
            .build();
}
