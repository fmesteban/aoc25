# AOE25 - Kotlin Multi-Application Project

This is a Kotlin project set up to support multiple independent terminal applications.

## Project Structure

```
aoe25/
├── src/
│   ├── main/
│   │   └── kotlin/
│   │       ├── app1/
│   │       │   └── Main.kt
│   │       ├── app2/
│   │       │   └── Main.kt
│   │       └── ... (add more apps as needed)
│   └── test/
│       └── kotlin/
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew
```

## Running Applications

Each application has its own main function and can be run independently:

### Run Application 1
```bash
./gradlew runApp1
```

### Run Application 2
```bash
./gradlew runApp2
```

## Adding New Applications

1. Create a new package under `src/main/kotlin/` (e.g., `app3`)
2. Add a `Main.kt` file with a `main()` function
3. Register a new run task in `build.gradle.kts`:

```kotlin
tasks.register<JavaExec>("runApp3") {
    group = "application"
    description = "Run Application 3"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("app3.MainKt")
}
```

## Building the Project

```bash
./gradlew build
```

## Running Tests

```bash
./gradlew test
```

## Requirements

- JDK 17 or higher
- Gradle (included via wrapper)

