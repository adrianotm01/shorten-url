package br.com.mand.shortenerurl.url.controller;

import br.com.mand.shortenerurl.url.request.ShortenUrlForm;
import br.com.mand.shortenerurl.url.response.ShortenUrlResponse;
import br.com.mand.shortenerurl.url.service.URLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("shorten")
public class URLController {

    private final URLService urlService;

    @PostMapping
    public ResponseEntity<Void> shortenUrl(@RequestBody ShortenUrlForm form){
        System.out.println(form);
        ShortenUrlResponse shortenUrlResponse = urlService.shortUrl(form.getEntity());
        return new ResponseEntity(shortenUrlResponse,HttpStatus.CREATED);
    }

}
