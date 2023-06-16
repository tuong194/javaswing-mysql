package ooad;



public class User {
    
    private String maNV;
    private String tenNV;
    private String Sex;
    private String Phone;
    private String dateBirthday;
    private String diaChi;
    
    public User(String pmaNV, String ptenNV, String pSex, String pPhone,  String pdiaChi, String pdateBirthday){
        this.maNV = pmaNV;
        this.tenNV = ptenNV;
        this.Sex = pSex;
        this.Phone= pPhone;
        this.diaChi= pdiaChi;
        this.dateBirthday = pdateBirthday;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

   

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }
    
    
    
}
