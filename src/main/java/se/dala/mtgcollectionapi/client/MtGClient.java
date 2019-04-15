package se.dala.mtgcollectionapi.client;

import io.magicthegathering.javasdk.api.SetAPI;
import io.magicthegathering.javasdk.resource.MtgSet;
import org.springframework.stereotype.Component;

@Component
public class MtGClient {
    public MtgSet getSet(String setCode) {
        return SetAPI.getSet(setCode);
    }
}
