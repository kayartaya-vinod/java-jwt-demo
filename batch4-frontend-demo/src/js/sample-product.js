var id = Math.round(1 + Math.random() * 85);

$.get(`http://localhost:8080/api/products/${id}`).then((p) => {
    $('#description').text(p.description);
    $('#name').text(p.name);
    $('#price').text(p.unitPrice);
    $('#qpu').text(p.quantityPerUnit);
    $('#discount').text(p.discount);
    $('#picture').attr('src', p.picture);
});
