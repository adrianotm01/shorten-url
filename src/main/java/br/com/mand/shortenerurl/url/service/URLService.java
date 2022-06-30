package br.com.mand.shortenerurl.url.service;

import br.com.mand.shortenerurl.url.entity.ShortenUrl;
import br.com.mand.shortenerurl.url.repository.URLRepository;
import br.com.mand.shortenerurl.url.response.ShortenUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class URLService {

    private final URLRepository urlRepository;

    @Value("${server.port}")
    private String serverPort;

    public ShortenUrlResponse shortUrl(ShortenUrl shortenUrl) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int targetStringLength = random.ints(5,10).findAny().getAsInt();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        shortenUrl.setShortUrl(generatedString);
        shortenUrl = urlRepository.save(shortenUrl);
        return new ShortenUrlResponse(shortenUrl, serverPort);
    }

    public String findByUrlShort(String urlShort) {
        return urlRepository.findByShortUrl(urlShort).orElseThrow(()->new RuntimeException()).getUrlRedirect();
    }
}
