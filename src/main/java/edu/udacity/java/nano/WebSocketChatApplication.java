package edu.udacity.java.nano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class WebSocketChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketChatApplication.class, args);
    }

    /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * Chatroom Page
     */
    @GetMapping("/chat")
    public ModelAndView index(String username, HttpServletRequest request) throws UnknownHostException {


        StringBuffer url = request.getRequestURL();
        //String wsURL = url.toString().replaceFirst("http:", "ws:") + "/";
        String wsURL = url.toString().replaceFirst("https:", "wss:") + "/";

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/chat");
        modelAndView.addObject("username", username);
        modelAndView.addObject("wsURL", wsURL);

        return modelAndView;
    }
}