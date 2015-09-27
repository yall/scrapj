package org.scrapj.parse;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;
import java.util.List;

public class JsoupMultipleSelection extends JsoupSelection {

    private final Elements elements;

    public JsoupMultipleSelection(Elements elements) {
        this.elements = elements;
    }

    @Override
    public Selection css(String selector) {
        return new JsoupMultipleSelection(this.elements.select(selector));
    }

    @Override
    public List<String> extract() {
        return null;
    }

    @Override
    public String text() {
        return this.elements.text();
    }

    @Override
    public String attr(String name) {
        return this.elements.attr(name);
    }

    @Override
    public Iterator<Selection> iterator() {
       return new ElementsToSelectionIterator(this.elements);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public boolean isMultiple() {
        return true;
    }


    private static class ElementsToSelectionIterator implements Iterator<Selection> {

        private Iterator<Element> elementIterator;

        private ElementsToSelectionIterator(Elements elements) {
            this.elementIterator = elements.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.elementIterator.hasNext();
        }

        @Override
        public Selection next() {
            return new JsoupSingleSelection(this.elementIterator.next());
        }
    }

}
