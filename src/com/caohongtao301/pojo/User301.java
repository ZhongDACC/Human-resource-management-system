package com.caohongtao301.pojo;

import java.io.Serializable;


/** 
* @ClassName: User301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:22:21 
*  
*/
public class User301 implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id301;
	private String name301;
	private String gender301;
	private int age301;
	private String address301;
	private String qq301;
	private String email301;

	private String username301;
	private String password301;

	public User301() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User301(int id301, String name301, String gender301, int age301, String address301, String qq301,
			String email301, String username301, String password301) {
		super();
		this.id301 = id301;
		this.name301 = name301;
		this.gender301 = gender301;
		this.age301 = age301;
		this.address301 = address301;
		this.qq301 = qq301;
		this.email301 = email301;
		this.username301 = username301;
		this.password301 = password301;
	}

	public int getId301() {
		return id301;
	}

	public void setId301(int id301) {
		this.id301 = id301;
	}

	public String getName301() {
		return name301;
	}

	public void setName301(String name301) {
		this.name301 = name301;
	}

	public String getGender301() {
		return gender301;
	}

	public void setGender301(String gender301) {
		this.gender301 = gender301;
	}

	public int getAge301() {
		return age301;
	}

	public void setAge301(int age301) {
		this.age301 = age301;
	}

	public String getAddress301() {
		return address301;
	}

	public void setAddress301(String address301) {
		this.address301 = address301;
	}

	public String getQq301() {
		return qq301;
	}

	public void setQq301(String qq301) {
		this.qq301 = qq301;
	}

	public String getEmail301() {
		return email301;
	}

	public void setEmail301(String email301) {
		this.email301 = email301;
	}

	public String getUsername301() {
		return username301;
	}

	public void setUsername301(String username301) {
		this.username301 = username301;
	}

	public String getPassword301() {
		return password301;
	}

	public void setPassword301(String password301) {
		this.password301 = password301;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address301 == null) ? 0 : address301.hashCode());
		result = prime * result + age301;
		result = prime * result + ((email301 == null) ? 0 : email301.hashCode());
		result = prime * result + ((gender301 == null) ? 0 : gender301.hashCode());
		result = prime * result + id301;
		result = prime * result + ((name301 == null) ? 0 : name301.hashCode());
		result = prime * result + ((password301 == null) ? 0 : password301.hashCode());
		result = prime * result + ((qq301 == null) ? 0 : qq301.hashCode());
		result = prime * result + ((username301 == null) ? 0 : username301.hashCode());
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
		User301 other = (User301) obj;
		if (address301 == null) {
			if (other.address301 != null)
				return false;
		} else if (!address301.equals(other.address301))
			return false;
		if (age301 != other.age301)
			return false;
		if (email301 == null) {
			if (other.email301 != null)
				return false;
		} else if (!email301.equals(other.email301))
			return false;
		if (gender301 == null) {
			if (other.gender301 != null)
				return false;
		} else if (!gender301.equals(other.gender301))
			return false;
		if (id301 != other.id301)
			return false;
		if (name301 == null) {
			if (other.name301 != null)
				return false;
		} else if (!name301.equals(other.name301))
			return false;
		if (password301 == null) {
			if (other.password301 != null)
				return false;
		} else if (!password301.equals(other.password301))
			return false;
		if (qq301 == null) {
			if (other.qq301 != null)
				return false;
		} else if (!qq301.equals(other.qq301))
			return false;
		if (username301 == null) {
			if (other.username301 != null)
				return false;
		} else if (!username301.equals(other.username301))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User301 [id301=" + id301 + ", name301=" + name301 + ", gender301=" + gender301 + ", age301=" + age301
				+ ", address301=" + address301 + ", qq301=" + qq301 + ", email301=" + email301 + ", username301="
				+ username301 + ", password301=" + password301 + "]";
	}

}
