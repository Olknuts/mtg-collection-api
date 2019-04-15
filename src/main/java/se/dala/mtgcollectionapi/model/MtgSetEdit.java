package se.dala.mtgcollectionapi.model;

import java.util.List;

public class MtgSetEdit {
    private String name;
    private List<CardInfo> cards;

    public MtgSetEdit(String name, List<CardInfo> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public List<CardInfo> getCards() {
        return cards;
    }
}
