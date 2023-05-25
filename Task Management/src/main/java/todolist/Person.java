package todolist;

import lombok.Data;

@Data
public class Person {
    String name;
    int age;

    Address[] addresses;
  
    // Getters and setters (or lombok annotations) go here
  }
