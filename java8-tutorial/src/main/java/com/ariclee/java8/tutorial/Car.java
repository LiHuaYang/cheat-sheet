package com.ariclee.java8.tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author lihy
 * @version 1.0  2019/11/12
 */
public class Car {


    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired  " + this.toString());
    }


    public static void main(String[] args) {
        // 构造器引用
        final Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        // 静态方法引用
        cars.forEach(Car::collide);
        // 类成员方法引用
        cars.forEach(Car::repair);
        // 某个实例对象的成员方法的引用
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
