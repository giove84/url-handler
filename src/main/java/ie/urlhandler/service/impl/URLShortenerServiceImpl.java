package ie.urlhandler.service.impl;

import ie.urlhandler.service.URLShortenerService;
import ie.urlhandler.repository.URLRepository;
import ie.urlhandler.model.URL;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.codec.binary.Base64;

import java.util.Date;
import java.util.Optional;
import java.math.BigInteger;

/**
 * Class that implements the logic for creating a short URL and for retrieving the original one by decoding the shortened URL
 */
@Service
public class URLShortenerServiceImpl implements URLShortenerService {

  Logger logger = LoggerFactory.getLogger(URLShortenerServiceImpl.class);

  private final String DOMAIN = "http://sample/";

  @Autowired
  URLRepository urlRepository;

  @Override
  public String createShortenedURL(String originalURL) {

    // save the URL on the database
    URL url = new URL();
    url.setOriginalURL(originalURL);
    url.setCreationDate(new Date());
    URL savedURL = urlRepository.save(url);

    // encodes the id
    byte[] bytes = Base64.encodeInteger(new BigInteger(String.valueOf(savedURL.getId())));
    String encodedURL = DOMAIN + new String(bytes);

    // updates information on the database
    url.setShortURL(encodedURL);
    urlRepository.save(url);

    return encodedURL;
  }

  @Override
  public String decodeURL(String shortenedURL) {

    String stringToDecode = shortenedURL.substring(DOMAIN.length());
    BigInteger id = Base64.decodeInteger(stringToDecode.getBytes());
    Optional<URL> url = urlRepository.findById(id.longValue());
    URL urlValue = (URL) url.get();

    return urlValue.getOriginalURL();
  }

}
