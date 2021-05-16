function getOneProduct(id) {
    $.get(baseUrl + 'products/' + id)
        .then(function (p) {
            $('#view').html(`<div class="row">
        <div class="col">
          <img src="${p.picture}" alt="${p.name}" />
        </div>
        <div class="col">
          <h3>${p.description}</h3>
        </div>
      </div>
      `);
        })
        .catch(console.error);
}
