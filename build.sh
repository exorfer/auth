echo Begin Build
mkdir out
kotlinc -d out/auth.jar -include-runtime src
echo End Build