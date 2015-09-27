package org.scrapj.parse;

import java.util.List;

public interface Selection extends Iterable<Selection> {

    Selection css(String selector);

    List<String> extract();

    String text();

    String attr(String name);

}
