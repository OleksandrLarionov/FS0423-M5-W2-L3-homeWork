package larionov.API.controllers;

import larionov.API.entities.Author;
import larionov.API.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;


    @GetMapping
    public Page<Author> getAuthor(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String orderBy) {
        return authorService.getAuthors(page,size,orderBy);
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.saveAuthor(body);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id);

    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable Long id, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
