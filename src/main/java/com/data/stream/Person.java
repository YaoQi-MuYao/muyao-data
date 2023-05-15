package com.data.stream;

import java.util.Optional;

/**
 * @author XiaoXiao
 * @Date 2023/4/13 17:33
 **/
public class Person implements Cloneable {
    private String name;
    private int age;
    private House house;
    public House getHouse() {
        return house;
    }
}

class House{
    private long price;
    private Address address;
    public Address getAddress() {
        return address;
    }
}

class Address {
    private String country;
    private String city;
    public String getCity() {
        return city;
    }
}

class Main{
    public static void main(String[] args) {
        /* 创建空的Optional对象。可以通过静态工厂方法Optional.Empty() 创建一个空的对象，例如 */
        Optional<Person> optionalPerson1 = Optional.empty();
        /* 指定非空值创建Optional对象 */
        Person person1 = new Person();
        Optional<Person> optionalPerson2 = Optional.of(person1);
        /* 指定可能为空的值创建Optional对象 */
        Person person2 = null; // 可能为空
        Optional<Person> optionalPerson3 = Optional.of(person2);

        /*  ifPresent 如果值存在，则调用consumer实例消费该值，否则什么都不执行。举个栗子： */
        String str = "hello java8";
        Optional.ofNullable(str).ifPresent(System.out::println);
        String str2 = null;
        Optional.ofNullable(str2).ifPresent(System.out::println);
        /* orElse 如果value为空，则返回默认值，举个栗子 */
        test("");
        /* orElseGet 如果value为空，则调用Supplier实例返回一个默认值。举个例子： */
        test2("");
        /* orElseThrow 如果value为空，则抛出自定义异常。举个栗子： */
        test3("");

        System.out.println(getCity(new Person()));
        /* 使用Optional获取city */
        System.out.println(getCityUsingOptional(new Person()));
    }

    /***
      * 不使用Optional获取city
      * @author muyao
      * @date 2023/4/13 17:48
      * @param
      **/
    static String getCity(Person person) {
        return person.getHouse().getAddress().getCity();
    }

    /***
      * 使用Optional获取city
      * @author muyao
      * @date 2023/4/13 17:49
      * @param
      **/
    static String getCityUsingOptional(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getHouse)
                .map(House::getAddress)
                .map(Address::getCity).orElse("Unknown City");
    }

    public static void test(String city) {
        String defaultCity = Optional.ofNullable(city).orElse("unknown");
    }

    public static void test2(String city) {
        // 如果city为空，则调用generateDefaultCity方法
        String defaultCity = Optional.of(city).orElseGet(Main::generateDefaultCity);
    }

    public static void test3(String city) {
        // 如果city为空，则抛出空指针异常。
        String defaultCity = Optional.of(city).orElseThrow(NullPointerException::new);
    }
    private static String generateDefaultCity() {
        return "beijing";
    }


}





