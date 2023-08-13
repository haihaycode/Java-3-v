package lab6;

import java.sql.Date;

public class students {
	private String RegID, name, address, parentName, standard;
	private int phone;
	private Date RegDate;

	public students() {

	}

	public students(String regID, String name, String address, String parentName, int phone, String standard,
			Date regDate) {

		this.RegID = regID;
		this.name = name;
		this.address = address;
		this.parentName = parentName;
		this.standard = standard;
		this.phone = phone;
		this.RegDate = regDate;
	}

	/**
	 * @return the regID
	 */
	public String getRegID() {
		return RegID;
	}

	/**
	 * @param regID the regID to set
	 */
	public void setRegID(String regID) {
		RegID = regID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return RegDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		RegDate = regDate;
	}

}
