cd %~dp0

java -jar closure-templates-for-javascript-latest\SoyToJsSrcCompiler.jar ^
--outputPathFormat war\js\{INPUT_FILE_NAME_NO_EXT}.js ^
soy\template.soy
java -jar closure-templates-for-javascript-latest\SoyToJsSrcCompiler.jar ^
--outputPathFormat war\mjs\{INPUT_FILE_NAME_NO_EXT}.js ^
soy\template.soy

pause
