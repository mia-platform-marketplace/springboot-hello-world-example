# Springboot Hello World Example walkthrough

[![Build Status][github-actions-svg]][github-actions]

This walkthrough will explain you how to correctly create a microservice in Springboot that returns an hello message from the DevOps Console.

## Current Version

This example is currently based on Java SE 11 (LTS)

## Create a microservice

In order to do so, access to [Mia-Platform DevOps Console](https://console.cloud.mia-platform.eu/login), create a new project and go to the **Design** area.  
From the Design area of your project select _Microservices_ and then create a new one, you have now reached [Mia-Platform Marketplace](https://docs.mia-platform.eu/docs/marketplace/overview_marketplace)!  
In the marketplace you will see a set of Examples and Templates that can be used to set-up microservices with a predefined and tested function.  

For this walkthrough select the following example: **Java Hello World**.
Give your microservice the name you prefer, in this walkthrough we'll refer to it with the following name: **spring-hello**. Then, fill the other required fields and confirm that you want to create a microservice.  
A more detailed description on how to create a Microservice can be found in [Microservice from template - Get started](https://docs.mia-platform.eu/docs/development_suite/api-console/api-design/custom_microservice_get_started#1-microservice-creation) section of Mia-Platform documentation.

> :warning:
> Please once the service is installed in your project verify **Probes** confiugration, boot time of Springboot applications may be long
> so you might want to propertly tune readiness and liveness probes.

The created service will have automatically the following environment variables to work:

- LOG_LEVEL: `{{LOG_LEVEL}}`
- MICROSERVICE_GATEWAY_SERVICE_NAME: `microservice-gateway`
- TRUSTED_PROXIES: `10.0.0.0/8,172.16.0.0/12,192.168.0.0/16`
- HTTP_PORT: `3000`
- USERID_HEADER_KEY: `miauserid`
- GROUPS_HEADER_KEY: `miausergroups`
- CLIENTTYPE_HEADER_KEY: `client-type`


## Expose an endpoint to your microservice

In order to access to your new microservice it is necessary to create an endpoint that targets it.  
In particular, in this walkthrough you will create an endpoint to your microservice *spring-hello*. To do so, from the Design area of your project select _Endpoints_ and then create a new endpoint.
Now you need to choose a path for your endpoint and to connect this endpoint to your microservice. Give to your endpoint the following path: **/greetings**. Then, specify that you want to connect your endpoint to a microservice and, finally, select *spring-hello*.  
Step 2 of [Microservice from template - Get started](https://docs.mia-platform.eu/docs/development_suite/api-console/api-design/custom_microservice_get_started#2-creating-the-endpoint) section of Mia-Platform documentation will explain in detail how to create an endpoint from the DevOps Console.

## Save your changes

After having created an endpoint to your microservice you should save the changes that you have done to your project in the DevOps console.  
Remember to choose a meaningful title for your commit (e.g "created service spring_hello"). After some seconds you will be prompted with a popup message which confirms that you have successfully saved all your changes.  
Step 3 of [Microservice from template - Get started](https://docs.mia-platform.eu/docs/development_suite/api-console/api-design/custom_microservice_get_started#3-save-the-project) section of Mia-Platform documentation will explain how to correctly save the changes you have made on your project in the DevOps console.

## Deploy

Once all the changes that you have made are saved, you should deploy your project through the DevOps Console. Go to the **Deploy** area of the DevOps Console.  
Once here select the environment and the branch you have worked on and confirm your choices clicking on the *deploy* button. When the deploy process is finished you will receveive a pop-up message that will inform you.  
Step 4 of [Microservice from template - Get started](https://docs.mia-platform.eu/docs/development_suite/api-console/api-design/custom_microservice_get_started#4-deploy-the-project-through-the-api-console) section of Mia-Platform documentation will explain in detail how to correctly deploy your project.

## Try it

Now, if you launch the following command on your terminal (remember to replace `<YOUR_PROJECT_HOST>` with the real host of your project):

```shell
curl <YOUR_PROJECT_HOST>/greetings/hello
```

you should see the following message:

```json
{"message":"Hello World!"}
```

Congratulations! You have successfully learnt how to use our Springboot _Hello World_ Example on the DevOps Console!

[github-actions]: https://github.com/mia-platform-marketplace/springboot-hello-world-example/actions
[github-actions-svg]: https://github.com/mia-platform-marketplace/springboot-hello-world-example/workflows/Java%20CI%20with%20Maven/badge.svg
