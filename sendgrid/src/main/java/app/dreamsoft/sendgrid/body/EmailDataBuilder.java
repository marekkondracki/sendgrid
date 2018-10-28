package app.dreamsoft.sendgrid.body;

import java.util.ArrayList;
import java.util.List;

public class EmailDataBuilder {
    private List<Attachment> attachments = new ArrayList<>();
    private List<Content> content = new ArrayList<>();
    private List<Personalization> personalizations = new ArrayList<>();
    private Sender sender;


    public EmailDataBuilder addAttachment(Attachment attachment) {
        attachments.add(attachment);
        return this;
    }

    public EmailDataBuilder addContent(Content content) {
        this.content.add(content);
        return this;
    }

    public EmailDataBuilder setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public EmailData build() {
        EmailData emailData = new EmailData();
        emailData.setAttachments(attachments);
        emailData.setSender(sender);
        emailData.setContent(content);
        emailData.setPersonalizations(personalizations);
        return emailData;
    }

    public EmailDataBuilder addPersonalization(Personalization personalization) {
        personalizations.add(personalization);
        return this;
    }
}
