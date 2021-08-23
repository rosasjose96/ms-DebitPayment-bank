FROM openjdk:8
VOLUME /temp
EXPOSE 8090
ADD ./target/ms-DebitPayment-bank-0.0.1-SNAPSHOT.jar debitpayment-service.jar
ENTRYPOINT ["java","-jar","/debitpayment-service.jar"]