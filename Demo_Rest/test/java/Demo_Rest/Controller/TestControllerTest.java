package Demo_Rest.Controller;

import Demo_Rest.Model.Vendor;
import Demo_Rest.Serv.Servmple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

    @Mock
    private Servmple servmple;

    @InjectMocks
    private TestController testController;

    private MockMvc mockMvc;

    @Test
    void testGetdata() throws Exception {
        Vendor vendor = new Vendor(1, "John", "Doe", "New York");
        when(servmple.getdata("1")).thenReturn(vendor);

        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/Test/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstname").value("John"))
                .andExpect(jsonPath("$.lastname").value("Doe"))
                .andExpect(jsonPath("$.location").value("New York"));
    }

    @Test
    void testGetAllData() throws Exception {
        List<Vendor> vendors = Arrays.asList(
                new Vendor(1, "John", "Doe", "New York"),
                new Vendor(2, "Jane", "Smith", "California")
        );
        when(servmple.getalldata()).thenReturn(vendors);

        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testCreateNewData() throws Exception {
        Vendor vendor = new Vendor(3, "Alice", "Brown", "Texas");
        doNothing().when(servmple).Createdata(any(Vendor.class));

        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/Test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":3,\"firstname\":\"Alice\",\"lastname\":\"Brown\",\"location\":\"Texas\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Suceesfullay add data"));
    }

    @Test
    void testUpdateData() throws Exception {
        Vendor vendor = new Vendor(3, "Alice", "Brown", "Texas");
        doNothing().when(servmple).Updatedata(any(Vendor.class));

        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();

        mockMvc.perform(MockMvcRequestBuilders.put("/Test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":3,\"firstname\":\"Alice\",\"lastname\":\"Brown\",\"location\":\"Texas\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ok Suceessfull updated"));
    }

    @Test
    void testDeleteData() throws Exception {
        doNothing().when(servmple).Deletedata("3");

        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/Test/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ok succefully delete"));
    }
}
