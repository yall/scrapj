# Scrapj

A tiny Scrapy inspired web scraping framework.

```java
public class Main {

    public static void main(String[] args) throws IOException {

        Scrapj.processData(JsonOuputDataProcessor.to("titles.json"));

        Scrapj.start("http://www.lemonde.fr", (ctx, res) -> {
            for (Selection a : res.css("h2")) {
                ctx.emitData(a.text());
            }
        });

    }

}
```