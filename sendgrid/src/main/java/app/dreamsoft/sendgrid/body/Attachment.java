package app.dreamsoft.sendgrid.body;

import org.json.JSONException;
import org.json.JSONObject;

public class Attachment {
    private String base64content;
    private String type;
    private String filename;
    private String disposition;
    private String contentId;

    public Attachment(String filename, String base64content) {
        this.filename = filename;
        this.base64content = base64content;
    }

    public Attachment(String base64content, String type, String filename) {
        this.base64content = base64content;
        this.type = type;
        this.filename = filename;
    }

    public Attachment(String base64content, String type, String filename, String disposition, String contentId) {
        this.base64content = base64content;
        this.type = type;
        this.filename = filename;
        this.disposition = disposition;
        this.contentId = contentId;
    }

    JSONObject toJsonObject() throws JSONException {
        JSONObject attachment = new JSONObject();
        if (base64content != null)
            attachment.put("content", base64content);
        if (type != null)
            attachment.put("type", type);
        if (filename != null)
            attachment.put("filename", filename);
        if (disposition != null)
            attachment.put("disposition", disposition);
        if (contentId != null)
            attachment.put("content_id", contentId);
        if (contentId != null)
            return attachment;
        return attachment;
    }

}