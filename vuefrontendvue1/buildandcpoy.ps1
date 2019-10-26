npm run build


Remove-Item ..\clouddemo21\src\main\resources\static\* -recurse
Copy-Item .\dist\*  ..\clouddemo21\src\main\resources\static\ -recurse