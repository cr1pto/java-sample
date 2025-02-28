# syntax=docker/dockerfile:1
FROM alpine:3.16.0
RUN apk add --no-cache java-cacerts openjdk17-jdk

ENV JAVA_HOME=/opt/openjdk-17

ENV PATH=/opt/openjdk-17/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

ENV JAVA_VERSION=17-ea+14

RUN set -eux; \
    arch="$(apk --print-arch)"; \
    case "$arch" in         'x86_64')   \
    downloadUrl='https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_linux-x64_bin.tar.gz'; \
    downloadSha256='0022753d0cceecacdd3a795dd4cea2bd7ffdf9dc06e22ffd1be98411742fbb44';          ;;      *) echo >&2 "error: unsupported architecture: '$arch'"; exit 1 ;; \
    esac;       wget -O openjdk.tgz "$downloadUrl";     echo "$downloadSha256 *openjdk.tgz" | sha256sum -c -;       mkdir -p "$JAVA_HOME";  tar --extract       --file openjdk.tgz      --directory "$JAVA_HOME"        --strip-components 1        --no-same-owner     ;   rm openjdk.tgz*;        rm -rf "$JAVA_HOME/lib/security/cacerts";   ln -sT /etc/ssl/certs/java/cacerts "$JAVA_HOME/lib/security/cacerts"; \
    java -Xshare:dump;      fileEncoding="$(echo 'System.out.println(System.getProperty("file.encoding"))' | jshell -s -)"; [ "$fileEncoding" = 'UTF-8' ]; \
    rm -rf ~/.java; \
    javac --version; \
    java --version

CMD ["jshell"]

CMD [“java”, “-jar”, “/app/your-application.jar”]

