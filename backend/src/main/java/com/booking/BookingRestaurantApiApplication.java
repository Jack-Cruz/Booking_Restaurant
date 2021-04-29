package com.booking;

import com.booking.entities.Student;
import com.booking.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookingRestaurantApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingRestaurantApiApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            Student maria=new Student(
                    "Maria",
                    "Jones",
                    "maria.jones@upc.pe",
                    21
            );

            Student maria2=new Student(
                    "Maria",
                    "Jones",
                    "maria2.jones@upc.pe",
                    25
            );

            Student ahmed=new Student(
                    "Ahmed",
                    "Ali",
                    "ahmed.ali@upc.pe",
                    18
            );
           /* studentRepository.saveAll(List.of(maria,ahmed,maria2));

            studentRepository
                    .findStudentByEmail("ahmed.ali@upc.pe")
                    .ifPresentOrElse(
                            System.out::println,
                            ()-> System.out.println("Student NotFound")
                    );

            studentRepository.selectStudentWhereFirtsNameAndAgeGreaterOrEquals(
                    "Maria",
                    21
            ).forEach(System.out::println);

            studentRepository.selectStudentWhereFirtsNameAndAgeGreaterOrEqualsNative(
                    "Maria",
                    21
            ).forEach(System.out::println);

            System.out.println("Deleting Maria 2");
            System.out.println(studentRepository.deleteStudentById(4L));*/


        } ;
    }
}
