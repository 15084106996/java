---
typora-root-url: assets
typora-copy-images-to: assets
---

## JavaSE

### 1.JDK的下载与安装

#### 1.1 下载安装

[oracle官方下载](https://www.oracle.com/java/technologies/javase-downloads.html)

安装后目录如下

jdk: java developer kit java开发包，开发java的必备软件

jre: java runtime environmentjava运行时环境，运行java程序的

bin: 存放可执行的二进制文件、

lib: 库文件，架包

![1608518343471](/1608518343471.png)

#### 1.2 配置环境变量

![1608519624836](/1608519624836.png)

![1608519650651](/1608519650651.png)

![1608519751998](/1608519751998.png)

![1608520001453](/1608520001453.png)

![1608520200706](/1608520200706.png)

一路确定退出

### 2.Java语言简介

#### 2.1 跨平台

一种编程语言：跨平台

Java是如何实现跨平台的：**半编译半解释**

平台：硬件（cpu）+软件（操作系统）

C语言是将代码直接编译成底层平台识别的机器码，效率较高

**半编译半解释**：Java是将代码编译成一种中间格式文件（字节码文件,.class文件），Java提供了JVM（java虚拟机），专门用来执行字节码文件，JVM针对不同的平台，能够翻译出不同的机器码

#### 2.2 面向对象的语言

##### 2.2.1 继承（extends）

###### 概念

一个类可以从一个现有类中派生出来，“现有类”称为父类（超类，基类），派生出来的类称为“子类”，**子类拥有父类的所有属性和方法（不包括构造器和私有成员）**

> 注意：java中是单继承（一个类只能有一个直接父类，一个类可以有无数子类）

###### 作用

+ 1.代码复用
+ 2.子类是可以添加自己独有的属性和方法，从而扩展内容（开闭原则：对拓展开放，对修改关闭）

###### 创建子类对象的过程

**创建子类对象时，子类构造器会默认优先调用父类的无参构造器创建父类对象，然后再走子类构造器创建子类对象**

**如果父类没有无参构造器，只能再子类构造器中显式的调用（使用super）具体的有参构造器**

```java
public class Person {}
```

```java
public class Student extends Person{}
```

```java
public class Test {
    public static void main(String[] args) {
        // 创建子类:父类对象是否创建？是
        Student s = new Student();
    }
}
```

super,this

> super.方法
>
> super.属性
>
> this.方法
>
> this.属性
>
> super() 调用的是父类的无参构造器
>
> this() 

###### 方法重写

方法重写（运行时多态，override）：子类中与父类同名同参同返回值的方法

方法重载（编译时多态，静态多态，overload）：一个类中同名不同参的方法

###### final

+ 1.修饰类，不能被继承
+ 2.修饰方法，可以继承，不能重写
+ 3.修饰变量，常量，不能修改



##### 2.2.2 封装

###### 概念

利用不同的访问权限修饰符，将一组属性和方法装到一个类中，将一组代码装入一个方法，都可以理解封装

| 修饰符修饰属性和方法 | 当前类 | 当前包 | 其它包子类 | 其他包非子类 |
| -------------------- | ------ | ------ | ---------- | ------------ |
| public               | √      | √      | √          | √            |
| protected            | √      | √      | √          |              |
| 默认                 | √      | √      |            |              |
| private              | √      |        |            |              |

public和默认可以修饰类

一个类如果有无参的构造器：实体类（JavaBean）

一般情况下，实体类都有公有的getter和setter方法，属性都是**私有**的

##### 2.2.3 多态

###### 概念

物理：一个事物的不同形态

代码：在java中多态有两种体现（重写重载），一个方法的不同实现

编程：一种编程策略（1.泛化（继承或实现）关系，2.方法重写，3.上溯造型）

###### 作用

解耦（降低程序的耦合），拓展维护性强

###### instanceof

###### 上溯造型（向上转型）

父类引用指向子类对象

```java
public class Parent {}
```

```java
public class Child extends Parent {}
```

```java
public class Test {
    public static void main(String[] args) {
        // 父类引用指向子类对象
        Parent p = new Child();
    }
}
```

**父类引用无法调用子类独有的属性和方法**

###### 下溯造型（向下转型）

强转



##### 2.2.4 抽象(abstract)

###### 概念

“概念化”能力，即抽象能力

编程：比如抽象类，接口等等都是抽象的典型体现

**抽象类：不能创建对象(有构造器)**

虽然能定义以往的普通方法，但变得没有意义，因为无法创建对象，也就无法调用

```java
public abstract class Person {
    // 抽象方法只能在抽象类中定义
    public abstract void buyTicket();
    // 可以写，但没有用
    public void test(){}
}
```

**作用：作为父类，规范子类有哪些内容**

如果一个类继承了一个抽象类，必须实现它的抽象方法

**接口 (interface)：对单继承的一种弥补**

```java
public interface InterA {
    void test1();
    int test2();
    double test3(String name);
}
```

实现接口:**实现类必须重写所有方法**

```java
public class InterAImpl implements InterA{}
```

接口是可以多实现的

```java
public class InterAImpl implements InterA,InterB{}
```

如果又继承，又需要实现

```java
public class InterAImpl extends Parent implements InterA,InterB{}
```

+ 1.不能创建对象（没有构造器）

+ 2.接口中只能定义抽象方法，因为方法前面有默认的关键字 `public abstract`
+ 3.接口中只能定义常量(很少使用)，因为属性前面有默认的关键字 `public static final`

>接口和抽象类不能创建对象
>
>抽象类又构造器，接口没有
>
>抽象类可以定义非抽象成员，接口中只能定义抽象方法和常量
>
>类是单继承的，接口是可以多实现的，接口与接口是多继承



### 3.第一个Java程序

```java
package org.neuedu.chapter01;

/**
 * 文档注释
 * HelloWorld
 *  20班第一个源程序
 */
public class HelloWorld {
    public static void main(String[] args) {
        // 单行注释
        /*
            多行
            注释
        */
        System.out.println("100");
    }
}
```

| 关键字                              | 含义                 |
| ----------------------------------- | -------------------- |
| public                              | 公有                 |
| class                               | 类                   |
| {}                                  | 块                   |
| static                              | 静态                 |
| void                                | 没有返回值           |
| main                                | main方法，程序的入口 |
| System.out.println("hello world1"); | 打印                 |

### 4.变量及运算符

#### 4.1 标识符：一切需要开发人员自己起名字的

| 类别         | 规范                               | 举例                 |
| ------------ | ---------------------------------- | -------------------- |
| 类名         | 每个单词首字母大写                 | Demo,HelloWorld      |
| 方法名、变量 | 第一个单词小写，其余单词首字母大写 | main,getMaxAge       |
| 包名         | 全小写                             | org.neuedu.chapter01 |
| 常量         | 全大写                             | MAX_AGE              |

规则：

1. 标识符必须以字母、下划线（_）、数字或美元（$）组成；
2. 标识符必须由字母、下划线（_）或美元（$）开头，不能由数字开头；
3. 标识符不能是关键字或者保留字；
4. 标识符中不能有空格;
5. 标识符没有长度限制。

#### 4.2 数据类型

+ 1.基本数据类型（4类8种）
  + 1.1 整型 ： byte（1字节）,short（2字节）,int（4字节）,long（8字节）

    | 类型  | 范围          |
    | ----- | ------------- |
    | byte  | -2^7--2^7-1   |
    | short | -2^15--2^15-1 |
    | int   | -2^31--2^31-1 |
    | long  | -2^63--2^63-1 |

    ```java
    public class Demo03 {
        public static void main(String[] args) {
            int num1 = 0b10101;
            int num2 = 024;
            int num3 = 0x6A;
        }
    }
    ```

  + 1.2 浮点型 : float,double

  + 1.3 字符型 : char

  + 1.4 布尔型 : boolean
+ 2.引用数据类型
  + 2.1 类
  + 2.2 接口
  + 2.3 数组

#### 4.3 作用域

作用域：变量的有效范围（从声明位置开始，到它所在块结束）

在同一个块内，不允许声明同名的变量

#### 4.4 类型转换

+ 1.自动类型转换

![1608607419284](/1608607419284.png)

+ 2.强制类型转换

  ```java
  // 有损失精度的风险
  int num3 = 200;
  byte num4 = (byte)num3;
  ```

#### 4.5 运算符

算术运算符：+，-，*，/，%，++，--

赋值运算符：=，+=，-=，*=，/=，%=

```java
public class Demo12 {
    public static void main(String[] args) {
        // 赋值运算符
        int num = 100;
        num+=10;
        System.out.println(num);// 110
        num-=20;
        System.out.println(num);// 90
        num*=2;
        System.out.println(num);// 180
        num /= 3;
        System.out.println(num);// 60
        num %= 2;
        System.out.println(num);// 0
    }
}
```

关系运算符：>,>=,<,<=,!=,==

逻辑运算符：&&，||，!

位运算符：&，|，^

> 位运算符与逻辑运算符区别,&,| 和 && ,||
> && ,||有短路性
> &,|能够针对二进制数据运算

```java
public class Demo18 {
    public static void main(String[] args) {
        System.out.println(5&3);// 1 有0则0；
        /*
            5   101
            3   011
            --------
            1   001
         */
        System.out.println(5|3);// 7 有1则1；
        /*
            5   101
            3   011
            --------
            7   111
         */
        System.out.println(5^3);// 6 相同则0不同则1；
        /*
            5   101
            3   011
            --------
            6   110
         */
    }
}
```

三元(三目)运算符

```java
public class Demo20 {
    public static void main(String[] args) {
        // 三元运算符
        // 判断表达式 ? 表达式1 : 表达式2
        // 如果 判断表达式 成立，取 表达式1，否则取 表达式2
        System.out.println(5%2==0?"偶数":"奇数");
        int x = 100;
        int y = 60;
        System.out.println(x > y?"x大":"y大");
    }
}
```

#### 小结：

+ 1.标识符的命名规范
+ 2.数据类型：基本数据类型（4类8种），引用数据类型
+ 3.变量的声明及使用
+ 4.类型转换（自动转换，强转）
+ 5.`final int NUM = 10;`

### 5.流程控制语句

#### 5.1 条件判断

+ 1.if

+ 2.if...else

+ 3.if...else if..else

+ 4.switch

  ```java
  public class Demo06 {
      public static void main(String[] args) {
          // switch
          // 1.break
          // 2.case 不能重复
          // jdk8之前： 只支持byte,short,char,int
          String num = "1";
          switch (num){
              case "1":
                  System.out.println("hello1");
                  break;
              case "2":
                  System.out.println("hello2");
                  break;
              case "3":
                  System.out.println("hello3");
                  break;
              case "10":
                  System.out.println("hello10");
                  break;
              default :
                  System.out.println("helloX");
          }
      }
  }
  ```

  

#### 5.2 循环

+ 1.while(循环条件){循环体}
+ 2.do{循环体}while(循环条件) ： 至少循环一次
+ 3.for

break : 终止当前循环

continue : 跳过本次循环，执行下次循环

### 6.数组

+ 1.保存一组相同数据
+ 2.定长

#### 6.1 数组的声明

```java
public class Demo01 {
    public static void main(String[] args) {
        // 引用数据类型 ： 数组，类，接口
        // 数组能保存一组相同类型数据
        // 数组中数据称为元素
        int[] arr1 = {1, 2, 3};
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = new int[3];// 0,0,0

        String[] strArr1 = {"hello", "tom", "bob", "lucy"};
        String[] strArr2 = new String[]{"hello", "tom", "bob", "lucy"};
        String[] strArr3 = new String[4];// null,null.null,null

        boolean[] bArr1 = {true, false, true};
        boolean[] bArr2 = new boolean[]{true, false, true};
        boolean[] bArr3 = new boolean[3];// false,false,false
    }
}
```

#### 6.2 数组的访问和遍历

```java
package org.neuedu.数组.practice;

public class Prac01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8};
        // 遍历 ： 逐个访问
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

#### 6.3 数组的排序

```java
package org.neuedu.循环;

public class Demo10 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 5};
        // 冒泡排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num+" ");
        }
    }
}
```

```java
package org.neuedu.循环;

public class Demo11 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2, 5};
        // 选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
```

#### 6.4 数组拷贝

```java
package org.neuedu.ch6数组;

public class Demo13 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 源数组
        // 源数组起始索引
        // 目标数组
        // 目标数组起始索引
        // 长度
        System.arraycopy(arr1,1,arr2,2,3);
        for (int i : arr2) {
            System.out.print(i+" ");
        }
    }
}
```

#### 6.5 多维数组

```java
package org.neuedu.ch6数组.practice;

public class Prac12 {
    public static void main(String[] args) {
        // 求3x3矩阵 对角线 之和
        // [0][0] [0][2] [1][1] [2][0] [2][2]
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum = sum + arr[i][j];
                }
                if(i + j == 2){
                    sum = sum + arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
```

### 7.方法

+ 1.方法的返回值和参数的作用

+ 2.一个类中不能出现同名同参（参数的个数和类型相同）的方法

+ 3.方法重载（静态多态，编译时多态，overload）: 一个类中同名不同参数的方法

+ 4.构造方法（构造器，Constructor）：1.必须和类名一致；2.没有返回值概念

  > 构造器的作用：
  >
  > 1.创建对象；
  >
  > 2.能为对象属性初始化（赋值）
  
+ 5.方法调用堆栈 : 栈-后进先出

### 8.类和对象

#### 8.1 全局变量和局部变量

全局变量

```java
package org.neuedu.ch类和对象.demo08;

public class Demo01 {
    // 全局变量（成员变量，对象属性）有默认值
    // 基本数据类型：数字 0,boolean false
    // 引用数据类型：null
    int num;
    String name;
}

```

局部变量

```java
package org.neuedu.ch类和对象.demo08;

public class Demo01 {
    public static void main(String[] args) {
        Demo01 d1 = new Demo01();
        int num = 100;
        // 局部变量没有默认值
    }
}

```

基本数据类型：byte,short,int,long,float,double,boolean,char

引用数据类型：类，数组，接口

类相当于一种数据类型

```java
package org.neuedu.ch8类和对象;

public class Student {
    String name;
    int age;
    boolean gender;
}
```

```java
package org.neuedu.ch8类和对象;

public class Demo01 {
    public static void main(String[] args) {
        // 实例化-创建对象:如果一个类没有构造器，会默认提供一个空的无参构造器
        // 类名 变量名 = new 构造器();
        Student s1 = new Student();
        s1.name = "tom";
        s1.age = 12;
        s1.gender = false;

        Student s2 = new Student();
        s2.name = "lucy";
        s2.age = 12;
        s2.gender = false;
    }
}

```

#### 8.2 构造器和内存模型

如果一个类没有构造器，会默认提供一个空的无参构造器

```java
public class Student {
    // 全局变量（成员变量，对象属性）
    String name;
    int age;
    boolean gender;
    // 没写，也存在的无参构造器，称为默认构造器
    public Student() {}
}
```

一个类写了任意一个构造器，默认的构造器不在提供

![1609228117416](/1609228117416.png)

```java
package org.neuedu.ch类和对象.demo04;

public class Warrior {
    String name;

    public Warrior(String name) {
        this.name = name;
    }

    public Warrior() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

一个类如果有无参的构造器：实体类（JavaBean）

一般情况下，实体类都有公有的getter和setter方法，属性都是**私有**的

#### 8.3 匿名对象

```java
package org.neuedu.ch类和对象.demo08;

public class Demo02 {
    public void test() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        // 匿名对象 ： 没有引用的对象，只能用一次
        new Demo02().test();
    }
}

```

#### 8.4 自动垃圾回收机制（GC）

没有引用的对象JVM视为垃圾对象，JVM会自动调用这个对象的finalize方法，释放内存

#### 8.5 static

+ 1.能修饰方法和全局变量

+ 2.静态方法和属性可以直接通过类名进行调用

```java
public class Demo01 {
    // 静态变量（静态属性，类变量）
    static int num2;
    // 静态方法
    public static void test2() {}
}
```

```java
public class Demo01Test {
    public static void main(String[] args) {
        // 静态方法和属性可以直接通过类名进行调用
        Demo01.num2 = 200;
        Demo01.test2();
    }
}
```

+ 3.静态方法只能直接访问静态成员
+ 4.内存模型

![1610091305259](/1610091305259.png)

+ 5.单例模式（单例工厂模式）

保证一个类只能创建一个对象

作用：节省资源

```java
// 饿汉模式
public class Singleton {
    private static Singleton s = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return s;
    }
}

// 懒汉模式（懒加载）
public class Singleton {
    private static Singleton s;
    private Singleton(){}
    public static Singleton getInstance(){
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
```



### 9.异常处理

代表所有“问题”的类 `Throwable`

#### Error 错误

代码级别难以调试

#### Exception 异常

+ 1.非检查性异常：编辑器是不提示的，需要开发人员自己避免
+ 2.检查性异常：编辑器会提示，不代表写的有问题，需要开发人员处理

##### try..catch..finally

```java
public class Demo01 {
    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("D:\\test.txt");
            Class.forName("aaa");
        } catch (FileNotFoundException e) {
            System.out.println(111);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            System.out.println(100);
        }
    }
}
```

一些回收资源的操作一般放在finally中：关闭一个文件流，关闭数据库连接...

###### final,finally,finalize的区别

> final修饰类，不能继承，final修饰方法，不能重写，final修饰属性，表示常量，不能改
>
> finally一般与异常处理有关，用来执行一定要执行的代码，例如回收资源等
>
> finalize与垃圾回收有关，没有引用的对象JVM视为垃圾对象，JVM会自动调用这个对象的finalize方法，释放内存

##### throws 规避异常（向上抛出异常）

```java
public class Demo01 {
    public void test() throws ClassNotFoundException {
        Class.forName("aaa");
    }
}
```

```java
public class Test1 {
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        try {
            d.test();
        } catch (ClassNotFoundException e) {
            System.out.println(111);
        }
    }
}
```

```java
public class Test2 {
    public static void main(String[] args) {
        Demo01 d = new Demo01();
        try {
            d.test();
        } catch (ClassNotFoundException e) {
            System.out.println(222);
        }
    }
}
```

方法调用这可以对异常处理进行个性化处理



##### 自定义异常

```java
public class HeadCountsException extends Exception {}
```

##### throw

```java
public class Person {
    private int head;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        if (head != 1) {
            // 抛一个异常，HeadCountsException
            try {
                throw new HeadCountsException();
            } catch (HeadCountsException e) {
                e.printStackTrace();
            }
        }
        this.head = head;
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setHead(2);
    }
}
```

![1610352276591](/1610352276591.png)



### 10.Java API

API : 应用程序接口

java.lang : 默认导入的，不需要手动

+ 1.Object : 顶级类，所有类的父类

  > public boolean equals(Object o) : 比较两个对象是否相等
  >
  > 与 == 的区别
  >
  > 1. == 能比较基本数据类型也能比较引用数据类型，equals专门比较引用数据类型
  > 2. 但是方法是可以被重写的，一旦重写，比较规则就改变了

  > public String toString() : 包名.类名@16进制哈希值

  > public void finalize() : 垃圾回收

  > public int hashCode() : 返回10进制哈希值

  如果一个类的equals重写过，hashCode理论上也是需要重写

  如果两个对象是相等的，hashCode一定是相等的，hashCode一样，对象不一定相等

+ 2.包装类

  | 基本数据类型 | 包装类        |
  | ------------ | ------------- |
  | byte         | Byte          |
  | short        | Short         |
  | int          | **Integer**   |
  | long         | Long          |
  | float        | Float         |
  | double       | Double        |
  | boolean      | Boolean       |
  | char         | **Character** |

  - 1.可以当成基本数据类型一样去使用（引用数据类型）

    ```java
    public class Demo01 {
        public static void main(String[] args) {
            // 自动装箱
            Integer num1 = 127;
            // 自动拆箱
            int num3 = num1;
    		// jdk 1.5之前
            Integer num2 = new Integer(127);
        }
    }
    ```

  - 2.可以调用包装类方法，与字符串进行转换的方法

    ```java
    package org.neuedu.ch工具类.ch包装类;
    
    public class Demo02 {
        public static void main(String[] args) {
            String price = "400";
            System.out.println(price+100);
            int numPrice = Integer.valueOf(price);// Integer
            int numPrice3 = Integer.parseInt(price);// int
            System.out.println(numPrice+100);
            double numPrice2 = Double.valueOf(price);// Double
            double numPrice4 = Double.parseDouble(price);// double
            System.out.println(numPrice2+100);
    		// 数字转字符串
            int num = 100;
            String str1 = num + "";
            String str2 = String.valueOf(num);
            String str3 = Integer.toString(num);
        }
    }
    
    ```

+ 3.字符串类

  - 1.String : 字符串常量，对其的修改其实是在常量池新创建了一个字符串

    ![1610421944926](/1610421944926.png)

    所以比较字符串，必须用equals方法比较，不能用 == 

    ```java
    public class Demo02 {
        public static void main(String[] args) {
            String str1 = "hello";
            // public int length() 返回长度
            System.out.println(str1.length());// 5
            
            // public String substring(int begin) 从起始索引截取
            // public String substring(int begin,int end) 从起始索引，截取到结束索引之前
            System.out.println(str1.substring(1));// ello
            System.out.println(str1.substring(1,4)); // ell
            
            // public int indexOf(String str) 返回 参数 在原有字符串中 第一次 出现的位置
            System.out.println(str1.indexOf("l"));// 2
            // public int lastIndexOf(String str) 返回 参数 在原有字符串中 最后一次 出现的位置
            System.out.println(str1.lastIndexOf("l"));// 3
        }
    }
    ```

    ```java
    public class Demo03 {
        public static void main(String[] args) {
            String str1 = "hello";
            // publi char charAt(int index) 返回 指定 索引处的字符
            System.out.println(str1.charAt(4));
            
            // public char[] toCharArray() 返回字符串的字符数组
            char[] arr = str1.toCharArray(); // {'h','e','l','l','o'}
            System.out.println(Arrays.toString(arr));
            
            // public String[] spilt(String str) 将字符串按照参数分割成一个数组
            String str2 = "辽宁^湖北^新疆";
            String[] strArr = str2.split("\\^");
            System.out.println(Arrays.toString(strArr));
        }
    }
    ```

    ```java
    public class Demo04 {
        public static void main(String[] args) {
            String str1 = "hello";
            String str2 = "Hello";
            // public boolean equals(String str) 比较字符串是否相等
            System.out.println(str1.equals(str2));// false
            
            // public boolean equalsIgnoreCase(String str) 比较字符串是否相等(忽略大小写)
            System.out.println(str1.equalsIgnoreCase(str2));// true
            
            // public boolean contains(String str) : 判断字符串是否包含一个子字符串
            System.out.println(str1.contains("ell"));// true
            
            // public boolean startsWith(String str) : 是否以xx开头
            System.out.println(str1.startsWith("app"));//false
            
            // public boolean endsWith(String str): 是否以xx结尾
            System.out.println(str1.endsWith("llo"));//true
            
            // public String concat(String str)
            System.out.println(str1.concat(" world"));
        }
    }
    ```

  - 2.StringBuffer,StringBuilder：字符串变量，对其的修改都是在原有基础上进行的，不创建新的字符串

    程序：一个软件

    进程：一个正在运行的软件

    线程：进程中的进程

    区别：StringBuffer是线程安全（数据同步）的，多线程操作使用

    ​		   StringBuilder是线程不安全（数据有可能不同步）的，单线程操作，效率高
    
    ```java
    public class Demo05 {
        public static void main(String[] args) {
            StringBuilder sbf = new StringBuilder("hello");
            String str1 = sbf.toString();
    //        sbf.append(" world");
    //        System.out.println(sbf);
    //        sbf.reverse();
    //        System.out.println(sbf);
    
            StringBuilder sbf1 = new StringBuilder("hello");
            String str2 = sbf1.toString();
            System.out.println(sbf1.equals(sbf));// false
            System.out.println(str1.equals(str2));// false
            System.out.println(sbf.toString().equals(sbf1.toString()));// true
        }
    }
    ```

+ 4.Math类

  ```java
  package org.neuedu.ch工具类.ch数学类;
  
  public class Demo01 {
      public static void main(String[] args) {
          // Math 静态方法
          // 随机数 [0,1)
          System.out.println(Math.random());
          // 向上取整
          System.out.println(Math.ceil(5.1));
          // 向下取整
          System.out.println(Math.floor(5.9));
          // 四舍五入
          System.out.println(Math.round(5.5));
          // 取绝对值
          System.out.println(Math.abs(-9.9));
          // 取两个之中较大的值
          System.out.println(Math.max(5,6));
          // 取两个之中较小的值
          System.out.println(Math.min(5,6));
      }
  }
  ```

  ```java
  public class Demo02 {
      public static void main(String[] args) {
          // 1-100
          int random = (int)(Math.random()*100+1);// [1,101)
  
          // Random 类
          Random r = new Random();
          int num = r.nextInt(100)+1;// [1,101)
          System.out.println(num);
      }
  }
  ```

+ 5.日期类

  - 1.Date

    ```java
    public class Demo01 {
        public static void main(String[] args) {
            Date date = new Date();
            System.out.println(date);
            // 时间戳 -- 1970-01-01 00：00：00 - 现在 经过的 毫秒数
            long time = date.getTime();
            System.out.println(time);
    
            Date date1 = new Date(1610504484384L);
            System.out.println(date1);
            // 过时方法
            System.out.println(date1.toLocaleString());
        }
    }
    ```

  - 2.Calendar

    ```java
    public class Demo02 {
        public static void main(String[] args) {
            Date d = new Date();
            System.out.println(d);
    		// Calendar 是抽象类，不能直接创建对象
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            System.out.println(date);
            System.out.println(date.getTime());
            System.out.println(calendar.getTime().getTime());
        }
    }
    ```

    ```java
    public class Demo03 {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar);
            calendar.set(2007,7,8,12,13,14);
            System.out.println(calendar.get(Calendar.YEAR));
            System.out.println(calendar.get(Calendar.MONTH)+1);// 月份0是1月
            System.out.println(calendar.get(Calendar.DATE));
            System.out.println(calendar.get(Calendar.HOUR));// 12进制
            System.out.println(calendar.get(Calendar.HOUR_OF_DAY));// 24进制
            System.out.println(calendar.get(Calendar.MINUTE));
            System.out.println(calendar.get(Calendar.SECOND));
            System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println(calendar.get(Calendar.DAY_OF_WEEK));// 1周日-7周六
        }
    }
    ```

    ```java
    public class Demo04 {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR,1);
            System.out.println(calendar.get(Calendar.YEAR));
        }
    }
    ```

    ```java
    public class Demo05 {
        public static void main(String[] args) {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(2008,7,8,12,13,14);
    
            Calendar calendar2 = Calendar.getInstance();
            if (calendar1.before(calendar2)) {
                System.out.println("第1个日期早");
            }else{
                System.out.println("第2个日期早");
            }
            if (calendar2.after(calendar1)) {
                System.out.println("第1个日期早");
            }else{
                System.out.println("第2个日期早");
            }
        }
    }
    ```

    

+ 6.日期转换类SimpleDateFormat

  日期和字符串的转换

  ```java
  public class Demo06 {
      public static void main(String[] args) {
          Date date = new Date();
          // yyyy  完整的年份
          // MM 数字月份
          // dd 日期
          // HH/hh 24进制/12进制
          // mm 分钟
          // ss 秒
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String str = sdf.format(date);
          System.out.println(str);
  
          String str1 = "2020-11-03 12:13:14";
          try {
              Date date1 = sdf.parse(str1);
              System.out.println(date1);
          } catch (ParseException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  ```java
  package org.neuedu.ch工具类.ch日期类;
  
  import java.text.ParseException;
  import java.text.SimpleDateFormat;
  import java.util.Calendar;
  import java.util.Date;
  import java.util.Scanner;
  
  public class Practice02 {
  
      public static int getWeek(Calendar calendar) {
          int num = calendar.get(Calendar.DAY_OF_WEEK);
          if (num == 1) {
              return 7;
          }else{
              return num - 1;
          }
      }
  
      public static void main(String[] args) throws ParseException {
          // 周一到周日上下午
          // 1 - 需要上班
          // 0 - 没班
          String rules = "11111111110000";
          Scanner scanner = new Scanner(System.in);
          System.out.println("起始日期");// 2021-1-13
          String str1 = scanner.nextLine();
          System.out.println("结束日期");// 2021-2-4
          String str2 = scanner.nextLine();
  
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date date1 = sdf.parse(str1);
          Date date2 = sdf.parse(str2);
  
          Calendar begin = Calendar.getInstance();
          begin.setTime(date1);
          Calendar end = Calendar.getInstance();
          end.setTime(date2);
          end.add(Calendar.DATE, 1);
  
          while (begin.before(end)) {
              // 判断 begin 是周几
              int week = getWeek(begin);
              // 根据 周几 和 rules 决定 打印上班还是打印休息
              int year = begin.get(Calendar.YEAR);
              int month = begin.get(Calendar.MONTH) + 1;
              int date = begin.get(Calendar.DATE);
              String strDate = year + "-" + month + "-" + date;
              if (rules.charAt(2 * week - 2) == '1') {
                  System.out.println(strDate+" 上午上班");
              }else{
                  System.out.println(strDate+" 上午休息");
              }
              if (rules.charAt(2 * week - 1) == '1') {
                  System.out.println(strDate+" 下午上班");
              }else{
                  System.out.println(strDate+" 下午休息");
              }
              begin.add(Calendar.DATE, 1);
          }
      }
  }
  ```

  

### 11.集合

数组：能保存一组元素，类型必须相同，定长

集合：能保存一组元素（引用数据类型），类型可以不同，长度自动扩容

![1610593021110](/1610593021110.png)

**ArrayList是基于数组实现的，创建一个ArrayList集合，内部其实是创建了一个长度为10的Object类型数组，当元素个数超过10个，集合会自动扩容，每次扩容到原来的1.5倍**

> ```java
> public class Demo01 {
>     public static void main(String[] args) {
>         // list1 存100个元素.扩容了几次 = 6次
>         List list1 = new ArrayList();
>         // list2  扩容了几次 = 0次
>         List list2 = new ArrayList(100);
>     }
> }
> ```

**数组是一种静态线性表，内存是连续的，访问速度快，插入和删除速度比较慢**

**LinkedList是基于链表实现的，链表内存不是连续的，访问速度慢，插入和删除速度比较快**

```java
public class Demo01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0,0);
        System.out.println(list.get(2));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(4));
    }
}
```

```java
public class Demo02 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.addFirst(0);
        list.addLast(4);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
    }
}
```

泛型

```java
public class Demo06 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<String>();
    }
}
```

Set略

![1610604426682](/1610604426682.png)

key值如果重复，value会被覆盖

```java
public class Demo01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        // 添加元素
        map.put("a",1001);
        map.put(1002,1001);
        map.put(true,9.9);
        map.put("a",2000);
        Object num = map.get(true);
        System.out.println(num);
        System.out.println(map.size());
    }
}
```

```java
public class Demo02 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("java1", 12);
        map.put("java2", 22);
    }
}
```

```java
public class Demo02 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("java1", 12);
        map.put("java2", 22);
        map.put("java3", 32);
        map.put("java4", 42);
        // key 遍历
        for (String key : map.keySet()) {
            System.out.println(key+","+map.get(key));
        }

        // entry 遍历
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
```

![1610608402447](/1610608402447.png)

Java中有一个操作集合的工具类 `Collections` ，主要提供了一些静态方法操作集合，例如集合的合并，拷贝等

迭代器（Iterator）遍历集合

```java
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello1");
        list.add("hello2");
        list.add("hello3");
        list.add("hello4");

        // 获取迭代器对象
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
```

```java
public class Demo02 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("java1",1001);
        map.put("java2",1002);
        map.put("java3",1003);
        map.put("java4",1004);

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key+","+map.get(key));
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
```



### 12.JDBC

需要引入 jdbc 依赖

[Maven]( https://mvnrepository.com/ ) : 包含世界上所有的依赖

![1610679788794](/1610679788794.png)

![1610680147709](/1610680147709.png)

![1610680231328](/1610680231328.png)

![1610680285597](/1610680285597.png)

![1610680425218](/1610680425218.png)

```java
package org.neuedu.ch数据库连接JDBC.demo01;

import java.sql.*;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载 数据库 启动(将 数据库驱动类 加载进 JVM 内存)
        // 5.x com.mysql.jdbc.Driver  数据参数 useSSL=true&characterEncoding=utf-8&useUnicode=true
        // 8.x com.mysql.cj.jdbc.Driver        useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.利用 驱动管理器 获取数据库连接
        // String url       数据库连接地址   主协议:次协议://主机IP:端口号/数据库名称?数据库参数
        // String username  数据库用户       root
        // String password  用户密码         root
        String url = "jdbc:mysql://localhost:3306/jdbc_java20?useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        // 3.获取sql语句对象
        String sql = "select * from user";
        PreparedStatement statement = conn.prepareStatement(sql);
        // 4.执行语句,获取结果集对象
        ResultSet rs = statement.executeQuery();
        // 5.遍历结果集
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = rs.getBoolean("gender");
//            Date birthday = rs.getDate("birthday");
            String birthday = rs.getString("birthday");
            int age = rs.getInt("age");
            System.out.println(id+","+name+","+gender+","+birthday+","+age);
        }
    }
}

```

常见错误

![1610699349677](/1610699349677.png)

数据库名称错误

![1610699421206](/1610699421206.png)

sql代码写错

![1610699484068](/1610699484068.png)

连接参数写错

![1610699637281](/1610699637281.png)

url写错了

![1610699707845](/1610699707845.png)

用户名或密码错误

![1610699751828](/1610699751828.png)

ip写错，没有@

![1610699820126](/1610699820126.png)

没有引入依赖，或者引入失败

事务：一组增删改语句组成的工作单元

oracle : 每次做增删改，需要手动的“保存”（提交）或"撤销"(回滚)

mysql ：自动保存，默认没有开启事务

```sql
set autocommit=off
```

