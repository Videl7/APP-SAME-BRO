package es.samebro.backoffice.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import es.samebro.backoffice.services.BusinessService;
import es.samebro.backoffice.entities.Business;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class TestController {

  @Autowired
  private BusinessService business_service;

  @GetMapping("")
  @ResponseBody
  public ResponseEntity<String> HelloWorld(HttpServletRequest request) throws Exception {
    return new ResponseEntity<>("Hello World", HttpStatus.OK);
  }

  @GetMapping("/business")
  @ResponseBody
  public ResponseEntity<ArrayList<Business>> getAllBusiness(HttpServletRequest request) throws Exception {
    return new ResponseEntity<>(this.business_service.getAll(), HttpStatus.OK);
  }

}
