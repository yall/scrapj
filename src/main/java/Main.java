import org.scrapj.Scrapj;
import org.scrapj.impl.JsonOuputDataProcessor;
import org.scrapj.impl.SystemOutDataProcessor;
import org.scrapj.parse.Selection;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Scrapj.processData(JsonOuputDataProcessor.to("out/test.json"));
        Scrapj.processData(SystemOutDataProcessor.get());

        Scrapj.start("http://www.lemonde.fr", (ctx, res) -> {
            for (Selection a : res.css("h2")) {
                ctx.emitData(a.text());
            }
        });

    }

}



