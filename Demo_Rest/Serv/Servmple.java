package Demo_Rest.Serv;

import Demo_Rest.Model.Vendor;
import Demo_Rest.Reposrty.Repo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Servmple implements  Reposerv {

    Repo repo;

    public Servmple(Repo repo) {
        this.repo = repo;
    }

    @Override
    public String Createdata(Vendor vendor) {
         repo.save(vendor);
         return "Done Save Data";

    }

    @Override
    public String Updatedata(Vendor vendor) {
        repo.save( vendor);
        return " Success update data" ;
    }

    @Override
    public String Deletedata(String Vendorid) {
        repo.deleteById(Vendorid);
        return " Delete Data from Database";
    }

    @Override
    public Vendor getdata(String id) {
       return repo.findById(id).get();


    }

    @Override
    public List<Vendor> getalldata() {
        return repo.findAll();
    }
}
