package app.dreamsoft.sendgrid.body;

import java.util.ArrayList;
import java.util.List;

public class PersonalizationBuilder {
    private List<Participant> to = new ArrayList<>();
    private List<Participant> cc = new ArrayList<>();
    private List<Participant> bcc = new ArrayList<>();
    private String subject;

    public PersonalizationBuilder addTo(Recipient to) {
        this.to.add(to);
        return this;
    }

    public PersonalizationBuilder addCc(Recipient cc) {
        this.cc.add(cc);
        return this;
    }

    public PersonalizationBuilder addBcc(Recipient bcc) {
        this.bcc.add(bcc);
        return this;
    }

    public PersonalizationBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Personalization build() {
        Personalization personalization = new Personalization();
        personalization.setBcc(bcc);
        personalization.setTo(to);
        personalization.setSubject(subject);
        personalization.setCc(cc);
        return personalization;
    }
}
