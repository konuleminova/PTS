package photogeneia.koteoglou.olga.pts;

/**
 * Created by Asus on 12/25/2017.
 */

public class Item {
    private String name,location,time;
    private int nameImg,locationImg,timeImg;
    private int nextbtn;

    public Item(String name, String location, String time, int nameImg, int locationImg, int timeImg, int nextbtn) {
        this.name = name;
        this.location = location;
        this.time = time;
        this.nameImg = nameImg;
        this.locationImg = locationImg;
        this.timeImg = timeImg;
        this.nextbtn = nextbtn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNameImg() {
        return nameImg;
    }

    public void setNameImg(int nameImg) {
        this.nameImg = nameImg;
    }

    public int getLocationImg() {
        return locationImg;
    }

    public void setLocationImg(int locationImg) {
        this.locationImg = locationImg;
    }

    public int getTimeImg() {
        return timeImg;
    }

    public void setTimeImg(int timeImg) {
        this.timeImg = timeImg;
    }

    public int getNextbtn() {
        return nextbtn;
    }

    public void setNextbtn(int nextbtn) {
        this.nextbtn = nextbtn;
    }
}
