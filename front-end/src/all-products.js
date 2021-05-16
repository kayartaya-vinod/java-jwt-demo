var baseUrl = 'http://localhost:8080/api/';

$(function () {
    var productsUrl = baseUrl + 'products';

    // make an ajax call to the rest server to get the data
    $.get(productsUrl)
        .then(function (products) {
            var out = '<div class="row">';

            products.forEach(function (p) {
                out += `<div class="col-3 card" onClick="getOneProduct(${p.id})">
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
});
