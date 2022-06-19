package br.com.mand.shortenerurl.url.controller;

import br.com.mand.shortenerurl.url.service.URLService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RedirectController {

    private final URLService urlService;

    @GetMapping("/{urlShort}")
    public RedirectView redirecUrl(@PathVariable String urlShort){

        return new RedirectView(urlService.findByUrlShort(urlShort));
    }

}
