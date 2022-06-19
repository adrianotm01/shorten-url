package br.com.mand.shortenerurl.url.repository;

import br.com.mand.shortenerurl.url.entity.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends JpaRepository<ShortenUrl, Long> {
    Optional<ShortenUrl> findByShortUrl(String urlShort);
}
