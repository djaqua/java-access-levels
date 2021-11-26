package io.protobox.poc;

public class Foo {

    /*
        Neither package siblings nor subclasses should be able to access this method
    */
    private String getPrivateMessage() {
        return "Hello, self!";
    }

    /* 
        Only package siblings should be able to access this method
    */
    String getPackagePrivateMessage() {
        return "Hello, package siblings!";
    }

    /*
        Only package siblings and subclasses should be able to access this method 
    */
    protected String getProtectedMessage() {
        return "Hello, package siblings and subclasses!";
    }

    /*
        No access restrictions
    */
    public String getPublicMessage() {
        return "Hello, world!";
    }
}
