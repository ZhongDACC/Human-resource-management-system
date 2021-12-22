package com.caohongtao301.pojo;



/** 
* @ClassName: Menu301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:22:12 
*  
*/
public class Menu301 {

	private static final long serialVersionUID = 1L;
	private int id301;// µ¼º½²Ëµ¥±àºÅ
	private String menuName301;// µ¼º½²Ëµ¥Ãû³Æ
	private String menuURL301;// µ¼º½²Ëµ¥µØÖ·
	private String menuNo301;// µ¼º½²Ëµ¥ÐòºÅ

	public Menu301() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu301(int id301, String menuName301, String menuURL301, String menuNo301) {
		super();
		this.id301 = id301;
		this.menuName301 = menuName301;
		this.menuURL301 = menuURL301;
		this.menuNo301 = menuNo301;
	}

	public int getId301() {
		return id301;
	}

	public void setId301(int id301) {
		this.id301 = id301;
	}

	public String getMenuName301() {
		return menuName301;
	}

	public void setMenuName301(String menuName301) {
		this.menuName301 = menuName301;
	}

	public String getMenuURL301() {
		return menuURL301;
	}

	public void setMenuURL301(String menuURL301) {
		this.menuURL301 = menuURL301;
	}

	public String getMenuNo301() {
		return menuNo301;
	}

	public void setMenuNo301(String menuNo301) {
		this.menuNo301 = menuNo301;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id301;
		result = prime * result + ((menuName301 == null) ? 0 : menuName301.hashCode());
		result = prime * result + ((menuNo301 == null) ? 0 : menuNo301.hashCode());
		result = prime * result + ((menuURL301 == null) ? 0 : menuURL301.hashCode());
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
		Menu301 other = (Menu301) obj;
		if (id301 != other.id301)
			return false;
		if (menuName301 == null) {
			if (other.menuName301 != null)
				return false;
		} else if (!menuName301.equals(other.menuName301))
			return false;
		if (menuNo301 == null) {
			if (other.menuNo301 != null)
				return false;
		} else if (!menuNo301.equals(other.menuNo301))
			return false;
		if (menuURL301 == null) {
			if (other.menuURL301 != null)
				return false;
		} else if (!menuURL301.equals(other.menuURL301))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu301 [id301=" + id301 + ", menuName301=" + menuName301 + ", menuURL301=" + menuURL301
				+ ", menuNo301=" + menuNo301 + "]";
	}

}
