-- Sped EFD
DROP VIEW IF EXISTS LBR_FactFiscal;
DROP VIEW IF EXISTS LBR_FactFiscal_NotaFiscalTax;
DROP VIEW IF EXISTS LBR_FactFiscal_NFLineTax;
DROP VIEW IF EXISTS LBR_FactFiscal_InvoiceTax;
DROP VIEW IF EXISTS LBR_FactFiscal_InvoiceLineTax;

SELECT lbr_register_migration_script('201603311324-Sped-000-removeviews.sql') FROM dual;
