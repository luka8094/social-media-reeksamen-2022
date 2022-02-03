package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts")
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    private String author;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private String text;

    @ManyToOne
    @JoinColumn(name ="user_id")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy="post")
    @JsonBackReference
    private List<Hashtag> hashtags = new ArrayList<>();

    public Post(){ }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long postNumber) {
        this.number = postNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
