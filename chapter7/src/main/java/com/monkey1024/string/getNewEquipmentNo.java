package com.monkey1024.string;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class getNewEquipmentNo {

    /**
     * 生成规则设备编号:设备类型+五位编号（从1开始，不够前补0）
     *
     * @param equipmentType
     *              设备类型
     * @param equipmentNo
     *              最新设备编号
     * @return
     */
    public static String getNewEquipmentNo(String equipmentType, String equipmentNo){
        String newEquipmentNo = "00001";

        if(equipmentNo != null && !equipmentNo.isEmpty()){
            int newEquipment = Integer.parseInt(equipmentNo) + 1;
            newEquipmentNo = String.format(equipmentType + "%03d", newEquipment);
        }

        return newEquipmentNo;
    }

    public static void main(String[] args) {
        //生成日期序号如20211028
        LocalDate now = LocalDate.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        String nowTime = now.format(timeFormatter);

        String equipmentNo = getNewEquipmentNo.getNewEquipmentNo("SYXH", "00032");
        System.out.println("生成设备编号：" + equipmentNo + nowTime);
    }

}