package com.ylch.test.jdk_class_test.safeVarargs;

/**
 * Created by yanglaichang1 on 2017/7/17.
 *
 *
 * 1.6　优化变长参数的方法调用

 J2SE 5.0中引入的一个新特性就是允许在方法声明中使用可变长度的参数。一个方法的最后一个形式参数可以被指定为代表任意多个相同类型的参数。在调用的时候，这些参数是以数组的形式来传递的。在方法体中也可以按照数组的方式来引用这些参数。代码清单1-21给出了一个简单的示例，对多个整数进行求和。可以用类似sum(1, 2, 3)这样的形式来调用此方法。

 代码清单1-21　变长参数方法的示例

 public int sum(int... args) {
 int result = 0;
 for (int value : args) {
 result += value;
 }
 return result;
 }
 可变长度的参数在实际开发中可以简化方法的调用方式。但是在Java 7之前，如果可变长度的参数与泛型一起使用会遇到一个麻烦，就是编译器产生的警告过多。比如代码清单1-22中给出的方法。

 代码清单1-22　使用泛型的变长参数方法产生编译器警告的示例

 public static <T> T useVarargs(T... args) {
 return args.length > 0 ? args[0] : null;
 }
 如果参数传递的是不可具体化（non-reifiable）的类型，如List<String>这样的泛型类型，会产生警告信息。每一次调用该方法，都会产生警告信息。比如在Java 7之前的编译器上编译代码清单1-23中的代码，编译器会给出警告信息。如果希望禁止这个警告信息，需要使用@SuppressWarnings("unchecked")注解来声明。

 代码清单1-23　调用使用泛型的变长参数方法的示例

 VarargsWarning.useVarargs(new ArrayList<String>());
 这其中的原因是可变长度的方法参数的实际值是通过数组来传递的，而数组中存储的是不可具体化的泛型类对象，自身存在类型安全问题。因此编译器会给出相应的警告信息。关于泛型的内容，本书的第12章会详细介绍，这里就不再赘述。

 这样的警告信息在使用Java标准类库中的java.util.Arrays类的asList和java.util.Collections类的addAll方法中也会遇到。建议开发人员每次使用方法时都抑制编译器的警告信息，并不是一个好主意。为了解决这个问题，Java 7引入了一个新的注解@SafeVarargs。如果开发人员确信某个使用了可变长度参数的方法，在与泛型类一起使用时不会出现类型安全问题，就可以用这个注解进行声明。在使用了这个注解之后，编译器遇到类似的情况，就不会再给出相关的警告信息，如代码清单1-24所示。

 代码清单 1-24　使用@SafeVarargs注解抑制编译器警告的示例

 @SafeVarargs
 public static <T> T useVarargs(T... args) {
 return args.length > 0 ? args[0] : null;
 }
 @SafeVarargs注解只能用在参数长度可变的方法或构造方法上，且方法必须声明为static或final，否则会出现编译错误。一个方法使用@SafeVarargs注解的前提是，开发人员必须确保这个方法的实现中对泛型类型参数的处理不会引发类型安全问题。
 */
public class SafeVarargsTest {

    @SafeVarargs
    public SafeVarargsTest(Class... plugins) {

    }

    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }


}
