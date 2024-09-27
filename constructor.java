// public class constructor {
//     String name;
//     int rollno;
//     constructor(String name,int rollno)
//     {
//         this.name=name;
//         this.rollno=rollno;

//     }
//     public static void main(String[] args) {
//         constructor c1=new constructor("Adi",100);
//         constructor c2=new constructor("durga",103);

//     }
// }
class Test
{
    void Test()
    {
        System.out.println("method but not constructor");
    }
    public static void main(String[] args) {
        Test t=new Test();
        t.Test();
    }
}