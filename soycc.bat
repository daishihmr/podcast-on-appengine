@echo off
cd %~dp0
java -jar soycc.jar war\soy\template.soy soyc.bat
