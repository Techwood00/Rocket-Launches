# KMP Rocket Launches App 🚀
Welcome to the KMP Rocket Launches App, a Kotlin Multiplatform (KMP) project that showcases rocket launches using an open-source API. This app demonstrates my skills in Kotlin Multiplatform development, utilizing Kotlin for both the web and mobile platforms.

![Screenshot_from_2023-10-27_06-28-40_50](https://github.com/Techwood00/Rocket-Launches/assets/149005562/92845de8-ae13-4dc7-98b6-9aff785379a0)  ![Screenshot_from_2023-10-27_06-26-42_60](https://github.com/Techwood00/Rocket-Launches/assets/149005562/7dc1c99a-db41-4a44-9007-bf8292fab8e8)


## Features
- **Kotlin Multiplatform (KMP):** This app is built using Kotlin Multiplatform, allowing seamless development for both web and mobile platforms.
- **Open Source API:** Utilizes an open-source API to fetch data about rocket launches.
- **MVVM Architecture:** Follows the Model-View-ViewModel architecture pattern for a clean and organized codebase.
- **GraphQL Integration:** Uses GraphQL for API communication and model generation, ensuring efficient data handling.
- **Compose UI:** Android views utilize Jetpack Compose for building native UI components, while the web views utilize Compose Multiplatform for consistent and beautiful UI across platforms.
## How to Run
### Web View
To run the web view, use the following command:
```shell
./gradlew jsRun
```
This command will launch the web view of the app, allowing you to explore rocket launches in your web browser.
## Project Structure
- **Common Module:** Contains shared logic and data models for both web and Android platforms.
- **Web Module:** Implements the web view of the app using Compose Multiplatform.
- **Android Module:** Implements the Android view of the app using Jetpack Compose.
## API Response Handling
The `LaunchListQuery` data class is used to deserialize the API response. It includes the necessary data fields such as launch ID, launch site, and mission details.
```kotlin
data class LaunchListQuery(
  val cursor: Optional<String?> = Optional.Absent,
  // ... other fields ...
)
```
## Version Management
Library versions are managed using a `.toml` file, ensuring consistency and easy dependency management across modules.

Build Configuration
Each module has its own `build.gradle.kts` file, allowing specific configurations for individual platforms.
