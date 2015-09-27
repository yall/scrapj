package org.scrapj.context;

import org.scrapj.http.Response;

public class DummyCallback implements Callback {

    private DummyCallback() {}

    public static final DummyCallback INSTANCE = new DummyCallback();

    @Override
    public void process(Context context, Response response) {
        // Nothing to do
    }
}
