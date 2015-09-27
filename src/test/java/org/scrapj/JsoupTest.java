package org.scrapj;

import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsoupTest {

    private static String HTML = "<html><ul><li>a</li><li>b</li></ul></html>";

    @Test
    public void testEmptySelection() {
        String text = Jsoup.parse(HTML).select("#test").text();
        Assert.assertEquals("", text);
    }

    @Test
    public void testSelectListItemsText() {
        String text = Jsoup.parse(HTML).select("li").text();
        Assert.assertEquals("a b", text);
    }

}
