FROM java:8
COPY ./the-office-website-1.0-SNAPSHOT.jar ./homyit.jar
# 暴露端口
EXPOSE 8570

# 入口，java项目的启动命令
ENTRYPOINT java -jar /homyit.jar