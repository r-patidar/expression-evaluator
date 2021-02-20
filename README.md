# expression-evaluator

Requirements:
1. Java 1.8

Setup:

Clone this repository to your machine.

Open 'expression-evaluator' folder and open Terminal/Command Prompt on current location.

For Windows run `mvnw.cmd spring-boot:run`

For Linux/OSX run `mvnw spring-boot:run`

Wait for the service to start you will see following line in logs

> ​	 *Started ExpressionEvaluatorApplication*



and then open this [link](http://localhost:8080/swagger-ui/) in your browser.



Using the APIs:

Click on "Expression Controller", this will open 2 API endpoints

1. **/api/v1/user/evaluate**: This API accepts an user id and a mathematical expression as parameter and returns result of the expression.
2. **/api/v1/user/get/operator/mostused**: This API takes an user id as parameter and returns the most used operator by user and its count. if the max count is same for multiple operators only one of those is returned.

To try any of the API click on their name and than click on "Try it out" button on the right hand side, fill the required information and press "execute" button. the API response will reflect in the "Responses" section.
