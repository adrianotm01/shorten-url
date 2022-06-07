package br.com.mand.shortenerurl.request;

import br.com.mand.shortenerurl.entity.ShortenUrl;

public class ShortenUrlForm {
    public ShortenUrl getEntity() {
        return new ShortenUrl();
    }
}
