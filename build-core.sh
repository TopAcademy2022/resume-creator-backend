#!/bin/bash

# Enable debugging
set -x

# Store the current directory
currentDir=$(pwd)

# Initialize and update git submodules
git submodule init
git submodule update

# Change to the resume-creator-logic directory and build the project
cd "lib/resume-creator-logic" || exit
./gradlew build

# Change back to the original directory
cd "$currentDir" || exit

# Copy the built jar file to the lib directory
cp lib/resume-creator-logic/app/build/libs/app.jar lib