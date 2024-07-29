package com.devsuperior.dev_superior_desafio_01;

import com.devsuperior.dev_superior_desafio_01.order.Order;
import com.devsuperior.dev_superior_desafio_01.order.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevSuperiorDesafio01Application implements CommandLineRunner {

	private final OrderService orderService;

	public DevSuperiorDesafio01Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DevSuperiorDesafio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		processOrder(new Order(1034, 150D, 20D));
		processOrder(new Order(2282, 800D, 10D));
		processOrder(new Order(1309, 95.9D, 0D));

	}

	public void processOrder(Order order){

		try{
			double total = this.orderService.total(order);

			System.out.println(String.format("Pedido Código %d", order.getCode()));
			System.out.println(String.format("Valor Total: R$ %.2f", total));

		}catch (Exception ex){
			System.err.println("Erro ao processar o pedido " + order.getCode() + ": " + ex.getMessage());
		}

	}

}
