## Consumer Driven Contract Testing Demo Project

This repository has a provider service (billing-service) and a consumer service (user-privilege-service).

These have been created to show a demo of consumer driven contract testing using [Pact](https://docs.pact.io/).

### Prerequisites:
- Install MySQL v8.0.16 and start it

### To see the responses:
#### Provider Service:
- Go to the billing-service folder:
`cd <path>/consumer-driven-contract-testing/billing-service`
- Start the server: `./gradlew clean bootRun`. The server will be started on port `9000`.
- You can hit the endpoint to see the JSON response: `http://localhost:9000/billing-info?userId=user1`
#### Consumer Service:
- Go to the user-privilege-service folder:
`cd <path>/consumer-driven-contract-testing/user-privilege-service`
- Start the server: `./gradlew clean bootRun`. The server will be started on port `8080`.
- You can hit the endpoint to see the JSON response: `http://localhost:8080/user-privilege?userId=user1`

### To Run Pact Tests (Ensure that the servers are stopped):
### Consumer side:
- Go to the user-privilege-service folder:
`cd <path>/consumer-driven-contract-testing/user-privilege-service`
- Run `sh './gradlew clean test --tests "*user_privilege_engine.pact*"'`
### Provider side:
If you do not want to use pact broker:
Go to a commit: `git checkout 275ae74157409f7938cfc3b8abe46ebe49d1f947`

Copy pacts folder from `<path>/user-privilege-service/build/` to `<path>/billing-service/`

- Go to the billing-service folder:
`cd <path>/consumer-driven-contract-testing/billing-service`

- Run `sh './gradlew clean test`