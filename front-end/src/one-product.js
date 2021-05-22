function getOneProduct(id) {
    $.get(baseUrl + 'products/' + id)
        .then(function (p) {
            $('#view').html(`<div class="row">
        <div class="col">
          <img src="${p.picture}" alt="${p.name}" />
        </div>
        <div class="col">
          <h3>${p.description}</h3>
          <table class="table">
            <tr>
              <td>Unit price</td>
              <td>₹ ${p.unitPrice}</td>
            </tr>
            <tr>
              <td>Discount</td>
              <td>${p.discount}%</td>
            </tr>
            <tr>
              <td>Quantity per unit</td>
              <td>${p.quantityPerUnit}</td>
            </tr>
            <tr>
              <td>Brand</td>
              <td>${p.brand}</td>
            </tr>
            <tr>
              <td>Category</td>
              <td>${p.category}</td>
            </tr>
          </table>
        </div>
      </div>`);
        })
        .catch(console.error);
}
