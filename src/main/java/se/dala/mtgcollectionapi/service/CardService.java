package se.dala.mtgcollectionapi.service;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import org.springframework.stereotype.Service;
import se.dala.mtgcollectionapi.client.MtGClient;
import se.dala.mtgcollectionapi.model.CardInfo;
import se.dala.mtgcollectionapi.model.MtgSetEdit;

import java.util.*;
import java.util.stream.Collectors;
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
        return parseSet(set);
    }

    private MtgSetEdit parseSet(MtgSet set) {;
        Set<CardInfo> cardSet = new HashSet<>();
        for (Card card : set.getCards()) {
            cardSet.add(parseCard(card));
        }
        List<CardInfo> cardList = cardSet.stream().collect(Collectors.toList());
        cardList.sort(Comparator.comparing(a -> Integer.parseInt(a.getNumber())));
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
