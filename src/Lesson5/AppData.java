package Lesson5;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}

