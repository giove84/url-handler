package ie.urlhandler.controller;

import ie.urlhandler.service.URLShortenerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * Rest controller that handles requests for shortening URLs and for redirecting to the original one
 */
@RestController
@RequestMapping("/url-handler")
public class URLShortenerController {

  Logger logger = LoggerFactory.getLogger(URLShortenerController.class);

  @Autowired
  URLShortenerService urlShortenerService;

  @PostMapping("/shorten-url")
  public ModelAndView shortenURL(@RequestParam("originalUrl") String originalURL) {

    String shortenedURL = urlShortenerService.createShortenedURL(originalURL);

    ModelAndView modelAndView = new ModelAndView("result");
    modelAndView.addObject("shortenedURL", shortenedURL);

    return modelAndView;
  }

  @GetMapping("/redirect")
  public RedirectView redirectToOriginalURL(@RequestParam("shortenedUrl") String shortenedURL)
    throws URISyntaxException {

    String originalURL = urlShortenerService.decodeURL(shortenedURL);
    return new RedirectView(originalURL);
  }
}
