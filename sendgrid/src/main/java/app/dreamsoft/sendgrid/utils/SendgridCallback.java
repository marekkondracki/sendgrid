package app.dreamsoft.sendgrid.utils;

public interface SendgridCallback {
    void onSuccess();
    void onFailure(String error);
}
