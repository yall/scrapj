package org.scrapj.middleware;

import org.scrapj.http.Request;
import org.scrapj.http.Response;

import java.io.IOException;

public interface RequestProcessor {

    Response process(Request request) throws IOException;

}
