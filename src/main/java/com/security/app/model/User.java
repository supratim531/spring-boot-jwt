package com.security.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "my_users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "user_email") })
public class User {

	@Id
	@Column(name = "user_id")
	private Long id;

	@NotBlank
	@Size(max = 30)
	private String username;

	@NotBlank
	@Size(max = 70)
	private String password;

	@Email
	@NotBlank
	@Size(max = 50)
	@Column(name = "user_email")
	private String email;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "role", referencedColumnName = "role_name")
	private Role role;

}
