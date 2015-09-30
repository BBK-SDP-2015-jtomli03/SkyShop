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
        <button class="waves-effect waves-light btn red" onclick="emptyCartButton();">Empty Cart</button>
    </div>
</div>

<jsp:include page="modules/bestsellers.jsp" />
<jsp:include page="modules/footer.jsp" />
<script type="application/javascript">
    basketStartCart();
    $( "input" ).change(function() {
        basketUpdateCart();
    });
</script>