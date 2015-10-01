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

function addToCart( product, price, num, id ) {
    var cart = sessionStorage.getItem("cart");
    var cartObject = JSON.parse( cart );
    var cartCopy = cartObject;
    var items = cartCopy.items;
    items.push( {
        "product": product,
        "id": id,
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
        $(obj).next().find('h5').html("&pound;" + price);
    });
}

function basketUpdateCart() {
    k = 0;
    var cart = JSON.parse(sessionStorage.getItem("cart"));
    if(cart.items[0]==null){
        $('#checkOut').addClass('disabled')
    } else {
        $('#checkOut').removeClass('disabled')
    }
    $(".prod").each(function (i, obj) {
        //console.log("input changed");
        var price = parseFloat($(obj).find('.price').val());
        var num = parseFloat($(obj).find('.num').val());
        var name = parseFloat($(obj).find('.name').val());
        var id = parseFloat($(obj).find('.id').val());
        if (parseInt(num)==0){
            $(obj).parent().parent().remove();
            console.log(id);
            cart.items.splice(parseInt(id),1);
        } else {
            cart.items[parseInt(id)].num = parseInt(num);
            j = price * num;
            k += j;
        }
        var jsonStr = JSON.stringify( cart );
        sessionStorage.setItem( "cart", jsonStr );
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
                    '<h5 class="title blue-text"></h5>' +
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

function checkout() {
    $('#modal1').openModal();
    var cart = JSON.parse(sessionStorage.getItem("cart"));

    var items = cart.items;
    var $tableCart = $( "#checkoutModal");
    $tableCart.html("");
    //console.log($tableCart);
    var totalPrice = 0;
    for( var i = 0; i < items.length; ++i ) {
        var item = items[i];
        var product = item.product;
        var price = item.price;
        var num = item.num;
        totalPrice += num * price;
        var html2 = '<div class="row">' +
            '<div class="col s6">' +
            '<p class="teal-text">' + num + ' x ' + product + '</p>' +
            '</div>' +
            '<div class="col s6">' +
            '<p class="right teal-text">'+'&pound;' + (price * num).toFixed(2) + '</p>' +
            '</div></div><hr>';
        $tableCart.html( $tableCart.html() + html2 );
    }
    var html = '<div class="col s6 offset-s6">' +
        '<h4 class="right teal-text">' +
        '&pound;' +totalPrice.toFixed(2) +
            '</h4></div>';
    $tableCart.html( $tableCart.html() + html );
}

function processCheckout(){
    //var sendString = [];
    var allProducts = [];
    var numProducts = [];
    var sumPrice = 0;
    var cart = JSON.parse(sessionStorage.getItem("cart"));
    var items = cart.items;
    //sendString.push("guest");
    for( var i = 0; i < items.length; ++i ) {
        var item = items[i];
        var id = item.id;
        var num = item.num;
        var price = item.price;
        allProducts.push(id);
        numProducts.push(num);
        //sendString.push(id.toString());
        //sendString.push(num.toString());
        sumPrice += num*price;
    }
    //sendString.push(sumPrice.toFixed(2).toString());
    sumPrice = sumPrice.toFixed(2);

    //console.log(sendString.toString());
    //jQuery.post( "/customer/order/place", "1,2,3", function()  {
    //    alert( "test" );
    //});
    //console.log(JSON.stringify(cart));
    /*
    jQuery.ajax({
        type: "POST",
        data: {sendString:sendString},
        url: "/customer/order/place",
        success:function(data) {
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown){
            alert(textStatus);
        }
    });
    */
    /*
    $.ajax({
        type: "POST",
        url: "/customer/order/place",
        data: { name: "John", location: "Boston" },
        success: function (html) {
            alert("works");
        },
        error: function(e) {
            console.log("Error:" + e);
        }
    });
    */

    $.ajax({
        type: "POST",
        url: "/customer/order/place",
        data: { products: allProducts.toString(), numbers: numProducts.toString(), cost: sumPrice, customer: "guest"},
        success: function (html) {
            window.location.href = "/confirmation";
            //alert("works");
        },
        error: function(e) {
            alert("Failed to contact the database! Please get in touch.");
        }
    });

    /*
    $.ajax({
        url: "/customer/order/place",
        dataType: "json",
        headers : {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        data: JSON.stringify(["test","test"]),
        type: "POST",
        contentType : 'application/json; charset=utf-8',
    });
*/
}
