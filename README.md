# Swoop API

A RESTful web service written in Groovy.  Uses:

- Sprint Boot
- Gradlew
- Docker

## Time API

WaitTime API isn't available publicly anymore.  An alternative was found at [timezonedb](http://timezonedb.com).  It requires registration and returns XML.

Groovy's XMLSlurper is used to extract the time and timezone.

## Docker

A gradle plugin and task is used to generate docker images.  A Dockerfile isn't required.

To build a container, use:

```
./gradlew buildDocker
```

To push a container to Docker Hub (assumes docker toolchain is installed), use:

```
./gradlew buildDocker -Ppush
```
