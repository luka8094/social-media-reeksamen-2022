package controllers;

import java.util.List;
import model.Post;

import org.springframework.web.bind.annotation.*;
import repositories.HashtagsRepository;
import repositories.PostsRepository;

@RestController
@RequestMapping("/posts")
public class PostsRestController {

    //Inspiration til REST API ved Lars Mortensen

    PostsRepository postsRepository;
    HashtagsRepository hashtagsRepository;

    public PostsRestController(HashtagsRepository hashtagsRepository,
                               PostsRepository postsRepository){
        this.postsRepository = postsRepository;
        this.hashtagsRepository = hashtagsRepository;
    }

    //show all posts
    @GetMapping()
    List<Post> getPosts(){

        return postsRepository.findAll();
    }

    //create a new post
    @PostMapping()
    Post createPost(@RequestBody Post post){

        return postsRepository.save(post);
    }

    //edit/update a post
    @PutMapping("/{id}")
    Post updatePost(@RequestBody Post post, @PathVariable("id") Long id){

       Post repositoryPost = postsRepository.findById(id).get();
       repositoryPost.setAuthor(post.getAuthor());
       repositoryPost.setPublicationDate(post.getPublicationDate());
       repositoryPost.setText(post.getText());

       return postsRepository.save(repositoryPost);
    }

    //delete a post
    @DeleteMapping("/{id}")
    void deletePost(@PathVariable("id") Long id){

        postsRepository.deleteById(id);
    }

}
