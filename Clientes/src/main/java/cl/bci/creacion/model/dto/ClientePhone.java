package cl.bci.creacion.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente_phone")
public class ClientePhone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String clienteId;
	private String number;
	private String citycode;
	private String contrycode;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContrycode() {
		return contrycode;
	}
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public ClientePhone(long id, String number, String citycode, String contrycode) {
		super();
		this.id = id;
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}
	public ClientePhone() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
