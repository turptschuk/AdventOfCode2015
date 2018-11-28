import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int x = 0;
        int y = 0;

        int z = 0;
        int t = 0;

        char[] chars = s.toCharArray();

        Set<Point> santaSet = new HashSet<>();
        Set<Point> santaRobotSet = new HashSet<>();
        santaSet.add(new Point(0, 0));

        for (int i = 0; i < chars.length; i++) {
            Point point = new Point();
            if (i % 2 == 0) {
                if (chars[i] == '^') {
                    santaSet.add(new Point(x, y + 1));
                    y++;
                }
                if (chars[i] == 'v') {
                    santaSet.add(new Point(x, y - 1));
                    y--;
                }
                if (chars[i] == '<') {
                    santaSet.add(new Point(x - 1, y));
                    x--;
                }
                if (chars[i] == '>') {
                    santaSet.add(new Point(x + 1, y));
                    x++;
                }
            } else {
                if (chars[i] == '^') {
                    santaRobotSet.add(new Point(z, t + 1));
                    t++;
                }
                if (chars[i] == 'v') {
                    santaRobotSet.add(new Point(z, t - 1));
                    t--;
                }
                if (chars[i] == '<') {
                    santaRobotSet.add(new Point(z - 1, t));
                    z--;
                }
                if (chars[i] == '>') {
                    santaRobotSet.add(new Point(z + 1, t));
                    z++;
                }
            }
        }

        Set<Point> sumSet = new HashSet<>();
        sumSet.addAll(santaSet);
        sumSet.addAll(santaRobotSet);

        System.out.println(sumSet.size());
    }
}

class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}
