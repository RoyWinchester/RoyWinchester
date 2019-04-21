package service;


import java.util.List;

import dao.ExcelImportDao;
import model.Candidate;

public class ExcelImportService {

    //保存导入的信息
    public void save(List<Candidate> list) {
        new ExcelImportDao().save(list);
    }

}

