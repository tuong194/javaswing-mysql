package ooad;

/**
 *
 * @author DELL
 */
public class HoaDon {
    String mahd;
    int masp;
    float giasp;
    int soluong;
    float tongtien;
    String ngayban;

    public HoaDon(String mahd, int masp, float giasp, int soluong, float tongtien, String ngayban) {
        this.mahd = mahd;
        this.masp = masp;
        this.giasp = giasp;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.ngayban=ngayban;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public float getGiasp() {
        return giasp;
    }

    public void setGiasp(float giasp) {
        this.giasp = giasp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }
    
    
}
