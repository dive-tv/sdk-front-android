#!/bin/bash

if [ "$TRAVIS_REPO_SLUG" == "touchvie/sdk-front-android" ] && [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo -e "Publishing javadoc...\n"

  # variables
  GRADLE_PATH=./app/build.gradle
  GRADLE_FIELD='versionName ".*"'

  # logic
  VERSION_TMP=$(grep "$GRADLE_FIELD" $GRADLE_PATH | awk '{print $2}')
  VERSION=$(echo $VERSION_TMP | sed -e 's/^"//'  -e 's/"$//')

  # result
  echo "GRADLE_PATH: " $GRADLE_PATH
  echo "GRADLE_FIELD: " $GRADLE_FIELD
  echo "VERSION_TMP: " $VERSION_TMP
  echo "VERSION: " $VERSION

  location="docs/"
  location+=$VERSION
  echo "LOCATION: " $location

  cp -R $location $HOME/javadoc-latest

  # Get to the Travis build directory, configure git and clone the repo
  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"

  echo -e "\nCloning gh-pages..."
  git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/touchvie/sdk-front-android gh-pages > /dev/null

  # Commit and Push the Changes
  echo -e "\nReplacing with updated javadoc..."
  cd gh-pages

  if [ -d $location ]; then
    #do nothing
    echo "Version name already exists"
  else
    #create doc and update the index
    echo "Version name does not exist"

    mkdir -p $location
    echo "Folder created: " $location

    cd docs

    #create listing index
    ls | sort -nr | egrep -v ".html" | perl -e 'print "<html><body><h1>Version Docs Listing</h1><ul><li><a href=\"'$VERSION'\">Latest ('$VERSION')</a></li><hr>"; while(<>) { chop $_; print "<li><a href=\"./$_\">$_</a></li>";} print "</ul></body></html>"' > index.html

    cp -Rf $HOME/javadoc-latest/. $VERSION
    git add -f .
    git commit -m "Lastest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
    commit_message="Release $RELEASE_VERSION javadoc pushed to gh-pages."

    # Set tag
    git tag -a $VERSION -m "Version "$VERSION

    echo -e "\nPushing..."
    git push -fq origin gh-pages --tags > /dev/null

    echo -e "Published Javadoc to gh-pages.\n"
  fi

else
  echo -e "Not publishing javadoc.\n"
fi