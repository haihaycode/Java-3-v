package lab4;

public class sanPham {
	private String maSanPham, tenSanPham, DVT, nhaCungCap;
	private int donGia;

	public sanPham() {

	}

	public sanPham(String maSanPham, String tenSanPham, String dVT, String nhaCungCap, int donGia) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		DVT = dVT;
		this.nhaCungCap = nhaCungCap;
		this.donGia = donGia;
	}

	/**
	 * @return the maSanPham
	 */
	public String getMaSanPham() {
		return maSanPham;
	}

	/**
	 * @param maSanPham the maSanPham to set
	 */
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	/**
	 * @return the tenSanPham
	 */
	public String getTenSanPham() {
		return tenSanPham;
	}

	/**
	 * @param tenSanPham the tenSanPham to set
	 */
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	/**
	 * @return the dVT
	 */
	public String getDVT() {
		return DVT;
	}

	/**
	 * @param dVT the dVT to set
	 */
	public void setDVT(String dVT) {
		DVT = dVT;
	}

	/**
	 * @return the nhaCungCap
	 */
	public String getNhaCungCap() {
		return nhaCungCap;
	}

	/**
	 * @param nhaCungCap the nhaCungCap to set
	 */
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	/**
	 * @return the donGia
	 */
	public int getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

}
