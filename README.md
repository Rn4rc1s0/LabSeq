# LabSeq Project Documentation

## labseq-service

The LabSeq Service is a RESTful backend application built with the Quarkus framework. It calculates and returns values from the labseq sequence through a REST API. Quarkus has been chosen for its efficient runtime characteristics in both JVM and native modes, making it ideal for microservices architecture and cloud deployments. This service leverages Quarkus features such as live coding, small memory footprint, and fast startup times.

### Features

- RESTful API endpoint to calculate labseq sequence values.
- Caching mechanism implemented for optimized performance.
- Swagger UI integration for API documentation and exploration.
- Support for both JVM and native compilation for optimal performance in different environments.

### Getting Started

#### Prerequisites

- Java JDK 11 or newer.
- Apache Maven 3.8.1 or newer.

#### Setup and Installation

1. Clone the repository

   ```shell script
   git clone https://github.com/Rn4rc1s0/LabSeq.git
   cd LabSeq
   ```

2. Build the project

   ```shell script
   mvn clean install
   ```
   This command compiles the project and runs the tests.

3. Run the application

   Quarkus supports live coding with hot reload. To start the application in development mode:

   ```shell script
   ./mvnw quarkus:dev
   ```

   Or you can also use:

   ```shell script
   ./mvnw compile quarkus:dev
   ```

### API Usage

- Retrieve a Sequence Value
    - Request: GET `http://localhost:8080/labseq/{n}` (when you use HTTP Request in an application like Postman or Insomnia)
    - Path Variable: `n` - The index of the sequence value to retrieve.
    - Run the labseq-gui project to use the GUI
    - Response: A plain text response containing the sequence value.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at `http://localhost:8080/q/dev/`.

### Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

### Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/labseq-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## labseq-gui

The LabSeq GUI is a simple web interface built with React to interact with the LabSeq Service. It allows users to input a number, fetches the corresponding sequence value from the backend service, and displays it.

### Setup and Running

1. Navigate to the frontend project directory.
2. Install dependencies:

   ```shell script
   npm install
   ```

   Or if you're using yarn:

   ```shell script
   yarn install
   ```

3. Start the application:

   ```shell script
   npm start
   ```

   Or:

   ```shell script
   yarn start
   ```

The React application will be available at `http://localhost:3000`.

### Using the Interface

Open your browser and go to `http://localhost:3000`. Enter a non-negative integer and click on "Fetch Sequence Value" to retrieve the corresponding value from the `labseq` sequence.

### Documentation Link

For detailed API documentation, including available endpoints and response formats, visit `http://localhost:8080/q/swagger-ui` (Inside the GUI there is a link to the documentation).

## Contributing

Instructions for contributing to the project, including code standards, pull request process, etc.

