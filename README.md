# kernel-service-poc
This repository started as a proof-of-concept. It is expanding to serve as a template
project for MC Terra services.

In general, once you copy this project, you can search for the word "template" and
fill in your service or some other appropriate name.

## OpenAPI V3 - formerly swagger
The template provides a simple OpenAPI V3 yaml document that includes a /status
endpoint and a /api/template/v1/ping endpoint. The ping endpoint is there to
show the full plumbing for an endpoint that uses the common exception handler to 
return an ErrorReport.

The OpenAPI document also contains two components that we would like to have common
across all of our APIs:
<ul>
<li>ErrorReport - a common error return structure</li>
<li>SystemStatus - a common response to the /status endpoint</li>
</ul>

## Spring Boot
We use Spring Boot as our framework for REST servers. The objective is to use a minimal set
of Spring features; there are many ways to do the same thing and we would like to constrain ourselves
to a common set of techniques.

### Configuration
We only use Java configuration. We never use XML files.

In general, we use type-safe configuration parameters as shown here: 
[Type-safe Configuration Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-typesafe-configuration-properties).
That allows proper typing of parameters read from property files or environment variables. Parameters are
then accessed with normal accessor methods. You should never need to use an `@Value` annotation.

### Initialization
When the applications starts, Spring wires up the components based on the profiles in place.
Setting different profiles allows different components to be included. This technique is used
as the way to choose the cloud platform (Google, Azure, AWS) code to include.

We use the Spring idiom of the `postSetupInitialization`, found in ApplicationConfiguration.java,
to perform initialization of the application between the point of having the entire application initialized and
the point of opening the port to start accepting REST requests.

### Annotating Singletons
The typical pattern when using Spring is to make singleton classes for each service, controller, and DAO.
You do not have to write the class with its own singleton support. Instead, annotate the class with
the appropriate Spring annotation. Here are ones we use:


## Code Structure

Explain
app package
  configuration
  controllers
common package
service package


