var fullname = localStorage.getItem('fullname');
if (checkForLoggedInStatus()) {
    $('#fullname').text(fullname);
}
