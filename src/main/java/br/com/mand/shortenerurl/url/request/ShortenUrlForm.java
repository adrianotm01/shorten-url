package br.com.mand.shortenerurl.url.request;

import br.com.mand.shortenerurl.url.entity.ShortenUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortenUrlForm {

    private String url;

    public ShortenUrl getEntity() {
        ShortenUrl shortenUrl= new ShortenUrl();
        shortenUrl.setUrlRedirect(url);
        return shortenUrl;
    }
}
