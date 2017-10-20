Select Case When Prodtype Is Null Then 
Case When Exemplar = 447 Then Pricustmnm Else Nprcustmnm End
Else Case When Exemplar = 447 Then Pricustmnm Else Nprcustmnm End End As CUSTOMERID 
,Nprcustmnm, Pricustmnm,Master_Ref
From Master Where  
Master_Ref = '{referenceNumber}'