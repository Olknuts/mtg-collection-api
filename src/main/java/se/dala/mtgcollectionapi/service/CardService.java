package se.dala.mtgcollectionapi.service;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import org.springframework.stereotype.Service;
import se.dala.mtgcollectionapi.client.MtGClient;
import se.dala.mtgcollectionapi.model.CardInfo;
import se.dala.mtgcollectionapi.model.MtgSetEdit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//little comment
/*
Reason for having a server that map the MtG API is that I want to have a different set of cards in my collection view than
wizard of the coast gives me. I also can't seem to find every card on Gatherer.com so to gather cards from other resources
could be possible.
*/

@Service
public class CardService     {
    private MtGClient client;

    public CardService(MtGClient client) {
        this.client = client;
    }

    public MtgSetEdit getSet(String setCode) {
        MtgSet set = client.getSet(setCode);
        set.getCards().sort(Comparator.comparing(a -> a.getNumber()));
        for (Card card: set.getCards()
        ) {
            System.out.println(card.getNumber() + " " + card.getName());
        }
        return parseSet(set);
    }

    private MtgSetEdit parseSet(MtgSet set) {;
        List<CardInfo> cardList = new ArrayList<>();
        for (Card card : set.getCards()) {
            cardList.add(parseCard(card));
        }
        return new MtgSetEdit(set.getName(), cardList);
    }

    private CardInfo parseCard(Card card) {
        CardInfo newCard = new CardInfo();
        newCard.setName(card.getName());
        newCard.setNumber(card.getNumber());
        newCard.setImageUrl(card.getImageUrl());
        return newCard;
    }
}
