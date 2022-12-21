package api.tests;

import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.*;

public class CompanySearch {
    @Test
    public void SearchForCompany() {
       List<List<Object>> params =  Arrays.asList(Arrays.asList("searchQuery","staffers"));

        DriverFactory.getAPIDriver("https://staffers-985f5.uc.r.appspot.com/")
                .buildNewRequest("company/search/", RestActions.RequestType.GET)
                .setTargetStatusCode(200)
                .setParameters(params, RestActions.ParametersType.QUERY)
                .performRequest();
    }

}
