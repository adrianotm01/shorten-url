package br.com.mand.shortenerurl.service;

import br.com.mand.shortenerurl.url.entity.ShortenUrl;
import br.com.mand.shortenerurl.url.repository.URLRepository;
import br.com.mand.shortenerurl.url.response.ShortenUrlResponse;
import br.com.mand.shortenerurl.url.service.URLService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class URLServiceTest {


    @InjectMocks
    URLService urlService;

    @Mock
    URLRepository urlRepository;

    @Test
    public void shouldShortUrlWithMaxSizeTen(){
        ShortenUrl shortenUrl =new ShortenUrl();
        shortenUrl.setUrlRedirect("https://g1.globo.com/");
        Mockito.when(urlRepository.save(any())).thenReturn(shortenUrl);
        ShortenUrlResponse shortenUrlResponse = urlService.shortUrl(shortenUrl);
        assertTrue(shortenUrlResponse.getNewUrl().split("/")[3].length() >= 5 && shortenUrlResponse.getNewUrl().split("/")[3].length() <= 10 );
        assertFalse(shortenUrlResponse.getNewUrl().split("/")[3].matches("[^a-zA-Z0-9_]+"));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenNotFound(){
        assertThrows(RuntimeException.class, ()->{
            urlService.findByUrlShort("DSADSA");
        });
    }

}
