FROM mysql:5.7

MAINTAINER carlos(158199521@qq.com)

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./db/schema.sql /docker-entrypoint-initdb.d

COPY ./db/boot.sql /docker-entrypoint-initdb.d

COPY ./db/flowable-boot.sql /docker-entrypoint-initdb.d
