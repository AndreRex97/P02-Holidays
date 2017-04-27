package sg.edu.rp.c346.p02_holidays;

/**
 * Created by 15017103 on 27/4/2017.
 */

public class Holiday {
    private String type;
    private String image;
    private String event;
    private String date;

    public Holiday(String type, String image, String event, String date) {
        this.type = type;
        this.image = image;
        this.event = event;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
