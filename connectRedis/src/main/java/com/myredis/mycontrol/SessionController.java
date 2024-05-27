package com.myredis.mycontrol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/set")
    public String setSessionAttribute(HttpSession session) {
        session.setAttribute("username", "JohnDoe");
        return "Session attribute set successfully.";
    }

    @GetMapping("/get")
    public String getSessionAttribute(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "Session attribute username: " + (username != null ? username : "not set");
    }
}
