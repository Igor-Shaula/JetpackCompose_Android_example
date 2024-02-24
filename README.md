# Android client sample to work with an Outdoorsy API

(exactly this one: GET https://search.outdoorsy.com/rentals with some queries)

## The Task...

### Initial requirements:

+ Develop a single-page app that provides the ability to search Outdoorsy listings
  (very simple data about Recreational Vehicles available in region of your IP) - by a search query.
+ Users has to be able to type keywords in a text field.
+ Typing in the text field should cause search results to appear automatically.
+ The search results should display an image of the vehicle and the vehicle’s name.
+ The keyboard should hide when the user starts to scroll.

### Some useful links:

[How the app should look (only one screen)](https://github.com/outdoorsy/interview-challenge-android/blob/main/Challenge-Design.png)

[Endpoint documentation (only few words)](https://github.com/outdoorsy/interview-challenge-android/blob/main/API.md)

[Request sample for Postman (only one JSON)](https://github.com/outdoorsy/interview-challenge-android/blob/main/Outdoorsy-Challenge.postman_collection.json)

[The most recent original readme](https://github.com/outdoorsy/interview-challenge-android/blob/main/README.md)

## The Solution!

All given requirements were met. And much more - according to the ___list of additions___.
The project is intended to be developed further, so it will stay alive.
The code is able to be built. You're very welcome to do it and check the app on your device.
If you like the solution - please give this repository a star on GitHub.

### Technical solutions used:

- **Kotlin** - as the only coding language.
- **Coroutines & Flows** - for all async work.
- **Jetpack Compose** - as implementation of all UI.
- **Modern Android Architecture** - as a skeleton for naming/placing packages & classes.
- **Retrofit 2** - as a REST network client.
- **Coil** - for downloading images.

### What's next (list of additions):

- [x] fix colors in SearchBar - probably by replacing it with other composables.
- [x] use Kotlin's Result wrapper for delivering network outcome.
- [x] adding error state for UI - for beautiful handling of any network cases.
- [x] fake-data preparation tract with its own DataSource for consuming mock JSON.
- [ ] eliminate hardcoded values from composables by making order with sizes and colors.
- [ ] optimize NetworkEntity processing with flows (now there are three loops).
- [ ] add **Hilt** as dependency injection mechanism.
- [ ] would be nice to add pagination for network response.
- [ ] add mechanism for checking Network status to have realtime info about offline.
- [ ] add **unit tests** for ViewModel and other logic-related code.
- [ ] add **UI tests** with Espresso.
- [ ] add option to remember search queries (at least for a session).
- [ ] add **Room** as mechanism for storing search queries.