package org.idempierelbr.cnab240febraban.annotated;

import java.util.Date;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatDecimal;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatPattern;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record
public class CNABSegmentURecord extends CNABSegmentBaseRecord {

	private int codigoMovimento;
	private Double valorAcrescimos;
	private Double valorDesconto;
	private Double valorAbatimento;
	private Double valorIOF;
	private Double valorPago;
	private Double valorLiquido;
	private Double outrasDespesas;
	private Double outrosCreditos;
	private Date dataOcorrencia;
	private Date dataCredito;

	public CNABSegmentURecord() {
		super();
		this.setTipoSegmento("U");
	}
	
	@Field( offset=16 , length=2, paddingChar='0' , align = Align.RIGHT)
	public int getCodigoMovimento() {
		return codigoMovimento;
	}
	public void setCodigoMovimento(int codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	@Field( offset=18 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorAcrescimos() {
		return valorAcrescimos;
	}
	public void setValorAcrescimos(Double valorAcrescimos) {
		this.valorAcrescimos = valorAcrescimos;
	}
	

	@Field( offset=33 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	@Field( offset=48 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorAbatimento() {
		return valorAbatimento;
	}
	public void setValorAbatimento(Double valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}
	
	@Field( offset=63 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorIOF() {
		return valorIOF;
	}
	public void setValorIOF(Double valorIOF) {
		this.valorIOF = valorIOF;
	}
	
	@Field( offset=78 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	@Field( offset=93 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Field( offset=108 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getOutrasDespesas() {
		return outrasDespesas;
	}
	public void setOutrasDespesas(Double outrasDespesas) {
		this.outrasDespesas = outrasDespesas;
	}
	
	@Field( offset=123 , length=15, paddingChar='0' , align = Align.RIGHT)
	@FixedFormatDecimal( decimals = 2 , useDecimalDelimiter = false )
	public Double getOutrosCreditos() {
		return outrosCreditos;
	}
	public void setOutrosCreditos(Double outrosCreditos) {
		this.outrosCreditos = outrosCreditos;
	}
	
	@Field( offset=138 , length=8 )
	@FixedFormatPattern("ddMMyyyy")
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	
	@Field( offset=146 , length=8 )
	@FixedFormatPattern("ddMMyyyy")
	public Date getDataCredito() {
		return dataCredito;
	}
	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}
	
}
