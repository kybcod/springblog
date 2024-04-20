package com.springblog.controller;

import com.springblog.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {

//     직접
//    Animal animal = new Animal();

    private final Animal animal;

    // 생성자 주입
    @Autowired
    public Zoo(Animal animal) {
        this.animal = animal;
    }


//    //    setter 주입
//    private Animal animal;
//
//    @Autowired
//    public void setAnimal(Animal animal) {
//        this.animal = animal;
//    }


}

class ZooTest {
    public static void main(String[] args) {

        Animal animal = new Animal("호랑이", 13);
        Zoo zoo = new Zoo(animal);


//        // 먼저 Zoo 객체 생성
//        // Animal 객체 생성 후 Setter 메서드를 통해 주입
//        Zoo zoo = new Zoo();
//        Animal animal = new Animal();
//        animal.setName("코끼리");
//        animal.setAge(10);
//        zoo.setAnimal(animal);


    }
}

