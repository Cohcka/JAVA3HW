package home_work_7;

public class DemoClass {

    public DemoClass(){}

    @BeforeSuite
    public static void before (){
        System.out.println("Before suite");
    }

    @Test(priority = 10)
    public static void test1(){
        System.out.println("Test1");
    }

    @Test(priority = 9)
    public static void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 6)
    public static void test3(){
        System.out.println("Test3");
    }

    @Test(priority = 3)
    public static void test4(){
        System.out.println("Test4");
    }

    @Test
    public static void test5(){
        System.out.println("Test5");
    }

    @Test
    public static void test6(){
        System.out.println("Test6");
    }

    @AfterSuite
    public static void after(){
        System.out.println("After");
    }
}
