Remove-Item .\src\main\resources\static\* -recurse
Copy-Item ..\frontendvue1\dist\*  .\src\main\resources\static\ -recurse

mvn clean install
ibmcloud cf push backendspringboot1 -p .\target\demo2-0.0.1-SNAPSHOT.jar