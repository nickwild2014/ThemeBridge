SELECT CASE WHEN TRIM(PRICUSTMNM) is not null then TRIM(PRICUSTMNM) else trim(NPRCUSTMNM)
end AS customerid FROM MASTER WHERE MASTER_REF = '{referenceNumber}'