mac docker microservice

啟動docker後
在專案根目錄 且有docker-compose.yml

啟動: `docker compose up -d`  
(-d 分離模式（detached mode） 讓你可以繼續使用終端而不需要等待容器運行完成)  
關閉: `docker compose down `  

## 微服務啟動順序

1. 數據庫和外部服務
    * `docker compose up -d`
4. 服務發現和配置服務

    * config-service
    * discovery-service
4. 核心和基礎服務
    * 身份驗證和授權服務：如 OAuth2 服務器、JWT 提供者。
    * 用戶管理服務：如用戶信息服務、權限管理服務。
6. 業務邏輯和應用服務
    * customer-service
    * product-service
    * order-service
    * payment-service
    * notification-service

6. 邊界服務和 API Gateway
   全部起完後再開啟GateWay
   Spring Cloud Gateway 通常依賴於服務發現系統（如 Eureka）來找到後端服    務。這些服務必須先註冊到 Eureka，這樣 Gateway 才能在啟動時正確地發現和    註冊這些服務。

8. 監控、日誌和輔助服務






## 應用程式進入點

> 都為docker 設定對外暴露port

* postgresql - pgAdmin 進入點 5050為docker自定義對外port  
  http://localhost:5050/browser/

* Mongo Express
  http://localhost:8081  
  預設 username: admin  
  預設 passwoed: pass  

查看log :`docker logs mongo_express `

* Eureka
  http://localhost:8761/

* zipkin
  http://localhost:9411/zipkin/

* mailDev
  http://localhost:1080/#

* keycloak admin:admin
  http://localhost:9098/

---

## 設定

### config

* 父
  config server 需掛 **config server** 依賴  
  且須加上@EnableConfigServer

* 子
  而依賴config server 的需掛 **config client**  
  讀取設定需設定以下 指定到config server 專案讀檔
```
spring:
  config:
    import: optional:configserver:http://localhost:8888
```

### Eureka
* 父
  需掛Eureka Server 依賴  
  且加上 @EnableEurekaServer

* 子
  需掛上 Eureka Discovery Clent

### keycloak
安全驗證設定在網關層


### openfeign
微服務內打
入口點需加上`@EnableFeignClients`















