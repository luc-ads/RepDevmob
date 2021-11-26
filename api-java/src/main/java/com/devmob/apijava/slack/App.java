package com.devmob.apijava.slack;

import java.io.IOException;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        JSONObject json = new JSONObject();

        json.put("text", "Bem-vindos! :sunglasses:");
        Slack.enviarMensagem(json);
    }
}
