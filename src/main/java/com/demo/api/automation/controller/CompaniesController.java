package com.demo.api.automation.controller;

import com.demo.api.automation.constant.ApiConstant;
import com.demo.api.automation.model.response.GetCompaniesResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.given;

public class CompaniesController implements ApiConstant {

    public GetCompaniesResponse getCompaniesByQty(int qty){
       Response response =  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .basePath(BASE_PATH)
                .queryParam("_quantity",qty)
                .get(ENDPOINT_GET_COMPANIES);
       ResponseBody responseBody = response.getBody();
       responseBody.prettyPrint();
       return responseBody.as(GetCompaniesResponse.class);
    }

    public GetCompaniesResponse getAllCompanies(){
        Response response =  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .basePath(BASE_PATH)
                .get(ENDPOINT_GET_COMPANIES);
        ResponseBody responseBody = response.getBody();
        responseBody.prettyPrint();
        return responseBody.as(GetCompaniesResponse.class);
    }

    public ResponseBody<Response> getAllCompaniesJsonSchema(){
        return given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .basePath(BASE_PATH)
                .get(ENDPOINT_GET_COMPANIES);

    }
}
