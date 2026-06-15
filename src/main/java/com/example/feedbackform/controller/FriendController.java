package com.example.feedbackform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.feedbackform.model.Friend;
import com.example.feedbackform.repository.FriendRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendRepository repository;

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("friend", new Friend());

        return "friend-form";
    }

    @PostMapping("/save")
    public String saveFriend(Friend friend) {

        repository.saveFriend(friend);

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {

        return "success";
    }
    
    @GetMapping("/friends")
    public String viewFriends(Model model) {

        List<Friend> friends = repository.getAllFriends();

        model.addAttribute("friends", friends);

        return "friends-list";
    }
    @GetMapping("/delete")
    public String deleteFriend(
            @RequestParam int id) {

        repository.deleteFriend(id);

        return "redirect:/friends";
    }
    
    @GetMapping("/search")
    public String searchFriends(
            @RequestParam String name,
            Model model) {

        List<Friend> friends =
                repository.searchFriends(name);

        model.addAttribute("friends", friends);

        return "friends-list";
    }
    @GetMapping("/edit")
    public String editFriend(
            @RequestParam int id,
            Model model) {

        Friend friend =
                repository.getFriendById(id);

        model.addAttribute("friend", friend);

        return "edit-friend";
    }
    @PostMapping("/update")
    public String updateFriend(Friend friend) {

        repository.updateFriend(friend);

        return "redirect:/friends";
    }
}