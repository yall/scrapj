package org.scrapj.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.scrapj.middleware.DataProcessor;

import java.io.*;

public class JsonOuputDataProcessor implements DataProcessor {

    private BufferedWriter writer;

    private ObjectMapper mapper = new ObjectMapper();

    private JsonOuputDataProcessor(OutputStream out) {
        this.writer = new BufferedWriter(new OutputStreamWriter(out));
    }

    public static final JsonOuputDataProcessor to(OutputStream out) {
        return new JsonOuputDataProcessor(out);
    }

    public static final JsonOuputDataProcessor to(File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            return to(out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found : " +  file.getAbsolutePath());
        }
    }

    public static final JsonOuputDataProcessor to(String path) {
        return to(new File(path));
    }


    @Override
    public void process(Object data) {

        try {
            this.writer.write(this.mapper.writeValueAsString(data));
            this.writer.write('\n');
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
       if (this.writer != null) {
           try {
               this.writer.close();
           } catch (IOException e) {
               //
           }
       }
    }
}
