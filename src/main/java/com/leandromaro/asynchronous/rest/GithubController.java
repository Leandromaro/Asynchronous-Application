package com.leandromaro.asynchronous.rest;


import com.leandromaro.asynchronous.rest.domain.User;
import com.leandromaro.asynchronous.rest.service.GitHubLookupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping(path="/github")
public class GithubController {

    private GitHubLookupService service;

    GithubController(GitHubLookupService service) {
        this.service = service;
    }

    @GetMapping(path="/user")
    public @ResponseBody String addNewUser (@RequestParam String name){
        try {
            CompletableFuture<User> user = service.findUser(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
