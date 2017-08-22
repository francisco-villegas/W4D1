package com.example.francisco.w4d1week;

/**
 * Created by FRANCISCO on 21/08/2017.
 */

public class Main {

    Dependency dependency;

    //constructor dependency -- when a class constructor initializes the dependency
    public Main(Dependency dependency) {
        this.dependency = dependency;
    }

    //inject dependency -- when a method initializes a dependency
    public String getManipulatedString(String s){
        dependency = new Dependency();

        String manipulatedString;
        manipulatedString = dependency.getString("Jhon");
        return manipulatedString;

    }
}
