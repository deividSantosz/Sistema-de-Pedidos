package Sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entitities.enums.OrderStatus;

public class Pedido {
	private Date moment;
	private OrderStatus status;
	
	private Cliente cliente;
	private List <OrdemItem> itens = new ArrayList<>();
	
	public Pedido () {
		
	}

	public Pedido(Date moment, OrderStatus status, Cliente cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;

	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemItem> getItens() {
		return itens;

	}
	
	public void addItem (OrdemItem item) {
		itens.add(item);
	}
	public void removeItem(OrdemItem item) {
		itens.remove(item);
	}

	public Double TotalPedido () {
		Double res = 0.0;
		for (OrdemItem i : itens) {
			res = res + i.total(i.getQuantidade(), i.getPreco());
		}
		return res;
}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (OrdemItem l : itens) {
			sb.append(l + "\n");
		}
		return sb.toString();
	}
}
