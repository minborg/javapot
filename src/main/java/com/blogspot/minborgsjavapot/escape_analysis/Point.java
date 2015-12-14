package com.blogspot.minborgsjavapot.escape_analysis;

/**
 *
 * @author pemi
 */
public class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int someMethod() {
        Integer someValue = x;
        return someValue;
    }

//    @Override
//    public String toString() {
//        final Integer ex = x;
//        final Integer wy = y;
//        return "(" + ex + ", " + wy + ")";
//    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb
                .append("(")
                .append(x)
                .append(", ")
                .append(y)
                .append(")");
        return sb.toString();
    }
//    @Override
//    public String toString() {
//        //return new Tuple2(x, y).toString();
//        return new Tuple2(x, y).isFirstEqualsSecond() ? "T" : "F";
//    }

}
