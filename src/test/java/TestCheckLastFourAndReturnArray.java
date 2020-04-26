import home_work_6.WorkWithAnArrays;
import org.junit.*;

public class TestCheckLastFourAndReturnArray {
    WorkWithAnArrays wwaa;
    @Before
    public void init(){
        wwaa = new WorkWithAnArrays();
    }

    @Test
    public void test1(){
        Assert.assertArrayEquals(new int[]{1, 7}, wwaa.CheckLastFourAndReturnArray(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test2(){
        Assert.assertArrayEquals(new int[]{0, 2, 1, 3, 7, 2, 99, 1}, wwaa.CheckLastFourAndReturnArray(new int[]{2, 4, 0, 2, 1, 3, 7, 2, 99, 1}));
    }

    @Test(expected = RuntimeException.class)
    public void test3(){
        Assert.assertArrayEquals(new int[0], wwaa.CheckLastFourAndReturnArray(new int[]{22, 99, 1, 3, 2, 3, 5, 1, 6}));
    }

    @Test(expected = RuntimeException.class)
    public void test4(){
        Assert.assertArrayEquals(new int[0], wwaa.CheckLastFourAndReturnArray(new int[]{}));
    }
}
