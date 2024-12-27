package test.src;
// name: Ran Gedamo
// ID : 205386626
import java.io.UnsupportedEncodingException;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;


    public Message(byte[] data) {
        this.data = data;
        this.asText = tryToStringify(this.data);
        this.asDouble = tryParse(this.asText);
        this.date = new Date();
    }

    public Message(double asDouble) {
        this(Double.toString(asDouble));
    }

    public Message(String asText) {
        this(asText.getBytes());
    }

    private String tryToStringify(byte[] bytes) {
        try{
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }
    }
    private double tryParse(String asText) {
        try {
            return Double.parseDouble(asText);
        }catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
