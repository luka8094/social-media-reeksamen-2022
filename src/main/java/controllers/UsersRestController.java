package controllers;

import model.Post;
import model.User;
import org.springframework.web.bind.annotation.*;
import repositories.HashtagsRepository;
import repositories.PostsRepository;
import repositories.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersRestController {

    //Inspiration til REST API ved Lars Mortensen

    PostsRepository postsRepository;
    UsersRepository usersRepository;

    public UsersRestController(UsersRepository usersRepository,
                               PostsRepository postsRepository){
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    //show all users
    @GetMapping()
    List<User> getUsers(){

        return usersRepository.findAll();
    }

    //create a new user
    @PostMapping()
    User createUser(@RequestBody User user){

        return usersRepository.save(user);
    }

    //edit/update a user profile
    @PutMapping("/{id}")
    User updateUser(@RequestBody User user, @PathVariable("id") Long id){

        User repositoryUser = usersRepository.findById(id).get();
        repositoryUser.setUsername(user.getUsername());
        repositoryUser.setDescription(user.getDescription());

        return usersRepository.save(repositoryUser);
    }

    //delete a user
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") Long id){

        usersRepository.deleteById(id);
    }

}
