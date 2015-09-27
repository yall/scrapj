package org.scrapj.middleware;

import org.scrapj.http.Request;
import org.scrapj.http.Response;

public interface RequestFilter {

    void filter(Request request);

}
