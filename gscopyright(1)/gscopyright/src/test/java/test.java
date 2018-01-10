import com.seu.dao.DBSetting;
import com.seu.dao.PageinfoDAO;
import com.seu.model.Pageinfo;
import com.seu.service.impl.CopyrightSearchServiceImpl;

/**
 * Created by SUN on 2017.12.21.
 */
public class test {
    public static void main(String[] args) throws Exception {
        PageinfoDAO pageinfoDAO = new PageinfoDAO();
        pageinfoDAO.setDbSetting(new DBSetting());
//        for(Pageinfo p : pageinfoDAO.copyrightSearch(2))
//            System.out.println(p.get_id()+p.getTitle());
        CopyrightSearchServiceImpl c = new CopyrightSearchServiceImpl();
        c.pageinfoDAO=pageinfoDAO;
        System.out.println(c.pagination(2,"hhttpp"));
    }
}
