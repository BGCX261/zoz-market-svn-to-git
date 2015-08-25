package com.digo.pojo;

// Generated Mar 10, 2013 2:27:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private String roleId;
	private String roleName;
	private String roleDes;
	private char roleStatus;
	private Set rolerelations = new HashSet(0);

	public Role() {
	}

	public Role(String roleId, String roleName, String roleDes, char roleStatus) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDes = roleDes;
		this.roleStatus = roleStatus;
	}

	public Role(String roleId, String roleName, String roleDes,
			char roleStatus, Set rolerelations) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDes = roleDes;
		this.roleStatus = roleStatus;
		this.rolerelations = rolerelations;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDes() {
		return this.roleDes;
	}

	public void setRoleDes(String roleDes) {
		this.roleDes = roleDes;
	}

	public char getRoleStatus() {
		return this.roleStatus;
	}

	public void setRoleStatus(char roleStatus) {
		this.roleStatus = roleStatus;
	}

	public Set getRolerelations() {
		return this.rolerelations;
	}

	public void setRolerelations(Set rolerelations) {
		this.rolerelations = rolerelations;
	}

}
