@echo on

set currentDir="%CD%"
call git submodule init
call git submodule update

cd "lib/resume-creator-logic"
call gradlew build

cd %currentDir%
copy lib\resume-creator-logic\app\build\libs\app.jar lib

pause