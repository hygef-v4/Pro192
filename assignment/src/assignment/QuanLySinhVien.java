package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLySinhVien implements ISinhVien {

    private List<SinhVien> danhSach;

    public QuanLySinhVien() {
        danhSach = new ArrayList<>();
    }

    // Thêm sinh viên
    @Override
    public void themSinhVien(SinhVien sv) {
        if (timKiem(sv.getMaSo()) == null) {
            danhSach.add(sv);
            System.out.println("Thêm sinh viên thành công!");
        } else {
            System.err.println("Mã số sinh viên đã tồn tại. Không thể thêm sinh viên !");
        }

    }

    // Cập nhật sinh viên
    @Override
    public void capNhatSinhVien(String maSo, SinhVien svMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSo().equals(maSo)) {
                danhSach.set(i, svMoi);
                return;
            }
        }
    }

    // Xóa sinh viên
    @Override
    public boolean xoaSinhVien(String maSo) {
        return danhSach.removeIf(sv -> sv.getMaSo().equals(maSo));
    }

    // Tìm kiếm sinh viên
    @Override
    public SinhVien timKiem(String maSo) {
        return danhSach.stream()
                .filter(sv -> sv.getMaSo().equals(maSo))
                .findFirst()
                .orElse(null);
    }

    // Lọc sinh viên giỏi
    @Override
    public void locSinhVienGioi() {
        List<SinhVien> svGioi = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getGpa() >= 8 && sv.getGpa() < 9) {
                svGioi.add(sv);
            }
        }
        if (svGioi.isEmpty()) {
            System.out.println("Không có sinh viên giỏi");
        } else {
            System.out.println("Danh sách sinh viên giỏi:");
            System.out.printf("%-5s %-20s %-10s %-10s %-20s %-30s%n",
                    "STT", "Họ và Tên", "MSSV", "Điểm", "Chuyên ngành", "Email");
            int stt = 1; // Biến đếm số thứ tự
            for (SinhVien sv : svGioi) {
                System.out.printf("%-5d %-20s %-10s %-10s %-20s %-30s%n",
                        stt++, sv.getHoTen(), sv.getMaSo(), sv.getGpa(), sv.getChuyenNganh(), sv.getEmail());
            }
        }

    }

    // Lọc sinh viên xuất sắc
    @Override
    public void locSinhVienXuatSac() {
        List<SinhVien> svXuatSac = new ArrayList<>();
        for (SinhVien sv : danhSach) {
            if (sv.getGpa() >= 9) {
                svXuatSac.add(sv);
            }
        }
        if (svXuatSac.isEmpty()) {
            System.out.println("Không có sinh viên xuất sắc");
        } else {
            System.out.println("Danh sách sinh viên xuất sắc:");
            System.out.printf("%-5s %-20s %-10s %-10s %-20s %-30s%n",
                    "STT", "Họ và Tên", "MSSV", "Điểm", "Chuyên ngành", "Email");
            int stt = 1; // Biến đếm số thứ tự
            for (SinhVien sv : svXuatSac) {
                System.out.printf("%-5d %-20s %-10s %-10s %-20s %-30s%n",
                        stt++, sv.getHoTen(), sv.getMaSo(), sv.getGpa(), sv.getChuyenNganh(), sv.getEmail());
            }

        }
    }

    @Override
    public void sapXepTheoGPA() {

        List<SinhVien> danhSachCopy = new ArrayList<>(danhSach);
        // sắp xếp giảm dần 
        danhSachCopy.sort(Comparator.comparingDouble(SinhVien::getGpa).reversed());
        System.out.println("Danh sách sinh viên sắp xếp theo gpa:");
        System.out.printf("%-5s %-20s %-10s %-10s %-20s %-30s%n",
                "STT", "Họ và Tên", "MSSV", "Điểm", "Chuyên ngành", "Email");
        int stt = 1; // Biến đếm số thứ tự
        for (SinhVien sv : danhSachCopy) {
            System.out.printf("%-5d %-20s %-10s %-10s %-20s %-30s%n",
                    stt++, sv.getHoTen(), sv.getMaSo(), sv.getGpa(), sv.getChuyenNganh(), sv.getEmail());
        }

    }

    @Override
    public void sapXepTheoTen() {
        // sắp xếp theo tên chính 

        List<SinhVien> danhSachCopy = new ArrayList<>(danhSach);
        danhSachCopy.sort(Comparator.comparing(sv -> sv.getHoTen().split(" ")[sv.getHoTen().split(" ").length - 1]));
        System.out.println("Danh sách sinh viên sắp xếp theo tên:");
        System.out.printf("%-5s %-20s %-10s %-10s %-20s %-30s%n",
                "STT", "Họ và Tên", "MSSV", "Điểm", "Chuyên ngành", "Email");
        int stt = 1; // Biến đếm số thứ tự
        for (SinhVien sv : danhSachCopy) {
            System.out.printf("%-5d %-20s %-10s %-10s %-20s %-30s%n",
                    stt++, sv.getHoTen(), sv.getMaSo(), sv.getGpa(), sv.getChuyenNganh(), sv.getEmail());
        }

    }

    // Xuất danh sách sinh viên
    @Override
    public void xuatDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống !");
        } else {
            System.out.println("Danh sách sinh viên: ");
            System.out.printf("%-5s %-20s %-10s %-10s %-20s %-30s%n",
                    "STT", "Họ và Tên", "MSSV", "Điểm", "Chuyên ngành", "Email");
            int stt = 1; // Biến đếm số thứ tự
            for (SinhVien sv : danhSach) {
                System.out.printf("%-5d %-20s %-10s %-10s %-20s %-30s%n",
                        stt++, sv.getHoTen(), sv.getMaSo(), sv.getGpa(), sv.getChuyenNganh(), sv.getEmail());
            }
        }

    }

    @Override
    public int soLuongSinhVien() {
        return this.danhSach.size();
    }

    // Lưu danh sách sinh viên vào file
    @Override
    public void luuFile(String tenFile) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(danhSach);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    // Đọc danh sách sinh viên từ file
    @Override
    public void docFile(String tenFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            danhSach = (List<SinhVien>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

}
