public class StringBuilderTest01 {
    public static void main(String[] args) {

        StringBuilder bindUrl = new StringBuilder();
        bindUrl.append("contentPath").append("/common/bind.html").append("?uuid=").append("uuid");
        bindUrl.append("&redirectUrl=").append("redirectUrl");
        bindUrl.append("&msg=").append("信息字段！");
        System.out.println(bindUrl.toString());


    }
}
