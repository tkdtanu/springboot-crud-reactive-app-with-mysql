package com.tkd.user.crud.app.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.tkd.user.crud.app.constants.EntityConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tarun.das
 *
 */
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Persistable<Integer> {

	@Id
	private Integer id;

	private String name;

	private String dob;

	@Transient
	private long age;

	private String address;

	public long getAge() {
		return ChronoUnit.YEARS.between(LocalDate.parse(dob, EntityConstant.formatter), LocalDate.now());
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

}
