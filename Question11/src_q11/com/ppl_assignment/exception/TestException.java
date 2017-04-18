package com.ppl_assignment.exception;

public class TestException extends Throwable {
    public TestException(String test){
        System.out.println("Exception Test "+test);
    }
}
