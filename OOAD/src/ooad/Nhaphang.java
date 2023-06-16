package ooad;

/**
 *
 * @author DELL
 */
public class Nhaphang {
    private int stt;
    private int masp;
    private String tensp;
    private float gianhap;
    private  int soluong;
    private String ngayveString;

    public Nhaphang(int stt,int masp, String tensp, float gianhap, int soluong, String ngayveString) {
        this.stt = stt;
        this.masp = masp;
        this.tensp = tensp;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.ngayveString = ngayveString;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
    

    public int getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public float getGianhap() {
        return gianhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getNgayveString() {
        return ngayveString;
    }
    
    
}
