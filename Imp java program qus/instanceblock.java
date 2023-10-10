//Parent class file

class instanceblock
{
    int i = 10;
    {
        m1();
        System.out.println("parent instance block");
    }
    instanceblock()
    {
        System.out.println("Parent constructor");
    }
    public static void main(String[] args) {
        instanceblock P=new instanceblock();
        System.out.println("parent main");
    }
    public void m1()
    {
        System.out.println(j);

    }
    int j = 20;
}
class child extends instanceblock
{
    int x = 100;
    {
        m2();
        System.out.println("child instance block");
    }
    child()
    {
        System.out.println("child constructor");
    }
    public static void main(String[] args) {
        child c=new child();
        System.out.println("child main");
    }
    public void m2()
    {
        System.out.println(y);

    }
    int y = 200;

}