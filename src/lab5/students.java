package lab5;

public class students {
	private String maSv, hoten, email, gioiTinh, diachi;
	private int phone;

	public students() {

	}

	public students(String maSv, String hoten, String email, String gioiTinh, String diachi, int phone) {
		this.maSv = maSv;
		this.hoten = hoten;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.diachi = diachi;
		this.phone = phone;
	}

	/**
	 * @return the maSv
	 */
	public String getMaSv() {
		return maSv;
	}

	/**
	 * @param maSv the maSv to set
	 */
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	/**
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}

	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}

	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
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

}
