const cache = {};

function navigateTo(path) {
    location.href = `./#${path}`;
    loadView();
}

function loadView() {
    const path = location.href.split('#')[1];
    if (!path || path === '/') return;

    if (!cache[path]) {
        $.get(`./src/templates/${path}.html`)
            .then((content) => {
                cache[path] = content;
                $('#view').html(cache[path]);
            })
            .catch(console.error);
    } else {
        $('#view').html(cache[path]);
    }
}

$(function () {
    loadView();
});

// handle back button
$(window).on('popstate', loadView);
