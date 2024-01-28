package org.source.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 *
 * @author Mr_wenpan@163.com 2022/04/02 17:35
 */
@RestController("HelloController.v1")
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
}
