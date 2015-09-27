package org.scrapj.middleware;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.scrapj.http.JsoupResponse;
import org.scrapj.http.Request;
import org.scrapj.http.Response;

import java.io.IOException;
import java.util.Map;

public class JsoupRequestProcessor implements RequestProcessor {

    @Override
    public Response process(Request request) throws IOException {

        Document document = null;

        Connection connection = Jsoup.connect(request.getUrl());

        System.out.println("Process request");

        switch (request.getMethod()) {
            case GET:  document = getRequest(request, connection); break;
            case POST: document = postRequest(request, connection); break;
            default: throw new IllegalArgumentException("Method " + request.getMethod() + " unsupported yet");
        }

        System.out.println("Got response");

        return new JsoupResponse(document);
    }

    private Document getRequest(Request request, Connection connection) throws IOException {
        copyHeaders(request, connection);
        return connection.get();
    }

    private Document postRequest(Request request, Connection connection) {
        return null;
    }

    private void copyHeaders(Request request, Connection connection) {
        for (Map.Entry<String, String> header : request.getHeaders().entrySet()) {
            connection.header(header.getKey(), header.getValue());
        }
    }


}
