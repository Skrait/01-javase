package builder.demo;

import org.testng.annotations.Test;

/**
 * @author Peekaboo
 * @date 2023年01月04日 16:09
 */
public class BuilderTest {

    /**
     * 指挥具体工人建造
     */
    @Test
    public void builderTest(){
        //创建指挥
        Director director = new Director();
        Product build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
