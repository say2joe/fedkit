FED Kit
=======

The FED Kit repo will serve as a library and jumpstart for front-end development (FED).

The projects / files found in this repo should be "best-of-breed", so please  
make sure to note any additions to the repo which have not been fully vetted. 

<br/>

## Must-Haves for Web Development ##
- [Xcode /w Command Line Tools](http://developer.apple.com/xcode/) (Mac)
- [Adobe Edge Inspect](http://html.adobe.com/edge/inspect/) (All)
- [Google Chrome](http://www.google.com/intl/en/chrome/browser/) (All)

## FED-Focused IDEs (free) ##
- [Sublime Text 2/3](http://www.sublimetext.com/)
- [Eclipse (/w JS)](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplerr)
- [Brackets (beta)](https://github.com/adobe/brackets)

## Local Web Servers ##
- [XAMPP (Mac OS X)](http://www.apachefriends.org/en/xampp-macosx.html)
- [XAMPP (Windows)](http://www.apachefriends.org/en/xampp-windows.html)

<br/>
## Web App Scaffolding (Yeoman) ##

#### Install [nodejs/npm](https://github.com/joyent/node/wiki/Installing-Node.js-via-package-manager#osx) using [Homebrew](http://brew.sh/) or [MSI](http://nodejs.org/download/)  
    (Mac OS X) username$ npm install -g yo  
    (Windows) http://nodejs.org/download/

## Web Dev Resources ##
- [jQuery Plugins](http://plugins.jquery.com/)
- [CSS Tricks](http://github.com/CSS-Tricks/)

<br/>

## Miscellanea ##
### Open-Source Software (OSS) 
- [Adobe OpenSource](http://html.adobe.com/opensource/)

### Useful Utilities 
- [Desktop Utility](http://sweetpproductions.com/)
- [Display Menu](https://itunes.apple.com/us/app/display-menu/id549083868?mt=12)
- [SecondBar](https://www.macupdate.com/app/mac/33264/secondbar)

### Shell Scripts
#### .bash_profile
> The following script is a compilation of my various work environments.  
> To note: **ferment**, **ls**, **edit**

```bash
alias hidden='defaults write com.apple.Finder AppleShowAllFiles'

#alias rename='for f in *; do if [["$f" =~ $* ]]; then mv "$f" "${BASH_REMATCH[1]}"; fi; done;'
#alias ritup='cd /Volumes/Dev/web/toyota/svn/rit/ToyotaSite2012UI; svn cleanup; svn up;'
alias ferment='brew up && brew upgrade `brew outdated` && gem up && npm up'
#alias jsdoc='/Volumes/Dev/jsdoc/jsdoc -l -d ./jsdocs'
alias apache='cd /Applications/XAMPP'
alias reload='source ~/.bash_profile'
alias edit='open -a TextEdit.app'
alias ls='ls -alhFG'
alias home='cd ~'

alias svn='/opt/local/bin/svn'
alias IP='ipconfig getifaddr en0'
alias js='/Volumes/Dev/GitHub/v8/out/native/shell'
#alias watchrit='while true; do ritup echo "SVN Update for RIT at $(date)."; sleep 600; done'

export PATH=/usr/local/bin:/usr/local/sbin:/android-sdk-macosx/platform-tools:/usr/local/share/npm/bin:$PATH
export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home
export EDITOR=/Applications/TextEdit.app/Contents/MacOS/TextEdit
export JBOSS_HOME=/jboss-5.1.0.GA

export SLPADMIN=/Volumes/Dev/web/toyota/svn/slp/SLPAdmin/trunk
function slp () {
  local __pwd=`pwd`
  local __pid=`pid get SLPPID`
  if [ "$1" = "up" ]; then
    cd $SLPADMIN; svn cleanup; svn up;
    echo "SLP has been updated."; return 0;
  fi
  echo "SLP v2.0 Admin script running …"
  if [ "$1" = "build" ]; then
    echo "Building SLPAdmin application …"
    slp up; mvn -DskipTests install
    cp $HOME/.m2/repository/com/tms/slp20/slpadmin/1.0/slpadmin-1.0.war $JBOSS_HOME/server/all-with-hornetq/deploy
    echo "Done building and copying SLPAdmin application."
  fi
  if [[ $__pid && ( "$1"="stop" || "$1"="kill" )]]; then
    for id in $(ps -A | grep org.jboss | awk '{print $1}'); do kill $id; done;
    echo "Killing SLP with Process ID: $SLPPID"
    kill $__pid && pid unset SLPPID
  else
    cd $JBOSS_HOME/bin
    nohup ./run.sh -c all-with-hornetq -P ../test.properties -g wheel -u 239.255.100.100 -b 0.0.0.0 -Djboss.messaging.ServerPeerID=-Djboss.service.binding.set=ports-default >/dev/null & >/dev/null
    sleep 10 && echo "Starting server (for SLPAdmin) in background with PID: $(pid set SLPPID $!; pid get SLPPID). Please wait 15 seconds …"
    sleep 5 && echo "Please wait 10 seconds …" && sleep 5 && echo "Please wait 5 seconds …" && sleep 5
    open http://localhost:8080/slpadmin-1.0/ &
    echo "You may need a browser refresh."
    cd $__pwd
  fi
  echo "SLP v2.0 Admin script finished."
}
function pid () {
	if [ "$1" = "set" ]; then
		launchctl setenv $2 $3
	elif [ "$1" = "unset" ]; then
		launchctl unsetenv $2
	elif [ "$1" = "get" ]; then
		eval "launchctl getenv $2"
	fi
}

[[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" # Load RVM into a shell session *as a function*
```