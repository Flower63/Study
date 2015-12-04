package json;

//import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Flower
 *
 * on 12/4/2015.
 */
public class Runner {
    public static void main(String[] args) throws ParseException {
        JSONObject jObj = new JSONObject();
        jObj.put("name", "first name");
        jObj.put("id", 100500);

        JSONObject subObj = new JSONObject();
        subObj.put("subName", "subValue");
        jObj.put("sub", subObj);

        System.out.println(jObj);

        String str = jObj.toJSONString();

        JSONParser parser = new JSONParser();
        JSONObject newObject = (JSONObject) parser.parse(str);
        System.out.println(newObject.get("name"));
        System.out.println(newObject.get("id"));

        JSONObject object = (JSONObject) newObject.get("sub");

        System.out.println(object);
    }
}
