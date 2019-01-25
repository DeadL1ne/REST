package com.example.SingerService.lastFmClient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultDTO {

    private FoundedDTO artistmatches;

    public FoundedDTO getArtistmatches() {
        return artistmatches;
    }

    public void setArtistmatches(FoundedDTO artistmatches) {
        this.artistmatches = artistmatches;
    }
}
