//Cambiar el active en el navbar
$(function() {
    var path = window.location.pathname.split("/").pop();
    
    if (path === "") {
        path = "home.jsp";
    }
    
    var act = $('.nav li a[href="'+path+'"]');
    act.addClass('active');
});