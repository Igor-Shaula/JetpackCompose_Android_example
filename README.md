	**initial requirements**
The task was to develop a single-page app that provides the ability to search Outdoorsy listings by keyword.
Users has to be able to type keywords in a text field. Typing in the text field should cause search results to appear automatically.
The search results should display an image of the vehicle and the vehicle’s name. The keyboard should hide when the user starts to scroll.
	* reference design: https://github.com/outdoorsy/interview-challenge-android/blob/main/Challenge-Design.png
	* the API details: https://github.com/outdoorsy/interview-challenge-android/blob/main/API.md
 All these requirements are met, the code is able to build and you're very welcome to do it and check the app on your device.

	**technical solutions**
 - **Kotlin** as the only coding language.
 - **Coroutines & Flows** for all async work.
 - **Jetpack Compose** as implementation of all UI.
 - **Moder Android Architecture** approach as a sceleton for nanming/placing packages & classes.
 - **Retrofit 2** as a REST network client.
 - **Coil** for downloading images.

	**what's next (very soon)**
	- fix colors in SearchBar - probably by replacing it with other composables.
 	- adding error state for UI - for beautiful handling of any network cases.
   	- fake-data preparation tract with its own DataSource for consuming mock JSON.
   	- optimization of NetworkEntity processing (now there are three loops).
   	- adding option to remember search queries (at least for a session).
   	- would be nice to add pagination for network response.
	- **Hilt** as dependency injection mechanism.
 	- **unit tests** for ViewModel and other logic-related code.
	- **UI tests** just to have them :)
