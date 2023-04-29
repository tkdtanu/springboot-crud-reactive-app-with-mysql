package com.tkd.user.crud.app.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.tkd.user.crud.app.constants.EntityConstant;

import lombok.Data;

@Data
public class User {
	private Integer id;

	@NotEmpty(message = "Please Provide A Name")
	private String name;

	@NotEmpty(message = "Please Provide Date Of Birth")
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { EntityConstant.DATE_FORMATTER })
	private String dob;

	private long age;

	@NotEmpty(message = "Please Provide The Address")
	private String address;

	public static User entityToDto(com.tkd.user.crud.app.entity.User userEntity) {
		User user = new User();
		user.setId(userEntity.getId());
		user.setName(userEntity.getName());
		user.setDob(userEntity.getDob());
		user.setAge(userEntity.getAge());
		user.setAddress(userEntity.getAddress());
		return user;
	}

	public com.tkd.user.crud.app.entity.User toEntity() {
		com.tkd.user.crud.app.entity.User user = new com.tkd.user.crud.app.entity.User();
		user.setId(this.getId());
		user.setName(this.getName());
		user.setDob(this.getDob());
		user.setAge(this.getAge());
		user.setAddress(this.getAddress());
		return user;
	}
}
