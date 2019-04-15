package se.dala.mtgcollectionapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dala.mtgcollectionapi.model.CardInfo;
import se.dala.mtgcollectionapi.model.MtgSetEdit;
import se.dala.mtgcollectionapi.service.CardService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/set", produces = APPLICATION_JSON_VALUE)
public class Resource {
    private CardService cardService;

    public Resource(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(value = "/{setCode}")
    public MtgSetEdit getSet(@PathVariable String setCode) {
        return cardService.getSet(setCode);
    }

    private void printRequest(MtgSetEdit set) {
        for (CardInfo card : set.getCards()) {
            System.out.println(card.getName());
            System.out.println(card.getNumber());
            System.out.println(card.getImageUrl());
        }
    }
}
