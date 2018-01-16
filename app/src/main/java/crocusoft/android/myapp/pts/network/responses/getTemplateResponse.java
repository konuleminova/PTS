package crocusoft.android.myapp.pts.network.responses;

/**
 * Created by Asus on 1/16/2018.
 */

public class getTemplateResponse {
MessageClass message;
Template template;

    public MessageClass getMessage() {
        return message;
    }

    public void setMessage(MessageClass message) {
        this.message = message;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
