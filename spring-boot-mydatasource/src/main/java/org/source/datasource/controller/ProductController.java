package org.source.datasource.controller;

import org.source.datasource.annotation.RoutingWith;
import org.source.datasource.config.RoutingDataSourceContext;
import org.source.datasource.entity.Product;
import org.source.datasource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品controller
 *
 * @author Mr_wenpan@163.com 2022/04/05 16:12
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RoutingWith("master")
	@GetMapping("/find-from-master")
	public String findAllProductFromMaster(){
		productService.findAllProductFromMaster();
		return "find from master success";
	}

	@RoutingWith("slave")
	@GetMapping("/find-from-slave")
	public String findAllProductFromSlave(){
		productService.findAllProductFromSlave();
		return "find from slave success";
	}


}
