package org.source.cache.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工实体
 *
 * @author Mr_wenpan@163.com 2022/04/06 11:21
 */
@Data
public class Employee implements Serializable {
	
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;
	private Integer dId;
}
