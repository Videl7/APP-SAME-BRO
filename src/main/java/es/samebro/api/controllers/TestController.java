package es.samebro.api.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
  @GetMapping("")
  @ResponseBody
  public ResponseEntity<String> HelloWorld(HttpServletRequest request) throws Exception {
    return new ResponseEntity<>("Hello World", HttpStatus.OK);
  }
}
