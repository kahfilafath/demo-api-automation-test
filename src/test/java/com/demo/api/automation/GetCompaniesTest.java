package com.demo.api.automation;

import com.demo.api.automation.controller.CompaniesController;
import com.demo.api.automation.model.response.GetCompaniesResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class GetCompaniesTest {

    CompaniesController companiesController = new CompaniesController();

    @Test
    public void verifyGetCompaniesReturn20Values(){
        GetCompaniesResponse getCompaniesResponse = companiesController.getCompaniesByQty(20);
        Assertions.assertEquals(200,getCompaniesResponse.getCode());
        Assertions.assertEquals(20,getCompaniesResponse.getTotal());
    }

    @Test
    public void verifyGetCompaniesReturn5Values(){
        GetCompaniesResponse getCompaniesResponse = companiesController.getCompaniesByQty(5);
        Assertions.assertEquals(200,getCompaniesResponse.getCode());
        Assertions.assertEquals(5,getCompaniesResponse.getTotal());
    }

    @Test
    public void verifyGetCompaniesReturn1Values(){
        GetCompaniesResponse getCompaniesResponse = companiesController.getCompaniesByQty(1);
        Assertions.assertEquals(200,getCompaniesResponse.getCode());
        Assertions.assertEquals(1,getCompaniesResponse.getTotal());
    }

    @Test
    public void verifyGetCompaniesIdShouldNotReturnNullValue(){
        GetCompaniesResponse getCompaniesResponse = companiesController.getAllCompanies();
        for(int i=0; i< getCompaniesResponse.getData().size();i++){
            Assertions.assertNotNull(getCompaniesResponse.getData().get(i).getId(),
                    "Id should not return null value!");
        }
    }

    @Test
    public void verifyGetCompaniesShouldReturnCorrectJsonSchema(){
        ResponseBody getCompaniesResponse = companiesController.getAllCompaniesJsonSchema();
        MatcherAssert.assertThat("Incorrect Json Schema!",getCompaniesResponse.prettyPrint(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema/GetCompanyJsonSchema.json"));

    }
}
