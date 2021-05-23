var baseUrl = 'http://localhost:8080/api/';

// function fn() {
//     alert('Hello');
// }
// $(fn); // the argument fn is a function, executed when the entire DOM is ready

$(function () {
    var productsUrl = baseUrl + 'products';

    // var token = localStorage.getItem('token');
    // if (token) {
    // make an ajax call to the rest server to get the data
    $.ajax(productsUrl, {
        method: 'GET',
        data: {
            timestamp: Date.now(),
        },
        // headers: {
        //     Authorization: 'JWT ' + token,
        // },
    })
        .then(function (products) {
            var out = '<div class="row">';

            products.forEach(function (p) {
                out += `<div style="cursor: pointer;" class="col-3 card" onClick="getOneProduct(${p.id})">
            <img src="${p.picture}" class="card-img-top" alt="${p.name}">
            <div class="card-body">
              <h5 class="card-title">${p.description}</h5>
              <p class="card-text">${p.quantityPerUnit}</p>
              <p class="card-text">₹ ${p.unitPrice}</p>
            </div>
          </div>`;
            });

            out += '</div>';

            $('#view').html(out);
        })
        .catch(function (err) {
            console.error(err);
        });
    // } else {
    //     // redirec the user to login page
    //     alert('Login required');
    // }
});
