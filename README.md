# spring-boot-rest-si

Spring Boot with Integration sample 
=========================================

To Use 
=========================================

To use this project , do these 3 steps

1. Make sure the POJO structure aligns with the REST API . Example shown is using REST API serving as service provider backed by Spring Integration for EIP
2. http://<ip>:8080/getCustomer -> fetches customer details then calls an externalUrl to get the address and send response back after transformation. 
   The externalUrl here in this case was a POST Rest Service which I hosted in my local node server serving static json response for testing purpose
3. Build the Project using the following command


    $ mvn clean install
    
    

Execute
=========================================    
run App or as String boot project

    $ mvn spring-boot:run




