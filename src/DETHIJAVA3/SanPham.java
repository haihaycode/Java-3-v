package DETHIJAVA3;

//lớp sinh viên String masp, hoten, lop;
public class SanPham {
	private String masp, tensanpham;
	private int soluong;

	public SanPham(String masp, String tensanpham, int soluong) {
		this.masp = masp;
		this.tensanpham = tensanpham;
		this.soluong = soluong;
	}

	public String getmasp() {
		return masp;
	}

	public void setmasp(String masp) {
		this.masp = masp;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
