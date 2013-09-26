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
## Web App Scaffolding ##
### [Yeoman](https://github.com/yeoman/yeoman/wiki/Getting-Started)
> Includes (optionally): HTML5 Boilerplate, jQuery, Bootstrap, Modernizr, Angular, etc. /w Bower and Grunt.
#### Install [nodejs/npm](https://github.com/joyent/node/wiki/Installing-Node.js-via-package-manager#osx) using [Homebrew](http://brew.sh/) or [MSI](http://nodejs.org/download/)  
    (Mac OS X) username$ npm install -g yo  
    (Windows) http://nodejs.org/download/

<br/>
## Web Dev Resources ##
### General: Plugins and Tips & Tricks
- [jQuery Plugins](http://plugins.jquery.com/)
- [CSS Tricks](http://github.com/CSS-Tricks/)

### Forms: jQuery Plugins, etc.
- [Improved UX](http://blog.teamtreehouse.com/best-free-jquery-form-plugins-to-improve-user-experience)
- [Validation](http://plugins.jquery.com/tag/validate/)
- [h5Validate](http://ericleads.com/h5validate/)

### Table data (inlcuding RWD)
- [DataTables](http://www.datatables.net/)
- [FooTable](https://github.com/bradvin/FooTable)

### Timelines and Graphing
- [TimelineJS](http://timeline.verite.co/)
- [Timeglider](http://timeglider.com/widget/kitchen_sink.html)

### Responsive Web Design
- [Media Queries](http://css-tricks.com/snippets/css/media-queries-for-standard-devices/)
- [Menus / Nav](http://www.jqueryfeed.net/go/140/menufication-responsive-fly-out-menu)

### JS Debugging
- [Object Debugger](https://gist.github.com/say2joe/6707788)

<br/>

## Miscellanea ##
### Best Practices and Debugging
- [Chrome Dev Tools](https://developers.google.com/chrome-developer-tools/docs/authoring-development-workflow)
- [Visual Event 2](http://www.sprymedia.co.uk/article/Visual+Event+2)

### Open-Source Software (OSS) 
- [CHAP - Collective Human-Agent Paradigm](http://chap.almende.com/)
- [Adobe OpenSource](http://html.adobe.com/opensource/)

### Useful Utilities
- [View (all) Plain Text Files in Finder](https://coderwall.com/p/dlithw)
- [Desktop Utility](http://sweetpproductions.com/)
- [Display Menu](https://itunes.apple.com/us/app/display-menu/id549083868?mt=12)
- [SecondBar](https://www.macupdate.com/app/mac/33264/secondbar)

### Multimedia
- [YouTube Audio Library](http://www.youtube.com/audiolibrary)

### Fonts/Text
- [Google Web Fonts](http://www.google.com/fonts)
- [Adobe Edge Fonts](https://edgewebfonts.adobe.com/fonts)
- [Font Squirrel](http://www.fontsquirrel.com/)

### Newsletters
- [How-To Geek Daily](http://www.howtogeek.com/)
- [Web Design Weekly](http://web-design-weekly.com/)
- [JavaScript Weekly](http://javascriptweekly.com/)
- [HTML5 Weekly](http://html5weekly.com/)
- [CSS-Tricks](http://css-tricks.com/subscription-options/)
- [Smashing](http://www.smashingmagazine.com/the-smashing-newsletter/)


### Shell Scripts
#### .bash_profile
> The following script is a compilation of my various work environments.  
> To note: **ferment**, **ls**, **edit**

```bash
defaults write com.apple.finder QLEnableTextSelection -bool true
alias hidden='defaults write com.apple.Finder AppleShowAllFiles'

#alias toyota='cd /Volumes/Dev/web/toyota/pswebp41/cache/default/main/Toyota/Toyota2007/WORKAREA/johnjoe'
alias rename='for f in *; do if [["$f" =~ $* ]]; then mv "$f" "${BASH_REMATCH[1]}"; fi; done;'
#alias ritup='cd /Volumes/Dev/web/toyota/svn/rit/ToyotaSite2012UI; svn cleanup; svn up;'
alias pup='pip freeze --local | grep -v '^\-e' | cut -d = -f 1  | xargs pip install -U'
alias ferment='brew up && brew upgrade `brew outdated` && gem up && npm up'
#alias jsdoc='/Volumes/Dev/jsdoc/jsdoc -l -d ./jsdocs'
#alias apache='cd /Applications/MAMP/conf/apache'
#alias software='cd /Volumes/Dev/Software'
alias sudoedit='sudo open -a TextEdit.app'
alias reload='source ~/.bash_profile'
alias edit='open -a TextEdit.app'
#alias web='cd /Volumes/Dev/web'
alias ls='ls -alhFG'
alias home='cd ~'

alias IP='ipconfig getifaddr en0'
alias svn='/opt/local/bin/svn'
#alias js='/Volumes/Dev/GitHub/v8/out/native/shell'
#alias watchrit='while true; do ritup echo "SVN Update for RIT at $(date)."; sleep 600; done'

export PATH=/usr/local/bin:$PATH
#export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home
export EDITOR=/Applications/TextEdit.app/Contents/MacOS/TextEdit
#export JBOSS_HOME=/jboss-5.1.0.GA

#export SLPADMIN=/Volumes/Dev/web/toyota/svn/slp/SLPAdmin/trunk
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

#[[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" # Load RVM into a shell session *as a function*

```