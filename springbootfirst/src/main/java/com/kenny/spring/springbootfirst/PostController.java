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

@Controller
@EnableAutoConfiguration
public class PostController {

    @Autowired
    private PostDao postDao;

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

        return "show";
    }
}
