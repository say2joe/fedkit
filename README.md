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
#### General: Plugins and Tips & Tricks
- [WebPlatform.org](http://platform.html5.org/)
- [jQuery Plugins](http://plugins.jquery.com/)
- [jQuery Tools](http://jquerytools.org/)
- [CSS Tricks](http://github.com/CSS-Tricks/)
- [Can I Use](http://caniuse.com/)

#### UI / User Experience
- [Improved UX (forms)](http://blog.teamtreehouse.com/best-free-jquery-form-plugins-to-improve-user-experience)
- [CSS Hacks & Tricks](https://gist.github.com/say2joe/6734483)
- [jQuery UI](http://jqueryui.com/)

#### Forms: jQuery Plugins, etc.
- [Improved UX (forms)](http://blog.teamtreehouse.com/best-free-jquery-form-plugins-to-improve-user-experience)
- [jQuery Validate](http://jqueryvalidation.org/)
- [h5Validate](http://ericleads.com/h5validate/)

#### Table data (inlcuding RWD)
- [DataTables](http://www.datatables.net/)
- [FooTable](https://github.com/bradvin/FooTable)

#### Timelines and Graphing
- [TimelineJS](http://timeline.verite.co/)
- [Timeglider](http://timeglider.com/widget/kitchen_sink.html)

#### Responsive Web Design
- [Media Queries](http://css-tricks.com/snippets/css/media-queries-for-standard-devices/)
- [Menus / Nav](http://www.jqueryfeed.net/go/140/menufication-responsive-fly-out-menu)

#### JS Debugging
- [Object Debugger](https://gist.github.com/say2joe/6707788)

#### Fonts/Text
- [Google Web Fonts](http://www.google.com/fonts)
- [Adobe Edge Fonts](https://edgewebfonts.adobe.com/fonts)
- [Font Squirrel](http://www.fontsquirrel.com/)

#### Snippets
- [Joe's Gists](http://gist.github.com/say2joe)

<br/>

## Miscellanea ##
#### Best Practices and Debugging
- [Chrome Dev Tools](https://developers.google.com/chrome-developer-tools/docs/authoring-development-workflow)
- [Visual Event 2](http://www.sprymedia.co.uk/article/Visual+Event+2)

#### Open-Source Software (OSS) 
- [CHAP - Collective Human-Agent Paradigm](http://chap.almende.com/)
- [Adobe OpenSource](http://html.adobe.com/opensource/)

#### Useful Utilities
- [View (all) Plain Text Files in Finder](https://coderwall.com/p/dlithw)
- [Desktop Utility](http://sweetpproductions.com/)
- [Display Menu](https://itunes.apple.com/us/app/display-menu/id549083868?mt=12)
- [SecondBar](https://www.macupdate.com/app/mac/33264/secondbar)

#### Multimedia
- [YouTube Audio Library](http://www.youtube.com/audiolibrary)

#### Newsletters
- [How-To Geek Daily](http://www.howtogeek.com/)
- [Web Design Weekly](http://web-design-weekly.com/)
- [JavaScript Weekly](http://javascriptweekly.com/)
- [HTML5 Weekly](http://html5weekly.com/)
- [CSS-Tricks](http://css-tricks.com/subscription-options/)
- [Smashing](http://www.smashingmagazine.com/the-smashing-newsletter/)

<br/>

## Bookmarklets ##
#### Debugging
- Visual Event
`javascript:(function()%20%7Bvar%20protocol%20%3D%20window.location.protocol%20%3D%3D%3D%20%27file:%27%20%3F%27http:%27%20:%20%27%27%3Bvar%20url%20%3D%20protocol%2B%27//www.sprymedia.co.uk/VisualEvent/VisualEvent_Loader.js%27%3Bif(%20typeof%20VisualEvent!%3D%27undefined%27%20)%20%7Bif%20(%20VisualEvent.instance%20!%3D%3D%20null%20)%20%7BVisualEvent.close()%3B%7Delse%20%7Bnew%20VisualEvent()%3B%7D%7Delse%20%7Bvar%20n%3Ddocument.createElement(%27script%27)%3Bn.setAttribute(%27language%27,%27JavaScript%27)%3Bn.setAttribute(%27src%27,url%2B%27%3Frand%3D%27%2Bnew%20Date().getTime())%3Bdocument.body.appendChild(n)%3B%7D%7D)()%3B`

#### Utilities
- Dual View:
`javascript:A14nH=location.href;L3f7=prompt('Choose%20File%201',A14nH);R1Gh7=prompt('Choose%20File%202',L3f7);if(L3f7&&R1Gh7){Fr4Q='<frameset%20cols=\'*,*\'>\n<frame%20src=\''+L3f7+'\'/>';Fr4Q+='<frame%20src=\''+R1Gh7+'\'/>\n';Fr4Q+='</frameset>';with(document){write(Fr4Q);void(close())}}else{void(null)}`
- Curiate This
`javascript:void((function()%7Bvar%20e%3Ddocument.createElement(%27script%27)%3Be.setAttribute(%27src%27,%27//curiator.com/static/js/bookmarklet.js%3Fr%3D%27%20%2B%20(new%20Date()).getTime())%3Be.setAttribute(%27type%27,%27text/javascript%27)%3Be.setAttribute(%27charset%27,%27UTF-8%27)%3Bdocument.body.appendChild(e)%7D)())%3B`

<br/>

### Shell Scripts
- [Joe's .bash_profile](https://gist.github.com/say2joe/ae87bea4ad39b19fe40f)
