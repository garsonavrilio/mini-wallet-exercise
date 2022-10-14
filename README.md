# Mini Wallet Exercise
# Setup
First of all, you need to setup your local and do install this dependencies first:
1. Java 8
2. Gradle v7.5
3. Postgres
4. Clone this repo

# Run
After the installation, you need to run on your local:
1. Postgres Server with url `localhost` and port number `5433`
2. Run this command to build the project `gradle clean build`
3. After build is succeed, run the app by using this command `gradle bootRun`
4. The app should be started with url `localhost` and port number `8080`

#Example Request
1. You need to create the wallet first
`curl --location --request POST 'http://localhost:8080/api/v1/init' \
--form 'customer_xid="92ea76d2-4a4b-11ed-b878-0242ac120002"'`
2. After the creation of your wallet success you need to enable the wallet to use all the feature in this service
``
3. To view your wallet balance you can use this curl
`curl --location --request GET 'http://localhost:8080/api/v1/wallet' \
--header 'Authorization: Token dfdd2db54cc0ba4b6d1e7e164a6fd0d90d2e0bca73c9cacd7d7c16df8a254f02'`
4. For Deposit to your wallet with certain amount you can use this curl
`curl --location --request POST 'http://localhost:8080/api/v1/wallet/deposits' \
--header 'Authorization: Token dfdd2db54cc0ba4b6d1e7e164a6fd0d90d2e0bca73c9cacd7d7c16df8a254f02' \
--form 'amount="100"' \
--form 'reference_id="a8567184-4adb-11ed-b878-0242ac120002"'`
5. To Withdraw your amount you can use this curl
`curl --location --request POST 'http://localhost:8080/api/v1/wallet/withdrawals' \
--header 'Authorization: Token dfdd2db54cc0ba4b6d1e7e164a6fd0d90d2e0bca73c9cacd7d7c16df8a254f02' \
--form 'amount="50"' \
--form 'reference_id="a8567184-4adb-11ed-b878-0242ac120005"'`
6. This curl is to Disabled your wallet so the feature would be locked until you enabled it again
`curl --location --request PATCH 'http://localhost:8080/api/v1/wallet' \
--header 'Authorization: Token dfdd2db54cc0ba4b6d1e7e164a6fd0d90d2e0bca73c9cacd7d7c16df8a254f02' \
--form 'is_disabled="true"'`
