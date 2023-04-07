package in.harsh.servicefactory;

import in.harsh.service.FlowersServiceImpl;
import in.harsh.service.IFlowersService;

public class FlowersServiceFactory {
    private static IFlowersService bankAccountService=null;

    private FlowersServiceFactory() {
    }
    public static IFlowersService getBankAccountService(){
        if (bankAccountService==null) {
            bankAccountService= new FlowersServiceImpl();
        }
        return bankAccountService;
    }
    
}
