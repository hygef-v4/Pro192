package assignment;

public class SinhVienKyThuat extends SinhVien {
    public static final String[] MON_HOC = {"Toán kỹ thuật", "Vật lý", "Hóa học", "Lập trình", "Cơ học"};

    public SinhVienKyThuat(String hoTen, String maSo, String chuyenNganh, double[] diemMon) {
        super(hoTen, maSo, chuyenNganh, diemMon);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Các môn học: %s", String.join(", ", MON_HOC));
    }
}
