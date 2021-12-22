package com.caohongtao301.pojo;

import java.io.Serializable;



/** 
* @ClassName: CompanyInfomation301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:22:06 
*  
*/
public class CompanyInfomation301 implements Serializable {
	private static final long seriaLVersionUID = 1L;

	private int ciId301;// 公司信息编号
	private String ciTitle301;// 公司信息标题
	private String ciImage301;// 公司信息图片
	private String ciContent301;// 公司信息内容
	private String ciEditDate301;// 公司信息编辑时间
	private int ciNo301;// 公司信息序号

	public CompanyInfomation301() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyInfomation301(String ciTitle301, String ciImage301, String ciEditDate301, int ciNo301) {
		super();
		this.ciTitle301 = ciTitle301;
		this.ciImage301 = ciImage301;
		this.ciEditDate301 = ciEditDate301;
		this.ciNo301 = ciNo301;
	}

	public CompanyInfomation301(int ciId301, String ciTitle301, String ciImage301, String ciContent301,
			String ciEditDate301, int ciNo301) {
		super();
		this.ciId301 = ciId301;
		this.ciTitle301 = ciTitle301;
		this.ciImage301 = ciImage301;
		this.ciContent301 = ciContent301;
		this.ciEditDate301 = ciEditDate301;
		this.ciNo301 = ciNo301;
	}

	public int getCiId301() {
		return ciId301;
	}

	public void setCiId301(int ciId301) {
		this.ciId301 = ciId301;
	}

	public String getCiTitle301() {
		return ciTitle301;
	}

	public void setCiTitle301(String ciTitle301) {
		this.ciTitle301 = ciTitle301;
	}

	public String getCiImage301() {
		return ciImage301;
	}

	public void setCiImage301(String ciImage301) {
		this.ciImage301 = ciImage301;
	}

	public String getCiContent301() {
		return ciContent301;
	}

	public void setCiContent301(String ciContent301) {
		this.ciContent301 = ciContent301;
	}

	public String getCiEditDate301() {
		return ciEditDate301;
	}

	public void setCiEditDate301(String ciEditDate301) {
		this.ciEditDate301 = ciEditDate301;
	}

	public int getCiNo301() {
		return ciNo301;
	}

	public void setCiNo301(int ciNo301) {
		this.ciNo301 = ciNo301;
	}

	public static long getSerialversionuid() {
		return seriaLVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciContent301 == null) ? 0 : ciContent301.hashCode());
		result = prime * result + ((ciEditDate301 == null) ? 0 : ciEditDate301.hashCode());
		result = prime * result + ciId301;
		result = prime * result + ((ciImage301 == null) ? 0 : ciImage301.hashCode());
		result = prime * result + ciNo301;
		result = prime * result + ((ciTitle301 == null) ? 0 : ciTitle301.hashCode());
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
		CompanyInfomation301 other = (CompanyInfomation301) obj;
		if (ciContent301 == null) {
			if (other.ciContent301 != null)
				return false;
		} else if (!ciContent301.equals(other.ciContent301))
			return false;
		if (ciEditDate301 == null) {
			if (other.ciEditDate301 != null)
				return false;
		} else if (!ciEditDate301.equals(other.ciEditDate301))
			return false;
		if (ciId301 != other.ciId301)
			return false;
		if (ciImage301 == null) {
			if (other.ciImage301 != null)
				return false;
		} else if (!ciImage301.equals(other.ciImage301))
			return false;
		if (ciNo301 != other.ciNo301)
			return false;
		if (ciTitle301 == null) {
			if (other.ciTitle301 != null)
				return false;
		} else if (!ciTitle301.equals(other.ciTitle301))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanyInfomation301 [ciId301=" + ciId301 + ", ciTitle301=" + ciTitle301 + ", ciImage301=" + ciImage301
				+ ", ciContent301=" + ciContent301 + ", ciEditDate301=" + ciEditDate301 + ", ciNo301=" + ciNo301 + "]";
	}

}
