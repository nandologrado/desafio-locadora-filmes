package br.com.moviestore.dto;

import java.util.List;

public class MensagemDTO {
	private String status;
	private String messagem;
	private List<Object> obj;
	
	public MensagemDTO(String status, String messagem, List<Object> obj) {
		this.status = status;
		this.messagem = messagem;
		this.obj = obj;
	}

	public MensagemDTO() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

	public List<Object> getObj() {
		return obj;
	}

	public void setObj(List<Object> obj) {
		this.obj = obj;
	}
}
