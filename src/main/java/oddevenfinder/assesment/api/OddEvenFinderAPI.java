package oddevenfinder.assesment.api;


import oddevenfinder.assesment.module.FinderModule;
import oddevenfinder.assesment.service.FinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OddEvenFinderAPI {

    @Autowired
    FinderService finderService;

    @PostMapping("/findOddEven")
    public FinderModule findOddEven(@RequestBody FinderModule finderModule) {

        return finderService.findOddEven(finderModule);

    }


}