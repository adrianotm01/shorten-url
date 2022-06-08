package br.com.mand.shortenerurl.url.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class RedirectController {

    @GetMapping("/{urlShort}")
    public RedirectView redirecUrl(@PathVariable String urlShort){
        return new RedirectView("https://www.google.com/");
    }

}
