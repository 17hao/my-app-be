package xyz.shiqihao.common.utils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import xyz.shiqihao.app.model.User;

@Log4j2
public class ExcelUtil {
    public static void write(String fileName, List<User> users) {
        final String localFilePath = "tmp/" + fileName + ".xlsx";
        try (Workbook wb = new XSSFWorkbook(); FileOutputStream fos = new FileOutputStream(localFilePath)) {
            Sheet sheet = wb.createSheet();
            Row row0 = sheet.createRow(0);
            row0.createCell(0).setCellValue("id");
            row0.createCell(1).setCellValue("name");

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);

                Row row = sheet.createRow(i + 1);

                Cell cell0 = row.createCell(0);
                cell0.setCellValue(u.getId());
                cell0.setCellStyle(cellStyle);

                Cell cell1 = row.createCell(1);
                cell1.setCellValue(u.getName());
                cell1.setCellStyle(cellStyle);
            }
            wb.write(fos);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User u1 = new User(1L);
        u1.setName("u1");
        users.add(u1);
        ExcelUtil.write("2024-09-05", users);
    }
}
