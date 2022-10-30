package excel;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
public class TestOperationExcel {

    private static String fileName = "E://JZ工作//丽水固危废管家//测试文件夹//青田县固危废企业信息普查统计表测试.xlsx";

    public static void main(String[] args) throws Exception{
        createExcelWithImage();
    }

    public static void createExcelWithImage() throws Exception {
        //创建一个excel文件，名称为：
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个sheet，名称为工作簿1
        XSSFSheet sheet = workbook.createSheet("工作簿测试1");

        BufferedImage bufferImg = null;
        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        String imageUrl = "https://profile-avatar.csdnimg.cn/9d7d1bacda2240c4887045be99d6190a_sk879095092.jpg";

        //获取图片后缀
        String imageType = imageUrl.substring(imageUrl.length()-3);
        File imageFile = new File("./temp." + imageType);
        FileUtils.copyURLToFile(new URL(imageUrl), imageFile);
        bufferImg = ImageIO.read(imageFile);
        ImageIO.write(bufferImg, imageType, byteArrayOut);

        //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        //anchor主要用于设置图片的属性
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, (short) 2, 2, (short) 4, 4);
        anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
        //插入图片
        patriarch.createPicture(anchor, workbook.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
    }
}
