package org.scrapj.context;

import org.scrapj.http.Request;
import org.scrapj.middleware.DataProcessor;

import java.util.ArrayList;
import java.util.List;

public class ContextBuilder {

    private List<DataProcessor> dataProcessors;

    private ContextBuilder() {
        this.dataProcessors = new ArrayList<>();
    }

    public static ContextBuilder create() {
        return new ContextBuilder();
    }

    public void addDataProcessor(DataProcessor dataProcessor) {
        this.dataProcessors.add(dataProcessor);
    }


    public Context build(Request request) {
        ContextImpl context = new ContextImpl(request);
        return context;
    }


    public class ContextImpl implements Context {

        private Request request;

        private ContextImpl(Request request) {
            this.request = request;
        }

        @Override
        public Request getRequest() {
            return this.request;
        }

        @Override
        public void emitRequest(Request request) {

        }

        @Override
        public void emitData(Object data) {

            for (DataProcessor dataProcessor : dataProcessors) {
                dataProcessor.process(data);
            }

        }

    }
}
