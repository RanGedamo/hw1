package test.src;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;


    public Message(byte[] data) {
        this.data = data;
        this.asText = data.toString();
        this.asDouble = tryParse(this.asText);
        this.date = new Date();
    }

    public Message(double asDouble) {
        this(Double.toString(asDouble));
    }

    public Message(String asText) {
        this(asText.getBytes());
    }

    private double tryParse(String asText) {
        try {
            return Double.parseDouble(asText);
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return Double.NaN;
        }

    }

}
