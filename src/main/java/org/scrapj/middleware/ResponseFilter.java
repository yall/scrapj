package org.scrapj.middleware;

import org.scrapj.http.Request;
import org.scrapj.http.Response;

public interface ResponseFilter {

    void filter(Request request, Response reponse);

}
