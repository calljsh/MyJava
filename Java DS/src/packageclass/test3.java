package packageclass;
//
//
//class Person  implements Comparable
//{
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
//class  Fan<T extends Person>
//{
//    public  T cmp(T[] array)
//            // 如果要比较类的话,你泛型继承的类一定要继承了Comparable接口,不然就没法比较
//    {
//        T max=array[0];
//        for(int i=1;i<array.length;i++)
//        {
//            if(array[i].compareTo(max)>0)
//            {
//                max=array[i];
//            }
//
//        }
//        return max;
//    }
//}
//public class test3
//{
//    public static void main(String[] args)
//    {
//       Fan fan=new Fan();
//    }
//}
//package packageclass;
//
//class Person implements Comparable<Person> {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public int compareTo(Person other) {
//        return this.age-other.age;
//    }
//
//    @Override
//    public String toString() {
//        return "{name='" + name + "', age=" + age + '}';
//    }
//}


//class Fan<T extends Comparable<T>> {
//  泛型类
//    public T cmp(T[] array) {
//        T max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i].compareTo(max) > 0) {
//                max = array[i];
//            }
//        }
//        return max;
//    }
//}
class Fan {
    // 泛型方法
    public<T extends Comparable<T>> T cmp(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
public class test3 {
    public static void main(String[] args) {
        Fan fan = new Fan();
    Integer [] arr={1,2,3,4,5};
        System.out.println(fan.cmp(arr));
    }
}
