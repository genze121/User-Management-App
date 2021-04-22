package com.UserManagement.Bean;

public class UserManagementBean {

	private int id;
	private String name;
	private String email;
	private String countries;
	private int userId;

	public UserManagementBean() {
		super();
	}

	public UserManagementBean(int id, String name, String email, String countries, int userId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.countries = countries;
		this.userId = userId;
	}

	public UserManagementBean(String name, String email, String countries, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.countries = countries;
		this.userId = userId;
	}

	public UserManagementBean(String name, String email, String countries) {
		super();
		this.name = name;
		this.email = email;
		this.countries = countries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserManagementBean [id=" + id + ", name=" + name + ", email=" + email + ", countries=" + countries
				+ ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countries == null) ? 0 : countries.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserManagementBean other = (UserManagementBean) obj;
		if (countries == null) {
			if (other.countries != null)
				return false;
		} else if (!countries.equals(other.countries))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
