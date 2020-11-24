import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Point {
    private double x, y, time;
    private int r;
    private Date currentDate;
    private String result;

    Point(double x, double y, int r, long start) {
        this.currentDate = new Date();
        this.time = roundAvoid(((double)System.nanoTime() - start)/1000000,2);
        this.result = checkResult(x,r,y);
        this.x = roundAvoid(x,2);
        this.y = roundAvoid(y,2);
        this.r = r;
    }

    private double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    private String checkResult(double x, int r, double y) {
        if ((x >= -r && x <= 0 && y >= 0 && y <=r) ||
                (y >= -x-r && y <= 0 && x <= 0) ||
                ((x*x + y*y) <= (float)r*r/4 && x >= 0 && y <= 0)){
            System.out.println(1);
            return "True";
        }else {
            System.out.println(2);
            return "False";
        }
    }

    private boolean valid(double x, int r, double y) {
        int[] rVal = new int[] {1,2,3,4,5};
        return Arrays.asList(rVal).contains(r);
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public String getResult() {
        return result;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public String isResult() {
        return result;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toJson() {
        return "{" +
                "\"x\":\"" + x+ "\"," +
                "\"y\":\"" + y+ "\"," +
                "\"r\":\"" + r+ "\"," +
                "\"result\":\"" + result+ "\"," +
                "\"current_time\":\"" + currentDate+ "\"," +
                "\"time\":\"" + time+ "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.getX(), getX()) == 0 &&
                Double.compare(point.getY(), getY()) == 0 &&
                Double.compare(point.getTime(), getTime()) == 0 &&
                getR() == point.getR() &&
                getCurrentDate().equals(point.getCurrentDate()) &&
                getResult().equals(point.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getTime(), getR(), getCurrentDate(), getResult());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", time=" + time +
                ", r=" + r +
                ", currentDate=" + currentDate +
                ", result='" + result + '\'' +
                '}';
    }
}
