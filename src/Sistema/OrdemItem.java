package Sistema;

public class OrdemItem {
	private Integer quantidade;
	private Double preco;
	
	private Produto produto;
	
	public OrdemItem() {

	}

	public OrdemItem(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = produto.getPreco();
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double total (Integer quantidade, Double preco) {
		return quantidade*preco;	
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(produto.getName() + ", ");
		sb.append("$" +preco + ",");
		sb.append("Quantidade: " + quantidade + ", ");
		sb.append("Subtotal: $" +total(quantidade, preco));
		return sb.toString();
		}

}
