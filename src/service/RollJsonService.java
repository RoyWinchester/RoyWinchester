package service;
import java.util.List;

import dao.RollJsonDao;
import model.Roll;

public class RollJsonService {
    //转盘业务层
    RollJsonDao dao = new RollJsonDao();

    //查询所有用户
    public List<Roll> finall() {
        return dao.finall();
    }
}
