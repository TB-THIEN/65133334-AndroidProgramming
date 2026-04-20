package thigk2.tranbaothien.baithigk2;

public class DanhNhan {
    String DanhNhanImageFileName;
    String DanhNhanCation;

    public DanhNhan(String DanhNhanImageFileName, String DanhNhanCation) {
        this.DanhNhanImageFileName = DanhNhanImageFileName;
        this.DanhNhanCation = DanhNhanCation;
    }

    public String getDanhNhanImageFileName() {
        return DanhNhanImageFileName;
    }

    public void setDanhNhanImageFileName(String DanhNhanImageFileName) {
        this.DanhNhanImageFileName = DanhNhanImageFileName;
    }

    public String getDanhNhanCation() {
        return DanhNhanCation;
    }

    public void setDanhNhanCation(String DanhNhanCation) {
        this.DanhNhanCation = DanhNhanCation;
    }
}
