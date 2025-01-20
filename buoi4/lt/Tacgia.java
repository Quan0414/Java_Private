package buoi4.lt;

public class Tacgia {
    private String tenTacGia;

    public Tacgia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    @Override
    public String toString() {
        return tenTacGia;
    }
}
