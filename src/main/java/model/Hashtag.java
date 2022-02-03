package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="hashtags")
public class Hashtag {

    @Id
    private String hashtagName;

    @ManyToOne
    @JoinColumn(name="post_number")
    @JsonManagedReference
    private Post post;

    public Hashtag(){ }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
