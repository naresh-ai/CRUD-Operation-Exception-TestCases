package Demo_Rest.Reposrty;

import Demo_Rest.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repo extends JpaRepository<Vendor ,String> {


}
