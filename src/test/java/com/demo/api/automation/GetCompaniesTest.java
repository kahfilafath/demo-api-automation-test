package com.demo.api.automation;

import com.demo.api.automation.controller.CompaniesController;
import com.demo.api.automation.model.response.GetCompaniesResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class GetCompaniesTest {

    CompaniesController companiesController = new CompaniesController();

    @ParameterizedTest(name = "Verify getCompanies API should return the correct value:{index}")
    @ValueSource(ints = {20,5,1})
    @Tag(value = "smoke-test")
    @Tag(value = "TC0001")
    public void verifyGetCompaniesReturnTheCorrectValues(int totalData){
        GetCompaniesResponse getCompaniesResponse = companiesController.getCompaniesByQty(totalData);
        Assertions.assertEquals(200,getCompaniesResponse.getCode());
        Assertions.assertEquals(totalData,getCompaniesResponse.getTotal());
    }

    @Test
    @Tag(value = "TC0002")
    @DisplayName("Verify getCompanies by Id should not return null value")
    public void verifyGetCompaniesIdShouldNotReturnNullValue(){
        GetCompaniesResponse getCompaniesResponse = companiesController.getAllCompanies();
        for(int i=0; i< getCompaniesResponse.getData().size();i++){
            Assertions.assertNotNull(getCompaniesResponse.getData().get(i).getId(),
                    "Id should not return null value!");
        }
    }

    @Test
    @Tag(value = "smoke-test")
    @Tag(value = "TC0003")
    @DisplayName("Verify getCompanies API should return the correct Json schema")
    public void verifyGetCompaniesShouldReturnCorrectJsonSchema(){
        ResponseBody getCompaniesResponse = companiesController.getAllCompaniesJsonSchema();
        MatcherAssert.assertThat("Incorrect Json Schema!",getCompaniesResponse.prettyPrint(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema/GetCompanyJsonSchema.json"));

    }
}
