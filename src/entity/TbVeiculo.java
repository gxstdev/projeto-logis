package entity;

public class TbVeiculo {
	private Integer id;
	private String placa;
	private TbEstado estado;
	private TbProprietario proprietario;

	public TbVeiculo(Integer id, String placa, TbEstado estado, TbProprietario proprietario) {
		this.id = id;
		this.placa = placa;
		this.estado = estado;
		this.proprietario = proprietario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TbEstado getEstado() {
		return estado;
	}

	public void setEstado(TbEstado estado) {
		this.estado = estado;
	}

	public TbProprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(TbProprietario proprietario) {
		this.proprietario = proprietario;
	}
	
}
