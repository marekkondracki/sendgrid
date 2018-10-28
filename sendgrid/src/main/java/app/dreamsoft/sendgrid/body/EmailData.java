package app.dreamsoft.sendgrid.body;

import java.util.ArrayList;
import java.util.List;

public class EmailData {
    private List<Personalization> personalizations = new ArrayList<>();
    private List<Attachment> attachments = new ArrayList<>();
    private List<Content> content = new ArrayList<>();
    private Sender sender;

    void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    void setPersonalizations(List<Personalization> personalizations) {
        this.personalizations = personalizations;
    }

    void setContent(List<Content> content) {
        this.content = content;
    }

    void setSender(Sender sender) {
        this.sender = sender;
    }

    List<Attachment> getAttachments() {
        return attachments;
    }

    List<Content> getContent() {
        return content;
    }

    Sender getSender() {
        return sender;
    }

    List<Personalization> getPersonalizations() {
        return personalizations;
    }

}

