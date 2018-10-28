package app.dreamsoft.sendgrid;

import java.io.IOException;

import app.dreamsoft.sendgrid.utils.SendgridCallback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SendGrid {

    private OkHttpClient httpClient;

    public SendGrid() {
        httpClient = new OkHttpClient.Builder().build();
    }

    public void sendAsync(final String body, final String endpoint, final SendgridCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = send(body, endpoint);
                    if (response.code() == 202)
                        callback.onSuccess();
                    else
                        callback.onFailure(getResponse(response.body()));
                } catch (IOException e) {
                    e.printStackTrace();
                    callback.onFailure(getMessage(e));
                }
            }
        }).start();
    }

    private String getResponse(ResponseBody response) throws IOException {
        if (response != null)
            return response.string();
        return null;
    }

    private String getMessage(Exception e) {
        if (e != null)
            return e.getMessage();
        return null;
    }

    // todo: endpont -> mail/send
    public Response send(String body, String endpoint) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
        Request request = new Request.Builder()
                .url(SendgridConfig.HOST + "/" + SendgridConfig.API_VERSION + "/" + endpoint)
                .addHeader("Authorization", "Bearer " + SendgridConfig.API_KEY)
                .addHeader("User-agent", SendgridConfig.USER_AGENT)
                .addHeader("Accept", SendgridConfig.APPLICATION_JSON)
                .post(requestBody)
                .build();
        return httpClient.newCall(request).execute();
    }
}
