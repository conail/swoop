# Swoop API

A RESTful web service written in Groovy.  Uses:

- Sprint Boot
- Gradlew
- Docker

## Time API

WaitTime API isn't available publicly anymore.  An alternative was found at [timezonedb](http://timezonedb.com).  It requires registration and returns XML.

Groovy's XMLSlurper is used to extract the time and timezone.

## Docker

A gradle plugin and task is used to generate docker images.  A Dockerfile isn't required, allowing build and deployment via a single command.

To build a container, use:

```
./gradlew buildDocker
```

To push a container to Docker Hub (assumes docker toolchain is installed), use:

```
./gradlew buildDocker -Ppush
```

Plugin: [gradle-docker](https://github.com/Transmode/gradle-docker).

## Service Design

Classes were not extracted into their own files, owing to their brevity.

Credentials were not extracted, but [Vault](https://www.vaultproject.io/) might be useful.

## Caching

Caching could be performed by storing the results of calculations or API responses.  

This isn't necessary/practical because of the trivial calculations performed by the Math endpoint.  A cache lookup would be more complex in terms of instructions than the actual operation.  

Cache invalidation is expected on every call to the Time endpoint because of it's temporal nature, although entirely predicable.  

## Running Locally

### Gradlew

```
./gradlew bootRun
```

### Docker 

```
./gradlew buildDocker
docker run conail/swoop -p 8080:8080
```

