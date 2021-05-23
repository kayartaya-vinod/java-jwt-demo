if (checkForLoggedInStatus()) {
    // user has logged in

    var names = ['Vinod', 'Shyam', 'Harish'];
    names.forEach((name) => $('#names').append(`<li>${name}</li>`));
}
