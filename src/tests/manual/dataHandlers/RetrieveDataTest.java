package manual.dataHandlers;

import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.RetrieveData;
import capstone.mobile.models.Line;

import org.junit.Rule;
import org.junit.Test;

import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RetrieveDataTest {

    @Rule
    public MockServerRule mockServerRule = new MockServerRule(this, 9000);

    private MockServerClient mockServerClient;

    // TODO: mock server isn't working - org.junit.ComparisonFailure:   Expected: Gorge   Actual: EmptyLine

//    @Test
//    public void fetchLinesListTest() throws Exception {
//        String body = "{\"result\": [{\"animal3\": 4, \"name\": \"Gorge\", \"animal1\": 3, \"animal2\": 2, \"id\": 1}]}";
//
//        mockServerClient.when(HttpRequest.request("/api/line")).respond(HttpResponse.response()
//                .withStatusCode(200)
//                .withBody(body));
//
//        List<Line> lines = RetrieveData.fetchLinesList();
//        Line line = lines.get(0);
//
//        assertEquals("Gorge", line.getName());
//        assertEquals(1, line.getId());
//        assertEquals(3, line.getAnimal1());
//        assertEquals(2, line.getAnimal2());
//        assertEquals(4, line.getAnimal3());
//    }

    // TODO: mock server isn't working, so exception not thrown - java.lang.AssertionError: Expected exception: capstone.mobile.dataHandlers.DataUnavailableException

//    @Test(expected = DataUnavailableException.class)
//    public void fetchLinesListNoKeyPresentTest() throws Exception {
//        String body = "{\"invalid\":[]}";
//
//        mockServerClient.when(HttpRequest.request("/api/line")).respond(HttpResponse.response()
//                .withStatusCode(200)
//                .withBody(body));
//
//        RetrieveData.fetchLinesList();
//    }

    @Test
    public void fetchTrapsListTest() {
//        String body = "{\"result\": [" +
//                "{\"latitude\": -37.801914, \"longitude\": 175.998381, \"id\": 3, \"side\": false, \"moved\": false, \"broken\": false, \"number\": 1, \"lineId\": 2}," +
//                "{\"latitude\": -37.799744, \"longitude\": 175.997491, \"id\": 6, \"side\": false, \"moved\": false, \"broken\": false, \"number\": 2, \"lineId\": 2}" +
//                "]}";
    }
}
