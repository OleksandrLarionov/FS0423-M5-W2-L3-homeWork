package larionov.API.services;

import larionov.API.entities.Author;
import larionov.API.entities.BlogPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BlogPostService {


    private List<BlogPost> blogPost = new ArrayList<>();

    public List<BlogPost> getBlogPosts() {
        return this.blogPost;
    }

    public BlogPost saveBlogPost(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 20000));
        this.blogPost.add(body);
        return body;
    }

    public BlogPost findById(Long id) {
        return blogPost.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    log.info("per la peppa");
                    return null;
                });
    }

    public void delete(Long id) {
        blogPost.removeIf(blog -> blog.getId().equals(id));
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPost body) {
        Optional<BlogPost> blogPostOptional = this.blogPost.stream()
                .filter(blogPost -> blogPost.getId().equals(id))
                .findFirst();

        if (blogPostOptional.isPresent()) {
            BlogPost found = blogPostOptional.get();
            found.setId(id);
            found.setCategoria(body.getCategoria());
            found.setTitolo(body.getTitolo());
            return found;
        } else {
            log.info("error");
            return null;
        }
    }

    public List<BlogPost> filterByCategory(String categoria) {
        List<BlogPost> categoryList = this.blogPost.stream()
                .filter(blogPost -> blogPost.getCategoria().equals(categoria))
                .collect(Collectors.toList());

        return categoryList;
    }


}

