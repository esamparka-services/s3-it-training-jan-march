package oddevenfinder.assesment.service;

import oddevenfinder.assesment.module.FinderModule;
import org.springframework.stereotype.Service;

@Service
public class FinderService {


    public FinderModule findOddEven(FinderModule finderModule) {
        if ((finderModule.getNumber() % 2 == 0)) {
            finderModule.setType("even");
        } else {
            finderModule.setType("odd");
        }

            return finderModule;
        }


    }
