package br.com.mand.shortenerurl.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ShortenUrl {

    @Id
    @GeneratedValue
    private Long id;

    private String urlRedirect;

    @Min(5)
    @Max(10)
    private String shortUrl;
}
