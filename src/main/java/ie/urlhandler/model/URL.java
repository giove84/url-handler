package ie.urlhandler.model;

import javax.persistence.*;
import java.util.Date;

import lombok.Data;

/**
 * Entity class that represents the database table 'urls'
 */
@Data
@Entity
@Table(name = "urls")
public class URL {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "original_url")
  private String originalURL;

  @Column(name = "short_url")
  private String shortURL;

  @Column(name = "creation_date")
  private Date creationDate;
}
