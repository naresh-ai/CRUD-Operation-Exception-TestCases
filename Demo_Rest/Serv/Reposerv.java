package Demo_Rest.Serv;

import Demo_Rest.Model.Vendor;

import java.util.List;

public interface Reposerv {
    public String Createdata(Vendor vendor);
    public String Updatedata(Vendor vendor);
    public  String Deletedata (String id);
    public  Vendor getdata(String id );
    public List<Vendor> getalldata();
}
