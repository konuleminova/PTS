package crocusoft.android.myapp.pts.network.responses;

/**
 * Created by Asus on 1/16/2018.
 */

public class Template {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FormInputs[] getFormInputs() {
        return formInputs;
    }

    public void setFormInputs(FormInputs[] formInputs) {
        this.formInputs = formInputs;
    }

    private FormInputs[] formInputs;
}
