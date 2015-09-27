package org.scrapj.middleware;

import org.scrapj.http.Request;
import org.scrapj.http.Response;

public interface DataProcessor {

    void process(Object data);

    void destroy();

}
