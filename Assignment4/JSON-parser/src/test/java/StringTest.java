import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StringTest {

    private static JSONParser parser;

    @BeforeAll
    public static void setup() {
        parser = new JSONParser();
    }

    @Test
    public void mustThrowExceptionIfJsonObjectIsEmpty(){
        JSONObject obj = new JSONObject();

        CustomJsonException exception = Assertions.assertThrows(CustomJsonException.class, () -> {
            var singleValue = parser.getSingleValueFromJson(obj, "name");
        });
        Assertions.assertEquals("JsonObject is empty", exception.getMessage());
    }

    @Test
    public void mustParseIfValueInJsonIsNull() throws CustomJsonException {
        JSONObject obj = new JSONObject();
        obj.put("lesson", "Test");
        obj.put("grade", JSONObject.NULL);

        var singleValue = parser.getSingleValueFromJson(obj,"grade");
        Assertions.assertEquals(null, singleValue);
    }

    @Test
    public void mustGetSingleValueFromJson() throws CustomJsonException {
        JSONObject obj = new JSONObject();
        obj.put("name", "Frederikke");
        obj.put("birthyear", 1995);
        obj.put("hobby", "Fitness");

        var singleValue = parser.getSingleValueFromJson(obj, "name");
        Assertions.assertEquals("Frederikke", singleValue);
    }

    @Test
    public void mustGetArrayValuesFromKey() throws CustomJsonException {
        JSONArray contactInformation = new JSONArray();
        contactInformation.put(0, "Frederikke");
        contactInformation.put(1, 12345679);

        JSONObject obj = new JSONObject();
        obj.put("id", 1000);
        obj.put("name", "Carla");
        obj.put("type", "Golden retriever");
        obj.put("weight", 30);
        obj.put("contact", contactInformation);

        var values = parser.getValuesFromArray(obj,"contact");

        List<Object> expected = new ArrayList<>();
        expected.add("Frederikke");
        expected.add(12345679);

        //Testing size
        Assertions.assertEquals(expected.size(), values.size());

        //Testing actual list matches expected list
        Assertions.assertEquals(expected, values);
    }

    @Test
    public void mustParseAllValuesFromJson(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Frederikke");
        obj.put("birthyear", 1995);
        obj.put("hobby", "Fitness");

        Map<String,Object> parsedValues = parser.getAllValuesFromJson(obj);

        HashMap <String, Object> expected = new HashMap<>();
        expected.put("name", "Frederikke");
        expected.put("birthyear", 1995);
        expected.put("hobby", "Fitness");

        //Testing size
        Assertions.assertEquals(expected.size(), parsedValues.size());

        //Testing actual hashmap matches expected
        for (Map.Entry<String, Object> entry : parsedValues.entrySet()){
            Assertions.assertEquals(expected.get(entry.getKey()), parsedValues.get(entry.getKey()));
            Assertions.assertEquals(expected.get(entry.getValue()), parsedValues.get(entry.getValue()));
        }
    }
}
