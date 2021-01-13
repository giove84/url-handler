package ie.urlhandler.service;

public interface URLShortenerService {

  public String createShortenedURL(String originalURL);

  public String decodeURL(String shortenedURL);

}
