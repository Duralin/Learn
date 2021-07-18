package ThirdProject;

import ThirdProject.mathClass.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistance(){
        Point point1 = new Point(23, 21);
        Point point2 = new Point(-21,32);
        Assert.assertEquals(point1.distanceMethod(point1,point2), 30);
    }
    @Test
    public void testDistance2(){
        Point point1 = new Point(23, 21);
        Point point2 = new Point(-21,32);
        Assert.assertEquals(point1.distanceMethod(point1,point2), 45.35416188179427);
    }
}
