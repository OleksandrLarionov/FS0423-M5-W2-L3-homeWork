package larionov.API.controllers;

import larionov.API.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/examples")
public class ExampleController {
    @GetMapping("/getExample")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String getExample() {
        return "Per le GET sei nel posto giusto";
    }

    @PostMapping("/postExample")
    public String postExample() {
        return "Per le POST sei nel posto giusto";
    }

    @GetMapping("/")
    public String get() {
        return "GET";
    }

    @PostMapping("/")
    public String post() {
        return "POST";
    }

    @PatchMapping("/")
    public String patch() {
        return "PATCH";
    }

    @DeleteMapping("/")
    public String delete() {
        return "DELETE";
    }

    @PutMapping("/")
    public String put() {
        return "PUT";
    }

    @GetMapping("/queryParams")
    public String queryParams(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        System.out.println("****************************************Query Params**********************************");
        System.out.println(name);
        System.out.println(surname);
        return "hello " + name + " " + surname;
    }
    @PostMapping("/payloadBody")
    public Author payloadBody(@RequestBody Author body ){
        System.out.println("--------------->" + body);
        return body;
    }
}
