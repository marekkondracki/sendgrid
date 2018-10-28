package app.dreamsoft.sendgrid.body;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailBodyBuilder {
    private EmailData emailData;

    public EmailBodyBuilder(EmailData emailData) {
        this.emailData = emailData;
    }

    public String makeBody() {
        JSONObject body = new JSONObject();
        try {
            body.put("personalizations", buildPersonalizations());
            body.put("from", emailData.getSender().toJsonObject());
            body.put("content", buildContent());
            if (!emailData.getAttachments().isEmpty())
                body.put("attachments", buildAttachments());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return body.toString();
    }

    private JSONArray buildPersonalizations() throws JSONException {
        JSONArray personalizationsArray = new JSONArray();
        for (Personalization personalization : emailData.getPersonalizations()) {
            personalizationsArray.put(personalization.getJsonObject());
        }
        return personalizationsArray;
    }

    private JSONArray buildContent() throws JSONException {
        JSONArray contentsArray = new JSONArray();
        for (Content content : emailData.getContent()) {
            contentsArray.put(content.toJsonObject());
        }
        return contentsArray;
    }

    private JSONArray buildAttachments() throws JSONException {
        JSONArray attachmentsArray = new JSONArray();
        for (Attachment attachment : emailData.getAttachments()) {
            attachmentsArray.put(attachment.toJsonObject());
        }
        return attachmentsArray;
    }
}
