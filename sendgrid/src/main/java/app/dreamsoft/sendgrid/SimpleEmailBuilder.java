package app.dreamsoft.sendgrid;

import app.dreamsoft.sendgrid.body.Attachment;
import app.dreamsoft.sendgrid.body.Content;
import app.dreamsoft.sendgrid.body.EmailData;
import app.dreamsoft.sendgrid.body.EmailDataBuilder;
import app.dreamsoft.sendgrid.body.EmailBodyBuilder;
import app.dreamsoft.sendgrid.body.Personalization;
import app.dreamsoft.sendgrid.body.PersonalizationBuilder;
import app.dreamsoft.sendgrid.body.Recipient;
import app.dreamsoft.sendgrid.body.Sender;

public class SimpleEmailBuilder {

    private Sender from;
    private Recipient to;
    private Content content;
    private Attachment attachment;
    private String subject;

    public SimpleEmailBuilder from(Sender from) {
        this.from = from;
        return this;
    }

    public SimpleEmailBuilder to(Recipient to) {
        this.to = to;
        return this;
    }

    public SimpleEmailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public SimpleEmailBuilder content(Content content) {
        this.content = content;
        return this;
    }

    public SimpleEmailBuilder attachment(Attachment attachment) {
        this.attachment = attachment;
        return this;
    }

    public String makeBody() {
        EmailDataBuilder builder = new EmailDataBuilder();

        Personalization personalization = new PersonalizationBuilder()
                .addTo(to)
                .setSubject(subject)
                .build();

        if (attachment != null)
            builder.addAttachment(attachment);

        builder.setSender(from)
                .addPersonalization(personalization)
                .addContent(content);

        EmailBodyBuilder bodyBuilder = new EmailBodyBuilder(builder.build());
        return bodyBuilder.makeBody();
    }
}
