package br.com.mand.shortenerurl.service;

import br.com.mand.shortenerurl.url.repository.URLRepository;
import br.com.mand.shortenerurl.url.service.URLService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class URLServiceTest {


    @InjectMocks
    URLService urlService;

    @Mock
    URLRepository urlRepository;

    @Test
    public void should(){
        Mockito.when(urlRepository.findByShortUrl(null)).thenReturn(null);
    }

}
