package com.url.shortener.controllers;

import com.url.shortener.models.UrlMapping;
import com.url.shortener.service.UrlMappingService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    private UrlMappingService urlMappingService;

    public ResponseEntity<Void> redirect(@PathVariable String shortUrl){

        UrlMapping urlMapping=urlMappingService.getOriginalUrl(shortUrl);
        if(urlMapping!=null){
            HttpHeaders httpHeaders=new HttpHeaders();
            httpHeaders.add("Location",urlMapping.getOriginalUrl());
            return ResponseEntity.status(302).headers(httpHeaders).build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
