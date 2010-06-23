rem [SOYC START]

cd %~dp0

java -jar closure-templates-for-javascript-latest\SoyToJsSrcCompiler.jar ^
--outputPathFormat war\js\{INPUT_FILE_NAME_NO_EXT}.js ^
war\soy\template.soy

rem [SOYC COMPLETE]
