# Universities Assessment

Welcome to the Technical Assessment Project! This project aims to demonstrate proficiency in various architectural patterns and popular Android libraries. Below, you'll find details about the architecture, libraries used, and how to set up the project.

## Project Overview

This project implements the MVVM (Model-View-ViewModel) architecture pattern along with Modular Clean Architecture principles. It integrates Dagger 2 for dependency injection, Retrofit for networking, Jetpack Room for local database operations, and Jetpack Navigation for seamless navigation within the app.

## Screens


<table align="center">
  <tr>
    <th>Universities List</th>
    <th>University Details</th>
  </tr>
  <tr>
    <td align="center"><img src="https://github.com/IamMaher/Assignment_Universities/assets/15931456/c83487f4-9b2e-4e31-967c-4f2819707c0b" width="200" alt="Universities List"></td>
    <td align="center"><img src="https://github.com/IamMaher/Assignment_Universities/assets/15931456/f16cbe26-87ad-4421-a927-b8eb5d4e33d4" width="200" alt="University Details"></td>
  </tr>
</table>

## Architecture Diagrams

### MVVM Architecture

![MVVM Diagram](https://github.com/IamMaher/Assignment_Universities/assets/15931456/10ed1b70-b53d-4f5f-b5d0-295ad918eca8)

The MVVM architecture separates the UI from the business logic by introducing a ViewModel layer. This allows for better testability and maintainability of the codebase.

### Modular Seperation 

![Modular Diagram](https://github.com/IamMaher/Assignment_Universities/assets/15931456/6932c2c6-dbad-4eb7-9e0c-309aed8b137a)

This project demonstrates a scalable Android modular architecture with three key modules:

*   **Core Module:** Provides essential dependencies, utilities, and base classes.
*   **Universities List Feature Module:** Displays a list of universities.
*   **University Details Feature Module:** Presents detailed information about a single university.


### Clean Architecture

![Modular Clean Architecture Diagram](https://github.com/IamMaher/Assignment_Universities/assets/15931456/2751283f-2393-4ff5-94de-1f3931bc7518")

The Modular Clean Architecture divides the app into layers of responsibility, each with its own clear role. This enhances scalability and flexibility while ensuring separation of concerns.

### DDD (Domain-Driven Design)
![Modular Clean Architecture Diagram](https://github.com/IamMaher/Assignment_Universities/assets/15931456/c90432b5-f31b-4fe9-ab61-1768ceffb057)

Apply DDD concepts to model your app's domain and business logic in a way that aligns with the problem space.


## Libraries Used

- Dagger 2: For dependency injection, providing a modular and scalable approach to managing dependencies.
- Retrofit: For making network requests and handling API communication efficiently.
- Coroutine: Leverage Kotlin Coroutines for asynchronous programming, ensuring smooth and efficient handling of background tasks.
- Kotlin: Develop the app using Kotlin, taking advantage of its concise syntax and modern language features.
- Jetpack Room: For local database operations, enabling seamless data persistence on the device.
- Jetpack Navigation: For managing navigation within the app, simplifying the navigation flow and ensuring a consistent user experience.

