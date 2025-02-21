package Demo_Rest.Serv;

import Demo_Rest.Model.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReposervTest {

    @Mock
    private Reposerv reposerv;

    @Test
    void testCreateData() {
        Vendor vendor = new Vendor(1, "Nana", "Patekar", "SataraPune");
        when(reposerv.Createdata(vendor)).thenReturn("Successfully added");
        String result = reposerv.Createdata(vendor);
        assertEquals("Successfully added", result);
        verify(reposerv, times(1)).Createdata(vendor);
    }

    @Test
    void testUpdateData() {
        Vendor vendor = new Vendor(2, "nana", "deee", "Lohgav");
        when(reposerv.Updatedata(vendor)).thenReturn("Successfully updated");
        String result = reposerv.Updatedata(vendor);
        assertEquals("Successfully updated", result);
        verify(reposerv, times(1)).Updatedata(vendor);
    }

    @Test
    void testDeleteData() {
        when(reposerv.Deletedata("1")).thenReturn("Successfully deleted");
        String result = reposerv.Deletedata("1");
        assertEquals("Successfully deleted", result);
        verify(reposerv, times(1)).Deletedata("1");
    }

    @Test
    void testGetData() {
        Vendor vendor = new Vendor(3, "Saurya", "Thakur", "Nagpur");
        when(reposerv.getdata("3")).thenReturn(vendor);
        Vendor result = reposerv.getdata("3");
        assertNotNull(result);
        verify(reposerv, times(1)).getdata("3");
    }

    @Test
    void testGetAllData() {
        List<Vendor> vendors = Arrays.asList(
                new Vendor(1, "Nana", "Patekar", "SataraPune"),
                new Vendor(2, "nana", "deee", "Lohgav")
        );
        when(reposerv.getalldata()).thenReturn(vendors);
        List<Vendor> result = reposerv.getalldata();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(reposerv, times(1)).getalldata();
    }
}
