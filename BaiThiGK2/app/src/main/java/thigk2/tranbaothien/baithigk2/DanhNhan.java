package thigk2.tranbaothien.baithigk2;

public class DanhNhan {
    String DanhNhanImageFileName;
    String DanhNhanCation;

    public DanhNhan(String landImageFileName, String landCation) {
        this.DanhNhanImageFileName = DanhNhanImageFileName;
        this.DanhNhanCation = DanhNhanCation;
    }

    public String getDanhNhanImageFileName() {
        return DanhNhanImageFileName;
    }

    public void setDanhNhanImageFileName(String landImageFileName) {
        this.DanhNhanImageFileName = DanhNhanImageFileName;
    }

    public String getDanhNhanCation() {
        return DanhNhanCation;
    }

    public void setDanhNhanCation(String landCation) {
        this.DanhNhanCation = DanhNhanCation;
    }
}
