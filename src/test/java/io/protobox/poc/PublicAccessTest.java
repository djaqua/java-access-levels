package io.protobox.poc;

import io.protobox.poc.sub.SubpackageSubclass;
import io.protobox.poc.sub.SubpackageNonSubclass;

import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class PublicAccessTest {

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
       
    @Test
    public void expect_PackageSibling_to_succeed() {
        try {
            packageSibling.useProtectedMethod(); 
        }
        catch (Exception exc) {
            Assert.fail("PackageSibling threw " + exc.getClass().getName());
        }
    }
   
    @Test
    public void expect_PackageSubclass_to_succeed() {
        try {
            packageSubclass.useProtectedMethod(); 
        }
        catch (Exception exc) {
            Assert.fail("PackageSubclass threw " + exc.getClass().getName());
        }
    }
 
    @Test
    public void expect_SubpackageSubclass_to_succeed() {
        try {
            subpackageSubclass.useProtectedMethod(); 
        }
        catch (Exception exc) {
            Assert.fail("SubpackageSubclass threw " + exc.getClass().getName());
        }
    }

    @Test
    public void expect_SubpackageNonSubclass_to_succeed() {
        try {
            subpackageNonSubclass.usePublicMethod(); 
        }
        catch (Exception exc) {
            Assert.fail("SubpackageNonSubclass threw " + exc.getClass().getName());
        }
    }
}
