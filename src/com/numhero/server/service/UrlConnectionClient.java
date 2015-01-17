package com.numhero.server.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionClient {
    public UrlConnectionClient() { }

    public HttpURLConnection getConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(2000);
        return connection;
    }
}
