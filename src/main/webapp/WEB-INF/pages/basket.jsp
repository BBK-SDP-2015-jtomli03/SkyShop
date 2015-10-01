<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="modules/header.jsp" />
<jsp:include page="modules/remote.jsp" />
<div class="section"></div>
<div class="row">
    <div class="col m10 offset-m1">
        <h3 class="header blue-grey-text">Shopping Basket</h3>
        <hr>
        <div class="section"></div>
        <form>
            <div id="productList" class="row">

            </div>
        </form>
        <button class="waves-effect waves-light btn red" onclick="emptyCartButton();">Empty Cart<i class="material-icons right">cancel</i></button>
        <button class="waves-effect waves-light btn green right disabled" id="checkOut" onclick="checkout();">Checkout<i class="material-icons right">send</i></button>
    </div>
</div>

<div id="modal1" class="modal">
    <div class="modal-content">
        <h4>Checkout</h4>
        <ul id="checkoutModal">
        </ul>
    </div>
    <div class="modal-footer">
        <div class="row">
            <div class="col s10 offset-m1">
                <button class="waves-effect waves-light btn green right" onclick="processCheckout();">Confirm<i class="material-icons right">send</i></button>
            </div>
        </div>
    </div>
</div>
<form class="hide" action="#" th:action="@{/customer/order/new}" th:object="${greeting}" method="post">
    <input type="text" th:field="*{id}" />
</form>
<jsp:include page="modules/bestsellers.jsp" />
<jsp:include page="modules/footer.jsp" />
<script type="application/javascript">
    basketStartCart();
    $( "input" ).change(function() {
        basketUpdateCart();
    });
</script>