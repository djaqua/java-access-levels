package io.protobox.poc.sub;

import io.protobox.poc.Foo;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class SubpackageNonSubclass {

    private Foo foo;

    public SubpackageNonSubclass() {
        this.foo = new Foo();
    }

    public void usePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPrivateMessage = getFooMethod( "getPrivateMessage" );
        String privateMessage = (String) getPrivateMessage.invoke( this.foo );        
    }

    public void usePackagePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPackagePrivateMessage = getFooMethod( "getPackagePrivateMessage" );
        String packageProtectedMessage = (String) getPackagePrivateMessage.invoke( this.foo );        
    }

    public void useProtectedMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getProtectedMessage = getFooMethod( "getProtectedMessage" );
        String protectedMessage = (String) getProtectedMessage.invoke( this.foo );        
    }

    public void usePublicMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPublicMessage = getFooMethod( "getPublicMessage" );
        String publicMessage = (String) getPublicMessage.invoke( this.foo );        
    }

    private Method getFooMethod(String methodName) throws NoSuchMethodException {
        return foo.getClass().getDeclaredMethod( methodName );
    }
}


