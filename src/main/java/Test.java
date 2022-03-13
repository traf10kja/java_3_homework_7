public class Test {

    @BeforeSuite
    public void test2() {
        System.out.println("test2 BeforeSuite");
    }

    @MyTest
    public void test8() {
        System.out.println("test8");
    }

    @MyTest
    public void test1() {
        System.out.println("test1");
    }

    @MyTest(priority = 2)
    public void test3() {
        System.out.println("test3 priority = 2 ");
    }

    @MyTest(priority = 7)
    public void test4() {
        System.out.println("test4 priority = 7 ");
    }

    @AfterSuite
    public void test5() {
        System.out.println("test5 AfterSuite");
    }
}
