/**
 * Created by jat40 on 29/09/15.
 */

$( document ).ready(function(){
        if (sessionStorage.getItem( "cart" )==null){
            emptyCart();
        }

// now the cart is {"item":"Product 1","price":35.50,"qty":2}
        var cartValue = sessionStorage.getItem( "cart" );
        var cartObj = JSON.parse( cartValue );
    }
);

function addToCart( product, price, num ) {
    var cart = sessionStorage.getItem("cart");
    var cartObject = JSON.parse( cart );
    var cartCopy = cartObject;
    var items = cartCopy.items;
    items.push( {
        "product": product,
        "price": price,
        "num": num
    } );

    sessionStorage.setItem( "cart", JSON.stringify( cartCopy ) );
}

function basketStartCart() {
    displayFunction();
    basketUpdateCart();
    $(".prod").each(function (i, obj) {
        var price = parseFloat($(obj).find('.price').val());
        //var price = $(obj).find('.price').val();
        $(obj).next().find('h3').html("&pound;" + price);
    });
}

function basketUpdateCart() {
    k = 0;
    $(".prod").each(function (i, obj) {
        //console.log("input changed");
        var price = parseFloat($(obj).find('.price').val());
        var num = parseFloat($(obj).find('.num').val());
        var name = parseFloat($(obj).find('.name').val());
        var id = parseFloat($(obj).find('.id').val());
        if (parseInt(num)==0){
            var cart = JSON.parse(sessionStorage.getItem("cart"));
            $(obj).parent().parent().remove();
            delete cart.items[id];
        } else {
            j = price * num;
            k += j;
        }
    });
    $("#totalPrice").html("Total: " + "&pound;" + k.toFixed(2));

}

function displayFunction() {
    var cart = JSON.parse(sessionStorage.getItem("cart"));

    var items = cart.items;
    var $tableCart = $( "form").find( "#productList" );

    //console.log($tableCart);

    for( var i = 0; i < items.length; ++i ) {
        var item = items[i];
        var product = item.product;
        var price = item.price;
        var num = item.num;
        var html = '<div class="col s12">' +
            '<div class="row">' +
                '<div class="col m2 s3">' +
                    '<img class="circle" src="/resources/img/gnome.JPG">' +
                '</div>' +
                '<div class="col m6 s9">' +
                '<span class="title">' +
                    '<a href="/product">' + product + '</a>' +
                '</span>' +
                '<p>Short product description lorem ipsum dolor sit amet, consectetur</p>' +
            '</div>' +
            '<div class="col m4 s12 right">' +
                '<div class="input-field col s6 prod">' +
                    '<i class="material-icons prefix">plus</i>' +
                    '<input type="number" value="'+i+'" class="hide id">' +
                    '<input type="number" value="'+product+'" class="hide name">' +
                    '<input type="number" value="'+price+'" class="hide price">' +
                    '<input type="number" value="'+num+'" class="validate num">' +
                    '<label>Num:</label>' +
                '</div>' +
                '<div class="col s6 input-field">' +
                    '<h3 class="title blue-text"></h3>' +
                '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
        $tableCart.html( $tableCart.html() + html );
    }
    var html = '<div class="col s12 right">' +
                    '<h4 id="totalPrice" class="blue-text right"> </h4>' +
                '</div>';
    $tableCart.html( $tableCart.html() + html );
}
function emptyCart() {
    var cart = {
        "items": [
        ] };
    var jsonStr = JSON.stringify( cart );
    sessionStorage.setItem( "cart", jsonStr );
}
function emptyCartButton() {
    emptyCart();
    window.location.href = "/basket";
}