ALTER TABLE CONTACT_CUSTOMER DROP CONSTRAINT CNTCTCSTOMERcstmrd;
ALTER TABLE CUSTOMER_CONTACT_CUSTOMER DROP CONSTRAINT CSTMRCNCstmrcstmrd;
ALTER TABLE CUSTOMER_CONTACT_CUSTOMER DROP CONSTRAINT cstmrCntctCstmrcnt;
DROP TABLE CONTACT_CUSTOMER;
DROP TABLE CUSTOMER;
DROP TABLE CUSTOMER_CONTACT_CUSTOMER;
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN';
