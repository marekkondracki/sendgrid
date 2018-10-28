package app.dreamsoft.sendgrid;

import org.junit.Test;

import app.dreamsoft.sendgrid.body.Attachment;
import app.dreamsoft.sendgrid.body.Content;
import app.dreamsoft.sendgrid.body.EmailBodyBuilder;
import app.dreamsoft.sendgrid.body.EmailData;
import app.dreamsoft.sendgrid.body.EmailDataBuilder;
import app.dreamsoft.sendgrid.body.Personalization;
import app.dreamsoft.sendgrid.body.PersonalizationBuilder;
import app.dreamsoft.sendgrid.body.Recipient;
import app.dreamsoft.sendgrid.body.Sender;

public class EmailBodyBuilderTest {

    @Test
    public void testRecipients() {
        Personalization personalization = new PersonalizationBuilder()
                .addTo(new Recipient("Test Recipient", "recipient@test.pl"))
                .setSubject("test_subject")
                .build();
        EmailData emailData = new EmailDataBuilder()
                .setSender(new Sender("Test Sender", "sender@test.pl"))
                .addPersonalization(personalization)
                .addContent(new Content("text/html", "Hello World!"))
                .addAttachment(new Attachment("test.json", "SGVsbG8gV29ybGQh"))
                .build();
        EmailBodyBuilder emailBodyBuilder = new EmailBodyBuilder(emailData);
        String result = emailBodyBuilder.makeBody();
        System.out.println(result);
    }

    @Test
    public void testSimple() {
        String data = new SimpleEmailBuilder()
                .from(new Sender("Test Sender", "sender@test.pl"))
                .to(new Recipient("Test Recipient", "recipient@test.pl"))
                .content(new Content("text/plain", "Hello World!"))
                .makeBody();
        System.out.println(data);
    }
}