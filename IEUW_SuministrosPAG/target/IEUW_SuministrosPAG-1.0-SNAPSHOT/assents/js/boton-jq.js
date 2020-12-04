$(window).resize(function () {
    var heightBrowser = $(window).width();
    if (heightBrowser < 978) {
        if ($("#menu-toggle").length == 0) {
            var buttonMenu = "<button class='btn btn-primary' id='menu-toggle'>Menu</button>";
            $(".menu-button").append(buttonMenu);
        }
    } else {
        if ($("#menu-toggle").length > 0) {
            $(".menu-button").remove();
        }
    }
});