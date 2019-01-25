package com.example.SingerService.lastFmClient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObjectDTO {

    private SearchResultDTO results;

    public SearchResultDTO getResults() {
        return results;
    }

    public void setResults(SearchResultDTO results) {
        this.results = results;
    }
}
