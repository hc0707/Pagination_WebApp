package in.harsh.daofactory;

import in.harsh.persistence.FlowersDaoImpl;
import in.harsh.persistence.IFlowersDao;

public class FlowersDaoFactory {
    private static IFlowersDao studentDao=null;

    private FlowersDaoFactory() {
    }

    public static IFlowersDao getBankAccountDao(){
        if (studentDao==null) {
            studentDao = new FlowersDaoImpl();
        }
        return studentDao;
    }
    
}
