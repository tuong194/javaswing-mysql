package ooad;

/**
 *
 * @author DELL
 */
public class KhachHang {
    String maKH;
    String tenKH;
    String sdt;
    String diachi;
    int luotmua;

    public KhachHang(String maKH, String tenKH, String sdt, String diachi, int luotmua) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.diachi = diachi;
        this.luotmua = luotmua;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getLuotmua() {
        return luotmua;
    }

    public void setLuotmua(int luotmua) {
        this.luotmua = luotmua;
    }
    
    
    
    
}
