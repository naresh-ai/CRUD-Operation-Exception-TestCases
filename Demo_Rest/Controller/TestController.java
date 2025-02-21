package Demo_Rest.Controller;

import Demo_Rest.Model.Vendor;
import Demo_Rest.Serv.Servmple;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Test")
public class TestController {
    Servmple servmple;

    public TestController(Servmple servmple) {
        this.servmple = servmple;
    }
// all one data
    @GetMapping("{vendorid}")
    public Vendor getdata( @PathVariable("vendorid") String vendorid){
       return servmple.getdata(vendorid);

                //new Vendor(2,"Naresh","Petkar","Pune");

    }
    // call all data
    @GetMapping
    public List<Vendor> getalldata(){
        return servmple.getalldata();

        //new Vendor(2,"Naresh","Petkar","Pune");

    }

    @PostMapping
    public  String createnewdata (@RequestBody Vendor vendor){
    servmple.Createdata(vendor);
    return "Suceesfullay add data";
    }

    @PutMapping
    public  String Updatedada(@RequestBody Vendor vendor){
        servmple.Updatedata(vendor);
    return "Ok Suceessfull updated";

    }

    @DeleteMapping("{Vendorid}")
    public  String Deletedata(@PathVariable("Vendorid") String Vendorid){
    servmple.Deletedata(Vendorid);
    return "Ok succefully delete";

    }

}
