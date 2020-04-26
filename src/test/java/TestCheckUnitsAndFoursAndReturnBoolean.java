import home_work_6.WorkWithAnArrays;
import org.junit.*;

public class TestCheckUnitsAndFoursAndReturnBoolean {
    WorkWithAnArrays wwaa;
    @Before
    public void init(){
        wwaa = new WorkWithAnArrays();
    }

    @Test
    public void test1(){
        Assert.assertFalse(wwaa.CheckUnitsAndFoursAndReturnBoolean(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    @Test
    public void test2(){
        Assert.assertFalse(wwaa.CheckUnitsAndFoursAndReturnBoolean(new int[]{0, 2, 3, 0, 5, 6, 7, 8}));
    }

    @Test
    public void test3(){
        Assert.assertFalse(wwaa.CheckUnitsAndFoursAndReturnBoolean(new int[]{1}));
    }

    @Test
    public void test4(){
        Assert.assertFalse(wwaa.CheckUnitsAndFoursAndReturnBoolean(new int[]{}));
    }
}
