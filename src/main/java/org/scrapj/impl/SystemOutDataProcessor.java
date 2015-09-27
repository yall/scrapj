package org.scrapj.impl;

import org.scrapj.middleware.DataProcessor;

import java.io.File;

public class SystemOutDataProcessor implements DataProcessor {


    private SystemOutDataProcessor() {
    }

    public static final SystemOutDataProcessor get() {
        return new SystemOutDataProcessor();
    }

    @Override
    public void process(Object data) {
        System.out.println(data);
    }

    @Override
    public void destroy() {

    }
}
