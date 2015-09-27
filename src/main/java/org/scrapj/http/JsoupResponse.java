package org.scrapj.http;

import org.jsoup.nodes.Document;
import org.scrapj.parse.JsoupSelection;
import org.scrapj.parse.Selection;

public class JsoupResponse implements Response {

    private Document document;

    public JsoupResponse(Document document) {
        this.document = document;
    }

    @Override
    public Selection css(String selector) {
        return JsoupSelection.create(this.document, selector);
    }
}
