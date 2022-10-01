package com.restapi.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AssertionData {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
            response = given()
                    .when()
                    .get("/employees")
                    .then().statusCode(200);
    }

    //1. total records are 24
    @Test
    public void TotalRecords() {
        ArrayList<Integer> dataSize = response.extract().path("data");
        int sizes = dataSize.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : "+sizes);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. data[23].id = 24
    @Test
    public void Id() {
        response.body("data[23].id",equalTo(24));

    }

    //3. data[23].employee_name = “Doris Wilder”
    @Test
    public void Employee_Name()
    {
        response.body("data[23].employee_name",equalTo("Doris Wilder"));
    }
    //4. message = “Successfully! All records has been fetched.”
    @Test
    public void Msg()
    {
        response.body("message",equalTo("Successfully! All records has been fetched."));
    }

    //5.status = success
    @Test
    public void Status()
    {
        response.body("status",equalTo("success"));
    }
    //6. id = 3 has employee_salary = 86000
    @Test
    public void Employee_Salary()
    {
        response.body("data[2].employee_salary",equalTo(86000));
    }
    //7. id = 6 has employee_age = 61
    @Test
    public void Employee_Age()
    {
        response.body("data[5].employee_age",equalTo(61));
    }

    //8. id = 11 has employee_name = Jena Gaines
    @Test
    public void Employee_Name1()
    {
        response.body("data[10].employee_name",equalTo("Jena Gaines"));
    }
}
