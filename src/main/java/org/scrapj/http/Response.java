package org.scrapj.http;

import org.scrapj.parse.JsoupSelection;
import org.scrapj.parse.Selection;

public interface Response {

    public Selection css(String selector);

}
