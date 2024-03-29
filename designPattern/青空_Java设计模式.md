![image-20220513191747324](https://tva1.sinaimg.cn/large/e6c9d24egy1h26ztcf6xbj21hy0i2abh.jpg)

# 面向对象设计原则

**注意：**推荐完成JavaEE通关路线再开始学习。

我们在进行软件开发时，不仅仅需要将最基本的业务给完成，还要考虑整个项目的可维护性和可复用性，我们开发的项目不单单需要我们自己来维护，同时也需要其他的开发者一起来进行共同维护，因此我们在编写代码时，应该尽可能的规范。如果我们在编写代码时不注重这些问题，整个团队项目就像一座屎山，随着项目的不断扩大，整体结构只会越来越遭。

甚至到最后你会发现，我们的程序居然是稳定运行在BUG之上的...

所以，为了尽可能避免这种情况的发生，我们就来聊聊面向对象设计原则。

## 单一职责原则

单一职责原则（Simple Responsibility Pinciple，SRP）是最简单的面向对象设计原则，它用于控制类的粒度大小。

> 一个对象应该只包含单一的职责，并且该职责被完整地封装在一个类中。

比如我们现在有一个People类：

```java
//一个人类
public class People {

    /**
     * 人类会编程
     */
    public void coding(){
        System.out.println("int mian() {");
        System.out.println("   printf(\"Holle Wrold!\");");
        System.out.println("}");
        System.out.println("啊嘞，怎么运行不起？明明照着老师敲的啊");
    }

    /**
     * 工厂打螺丝也会
     */
    public void work(){
        System.out.println("真开心，能进到富土康打螺丝");
        System.out.println("诶，怎么工友都提桶跑路了");
    }

    /**
     * 送外卖也会
     */
    public void ride(){
        System.out.println("今天终于通过美团最终面，加入了梦寐以求的大厂了");
        System.out.println("感觉面试挺简单的，就是不知道为啥我同学是现场做一道力扣接雨水，而我是现场问会不会骑车");
        System.out.println("（迫不及待穿上外卖服装）");
    }
}
```

我们可以看到，这个People类可以说是十八般武艺样样精通了，啥都会，但是实际上，我们每个人最终都是在自己所擅长的领域工作，所谓闻道有先后，术业有专攻，会编程的就应该是程序员，会打螺丝的就应该是工人，会送外卖的应该是骑手，显然这个People太过臃肿（我们需要修改任意一种行为都需要修改People类，它拥有不止一个引起它变化的原因），所以根据单一职责原则，我们下需要进行更明确的划分，同种类型的操作我们一般才放在一起：

```java
class Coder{
    /**
     * 程序员会编程
     */
    public void coding(){
        System.out.println("int mian() {");
        System.out.println("   printf(\"Hello World!\")");
        System.out.println("}");
        System.out.println("啊嘞，怎么运行不起？明明照着老师敲的啊");
    }
}

class Worker{
    /**
     * 工人会打螺丝
     */
    public void work(){
        System.out.println("真开心，能进到富土康打螺丝");
        System.out.println("诶，怎么工友都提桶跑路了");
    }
}

class Rider {
    /**
     * 骑手会送外卖
     */
    public void ride(){
        System.out.println("今天终于通过美团最终面，加入了梦寐以求的大厂");
        System.out.println("感觉面试挺简单的，就是不知道为啥我同学是现场做一道力扣接雨水，我是现场问会不会骑车");
        System.out.println("（迫不及待穿上外卖服装）");
    }
}
```

我们将类的粒度进行更近一步的划分，这样就很清晰了，包括我们以后在设计Mapper、Service、Controller等等，根据不同的业务进行划分，都可以采用单一职责原则，以它作为我们实现高内聚低耦合的指导方针。实际上我们的微服务也是参考了单一职责原则，每个微服务只应担负一个职责。

## 开闭原则

开闭原则（Open Close Principle）也是重要的面向对象设计原则。

> 软件实体应当对扩展开放，对修改关闭。

一个软件实体，比如类、模块和函数应该对扩展开放，对修改关闭。其中，对扩展开放是针对提供方来说的，对修改关闭是针对调用方来说的。

比如我们的程序员分为Java程序员、C#程序员、C艹程序员、PHP程序员、前端程序员等，而他们要做的都是去打代码，而具体如何打代码是根据不同语言的程序员来决定的，我们可以将程序员打代码这一个行为抽象成一个统一的接口或是抽象类，这样我们就满足了开闭原则的第一个要求：对扩展开放，不同的程序员可以自由地决定他们该如何进行编程。而具体哪个程序员使用什么语言怎么编程，是自己在负责，不需要其他程序员干涉，所以满足第二个要求：对修改关闭，比如：

```java
public abstract class Coder {

    public abstract void coding();

    class JavaCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("Java太卷了T_T，快去学Go吧！");
        }
    }

    class PHPCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("PHP是世界上最好的语言");
        }
    }

    class C艹Coder extends Coder{
        @Override
        public void coding() {
            System.out.println("笑死，Java再牛逼底层不还得找我？");
        }
    }
}
```

通过提供一个Coder抽象类，定义出编程的行为，但是不进行实现，而是开放给其他具体类型的程序员来实现，这样就可以根据不同的业务进行灵活扩展了，具有较好的延续性。

不过，回顾我们这一路的学习，好像处处都在使用开闭原则。

## 里氏替换原则

里氏替换原则（Liskov Substitution Principle）是对子类型的特别定义。它由芭芭拉·利斯科夫（Barbara Liskov）在1987年在一次会议上名为 "数据的抽象与层次" 的演说中首先提出。

> 所有引用基类的地方必须能透明地使用其子类的对象。

简单的说就是，子类可以扩展父类的功能，但不能改变父类原有的功能：

1. 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
2. 子类可以增加自己特有的方法。
3. 当子类的方法重载父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松。
4. 当子类的方法实现父类的方法时（重写/重载或实现抽象方法），方法的后置条件（即方法的输出/返回值）要比父类更严格或与父类一样。

比如我们下面的例子：

```java
public abstract class Coder {

    public void coding() {
        System.out.println("我会打代码");
    }


    class JavaCoder extends Coder{

        /**
         * 子类除了会打代码之外，还会打游戏
         */
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }
    }
}
```

可以看到JavaCoder虽然继承自Coder，但是并没有对父类方法进行重写，并且还在父类的基础上进行额外扩展，符合里氏替换原则。但是我们再来看下面的这个例子：

```java
public abstract class Coder {

    public void coding() {
        System.out.println("我会打代码");
    }


    class JavaCoder extends Coder{
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }

        /**
         * 这里我们对父类的行为进行了重写，现在它不再具备父类原本的能力了
         */
        public void coding() {
            System.out.println("我寒窗苦读十六年，到最后还不如培训班三个月出来的程序员");
            System.out.println("想来想去，房子车子结婚彩礼，为什么这辈子要活的这么累呢？");
            System.out.println("难道来到这世间走这一遭就为了花一辈子时间买个房子吗？一个人不是也能活的轻松快乐吗？");
            System.out.println("摆烂了，啊对对对");  
          	//好了，emo结束，继续卷吧，人生因奋斗而美丽，这个世界虽然满目疮痍，但是还是有很多美好值得期待
        }
    }
}
```

可以看到，现在我们对父类的方法进行了重写，显然，父类的行为已经被我们给覆盖了，这个子类已经不具备父类的原本的行为，很显然违背了里氏替换原则。

要是程序员连敲代码都不会了，还能叫做程序员吗？

所以，对于这种情况，我们不需要再继承自Coder了，我们可以提升一下，将此行为定义到People中：

```java
public abstract class People {

    public abstract void coding();   //这个行为还是定义出来，但是不实现
    
    class Coder extends People{
        @Override
        public void coding() {
            System.out.println("我会打代码");
        }
    }


    class JavaCoder extends People{
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }

        public void coding() {
            System.out.println("摆烂了，啊对对对");
        }
    }
}
```

里氏替换也是实现开闭原则的重要方式之一。

## 依赖倒转原则

依赖倒转原则（Dependence Inversion Principle）也是我们一直在使用的，最明显的就是我们的Spring框架了。

> 高层模块不应依赖于底层模块，它们都应该依赖抽象。抽象不应依赖于细节，细节应该依赖于抽象。

还记得我们在我们之前的学习中为什么要一直使用接口来进行功能定义，然后再去实现吗？我们回顾一下在使用Spring框架之前的情况：

```java
public class Main {

    public static void main(String[] args) {
        UserController controller = new UserController();
      	//该怎么用就这么用
    }

    static class UserMapper {
        //CRUD...
    }

    static class UserService {
        UserMapper mapper = new UserMapper();
        //业务代码....
    }

    static class UserController {
        UserService service = new UserService();
        //业务代码....
    }
}
```

但是突然有一天，公司业务需求变化，现在用户相关的业务操作需要使用新的实现：

```java
public class Main {

    public static void main(String[] args) {
        UserController controller = new UserController();
    }

    static class UserMapper {
        //CRUD...
    }

    static class UserServiceNew {   //由于UserServiceNew发生变化，会直接影响到其他高层模块
        UserMapper mapper = new UserMapper();
        //业务代码....
    }

    static class UserController {   //焯，干嘛改底层啊，我这又得重写了
        UserService service = new UserService();   //哦豁，原来的不能用了
        UserServiceNew serviceNew = new UserServiceNew();   //只能修改成新的了
        //业务代码....
    }
}
```

我们发现，我们的各个模块之间实际上是具有强关联的，一个模块是直接指定依赖于另一个模块，虽然这样结构清晰，但是底层模块的变动，会直接影响到其他依赖于它的高层模块，如果我们的项目变得很庞大，那么这样的修改将是一场灾难。

而有了Spring框架之后，我们的开发模式就发生了变化：

```java
public class Main {

    public static void main(String[] args) {
        UserController controller = new UserController();
    }

    interface UserMapper {
        //接口中只做CRUD方法定义
    }

    static class UserMapperImpl implements UserMapper {
        //实现类完成CRUD具体实现
    }

    interface UserService {
        //业务代码定义....
    }

    static class UserServiceImpl implements UserService {
        @Resource   //现在由Spring来为我们选择一个指定的实现类，然后注入，而不是由我们在类中硬编码进行指定
        UserMapper mapper;
        
        //业务代码具体实现
    }

    static class UserController {
        @Resource
        UserService service;   //直接使用接口，就算你改实现，我也不需要再修改代码了

        //业务代码....
    }
}
```

可以看到，通过使用接口，我们就可以将原有的强关联给弱化，我们只需要知道接口中定义了什么方法然后去使用即可，而具体的操作由接口的实现类来完成，并由Spring来为我们注入，而不是我们通过硬编码的方式去指定。

## 接口隔离原则

接口隔离原则（Interface Segregation Principle, ISP）实际上是对接口的细化。

> 客户端不应依赖那些它不需要的接口。

我们在定义接口的时候，一定要注意控制接口的粒度，比如下面的例子：

```java
interface Device {
    String getCpu();
    String getType();
    String getMemory();
}

//电脑就是一种电子设备，那么我们就实现此接口
class Computer implements Device {

    @Override
    public String getCpu() {
        return "i9-12900K";
    }

    @Override
    public String getType() {
        return "电脑";
    }

    @Override
    public String getMemory() {
        return "32G DDR5";
    }
}

//电风扇也算是一种电子设备
class Fan implements Device {

    @Override
    public String getCpu() {
        return null;   //就一个破风扇，还需要CPU？
    }

    @Override
    public String getType() {
        return "风扇";
    }

    @Override
    public String getMemory() {
        return null;   //风扇也不需要内存吧
    }
}
```

虽然我们定义了一个Device接口，但是由于此接口的粒度不够细，虽然比较契合电脑这种设备，但是不适合风扇这种设备，因为风扇压根就不需要CPU和内存，所以风扇完全不需要这些方法。这时我们就必须要对其进行更细粒度的划分：

```java
interface SmartDevice {   //智能设备才有getCpu和getMemory
    String getCpu();
    String getType();
    String getMemory();
}

interface NormalDevice {   //普通设备只有getType
    String getType();
}

//电脑就是一种电子设备，那么我们就继承此接口
class Computer implements SmartDevice {

    @Override
    public String getCpu() {
        return "i9-12900K";
    }

    @Override
    public String getType() {
        return "电脑";
    }

    @Override
    public String getMemory() {
        return "32G DDR5";
    }
}

//电风扇也算是一种电子设备
class Fan implements NormalDevice {
    @Override
    public String getType() {
        return "风扇";
    }
}
```

这样，我们就将接口进行了细粒度的划分，不同类型的电子设备就可以根据划分去实现不同的接口了。当然，也不能划分得太小，还是要根据实际情况来进行决定。

## 合成复用原则

合成复用原则（Composite Reuse Principle）的核心就是委派。

> 优先使用对象组合，而不是通过继承来达到复用的目的。

在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分，新的对象通过向这些对象的委派达到复用已有功能的目的。实际上我们在考虑将某个类通过继承关系在子类得到父类已经实现的方法之外（比如A类实现了连接数据库的功能，恰巧B类中也需要，我们就可以通过继承来获得A已经写好的连接数据库的功能，这样就能直接复用A中已经写好的逻辑）我们应该应该优先地去考虑使用合成的方式来实现复用。

比如下面这个例子：

```java
class A {
    public void connectDatabase(){
        System.out.println("我是连接数据库操作！");
    }
}

class B extends A{    //直接通过继承的方式，得到A的数据库连接逻辑
    public void test(){
        System.out.println("我是B的方法，我也需要连接数据库！");
        connectDatabase();   //直接调用父类方法就行
    }
}
```

虽然这样看起来没啥毛病，但是还是存在我们之前说的那个问题，耦合度太高了。

可以看到通过继承的方式实现复用，我们是将类B直接指定继承自类A的，那么如果有一天，由于业务的更改，我们的数据库连接操作，不再由A来负责，而是由新来的C去负责，那么这个时候，我们就不得不将需要复用A中方法的子类全部进行修改，很显然这样是费时费力的。

并且还有一个问题就是，通过继承子类会得到一些父类中的实现细节，比如某些字段或是方法，这样直接暴露给子类，并不安全。

所以，当我们需要实现复用时，可以优先考虑以下操作：

```java
class A {
    public void connectDatabase(){
        System.out.println("我是连接数据库操作！");
    }
}

class B {   //不进行继承，而是在用的时候给我一个A，当然也可以抽象成一个接口，更加灵活
    public void test(A a){
        System.out.println("我是B的方法，我也需要连接数据库！");
        a.connectDatabase();   //在通过传入的对象A去执行
    }
}
```

或是：

```java
class A {
    public void connectDatabase(){
        System.out.println("我是连接数据库操作！");
    }
}

class B {
    
    A a;
    public B(A a){   //在构造时就指定好
        this.a = a;
    }
    
    public void test(){
        System.out.println("我是B的方法，我也需要连接数据库！");
        a.connectDatabase();   //也是通过对象A去执行
    }
}
```

通过对象之间的组合，我们就大大降低了类之间的耦合度，并且A的实现细节我们也不会直接得到了。

## 迪米特法则

迪米特法则（Law of Demeter）又称最少知识原则，是对程序内部数据交互的限制。

> 每一个软件单位对其他单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位。

简单来说就是，一个类/模块对其他的类/模块有越少的交互越好。当一个类发生改动，那么，与其相关的类（比如用到此类啥方法的类）需要尽可能少的受影响（比如修改了方法名、字段名等，可能其他用到这些方法或是字段的类也需要跟着修改）这样我们在维护项目的时候会更加轻松一些。

其实说白了，还是降低耦合度，我们还是来看一个例子：

```java
public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);   //假设我们当前的程序需要进行网络通信
        Test test = new Test();
        test.test(socket);   //现在需要执行test方法来做一些事情
    }

    static class Test {
        /**
         * 比如test方法需要得到我们当前Socket连接的本地地址
         */
        public void test(Socket socket){
            System.out.println("IP地址："+socket.getLocalAddress());
        }
    }
}
```

可以看到，虽然上面这种写法没有问题，我们提供直接提供一个Socket对象，然后再由test方法来取出IP地址，但是这样显然违背了迪米特法则，实际上这里的`test`方法只需要一个IP地址即可，我们完全可以直接传入一个字符串，而不是整个Socket对象，我们需要保证与其他类的交互尽可能的少。

就像我们在餐厅吃完了饭，应该是我们自己扫码付款，而不是直接把手机交给老板来帮你操作付款。

要是某一天，Socket类中的这些方法发生修改了，那我们就得连带着去修改这些类，很麻烦。

所以，我们来改进改进：

```java
public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Test test = new Test();
        test.test(socket.getLocalAddress().getHostAddress());  //在外面解析好就行了
    }

    static class Test {
        public void test(String str){   //一个字符串就能搞定，就没必要丢整个对象进来
            System.out.println("IP地址："+str);
        }
    }
}
```

这样，类与类之间的耦合度再次降低。







![image-20220521153312361](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2g2a4fy7rj21fc0hkwsb.jpg)

# 设计模式（创建型）

软件设计模式（Design pattern），又称设计模式，是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性、程序的重用性。

> 肯特·贝克和[沃德·坎宁安](https://baike.baidu.com/item/沃德·坎宁安/6488429)在1987年利用克里斯托佛·亚历山大在建筑设计领域里的思想开发了设计模式并把此思想应用在Smalltalk中的图形用户接口的生成中。一年后Erich Gamma在他的[苏黎世大学](https://baike.baidu.com/item/苏黎世大学/1621125)博士毕业论文中开始尝试把这种思想改写为适用于软件开发。与此同时James Coplien 在1989年至1991 年也在利用相同的思想致力于C++的开发，而后于1991年发表了他的著作Advanced C++ Idioms。就在这一年Erich Gamma 得到了博士学位，然后去了美国，在那与Richard Helm, Ralph Johnson ,John Vlissides合作出版了Design Patterns - Elements of Reusable Object-Oriented Software 一书，在此书中共收录了23个设计模式。这四位作者在软件开发领域里也以他们的匿名著称Gang of Four(四人帮，简称GoF),并且是他们在此书中的协作导致了软件设计模式的突破。

我们先来看看有关对象创建的几种设计模式。

## 工厂方法模式

首当其冲的是最简单的一种设计模式——工厂方法模式，我们知道，如果需要创建一个对象，那么最简单的方式就是直接new一个即可。而工厂方法模式代替了传统的直接new的形式，那么为什么要替代传统的new形式呢？

可以想象一下，如果所有的对象我们都通过new的方式去创建，那么当我们的程序中大量使用此对象时，突然有一天**这个对象的构造方法或是类名发生了修改**，那我们岂不是得挨个去进行修改？根据迪米特法则，我们应该尽可能地少与其他类进行交互，所以我们可以将那些需要频繁出现的对象创建，封装到一个工厂类中，当我们需要对象时，直接调用工厂类中的工厂方法来为我们生成对象，这样，就算类出现了变动，*我们也只需要修改工厂中的代码即可*，而不是大面积地进行修改。

同时，可能某些对象的创建并不只是一个new就可以搞定，可能还需要更多的步骤来准备构造方法需要的参数，所以我们来看看如何使用`简单工厂模式`来创建对象，既然是工厂，那么我们就来创建点工厂需要生产的东西：

```java
public abstract class Fruit {   //水果抽象类
    private final String name;
    
    public Fruit(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"@"+hashCode();   //打印一下当前水果名称，还有对象的hashCode
    }
}
```

```java
public class Apple extends Fruit{   //苹果，继承自水果

    public Apple() {
        super("苹果");
    }
}
```

```java
public class Orange extends Fruit{  //橘子，也是继承自水果
    public Orange() {
        super("橘子");
    }
}
```

正常情况下，我们直接new就可以得到对象了：

```java
public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple);
    }
}
```

现在我们将对象的创建封装到工厂中：

```java
public class FruitFactory {
    /**
     * 这里就直接来一个静态方法根据指定类型进行创建
     * @param type 水果类型
     * @return 对应的水果对象
     */
    public static Fruit getFruit(String type) {
        switch (type) {
            case "苹果":
                return new Apple();
           	case "橘子":
                return new Orange();
            default:
                return null;
        }
    }
}
```

现在我们就可以使用此工厂来创建对象了：

```java
public class Main {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getFruit("橘子");   //直接问工厂要，而不是我们自己去创建
        System.out.println(fruit);
    }
}
```

不过这样还是有一些问题，我们前面提到了开闭原则，一个软件实体，比如类、模块和函数应该对扩展开放，对修改关闭，但是如果我们现在需要新增一种水果，比如桃子，那么这时我们就得去修改工厂提供的工厂方法了，但是这样是不太符合开闭原则的，因为工厂实际上是针对于调用方提供的，所以我们应该尽可能对修改关闭。

所以，我们就利用对扩展开放，对修改关闭的性质，将`简单工厂模式`改进为`工厂方法模式`，那现在既然不让改，那么我们就看看如何去使用扩展的形式：

```java
public abstract class FruitFactory<T extends Fruit> {   //将水果工厂抽象为抽象类，添加泛型T由子类指定水果类型
    public abstract T getFruit();  //不同的水果工厂，通过此方法生产不同的水果
}
```

```java
public class AppleFactory extends FruitFactory<Apple> {  //苹果工厂，直接返回Apple，一步到位
    @Override
    public Apple getFruit() {
        return new Apple();
    }
}
```

这样，我们就可以使用不同类型的工厂来生产不同类型的水果了，并且如果新增了水果类型，直接创建一个新的工厂类就行，不需要修改之前已经编写好的内容。

```java
public class Main {
    public static void main(String[] args) {
        test(new AppleFactory()::getFruit);   //比如我们现在要吃一个苹果，那么就直接通过苹果工厂来获取苹果
    }

    //此方法模拟吃掉一个水果
    private static void test(Supplier<Fruit> supplier){
        System.out.println(supplier.get()+" 被吃掉了，真好吃。");
    }
}
```

这样，我们就简单实现了工厂方法模式，通过工厂来屏蔽对象的创建细节，使用者只需要关心如何去使用对象即可。

## 抽象工厂模式

前面我们介绍了工厂方法模式，通过定义顶层抽象工厂类，通过继承的方式，针对于每一个产品都提供一个工厂类用于创建。

不过这种模式只适用于简单对象，当我们需要生产许多个产品族的时候，这种模式就有点乏力了，比如：

![image-20220521162444703](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2g3rpau36j218u0e0jt8.jpg)

实际上这些产品都是成族出现的，比如小米的产品线上有小米12，小米平板等，华为的产品线上也有华为手机、华为平板，但是如果按照我们之前工厂方法模式来进行设计，那就需要单独设计9个工厂来生产上面这些产品，显然这样就比较浪费时间的。

但是现在有什么方法能够更好地处理这种情况呢？我们就可以使用抽象工厂模式，我们可以将多个产品，都放在一个工厂中进行生成，按不同的产品族进行划分，比如小米，那么我就可以安排一个小米工厂，而这个工厂里面就可以生产整条产品线上的内容，包括小米手机、小米平板、小米路由等。

所以，我们只需要建立一个抽象工厂即可：

```java
public class Router {
}
```

```java
public class Table {
}
```

```java
public class Phone {
}
```

```java
public abstract class AbstractFactory {
    public abstract Phone getPhone();
    public abstract Table getTable();
    public abstract Router getRouter();
}
```

一个工厂可以生产同一个产品族的所有产品，这样按族进行分类，显然比之前的工厂方法模式更好。

不过，缺点还是有的，如果产品族新增了产品，那么我就不得不去为每一个产品族的工厂都去添加新产品的生产方法，违背了开闭原则。

## 建造者模式

建造者模式也是非常常见的一种设计模式，我们经常看到有很多的框架都为我们提供了形如`XXXBuilder`的类型，我们一般也是使用这些类来创建我们需要的对象。

也属于创建型模式，它提供了一种创建对象的最佳方式。

定义：将一个复杂对象的构建与它的表示分离，是的同样的构建过程可以有不同表示。

**主要作用**：用户不知道对象的建造过程和细节的情况下就可以直接创造复杂对象。

**优点**：

1、产品建造和标识进行分离，实现了解耦。可以使客户端不必知道产品内部组成的细节。

2、将复杂产品的创建步骤分解在不同方法中，是的创建过程更加清晰。

3、具体的建造类之间是相互独立的，有利于系统拓展。增加新的具体建造者无需修改原有的类库代码，符合开闭原则。

**缺点:**

1、建造者模式所创建产品一般具有较多**共同点**，组成部分相似；如果产品存在较多差异，则不适合建造者模式

2、如果产品结构内部变化复杂，可能导致需要更多具体建造者类来实现这种变化，导致系统变的庞大臃肿。

比如，我们在JavaSE中就学习过的`StringBuiler`类：

```java
public static void main(String[] args) {
    StringBuilder builder = new StringBuilder();   //创建一个StringBuilder来逐步构建一个字符串
    builder.append(666);   //拼接一个数字
    builder.append("老铁");   //拼接一个字符串
   	builder.insert(2, '?');  //在第三个位置插入一个字符
    System.out.println(builder.toString());   //差不多成形了，最后转换为字符串
}
```

实际上我们是通过建造者来不断配置参数或是内容，当我们配置完所有内容后，最后再进行对象的构建。

相比直接去new一个新的对象，建造者模式的重心更加关注在如何完成每一步的配置，同时如果一个类的构造方法参数过多，**我们通过建造者模式来创建这个对象，会更加优雅**。

比如我们现在有一个学生类：

```java
public class Student {
    int id;
    int age;
    int grade;
    String name;
    String college;
    String profession;
    List<String> awards;

    public Student(int id, int age, int grade, String name, String college, String profession, List<String> awards) {
        this.id = id;
        this.age = age;
        this.grade = grade;
        this.name = name;
        this.college = college;
        this.profession = profession;
        this.awards = awards;
    }
}
```

可以看到这个学生类的属性是非常多的，所以构造方法不是一般的长，如果我们现在直接通过new的方式去创建：

```java
public static void main(String[] args) {
    Student student = new Student(1, 18, 3, "小明", "计算机学院", "计算机科学与技术", Arrays.asList("ICPC-ACM 区域赛 金牌", "LPL 2022春季赛 冠军"));
}
```

可以看到，我们光是填参数就麻烦，我们还得一个一个对应着去填，一不小心可能就把参数填到错误的位置了。

所以，我们现在可以使用建造者模式来进行对象的创建：

```java
public class Student {
		...

    //一律使用建造者来创建，不对外直接开放
    private Student(int id, int age, int grade, String name, String college, String profession, List<String> awards) {
        ...
    }

    public static StudentBuilder builder(){   //通过builder方法直接获取建造者
        return new StudentBuilder();
    }

    public static class StudentBuilder{   //这里就直接创建一个内部类
        //Builder也需要将所有的参数都进行暂时保存，所以Student怎么定义的这里就怎么定义
        int id;
        int age;
        int grade;
        String name;
        String college;
        String profession;
        List<String> awards;

        public StudentBuilder id(int id){    //直接调用建造者对应的方法，为对应的属性赋值
            this.id = id;
            return this;   //为了支持链式调用，这里直接返回建造者本身，下同
        }

        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }
      
      	...

        public StudentBuilder awards(String... awards){
            this.awards = Arrays.asList(awards);
            return this;
        }
        
        public Student build(){    //最后我们只需要调用建造者提供的build方法即可根据我们的配置返回一个对象
            return new Student(id, age, grade, name, college, profession, awards);
        }
    }
}
```

现在，我们就可以使用建造者来为我们生成对象了：

```java
public static void main(String[] args) {
    Student student = Student.builder()   //获取建造者
            .id(1)    //逐步配置各个参数
            .age(18)
            .grade(3)
            .name("小明")
            .awards("ICPC-ACM 区域赛 金牌", "LPL 2022春季赛 冠军")
            .build();   //最后直接建造我们想要的对象
}
```

这样，我们就可以让这些参数对号入座了，并且也比之前的方式优雅许多。

## 单例模式

单例模式其实在之前的课程中已经演示过很多次了，这也是使用频率非常高的一种模式。

那么，什么是单例模式呢？顾名思义，单例那么肯定就是只有一个实例对象，在我们的整个程序中，同一个类始终只会有一个对象来进行操作。比如数据库连接类，实际上我们只需要创建一个对象或是直接使用静态方法就可以了，没必要去创建多个对象。

这里还是还原一下我们之前使用的简单单例模式：

```java
public class Singleton {
    private final static Singleton INSTANCE = new Singleton();   //用于引用全局唯一的单例对象，在一开始就创建好
    
    private Singleton() {}   //不允许随便new，需要对象直接找getInstance
    
    public static Singleton getInstance(){   //获取全局唯一的单例对象
        return INSTANCE;
    }
}
```

这样，当我们需要获取此对象时，只能通过`getInstance()`来获取唯一的对象：

```java
public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
}
```

当然，单例模式除了这种写法之外，还有其他写法，这种写法被称为饿汉式单例，也就是说在一开始类加载时就创建好了，我们来看看另一种写法——懒汉式：

```java
public class Singleton {
    private static Singleton INSTANCE;   //在一开始先不进行对象创建

    private Singleton() {}   //不用多说了吧

    public static Singleton getInstance(){   //将对象的创建延后到需要时再进行
        if(INSTANCE == null) {    //如果实例为空，那么就进行创建，不为空说明已经创建过了，那么就直接返回
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
```

可以看到，懒汉式就真的是条懒狗，你不去用它，它是不会给你提前准备单例对象的（延迟加载，懒加载），当我们需要获取对象时，才会进行检查并创建。虽然饿汉式和懒汉式写法不同，但是最后都是成功实现了单例模式。

不过，这里需要特别提醒一下，由于懒汉式是在方法中进行的初始化，在多线程环境下，可能会出现问题（建议学完JUC篇视频教程再来观看）大家可以试想一下，如果这个时候有多个线程同时调用了`getInstance()`方法，那么会出现什么问题呢？

![image-20220522161134092](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2h90c124gj21ae0bedhw.jpg)

可以看到，在多线程环境下，如果三条线程同时调用`getInstance()`方法，会同时进行`INSTANCE == null`的判断，那么此时由于确实还没有进行任何实例化，所以导致三条线程全部判断为`true`（而饿汉式由于在类加载时就创建完成，不会存在这样的问题）此时问题就来了，我们既然要使用单例模式，那么肯定是只希望对象只被初始化一次的，但是现在由于多线程的机制，导致对象被多次创建。

所以，为了避免线程安全问题，针对于懒汉式单例，我们还得进行一些改进：

```java
public static synchronized Singleton getInstance(){   //方法必须添加synchronized关键字加锁
    if(INSTANCE == null) {
        INSTANCE = new Singleton();
    }
    return INSTANCE;
}
```

既然多个线程要调用，那么我们就直接加一把锁，在方法上添加`synchronized`关键字即可，这样同一时间只能有一个线程进入了。虽然这样简单粗暴，但是在高并发的情况下，效率肯定是比较低的，我们来看看如何进行优化：

```java
public static Singleton getInstance(){
    if(INSTANCE == null) {
        synchronized (Singleton.class) {    //实际上只需要对赋值这一步进行加锁即可
            INSTANCE = new Singleton();   
        }
    }
    return INSTANCE;
}
```

不过这样还不完美，因为这样还是有可能多个线程同时判断为`null`而进入等锁的状态，所以，我们还得加一层内层判断：

```java
public static Singleton getInstance(){
    if(INSTANCE == null) {
        synchronized (Singleton.class) {
            if(INSTANCE == null) INSTANCE = new Singleton();  //内层还要进行一次检查，双重检查锁定
        }
    }
    return INSTANCE;
}
```

不过我们还少考虑了一样内容，其实IDEA此时应该是给了黄标了：

![image-20220522162246278](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2h9by3dioj21be0aqmyd.jpg)

可以看到，这种情况下，IDEA会要求我们添加一个`volatile`给`INSTANCE`，各位还记得这个关键字有什么作用吗？没错，我们还需要保证`INSTANCE`在线程之间的可见性，这样当其他线程进入之后才会拿`INSTANCE`由其他线程更新的最新值去判断，这样，就差不多完美了。

那么，有没有一种更好的，不用加锁的方式也能实现延迟加载的写法呢？我们可以使用静态内部类：

```java
public class Singleton {
    private Singleton() {}

    private static class Holder {   //由静态内部类持有单例对象，但是根据类加载特性，我们仅使用Singleton类时，不会对静态内部类进行初始化
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){   //只有真正使用内部类时，才会进行类初始化
        return Holder.INSTANCE;   //直接获取内部类中的
    }
}
```

这种方式显然是最完美的懒汉式解决方案，没有进行任何的加锁操作，也能保证线程安全，不过要实现这种写法，跟语言本身也有一定的关联，并不是所有的语言都支持这种写法。

## 原型模式

原型模式实际上与对象的拷贝息息相关，原型模式使用原型实例指定待创建对象的类型，并且通过复制这个原型来创建新的对象。也就是说，原型对象作为模板，通过克隆操作，来产生更多的对象，就像细胞的复制一样。

开始之前，我们先介绍一下对象的深拷贝和浅拷贝，首先我们来看浅拷贝：

* **浅拷贝：**对于类中基本数据类型，会直接复制值给拷贝对象；对于引用类型，只会复制对象的地址，而实际上指向的还是原来的那个对象，拷贝个基莫。

  ```java
  public static void main(String[] args) {
      int a = 10;
      int b = a;  //基本类型浅拷贝
      System.out.println(a == b);
  
      Object o = new Object();
      Object k = o;    //引用类型浅拷贝，拷贝的仅仅是对上面对象的引用
      System.out.println(o == k);
  }
  ```

* **深拷贝：**无论是基本类型还是引用类型，深拷贝会将引用类型的所有内容，全部拷贝为一个新的对象，包括对象内部的所有成员变量，也会进行拷贝。

在Java中，我们就可以使用Cloneable接口提供的拷贝机制，来实现原型模式：

```java
public class Student implements Cloneable{   //注意需要实现Cloneable接口
    @Override
    public Object clone() throws CloneNotSupportedException {   //提升clone方法的访问权限
        return super.clone();
    }
}
```

接着我们来看看克隆的对象是不是原来的对象：

```java
public static void main(String[] args) throws CloneNotSupportedException {
    Student student0 = new Student();
    Student student1 = (Student) student0.clone();
    System.out.println(student0);
    System.out.println(student1);
}
```

可以看到，通过`clone()`方法克隆的对象并不是原来的对象，我们来看看如果对象内部有属性会不会一起进行克隆：

```java
public class Student implements Cloneable{
    
    String name;

    public Student(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

```java
public static void main(String[] args) throws CloneNotSupportedException {
    Student student0 = new Student("小明");
    Student student1 = (Student) student0.clone();
    System.out.println(student0.getName() == student1.getName());
}
```

可以看到，虽然Student对象成功拷贝，但是其内层对象并没有进行拷贝，依然只是对象引用的复制，所以Java为我们提供的`clone`方法只会进行浅拷贝。那么如何才能实现深拷贝呢？

```java
@Override
public Object clone() throws CloneNotSupportedException {   //这里我们改进一下，针对成员变量也进行拷贝
    Student student = (Student) super.clone();
    student.name = new String(name);
    return student;   //成员拷贝完成后，再返回
}
```

这样，我们就实现了深拷贝。





![image-20220522171355473](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2hat6hcrvj21fi0dcdhg.jpg)

# 设计模式（结构型）

结构型设计模式关注如何将现有的类或对象组织在一起形成更加强大的结构。并且根据我们前面学习的合成复用原则，我们该如何尽可能地使用关联关系来代替继承关系是我们本版块需要重点学习的内容。

## 类/对象适配器模式

在生活中，我们经常遇到这样的一个问题：笔记本太轻薄了，以至于没有RJ45网口和USB A口（比如Macbook为了轻薄甚至全是type-c形式的雷电口）但是现在我们因为工作需要，又得使用这些接口来连接线缆，这时我们想到的第一个解决方案，就是去买一个转接口（扩展坞），扩展坞可以将type-c口转换为其他类型的接口供我们使用，实际上这就是一种适配模式。

![image-20220523002617557](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2hnb1v5ytj21e20be401.jpg)

由于我们的电脑没有这些接口，但是提供了type-c类型的接口，虽然接口类型不一样，但是同样可以做其他接口能做的事情，比如USB文件传输、有线网络连接等，所以，这个时候，我们只需要添加一个中间人来帮我们转换一下接口形态即可。包括我们常用的充电头，为什么叫电源适配器呢？我们知道传统的供电是220V交流电，但是我们的手机可能只需要5V的电压进行充电，虽然现在有电，但是不能直接充，我们也不可能让电力公司专门为我们提供一个5V的直流电使用。这时电源适配器就开始发挥作用了，比如苹果的祖传5V1A充电头，实际上就是将220V交流电转换为5V的直流电进行传输，这样就相当于在220V交流电和我们的手机之前，做了一个适配器的角色。

在我们的Java程序中，也会经常遇到这样的问题，比如：

```java
public class TestSupplier {   //手机供应商

    public String doSupply(){
        return "iPhone 14 Pro";
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        TestSupplier supplier = new TestSupplier();
      	test( ? );   //我们没有Target类型的手机供应商，只有其他的，那这里该填个啥
    }

    public static void test(Target target){   //现在我们需要调用test方法，但是test方法需要Target类型的手机供应商
        System.out.println("成功得到："+target.supply());
    }
}
```

```java
public interface Target {    //现在的手机供应商，并不是test方法所需要的那种类型

    String supply();
}
```

这个时候，我们就可以使用适配器模式了，适配器模式分为类适配器和对象适配器，我们首先来看看如何使用类适配器解决这种问题，我们直接创建一个适配器类：

```java
public class TestAdapter extends TestSupplier implements Target {  
  //让我们的适配器继承TestSupplier并且实现Target接口
    @Override
    public String supply() {   //接着实现supply方法，直接使用TestSupplier提供的实现
        return super.doSupply();
    }
}
```

这样，我们就得到了一个Target类型的实现类，并且同时采用的是TestSupplier提供的实现。

```java
public static void main(String[] args) {
    TestAdapter adapter = new TestAdapter();
    test(adapter);
}

public static void test(Target target){
    System.out.println("成功得到："+target.supply());
}
```

不过，这种实现方式需要占用一个继承坑位，如果此时Target不是接口而是抽像类的话，由于Java不支持多继承，那么就无法实现了。同时根据合成复用原则，我们应该更多的通过合成的方式去实现功能，所以我们来看看第二种，也是用的比较多的一种模式，对象适配器：

```java
public class TestAdapter implements Target{   //现在不再继承TestSupplier，仅实现Target

    TestSupplier supplier;
    
    public TestAdapter(TestSupplier supplier){
        this.supplier = supplier;
    }
    
    @Override
    public String supply() {
        return supplier.doSupply();
    }
}
```

现在，我们就将对象以组合的形式存放在TestAdapter中，依然是通过存放的对象调用具体实现。

## 桥接模式

相信各位都去奶茶店买过奶茶，在购买奶茶的时候，店员首先会问我们，您需要什么类型的奶茶，比如我们此时点了一杯啵啵芋圆奶茶，接着店员会直接问我们需要大杯、中杯还是小杯，最后还会询问我们需要加什么配料，比如椰果、珍珠等，最后才会给我们制作奶茶。

![image-20220523233253071](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2irdudr55j20w00ba40h.jpg)

那么现在让你来设计一下这种模式的Java类，该怎么做呢？首先我们要明确，一杯奶茶除了类型之外，还分大中小杯，甚至可能还分加什么配料，这个时候，如果我们按照接口实现的写法：

```java
public interface Tea {   //由具体类型的奶茶实现
    String getType();   //不同的奶茶返回的类型不同
}
```

```java
public interface Size {   //分大杯小杯中杯
    String getSize();
}
```

比如现在我们创建一个新的类型：

```java
/**
 * 大杯芋圆啵啵奶茶
 */
public class LargeKissTea implements Tea, Size{

    @Override
    public String getSize() {
        return "大杯";
    }

    @Override
    public String getType() {
        return "芋圆啵啵奶茶";
    }
}
```

虽然这样设计起来还挺合理的，但是如果现在我们的奶茶品种多起来了，并且每种奶茶都有大中小杯，现在一共有两个维度需要考虑，那么我们岂不是得一个一个去创建这些类？甚至如果还要考虑配料，那么光创建类就得创建不知道多少个了。显然这种设计不太好，我们得换个方式。

这时，就可以使用我们的桥接模式了，现在我们面临的问题是，维度太多，不可能各种类型各种尺寸的奶茶都去创建一个类，那么我们就还是单独对这些接口进行简单的扩展，单独对不同的维度进行控制，但是如何实现呢？我们不妨将奶茶的类型作为最基本的抽象类，然后对尺寸、配料等属性进行桥接：

```java
public abstract class AbstractTea {
    
    protected Size size;   //尺寸作为桥接属性存放在类中
    
    protected AbstractTea(Size size){   //在构造时需要知道尺寸属性
        this.size = size;
    }
    
    public abstract String getType();   //具体类型依然是由子类决定
}
```

不过这个抽象类提供的方法还不全面，仅仅只有Tea的getType方法，我们还需要添加其他维度的方法，所以继续编写一个子类：

```java
public abstract class RefinedAbstractTea extends AbstractTea{
    protected RefinedAbstractTea(Size size) {
        super(size);
    }
    
    public String getSize(){   //添加尺寸维度获取方式
        return size.getSize();
    }
}
```

现在我们只需要单独为Size创建子类即可：

```java
public class Large implements Size{

    @Override
    public String getSize() {
        return "大杯";
    }
}
```

现在我们如果需要一个大杯的啵啵芋圆奶茶，只需要：

```java
public class KissTea extends RefinedAbstractTea{   //创建一个啵啵芋圆奶茶的子类
    protected KissTea(Size size) {   //在构造时需要指定具体的大小实现
        super(size);
    }

    @Override
    public String getType() {
        return "啵啵芋圆奶茶";   //返回奶茶类型
    }
}
```

现在我们就将两个维度拆开，可以分别进行配置了：

```java
public static void main(String[] args) {
    KissTea tea = new KissTea(new Large());
    System.out.println(tea.getType());
    System.out.println(tea.getSize());
}
```

通过桥接模式，使得抽象和实现可以沿着各自的维度来进行变化，不再是固定的绑定关系。

## 组合模式

组合模式实际上就是将多个组件进行组合，让用户可以对它们进行一致性处理。比如我们的文件夹，一个文件夹中可以有很多个子文件夹或是文件：

![image-20220524001804908](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2isot6rdnj213c072jsu.jpg)

它就像是一个树形结构一样，有分支有叶子，而组合模式则是可以对整个树形结构上的所有节点进行递归处理，比如我们现在希望将所有文件夹中的文件的名称前面都添加一个前缀，那么就可以使用组合模式。

![image-20220524083222697](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2j6z4r7nej21p60mgdhd.jpg)

组合模式的示例如下，这里我们就用文件和文件夹的例子来讲解：

```java
/**
 * 首先创建一个组件抽象，组件可以包含组件，组件有自己的业务方法
 */
public abstract class Component {
    public abstract void addComponent(Component component);    //添加子组件
    public abstract void removeComponent(Component component);   //删除子组件
    public abstract Component getChild(int index);   //获取子组件
    public abstract void test();   //执行对应的业务方法，比如修改文件名称
}
```

接着我们来编写两种实现类：

```java
public class Directory extends Component{   //目录可以包含多个文件或目录

    List<Component> child = new ArrayList<>();   //这里我们使用List来存放目录中的子组件

    @Override
    public void addComponent(Component component) {
        child.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        child.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return child.get(index);
    }

    @Override
    public void test() {
        child.forEach(Component::test);   //将继续调用所有子组件的test方法执行业务
    }
}
```

```java
public class File extends Component{   //文件就相当于是树叶，无法再继续添加子组件了

    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();   //不支持这些操作了
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void test() {
        System.out.println("文件名称修改成功！"+this);   //具体的名称修改操作
    }
}
```

最后，我们来测试一下：

```java
public static void main(String[] args) {
    Directory outer = new Directory();   //新建一个外层目录
    Directory inner = new Directory();   //新建一个内层目录
    outer.addComponent(inner);
    outer.addComponent(new File());   //在内层目录和外层目录都添加点文件，注意别导错包了
    inner.addComponent(new File());
    inner.addComponent(new File());
    outer.test();    //开始执行文件名称修改操作
}
```

可以看到我们对最外层目录进行操作后，会递归向下处理当前目录和子目录中所有的文件。

## 装饰模式

装饰模式就像其名字一样，为了对现有的类进行装饰。比如一张相片就一张纸，如果直接贴在墙上，总感觉少了点什么，但是我们给其添加一个好看的相框，就会变得非常对味。装饰模式的核心就在于不改变一个对象本身功能的基础上，给对象添加额外的行为，并且它是通过组合的形式完成的，而不是传统的继承关系。

比如我们现在有一个普通的功能类：

```java
public abstract class Base {   //顶层抽象类，定义了一个test方法执行业务
    public abstract void test();
}
```

```java
public class BaseImpl extends Base{
    @Override
    public void test() {
        System.out.println("我是业务方法");   //具体的业务方法
    }
}
```

不过现在的实现类太单调了，我们来添加一点装饰上去：

```java
public class Decorator extends Base{   //装饰者需要将装饰目标组合到类中

    protected Base base;

    public Decorator(Base base) {
        this.base = base;
    }

    @Override
    public void test() {
        base.test();    //这里暂时还是使用目标的原本方法实现
    }
}
```

```java
public class DecoratorImpl extends Decorator{   //装饰实现

    public DecoratorImpl(Base base) {
        super(base);
    }

    @Override
    public void test() {    //对原本的方法进行装饰，我们可以在前后都去添加额外操作
        System.out.println("装饰方法：我是操作前逻辑");
        super.test();
        System.out.println("装饰方法：我是操作后逻辑");
    }
}
```

这样，我们就通过装饰模式对类的功能进行了扩展：

```java
public static void main(String[] args) {
    Base base = new BaseImpl();
    Decorator decorator = new DecoratorImpl(base);  //将Base实现装饰一下
    Decorator outer = new DecoratorImpl(decorator);  //装饰者还可以嵌套

    decorator.test();

    outer.test();
}
```

这样我们就实现了装饰模式。

## 代理模式

代理模式和装饰模式很像，初学者很容易搞混，所以这里我们得紧接着来讲解一下。首先请记住，当无法直接访问某个对象或访问某个对象存在困难时，我们就可以通过一个代理对象来间接访问。

实际上代理在我们生活中处处都存在，比如手机厂商要去销售手机，但是手机厂商本身没有什么渠道可以大规模地进行售卖，很难与这些消费者进行对接，这时就得交给代理商去进行出售，比如Apple在中国的直营店很少，但是在中国的授权经销商却很多，手机厂商通过交给旗下代理商的形式来进行更大规模的出售。比如我们经常要访问Github，但是直接连接会发现很难连的上，这时我们加了一个代理就可以轻松访问，也是在体现代理的作用。

![image-20220524110803328](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jbh4qkf3j21ga0ioaf6.jpg)

同时，代理类需要保证客户端使用的透明性，也就是说操作起来需要与原本的真实对象相同，比如我们访问Github只需要输入网址即可访问，而添加代理之后，也是使用同样的方式去访问Github，所以操作起来是一样的。包括Spring框架其实也是依靠代理模式去实现的AOP记录日志等。

比如现在有一个目标类，但是我们现在需要通过代理来使用它：

```java
public abstract class Subject {
    public abstract void test();
}
```

```java
public class SubjectImpl extends Subject{  //此类无法直接使用，需要我们进行代理

    @Override
    public void test() {
        System.out.println("我是测试方法！");
    }
}
```

现在我们为其建立一个代理类：

```java
public class Proxy extends Subject{   //为了保证和Subject操作方式一样，保证透明性，也得继承

    Subject target;   //被代理的对象（甚至可以多重代理）

    public Proxy(Subject subject){
        this.target = subject;
    }

    @Override
    public void test() {   //由代理去执行被代理对象的方法，并且我们还可以在前后添油加醋
        System.out.println("代理前绕方法");
        target.test();
        System.out.println("代理后绕方法");
    }
}
```

乍一看，这不跟之前的装饰模式一模一样吗？

对装饰器模式来说，装饰者和被装饰者都实现同一个接口/抽象类。对代理模式来说，代理类和被代理的类都实现同一个接口/抽象类，在结构上确实没有啥区别。但是他们的作用不同，装饰器模式强调的是增强自身，在被装饰之后你能够在被增强的类上使用增强后的功能，增强后你还是你，只不过被强化了而已；代理模式强调要让别人帮你去做事情，以及添加一些本身与你业务没有太多关系的事情（记录日志、设置缓存等）重点在于让别人帮你做。

装饰模式和代理模式的不同之处在于思想。

当然实现代理模式除了我们上面所说的这种方式之外，我们还可以使用JDK为我们提供的动态代理机制，我们不再需要手动编写继承关系创建代理类，它能够在运行时通过反射机制为我们自动生成代理类：

```java
public interface Subject {  //JDK提供的动态代理只支持接口
    void test();
}
```

```java
public class SubjectImpl implements Subject{

    @Override
    public void test() {
        System.out.println("我是测试方法！");
    }
}
```

接着我们需要创建一个动态代理的处理逻辑：

```java
public class TestProxy implements InvocationHandler {    //代理类，需要实现InvocationHandler接口

    private final Object object;   //这里需要保存一下被代理的对象，下面需要用到

    public TestProxy(Object object) {
        this.object = object;
    }

    @Override   //此方法就是调用代理对象的对应方法时会进入，这里我们就需要编写如何进行代理了
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     		//method就是调用的代理对象的哪一个方法，args是实参数组
        System.out.println("代理的对象："+proxy.getClass());   //proxy就是生成的代理对象了，我们看看是什么类型的
        Object res = method.invoke(object, args);   //在代理中调用被代理对象原本的方法，因为你是代理，还是得执行一下别人的业务，当然也可以不执行，但是这样就失去代理的意义了，注意要用上面的object
        System.out.println("方法调用完成，返回值为："+res);   //看看返回值是什么
        return res;   //返回返回值
    }
}
```

最后我们来看看如何创建一个代理类：

```java
public static void main(String[] args) {
    SubjectImpl subject = new SubjectImpl();   //被代理的大冤种
    InvocationHandler handler = new TestProxy(subject);
    Subject proxy = (Subject) Proxy.newProxyInstance(
            subject.getClass().getClassLoader(),    //需要传入被代理的类的类加载器
            subject.getClass().getInterfaces(),    //需要传入被代理的类的接口列表
            handler);    //最后传入我们实现的代理处理逻辑实现类
    proxy.test();    //比如现在我们调用代理类的test方法，那么就会进入到我们上面TestProxy中invoke方法，走我们的代理逻辑
}
```

运行一次，可以看到调用代理类的方法，最终会走到我们的invoke方法中进行：

![image-20220524141757961](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jgypioutj214403cmxd.jpg)

根据接口，代理对象是`com.sun.proxy.$Proxy0`类（看名字就知道不对劲），这个类是动态生成的，我们也找不到具体的源代码。

不过JDK提供的动态代理只能使用接口，如果换成我们一开始的抽象类，就没办法了，这时我们可以使用一些第三方框架来实现更多方式的动态代理，比如Spring都在使用的CGLib框架，Maven依赖如下：

```xml
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.1</version>
</dependency>
```

由于CGlib底层使用ASM框架（JVM篇视频教程有介绍）进行字节码编辑，所以能够实现不仅仅局限于对接口的代理：

```java
public class TestProxy implements MethodInterceptor {  //首先还是编写我们的代理逻辑

    private final Object target;   //这些和之前JDK动态代理写法是一样的

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override   //我们也是需要在这里去编写我们的代理逻辑
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("现在是由CGLib进行代理操作！"+o.getClass());
        return method.invoke(target, objects);   //也是直接调用代理对象的方法即可
    }
}
```

接着我们来创建一下代理类：

```java
public static void main(String[] args) {
    SubjectImpl subject = new SubjectImpl();

    Enhancer enhancer = new Enhancer();   //增强器，一会就需要依靠增强器来为我们生成动态代理对象
    enhancer.setSuperclass(SubjectImpl.class);    //直接选择我们需要代理的类型，直接不需要接口或是抽象类，SuperClass作为代理类的父类存在，这样我们就可以按照指定类型的方式去操作代理类了
    enhancer.setCallback(new TestProxy(subject));  //设定我们刚刚编写好的代理逻辑

    SubjectImpl proxy = (SubjectImpl) enhancer.create();   //直接创建代理类

    proxy.test();   //调用代理类的test方法
}
```

可以看到，效果其实是差不多的：

![image-20220524143920720](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jhky32gyj216y03ggm0.jpg)

可以看到代理类是`包名.SubjectImpl$$EnhancerByCGLIB$$47f6ed3a`，也是动态生成的一个类，所以我们无法去查看源码，不过此类是继承自我们指定的类型的。

## 外观模式

你是否经历过类似的情况：今年计算机学院的奖学金评定工作开始了，由于你去年一不小心拿了个ACM的区域赛金牌，觉得自己又行了，于是也想参与到奖学金的争夺中，首先你的辅导员会通知你去打印你的获奖材料，然后你高高兴兴拿给辅导员之后，辅导员又给了你一张表，让你打印了之后填写一下，包括你的个人信息还有一些个人介绍，完成后，你本以为可以坐等发奖了，结果辅导员又跟你说我们评定还要去某某地方盖章，盖完章还要去找谁谁谁签字，最后还要参加一下答辩... 看着如此复杂的流程，你瞬间不想搞了。

![image-20220524150153791](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2ji8fk7ddj21e40d2dhh.jpg)

实际上我们生活中很多时候都是这样，可能在办一件事情的时候，由于部门职能的不同，你得各个部门到处跑，你肯定会抱怨一句，就不能有个人来统一一下吗，就不能在一个地方一起把事情都办了吗？这时，我们就可以用到外观模式了。

外观模式充分体现了迪米特法则。可能我们的整个项目有很多个子系统，但是我们可以在这些子系统的上面加一个门面（Facade）当我们外部需要与各个子系统交互时，无需再去直接使用各个子系统，而是与门面进行交互，再由门面与后面的各个子系统操作，这样，我们以后需要办什么事情，就统一找门面就行了。这样的好处是，首先肯定方便了代码的编写，统一找门面就行，不需要去详细了解子系统，并且，当子系统需要修改时，也只需要修改门面中的逻辑，不需要大面积的变动，遵循迪米特法则尽可能少的交互。

![image-20220524150617434](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jiczopulj21cm0eaq4l.jpg)

比如现在我们设计了三个子系统，分别是排队、结婚、领证，正常情况下我们是需要分别去找这三个部门去完成的，但是现在我们通过门面统一来完成：

```java
public class SubSystemA {
    public void test1(){
        System.out.println("排队");
    }
}
```

```java
public class SubSystemB {
    public void test2(){
        System.out.println("结婚");
    }
}
```

```java
public class SubSystemC {
    public void test3(){
        System.out.println("领证");
    }
}
```

现在三个系统太复杂了，我们添加一个门面：

```java
public class Facade {

    SubSystemA a = new SubSystemA();
    SubSystemB b = new SubSystemB();
    SubSystemC c = new SubSystemC();

    public void marry(){   //红白喜事一条龙服务
        a.test1();
        b.test2();
        c.test3();
    }
}
```

现在我们只需要一个门面就能直接把事情办完了：

```java
public static void main(String[] args) {
    Facade facade = new Facade();
    facade.marry();
}
```

通过使用外观模式，我们就大大降低了类与类直接的关联程度，并且简化了流程。

## 享元模式

最后我们来看看享元模式（Flyweight），那么这个"享元"代表什么意思呢？我们先来看看下面的问题：

```java
public static void main(String[] args) {
    String str1 = "abcdefg";
    String str2 = "abcd";
}
```

我们发现上面的例子中，两个字符串虽然长短不同，但是却包含了一段相同的部分，那么现在我们如果要对内存进行优化：

```java
public static void main(String[] args) {
    String str1 = "efg";   //由于str1包含str2，所以我们可以去掉重复的部分，当需要原本的str1时，再合在一起
    String str2 = "abcd";
    System.out.println("str1 = "+str2+str1);
}
```

而享元模式就是这个思想，我们可以将那些重复出现的内容作为共享部分取出，这样当我们拥有大量对象时，我们把其中共同的部分抽取出来，由于提取的部分是多个对象共享只有一份，那么就可以减轻内存的压力。包括我们的围棋，实际上我们只需要知道棋盘上的各个位置是黑棋还是白棋，实际上没有毕业创建很多个棋子对象，我们只需要去复用一个黑棋和一个白棋子对象即可。

比如现在我们有两个服务，但是他们都需要使用数据库工具类来操作，实际上这个工具类没必要创建多个，我们这时就可以使用享元模式，让数据库工具类作为享元类，通过享元工厂来提供一个共享的数据库工具类：

```java
public class DBUtil {
    public void selectDB(){
        System.out.println("我是数据库操作...");
    }
}
```

```java
public class DBUtilFactory {
    private static final DBUtil UTIL = new DBUtil();   //享元对象被存放在工厂中

    public static DBUtil getFlyweight(){   //获取享元对象
        return UTIL;
    }
}
```

最后当我们需要使用享元对象时，直接找享元工厂要就行了：

```java
public class UserService {   //用户服务

    public void service(){
        DBUtil util = DBUtilFactory.getFlyweight();   //通过享元工厂拿到DBUtil对象
        util.selectDB();    //该干嘛干嘛
    }
}
```

当然，这只是简单的享元模式实现，实际上我们一开始举例的String类，也在使用享元模式进行优化，比如下面的代码：

```java
public static void main(String[] args) {
    String str1 = "abcd";
    String str2 = "abcd";
    String str3 = "ab" + "cd";
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);   //猜猜这三个对象是不是都是同一个？
}
```

虽然我们这里定义了三个字符串，但是我们发现，这三个对象指向的都是同一个对象，这是为什么呢？实际上这正是Java语言实现了数据的共享，想要了解具体实现请前往JVM篇视频教程。





![image-20220524160923707](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jk6p4i6hj21fa0h677n.jpg)

# 设计模式（行为型）

前面我们已经学习了12种设计模式，分为两类：

* 创建型：关注对象创建
* 结构型：关注类和对象的结构组织

我们接着来看最后一种设计模式，也是最多的一种，行为型设计模式关注系统中对象之间的交互，研究系统在运行时对象之间的相互通信与协作，进一步明确对象的职责。

## 解释器模式

这种模式的使用场景较少，很少使用的一种设计模式，这里提一下就行。

解释器顾名思义，就是对我们的语言进行解释，根据不同的语义来做不同的事情，比如我们在SE中学习的双栈计算器，正是根据我们输入的算式，去进行解析，并根据不同的运算符来不断进行计算。

比如我们输入：1+2*3

那么计算器就会进行解析然后根据语义优先计算2*3的结果然后在计算1+6最后得到7，详细实现请参考JavaSE篇双栈计算器实现。

## 模板方法模式

模板方法模式我们之前也见到过许多，我们先来看看什么是模板方法。

有些时候，我们的业务可能需要经历很多个步骤来完成，比如我们生病了在医院看病，首先是去门诊挂号，然后等待叫号，然后是去找医生看病，确定病因后，就根据医生的处方去前台开药，最后付钱。这一整套流程看似是规规矩矩的，但是在这其中，某些步骤并不是确定的，比如医生看病这一步，由于不同的病因，可能会进行不同的处理，最后开出来的药方也会不同，所以，整套流程中，有些操作是固定的，有些操作可能需要根据具体情况而定。

![image-20220524164925635](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jlcb4jmqj20yi084mxz.jpg)

在我们的程序中也是如此，可能某些操作是固定的，我们就可以直接在类中对应方法进行编写，但是可能某些操作需要视情况而定，由不同的子类实现来决定，这时，我们就需要让这些操作由子类来延迟实现了。现在我们就需要用到模板方法模式。

我们先来写个例子：

```java
/**
 * 抽象诊断方法，因为现在只知道挂号和看医生是固定模式，剩下的开处方和拿药都是不确定的
 */
public abstract class AbstractDiagnosis {

    public void test(){
        System.out.println("今天头好晕，不想起床，开摆，先跟公司请个假");
        System.out.println("去医院看病了~");
        System.out.println("1 >> 先挂号");
        System.out.println("2 >> 等待叫号");
        //由于现在不知道该开什么处方，所以只能先定义一下行为，然后具体由子类实现
      	//大致的流程先定义好就行
        this.prescribe();
        this.medicine();  //开药同理
    }

    public abstract void prescribe();   //开处方操作根据具体病症决定了

    public abstract void medicine();   //拿药也是根据具体的处方去拿
}
```

现在我们定义好了抽象方法，只是将具体的流程先定义出来了，但是部分方法需要根据实现决定：

```java
/**
 * 感冒相关的具体实现子类
 */
public class ColdDiagnosis extends AbstractDiagnosis{
    @Override
    public void prescribe() {
        System.out.println("3 >> 一眼丁真，鉴定为假，你这不是感冒，纯粹是想摆烂");
    }

    @Override
    public void medicine() {
        System.out.println("4 >> 开点头孢回去吃吧");
    }
}
```

这样，我们就有了一个具体的实现类，并且由于看病的逻辑已经由父类定义好了，所以子类只需要实现需要实现的部分即可，这样我们就实现了简单的模板方法模式：

```java
public static void main(String[] args) {
    AbstractDiagnosis diagnosis = new ColdDiagnosis();
    diagnosis.test();
}
```

![image-20220524171621919](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jm4bz3mej217k06s3z7.jpg)

最后我们来看看在JUC中讲解AQS源码实现中出现的代码：

```java
public final boolean release(int arg) {    //AQS的锁释放操作
    if (tryRelease(arg)) {   //可以看到这里调用了tryRelease方法，但是此方法并不是在AQS实现的，而是不同的锁自行实现，因为AQS也不知道你这种类型的锁到底该怎么去解锁
        Node h = head;
        if (h != null && h.waitStatus != 0)
            unparkSuccessor(h);
        return true;
    }
    return false;
}

protected boolean tryRelease(int arg) {
    throw new UnsupportedOperationException();   //AQS中不支持，需要延迟到具体的子类去实现
}
```

模板方法模式，实际上部分功能的实现是在子类完成的：

```java
protected final boolean tryRelease(int releases) {   
  //ReentrantLock中的AQS Sync实现类，对tryRelease方法进行了具体实现
    int c = getState() - releases;
    if (Thread.currentThread() != getExclusiveOwnerThread())
        throw new IllegalMonitorStateException();
    boolean free = false;
    if (c == 0) {
        free = true;
        setExclusiveOwnerThread(null);
    }
    setState(c);
    return free;
}
```

是不是现在感觉，这种层层套娃的写法，好像并不是这些大佬故意为了装逼才这样写的，而是真的在遵守规范编写，让代码更易懂一些，甚至你现在再回去推一遍会发现思路非常清晰。当然，除了这里之外，还有很多框架都使用了模板方法模式来设计类结构，还请各位小伙伴自行探索。

## 责任链模式

责任链模式也非常好理解，比如我们的钉钉审批，实际上就是一条流水线一样的操作，由你发起申请，然后经过多个部门主管审批，最后才能通过，所以你的申请表相当于是在一条责任链上传递。当然除了这样的直线型责任链之外，还有环形、树形等。

![image-20220524172400365](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2jmca3j84j21bs08kglw.jpg)

实际上我们之前也遇到过很多种责任链，比如JavaWeb中学习的Filter过滤器，正是采用的责任链模式，通过将请求一级一级不断向下传递，来对我们所需要的请求进行过滤和处理。

![image-20220524231849889](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2jwlifbqfj21ci05ujrx.jpg)

这里我们就使用责任链模式来模拟一个简单的面试过程，我们面试也是一面二面三面这样走的流程，这里我们先设计一下责任链上的各个处理器：

```java
public abstract class Handler {

    protected Handler successor;    //这里我们就设计责任链以单链表形式存在，这里存放后继节点

    public Handler connect(Handler successor){     //拼接后续节点
        this.successor = successor;
        return successor;  //这里返回后继节点，方便我们一会链式调用
    }

    public void handle(){
        this.doHandle();   //由不同的子类实现具体处理过程
        Optional
                .ofNullable(successor)
                .ifPresent(Handler::handle);    //责任链上如果还有后继节点，就继续向下传递
    }

    public abstract void doHandle();   //结合上节课学习的模板方法，交给子类实现
}
```

因为面试有很多轮，所以我们这里创建几个处理器的实现：

```java
public class FirstHandler extends Handler{   //用于一面的处理器
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员一面 ==========");
        System.out.println("1. 谈谈你对static关键字的理解？");
        System.out.println("2. 内部类可以调用外部的数据吗？如果是静态的呢？");
        System.out.println("3. hashCode()方法是所有的类都有吗？默认返回的是什么呢？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}
```

```java
public class SecondHandler extends Handler{  //二面
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员二面 ==========");
        System.out.println("1. 如果我们自己创建一个java.lang包并且编写一个String类，能否实现覆盖JDK默认的？");
        System.out.println("2. HashMap的负载因子有什么作用？变化规律是什么？");
        System.out.println("3. 线程池的运作机制是什么？");
        System.out.println("4. ReentrantLock公平锁和非公平锁的区别是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}
```

```java
public class ThirdHandler extends Handler{
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员三面 ==========");
        System.out.println("1. synchronized关键字了解吗？如何使用？底层是如何实现的？");
        System.out.println("2. IO和NIO的区别在哪里？NIO三大核心组件？");
        System.out.println("3. TCP握手和挥手流程？少一次握手可以吗？为什么？");
        System.out.println("4. 操作系统中PCB是做什么的？运行机制是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}
```

这样我们就编写好了每一轮的面试流程，现在我们就可以构建一个责任链了：

```java
public static void main(String[] args) {
    Handler handler = new FirstHandler();  //一面首当其冲
    handler
            .connect(new SecondHandler())   //继续连接二面和三面
            .connect(new ThirdHandler());
    handler.handle();   //开始面试
} 
```

可以看到最后结果也是按照我们的责任链来进行的。

## 命令模式

大家有没有发现现在的家电都在趋向于智能化，通过一个中央控制器，我们就可以对家里的很多电器进行控制，比如国内做的比较好的小米智能家居系列，还有Apple的HomeKit等，我们只需要在一个终端上进行操作，就可以随便控制家里的电器。

![image-20220524235450650](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2jxmy55wej21g60jsjuz.jpg)

比如现在我们有很多的类，彩电、冰箱、空调、洗衣机、热水器等，既然现在我们要通过一个遥控器去控制他们，那么我们就需要将控制这些电器的指令都给设计好才行，并且还不能有太强的关联性。

所有的电器肯定需要通过蓝牙或是红外线接受遥控器发送的请求，所以所有的电器都是接收者：

```java
public interface Receiver {
    void action();   //具体行为，这里就写一个算了
}
```

接着我们要控制这些电器，那么肯定需要一个指令才能控制：

```java
public abstract class Command {   //指令抽象，不同的电器有指令

    private final Receiver receiver;

    protected Command(Receiver receiver){   //指定此命令对应的电器（接受者）
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();   //执行命令，实际上就是让接收者开始干活
    }
}
```

最后我们来安排一个遥控器：

```java
public class Controller {   //遥控器只需要把我们的指令发出去就行了
    public static void call(Command command){
        command.execute();
    }
}
```

比如现在我们创建一个空调，那么它就是作为我们命令的接收者：

```java
public class AirConditioner implements Receiver{
    @Override
    public void action() {
        System.out.println("空调已开启，呼呼呼");
    }
}
```

现在我们创建一个开启空调的命令：

```java
public class OpenCommand extends Command {
    public OpenCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }
}
```

最后我们只需要通过遥控器发送出去就可以了：

```java
public static void main(String[] args) {
    AirConditioner airConditioner = new AirConditioner();   //先创建一个空调
    Controller.call(new OpenCommand(airConditioner));   //直接通过遥控器来发送空调开启命令
}
```

通过这种方式，遥控器这个角色并不需要知道具体会执行什么，只需要发送命令即可，遥控器和电器的关联性就不再那么强了。

## 迭代器模式

迭代器我们在JavaSE篇就已经讲解过了，迭代器可以说是我们学习Java语言的基础，没有迭代器，集合类的遍历就成了问题，正是因为有迭代器的存在，我们才能更加优雅的使用foreach语法。

回顾我们之前使用迭代器的场景：

```java
public static void main(String[] args) {
    List<String> list = Arrays.asList("AAA", "BBB", "CCC");
    for (String s : list) {   //使用foreach语法糖进行迭代，依次获取每一个元素
        System.out.println(s);   //打印一下
    }
}
```

编译之后的代码如下：

```java
public static void main(String[] args) {
    List<String> list = Arrays.asList("AAA", "BBB", "CCC");
    Iterator var2 = list.iterator();   //实际上这里本质是通过List生成的迭代器来遍历我们每个元素的

    while(var2.hasNext()) {   //判断是否还有元素可以迭代，没有就false
        String s = (String)var2.next();   //通过next方法得到下一个元素，每调用一次，迭代器会向后移动一位
        System.out.println(s);    //打印一下
    }
}
```

可以看到，当我们使用迭代器对List进行遍历时，实际上就像一个指向列表头部的指针，我们通过不断向后移动指针来依次获取所指向的元素：

![image-20220525171535024](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2krpu5p8gj218m0800tp.jpg)

![image-20220525171557523](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24ely1h2krq82x3kj21c407474t.jpg)

这里，我们依照JDK提供的迭代器接口（JDK已经为我们定义好了一个迭代器的具体相关操作），也来设计一个迭代器：

```java
public class ArrayCollection<T> {    //首先设计一个简单的数组集合，一会我们就迭代此集合内的元素

    private final T[] array;   //底层使用一个数组来存放数据

    private ArrayCollection(T[] array){   //private掉，自己用
        this.array = array;
    }

    public static <T> ArrayCollection<T> of(T[] array){   //开个静态方法直接吧数组转换成ArrayCollection，其实和直接new一样，但是这样写好看一点
        return new ArrayCollection<>(array);
    }
}
```

现在我们就可以将数据存放在此集合中了：

```java
public static void main(String[] args) {
    String[] arr = new String[]{"AAA", "BBB", "CCC", "DDD"};
    ArrayCollection<String> collection = ArrayCollection.of(arr);
}
```

接着我们就可以来实现迭代器接口了：

```java
public class ArrayCollection<T> implements Iterable<T>{   //实现Iterable接口表示此类是支持迭代的

    ...

    @Override
    public Iterator<T> iterator() {    //需要实现iterator方法，此方法会返回一个迭代器，用于迭代我们集合中的元素
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<T> {   //这里实现一个，注意别用静态，需要使用对象中存放的数组
        private int cur = 0;   //这里我们通过一个指针表示当前的迭代位置

        @Override
        public boolean hasNext() {     //判断是否还有下一个元素
            return cur < array.length;   //如果指针大于或等于数组最大长度，就不能再继续了
        }

        @Override
        public T next() {   //返回当前指针位置的元素并向后移动一位
            return array[cur++];   //正常返回对应位置的元素，并将指针自增
        }
    }
}
```

接着，我们就可以对我们自己编写的一个简单集合类进行迭代了：

```java
public static void main(String[] args) {
    String[] arr = new String[]{"AAA", "BBB", "CCC", "DDD"};
    ArrayCollection<String> collection = ArrayCollection.of(arr);
    for (String s : collection) {    //可以直接使用foreach语法糖，当然最后还是会变成迭代器调用
        System.out.println(s);
    }
}
```

最后编译出来的样子：

```java
public static void main(String[] args) {
    String[] arr = new String[]{"AAA", "BBB", "CCC", "DDD"};
    ArrayCollection<String> collection = ArrayCollection.of(arr);
    Iterator var3 = collection.iterator();   //首先获取迭代器，实际上就是调用我们实现的iterator方法

    while(var3.hasNext()) {
        String s = (String)var3.next();   //直接使用next()方法不断向下获取
        System.out.println(s);
    }
}
```

这样我们就实现了一个迭代器来遍历我们的元素。

## 中介者模式

在早期，我们想要和别人进行语音聊天，一般都是通过电话的方式，我们通过拨打他人的电话号码，来建立会话，不过这样有一个问题，比如我现在想要通知通知3个人某件事情，那么我就得依次给三个人打电话，甚至还会遇到一种情况，就是我们没有某个人的电话号码，但是其他人有，这时还需要告知这个人并进行转告，就很麻烦。

![image-20220526164233041](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2lwdrfpkkj21dy0ewjx9.jpg)

但是现在我们有了Facetime、有了微信，我们可以同时让多个人参与到群通话中进行群聊，这样我们就不需要一个一个单独进行通话或是转达了。实际上正是依靠了一个中间商给我们提供了进行群体通话的平台，我们才能实现此功能，而这个平台实际上就是一个中间人。又比如我们想要去外面租房，但是我们怎么知道哪里有可以租的房子呢？于是我们就会上各大租房APP上去找房源，同样的，如果我们现在有房子需要出租，我们也不知道谁会想要租房子，同样的我们也会把房子挂在租房APP上展示，而当我们去租房时或是出租时，就会有一个称为中介的人来跟我们对接，实际上也是一种中介的模式。

在我们的程序中，可能也会出现很多的对象，但是这些对象之间的相互调用关系错综复杂，可能一个对象要做什么事情就得联系好几个对象：

![image-20220526174017796](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2ly1umglnj21fa0dswg2.jpg)

但是如果我们在这中间搞一个中间人：

![image-20220526174129303](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2ly3337mpj21ek0d4abk.jpg)

这样当我们要联系其他人时，一律找中介就可以了，中介存储了所有人的联系方式，这样就不会像上面一样乱成一团了。这里我们就以房产中介的例子来编写：

```java
public class Mediator {   //房产中介
    private final Map<String, User> userMap = new HashMap<>();   //在出售的房子需要存储一下

    public void register(String address, User user){   //出售房屋的人，需要告诉中介他的房屋在哪里
        userMap.put(address, user);
    }

    public User find(String address){   //通过此方法来看看有没有对应的房源
        return userMap.get(address);
    }
}
```

接着就是用户了，用户有两种角色，一种是租房，一种是出租：

```java
public class User {   //用户可以是出售房屋的一方，也可以是寻找房屋的一方
    String name;
    String tel;

    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
  
    public User find(String address, Mediator mediator){   //找房子的话，需要一个中介和你具体想找的地方
        return mediator.find(address);
    }

    @Override
    public String toString() {
        return name+" (电话："+tel+")";
    }
}
```

现在我们来测试一下：

```java
public static void main(String[] args) {
    User user0 = new User("刘女士", "10086");   //出租人
    User user1 = new User("李先生", "10010");   //找房人
    Mediator mediator = new Mediator();   //我是黑心中介

    mediator.register("成都市武侯区天府五街白马程序员", user0);   //先把房子给中介挂上去

    User user = user1.find("成都市武侯区天府五街下硅谷", mediator);  //开始找房子
    if(user == null) System.out.println("没有找到对应的房源");

    user = user1.find("成都市武侯区天府五街白马程序员", mediator);  //开始找房子
    System.out.println(user);   //成功找到对应房源
}
```

中介者模式优化了原有的复杂多对多关系，而是将其简化为一对多的关系，更容易理解一些。

## 备忘录模式

>  2021年10月1日下午，河南驻马店的一名13岁女中学生，因和同学发生不愉快喝下半瓶百草枯。
>
>  10月5日，抢救四天情况恶化，家属泣不成声称“肺部一个小时一变”。
>
>  10月6日下午，据武警河南省总队医院消息，“目前女孩仍在医院救治。”

喝下百草枯，会给你后悔的时间，但是不会给你后悔的机会（百草枯含有剧毒物质，会直接导致肺部纤维化，这是不可逆的，一般死亡过程在一周左右，即使家里花了再多的钱，接受了再多的治疗，也无法逆转这一过程）相信如果再给这位小女孩一次机会，回到拿起百草枯的那一刻，一定不会再冲动地喝下了吧。

![image-20220527123444026](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2muu9cw13j20pq07y0u1.jpg)

备忘录模式，就为我们的软件提供了一个可回溯的时间节点，可能我们程序在运行过程中某一步出现了错误，这时我们就可以回到之前的某个被保存的节点上重新来过（就像艾克的大招），我们平时编辑文本的时候，当我们编辑出现错误时，就需要撤回，而我们只需要按下`Ctrl+Z`就可以回到上一步，这样就大大方便了我们的文本编辑。

其实备忘录模式也可以应用到我们的程序中，如果你学习过安卓开发，安卓程序在很多情况下都会重新加载`Activity`，实际上安卓中`Activity`的`onSaveInstanceState`和`onRestoreInstanceState`就是用到了备忘录模式，分别用于保存和恢复，这样就算重新加载也可以恢复到之前的状态。

这里我们就模拟一下对象的状态保存：

```java
public class Student {
    private String currentWork;   //当前正在做的事情
    private int percentage;   //当前的工作完成百分比

    public void work(String currentWork) {
        this.currentWork = currentWork;
        this.percentage = new Random().nextInt(100);
    }

    @Override
    public String toString() {
        return "我现在正在做："+currentWork+" (进度："+percentage+"%)";
    }
}
```

接着我们需要保存它在某一时刻的状态，我们来编写一个状态保存类：

```java
public class State {
    final String currentWork;
    final int percentage;

    State(String currentWork, int percentage) {   //仅开放给同一个包下的Student类使用
        this.currentWork = currentWork;
        this.percentage = percentage;
    }
}
```

接着我们来将状态的保存和恢复操作都实现一下：

```java
public class Student {
    ...

    public State save(){
        return new State(currentWork, percentage);
    }

    public void restore(State state){
        this.currentWork = state.currentWork;
        this.percentage = state.percentage;
    }

    ...
}
```

现在我们来测试一下吧：

```java
public static void main(String[] args) {
    Student student = new Student();
    student.work("学Java");   //开始学Java
    System.out.println(student);

    State savedState = student.save();   //保存一下当前的状态

    student.work("打电动");   //刚打开B站播放视频，学一半开始摆烂了
    System.out.println(student);

    student.restore(savedState);   //两级反转！回到上一个保存的状态
    System.out.println(student);   //回到学Java的状态
}
```

可以看到，虽然在学习Java的过程中，中途摆烂了，但是我们可以时光倒流，回到还没开始摆烂的时候，继续学习Java：

![image-20220527163947219](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2n1x785gtj20x803m74l.jpg)

不过备忘录模式为了去保存对象的状态，会占用大量的资源，尤其是那种属性很多的对象，我们需要合理的使用才能保证程序稳定运行。

## 观察者模式

牵一发而动全身，一幅有序摆放的多米诺骨牌，在我们推到第一个骨牌时，后面的骨牌会不断地被上一个骨牌推倒：

![image-20220527164444210](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2n22ctg4rj20ym0cgact.jpg)

在Java中，一个对象的状态发生改变，可能就会影响到其他的对象，与之相关的对象可能也会联动的进行改变。还有我们之前遇到过的监听器机制，当具体的事件触发时，我们在一开始创建的监听器就可以执行相关的逻辑。我们可以使用观察者模式来实现这样的功能，当对象发生改变时，观察者能够立即观察到并进行一些联动操作，我们先定义一个观察者接口：

```java
public interface Observer {   //观察者接口
    void update();   //当对象有更新时，会回调此方法
}
```

接着我们来写一个支持观察者的实体类：

```java
public class Subject {
    private final Set<Observer> observerSet = new HashSet<>();

    public void observe(Observer observer) {   //添加观察者
        observerSet.add(observer);
    }

    public void modify() {   //模拟对象进行修改
        observerSet.forEach(Observer::update);   //当对象发生修改时，会通知所有的观察者，并进行方法回调
    }
}
```

接着我们就可以测试一下了：

```java
public static void main(String[] args) {
    Subject subject = new Subject();
    subject.observe(() -> System.out.println("我是一号观察者！"));
    subject.observe(() -> System.out.println("我是二号观察者！"));
    subject.modify();
}
```

这样，我们就简单实现了一下观察者模式，当然JDK也为我们提供了实现观察者模式相关的接口：

```java
import java.util.Observable;    //java.util包下提供的观察者抽象类

public class Subject extends Observable {   //继承此抽象类表示支持观察者

    public void modify(){
        System.out.println("对对象进行修改！");
        this.setChanged();    //当对对象修改后，需要setChanged来设定为已修改状态
        this.notifyObservers(new Date());   //使用notifyObservers方法来通知所有的观察者
      	//注意只有已修改状态下通知观察者才会有效，并且可以给观察者传递参数，这里传递了一个时间对象
    }
}
```

我们来测试一下吧：

```java
public static void main(String[] args) {
    Subject subject = new Subject();
    subject.addObserver((o, arg) -> System.out.println("监听到变化，并得到参数："+arg));  
  	//注意这里的Observer是java.util包下提供的
    subject.modify();   //进行修改操作
}
```

## 状态模式

在标准大气压下，水在0度时会结冰变成固态，在0-100度之间时，会呈现液态，100度以上会变成气态，水这种物质在不同的温度下呈现出不同的状态，而我们的对象，可能也会像这样存在很多种状态，甚至在不同的状态下会有不同的行为，我们就可以通过状态模式来实现。

![image-20220527215236172](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2nayq0qf7j21780comxv.jpg)

我们来设计一个学生类，然后学生的学习方法会根据状态不同而发生改变，我们先设计一个状态枚举：

```java
public enum State {   //状态直接使用枚举定义
    NORMAL, LAZY
}
```

接着我们来编写一个学生类：

```java
public class Student {

    public class Student {

    private State state;   //使用一个成员来存储状态

    public void setState(State state) {
        this.state = state;
    }

    public void study(){  
        switch (state) {   //根据不同的状态，学习方法会有不同的结果
            case LAZY:
                System.out.println("只要我不努力，老板就别想过上想要的生活，开摆！");
                break;
            case NORMAL:
                System.out.println("拼搏百天，我要上清华大学！");
                break;
        }
    }
}
```

我们来看看，在不同的状态下，是否学习会出现不同的效果：

```java
public static void main(String[] args) {
    Student student = new Student();
    student.setState(State.NORMAL);   //先正常模式
    student.study();

    student.setState(State.LAZY);   //开启摆烂模式
    student.study();
}
```

状态模式更加强调当前的对象所处的状态，我们需要根据对象不同的状态决定其他的处理逻辑。

## 策略模式

对面卡兹克打野被开了，我们是去打小龙还是打大龙呢？这就要看我们团队这一局的打法策略了。

![image-20220527222552772](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2nbxb021mj20ww0aotb1.jpg)

我们可以为对象设定一种策略，这样对象之后的行为就会按照我们在一开始指定的策略而决定了，看起来和前面的状态模式很像，但是，它与状态模式的区别在于，这种转换是“主动”的，是由我们去指定，而状态模式，可能是在运行过程中自动切换的。

其实策略模式我们之前也遇到过，比如线程池的拒绝策略：

```java
public static void main(String[] args) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
            TimeUnit.SECONDS, new SynchronousQueue<>(),  //这里不给排队
            new ThreadPoolExecutor.AbortPolicy());   //当线程池无法再继续创建新任务时，我们可以自由决定使用什么拒绝策略

    Runnable runnable = () -> {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };
    
    executor.execute(runnable);   //连续提交两次任务，肯定塞不下，这时就得走拒绝了
    executor.execute(runnable);
}
```

可以看到，我们如果使用AbortPolicy，那么就是直接抛出异常：

![image-20220527223231753](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2nc480yhjj21ga034aap.jpg)

我们也可以使用其他的策略：

```java
public static void main(String[] args) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
            TimeUnit.SECONDS, new SynchronousQueue<>(),
            new ThreadPoolExecutor.DiscardOldestPolicy());   //使用DiscardOldestPolicy策略从队列中丢弃
```

这种策略就会从等待队列中踢出一个之前的，不过我们这里的等待队列是没有容量的那种，所以会直接炸掉：

![image-20220527223510016](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2nc6ypzsnj21200220sw.jpg)

至于具体原因，可以回去看看JUC篇视频教程。

再比如我们现在有一个排序类，但是根据不同的策略，会使用不同的排序方案：

```java
public interface Strategy {   //策略接口，不同的策略实现也不同

    Strategy SINGLE = Arrays::sort;   //单线程排序方案
    Strategy PARALLEL = Arrays::parallelSort;   //并行排序方案
    
    void sort(int[] array);
}
```

现在我们编写一个排序类：

```java
public class Sorter {

    private Strategy strategy;   //策略

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array){
        strategy.sort(array);
    }
}
```

现在我们就可以指定不同的策略进行排序了：

```java
public static void main(String[] args) {
    Sorter sorter = new Sorter();
    sorter.setStrategy(Strategy.PARALLEL);    //指定为并行排序方案
    
    sorter.sort(new int[]{9, 2, 4, 5, 1, 0, 3, 7});
}
```

## 访问者模式

公园中存在多个景点，也存在多个游客，不同的游客对同一个景点的评价可能不同；医院医生开的处方单中包含多种药元素，査看它的划价员和药房工作人员对它的处理方式也不同，划价员根据处方单上面的药品名和数量进行划价，药房工作人员根据处方单的内容进行抓药，相对于处方单来说，划价员和药房工作人员就是它的访问者，不过访问者的访问方式可能会不同。

![image-20220527231226552](https://skrait-image1-hangzhou.oss-cn-hangzhou.aliyuncs.com/img/e6c9d24egy1h2nd9r7qzlj219u0dk432.jpg)

在我们的Java程序中，也可能会出现这种情况，我们就可以通过访问者模式来进行设计。

比如我们日以继夜地努力，终于在某某比赛赢得了冠军，而不同的人对于这分荣誉，却有着不同的反应：

```java
public class Prize {   //奖
    String name;   //比赛名称
    String level;    //等级

    public Prize(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
```

我们首先定义一个访问者接口：

```java
public interface Visitor {
    void visit(Prize prize);   //visit方法来访问我们的奖项
}
```

然后就是访问者相关的实现了：

```java
public class Teacher implements Visitor {   //指导老师作为一个访问者
    @Override
    public void visit(Prize prize) {   //它只关心你得了什么奖以及是几等奖，这也关乎老师的荣誉
        System.out.println("你得奖是什么奖？"+prize.name);
        System.out.println("你得了几等奖？"+prize.level);
    }
}
```

```java
public class Boss implements Visitor{    //你的公司老板作为一个访问者
    @Override
    public void visit(Prize prize) {   //你的老板只关心这些能不能为公司带来什么效益，奖本身并不重要
        System.out.println("你的奖项大么，能够为公司带来什么效益么？");
        System.out.println("还不如老老实实加班给我多干干，别去搞这些没用的");
    }
}
```

```java
public class Classmate implements Visitor{   //你的同学也可以作为一个访问者
    @Override
    public void visit(Prize prize) {   //你的同学也关心你得了什么奖，不过是因为你是他的奖学金竞争对手，他其实并不希望你得奖
        System.out.println("你得了"+prize.name+"奖啊，还可以");
        System.out.println("不过这个奖没什么含金量，下次别去了");
    }
}
```

```java
public class Family implements Visitor{    //你的家人也可以是一个访问者
    @Override
    public void visit(Prize prize) {   //你的家人并不是最关心你得了什么奖，而是先关心你自己然后才是奖项，他们才是真正希望你好的人。这个世界很残酷，可能你会被欺负得遍体鳞伤，可能你会觉得活着如此艰难，但是你的背后至少还有爱你的人，为了他们，怎能就此驻足。
        System.out.println("孩子，辛苦了，有没有好好照顾自己啊");
        System.out.println("你得了什么奖啊？"+prize.name+"，很不错，要继续加油啊！");
    }
}
```

可以看到，这里我们就设计了四种访问者，但是不同的访问者对于某一件事务的处理可能会不同。访问者模式把数据结构和作用于结构上的操作解耦，使得操作集合可相对自由地演化，我们上面就是将奖项本身的属性和对于奖项的不同操作进行了分离。
