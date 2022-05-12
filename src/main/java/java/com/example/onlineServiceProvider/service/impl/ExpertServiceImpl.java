package java.com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.user.Expert;
import java.com.example.onlineServiceProvider.repository.ExpertRepo;
import java.com.example.onlineServiceProvider.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ExpertServiceImpl implements ExpertService {


    private ExpertRepo expertRepo;

    public ExpertServiceImpl(ExpertRepo expertRepo) {
        this.expertRepo = expertRepo;
    }


    @Override
    @Transactional
    public void addService(Expert expert, C_Service service) {
        expert.addExpertCommercialService(service);
        expertRepo.save(expert);
    }

    @Override
    @Transactional
    public void removeService(Expert expert, C_Service service) {
        expert.removeExpertCommercialService(service);
        expertRepo.save(expert);
    }

    @Override
    @Transactional
    public List<Expert> filterByService(C_Service service) {
        return expertRepo.findByExpertCServices(service.getId());
    }
}
