package br.com.mand.shortenerurl.url.response;

import br.com.mand.shortenerurl.url.entity.ShortenUrl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;

@Data
@NoArgsConstructor
public class ShortenUrlResponse {

    private String newUrl;

    public ShortenUrlResponse(ShortenUrl newUrl, String port) {
        this.newUrl = String.format("http://%s:%s/%s", InetAddress.getLoopbackAddress().getCanonicalHostName(), port,newUrl.getShortUrl());
    }
}
