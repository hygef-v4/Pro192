package assignment;

public class SinhVienKinhTe extends SinhVien {
    public static final String[] MON_HOC = {"Kinh tế vi mô", "Kinh tế vĩ mô", "Marketing", "Kế toán", "Thương mại điện tử"};

    public SinhVienKinhTe(String hoTen, String maSo, String chuyenNganh, double[] diemMon) {
        super(hoTen, maSo, chuyenNganh, diemMon);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",\nCác môn học:\n%s", String.join("\n", MON_HOC));
    }
}
