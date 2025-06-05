# Media Player App

Company: CODTECH IT SOLUTION

Name: Vaghela Jeet Vijaybhai

Intern Id: CT04DM877

Domain: Android Development

Duration: 4 Weeks 

Mentor: Neela Santhosh Kumar

# Description

The Media Player App is a simple, visually pleasing Android app built with Java in Android Studio. 

The app is optimized to play local audio files at top speed while providing an effortless and nice-looking user interface. 

It comes equipped with a custom UI that has playback options like Play, Pause, Rewind, Fast Forward, and Skip — all of which have been done using symbol-based icons for a contemporary and minimalist look. 

The design is centered around responsiveness and clarity, and the app is perfect for music listening with direct controls and real-time monitoring of audio playback. 

The app employs Android's native MediaPlayer class for audio playback and illustrates how to deal with media in a resource-friendly and responsive way.

The application has a collection of three pre-loaded audio files placed in the res/raw folder and enables users to switch between them smoothly employing the skip button. One of the core aspects of the application is real-time updating the seek bar, synchronizing with the position of the audio currently playing and enabling users to scrub through the track manually. 

Two TextView views show the current playing time and the full duration, nicely formatted in mm:ss format. Real-time UI update is managed by a Handler and Runnable that update the playback position at every half-second interval for a smooth experience.

Every control button does its job well: the fast-forward and rewind buttons move the playback position 5 seconds forward or backward, respectively. 

The skip button permits jumping to the next song in the list, cycling back around to the first track when at the end. 

The application halts and releases the current MediaPlayer instance before creating a new one to maintain stability and effective resource usage when changing tracks. 

Playback state is handled cautiously as follows — when a song ends, the app restores playback UI to its original state to avoid confusion or unwanted behavior.

The layout of the app is constructed with a vertical LinearLayout to keep the music image, seek bar, duration labels, and control buttons in the middle. 

The UI is responsive and minimalistic, perfect for starters and developers who want to grasp Android media handling without using third-party libraries. 

The MediaPlayer lifecycle is handled correctly to prevent memory leak or crash, so the app remains stable on various configurations of devices.

This project is an ideal place to start for those who are interested in developing custom music or audio applications. 

It's ideal for students, hobbyists, and developers looking to venture into multimedia app development with native Android tools. Background playback support, notification controlling, file picking from device storage, or inclusion of visualizations such as waveforms or equalizers could be future additions.

The Media Player App illustrates fundamental principles in multimedia programming, UI updating in real time, and interaction design on Android. 

The source code is clean and commented for readability and modification. This open-source project can be used and modified freely, providing a strong foundation for your next Android audio application. Fork, clone, or contribute to the repository at will — whether you'd like to add features to the player, investigate more advanced features, or just learn Android fundamentals.


# OutPut

![Image](https://github.com/user-attachments/assets/7d021eaf-ee74-4756-af2f-73d19d9240d1)
