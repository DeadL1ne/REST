package com.example.SingerService.lastFmClient;

import com.example.SingerService.lastFmClient.dto.ArtistDTO;
import com.example.SingerService.lastFmClient.dto.ResponseObjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class LastFmClient {

    private static final String API_KEY = "2f29d9ff75563741b05b5b9276dab663";

    @Autowired
    private RestTemplate restTemplate;

    public List<ArtistDTO> getArtistsByName(String name){
        final String url = "http://ws.audioscrobbler.com/2.0/?method=artist."+
                "search&artist="+name+"&api_key="+API_KEY+"&format=json";
        ResponseObjectDTO result = null;
        try {
            result = restTemplate.getForObject(new URI(url), ResponseObjectDTO.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result.getResults().getArtistmatches().getArtist();
    }
}
