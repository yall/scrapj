package org.scrapj.parse;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class JsoupSelection implements Selection {

    public abstract boolean isSingle();

    public abstract boolean isMultiple();

    public static JsoupSelection create(Document doc, String selector) {

        Elements elements = doc.select(selector);

        return new JsoupMultipleSelection(elements);
    }

}
