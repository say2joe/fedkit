(function(ns) {
  var LF = {

    init: function() {
      this.FR = new FileReader();
    }

  }

  ns.LocalFilesChromeExtension = LF;

})(this);

document.addEventListener('DOMContentLoaded', function() {
  LocalFilesChromeExtension.init();
});