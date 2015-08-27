set WSDL=%1%

D:
cd D:\dev\workspace_TCC\SimuladorProcessoProducao\

D:\dev\ws\jaxws-ri\bin\wsimport -s src -d bin %WSDL%

pause