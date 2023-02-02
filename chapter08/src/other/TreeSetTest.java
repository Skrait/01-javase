package other;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author Peekaboo
 * @date 2023年01月09日 17:42
 * TreeSet:无需不可重复,按照元素大小自动排序
 */
public class TreeSetTest {

    @Test
    public void TreeSetTest1(){
        TreeSet<Integer> ts = new TreeSet<>();
        // 添加元素
        ts.add(1);
        ts.add(100);
        ts.add(10);
        ts.add(0);
        ts.add(15);
        System.out.println(ts);
    }


    /**
     * TreeSet/TreeMap底层都采用的是自平衡二叉树(TreeSet底层是TreeMap): 遵循左小右大的原则存放，存放的过程也就是排序的过程
     *
     * 遍历二叉树的三种方式: (note:左永远在右的左边)
     *
     * 前序遍历: 根左右
     * 中序遍历:左根右 (满足自平衡二叉树的存放方式，中序遍历取出数据的时候就为自动排序好的数据)
     * 后序遍历:左右根
     * TreeSet/TreeMap集合采用的是：中序遍历
     *
     * 二叉树的遍历均可以看成是递归的过程，也就是将一个树不断的划分成左子树、根、右子树的过程，直到不能再划分成一个子树
     */
}
