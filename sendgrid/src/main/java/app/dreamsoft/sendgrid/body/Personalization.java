package app.dreamsoft.sendgrid.body;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Personalization {
    private List<Participant> to = new ArrayList<>();
    private List<Participant> cc = new ArrayList<>();
    private List<Participant> bcc = new ArrayList<>();
    private String subject;

    JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        if (!to.isEmpty())
            jsonObject.put("to", buildParticipants(to));
        if (!cc.isEmpty())
            jsonObject.put("cc", buildParticipants(cc));
        if (!bcc.isEmpty())
            jsonObject.put("bcc", buildParticipants(bcc));
        if (subject != null)
            jsonObject.put("subject", subject);
        return jsonObject;
    }

    private JSONArray buildParticipants(List<Participant> participants) throws JSONException {
        JSONArray participantsArray = new JSONArray();
        for (Participant participant : participants) {
            participantsArray.put(participant.toJsonObject());
        }
        return participantsArray;
    }

    void setTo(List<Participant> to) {
        this.to = to;
    }

    void setCc(List<Participant> cc) {
        this.cc = cc;
    }

    void setBcc(List<Participant> bcc) {
        this.bcc = bcc;
    }

    void setSubject(String subject) {
        this.subject = subject;
    }
}