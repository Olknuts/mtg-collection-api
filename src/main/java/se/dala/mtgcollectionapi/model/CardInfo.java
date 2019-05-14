package se.dala.mtgcollectionapi.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardInfo cardInfo = (CardInfo) o;
        return Objects.equals(name, cardInfo.name) &&
                Objects.equals(imageUrl, cardInfo.imageUrl) &&
                Objects.equals(number, cardInfo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl, number);
    }
}
