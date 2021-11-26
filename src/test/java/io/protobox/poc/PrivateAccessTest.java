package io.protobox.poc;

import io.protobox.poc.sub.SubpackageSubclass;
import io.protobox.poc.sub.SubpackageNonSubclass;

import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class PrivateAccessTest {

    private PackageSibling packageSibling;
    private PackageSubclass packageSubclass;
    private SubpackageSubclass subpackageSubclass;
    private SubpackageNonSubclass subpackageNonSubclass;

    @BeforeTest
    public void setUp() {
        packageSibling = new PackageSibling();
        packageSubclass = new PackageSubclass();
        subpackageSubclass = new SubpackageSubclass();
        subpackageNonSubclass = new SubpackageNonSubclass();
    }
       
    @Test ( expectedExceptions = {IllegalAccessException.class} )
    public void expect_PackageSibling_to_throw_IllegalAccessException() throws Exception {
       packageSibling.usePrivateMethod(); 
    }
   
    @Test ( expectedExceptions = {IllegalAccessException.class} )
    public void expect_PackageSubclass_to_throw_IllegalAccessException() throws Exception {
       packageSubclass.usePrivateMethod(); 
    }
   
    @Test ( expectedExceptions = {IllegalAccessException.class} )
    public void expect_SubpackageSubclass_to_throw_IllegalAccessException() throws Exception {
        subpackageSubclass.usePrivateMethod(); 
    }
   
    @Test ( expectedExceptions = {IllegalAccessException.class} )
    public void expect_SubpackageNonSubclass_to_throw_IllegalAccessException() throws Exception {
        subpackageNonSubclass.usePrivateMethod(); 
    }
}
