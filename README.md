# FetchListApp – Fetch Rewards Android Assessment (Java)

A native Android app built in Java to fetch, filter, group, and sort data from a public API and display it in an organized, user-friendly format.

## 📱 Features

- ✅ Fetches data from `https://hiring.fetch.com/hiring.json`
- ✅ Filters out items with blank or null `name`
- ✅ Groups items by `listId`
- ✅ Sorts each group alphabetically by `name`
- ✅ Displays headers for each `listId` section
- ✅ Modern, responsive UI with custom styling and icons
- ✅ MVVM Architecture + Retrofit2

## 🚀 Tech Stack

- **Java** (Android SDK)
- **Retrofit2** – for networking
- **MVVM Pattern** – for clean separation of concerns
- **RecyclerView** – to display sorted grouped data
- **ViewModel + LiveData** – to handle reactive updates
- **ConstraintLayout + Material UI** – for design and layout

## 📸 Screenshots

| Grouped List by `listId` | Beautiful UI with icons |
|--------------------------|-------------------------|
| ![Grouped List](screenshots/screenshot1.png) | ![Styled UI](screenshots/screenshot2.png) |

## 🛠️ Architecture
app/
├── model/ # Data classes
├── api/ # Retrofit interface & client
├── repository/ # Data access abstraction
├── viewmodel/ # ViewModel for business logic
├── adapter/ # RecyclerView Adapter
├── MainActivity.java # Main UI logic


## 📦 Setup Instructions

1. Clone the repo:
   ```bash
   git clone https://github.com/pradnya-16/fetchAppList.git
   cd fetchAppList
2. Open in Android Studio
3. Build and run the project on an emulator or real device (API 21+)
