set projectLocation=D:\Eclipse-Oxygen\AutomationDemo\testng.xml
cd %projectLocation%
mvn clean test -DsuiteXmlFile=testng.xml
pause