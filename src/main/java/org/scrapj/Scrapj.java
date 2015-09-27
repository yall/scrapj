package org.scrapj;

import org.scrapj.context.Callback;
import org.scrapj.context.Context;
import org.scrapj.context.ContextBuilder;
import org.scrapj.http.Method;
import org.scrapj.http.Request;
import org.scrapj.http.RequestBuilder;
import org.scrapj.http.Response;
import org.scrapj.middleware.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scrapj {

    private static Queue<Request> requestQueue = new LinkedBlockingQueue<>();

    private static ContextBuilder contextBuilder = ContextBuilder.create();

    private static RequestProcessor requestProcessor = new JsoupRequestProcessor();

    public static void start(String url, Callback callback) {
        Request request = RequestBuilder.create()
                .url(url)
                .method(Method.GET)
                .header("User-Agent", "scrapj")
                .callback(callback)
                .build();
        start(request);
    }

    public static void start(Request request) {
        start(Arrays.asList(request));
    }

    public static void start(Collection<Request> requests) {
        requestQueue.addAll(requests);
        run();
    }

    public static void processData(DataProcessor dataProcessor) {
        contextBuilder.addDataProcessor(dataProcessor);
    }

    public static void before(RequestFilter requestFilter) {
        // TODO
        throw new RuntimeException("Not implemented yet.");
    }

    public static void after(ResponseFilter responseFilter) {
        // TODO
        throw new RuntimeException("Not implemented yet.");
    }


    private static void run() {
        Request request;
        while ((request = requestQueue.poll()) != null) {
            processRequest(request);
        }
    }

    private static void processRequest(Request request) {
        try {
            Response response = requestProcessor.process(request);
            Context context = contextBuilder.build(request);
            request.getCallback().process(context, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
