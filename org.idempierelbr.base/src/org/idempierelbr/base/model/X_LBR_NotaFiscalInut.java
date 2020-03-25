/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.idempierelbr.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LBR_NotaFiscalInut
 *  @author iDempiere (generated) 
 *  @version Release 2.1 - $Id$ */
public class X_LBR_NotaFiscalInut extends PO implements I_LBR_NotaFiscalInut, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20150701L;

    /** Standard Constructor */
    public X_LBR_NotaFiscalInut (Properties ctx, int LBR_NotaFiscalInut_ID, String trxName)
    {
      super (ctx, LBR_NotaFiscalInut_ID, trxName);
      /** if (LBR_NotaFiscalInut_ID == 0)
        {
			setDocumentNo (null);
			setLBR_NFBModel (null);
			setLBR_NFeEnv (null);
			setLBR_NFeSerie (null);
			setLBR_Number_End (null);
			setLBR_Number_Start (null);
        } */
    }

    /** Load Constructor */
    public X_LBR_NotaFiscalInut (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LBR_NotaFiscalInut[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Document Date.
		@param DateDoc 
		Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc)
	{
		set_Value (COLUMNNAME_DateDoc, DateDoc);
	}

	/** Get Document Date.
		@return Date of the Document
	  */
	public Timestamp getDateDoc () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDoc);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Justification.
		@param LBR_Justification Justification	  */
	public void setLBR_Justification (String LBR_Justification)
	{
		set_Value (COLUMNNAME_LBR_Justification, LBR_Justification);
	}

	/** Get Justification.
		@return Justification	  */
	public String getLBR_Justification () 
	{
		return (String)get_Value(COLUMNNAME_LBR_Justification);
	}

	/** Set NF-e Lot Sending Protocol.
		@param LBR_LotSendingProt 
		Indicates the protocol of the sending process to Sefaz
	  */
	public void setLBR_LotSendingProt (String LBR_LotSendingProt)
	{
		set_Value (COLUMNNAME_LBR_LotSendingProt, LBR_LotSendingProt);
	}

	/** Get NF-e Lot Sending Protocol.
		@return Indicates the protocol of the sending process to Sefaz
	  */
	public String getLBR_LotSendingProt () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotSendingProt);
	}

	/** 100 - Autorizado o uso da NF-e = 100 */
	public static final String LBR_LOTSENDINGSTATUS_100_AutorizadoOUsoDaNF_E = "100";
	/** 101 - Cancelamento de NF-e homologado = 101 */
	public static final String LBR_LOTSENDINGSTATUS_101_CancelamentoDeNF_EHomologado = "101";
	/** 102 - Inutilização de número homologado = 102 */
	public static final String LBR_LOTSENDINGSTATUS_102_InutilizaçãoDeNúmeroHomologado = "102";
	/** 103 - Lote recebido com sucesso = 103 */
	public static final String LBR_LOTSENDINGSTATUS_103_LoteRecebidoComSucesso = "103";
	/** 104 - Lote processado = 104 */
	public static final String LBR_LOTSENDINGSTATUS_104_LoteProcessado = "104";
	/** 105 - Lote em processamento = 105 */
	public static final String LBR_LOTSENDINGSTATUS_105_LoteEmProcessamento = "105";
	/** 106 - Lote não localizado = 106 */
	public static final String LBR_LOTSENDINGSTATUS_106_LoteNãoLocalizado = "106";
	/** 107 - Serviço em Operação = 107 */
	public static final String LBR_LOTSENDINGSTATUS_107_ServiçoEmOperação = "107";
	/** 108 - Serviço Paralisado Momentaneamente (curto prazo) = 108 */
	public static final String LBR_LOTSENDINGSTATUS_108_ServiçoParalisadoMomentaneamenteCurtoPrazo = "108";
	/** 109 - Serviço Paralisado sem Previsão = 109 */
	public static final String LBR_LOTSENDINGSTATUS_109_ServiçoParalisadoSemPrevisão = "109";
	/** 110 - Uso Denegado = 110 */
	public static final String LBR_LOTSENDINGSTATUS_110_UsoDenegado = "110";
	/** 111 - Consulta cadastro com uma ocorrência = 111 */
	public static final String LBR_LOTSENDINGSTATUS_111_ConsultaCadastroComUmaOcorrência = "111";
	/** 112 - Consulta cadastro com mais de uma ocorrência = 112 */
	public static final String LBR_LOTSENDINGSTATUS_112_ConsultaCadastroComMaisDeUmaOcorrência = "112";
	/** 113 - SCAN será desabilitado para a UF às hh:mm = 113 */
	public static final String LBR_LOTSENDINGSTATUS_113_SCANSeráDesabilitadoParaAUFÀsHhMm = "113";
	/** 114 - SCAN desabilitado pela SEFAZ Origem = 114 */
	public static final String LBR_LOTSENDINGSTATUS_114_SCANDesabilitadoPelaSEFAZOrigem = "114";
	/** 128 - Lote de Evento Processado = 128 */
	public static final String LBR_LOTSENDINGSTATUS_128_LoteDeEventoProcessado = "128";
	/** 135 - Evento registrado e vinculado a NF-e = 135 */
	public static final String LBR_LOTSENDINGSTATUS_135_EventoRegistradoEVinculadoANF_E = "135";
	/** 136 - Evento registrado; mas não vinculado a NF-e = 136 */
	public static final String LBR_LOTSENDINGSTATUS_136_EventoRegistradoMasNãoVinculadoANF_E = "136";
	/** 137 - Nenhum documento localizado para o Destinatário = 137 */
	public static final String LBR_LOTSENDINGSTATUS_137_NenhumDocumentoLocalizadoParaODestinatário = "137";
	/** 138 - Documento localizado para o Destinatário = 138 */
	public static final String LBR_LOTSENDINGSTATUS_138_DocumentoLocalizadoParaODestinatário = "138";
	/** 139 - Pedido de Download processado = 139 */
	public static final String LBR_LOTSENDINGSTATUS_139_PedidoDeDownloadProcessado = "139";
	/** 140 - Download disponibilizado = 140 */
	public static final String LBR_LOTSENDINGSTATUS_140_DownloadDisponibilizado = "140";
	/** 150 - Autorizado o uso da NF-e = 150 */
	public static final String LBR_LOTSENDINGSTATUS_150_AutorizadoOUsoDaNF_E = "150";
	/** 151 - Cancelamento de NF-e homologado fora de prazo = 151 */
	public static final String LBR_LOTSENDINGSTATUS_151_CancelamentoDeNF_EHomologadoForaDePrazo = "151";
	/** 155 - Cancelamento de NF-e homologado fora de prazo = 155 */
	public static final String LBR_LOTSENDINGSTATUS_155_CancelamentoDeNF_EHomologadoForaDePrazo = "155";
	/** 201 - Rejeição: O numero máximo de numeração de NF-e a inutilizar ultrapassou o limite = 201 */
	public static final String LBR_LOTSENDINGSTATUS_201_RejeiçãoONumeroMáximoDeNumeraçãoDeNF_EAInutilizarUltrapassouOLimite = "201";
	/** 202 - Rejeição: Falha no reconhecimento da autoria ou integridade do arquivo digital = 202 */
	public static final String LBR_LOTSENDINGSTATUS_202_RejeiçãoFalhaNoReconhecimentoDaAutoriaOuIntegridadeDoArquivoDigital = "202";
	/** 203 - Rejeição: Emissor não habilitado para emissão da NF-e = 203 */
	public static final String LBR_LOTSENDINGSTATUS_203_RejeiçãoEmissorNãoHabilitadoParaEmissãoDaNF_E = "203";
	/** 204 - Rejeição: Duplicidade de NF-e = 204 */
	public static final String LBR_LOTSENDINGSTATUS_204_RejeiçãoDuplicidadeDeNF_E = "204";
	/** 205 - Rejeição: NF-e está denegada na base de dados da SEFAZ = 205 */
	public static final String LBR_LOTSENDINGSTATUS_205_RejeiçãoNF_EEstáDenegadaNaBaseDeDadosDaSEFAZ = "205";
	/** 206 - Rejeição: NF-e já está inutilizada na Base de dados da SEFAZ = 206 */
	public static final String LBR_LOTSENDINGSTATUS_206_RejeiçãoNF_EJáEstáInutilizadaNaBaseDeDadosDaSEFAZ = "206";
	/** 207 - Rejeição: CNPJ do emitente inválido = 207 */
	public static final String LBR_LOTSENDINGSTATUS_207_RejeiçãoCNPJDoEmitenteInválido = "207";
	/** 208 - Rejeição: CNPJ do destinatário inválido = 208 */
	public static final String LBR_LOTSENDINGSTATUS_208_RejeiçãoCNPJDoDestinatárioInválido = "208";
	/** 209 - Rejeição: IE do emitente inválida = 209 */
	public static final String LBR_LOTSENDINGSTATUS_209_RejeiçãoIEDoEmitenteInválida = "209";
	/** 210 - Rejeição: IE do destinatário inválida = 210 */
	public static final String LBR_LOTSENDINGSTATUS_210_RejeiçãoIEDoDestinatárioInválida = "210";
	/** 211 - Rejeição: IE do substituto inválida = 211 */
	public static final String LBR_LOTSENDINGSTATUS_211_RejeiçãoIEDoSubstitutoInválida = "211";
	/** 212 - Rejeição: Data de emissão NF-e posterior a data de recebimento = 212 */
	public static final String LBR_LOTSENDINGSTATUS_212_RejeiçãoDataDeEmissãoNF_EPosteriorADataDeRecebimento = "212";
	/** 213 - Rejeição: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital = 213 */
	public static final String LBR_LOTSENDINGSTATUS_213_RejeiçãoCNPJ_BaseDoEmitenteDifereDoCNPJ_BaseDoCertificadoDigital = "213";
	/** 214 - Rejeição: Tamanho da mensagem excedeu o limite estabelecido = 214 */
	public static final String LBR_LOTSENDINGSTATUS_214_RejeiçãoTamanhoDaMensagemExcedeuOLimiteEstabelecido = "214";
	/** 215 - Rejeição: Falha no schema XML = 215 */
	public static final String LBR_LOTSENDINGSTATUS_215_RejeiçãoFalhaNoSchemaXML = "215";
	/** 216 - Rejeição: Chave de Acesso difere da cadastrada = 216 */
	public static final String LBR_LOTSENDINGSTATUS_216_RejeiçãoChaveDeAcessoDifereDaCadastrada = "216";
	/** 217 - Rejeição: NF-e não consta na base de dados da SEFAZ = 217 */
	public static final String LBR_LOTSENDINGSTATUS_217_RejeiçãoNF_ENãoConstaNaBaseDeDadosDaSEFAZ = "217";
	/** 218 - Rejeição: NF-e já esta cancelada na base de dados da SEFAZ = 218 */
	public static final String LBR_LOTSENDINGSTATUS_218_RejeiçãoNF_EJáEstaCanceladaNaBaseDeDadosDaSEFAZ = "218";
	/** 219 - Rejeição: Circulação da NF-e verificada = 219 */
	public static final String LBR_LOTSENDINGSTATUS_219_RejeiçãoCirculaçãoDaNF_EVerificada = "219";
	/** 220 - Rejeição: Prazo de Cancelamento Superior ao Previsto na Legislação = 220 */
	public static final String LBR_LOTSENDINGSTATUS_220_RejeiçãoPrazoDeCancelamentoSuperiorAoPrevistoNaLegislação = "220";
	/** 221 - Rejeição: Confirmado o recebimento da NF-e pelo destinatário = 221 */
	public static final String LBR_LOTSENDINGSTATUS_221_RejeiçãoConfirmadoORecebimentoDaNF_EPeloDestinatário = "221";
	/** 222 - Rejeição: Protocolo de Autorização de Uso difere do cadastrado = 222 */
	public static final String LBR_LOTSENDINGSTATUS_222_RejeiçãoProtocoloDeAutorizaçãoDeUsoDifereDoCadastrado = "222";
	/** 223 - Rejeição: CNPJ do transmissor do lote difere do CNPJ do transmissor da consulta = 223 */
	public static final String LBR_LOTSENDINGSTATUS_223_RejeiçãoCNPJDoTransmissorDoLoteDifereDoCNPJDoTransmissorDaConsulta = "223";
	/** 224 - Rejeição: A faixa inicial é maior que a faixa final = 224 */
	public static final String LBR_LOTSENDINGSTATUS_224_RejeiçãoAFaixaInicialÉMaiorQueAFaixaFinal = "224";
	/** 225 - Rejeição: Falha no Schema XML da NFe = 225 */
	public static final String LBR_LOTSENDINGSTATUS_225_RejeiçãoFalhaNoSchemaXMLDaNFe = "225";
	/** 226 - Rejeição: Código da UF do Emitente diverge da UF autorizadora = 226 */
	public static final String LBR_LOTSENDINGSTATUS_226_RejeiçãoCódigoDaUFDoEmitenteDivergeDaUFAutorizadora = "226";
	/** 227 - Rejeição: Erro na Chave de Acesso - Campo ID = 227 */
	public static final String LBR_LOTSENDINGSTATUS_227_RejeiçãoErroNaChaveDeAcesso_CampoID = "227";
	/** 228 - Rejeição: Data de Emissão muito atrasada = 228 */
	public static final String LBR_LOTSENDINGSTATUS_228_RejeiçãoDataDeEmissãoMuitoAtrasada = "228";
	/** 229 - Rejeição: IE do emitente não informada = 229 */
	public static final String LBR_LOTSENDINGSTATUS_229_RejeiçãoIEDoEmitenteNãoInformada = "229";
	/** 230 - Rejeição: IE do emitente não cadastrada = 230 */
	public static final String LBR_LOTSENDINGSTATUS_230_RejeiçãoIEDoEmitenteNãoCadastrada = "230";
	/** 231 - Rejeição: IE do emitente não vinculada ao CNPJ = 231 */
	public static final String LBR_LOTSENDINGSTATUS_231_RejeiçãoIEDoEmitenteNãoVinculadaAoCNPJ = "231";
	/** 232 - Rejeição: IE do destinatário não informada = 232 */
	public static final String LBR_LOTSENDINGSTATUS_232_RejeiçãoIEDoDestinatárioNãoInformada = "232";
	/** 233 - Rejeição: IE do destinatário não cadastrada = 233 */
	public static final String LBR_LOTSENDINGSTATUS_233_RejeiçãoIEDoDestinatárioNãoCadastrada = "233";
	/** 234 - Rejeição: IE do destinatário não vinculada ao CNPJ = 234 */
	public static final String LBR_LOTSENDINGSTATUS_234_RejeiçãoIEDoDestinatárioNãoVinculadaAoCNPJ = "234";
	/** 235 - Rejeição: Inscrição SUFRAMA inválida = 235 */
	public static final String LBR_LOTSENDINGSTATUS_235_RejeiçãoInscriçãoSUFRAMAInválida = "235";
	/** 236 - Rejeição: Chave de Acesso com dígito verificador inválido = 236 */
	public static final String LBR_LOTSENDINGSTATUS_236_RejeiçãoChaveDeAcessoComDígitoVerificadorInválido = "236";
	/** 237 - Rejeição: CPF do destinatário inválido = 237 */
	public static final String LBR_LOTSENDINGSTATUS_237_RejeiçãoCPFDoDestinatárioInválido = "237";
	/** 238 - Rejeição: Cabeçalho - Versão do arquivo XML superior a Versão vigente = 238 */
	public static final String LBR_LOTSENDINGSTATUS_238_RejeiçãoCabeçalho_VersãoDoArquivoXMLSuperiorAVersãoVigente = "238";
	/** 239 - Rejeição: Cabeçalho - Versão do arquivo XML não suportada = 239 */
	public static final String LBR_LOTSENDINGSTATUS_239_RejeiçãoCabeçalho_VersãoDoArquivoXMLNãoSuportada = "239";
	/** 240 - Rejeição: Cancelamento/Inutilização - Irregularidade Fiscal do Emitente = 240 */
	public static final String LBR_LOTSENDINGSTATUS_240_RejeiçãoCancelamentoInutilização_IrregularidadeFiscalDoEmitente = "240";
	/** 241 - Rejeição: Um número da faixa já foi utilizado = 241 */
	public static final String LBR_LOTSENDINGSTATUS_241_RejeiçãoUmNúmeroDaFaixaJáFoiUtilizado = "241";
	/** 242 - Rejeição: Cabeçalho - Falha no Schema XML = 242 */
	public static final String LBR_LOTSENDINGSTATUS_242_RejeiçãoCabeçalho_FalhaNoSchemaXML = "242";
	/** 243 - Rejeição: XML Mal Formado = 243 */
	public static final String LBR_LOTSENDINGSTATUS_243_RejeiçãoXMLMalFormado = "243";
	/** 244 - Rejeição: CNPJ do Certificado Digital difere do CNPJ da Matriz e do CNPJ do Emit = 244 */
	public static final String LBR_LOTSENDINGSTATUS_244_RejeiçãoCNPJDoCertificadoDigitalDifereDoCNPJDaMatrizEDoCNPJDoEmit = "244";
	/** 245 - Rejeição: CNPJ Emitente não cadastrado = 245 */
	public static final String LBR_LOTSENDINGSTATUS_245_RejeiçãoCNPJEmitenteNãoCadastrado = "245";
	/** 246 - Rejeição: CNPJ Destinatário não cadastrado = 246 */
	public static final String LBR_LOTSENDINGSTATUS_246_RejeiçãoCNPJDestinatárioNãoCadastrado = "246";
	/** 247 - Rejeição: Sigla da UF do Emitente diverge da UF autorizadora = 247 */
	public static final String LBR_LOTSENDINGSTATUS_247_RejeiçãoSiglaDaUFDoEmitenteDivergeDaUFAutorizadora = "247";
	/** 248 - Rejeição: UF do Recibo diverge da UF autorizadora = 248 */
	public static final String LBR_LOTSENDINGSTATUS_248_RejeiçãoUFDoReciboDivergeDaUFAutorizadora = "248";
	/** 249 - Rejeição: UF da Chave de Acesso diverge da UF autorizadora = 249 */
	public static final String LBR_LOTSENDINGSTATUS_249_RejeiçãoUFDaChaveDeAcessoDivergeDaUFAutorizadora = "249";
	/** 250 - Rejeição: UF diverge da UF autorizadora = 250 */
	public static final String LBR_LOTSENDINGSTATUS_250_RejeiçãoUFDivergeDaUFAutorizadora = "250";
	/** 251 - Rejeição: UF/Município destinatário não pertence a SUFRAMA = 251 */
	public static final String LBR_LOTSENDINGSTATUS_251_RejeiçãoUFMunicípioDestinatárioNãoPertenceASUFRAMA = "251";
	/** 252 - Rejeição: Ambiente informado diverge do Ambiente de recebimento = 252 */
	public static final String LBR_LOTSENDINGSTATUS_252_RejeiçãoAmbienteInformadoDivergeDoAmbienteDeRecebimento = "252";
	/** 253 - Rejeição: Digito Verificador da chave de acesso composta inválida = 253 */
	public static final String LBR_LOTSENDINGSTATUS_253_RejeiçãoDigitoVerificadorDaChaveDeAcessoCompostaInválida = "253";
	/** 254 - Rejeição: NF-e complementar não possui NF referenciada = 254 */
	public static final String LBR_LOTSENDINGSTATUS_254_RejeiçãoNF_EComplementarNãoPossuiNFReferenciada = "254";
	/** 255 - Rejeição: NF-e complementar possui mais de uma NF referenciada = 255 */
	public static final String LBR_LOTSENDINGSTATUS_255_RejeiçãoNF_EComplementarPossuiMaisDeUmaNFReferenciada = "255";
	/** 256 - Rejeição: Uma NF-e da faixa já está inutilizada na Base de dados da SEFAZ = 256 */
	public static final String LBR_LOTSENDINGSTATUS_256_RejeiçãoUmaNF_EDaFaixaJáEstáInutilizadaNaBaseDeDadosDaSEFAZ = "256";
	/** 257 - Rejeição: Solicitante não habilitado para emissão da NF-e = 257 */
	public static final String LBR_LOTSENDINGSTATUS_257_RejeiçãoSolicitanteNãoHabilitadoParaEmissãoDaNF_E = "257";
	/** 258 - Rejeição: CNPJ da consulta inválido = 258 */
	public static final String LBR_LOTSENDINGSTATUS_258_RejeiçãoCNPJDaConsultaInválido = "258";
	/** 259 - Rejeição: CNPJ da consulta não cadastrado como contribuinte na UF = 259 */
	public static final String LBR_LOTSENDINGSTATUS_259_RejeiçãoCNPJDaConsultaNãoCadastradoComoContribuinteNaUF = "259";
	/** 260 - Rejeição: IE da consulta inválida = 260 */
	public static final String LBR_LOTSENDINGSTATUS_260_RejeiçãoIEDaConsultaInválida = "260";
	/** 261 - Rejeição: IE da consulta não cadastrada como contribuinte na UF = 261 */
	public static final String LBR_LOTSENDINGSTATUS_261_RejeiçãoIEDaConsultaNãoCadastradaComoContribuinteNaUF = "261";
	/** 262 - Rejeição: UF não fornece consulta por CPF = 262 */
	public static final String LBR_LOTSENDINGSTATUS_262_RejeiçãoUFNãoForneceConsultaPorCPF = "262";
	/** 263 - Rejeição: CPF da consulta inválido = 263 */
	public static final String LBR_LOTSENDINGSTATUS_263_RejeiçãoCPFDaConsultaInválido = "263";
	/** 264 - Rejeição: CPF da consulta não cadastrado como contribuinte na UF = 264 */
	public static final String LBR_LOTSENDINGSTATUS_264_RejeiçãoCPFDaConsultaNãoCadastradoComoContribuinteNaUF = "264";
	/** 265 - Rejeição: Sigla da UF da consulta difere da UF do Web Service = 265 */
	public static final String LBR_LOTSENDINGSTATUS_265_RejeiçãoSiglaDaUFDaConsultaDifereDaUFDoWebService = "265";
	/** 266 - Rejeição: Série utilizada fora da faixa permitida no SCAN (0-889) = 266 */
	public static final String LBR_LOTSENDINGSTATUS_266_RejeiçãoSérieUtilizadaForaDaFaixaPermitidaNoSCAN0_889 = "266";
	/** 267 - Rejeição: Chave de Acesso referenciada inexistente = 267 */
	public static final String LBR_LOTSENDINGSTATUS_267_RejeiçãoChaveDeAcessoReferenciadaInexistente = "267";
	/** 268 - Rejeição: NF Complementar referencia uma outra NF-e Complementar = 268 */
	public static final String LBR_LOTSENDINGSTATUS_268_RejeiçãoNFComplementarReferenciaUmaOutraNF_EComplementar = "268";
	/** 269 - Rejeição: CNPJ Emitente da NF Complementar difere do CNPJ da NF Referenciada = 269 */
	public static final String LBR_LOTSENDINGSTATUS_269_RejeiçãoCNPJEmitenteDaNFComplementarDifereDoCNPJDaNFReferenciada = "269";
	/** 270 - Rejeição: Código Município do Fato Gerador: dígito inválido = 270 */
	public static final String LBR_LOTSENDINGSTATUS_270_RejeiçãoCódigoMunicípioDoFatoGeradorDígitoInválido = "270";
	/** 271 - Rejeição: Código Município do Fato Gerador: difere da UF do emitente = 271 */
	public static final String LBR_LOTSENDINGSTATUS_271_RejeiçãoCódigoMunicípioDoFatoGeradorDifereDaUFDoEmitente = "271";
	/** 272 - Rejeição: Código Município do Emitente: dígito inválido = 272 */
	public static final String LBR_LOTSENDINGSTATUS_272_RejeiçãoCódigoMunicípioDoEmitenteDígitoInválido = "272";
	/** 273 - Rejeição: Código Município do Emitente: difere da UF do emitente = 273 */
	public static final String LBR_LOTSENDINGSTATUS_273_RejeiçãoCódigoMunicípioDoEmitenteDifereDaUFDoEmitente = "273";
	/** 274 - Rejeição: Código Município do Destinatário: dígito inválido = 274 */
	public static final String LBR_LOTSENDINGSTATUS_274_RejeiçãoCódigoMunicípioDoDestinatárioDígitoInválido = "274";
	/** 275 - Rejeição: Código Município do Destinatário: difere da UF do Destinatário = 275 */
	public static final String LBR_LOTSENDINGSTATUS_275_RejeiçãoCódigoMunicípioDoDestinatárioDifereDaUFDoDestinatário = "275";
	/** 276 - Rejeição: Código Município do Local de Retirada: dígito inválido = 276 */
	public static final String LBR_LOTSENDINGSTATUS_276_RejeiçãoCódigoMunicípioDoLocalDeRetiradaDígitoInválido = "276";
	/** 277 - Rejeição: Código Município do Local de Retirada: difere da UF do Local de Retirada = 277 */
	public static final String LBR_LOTSENDINGSTATUS_277_RejeiçãoCódigoMunicípioDoLocalDeRetiradaDifereDaUFDoLocalDeRetirada = "277";
	/** 278 - Rejeição: Código Município do Local de Entrega: dígito inválido = 278 */
	public static final String LBR_LOTSENDINGSTATUS_278_RejeiçãoCódigoMunicípioDoLocalDeEntregaDígitoInválido = "278";
	/** 279 - Rejeição: Código Município do Local de Entrega: difere da UF do Local de Entrega = 279 */
	public static final String LBR_LOTSENDINGSTATUS_279_RejeiçãoCódigoMunicípioDoLocalDeEntregaDifereDaUFDoLocalDeEntrega = "279";
	/** 280 - Rejeição: Certificado Transmissor inválido = 280 */
	public static final String LBR_LOTSENDINGSTATUS_280_RejeiçãoCertificadoTransmissorInválido = "280";
	/** 281 - Rejeição: Certificado Transmissor Data Validade = 281 */
	public static final String LBR_LOTSENDINGSTATUS_281_RejeiçãoCertificadoTransmissorDataValidade = "281";
	/** 282 - Rejeição: Certificado Transmissor sem CNPJ = 282 */
	public static final String LBR_LOTSENDINGSTATUS_282_RejeiçãoCertificadoTransmissorSemCNPJ = "282";
	/** 283 - Rejeição: Certificado Transmissor - erro Cadeia de Certificação = 283 */
	public static final String LBR_LOTSENDINGSTATUS_283_RejeiçãoCertificadoTransmissor_ErroCadeiaDeCertificação = "283";
	/** 284 - Rejeição: Certificado Transmissor revogado = 284 */
	public static final String LBR_LOTSENDINGSTATUS_284_RejeiçãoCertificadoTransmissorRevogado = "284";
	/** 285 - Rejeição: Certificado Transmissor difere ICP-Brasil = 285 */
	public static final String LBR_LOTSENDINGSTATUS_285_RejeiçãoCertificadoTransmissorDifereICP_Brasil = "285";
	/** 286 - Rejeição: Certificado Transmissor erro no acesso a LCR = 286 */
	public static final String LBR_LOTSENDINGSTATUS_286_RejeiçãoCertificadoTransmissorErroNoAcessoALCR = "286";
	/** 287 - Rejeição: Código Município do FG - ISSQN: dígito inválido = 287 */
	public static final String LBR_LOTSENDINGSTATUS_287_RejeiçãoCódigoMunicípioDoFG_ISSQNDígitoInválido = "287";
	/** 288 - Rejeição: Código Município do FG - Transporte: dígito inválido = 288 */
	public static final String LBR_LOTSENDINGSTATUS_288_RejeiçãoCódigoMunicípioDoFG_TransporteDígitoInválido = "288";
	/** 289 - Rejeição: Código da UF informada diverge da UF solicitada = 289 */
	public static final String LBR_LOTSENDINGSTATUS_289_RejeiçãoCódigoDaUFInformadaDivergeDaUFSolicitada = "289";
	/** 290 - Rejeição: Certificado Assinatura inválido = 290 */
	public static final String LBR_LOTSENDINGSTATUS_290_RejeiçãoCertificadoAssinaturaInválido = "290";
	/** 291 - Rejeição: Certificado Assinatura Data Validade = 291 */
	public static final String LBR_LOTSENDINGSTATUS_291_RejeiçãoCertificadoAssinaturaDataValidade = "291";
	/** 292 - Rejeição: Certificado Assinatura sem CNPJ = 292 */
	public static final String LBR_LOTSENDINGSTATUS_292_RejeiçãoCertificadoAssinaturaSemCNPJ = "292";
	/** 293 - Rejeição: Certificado Assinatura - erro Cadeia de Certificação = 293 */
	public static final String LBR_LOTSENDINGSTATUS_293_RejeiçãoCertificadoAssinatura_ErroCadeiaDeCertificação = "293";
	/** 294 - Rejeição: Certificado Assinatura revogado = 294 */
	public static final String LBR_LOTSENDINGSTATUS_294_RejeiçãoCertificadoAssinaturaRevogado = "294";
	/** 295 - Rejeição: Certificado Assinatura difere ICP-Brasil = 295 */
	public static final String LBR_LOTSENDINGSTATUS_295_RejeiçãoCertificadoAssinaturaDifereICP_Brasil = "295";
	/** 296 - Rejeição: Certificado Assinatura erro no acesso a LCR = 296 */
	public static final String LBR_LOTSENDINGSTATUS_296_RejeiçãoCertificadoAssinaturaErroNoAcessoALCR = "296";
	/** 297 - Rejeição: Assinatura difere do calculado = 297 */
	public static final String LBR_LOTSENDINGSTATUS_297_RejeiçãoAssinaturaDifereDoCalculado = "297";
	/** 298 - Rejeição: Assinatura difere do padrão do Projeto = 298 */
	public static final String LBR_LOTSENDINGSTATUS_298_RejeiçãoAssinaturaDifereDoPadrãoDoProjeto = "298";
	/** 299 - Rejeição: XML da área de cabeçalho com codificação diferente de UTF-8 = 299 */
	public static final String LBR_LOTSENDINGSTATUS_299_RejeiçãoXMLDaÁreaDeCabeçalhoComCodificaçãoDiferenteDeUTF_8 = "299";
	/** 301 - Uso Denegado: Irregularidade fiscal do emitente = 301 */
	public static final String LBR_LOTSENDINGSTATUS_301_UsoDenegadoIrregularidadeFiscalDoEmitente = "301";
	/** 302 - Uso Denegado: Irregularidade fiscal do destinatário = 302 */
	public static final String LBR_LOTSENDINGSTATUS_302_UsoDenegadoIrregularidadeFiscalDoDestinatário = "302";
	/** 303 - Uso Denegado: Destinatário não habilitado a operar na UF = 303 */
	public static final String LBR_LOTSENDINGSTATUS_303_UsoDenegadoDestinatárioNãoHabilitadoAOperarNaUF = "303";
	/** 304 - Rejeição: Pedido de Cancelamento para NF-e com evento da Suframa = 304 */
	public static final String LBR_LOTSENDINGSTATUS_304_RejeiçãoPedidoDeCancelamentoParaNF_EComEventoDaSuframa = "304";
	/** 321 - Rejeição: NF-e de devolução não possui conhecimento fiscal referenciado = 321 */
	public static final String LBR_LOTSENDINGSTATUS_321_RejeiçãoNF_EDeDevoluçãoNãoPossuiConhecimentoFiscalReferenciado = "321";
	/** 322 - Rejeição: NF-e de devolução com mais de um documento fiscal referenciado = 322 */
	public static final String LBR_LOTSENDINGSTATUS_322_RejeiçãoNF_EDeDevoluçãoComMaisDeUmDocumentoFiscalReferenciado = "322";
	/** 323 - Rejeição: CNPJ autorizado para download inválido = 323 */
	public static final String LBR_LOTSENDINGSTATUS_323_RejeiçãoCNPJAutorizadoParaDownloadInválido = "323";
	/** 324 - Rejeição: CNPJ do destinatário ja autorizado para download = 324 */
	public static final String LBR_LOTSENDINGSTATUS_324_RejeiçãoCNPJDoDestinatárioJaAutorizadoParaDownload = "324";
	/** 325 - Rejeição: CPF autorizado para download inválido = 325 */
	public static final String LBR_LOTSENDINGSTATUS_325_RejeiçãoCPFAutorizadoParaDownloadInválido = "325";
	/** 326 - Rejeição: CPF do destinatário autorizado para download = 326 */
	public static final String LBR_LOTSENDINGSTATUS_326_RejeiçãoCPFDoDestinatárioAutorizadoParaDownload = "326";
	/** 327 - Rejeição: CFOP inválido para NF-e com finalidade de devolução = 327 */
	public static final String LBR_LOTSENDINGSTATUS_327_RejeiçãoCFOPInválidoParaNF_EComFinalidadeDeDevolução = "327";
	/** 328 - Rejeição: CFOP inválido para NF-e que não tem finalidade de devolução = 328 */
	public static final String LBR_LOTSENDINGSTATUS_328_RejeiçãoCFOPInválidoParaNF_EQueNãoTemFinalidadeDeDevolução = "328";
	/** 329 - Rejeição: Número da DI/DSI inválido = 329 */
	public static final String LBR_LOTSENDINGSTATUS_329_RejeiçãoNúmeroDaDIDSIInválido = "329";
	/** 330 - Rejeição: Informar o valor da AFRMM na importação por via marítima = 330 */
	public static final String LBR_LOTSENDINGSTATUS_330_RejeiçãoInformarOValorDaAFRMMNaImportaçãoPorViaMarítima = "330";
	/** 331 - Rejeição: Informar o CNPJ do adquirente ou do encomendante nesta forma de importação = 331 */
	public static final String LBR_LOTSENDINGSTATUS_331_RejeiçãoInformarOCNPJDoAdquirenteOuDoEncomendanteNestaFormaDeImportação = "331";
	/** 332 - Rejeição: CNPJ do adquirente ou do encomendante da importação inválido = 332 */
	public static final String LBR_LOTSENDINGSTATUS_332_RejeiçãoCNPJDoAdquirenteOuDoEncomendanteDaImportaçãoInválido = "332";
	/** 333 - Rejeição: Informar a UF do adquirente ou do encomendante nesta forma de importação = 333 */
	public static final String LBR_LOTSENDINGSTATUS_333_RejeiçãoInformarAUFDoAdquirenteOuDoEncomendanteNestaFormaDeImportação = "333";
	/** 334 - Rejeição: Número do processo de drawback não informado na importação = 334 */
	public static final String LBR_LOTSENDINGSTATUS_334_RejeiçãoNúmeroDoProcessoDeDrawbackNãoInformadoNaImportação = "334";
	/** 335 - Rejeição: Número do processo de drawback na importação inválido = 335 */
	public static final String LBR_LOTSENDINGSTATUS_335_RejeiçãoNúmeroDoProcessoDeDrawbackNaImportaçãoInválido = "335";
	/** 336 - Rejeição: Informado o grupo de exportação no item para CFOP que não é de exportação = 336 */
	public static final String LBR_LOTSENDINGSTATUS_336_RejeiçãoInformadoOGrupoDeExportaçãoNoItemParaCFOPQueNãoÉDeExportação = "336";
	/** 337 - Rejeição: Não informado o grupo de exportação no item = 337 */
	public static final String LBR_LOTSENDINGSTATUS_337_RejeiçãoNãoInformadoOGrupoDeExportaçãoNoItem = "337";
	/** 338 - Rejeição: Número de processo de drawback não informado na exportação = 338 */
	public static final String LBR_LOTSENDINGSTATUS_338_RejeiçãoNúmeroDeProcessoDeDrawbackNãoInformadoNaExportação = "338";
	/** 339 - Rejeição: Número de processo de drawback na exportação inválido = 339 */
	public static final String LBR_LOTSENDINGSTATUS_339_RejeiçãoNúmeroDeProcessoDeDrawbackNaExportaçãoInválido = "339";
	/** 340 - Rejeição: Não informado o grupo de exportação indireta no item = 340 */
	public static final String LBR_LOTSENDINGSTATUS_340_RejeiçãoNãoInformadoOGrupoDeExportaçãoIndiretaNoItem = "340";
	/** 341 - Rejeição: Número do registro de exportação inválido = 341 */
	public static final String LBR_LOTSENDINGSTATUS_341_RejeiçãoNúmeroDoRegistroDeExportaçãoInválido = "341";
	/** 342 - Rejeição: Chave de acesso informada na exportação indireta com DV inválido = 342 */
	public static final String LBR_LOTSENDINGSTATUS_342_RejeiçãoChaveDeAcessoInformadaNaExportaçãoIndiretaComDVInválido = "342";
	/** 343 - Rejeição: Modelo da NF-e informada na exportação indireta diferente de 55 = 343 */
	public static final String LBR_LOTSENDINGSTATUS_343_RejeiçãoModeloDaNF_EInformadaNaExportaçãoIndiretaDiferenteDe55 = "343";
	/** 344 - Rejeição: Duplicidade de NF-e informada na exportação indireta (chave acesso informada mais de uma vez) = 344 */
	public static final String LBR_LOTSENDINGSTATUS_344_RejeiçãoDuplicidadeDeNF_EInformadaNaExportaçãoIndiretaChaveAcessoInformadaMaisDeUmaVez = "344";
	/** 345 - Rejeição: Chave de acesso informada na exportação indireta não consta como NF-e referenciada = 345 */
	public static final String LBR_LOTSENDINGSTATUS_345_RejeiçãoChaveDeAcessoInformadaNaExportaçãoIndiretaNãoConstaComoNF_EReferenciada = "345";
	/** 346 - Rejeição: Somatório quantidades informadas na exportação indireta não corresponde total do item = 346 */
	public static final String LBR_LOTSENDINGSTATUS_346_RejeiçãoSomatórioQuantidadesInformadasNaExportaçãoIndiretaNãoCorrespondeTotalDoItem = "346";
	/** 347 - Rejeição: Descrição do combustível diverge da descrição adotada pela ANP = 347 */
	public static final String LBR_LOTSENDINGSTATUS_347_RejeiçãoDescriçãoDoCombustívelDivergeDaDescriçãoAdotadaPelaANP = "347";
	/** 348 - Rejeição: NFC-e com grupo RECOPI = 348 */
	public static final String LBR_LOTSENDINGSTATUS_348_RejeiçãoNFC_EComGrupoRECOPI = "348";
	/** 349 - Rejeição: Número RECOPI não informado = 349 */
	public static final String LBR_LOTSENDINGSTATUS_349_RejeiçãoNúmeroRECOPINãoInformado = "349";
	/** 350 - Rejeição: Número RECOPI inválido = 350 */
	public static final String LBR_LOTSENDINGSTATUS_350_RejeiçãoNúmeroRECOPIInválido = "350";
	/** 351 - Rejeição: Valor do ICMS da operação no ICMS-ST=51 difere do produto BC e alíquota = 351 */
	public static final String LBR_LOTSENDINGSTATUS_351_RejeiçãoValorDoICMSDaOperaçãoNoICMS_STEq51DifereDoProdutoBCEAlíquota = "351";
	/** 352 - Rejeição: Valor do ICMS diferido no CST=51 difere do produto Valor ICMS operação e ICMS diferido = 352 */
	public static final String LBR_LOTSENDINGSTATUS_352_RejeiçãoValorDoICMSDiferidoNoCSTEq51DifereDoProdutoValorICMSOperaçãoEICMSDiferido = "352";
	/** 353 - Rejeição: Valor do ICMS no CST=51 não corresponde a diferença do ICMS operação e ICMS diferido = 353 */
	public static final String LBR_LOTSENDINGSTATUS_353_RejeiçãoValorDoICMSNoCSTEq51NãoCorrespondeADiferençaDoICMSOperaçãoEICMSDiferido = "353";
	/** 354 - Rejeição: Informado grupo de devoluçãode tributos para NF-e e que não tem finalidade de devolução = 354 */
	public static final String LBR_LOTSENDINGSTATUS_354_RejeiçãoInformadoGrupoDeDevoluçãodeTributosParaNF_EEQueNãoTemFinalidadeDeDevolução = "354";
	/** 355 - Rejeição: Informar o local de saída do país no caso de exportação = 355 */
	public static final String LBR_LOTSENDINGSTATUS_355_RejeiçãoInformarOLocalDeSaídaDoPaísNoCasoDeExportação = "355";
	/** 356 - Rejeição: Informar o clocal de saída do pís somente no caso de exportação = 356 */
	public static final String LBR_LOTSENDINGSTATUS_356_RejeiçãoInformarOClocalDeSaídaDoPísSomenteNoCasoDeExportação = "356";
	/** 357 - Rejeição: Chave de acesso do grupo de exportação indireta inexistente = 357 */
	public static final String LBR_LOTSENDINGSTATUS_357_RejeiçãoChaveDeAcessoDoGrupoDeExportaçãoIndiretaInexistente = "357";
	/** 358 - Rejeição: Chave de acesso no grupo de exportação indireta cancelada ou denegada = 358 */
	public static final String LBR_LOTSENDINGSTATUS_358_RejeiçãoChaveDeAcessoNoGrupoDeExportaçãoIndiretaCanceladaOuDenegada = "358";
	/** 359 - Rejeição: NF-e de venda a Órgão público sem informar a Nota de Empenho = 359 */
	public static final String LBR_LOTSENDINGSTATUS_359_RejeiçãoNF_EDeVendaAÓrgãoPúblicoSemInformarANotaDeEmpenho = "359";
	/** 360 - Rejeição: NF-e com Nota de Empenho inválida para UF = 360 */
	public static final String LBR_LOTSENDINGSTATUS_360_RejeiçãoNF_EComNotaDeEmpenhoInválidaParaUF = "360";
	/** 361 - Rejeição: NF-e com Nota de Empenho inexistente na UF = 361 */
	public static final String LBR_LOTSENDINGSTATUS_361_RejeiçãoNF_EComNotaDeEmpenhoInexistenteNaUF = "361";
	/** 362 - Rejeição: Venda de combustível sem informação do Transportador = 362 */
	public static final String LBR_LOTSENDINGSTATUS_362_RejeiçãoVendaDeCombustívelSemInformaçãoDoTransportador = "362";
	/** 363 - Rejeição: Total do ISS difere do somatório dos itens = 363 */
	public static final String LBR_LOTSENDINGSTATUS_363_RejeiçãoTotalDoISSDifereDoSomatórioDosItens = "363";
	/** 364 - Rejeição: Total do valor da dedução do ISS difere do somatório dos itens = 364 */
	public static final String LBR_LOTSENDINGSTATUS_364_RejeiçãoTotalDoValorDaDeduçãoDoISSDifereDoSomatórioDosItens = "364";
	/** 365 - Rejeição: Total de outras retenções difere do somatório dos itens = 365 */
	public static final String LBR_LOTSENDINGSTATUS_365_RejeiçãoTotalDeOutrasRetençõesDifereDoSomatórioDosItens = "365";
	/** 366 - Rejeição: Total do desconto incondicionado do ISS difere do somatório dos itens = 366 */
	public static final String LBR_LOTSENDINGSTATUS_366_RejeiçãoTotalDoDescontoIncondicionadoDoISSDifereDoSomatórioDosItens = "366";
	/** 367 - Rejeição: Total do desconto condicionado do ISS difere do somatório dos itens = 367 */
	public static final String LBR_LOTSENDINGSTATUS_367_RejeiçãoTotalDoDescontoCondicionadoDoISSDifereDoSomatórioDosItens = "367";
	/** 368 - Rejeição: Total do ISS retido difere do somatório dos itens = 368 */
	public static final String LBR_LOTSENDINGSTATUS_368_RejeiçãoTotalDoISSRetidoDifereDoSomatórioDosItens = "368";
	/** 369 - Rejeição: Não informado o grupo avulsa na emissão pelo Fisco = 369 */
	public static final String LBR_LOTSENDINGSTATUS_369_RejeiçãoNãoInformadoOGrupoAvulsaNaEmissãoPeloFisco = "369";
	/** 370 - Rejeição: Nota Fiscal Avusa com tipo de emissão inválido = 370 */
	public static final String LBR_LOTSENDINGSTATUS_370_RejeiçãoNotaFiscalAvusaComTipoDeEmissãoInválido = "370";
	/** 401 - Rejeição: CPF do remetente inválido = 401 */
	public static final String LBR_LOTSENDINGSTATUS_401_RejeiçãoCPFDoRemetenteInválido = "401";
	/** 402 - Rejeição: XML da área de dados com codificação diferente de UTF-8 = 402 */
	public static final String LBR_LOTSENDINGSTATUS_402_RejeiçãoXMLDaÁreaDeDadosComCodificaçãoDiferenteDeUTF_8 = "402";
	/** 403 - Rejeição: O grupo de informações da NF-e avulsa é de uso exclusivo do Fisco = 403 */
	public static final String LBR_LOTSENDINGSTATUS_403_RejeiçãoOGrupoDeInformaçõesDaNF_EAvulsaÉDeUsoExclusivoDoFisco = "403";
	/** 404 - Rejeição: Uso de prefixo de namespace não permitido = 404 */
	public static final String LBR_LOTSENDINGSTATUS_404_RejeiçãoUsoDePrefixoDeNamespaceNãoPermitido = "404";
	/** 405 - Rejeição: Código do país do emitente: dígito inválido = 405 */
	public static final String LBR_LOTSENDINGSTATUS_405_RejeiçãoCódigoDoPaísDoEmitenteDígitoInválido = "405";
	/** 406 - Rejeição: Código do país do destinatário: dígito inválido = 406 */
	public static final String LBR_LOTSENDINGSTATUS_406_RejeiçãoCódigoDoPaísDoDestinatárioDígitoInválido = "406";
	/** 407 - Rejeição: O CPF só pode ser informado no campo emitente para a NF-e avulsa = 407 */
	public static final String LBR_LOTSENDINGSTATUS_407_RejeiçãoOCPFSóPodeSerInformadoNoCampoEmitenteParaANF_EAvulsa = "407";
	/** 409 - Rejeição: Campo cUF inexistente no elemento nfeCabecMsg do SOAP Header = 409 */
	public static final String LBR_LOTSENDINGSTATUS_409_RejeiçãoCampoCUFInexistenteNoElementoNfeCabecMsgDoSOAPHeader = "409";
	/** 410 - Rejeição: UF informada no campo cUF não é atendida pelo Web Service = 410 */
	public static final String LBR_LOTSENDINGSTATUS_410_RejeiçãoUFInformadaNoCampoCUFNãoÉAtendidaPeloWebService = "410";
	/** 411 - Rejeição: Campo versaoDados inexistente no elemento nfeCabecMsg do SOAP Header = 411 */
	public static final String LBR_LOTSENDINGSTATUS_411_RejeiçãoCampoVersaoDadosInexistenteNoElementoNfeCabecMsgDoSOAPHeader = "411";
	/** 417 - Rejeição: Total do ICMS superior ao valor limite estabelecido = 417 */
	public static final String LBR_LOTSENDINGSTATUS_417_RejeiçãoTotalDoICMSSuperiorAoValorLimiteEstabelecido = "417";
	/** 418 - Rejeição: Total do ICMS-ST superior ao limite estabelecido = 418 */
	public static final String LBR_LOTSENDINGSTATUS_418_RejeiçãoTotalDoICMS_STSuperiorAoLimiteEstabelecido = "418";
	/** 420 - Rejeição: Cancelamento para NF-e já cancelada = 420 */
	public static final String LBR_LOTSENDINGSTATUS_420_RejeiçãoCancelamentoParaNF_EJáCancelada = "420";
	/** 450 - Rejeição: Modelo da NF-e diferente de 55 = 450 */
	public static final String LBR_LOTSENDINGSTATUS_450_RejeiçãoModeloDaNF_EDiferenteDe55 = "450";
	/** 451 - Rejeição: Processo de emissão informado inválido = 451 */
	public static final String LBR_LOTSENDINGSTATUS_451_RejeiçãoProcessoDeEmissãoInformadoInválido = "451";
	/** 452 - Rejeição: Tipo Autorizador do Recibo diverge do Órgão Autorizador = 452 */
	public static final String LBR_LOTSENDINGSTATUS_452_RejeiçãoTipoAutorizadorDoReciboDivergeDoÓrgãoAutorizador = "452";
	/** 453 - Rejeição: Ano de inutilização não pode ser superior ao Ano atual = 453 */
	public static final String LBR_LOTSENDINGSTATUS_453_RejeiçãoAnoDeInutilizaçãoNãoPodeSerSuperiorAoAnoAtual = "453";
	/** 454 - Rejeição: Ano de inutilização não pode ser inferior a 2006 = 454 */
	public static final String LBR_LOTSENDINGSTATUS_454_RejeiçãoAnoDeInutilizaçãoNãoPodeSerInferiorA2006 = "454";
	/** 461 - Rejeição: Informado percentual de gás natural na mistura para produto diferente de GLP = 461 */
	public static final String LBR_LOTSENDINGSTATUS_461_RejeiçãoInformadoPercentualDeGásNaturalNaMisturaParaProdutoDiferenteDeGLP = "461";
	/** 465 - Rejeição: Número de controle da FCI inexistente = 465 */
	public static final String LBR_LOTSENDINGSTATUS_465_RejeiçãoNúmeroDeControleDaFCIInexistente = "465";
	/** 478 - Rejeição: Local da entrega não informado para faturamto direto de veículos novos = 478 */
	public static final String LBR_LOTSENDINGSTATUS_478_RejeiçãoLocalDaEntregaNãoInformadoParaFaturamtoDiretoDeVeículosNovos = "478";
	/** 479 - Rejeição: Emissor em situação irregular peranto o fisco = 479 */
	public static final String LBR_LOTSENDINGSTATUS_479_RejeiçãoEmissorEmSituaçãoIrregularPerantoOFisco = "479";
	/** 480 - Rejeição: CNPJ da Chave de acesso da NF-e informada diverge do CNPJ do emitente = 480 */
	public static final String LBR_LOTSENDINGSTATUS_480_RejeiçãoCNPJDaChaveDeAcessoDaNF_EInformadaDivergeDoCNPJDoEmitente = "480";
	/** 481 - Rejeição: UF da Chave de acesso diverge do código da UF informada = 481 */
	public static final String LBR_LOTSENDINGSTATUS_481_RejeiçãoUFDaChaveDeAcessoDivergeDoCódigoDaUFInformada = "481";
	/** 482 - Rejeição: AA da Chave de acesso inválida = 482 */
	public static final String LBR_LOTSENDINGSTATUS_482_RejeiçãoAADaChaveDeAcessoInválida = "482";
	/** 483 - Rejeição: MM da Chave de acesso inválido = 483 */
	public static final String LBR_LOTSENDINGSTATUS_483_RejeiçãoMMDaChaveDeAcessoInválido = "483";
	/** 484 - Rejeição: DPEC com tipo de emissão diferente de '4'(posição 35 da Chave de Acesso) = 484 */
	public static final String LBR_LOTSENDINGSTATUS_484_RejeiçãoDPECComTipoDeEmissãoDiferenteDe4Posição35DaChaveDeAcesso = "484";
	/** 485 - Rejeição: Número DPEC já existe no cadastro de DPEC = 485 */
	public static final String LBR_LOTSENDINGSTATUS_485_RejeiçãoNúmeroDPECJáExisteNoCadastroDeDPEC = "485";
	/** 486 - Rejeição: DPEC não localizada para o número de registro de DPEC informado = 486 */
	public static final String LBR_LOTSENDINGSTATUS_486_RejeiçãoDPECNãoLocalizadaParaONúmeroDeRegistroDeDPECInformado = "486";
	/** 487 - Rejeição: Nenhuma DPEC localizada para a chave de acesso informada = 487 */
	public static final String LBR_LOTSENDINGSTATUS_487_RejeiçãoNenhumaDPECLocalizadaParaAChaveDeAcessoInformada = "487";
	/** 488 - Rejeição: Requisitante de Consulta não tem o mesmo CNPJ base do emissor da DPEC = 488 */
	public static final String LBR_LOTSENDINGSTATUS_488_RejeiçãoRequisitanteDeConsultaNãoTemOMesmoCNPJBaseDoEmissorDaDPEC = "488";
	/** 489 - Rejeição: CNPJ informado inválido (DV ou zeros) = 489 */
	public static final String LBR_LOTSENDINGSTATUS_489_RejeiçãoCNPJInformadoInválidoDVOuZeros = "489";
	/** 490 - Rejeição: CPF informado inválido (DV ou zeros) = 490 */
	public static final String LBR_LOTSENDINGSTATUS_490_RejeiçãoCPFInformadoInválidoDVOuZeros = "490";
	/** 491 - Rejeição: O tpEvento informado inválido = 491 */
	public static final String LBR_LOTSENDINGSTATUS_491_RejeiçãoOTpEventoInformadoInválido = "491";
	/** 492 - Rejeição: O verEvento informado inválido = 492 */
	public static final String LBR_LOTSENDINGSTATUS_492_RejeiçãoOVerEventoInformadoInválido = "492";
	/** 493 - Rejeição: Evento não atende o Schema XML específico = 493 */
	public static final String LBR_LOTSENDINGSTATUS_493_RejeiçãoEventoNãoAtendeOSchemaXMLEspecífico = "493";
	/** 494 - Rejeição: Chave de Acesso inexistente = 494 */
	public static final String LBR_LOTSENDINGSTATUS_494_RejeiçãoChaveDeAcessoInexistente = "494";
	/** 501 - Rejeição: Verificar NFe autorizada há mais de 30 dias (720) horas = 501 */
	public static final String LBR_LOTSENDINGSTATUS_501_RejeiçãoVerificarNFeAutorizadaHáMaisDe30Dias720Horas = "501";
	/** 502 - Rejeição: Erro Chave Acesso - Campo Id ñ corresponde à conct. dos campos corresp = 502 */
	public static final String LBR_LOTSENDINGSTATUS_502_RejeiçãoErroChaveAcesso_CampoIdÑCorrespondeÀConctDosCamposCorresp = "502";
	/** 503 - Rejeição: Série utilizada fora da faixa permitida no SCAN (900-999) = 503 */
	public static final String LBR_LOTSENDINGSTATUS_503_RejeiçãoSérieUtilizadaForaDaFaixaPermitidaNoSCAN900_999 = "503";
	/** 504 - Rejeição: Data de Entrada/Saída posterior ao permitido = 504 */
	public static final String LBR_LOTSENDINGSTATUS_504_RejeiçãoDataDeEntradaSaídaPosteriorAoPermitido = "504";
	/** 505 - Rejeição: Data de Entrada/Saída anterior ao permitido = 505 */
	public static final String LBR_LOTSENDINGSTATUS_505_RejeiçãoDataDeEntradaSaídaAnteriorAoPermitido = "505";
	/** 506 - Rejeição: Data de Saída menor que a Data de Emissão = 506 */
	public static final String LBR_LOTSENDINGSTATUS_506_RejeiçãoDataDeSaídaMenorQueADataDeEmissão = "506";
	/** 507 - Rejeição: CNPJ destinatário/remetente ñ deve ser inform. em operação c/ exterior = 507 */
	public static final String LBR_LOTSENDINGSTATUS_507_RejeiçãoCNPJDestinatárioRemetenteÑDeveSerInformEmOperaçãoCExterior = "507";
	/** 508 - Rejeição: CNPJ com conteúdo nulo só é válido em operação com exterior = 508 */
	public static final String LBR_LOTSENDINGSTATUS_508_RejeiçãoCNPJComConteúdoNuloSóÉVálidoEmOperaçãoComExterior = "508";
	/** 509 - Rejeição: Inform. cód.município diferente de '9999999' para operação c/ exterior = 509 */
	public static final String LBR_LOTSENDINGSTATUS_509_RejeiçãoInformCódMunicípioDiferenteDe9999999ParaOperaçãoCExterior = "509";
	/** 510 - Rejeição: Oper.c/ Exterior e Cód.País destinatário é 1058(Brasil) ou ñ informado = 510 */
	public static final String LBR_LOTSENDINGSTATUS_510_RejeiçãoOperCExteriorECódPaísDestinatárioÉ1058BrasilOuÑInformado = "510";
	/** 511 - Rejeição: Não é Oper.c/ Exterior e Cód.País destinatário difere de 1058 (Brasil) = 511 */
	public static final String LBR_LOTSENDINGSTATUS_511_RejeiçãoNãoÉOperCExteriorECódPaísDestinatárioDifereDe1058Brasil = "511";
	/** 512 - Rejeição: CNPJ do Local de retirada inválido = 512 */
	public static final String LBR_LOTSENDINGSTATUS_512_RejeiçãoCNPJDoLocalDeRetiradaInválido = "512";
	/** 513 - Rejeição: Código Município Local Retirada deve ser 9999999 para UF retirada = EX = 513 */
	public static final String LBR_LOTSENDINGSTATUS_513_RejeiçãoCódigoMunicípioLocalRetiradaDeveSer9999999ParaUFRetiradaEqEX = "513";
	/** 514 - Rejeição: CNPJ do Local de Entrega inválido = 514 */
	public static final String LBR_LOTSENDINGSTATUS_514_RejeiçãoCNPJDoLocalDeEntregaInválido = "514";
	/** 515 - Rejeição: Código Munic. do Local de Entrega deve ser 9999999 p/ UF entrega=EX = 515 */
	public static final String LBR_LOTSENDINGSTATUS_515_RejeiçãoCódigoMunicDoLocalDeEntregaDeveSer9999999PUFEntregaEqEX = "515";
	/** 516 - Rejeição: Falha no schema XML - inexiste a tag raiz esperada para a mensagem = 516 */
	public static final String LBR_LOTSENDINGSTATUS_516_RejeiçãoFalhaNoSchemaXML_InexisteATagRaizEsperadaParaAMensagem = "516";
	/** 517 - Rejeição: Falha no schema XML - inexiste atributo versao na tag raiz da mensagem = 517 */
	public static final String LBR_LOTSENDINGSTATUS_517_RejeiçãoFalhaNoSchemaXML_InexisteAtributoVersaoNaTagRaizDaMensagem = "517";
	/** 518 - Rejeição: CFOP de entrada para NF-e de saída = 518 */
	public static final String LBR_LOTSENDINGSTATUS_518_RejeiçãoCFOPDeEntradaParaNF_EDeSaída = "518";
	/** 519 - Rejeição: CFOP de saída para NF-e de entrada = 519 */
	public static final String LBR_LOTSENDINGSTATUS_519_RejeiçãoCFOPDeSaídaParaNF_EDeEntrada = "519";
	/** 520 - Rejeição: CFOP de Operação com Exterior e UF destinatário difere de EX = 520 */
	public static final String LBR_LOTSENDINGSTATUS_520_RejeiçãoCFOPDeOperaçãoComExteriorEUFDestinatárioDifereDeEX = "520";
	/** 521 - Rejeição: CFOP não é de Operação com Exterior e UF destinatário é EX = 521 */
	public static final String LBR_LOTSENDINGSTATUS_521_RejeiçãoCFOPNãoÉDeOperaçãoComExteriorEUFDestinatárioÉEX = "521";
	/** 522 - Rejeição: CFOP de operação estadual e UF emitente <> da UF remetente contribuinte ICMS = 522 */
	public static final String LBR_LOTSENDINGSTATUS_522_RejeiçãoCFOPDeOperaçãoEstadualEUFEmitenteDaUFRemetenteContribuinteICMS = "522";
	/** 523 - Rejeição: CFOP não é de Operação Estadual e UF emitente igual a UF destinatário = 523 */
	public static final String LBR_LOTSENDINGSTATUS_523_RejeiçãoCFOPNãoÉDeOperaçãoEstadualEUFEmitenteIgualAUFDestinatário = "523";
	/** 524 - Rejeição: CFOP de Operação com Exterior e não informado NCM = 524 */
	public static final String LBR_LOTSENDINGSTATUS_524_RejeiçãoCFOPDeOperaçãoComExteriorENãoInformadoNCM = "524";
	/** 525 - Rejeição: CFOP de Importação e não informado dados da DI = 525 */
	public static final String LBR_LOTSENDINGSTATUS_525_RejeiçãoCFOPDeImportaçãoENãoInformadoDadosDaDI = "525";
	/** 526 - Rejeição: CFOP de Exportação e não informado Local de Embarque = 526 */
	public static final String LBR_LOTSENDINGSTATUS_526_RejeiçãoCFOPDeExportaçãoENãoInformadoLocalDeEmbarque = "526";
	/** 527 - Rejeição: Operação de Exportação com informação de ICMS incompatível = 527 */
	public static final String LBR_LOTSENDINGSTATUS_527_RejeiçãoOperaçãoDeExportaçãoComInformaçãoDeICMSIncompatível = "527";
	/** 528 - Rejeição: Valor do ICMS difere do produto BC e Alíquota = 528 */
	public static final String LBR_LOTSENDINGSTATUS_528_RejeiçãoValorDoICMSDifereDoProdutoBCEAlíquota = "528";
	/** 529 - Rejeição: NCM de informação obrigatória para produto tributado pelo IPI = 529 */
	public static final String LBR_LOTSENDINGSTATUS_529_RejeiçãoNCMDeInformaçãoObrigatóriaParaProdutoTributadoPeloIPI = "529";
	/** 530 - Rejeição: Operação com tributação de ISSQN sem informar a Inscrição Municipal = 530 */
	public static final String LBR_LOTSENDINGSTATUS_530_RejeiçãoOperaçãoComTributaçãoDeISSQNSemInformarAInscriçãoMunicipal = "530";
	/** 531 - Rejeição: Total da BC ICMS difere do somatório dos itens = 531 */
	public static final String LBR_LOTSENDINGSTATUS_531_RejeiçãoTotalDaBCICMSDifereDoSomatórioDosItens = "531";
	/** 532 - Rejeição: Total do ICMS difere do somatório dos itens = 532 */
	public static final String LBR_LOTSENDINGSTATUS_532_RejeiçãoTotalDoICMSDifereDoSomatórioDosItens = "532";
	/** 533 - Rejeição: Total da BC ICMS-ST difere do somatório dos itens = 533 */
	public static final String LBR_LOTSENDINGSTATUS_533_RejeiçãoTotalDaBCICMS_STDifereDoSomatórioDosItens = "533";
	/** 534 - Rejeição: Total do ICMS-ST difere do somatório dos itens = 534 */
	public static final String LBR_LOTSENDINGSTATUS_534_RejeiçãoTotalDoICMS_STDifereDoSomatórioDosItens = "534";
	/** 535 - Rejeição: Total do Frete difere do somatório dos itens = 535 */
	public static final String LBR_LOTSENDINGSTATUS_535_RejeiçãoTotalDoFreteDifereDoSomatórioDosItens = "535";
	/** 536 - Rejeição: Total do Seguro difere do somatório dos itens = 536 */
	public static final String LBR_LOTSENDINGSTATUS_536_RejeiçãoTotalDoSeguroDifereDoSomatórioDosItens = "536";
	/** 537 - Rejeição: Total do Desconto difere do somatório dos itens = 537 */
	public static final String LBR_LOTSENDINGSTATUS_537_RejeiçãoTotalDoDescontoDifereDoSomatórioDosItens = "537";
	/** 538 - Rejeição: Total do IPI difere do somatório dos itens = 538 */
	public static final String LBR_LOTSENDINGSTATUS_538_RejeiçãoTotalDoIPIDifereDoSomatórioDosItens = "538";
	/** 539 - Rejeição: Duplicidade de NF-e; com diferença na Chave de Acesso = 539 */
	public static final String LBR_LOTSENDINGSTATUS_539_RejeiçãoDuplicidadeDeNF_EComDiferençaNaChaveDeAcesso = "539";
	/** 540 - Rejeição: CPF do Local de Retirada inválido = 540 */
	public static final String LBR_LOTSENDINGSTATUS_540_RejeiçãoCPFDoLocalDeRetiradaInválido = "540";
	/** 541 - Rejeição: CPF do Local de Entrega inválido = 541 */
	public static final String LBR_LOTSENDINGSTATUS_541_RejeiçãoCPFDoLocalDeEntregaInválido = "541";
	/** 542 - Rejeição: CNPJ do Transportador inválido = 542 */
	public static final String LBR_LOTSENDINGSTATUS_542_RejeiçãoCNPJDoTransportadorInválido = "542";
	/** 543 - Rejeição: CPF do Transportador inválido = 543 */
	public static final String LBR_LOTSENDINGSTATUS_543_RejeiçãoCPFDoTransportadorInválido = "543";
	/** 544 - Rejeição: IE do Transportador inválida = 544 */
	public static final String LBR_LOTSENDINGSTATUS_544_RejeiçãoIEDoTransportadorInválida = "544";
	/** 545 - Rejeição: Falha schema XML - versão inform.na Dados do SOAPHeader difere da msg = 545 */
	public static final String LBR_LOTSENDINGSTATUS_545_RejeiçãoFalhaSchemaXML_VersãoInformNaDadosDoSOAPHeaderDifereDaMsg = "545";
	/** 546 - Rejeição: Erro na Chave de Acesso - Campo Id - falta a literal NFe = 546 */
	public static final String LBR_LOTSENDINGSTATUS_546_RejeiçãoErroNaChaveDeAcesso_CampoId_FaltaALiteralNFe = "546";
	/** 547 - Rejeição: Dígito Verificador da Chave de Acesso da NF-e Referenciada inválido = 547 */
	public static final String LBR_LOTSENDINGSTATUS_547_RejeiçãoDígitoVerificadorDaChaveDeAcessoDaNF_EReferenciadaInválido = "547";
	/** 548 - Rejeição: CNPJ da NF referenciada inválido. = 548 */
	public static final String LBR_LOTSENDINGSTATUS_548_RejeiçãoCNPJDaNFReferenciadaInválido = "548";
	/** 549 - Rejeição: CNPJ da NF referenciada de produtor inválido. = 549 */
	public static final String LBR_LOTSENDINGSTATUS_549_RejeiçãoCNPJDaNFReferenciadaDeProdutorInválido = "549";
	/** 550 - Rejeição: CPF da NF referenciada de produtor inválido. = 550 */
	public static final String LBR_LOTSENDINGSTATUS_550_RejeiçãoCPFDaNFReferenciadaDeProdutorInválido = "550";
	/** 551 - Rejeição: IE da NF referenciada de produtor inválido. = 551 */
	public static final String LBR_LOTSENDINGSTATUS_551_RejeiçãoIEDaNFReferenciadaDeProdutorInválido = "551";
	/** 552 - Rejeição: Dígito Verificador da Chave de Acesso do CT-e Referenciado inválido = 552 */
	public static final String LBR_LOTSENDINGSTATUS_552_RejeiçãoDígitoVerificadorDaChaveDeAcessoDoCT_EReferenciadoInválido = "552";
	/** 553 - Rejeição: Tipo autorizador do recibo diverge do Órgão Autorizador = 553 */
	public static final String LBR_LOTSENDINGSTATUS_553_RejeiçãoTipoAutorizadorDoReciboDivergeDoÓrgãoAutorizador = "553";
	/** 554 - Rejeição: Série difere da faixa 0-899 = 554 */
	public static final String LBR_LOTSENDINGSTATUS_554_RejeiçãoSérieDifereDaFaixa0_899 = "554";
	/** 555 - Rejeição: Tipo autorizador do protocolo diverge do Órgão Autorizador = 555 */
	public static final String LBR_LOTSENDINGSTATUS_555_RejeiçãoTipoAutorizadorDoProtocoloDivergeDoÓrgãoAutorizador = "555";
	/** 556 - Rejeição: Justific.de entrada em conting.não deve ser informada p/tp.emis.normal = 556 */
	public static final String LBR_LOTSENDINGSTATUS_556_RejeiçãoJustificDeEntradaEmContingNãoDeveSerInformadaPTpEmisNormal = "556";
	/** 557 - Rejeição: A Justificativa de entrada em contingência deve ser informada = 557 */
	public static final String LBR_LOTSENDINGSTATUS_557_RejeiçãoAJustificativaDeEntradaEmContingênciaDeveSerInformada = "557";
	/** 558 - Rejeição: Data de entrada em contingência posterior a data de emissão = 558 */
	public static final String LBR_LOTSENDINGSTATUS_558_RejeiçãoDataDeEntradaEmContingênciaPosteriorADataDeEmissão = "558";
	/** 559 - Rejeição: UF do Transportador não informada = 559 */
	public static final String LBR_LOTSENDINGSTATUS_559_RejeiçãoUFDoTransportadorNãoInformada = "559";
	/** 560 - Rejeição: CNPJ base do emitente <> CNPJ base da primeira NF-e do lote recebido = 560 */
	public static final String LBR_LOTSENDINGSTATUS_560_RejeiçãoCNPJBaseDoEmitenteCNPJBaseDaPrimeiraNF_EDoLoteRecebido = "560";
	/** 561 - Rejeição: Mês de Emissão informado na Chave de Acesso difere do Mês de Emissão d = 561 */
	public static final String LBR_LOTSENDINGSTATUS_561_RejeiçãoMêsDeEmissãoInformadoNaChaveDeAcessoDifereDoMêsDeEmissãoD = "561";
	/** 562 - Rejeição: Código Numérico informado da Chave de Acesso <> Código Numérico da NFe = 562 */
	public static final String LBR_LOTSENDINGSTATUS_562_RejeiçãoCódigoNuméricoInformadoDaChaveDeAcessoCódigoNuméricoDaNFe = "562";
	/** 563 - Rejeição: Já existe pedido de Inutilização com a mesma faixa de inutilização = 563 */
	public static final String LBR_LOTSENDINGSTATUS_563_RejeiçãoJáExistePedidoDeInutilizaçãoComAMesmaFaixaDeInutilização = "563";
	/** 564 - Rejeição: Total do Produto / Serviço difere do somatório dos itens = 564 */
	public static final String LBR_LOTSENDINGSTATUS_564_RejeiçãoTotalDoProdutoServiçoDifereDoSomatórioDosItens = "564";
	/** 565 - Rejeição: Falha no schema XML - inexiste a tag raiz esperada para o lote de NF-e = 565 */
	public static final String LBR_LOTSENDINGSTATUS_565_RejeiçãoFalhaNoSchemaXML_InexisteATagRaizEsperadaParaOLoteDeNF_E = "565";
	/** 567 - Rejeição: Falha schema XML - versão inform.na Dados do SOAPHeader difere do lote = 567 */
	public static final String LBR_LOTSENDINGSTATUS_567_RejeiçãoFalhaSchemaXML_VersãoInformNaDadosDoSOAPHeaderDifereDoLote = "567";
	/** 568 - Rejeição: Falha schema XML inexiste atributo versão na tag raiz do lote de NF-e = 568 */
	public static final String LBR_LOTSENDINGSTATUS_568_RejeiçãoFalhaSchemaXMLInexisteAtributoVersãoNaTagRaizDoLoteDeNF_E = "568";
	/** 569 - Rejeição: Data de entrada em contingência muito atrasada = 569 */
	public static final String LBR_LOTSENDINGSTATUS_569_RejeiçãoDataDeEntradaEmContingênciaMuitoAtrasada = "569";
	/** 570 - Rejeição: Tipo de emissão 3; 6 e 7 só é valido nas contingêncis SCAN/SVC = 570 */
	public static final String LBR_LOTSENDINGSTATUS_570_RejeiçãoTipoDeEmissão36E7SóÉValidoNasContingêncisSCANSVC = "570";
	/** 571 - Rejeição: O tpEmis informado diferente de 3 para contingência SCAN = 571 */
	public static final String LBR_LOTSENDINGSTATUS_571_RejeiçãoOTpEmisInformadoDiferenteDe3ParaContingênciaSCAN = "571";
	/** 572 - Rejeição: Erro Atributo ID do evento erro concatenação dos campos ('ID' + tpEvento + chNFe + nSeq) = 572 */
	public static final String LBR_LOTSENDINGSTATUS_572_RejeiçãoErroAtributoIDDoEventoErroConcatenaçãoDosCamposIDPlusTpEventoPlusChNFePlusNSeq = "572";
	/** 573 - Rejeição: Duplicidade de Evento = 573 */
	public static final String LBR_LOTSENDINGSTATUS_573_RejeiçãoDuplicidadeDeEvento = "573";
	/** 574 - Rejeição: O autor do evento diverge do emissor da NF-e = 574 */
	public static final String LBR_LOTSENDINGSTATUS_574_RejeiçãoOAutorDoEventoDivergeDoEmissorDaNF_E = "574";
	/** 575 - Rejeição: O autor do evento diverge do destinatário da NF-e = 575 */
	public static final String LBR_LOTSENDINGSTATUS_575_RejeiçãoOAutorDoEventoDivergeDoDestinatárioDaNF_E = "575";
	/** 576 - Rejeição: O autor do evento não é um órgão autorizado a gerar o evento = 576 */
	public static final String LBR_LOTSENDINGSTATUS_576_RejeiçãoOAutorDoEventoNãoÉUmÓrgãoAutorizadoAGerarOEvento = "576";
	/** 577 - Rejeição: A data do evento não pode ser menor que a data de emissão da NF-e = 577 */
	public static final String LBR_LOTSENDINGSTATUS_577_RejeiçãoADataDoEventoNãoPodeSerMenorQueADataDeEmissãoDaNF_E = "577";
	/** 578 - Rejeição: A data do evento não pode ser maior que a data do processamento = 578 */
	public static final String LBR_LOTSENDINGSTATUS_578_RejeiçãoADataDoEventoNãoPodeSerMaiorQueADataDoProcessamento = "578";
	/** 579 - Rejeição: A data do evento não pode ser menor que a data de autorização para NF-e não emitida em contingência = 579 */
	public static final String LBR_LOTSENDINGSTATUS_579_RejeiçãoADataDoEventoNãoPodeSerMenorQueADataDeAutorizaçãoParaNF_ENãoEmitidaEmContingência = "579";
	/** 580 - Rejeição: O evento exige uma NF-e autorizada = 580 */
	public static final String LBR_LOTSENDINGSTATUS_580_RejeiçãoOEventoExigeUmaNF_EAutorizada = "580";
	/** 587 - Rejeição: Usar somente o namespace padrão da NF-e = 587 */
	public static final String LBR_LOTSENDINGSTATUS_587_RejeiçãoUsarSomenteONamespacePadrãoDaNF_E = "587";
	/** 588 - Rejeição: Não é permitida a presença de caracteres de edição no início/fim da mensagem ou entre as tags da mensagem = 588 */
	public static final String LBR_LOTSENDINGSTATUS_588_RejeiçãoNãoÉPermitidaAPresençaDeCaracteresDeEdiçãoNoInícioFimDaMensagemOuEntreAsTagsDaMensagem = "588";
	/** 589 - Rejeição: Número do NSU informado superior ao maior NSU da base de dados da SEFAZ = 589 */
	public static final String LBR_LOTSENDINGSTATUS_589_RejeiçãoNúmeroDoNSUInformadoSuperiorAoMaiorNSUDaBaseDeDadosDaSEFAZ = "589";
	/** 590 - Rejeição: Informado CST para emissor do Simples Nacional = 590 */
	public static final String LBR_LOTSENDINGSTATUS_590_RejeiçãoInformadoCSTParaEmissorDoSimplesNacional = "590";
	/** 591 - Rejeição: Informado CSOSN para emissor que não é do Simples Nacional (CRT diferente de 1) = 591 */
	public static final String LBR_LOTSENDINGSTATUS_591_RejeiçãoInformadoCSOSNParaEmissorQueNãoÉDoSimplesNacionalCRTDiferenteDe1 = "591";
	/** 592 - Rejeição: A NF-e deve ter pelo menos um item de produto sujeito ao ICMS = 592 */
	public static final String LBR_LOTSENDINGSTATUS_592_RejeiçãoANF_EDeveTerPeloMenosUmItemDeProdutoSujeitoAoICMS = "592";
	/** 593 - Rejeição: CNPJ-Base consultado difere do CNPJ-Base do Certificado Digital = 593 */
	public static final String LBR_LOTSENDINGSTATUS_593_RejeiçãoCNPJ_BaseConsultadoDifereDoCNPJ_BaseDoCertificadoDigital = "593";
	/** 594 - Rejeição: O número de sequencia do evento informado é maior que o permitido = 594 */
	public static final String LBR_LOTSENDINGSTATUS_594_RejeiçãoONúmeroDeSequenciaDoEventoInformadoÉMaiorQueOPermitido = "594";
	/** 595 - Rejeição: Rejeição: A versão do leiaute da NF-e utilizada não é mais válida = 595 */
	public static final String LBR_LOTSENDINGSTATUS_595_RejeiçãoRejeiçãoAVersãoDoLeiauteDaNF_EUtilizadaNãoÉMaisVálida = "595";
	/** 596 - Rejeição: Rejeição: Ambiente de homologação indisponível para recepção de NF-e da versão 1.10. = 596 */
	public static final String LBR_LOTSENDINGSTATUS_596_RejeiçãoRejeiçãoAmbienteDeHomologaçãoIndisponívelParaRecepçãoDeNF_EDaVersão110 = "596";
	/** 597 - Rejeição: CFOP de Importação e não informado dados de IPI = 597 */
	public static final String LBR_LOTSENDINGSTATUS_597_RejeiçãoCFOPDeImportaçãoENãoInformadoDadosDeIPI = "597";
	/** 598 - Rejeição: NF-e emitida em ambiente de homologação com razão social <> de NF-e (Emitida homologação - S/vlr fiscal) = 598 */
	public static final String LBR_LOTSENDINGSTATUS_598_RejeiçãoNF_EEmitidaEmAmbienteDeHomologaçãoComRazãoSocialDeNF_EEmitidaHomologação_SVlrFiscal = "598";
	/** 599 - Rejeição: CFOP de Importação e não informado dados de II = 599 */
	public static final String LBR_LOTSENDINGSTATUS_599_RejeiçãoCFOPDeImportaçãoENãoInformadoDadosDeII = "599";
	/** 601 - Rejeição: Total do II difere do somatório dos itens = 601 */
	public static final String LBR_LOTSENDINGSTATUS_601_RejeiçãoTotalDoIIDifereDoSomatórioDosItens = "601";
	/** 602 - Rejeição: Total do PIS difere do somatório dos itens sujeitos ao ICMS = 602 */
	public static final String LBR_LOTSENDINGSTATUS_602_RejeiçãoTotalDoPISDifereDoSomatórioDosItensSujeitosAoICMS = "602";
	/** 603 - Rejeição: Total do COFINS difere do somatório dos itens sujeitos ao ICMS = 603 */
	public static final String LBR_LOTSENDINGSTATUS_603_RejeiçãoTotalDoCOFINSDifereDoSomatórioDosItensSujeitosAoICMS = "603";
	/** 604 - Rejeição: Total do vOutro difere do somatório dos itens = 604 */
	public static final String LBR_LOTSENDINGSTATUS_604_RejeiçãoTotalDoVOutroDifereDoSomatórioDosItens = "604";
	/** 605 - Rejeição: Total do vServ difere do somatório do vProd dos itens sujeitos ao ISSQN = 605 */
	public static final String LBR_LOTSENDINGSTATUS_605_RejeiçãoTotalDoVServDifereDoSomatórioDoVProdDosItensSujeitosAoISSQN = "605";
	/** 606 - Rejeição: Total do vBC do ISS difere do somatório dos itens = 606 */
	public static final String LBR_LOTSENDINGSTATUS_606_RejeiçãoTotalDoVBCDoISSDifereDoSomatórioDosItens = "606";
	/** 607 - Rejeição: Total do ISS difere do somatório dos itens = 607 */
	public static final String LBR_LOTSENDINGSTATUS_607_RejeiçãoTotalDoISSDifereDoSomatórioDosItens = "607";
	/** 608 - Rejeição: Total do PIS difere do somatório dos itens sujeitos ao ISSQN = 608 */
	public static final String LBR_LOTSENDINGSTATUS_608_RejeiçãoTotalDoPISDifereDoSomatórioDosItensSujeitosAoISSQN = "608";
	/** 609 - Rejeição: Total do COFINS difere do somatório dos itens sujeitos ao ISSQN = 609 */
	public static final String LBR_LOTSENDINGSTATUS_609_RejeiçãoTotalDoCOFINSDifereDoSomatórioDosItensSujeitosAoISSQN = "609";
	/** 610 - Rejeição: Total da NF difere do somatório dos Valores compõe o valor Total da NF = 610 */
	public static final String LBR_LOTSENDINGSTATUS_610_RejeiçãoTotalDaNFDifereDoSomatórioDosValoresCompõeOValorTotalDaNF = "610";
	/** 611 - Rejeição: cEAN inválido = 611 */
	public static final String LBR_LOTSENDINGSTATUS_611_RejeiçãoCEANInválido = "611";
	/** 612 - Rejeição: cEANTrib inválido = 612 */
	public static final String LBR_LOTSENDINGSTATUS_612_RejeiçãoCEANTribInválido = "612";
	/** 613 - Rejeição: Chave de Acesso difere da existente em BD = 613 */
	public static final String LBR_LOTSENDINGSTATUS_613_RejeiçãoChaveDeAcessoDifereDaExistenteEmBD = "613";
	/** 614 - Rejeição: Chave de Acesso inválida (Código UF inválido) = 614 */
	public static final String LBR_LOTSENDINGSTATUS_614_RejeiçãoChaveDeAcessoInválidaCódigoUFInválido = "614";
	/** 615 - Rejeição: Chave de Acesso inválida (Ano < 05 ou Ano maior que Ano corrente) = 615 */
	public static final String LBR_LOTSENDINGSTATUS_615_RejeiçãoChaveDeAcessoInválidaAnoLe05OuAnoMaiorQueAnoCorrente = "615";
	/** 616 - Rejeição: Chave de Acesso inválida (Mês < 1 ou Mês > 12) = 616 */
	public static final String LBR_LOTSENDINGSTATUS_616_RejeiçãoChaveDeAcessoInválidaMês1OuMês12 = "616";
	/** 617 - Rejeição: Chave de Acesso inválida (CNPJ zerado ou dígito inválido) = 617 */
	public static final String LBR_LOTSENDINGSTATUS_617_RejeiçãoChaveDeAcessoInválidaCNPJZeradoOuDígitoInválido = "617";
	/** 618 - Rejeição: Chave de Acesso inválida (modelo diferente de 55 e 65 ) = 618 */
	public static final String LBR_LOTSENDINGSTATUS_618_RejeiçãoChaveDeAcessoInválidaModeloDiferenteDe55E65 = "618";
	/** 619 - Rejeição: Chave de Acesso inválida (número NF = 0) = 619 */
	public static final String LBR_LOTSENDINGSTATUS_619_RejeiçãoChaveDeAcessoInválidaNúmeroNFEq0 = "619";
	/** 620 - Rejeição: Chave de Acesso difere da existente em BD = 620 */
	public static final String LBR_LOTSENDINGSTATUS_620_RejeiçãoChaveDeAcessoDifereDaExistenteEmBD = "620";
	/** 621 - Rejeição: CPF Emitente não cadastrado = 621 */
	public static final String LBR_LOTSENDINGSTATUS_621_RejeiçãoCPFEmitenteNãoCadastrado = "621";
	/** 622 - Rejeição: IE emitente não vinculada ao CPF = 622 */
	public static final String LBR_LOTSENDINGSTATUS_622_RejeiçãoIEEmitenteNãoVinculadaAoCPF = "622";
	/** 623 - Rejeição: CPF Destinatário não cadastrado = 623 */
	public static final String LBR_LOTSENDINGSTATUS_623_RejeiçãoCPFDestinatárioNãoCadastrado = "623";
	/** 624 - Rejeição: IE Destinatário não vinculada ao CPF = 624 */
	public static final String LBR_LOTSENDINGSTATUS_624_RejeiçãoIEDestinatárioNãoVinculadaAoCPF = "624";
	/** 625 - Rejeição: Inscrição SUFRAMA deve ser informada na venda com isenção para ZFM = 625 */
	public static final String LBR_LOTSENDINGSTATUS_625_RejeiçãoInscriçãoSUFRAMADeveSerInformadaNaVendaComIsençãoParaZFM = "625";
	/** 626 - Rejeição: O CFOP de operação isenta para ZFM diferente do previsto = 626 */
	public static final String LBR_LOTSENDINGSTATUS_626_RejeiçãoOCFOPDeOperaçãoIsentaParaZFMDiferenteDoPrevisto = "626";
	/** 627 - Rejeição: O valor do ICMS desonerado deve ser informado = 627 */
	public static final String LBR_LOTSENDINGSTATUS_627_RejeiçãoOValorDoICMSDesoneradoDeveSerInformado = "627";
	/** 628 - Rejeição: Total da NF superior ao valor limite estabelecido pela SEFAZ [Limite] = 628 */
	public static final String LBR_LOTSENDINGSTATUS_628_RejeiçãoTotalDaNFSuperiorAoValorLimiteEstabelecidoPelaSEFAZLimite = "628";
	/** 629 - Rejeição: Vlr Produto difere do produto Valor Unitário de Comercialização e quantidade comercial = 629 */
	public static final String LBR_LOTSENDINGSTATUS_629_RejeiçãoVlrProdutoDifereDoProdutoValorUnitárioDeComercializaçãoEQuantidadeComercial = "629";
	/** 630 - Rejeição: Vlr Produto difere do produto Valor Unitário de Tributação e quantidade tributável = 630 */
	public static final String LBR_LOTSENDINGSTATUS_630_RejeiçãoVlrProdutoDifereDoProdutoValorUnitárioDeTributaçãoEQuantidadeTributável = "630";
	/** 631 - Rejeição: CNPJ-Base do Destinatário difere do CNPJ-Base do Certificado Digital = 631 */
	public static final String LBR_LOTSENDINGSTATUS_631_RejeiçãoCNPJ_BaseDoDestinatárioDifereDoCNPJ_BaseDoCertificadoDigital = "631";
	/** 632 - Rejeição: Solicitação fora de prazo; a NF-e não está mais disponível para download = 632 */
	public static final String LBR_LOTSENDINGSTATUS_632_RejeiçãoSolicitaçãoForaDePrazoANF_ENãoEstáMaisDisponívelParaDownload = "632";
	/** 633 - Rejeição: NF-e indisponível para download devido a ausência de Manifestação do Destinatário = 633 */
	public static final String LBR_LOTSENDINGSTATUS_633_RejeiçãoNF_EIndisponívelParaDownloadDevidoAAusênciaDeManifestaçãoDoDestinatário = "633";
	/** 634 - Rejeição: Destinatário da NF-e não tem o mesmo CNPJ raiz do solicitante do download = 634 */
	public static final String LBR_LOTSENDINGSTATUS_634_RejeiçãoDestinatárioDaNF_ENãoTemOMesmoCNPJRaizDoSolicitanteDoDownload = "634";
	/** 635 - Rejeição: NF-e com mesmo número e série já transmitida e aguardando processamento = 635 */
	public static final String LBR_LOTSENDINGSTATUS_635_RejeiçãoNF_EComMesmoNúmeroESérieJáTransmitidaEAguardandoProcessamento = "635";
	/** 650 - Rejeição: Evento de 'Ciência da Operação' para NF-e Cancelada ou Denegada = 650 */
	public static final String LBR_LOTSENDINGSTATUS_650_RejeiçãoEventoDeCiênciaDaOperaçãoParaNF_ECanceladaOuDenegada = "650";
	/** 651 - Rejeição: Evento de 'Desconhecimento da Operação' para NF-e Cancelada ou Denegada = 651 */
	public static final String LBR_LOTSENDINGSTATUS_651_RejeiçãoEventoDeDesconhecimentoDaOperaçãoParaNF_ECanceladaOuDenegada = "651";
	/** 653 - Rejeição: NF-e Cancelada; arquivo indisponível para download = 653 */
	public static final String LBR_LOTSENDINGSTATUS_653_RejeiçãoNF_ECanceladaArquivoIndisponívelParaDownload = "653";
	/** 654 - Rejeição: NF-e Denegada; arquivo indisponível para download = 654 */
	public static final String LBR_LOTSENDINGSTATUS_654_RejeiçãoNF_EDenegadaArquivoIndisponívelParaDownload = "654";
	/** 655 - Rejeição: Evento de Ciência da Operação informado após a manifestação final do destinatário = 655 */
	public static final String LBR_LOTSENDINGSTATUS_655_RejeiçãoEventoDeCiênciaDaOperaçãoInformadoApósAManifestaçãoFinalDoDestinatário = "655";
	/** 656 - Rejeição: Consumo indevido = 656 */
	public static final String LBR_LOTSENDINGSTATUS_656_RejeiçãoConsumoIndevido = "656";
	/** 657 - Rejeição: Código do Órgão diverge do órgão autorizador = 657 */
	public static final String LBR_LOTSENDINGSTATUS_657_RejeiçãoCódigoDoÓrgãoDivergeDoÓrgãoAutorizador = "657";
	/** 658 - Rejeição: UF do destinatário da Chave de Acesso diverge da UF autorizadora = 658 */
	public static final String LBR_LOTSENDINGSTATUS_658_RejeiçãoUFDoDestinatárioDaChaveDeAcessoDivergeDaUFAutorizadora = "658";
	/** 660 - Rejeição: CFOP de Combustível e não informado grupo de combustível da NF-e = 660 */
	public static final String LBR_LOTSENDINGSTATUS_660_RejeiçãoCFOPDeCombustívelENãoInformadoGrupoDeCombustívelDaNF_E = "660";
	/** 661 - Rejeição: NF-e já existente para o número da DPEC informada = 661 */
	public static final String LBR_LOTSENDINGSTATUS_661_RejeiçãoNF_EJáExistenteParaONúmeroDaDPECInformada = "661";
	/** 662 - Rejeição: Numeração da DPEC está inutilizada na Base de Dados da SEFAZ = 662 */
	public static final String LBR_LOTSENDINGSTATUS_662_RejeiçãoNumeraçãoDaDPECEstáInutilizadaNaBaseDeDadosDaSEFAZ = "662";
	/** 663 - Rejeição: Alíq. ICMS maior que 4% na saída interestadual com produtos importados = 663 */
	public static final String LBR_LOTSENDINGSTATUS_663_RejeiçãoAlíqICMSMaiorQue4NaSaídaInterestadualComProdutosImportados = "663";
	/** 678 - Rejeição: NF referenciada com UF diferente da UF da NF-e complementar = 678 */
	public static final String LBR_LOTSENDINGSTATUS_678_RejeiçãoNFReferenciadaComUFDiferenteDaUFDaNF_EComplementar = "678";
	/** 679 - Rejeição: Modelo da NF-e referenciada diferente de 55 = 679 */
	public static final String LBR_LOTSENDINGSTATUS_679_RejeiçãoModeloDaNF_EReferenciadaDiferenteDe55 = "679";
	/** 680 - Rejeição: Duplicidade de NF-e referenciada (chave de acesso ref mais de uma vez) = 680 */
	public static final String LBR_LOTSENDINGSTATUS_680_RejeiçãoDuplicidadeDeNF_EReferenciadaChaveDeAcessoRefMaisDeUmaVez = "680";
	/** 681 - Rejeição: Duplicidade de NF Modelo 1 referenciada (CNPJ; Modelo Série e Número) = 681 */
	public static final String LBR_LOTSENDINGSTATUS_681_RejeiçãoDuplicidadeDeNFModelo1ReferenciadaCNPJModeloSérieENúmero = "681";
	/** 682 - Rejeição: Duplicidade de NF de produtor referenciada (IE; Modelo; Série e Número) = 682 */
	public static final String LBR_LOTSENDINGSTATUS_682_RejeiçãoDuplicidadeDeNFDeProdutorReferenciadaIEModeloSérieENúmero = "682";
	/** 683 - Rejeição: Modelo do CT-e referenciado diferente de 57 = 683 */
	public static final String LBR_LOTSENDINGSTATUS_683_RejeiçãoModeloDoCT_EReferenciadoDiferenteDe57 = "683";
	/** 684 - Rejeição: Duplicidade de Cupom Fiscal referenciado (Modelo; Número e Ordem e COO) = 684 */
	public static final String LBR_LOTSENDINGSTATUS_684_RejeiçãoDuplicidadeDeCupomFiscalReferenciadoModeloNúmeroEOrdemECOO = "684";
	/** 685 - Rejeição: Total do valor aproximado dos tributos difere do somatório dos itens = 685 */
	public static final String LBR_LOTSENDINGSTATUS_685_RejeiçãoTotalDoValorAproximadoDosTributosDifereDoSomatórioDosItens = "685";
	/** 686 - Rejeição: NF complementar referencia uma NF-e cancelada = 686 */
	public static final String LBR_LOTSENDINGSTATUS_686_RejeiçãoNFComplementarReferenciaUmaNF_ECancelada = "686";
	/** 687 - Rejeição: NF complementar referencia uma NF-e denegada = 687 */
	public static final String LBR_LOTSENDINGSTATUS_687_RejeiçãoNFComplementarReferenciaUmaNF_EDenegada = "687";
	/** 688 - Rejeição: NF referenciada de produtor com IE inexistente (nREF: xxx) = 688 */
	public static final String LBR_LOTSENDINGSTATUS_688_RejeiçãoNFReferenciadaDeProdutorComIEInexistenteNREFXxx = "688";
	/** 689 - Rejeição: NF referenciada de produtor com IE não vinculada ao CNPJ/CPF informado (nREF: xxx) = 689 */
	public static final String LBR_LOTSENDINGSTATUS_689_RejeiçãoNFReferenciadaDeProdutorComIENãoVinculadaAoCNPJCPFInformadoNREFXxx = "689";
	/** 690 - Rejeição: Pedido de cancelamento para NF-e com CT-e ou MDF-e = 690 */
	public static final String LBR_LOTSENDINGSTATUS_690_RejeiçãoPedidoDeCancelamentoParaNF_EComCT_EOuMDF_E = "690";
	/** 701 - Rejeição: NF-e não pode utilizar verão 3.00 = 701 */
	public static final String LBR_LOTSENDINGSTATUS_701_RejeiçãoNF_ENãoPodeUtilizarVerão300 = "701";
	/** 702 - Rejeição: NFC-e não é aceita pela UF do Emitente = 702 */
	public static final String LBR_LOTSENDINGSTATUS_702_RejeiçãoNFC_ENãoÉAceitaPelaUFDoEmitente = "702";
	/** 703 - Rejeição: Data-hora de emissão posterior ao horário de recebimento = 703 */
	public static final String LBR_LOTSENDINGSTATUS_703_RejeiçãoData_HoraDeEmissãoPosteriorAoHorárioDeRecebimento = "703";
	/** 704 - Rejeição: NFC-e com data-hora de emissão atrasada = 704 */
	public static final String LBR_LOTSENDINGSTATUS_704_RejeiçãoNFC_EComData_HoraDeEmissãoAtrasada = "704";
	/** 705 - Rejeição: NFC-e com data de entrada/saida = 705 */
	public static final String LBR_LOTSENDINGSTATUS_705_RejeiçãoNFC_EComDataDeEntradaSaida = "705";
	/** 706 - Rejeição: NFC-e para operação de entrada = 706 */
	public static final String LBR_LOTSENDINGSTATUS_706_RejeiçãoNFC_EParaOperaçãoDeEntrada = "706";
	/** 707 - Rejeição: NFC-e para operação interestadual ou com o exterior = 707 */
	public static final String LBR_LOTSENDINGSTATUS_707_RejeiçãoNFC_EParaOperaçãoInterestadualOuComOExterior = "707";
	/** 708 - Rejeição: NFC-e nao pode referenciar um documento fiscal = 708 */
	public static final String LBR_LOTSENDINGSTATUS_708_RejeiçãoNFC_ENaoPodeReferenciarUmDocumentoFiscal = "708";
	/** 709 - Rejeição: NFC-e com formato de DANFE inválido = 709 */
	public static final String LBR_LOTSENDINGSTATUS_709_RejeiçãoNFC_EComFormatoDeDANFEInválido = "709";
	/** 710 - Rejeição: NF-e com formado de DANFE inválido = 710 */
	public static final String LBR_LOTSENDINGSTATUS_710_RejeiçãoNF_EComFormadoDeDANFEInválido = "710";
	/** 711 - Rejeição: NF-e com contingência off-line = 711 */
	public static final String LBR_LOTSENDINGSTATUS_711_RejeiçãoNF_EComContingênciaOff_Line = "711";
	/** 712 - Rejeição: NFC-e com contingência off-line para a UF = 712 */
	public static final String LBR_LOTSENDINGSTATUS_712_RejeiçãoNFC_EComContingênciaOff_LineParaAUF = "712";
	/** 713 - Rejeição: Tipo de emissão diferente de 6 ou 7 para contingência da SVC acessada = 713 */
	public static final String LBR_LOTSENDINGSTATUS_713_RejeiçãoTipoDeEmissãoDiferenteDe6Ou7ParaContingênciaDaSVCAcessada = "713";
	/** 714 - Rejeição: NFC-e com contingência DPEC inexistente = 714 */
	public static final String LBR_LOTSENDINGSTATUS_714_RejeiçãoNFC_EComContingênciaDPECInexistente = "714";
	/** 715 - Rejeição: NFC-e com finalidade inválida = 715 */
	public static final String LBR_LOTSENDINGSTATUS_715_RejeiçãoNFC_EComFinalidadeInválida = "715";
	/** 716 - Rejeição: NFC-e em operaçoã não destinada a consumidor final = 716 */
	public static final String LBR_LOTSENDINGSTATUS_716_RejeiçãoNFC_EEmOperaçoãNãoDestinadaAConsumidorFinal = "716";
	/** 717 - Rejeição: NFC-e em operação não presencial = 717 */
	public static final String LBR_LOTSENDINGSTATUS_717_RejeiçãoNFC_EEmOperaçãoNãoPresencial = "717";
	/** 718 - Rejeição: NFC-e não deve informar IE de substituto tributário = 718 */
	public static final String LBR_LOTSENDINGSTATUS_718_RejeiçãoNFC_ENãoDeveInformarIEDeSubstitutoTributário = "718";
	/** 719 - Rejeição: NF-e sem identificação do destinatário = 719 */
	public static final String LBR_LOTSENDINGSTATUS_719_RejeiçãoNF_ESemIdentificaçãoDoDestinatário = "719";
	/** 720 - Rejeição: Na operação com exterior deve ser informada tag id Estrangeiro = 720 */
	public static final String LBR_LOTSENDINGSTATUS_720_RejeiçãoNaOperaçãoComExteriorDeveSerInformadaTagIdEstrangeiro = "720";
	/** 721 - Rejeição: Operação interestadual deve informar CNPJ ou CPF = 721 */
	public static final String LBR_LOTSENDINGSTATUS_721_RejeiçãoOperaçãoInterestadualDeveInformarCNPJOuCPF = "721";
	/** 722 - Rejeição: Operação interna com idEstrangeiro informado deve ser presencial = 722 */
	public static final String LBR_LOTSENDINGSTATUS_722_RejeiçãoOperaçãoInternaComIdEstrangeiroInformadoDeveSerPresencial = "722";
	/** 723 - Rejeição: Operação interna com idEstrangeiro informado deve ser para consumidor final = 723 */
	public static final String LBR_LOTSENDINGSTATUS_723_RejeiçãoOperaçãoInternaComIdEstrangeiroInformadoDeveSerParaConsumidorFinal = "723";
	/** 724 - Rejeição: NF-e sem o nome do destinatário = 724 */
	public static final String LBR_LOTSENDINGSTATUS_724_RejeiçãoNF_ESemONomeDoDestinatário = "724";
	/** 725 - Rejeição: NFC-e com CFOP inválido = 725 */
	public static final String LBR_LOTSENDINGSTATUS_725_RejeiçãoNFC_EComCFOPInválido = "725";
	/** 726 - Rejeição: NF-e sem a informação de endereço do destinatário = 726 */
	public static final String LBR_LOTSENDINGSTATUS_726_RejeiçãoNF_ESemAInformaçãoDeEndereçoDoDestinatário = "726";
	/** 727 - Rejeição: Operação com exterior e UF diferente de EX = 727 */
	public static final String LBR_LOTSENDINGSTATUS_727_RejeiçãoOperaçãoComExteriorEUFDiferenteDeEX = "727";
	/** 728 - Rejeição: NF-e sem informação da IE do destinatário = 728 */
	public static final String LBR_LOTSENDINGSTATUS_728_RejeiçãoNF_ESemInformaçãoDaIEDoDestinatário = "728";
	/** 729 - Rejeição: NFC-e sem informação da IE do destinatário = 729 */
	public static final String LBR_LOTSENDINGSTATUS_729_RejeiçãoNFC_ESemInformaçãoDaIEDoDestinatário = "729";
	/** 730 - Rejeição: NFC-e com inscrição SUFRAMA = 730 */
	public static final String LBR_LOTSENDINGSTATUS_730_RejeiçãoNFC_EComInscriçãoSUFRAMA = "730";
	/** 731 - Rejeição: CFOP de operação com exterior e idDest <> 3 = 731 */
	public static final String LBR_LOTSENDINGSTATUS_731_RejeiçãoCFOPDeOperaçãoComExteriorEIdDest3 = "731";
	/** 732 - Rejeição: CFOP de operação com interestadual e idDest <> 2 = 732 */
	public static final String LBR_LOTSENDINGSTATUS_732_RejeiçãoCFOPDeOperaçãoComInterestadualEIdDest2 = "732";
	/** 733 - Rejeição: CFOP de operação interna e idDest <> 1 = 733 */
	public static final String LBR_LOTSENDINGSTATUS_733_RejeiçãoCFOPDeOperaçãoInternaEIdDest1 = "733";
	/** 734 - Rejeição: NFC-e com unidade de comercialização inválida = 734 */
	public static final String LBR_LOTSENDINGSTATUS_734_RejeiçãoNFC_EComUnidadeDeComercializaçãoInválida = "734";
	/** 735 - Rejeição: NFC-e com unidade de tributação inválida = 735 */
	public static final String LBR_LOTSENDINGSTATUS_735_RejeiçãoNFC_EComUnidadeDeTributaçãoInválida = "735";
	/** 736 - Rejeição: NFC-e com grupo de veículos novos = 736 */
	public static final String LBR_LOTSENDINGSTATUS_736_RejeiçãoNFC_EComGrupoDeVeículosNovos = "736";
	/** 737 - Rejeição: NFC-e com grupo de medicamentos = 737 */
	public static final String LBR_LOTSENDINGSTATUS_737_RejeiçãoNFC_EComGrupoDeMedicamentos = "737";
	/** 738 - Rejeição: NFC-e com grupo de armamentos = 738 */
	public static final String LBR_LOTSENDINGSTATUS_738_RejeiçãoNFC_EComGrupoDeArmamentos = "738";
	/** 739 - Rejeição: NFC-e com grupo de combustíveis = 739 */
	public static final String LBR_LOTSENDINGSTATUS_739_RejeiçãoNFC_EComGrupoDeCombustíveis = "739";
	/** 740 - Rejeição: NFC-e com CST 51 - diferimento = 740 */
	public static final String LBR_LOTSENDINGSTATUS_740_RejeiçãoNFC_EComCST51_Diferimento = "740";
	/** 741 - Rejeição: NFC-e com partilha de CIMS entre UF = 741 */
	public static final String LBR_LOTSENDINGSTATUS_741_RejeiçãoNFC_EComPartilhaDeCIMSEntreUF = "741";
	/** 742 - Rejeição: NFC-e com grupo do IPI = 742 */
	public static final String LBR_LOTSENDINGSTATUS_742_RejeiçãoNFC_EComGrupoDoIPI = "742";
	/** 743 - Rejeição: NFC-e com grupo do II = 743 */
	public static final String LBR_LOTSENDINGSTATUS_743_RejeiçãoNFC_EComGrupoDoII = "743";
	/** 745 - Rejeição: NF-e sem grupo do PIS = 745 */
	public static final String LBR_LOTSENDINGSTATUS_745_RejeiçãoNF_ESemGrupoDoPIS = "745";
	/** 746 - Rejeição: NFC-e com grupo do PIS-ST = 746 */
	public static final String LBR_LOTSENDINGSTATUS_746_RejeiçãoNFC_EComGrupoDoPIS_ST = "746";
	/** 748 - Rejeição: NF-e sem grupo do COFINS = 748 */
	public static final String LBR_LOTSENDINGSTATUS_748_RejeiçãoNF_ESemGrupoDoCOFINS = "748";
	/** 749 - Rejeição: NF-e sem grupo do COFINS-ST = 749 */
	public static final String LBR_LOTSENDINGSTATUS_749_RejeiçãoNF_ESemGrupoDoCOFINS_ST = "749";
	/** 750 - Rejeição: NFC-e com valor total superior ao permitido para destinatário não identificado (código) = 750 */
	public static final String LBR_LOTSENDINGSTATUS_750_RejeiçãoNFC_EComValorTotalSuperiorAoPermitidoParaDestinatárioNãoIdentificadoCódigo = "750";
	/** 751 - Rejeição: NFC-e com valor total superior ao permitido para destinatário não identificado (nome) = 751 */
	public static final String LBR_LOTSENDINGSTATUS_751_RejeiçãoNFC_EComValorTotalSuperiorAoPermitidoParaDestinatárioNãoIdentificadoNome = "751";
	/** 752 - Rejeição: NFC-e com valor total superior ao permitido para destinatário não identificado (endereço) = 752 */
	public static final String LBR_LOTSENDINGSTATUS_752_RejeiçãoNFC_EComValorTotalSuperiorAoPermitidoParaDestinatárioNãoIdentificadoEndereço = "752";
	/** 753 - Rejeição: NFC-e sem frete = 753 */
	public static final String LBR_LOTSENDINGSTATUS_753_RejeiçãoNFC_ESemFrete = "753";
	/** 754 - Rejeição: NFC-e com dados do transportador = 754 */
	public static final String LBR_LOTSENDINGSTATUS_754_RejeiçãoNFC_EComDadosDoTransportador = "754";
	/** 755 - Rejeição: NFC-e com dados de retenção do ICMS no transporte = 755 */
	public static final String LBR_LOTSENDINGSTATUS_755_RejeiçãoNFC_EComDadosDeRetençãoDoICMSNoTransporte = "755";
	/** 756 - Rejeição: NFC-e com dados do veículo de transporte = 756 */
	public static final String LBR_LOTSENDINGSTATUS_756_RejeiçãoNFC_EComDadosDoVeículoDeTransporte = "756";
	/** 757 - Rejeição: NFC-e com dados de reboque do veículo de transporte = 757 */
	public static final String LBR_LOTSENDINGSTATUS_757_RejeiçãoNFC_EComDadosDeReboqueDoVeículoDeTransporte = "757";
	/** 758 - Rejeição: NFC-e com dados do vagão de transporte = 758 */
	public static final String LBR_LOTSENDINGSTATUS_758_RejeiçãoNFC_EComDadosDoVagãoDeTransporte = "758";
	/** 759 - Rejeição: NFC-e co dados da balsa de transporte = 759 */
	public static final String LBR_LOTSENDINGSTATUS_759_RejeiçãoNFC_ECoDadosDaBalsaDeTransporte = "759";
	/** 760 - Rejeição: NFC-e com dados de cobrança (fatura; duplicata) = 760 */
	public static final String LBR_LOTSENDINGSTATUS_760_RejeiçãoNFC_EComDadosDeCobrançaFaturaDuplicata = "760";
	/** 762 - Rejeição: NFC-e com dados de compra (empenho; pedido; contrato) = 762 */
	public static final String LBR_LOTSENDINGSTATUS_762_RejeiçãoNFC_EComDadosDeCompraEmpenhoPedidoContrato = "762";
	/** 763 - Rejeição: NFC-e com dados de aquisiçãod e cana = 763 */
	public static final String LBR_LOTSENDINGSTATUS_763_RejeiçãoNFC_EComDadosDeAquisiçãodECana = "763";
	/** 765 - Rejeição: Lote só poderá conter NF-e ou NFC-e = 765 */
	public static final String LBR_LOTSENDINGSTATUS_765_RejeiçãoLoteSóPoderáConterNF_EOuNFC_E = "765";
	/** 766 - Rejeição: NFC-e com CST 50-suspenção = 766 */
	public static final String LBR_LOTSENDINGSTATUS_766_RejeiçãoNFC_EComCST50_Suspenção = "766";
	/** 767 - Rejeição: NFC-e com somatório dos pagamentos diferente do total da Nota Fiscal = 767 */
	public static final String LBR_LOTSENDINGSTATUS_767_RejeiçãoNFC_EComSomatórioDosPagamentosDiferenteDoTotalDaNotaFiscal = "767";
	/** 768 - Rejeição: NF-e não deve possuir o grupo de formas de pagamento = 768 */
	public static final String LBR_LOTSENDINGSTATUS_768_RejeiçãoNF_ENãoDevePossuirOGrupoDeFormasDePagamento = "768";
	/** 769 - Rejeição: NFC-e deve possuir o grupo de formas de pagamento = 769 */
	public static final String LBR_LOTSENDINGSTATUS_769_RejeiçãoNFC_EDevePossuirOGrupoDeFormasDePagamento = "769";
	/** 771 - Rejeição: Operação interestadual e UF de destino com EX = 771 */
	public static final String LBR_LOTSENDINGSTATUS_771_RejeiçãoOperaçãoInterestadualEUFDeDestinoComEX = "771";
	/** 772 - Rejeição: Operação interestadual e UF de destino igual à UF do emitente = 772 */
	public static final String LBR_LOTSENDINGSTATUS_772_RejeiçãoOperaçãoInterestadualEUFDeDestinoIgualÀUFDoEmitente = "772";
	/** 773 - Rejeição: Operação interna e UF de destino difere da UF do emitente = 773 */
	public static final String LBR_LOTSENDINGSTATUS_773_RejeiçãoOperaçãoInternaEUFDeDestinoDifereDaUFDoEmitente = "773";
	/** 774 - Rejeição: NFC-e com indicador de item não participante do total = 774 */
	public static final String LBR_LOTSENDINGSTATUS_774_RejeiçãoNFC_EComIndicadorDeItemNãoParticipanteDoTotal = "774";
	/** 775 - Rejeição: Modelo da NFC-e diferente de 65 = 775 */
	public static final String LBR_LOTSENDINGSTATUS_775_RejeiçãoModeloDaNFC_EDiferenteDe65 = "775";
	/** 777 - Rejeição: NFC-e deve informar NCM completo = 777 */
	public static final String LBR_LOTSENDINGSTATUS_777_RejeiçãoNFC_EDeveInformarNCMCompleto = "777";
	/** 778 - Rejeição: Informado NCM inexistente = 778 */
	public static final String LBR_LOTSENDINGSTATUS_778_RejeiçãoInformadoNCMInexistente = "778";
	/** 779 - Rejeição: NFC-e com NCM incompatível = 779 */
	public static final String LBR_LOTSENDINGSTATUS_779_RejeiçãoNFC_EComNCMIncompatível = "779";
	/** 780 - Rejeição: Total da NFC-e superior ao valor limite estabelecido pela SEFAZ = 780 */
	public static final String LBR_LOTSENDINGSTATUS_780_RejeiçãoTotalDaNFC_ESuperiorAoValorLimiteEstabelecidoPelaSEFAZ = "780";
	/** 781 - Rejeição: Emissor não habilitado para emissão de NFC-e = 781 */
	public static final String LBR_LOTSENDINGSTATUS_781_RejeiçãoEmissorNãoHabilitadoParaEmissãoDeNFC_E = "781";
	/** 782 - Rejeição: NFC-e não é autorizada pelo SCAN = 782 */
	public static final String LBR_LOTSENDINGSTATUS_782_RejeiçãoNFC_ENãoÉAutorizadaPeloSCAN = "782";
	/** 783 - Rejeição: NFC-e não é autorizada pelo SVC = 783 */
	public static final String LBR_LOTSENDINGSTATUS_783_RejeiçãoNFC_ENãoÉAutorizadaPeloSVC = "783";
	/** 784 - Rejeição: NF-e com indicativo de NFC-e com entrega a domicilio = 784 */
	public static final String LBR_LOTSENDINGSTATUS_784_RejeiçãoNF_EComIndicativoDeNFC_EComEntregaADomicilio = "784";
	/** 785 - Rejeição: NFC-e com entrega a domicilio não permitida pela UF = 785 */
	public static final String LBR_LOTSENDINGSTATUS_785_RejeiçãoNFC_EComEntregaADomicilioNãoPermitidaPelaUF = "785";
	/** 786 - Rejeição: NFC-e de entrega a domicilio sem dados dos transportador = 786 */
	public static final String LBR_LOTSENDINGSTATUS_786_RejeiçãoNFC_EDeEntregaADomicilioSemDadosDosTransportador = "786";
	/** 787 - Rejeição: NFC-e de entrega a domicilio sem a identificação do destinatário = 787 */
	public static final String LBR_LOTSENDINGSTATUS_787_RejeiçãoNFC_EDeEntregaADomicilioSemAIdentificaçãoDoDestinatário = "787";
	/** 788 - Rejeição: NFC-e de entrega a domicílio sem o endereço do destinatário = 788 */
	public static final String LBR_LOTSENDINGSTATUS_788_RejeiçãoNFC_EDeEntregaADomicílioSemOEndereçoDoDestinatário = "788";
	/** 789 - Rejeição: NFC-e para destinatário contribuinte de ICMS = 789 */
	public static final String LBR_LOTSENDINGSTATUS_789_RejeiçãoNFC_EParaDestinatárioContribuinteDeICMS = "789";
	/** 790 - Rejeição: Operação com exterior para destinatário contribuinte do ICMS = 790 */
	public static final String LBR_LOTSENDINGSTATUS_790_RejeiçãoOperaçãoComExteriorParaDestinatárioContribuinteDoICMS = "790";
	/** 791 - Rejeição: NF-e com indicação de destinatário isento de IE; com a informação da IE do destinatario = 791 */
	public static final String LBR_LOTSENDINGSTATUS_791_RejeiçãoNF_EComIndicaçãoDeDestinatárioIsentoDeIEComAInformaçãoDaIEDoDestinatario = "791";
	/** 792 - Rejeição: Informada a IE do destinatário para operação com destinatário do exterior = 792 */
	public static final String LBR_LOTSENDINGSTATUS_792_RejeiçãoInformadaAIEDoDestinatárioParaOperaçãoComDestinatárioDoExterior = "792";
	/** 793 - Rejeição: Informado capítulo do NCM inexistente = 793 */
	public static final String LBR_LOTSENDINGSTATUS_793_RejeiçãoInformadoCapítuloDoNCMInexistente = "793";
	/** 999 - Rejeição: Erro não catalogado = 999 */
	public static final String LBR_LOTSENDINGSTATUS_999_RejeiçãoErroNãoCatalogado = "999";
	/** Set NF-e Lot Sending Status.
		@param LBR_LotSendingStatus 
		Indicates the status of the sending process to Sefaz
	  */
	public void setLBR_LotSendingStatus (String LBR_LotSendingStatus)
	{

		set_Value (COLUMNNAME_LBR_LotSendingStatus, LBR_LotSendingStatus);
	}

	/** Get NF-e Lot Sending Status.
		@return Indicates the status of the sending process to Sefaz
	  */
	public String getLBR_LotSendingStatus () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotSendingStatus);
	}

	/** Set NF-e Lot Sent On.
		@param LBR_LotSentOn 
		The date+time (expressed in decimal format) when the NF-e Lot has been sent
	  */
	public void setLBR_LotSentOn (Timestamp LBR_LotSentOn)
	{
		set_Value (COLUMNNAME_LBR_LotSentOn, LBR_LotSentOn);
	}

	/** Get NF-e Lot Sent On.
		@return The date+time (expressed in decimal format) when the NF-e Lot has been sent
	  */
	public Timestamp getLBR_LotSentOn () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LBR_LotSentOn);
	}

	/** 01 - Nota Fiscal = 01 */
	public static final String LBR_NFBMODEL_01_NotaFiscal = "01";
	/** 55 - NF-e = 55 */
	public static final String LBR_NFBMODEL_55_NF_E = "55";
	/** Set NFB (DocType) Model.
		@param LBR_NFBModel NFB (DocType) Model	  */
	public void setLBR_NFBModel (String LBR_NFBModel)
	{

		set_Value (COLUMNNAME_LBR_NFBModel, LBR_NFBModel);
	}

	/** Get NFB (DocType) Model.
		@return NFB (DocType) Model	  */
	public String getLBR_NFBModel () 
	{
		return (String)get_Value(COLUMNNAME_LBR_NFBModel);
	}

	/** Production = 1 */
	public static final String LBR_NFEENV_Production = "1";
	/** Homologation = 2 */
	public static final String LBR_NFEENV_Homologation = "2";
	/** Set Sefaz NF-e Environment.
		@param LBR_NFeEnv Sefaz NF-e Environment	  */
	public void setLBR_NFeEnv (String LBR_NFeEnv)
	{

		set_Value (COLUMNNAME_LBR_NFeEnv, LBR_NFeEnv);
	}

	/** Get Sefaz NF-e Environment.
		@return Sefaz NF-e Environment	  */
	public String getLBR_NFeEnv () 
	{
		return (String)get_Value(COLUMNNAME_LBR_NFeEnv);
	}

	/** Set NF Serie.
		@param LBR_NFeSerie NF Serie	  */
	public void setLBR_NFeSerie (String LBR_NFeSerie)
	{
		set_Value (COLUMNNAME_LBR_NFeSerie, LBR_NFeSerie);
	}

	/** Get NF Serie.
		@return NF Serie	  */
	public String getLBR_NFeSerie () 
	{
		return (String)get_Value(COLUMNNAME_LBR_NFeSerie);
	}

	/** Set Unused NF-e Numbering.
		@param LBR_NotaFiscalInut_ID 
		Identifies a Unused NF-e Numbering
	  */
	public void setLBR_NotaFiscalInut_ID (int LBR_NotaFiscalInut_ID)
	{
		if (LBR_NotaFiscalInut_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscalInut_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscalInut_ID, Integer.valueOf(LBR_NotaFiscalInut_ID));
	}

	/** Get Unused NF-e Numbering.
		@return Identifies a Unused NF-e Numbering
	  */
	public int getLBR_NotaFiscalInut_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_NotaFiscalInut_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Unused NF-e Numbering.
		@param LBR_NotaFiscalInut_UU 
		Identifies a Unused NF-e Numbering
	  */
	public void setLBR_NotaFiscalInut_UU (String LBR_NotaFiscalInut_UU)
	{
		set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscalInut_UU, LBR_NotaFiscalInut_UU);
	}

	/** Get Unused NF-e Numbering.
		@return Identifies a Unused NF-e Numbering
	  */
	public String getLBR_NotaFiscalInut_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_NotaFiscalInut_UU);
	}

	/** Set Number (End).
		@param LBR_Number_End 
		Indicates the end number
	  */
	public void setLBR_Number_End (String LBR_Number_End)
	{
		set_Value (COLUMNNAME_LBR_Number_End, LBR_Number_End);
	}

	/** Get Number (End).
		@return Indicates the end number
	  */
	public String getLBR_Number_End () 
	{
		return (String)get_Value(COLUMNNAME_LBR_Number_End);
	}

	/** Set Number (Start).
		@param LBR_Number_Start 
		Indicates the start number
	  */
	public void setLBR_Number_Start (String LBR_Number_Start)
	{
		set_Value (COLUMNNAME_LBR_Number_Start, LBR_Number_Start);
	}

	/** Get Number (Start).
		@return Indicates the start number
	  */
	public String getLBR_Number_Start () 
	{
		return (String)get_Value(COLUMNNAME_LBR_Number_Start);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}