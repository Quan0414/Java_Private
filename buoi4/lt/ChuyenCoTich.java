package buoi4.lt;

public class ChuyenCoTich extends Book {
    private String nvChinh;
    private String nD;

    public ChuyenCoTich() {
    }

    public ChuyenCoTich(int maSach, String tenSach, Tacgia tenTacGia, int namSanXuat, String tomTatNoiDung, double giaTien, String nvChinh, String nD) {
        super(maSach, tenSach, tenTacGia, namSanXuat, tomTatNoiDung, giaTien);
        this.nvChinh = nvChinh;
        this.nD = nD;
    }

    public String getNvChinh() {
        return nvChinh;
    }

    public void setNvChinh(String nvChinh) {
        this.nvChinh = nvChinh;
    }

    public String getnD() {
        return nD;
    }

    public void setnD(String nD) {
        this.nD = nD;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Nhan vat chinh: " + nvChinh);
        System.out.println("Noi dung: " + nD);
    }
}
