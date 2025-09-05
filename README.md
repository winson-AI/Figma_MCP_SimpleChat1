# SimpleChat1 - Customer Support Chat Interface

A Kotlin Multiplatform (KMP) application that implements a modern customer support chat interface using Compose Multiplatform. This project demonstrates Figma-to-Compose implementation with cross-platform compatibility.

## 🏗️ Project Structure

This is a Kotlin Multiplatform project targeting **Android**, **iOS**, and **Desktop**.

### 📁 Key Directories

* **[/composeApp](./composeApp/src)** - Shared Compose Multiplatform code
  - **[commonMain](./composeApp/src/commonMain/kotlin)** - Platform-agnostic code shared across all targets
  - **[androidMain](./composeApp/src/androidMain/kotlin)** - Android-specific implementations
  - **[iosMain](./composeApp/src/iosMain/kotlin)** - iOS-specific implementations
  - **[desktopMain](./composeApp/src/desktopMain/kotlin)** - Desktop-specific implementations

* **[/iosApp](./iosApp)** - iOS application entry point and SwiftUI components

## ✨ Features

- **Cross-Platform UI**: Unified interface across Android, iOS, and Desktop
- **Modern Chat Interface**: Clean, intuitive customer support chat design
- **Figma Integration**: Direct implementation from Figma design specifications
- **Responsive Layout**: Adaptive design for different screen sizes
- **Material Design 3**: Modern Android design system implementation

## 🎨 UI Components

- **Header Navigation**: Back arrow and status indicator
- **Chat Messages**: Support and customer message bubbles with distinct styling
- **User Avatars**: Profile images and icons for chat participants
- **Input Field**: Message composition area with send functionality
- **Responsive Design**: Optimized for mobile and desktop experiences

## 🛠️ Technologies Used

- **Kotlin Multiplatform** - Cross-platform development framework
- **Compose Multiplatform** - Declarative UI framework for Kotlin
- **Material Design 3** - Modern Android design system
- **Figma Integration** - Design-to-code implementation
- **Gradle** - Build automation and dependency management

## 🚀 Getting Started

### Prerequisites
- **JDK 11+** - Java Development Kit
- **Android Studio** (for Android development)
- **Xcode** (for iOS development, macOS only)
- **IntelliJ IDEA** (recommended for KMP development)

### Build and Run

#### Android Application
```bash
# Build debug APK
./gradlew :composeApp:assembleDebug

# Install and run on connected device
./gradlew :composeApp:installDebug
```

#### iOS Application
```bash
# Open in Xcode
open iosApp/iosApp.xcodeproj

# Or use command line
./gradlew :composeApp:buildIosApp
```

#### Desktop Application
```bash
# Run desktop version
./gradlew :composeApp:run
```

## 📱 Supported Platforms

- ✅ **Android** (API 24+)
- ✅ **iOS** (iOS 13.0+)
- ✅ **Desktop** (Windows, macOS, Linux)

## 🎯 Development Workflow

1. **Design in Figma** - Create UI designs with proper naming conventions
2. **Export Assets** - Use Figma MCP tools to export icons and images
3. **Implement UI** - Convert Figma designs to Compose components
4. **Test Across Platforms** - Ensure consistent behavior on all targets
5. **Build & Deploy** - Generate platform-specific binaries

## 📂 Key Files

- **[App.kt](./composeApp/src/commonMain/kotlin/com/example/simplechat1/App.kt)** - Main UI implementation
- **[Resources](./composeApp/src/commonMain/composeResources)** - Icons, images, and assets
- **[Build Config](./composeApp/build.gradle.kts)** - Project configuration and dependencies

## 🤝 Contributing

1. Follow the established code style and architecture patterns
2. Test changes across all supported platforms
3. Update documentation for any new features
4. Ensure UI consistency with Figma designs

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) and [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform).