function logout() {
    localStorage.clear();
    location.href = './#login';
    loadView();
    showHideUserOptions();
}

function navigateTo(path) {
    location.href = `./#${path}`;
    loadView();
}

function checkForLoggedInStatus() {
    var fullname = localStorage.getItem('fullname');
    if (!fullname) {
        location.href = './#login';
        loadView();
        return false;
    }
    return true;
}

function loadView() {
    var path = location.href.split('#')[1];

    $.get(`./src/${path}.html`)
        .then((content) => $('#view').html(content))
        .catch(console.error);
}

$(function () {
    loadView();
    showHideUserOptions();
});

function showHideUserOptions() {
    var fullname = localStorage.getItem('fullname');
    if (!fullname) {
        $('#visitorOptions').show();
        $('#userOptions').hide();
    } else {
        $('#visitorOptions').hide();
        $('#userOptions').show();
    }
}

/* function getMessage() {
    var id = Math.round(1 + Math.random() * 75);
    var url = 'http://localhost:8080/api/products/' + id;

    $.get(url).then((p) => $('#plist').html('<li>' + p.name + '</li>'));
} */

// setInterval(getMessage, 1000);
