package com.tnsi.bank;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	 @RequestMapping("/hello/{name}")
	 String hello(@PathVariable String name) {
         
         return "saly "+name+" !";
           
}
	 @RequestMapping("/bonjour/{name}")
	 String hello1(@PathVariable String name) {
         
         return "Saly daholo "+name+" !";
           
}

}
