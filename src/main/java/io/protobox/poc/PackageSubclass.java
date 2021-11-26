package io.protobox.poc;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class PackageSubclass extends Foo {

    public void usePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPrivateMessage = getSuperclassMethod( "getPrivateMessage" );
        String privateMessage = (String) getPrivateMessage.invoke(this);        
    }

    public void useProtectedMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getProtectedMessage = getSuperclassMethod( "getProtectedMessage" );
        String protectedMessage = (String) getProtectedMessage.invoke(this);        
    }

    public void usePackagePrivateMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPackagePrivateMessage = getSuperclassMethod( "getPackagePrivateMessage" );
        String packageProtectedMessage = (String) getPackagePrivateMessage.invoke(this);        
    }

    public void usePublicMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPublicMessage = getSuperclassMethod( "getPublicMessage" );
        String publicMessage = (String) getPublicMessage.invoke(this);        
    }

    private Method getSuperclassMethod(String methodName) throws NoSuchMethodException {
        return getClass().getSuperclass().getDeclaredMethod( methodName );
    }
}


