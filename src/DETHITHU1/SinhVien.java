package DETHITHU1;
//lớp sinh viên String masv, hoten, lop;
public class SinhVien {
	private String masv, hoten, lop;

	public SinhVien() {

	}

	public SinhVien(String masv, String hoten, String lop) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.lop = lop;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

}
