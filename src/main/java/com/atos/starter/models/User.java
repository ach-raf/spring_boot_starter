package com.atos.starter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id
	private String id;
	private String name;
	private String email;
	private String avatar;
}
