package app.dreamsoft.sendgrid.body;

import org.json.JSONException;
import org.json.JSONObject;

public class Participant {
    private String name;
    private String email;

    Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    JSONObject toJsonObject() throws JSONException {
        JSONObject participant = new JSONObject();
        participant.put("name", name);
        participant.put("email", email);
        return participant;
    }
}