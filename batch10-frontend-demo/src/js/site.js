const cache = {};

function navigateTo(path) {
    location.href = `./#${path}`; // will trigger 'popstate' event on window
}

function loadView() {
    const path = location.href.split('#')[1];
    if (!path || path === '/') return;

    if (path in cache === false) {
        // if the value of path (such as 'home' or 'profile') is a key in the object cache

        $.get(`./src/templates/${path}.html`)
            .then((content) => {
                cache[path] = content;
                $('#view').html(content);
            })
            .catch(() => navigateTo('home'));
    } else {
        $('#view').html(cache[path]);
    }
}

// on page ready
$(loadView);

// handle back button
$(window).on('popstate', loadView);
