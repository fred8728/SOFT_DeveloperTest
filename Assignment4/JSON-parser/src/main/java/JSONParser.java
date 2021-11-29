import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class JSONParser {


    public Object getSingleValueFromJson(JSONObject obj, String key) throws CustomJsonException {
        if (obj.isEmpty()){
            throw new CustomJsonException("JsonObject is empty");
        } else if (obj.get(key).equals(JSONObject.NULL)){
            return null;
        }
        return obj.get(key);
    }

    public Map<String, Object> getAllValuesFromJson(JSONObject obj) {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<?> keys = obj.keys();
        while(keys.hasNext()){
            String key = (String) keys.next();
            var value = obj.get(key);
            map.put(key,value);
        }
        return map;
    }

    public List<Object> getValuesFromArray(JSONObject obj, String contact) {
        JSONArray arr = obj.getJSONArray(contact);
        List <Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            list.add(arr.get(i));
        }
        return list;
    }
}
