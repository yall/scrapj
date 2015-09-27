package org.scrapj.context;

import org.scrapj.http.Request;

public interface Context {

    Request getRequest();

    void emitRequest(Request request);

    void emitData(Object data);

}
