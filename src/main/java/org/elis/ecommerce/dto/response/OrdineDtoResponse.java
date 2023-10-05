package org.elis.ecommerce.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrdineDtoResponse {
	
	private long idOrdine;
	private long idCiente;
	private List<RigaDordineDtoResponse> righe;
	private double prezzoTot;
	private LocalDateTime dataInvioOrdine;
	
	
	public OrdineDtoResponse() {
	}

	public long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public long getIdCiente() {
		return idCiente;
	}

	public void setIdCiente(long idCiente) {
		this.idCiente = idCiente;
	}

	public LocalDateTime getDataInvioOrdine() {
		return dataInvioOrdine;
	}

	public void setDataInvioOrdine(LocalDateTime dataInvioOrdine) {
		this.dataInvioOrdine = dataInvioOrdine;
	}

	public List<RigaDordineDtoResponse> getRighe() {
		return righe;
	}

	public void setRighe(List<RigaDordineDtoResponse> righe) {
		this.righe = righe;
	}

	public double getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}
	
	
	
}
