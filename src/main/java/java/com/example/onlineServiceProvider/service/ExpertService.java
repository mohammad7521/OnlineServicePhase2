package java.com.example.onlineServiceProvider.service;




import java.com.example.onlineServiceProvider.entity.c_service.C_Service;
import java.com.example.onlineServiceProvider.entity.user.Expert;
import java.util.List;

public interface ExpertService  {

    //adding a C_Service as services of an expert.
    public void addService(Expert expert, C_Service service);


    //removing a C_Service from services of an expert.
    public void removeService(Expert expert,C_Service service);



    //filtering experts by services.
    public List<Expert> filterByService(C_Service c_service);
}
