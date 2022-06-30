
# GraphQL for Spring

Officially GraphQL is integrated with the latest release of spring boot 2.7.0. With this release, spring-boot-starter-graphql replaces the current GraphQL for java.

So we don't need to use the following dependencies

```
<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphql-java-tools</artifactId>
    <version>12.0.0</version>
</dependency>
<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>12.0.0</version>
</dependency>
```

Create a new project using Java 17+, Spring Boot 2.7+ and select the following dependencies:

Spring Web,
Spring GraphQL

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-graphql</artifactId>
</dependency>
```


Now our project is clean and updated with the new dependencies. According to the spring graphql documentation, the biggest changes come with the new annotated controllers. The default location for schema files are src/main/resources/graphql/**.

## GraphQL Annotations
With Graphql spring java the resolvers component is needed to implement GraphQLQueryResolver or GraphQLMutationResolver classes. But with the spring boot starter graphql, it’s moved to an annotation-based programming model. In short previous resolvers are replaced by annotations:

``` 
GraphQLMutationResolver -> @MutationMapping
GraphQLQueryResolver -> @QueryMapping
```
And the @Controller component uses the annotated handler methods to bind and resolve graphql schema fields/queries.

