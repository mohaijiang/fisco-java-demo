## fisco java springboot 集成demo

springboot 集成fisco案例

需要引入fisco sdk
```
    <dependency>
        <groupId>org.fisco-bcos</groupId>
        <artifactId>web3sdk</artifactId>
        <version>2.3.0</version>
    </dependency>
```



### 配置

#### 节点证书

将节点证书复制到`src/main/resources`目录下。

需要复制的证书有:

* ca.crt
* node.crt
* node.key


#### 修改application.yml 节点连接端口

```
group-channel-connections-config:
  caCert: classpath:ca.crt
  sslCert: classpath:node.crt
  sslKey: classpath:node.key
  all-channel-connections:
    - group-id: 1 #group ID
      connections-str:
        - 127.0.0.1:20200 # 修改为需要连接的ip地址和端口
```

####　运行单元测试

运行 `mvn test` 以验证连接配置无误

#### 私钥证书配置

使用个人的私钥，需要将私钥文件复制到`src/main/resources`目录下，并修改application.yml

yml配置如下
```
accounts:
  pem-file: 0xcdcce60801c0a2e6bb534322c32ae528b9dec8d2.pem  ## 修改为拥有的私钥文件
```

