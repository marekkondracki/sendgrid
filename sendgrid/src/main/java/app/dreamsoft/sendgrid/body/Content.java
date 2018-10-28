package app.dreamsoft.sendgrid.body;

import org.json.JSONException;
import org.json.JSONObject;

public class Content {
    private String type;
    private String value;

    public Content(String type, String value) {
        this.type = type;
        this.value = value;
    }

    JSONObject toJsonObject() throws JSONException {
        JSONObject content = new JSONObject();
        content.put("type", type);
        content.put("value", value);
        return content;
    }
}
