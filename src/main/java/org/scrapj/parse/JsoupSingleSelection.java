package org.scrapj.parse;

import org.jsoup.nodes.Element;

import java.util.Iterator;
import java.util.List;

public class JsoupSingleSelection extends JsoupSelection {

    private Element element;

    public JsoupSingleSelection(Element element) {
        this.element = element;
    }

    @Override
    public Selection css(String selector) {
        return new JsoupMultipleSelection(this.element.select(selector));
    }

    @Override
    public List<String> extract() {
        return null;
    }

    @Override
    public String text() {
        return this.element.text();
    }

    @Override
    public String attr(String name) {
        return this.element.attr(name);
    }

    @Override
    public Iterator<Selection> iterator() {
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public boolean isMultiple() {
        return false;
    }
}
