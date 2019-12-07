package com.jc.javabase.java.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.ProtectionDomain;
import java.util.stream.Stream;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-10
 */
@Slf4j
public class ReflectionApiService {

    public void reflection(ReflectionVO reflectionVO) {
//        ReflectionVO reflectionVO = new ReflectionVO();
        Class<? extends Object> productClazz = reflectionVO.getClass();
        log.info("当前的clazz = {}", productClazz);

        Field[] fields = productClazz.getDeclaredFields();
        Stream.of(fields).forEach(x -> {
            log.info("************字段 = {} *****************", x.getName());
            log.info("x name = {}, x = {}", x.getName(), x);
            x.setAccessible(true);
            Class<?> declaringClass = x.getDeclaringClass();
            log.info("getDeclaringClass() 返回表示类或接口的 Class 对象 = {}", declaringClass);
            Type genericType = x.getGenericType();
            log.info("getGenericType() 返回一个 Type 对象，它表示此 Field 对象所表示字段的声明类型 = {}", genericType);
            int modifiers = x.getModifiers();
            log.info("getModifiers() 以整数形式返回由此 Field 对象表示的字段的 Java 语言修饰符 = {}", modifiers);
            Class<?> type = x.getType();
            log.info("getType() 返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型 = {}", type);
            try {
                getTypeDetails(type);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            boolean enumConstant = x.isEnumConstant();
            log.info("isEnumConstant() 如果此字段表示枚举类型的元素，则返回 true；否则返回 false = {}", enumConstant);
            boolean synthetic = x.isSynthetic();
            log.info("isSynthetic() 如果此字段是复合字段，则返回 true；否则返回 false = {}", synthetic);
        });
        log.info("获取当道fields = {}", fields);
    }

    private void getTypeDetails(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        log.info("  ***** clazz ****");

        String canonicalName = clazz.getCanonicalName();
        log.info("  getCanonicalName() 返回 Java Language Specification 中所定义的底层类的规范化名称 = {}", canonicalName);
        Class<?>[] classes = clazz.getClasses();
        log.info("  getClasses() 返回一个包含某些 Class 对象的数组，这些对象表示属于此 Class 对象所表示的类的成员的所有公共类和接口 = {}", classes);
        ClassLoader classLoader = clazz.getClassLoader();
        log.info("  getClassLoader() 返回该类的类加载器 = {}", classLoader);
        Class<?> componentType = clazz.getComponentType();
        log.info("  getComponentType() 返回表示数组组件类型的 Class = {}", componentType);
        Constructor<?>[] constructors = clazz.getConstructors();
        log.info("  getConstructors() 返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法 = {}", constructors);
        Class<?>[] declaredClasses = clazz.getDeclaredClasses();
        log.info("  getDeclaredClasses() 返回 Class 对象的一个数组，这些对象反映声明为此 Class 对象所表示的类的成员的所有类和接口 = {}", declaredClasses);
        Class<?> declaringClass = clazz.getDeclaringClass();
        log.info("  getDeclaringClass() 如果此 Class 对象所表示的类或接口是另一个类的成员，则返回的 Class 对象表示该对象的声明类 = {}", declaringClass);
        Object[] enumConstants = clazz.getEnumConstants();
        log.info("  getEnumConstants() 如果此 Class 对象不表示枚举类型，则返回枚举类的元素或 null = {}", enumConstants);
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        log.info("  getGenericInterfaces() 返回表示某些接口的 Type，这些接口由此对象所表示的类或接口直接实现 = {}", genericInterfaces);
        Type genericSuperclass = clazz.getGenericSuperclass();
        log.info("  getGenericSuperclass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type = {}", genericSuperclass);
        Class<?>[] interfaces = clazz.getInterfaces();
        log.info("  getInterfaces() 确定此对象所表示的类或接口实现的接口 = {}", interfaces);
        int modifiers = clazz.getModifiers();
        log.info("  getModifiers() 返回此类或接口以整数编码的 Java 语言修饰符 = {}", modifiers);
        String name = clazz.getName();
        log.info("  getName() 以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称 = {}", name);
        Package aPackage = clazz.getPackage();
        log.info("  getPackage() 获取此类的包 = {}", aPackage);
        ProtectionDomain protectionDomain = clazz.getProtectionDomain();
        log.info("  getProtectionDomain() 返回该类的 ProtectionDomain = {}", protectionDomain);
        Object[] signers = clazz.getSigners();
        log.info("  getSigners() 获取此类的标记 = {}", signers);
        String simpleName = clazz.getSimpleName();
        log.info("  getSimpleName() 返回源代码中给出的底层类的简称 = {}", simpleName);
        Class<?> superclass = clazz.getSuperclass();
        log.info("  返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class = {}", superclass);
        boolean anEnum = clazz.isEnum();
        log.info("  当且仅当该类声明为源代码中的枚举时返回 true = {}", anEnum);
        boolean anInterface = clazz.isInterface();
        log.info("  判定指定的 Class 对象是否表示一个接口类型 = {}", anInterface);
        boolean localClass = clazz.isLocalClass();
        log.info("  当且仅当底层类是本地类时返回 true = {}", localClass);
        boolean memberClass = clazz.isMemberClass();
        log.info("  当且仅当底层类是成员类时返回 true = {}", memberClass);
        boolean primitive = clazz.isPrimitive();
        log.info("  判定指定的 Class 对象是否表示一个基本类型 = {}", primitive);
        boolean synthetic = clazz.isSynthetic();
        log.info("  如果此类是复合类，则返回 true，否则 false = {}", synthetic);
//        Object o = clazz.newInstance();
//        log.info("  创建此 Class 对象所表示的类的一个新实例 = {}", o);
    }
}
