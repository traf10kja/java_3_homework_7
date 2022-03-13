public class Test {

    @BeforeSuite
    public static void test2() {
        System.out.println("test2 BeforeSuite");
    }

    @MyTest
    public static void test8() {
        System.out.println("test8");
    }

    @MyTest
    public static void test1() {
        System.out.println("test1");
    }

    @MyTest(priority = 2)
    public static void test3() {
        System.out.println("test3 priority = 2 ");
    }

    @MyTest(priority = 7)
    public static void test4() {
        System.out.println("test4 priority = 7 ");
    }

    @AfterSuite
    public static void test5() {
        System.out.println("test5 AfterSuite");
    }
}
