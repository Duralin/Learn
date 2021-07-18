package main;

import mathClass.Point;

public class main {
    public static void main(String[] args){
        Point p1 = new Point(23, 21);
        Point p2 = new Point(21,32);
        Point p3 = new Point(54,62);
        Point p4 = new Point(26,51);

        System.out.printf("Расстояние между точками равно %s \n",distance(p1,p2) );
        System.out.printf("Расстояние между точками равною %s \n",distance(p1,p4) );
        System.out.printf("Расстояние между точками равно %s \n",distance(p3,p2));

        p1.distanceMethod(p1,p2);
        p1.distanceMethod(p1,p3);
        p1.distanceMethod(p3,p4);

    }
    public static double distance (Point p1, Point p2){
        double result;
        result = Math.sqrt(Math.pow(p1.getX() - p2.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
        return result;
    }
}
