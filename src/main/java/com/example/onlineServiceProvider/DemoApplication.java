package com.example.onlineServiceProvider;
import com.example.onlineServiceProvider.entity.c_service.C_Service;
import com.example.onlineServiceProvider.entity.c_service.defaultService.MainServices;
import com.example.onlineServiceProvider.entity.offer.Offer;
import com.example.onlineServiceProvider.entity.order.Order;
import com.example.onlineServiceProvider.entity.user.Address;
import com.example.onlineServiceProvider.entity.user.Customer;
import com.example.onlineServiceProvider.entity.user.Expert;
import com.example.onlineServiceProvider.entity.user.SignUpStatus;
import com.example.onlineServiceProvider.service.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.List;


@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Component
	class OnStartup implements ApplicationRunner {

		private AdminService adminService;
		private C_Service_Service c_service_service;
		private CustomerService customerService;
		private ExpertService expertService;
		private OfferService offerService;
		private OrderService orderService;
		private BaseService baseService;

		public OnStartup(AdminService adminService,C_Service_Service c_service_service
		,CustomerService customerService,ExpertService expertService
		,OfferService offerService,OrderService orderService,BaseService baseService)

		{
			this.adminService = adminService;
			this.c_service_service = c_service_service;
			this.customerService = customerService;
			this.expertService = expertService;
			this.offerService = offerService;
			this.orderService = orderService;
			this.baseService=baseService;
		}

		@Override
		public void run(ApplicationArguments args) {


			//1 adding some services
			C_Service service1=new C_Service();
			service1.setBasePrice(5000);
			service1.setName(MainServices.CLEANING.toString());

			C_Service service2=new C_Service();
			service2.setBasePrice(6000);
			service2.setName(MainServices.HOME_DECORATION.toString());
			baseService.add(service1);
			baseService.add(service2);


			//2 adding orders by customer
			Customer customer=new Customer();
			customer.setBalance(560000);
			customer.setUsername("username");
			customer.setPassword("password12345678");
			customer.setEmail("newEmail");
			baseService.add(customer);

			Address address=new Address();
			baseService.add(address);

			Order order=new Order();
			order.setOrderCustomer(customer);
			Date date=new Date(System.currentTimeMillis());

			order.setCService(service1);
			order.setOrderDate(date);
			order.setOrderAddress(address);
			order.setCustomerPriceOffer(6200);
			orderService.addOrder(order);


			//3 adding offers by expert
			Expert expert1=new Expert();
			expert1.setUsername("expert1Username");
			expert1.setPassword("expert1Password");
			expert1.setEmail("expert1Email");
			expert1.setSignUpStatus(SignUpStatus.SUBMITTED);
			baseService.add(expert1);

			Expert expert2=new Expert();
			expert2.setUsername("expert2Username");
			expert2.setPassword("expert2Password");
			expert2.setEmail("expert2Email");
			expert2.setSignUpStatus(SignUpStatus.SUBMITTED);
			baseService.add(expert2);

			Offer offer1=new Offer();
			offer1.setOfferOrder(order);
			offer1.setOfferExpert(expert1);
			offer1.setOfferedPrice(340);

//			Offer offer2=new Offer();
//			offer2.setOfferOrder(order);
//			offer2.setOfferExpert(expert2);
//			offer2.setOfferedPrice(445);

			offerService.addOffer(offer1);
//			offerService.addOffer(offer2);



//			//4 show offer list of an order
//			List<Offer> orderOffers=orderService.orderOffers(order.getId());
//
//
//
//			//5 select offer by customer
//			orderService.selectOfferByCustomer(order,offer2);
//
//
//
//			//6 expert accepting the offer
//			orderService.orderSelectByExpert(order);
//
//
//			//7 start order
//			orderService.orderStart(order);
//
//
//
//			//8 order finish
//			orderService.orderFinish(order,4);

		}
	}
}
