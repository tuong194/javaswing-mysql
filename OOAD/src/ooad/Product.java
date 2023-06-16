package ooad;


public class Product {
    private int maSP;
    private String tenSP;
    private int soLuong;
    private String ngayNhap;
    //private float giaNhap;
    private float giaBan;
    private byte[] image;

    public Product(int maSP, String tenSP, int soLuong, String ngayNhap,  float giaBan, byte[] image) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        
        this.giaBan = giaBan;
        this.image = image;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

   

    public float getGiaBan() {
        return giaBan;
    }

    public byte[] getImage() {
        return image;
    }
    
    
    
    
}
