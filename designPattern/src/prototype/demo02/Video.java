package prototype.demo02;

import java.util.Date;

/**
 * @author Peekaboo
 * @date 2023年01月04日 17:41
 * Video
 * 拷贝过程:
 * 1：实现一个接口
 * 2：重写一个方法
 */
public class Video implements Cloneable{//无良up主，克隆别人视频

    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object obj = super.clone();
        Video v = (Video) obj;
        //讲对象属性进行克隆,实现深克隆
        v.setCreateTime((Date)this.createTime.clone());
        return obj;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
