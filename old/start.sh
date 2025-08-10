# build docker image for deployment
mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
# docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .

