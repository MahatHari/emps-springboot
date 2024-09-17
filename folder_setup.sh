#!/bin/bash

#set the base package name
BASE_PACKAGE="src/main/java/com/hari/ems"

#create main project structure
mkdir -p $BASE_PACKAGE/{api/v1/{controller,request},core/{domain/{entity,dto},service,repository},infrastructure/{config,security,persistence},application/{exception,mapper},util}

#create Docker-related folders
mkdir -p docker/{app,postgres}

echo "EMS project structure created successfully!"