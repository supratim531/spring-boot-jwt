package com.security.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "my_roles", uniqueConstraints = { @UniqueConstraint(columnNames = "role_desc") })
public class Role {

	@Id
	@NotBlank
	@Size(max = 20)
	@Column(name = "role_name")
	private String roleName;

	@NotBlank
	@Size(max = 255)
	@Column(name = "role_desc")
	private String roleDescription;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private Set<User> users;

}
