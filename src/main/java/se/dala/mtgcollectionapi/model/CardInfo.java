package se.dala.mtgcollectionapi.model;

public class CardInfo {
    private String name;
    private String imageUrl;
    private String number;

    public CardInfo() {}
    public CardInfo(String name, String imageUrl, String number) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
