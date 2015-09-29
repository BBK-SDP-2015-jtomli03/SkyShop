/**
 * Created by jat40 on 29/09/15.
 */

$( document ).ready(function() {
    startCart();
    $( "input" ).change(function() {
       updateCart();
    });
});

function startCart() {
    updateCart();
    $(".prod").each(function (i, obj) {
        var price = parseFloat($(obj).find('.price').val());
        //var price = $(obj).find('.price').val();
        $(obj).next().find('h3').html("&pound;" + price);
    });
}

function updateCart() {
    k = 0;
    $(".prod").each(function (i, obj) {
        //console.log("input changed");
        var price = parseFloat($(obj).find('.price').val());
        var num = parseFloat($(obj).find('.num').val());
        j = price * num;
        k+=j;
    });
    $("#totalPrice").html("Total: " + "&pound;" + k);
}

