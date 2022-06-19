package br.com.mand.shortenerurl.url.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Table
@Entity
public class ShortenUrl {

    @Id
    @GeneratedValue
    private Long id;

    private String urlRedirect;

    private String shortUrl;
}
