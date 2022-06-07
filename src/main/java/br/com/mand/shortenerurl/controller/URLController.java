package br.com.mand.shortenerurl.controller;

import br.com.mand.shortenerurl.request.ShortenUrlForm;
import br.com.mand.shortenerurl.service.URLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shorten")
public class URLController {

    private URLService urlService;

    @PostMapping
    public ResponseEntity<Void> shortenUrl(ShortenUrlForm form){
        urlService.shortUrl(form.getEntity());
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
