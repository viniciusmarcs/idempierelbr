-- Dec 26, 2013 11:26:41 AM BRST
-- Desativa idioma Espanhol(Colômbia) e ativa Português(Brasil)
UPDATE AD_Language SET IsSystemLanguage='N',Updated=TO_TIMESTAMP('2013-12-26 11:26:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Language_ID=136
;

-- Dec 26, 2013 11:54:53 AM BRST
UPDATE AD_Language SET IsLoginLocale='N',Updated=TO_TIMESTAMP('2013-12-26 11:54:53','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Language_ID=136
;

-- Dec 26, 2013 11:28:27 AM BRST
UPDATE AD_Language SET IsSystemLanguage='Y', IsLoginLocale='Y',Updated=TO_TIMESTAMP('2013-12-26 11:28:27','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Language_ID=174
;

SELECT lbr_register_migration_script('201312261125.sql') FROM dual
;
