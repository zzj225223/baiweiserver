package sn.sxt.baiweiserver.config;

import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import sn.sxt.baiweiserver.bean.Position;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-22 16:11
 */
public class POIUtils {
    public static ResponseEntity<byte[]> exportExcel(List<Position> positions) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        SummaryInformation information = workbook.getSummaryInformation();
        information.setTitle("职位表");
        information.setAuthor("javaboy");
        information.setComments("备注");
        HSSFSheet hssfSheet = workbook.createSheet("职位表");
        HSSFRow row0 = hssfSheet.createRow(0);
        HSSFCell c0 = row0.createCell(0);
        HSSFCell c1 = row0.createCell(1);
        HSSFCell c2 = row0.createCell(2);
        HSSFCell c3 = row0.createCell(3);
        c0.setCellValue("编号");
        c1.setCellValue("名称");
        c2.setCellValue("创建时间");
        c3.setCellValue("是否启用");
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        for (int i = 0; i < positions.size(); i++) {
            HSSFRow r = hssfSheet.createRow(i + 1);
            HSSFCell cell0 = r.createCell(0);
            Position p = positions.get(i);
            ((HSSFCell) cell0).setCellValue(p.getId());
            HSSFCell cell1 = r.createCell(1);
            ((HSSFCell) cell1).setCellValue(p.getName());
            HSSFCell cell2 = r.createCell(2);
            cell2.setCellStyle(dateCellStyle);
            ((HSSFCell) cell2).setCellValue(p.getCreatedate());
            HSSFCell cell3 = r.createCell(3);
            ((HSSFCell) cell3).setCellValue(p.getEnabled() ? "是" : "否");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",
                new String("职位表222.xls".getBytes("UTF-8"), "iso-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<Position> parseFile(MultipartFile file) {
        List<Position> list = new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rows; i++) {
                HSSFRow r = sheet.getRow(i);
                double numericCellValue = r.getCell(0).getNumericCellValue();
                String name = r.getCell(1).getStringCellValue();
                Date createdate = r.getCell(2).getDateCellValue();
                boolean enabled = "是".equals(r.getCell(3).getStringCellValue());
                Position position = new Position();
                position.setEnabled(enabled);
                position.setCreatedate(createdate);
                position.setName(name);
                position.setId((int) numericCellValue);
                list.add(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
}
