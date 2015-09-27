package org.scrapj.context;

import org.scrapj.http.Response;

public interface Callback {

    void process(Context context, Response response);

}
