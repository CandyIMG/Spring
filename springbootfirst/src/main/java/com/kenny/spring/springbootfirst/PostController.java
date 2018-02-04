package com.kenny.spring.springbootfirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class PostController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="/posts/new", method=RequestMethod.GET)
    public String newPost( Model model ) {
        model.addAttribute( "post", new Post() );
        return "new";
    }

    @RequestMapping(value="/posts", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post, Model model ) {
        model.addAttribute( "post", post );

        post.setId( "123" );
        System.out.println( "__KENNY__ post.id : " + post.getId() );
        postDao.save( post );


        Post findPost = postRepository.findById( "123" );
        System.out.println( "__KENNY__ findPost.id : " + findPost.getId() );


        List<Post> lp = postRepository.findByTitle( "title1" );
        System.out.println( "__KENNY__ lp.title : " + lp.get(0).getTitle() );


        lp = postRepository.findByContent( "content1" );
        System.out.println( "__KENNY__ lp.content : " + lp.get(0).getContent() );

        return "show";
    }
}
