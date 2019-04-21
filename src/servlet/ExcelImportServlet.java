package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Candidate;
import service.CandidateJsonService;
import service.ExcelImportService;


//导入excel
@WebServlet(name = "ExcelImportServlet")
public class ExcelImportServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求发送都是utf-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //文件路径   test.xlsx 文件在代码打包里面，给他这个excel放到C盘根目录下
        List<Candidate> list = parseExcel("/Users/fankun/IdeaProjects/PlanetLottery/candidate.xlsx");
        try {
            //保存
            new ExcelImportService().save(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存完重新打开首页，首页默认会查询

        //request.getRequestDispatcher("/index.jsp");
        response.sendRedirect("/lottery/uploadExcel.jsp");

    }




    // 解析Excel,读取内容,path Excel路径
    public static List<Candidate> parseExcel(String path) {
        List<Candidate> list = new ArrayList<Candidate>();
        File file = null;
        InputStream input = null;
        if (path != null && path.length() > 7) {
            // 判断文件是否是Excel(2003、2007)
            String suffix = path
                    .substring(path.lastIndexOf("."), path.length());
            file = new File(path);
            try {
                input = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                System.out.println("未找到指定的文件！");
            }
            // Excel2003
            if (".xls".equals(suffix)) {
                POIFSFileSystem fileSystem = null;
                // 工作簿
                HSSFWorkbook workBook = null;
                try {
                    fileSystem = new POIFSFileSystem(input);
                    workBook = new HSSFWorkbook(fileSystem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 获取第一个工作簿
                HSSFSheet sheet = workBook.getSheetAt(0);
                list = getContent((Sheet) sheet);
                // Excel2007
            } else if (".xlsx".equals(suffix)) {
                XSSFWorkbook workBook = null;
                try {
                    workBook = new XSSFWorkbook(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 获取第一个工作簿
                XSSFSheet sheet = workBook.getSheetAt(0);
                list = getContent(sheet);
            }
        } else {
            System.out.println("非法的文件路径!");
        }
        return list;
    }

    // 获取Excel内容
    public static List<Candidate> getContent(Sheet sheet) {
        List<Candidate> list = new ArrayList<Candidate>();
        // Excel数据总行数
        int rowCount = sheet.getPhysicalNumberOfRows();
        // 遍历数据行，略过标题行，从第二行开始
        for (int i = 1; i < rowCount; i++) {
            Candidate ub = new Candidate();
            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();
            // 遍历行单元格
            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                switch (j) {
                    case 0:
                        // 根据cell中的类型来输出数据
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            ub.setCandidateid((int)cell.getNumericCellValue());
                        }
                        break;
                    case 1:
                        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            ub.setCandidatename(cell.getStringCellValue());
                        }
                        break;

                }
            }
            list.add(ub);
        }
        return list;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
