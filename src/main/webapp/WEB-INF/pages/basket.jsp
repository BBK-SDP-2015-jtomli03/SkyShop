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
            <ul class="collection">
                <li class="collection-item avatar">
                    <div class="col m2 s3">
                        <img class="circle" src="<spring:url value="/resources/img/gnome.JPG" />">
                    </div>
                    <div class="col m6 s9">
                        <span class="title"><a href="/product">Product Name</a></span>
                        <p>Short product description lorem ipsum dolor sit amet, consectetur</p>
                    </div>
                    <div class="col m4 s12 right">
                        <div class="input-field col s6 prod">
                            <i class="material-icons prefix">plus</i>
                            <input type="number" value="4.99" class="hide price">
                            <input type="number" value="1" class="validate num">
                            <label>Num:</label>
                        </div>
                        <div class="col s6 input-field">
                            <h3 class="title blue-text"></h3>
                        </div>
                    </div>
                </li>
                <li class="collection-item avatar">
                    <div class="col m2 s3">
                        <img class="circle" src="<spring:url value="/resources/img/gnome.JPG" />">
                    </div>
                    <div class="col m6 s9">
                        <span class="title"><a href="/product">Product Name</a></span>
                        <p>Short product description lorem ipsum dolor sit amet, consectetur</p>
                    </div>
                    <div class="col m4 s12 right">
                        <div class="input-field col s6 prod">
                            <i class="material-icons prefix">plus</i>
                            <input type="number" value="4.99" class="hide price">
                            <input type="number" value="1" class="validate num">
                            <label>Num:</label>
                        </div>
                        <div class="col s6 input-field">
                            <h3 class="title blue-text"></h3>
                        </div>
                    </div>
                </li>
                <li class="collection-item right">
                    <h4 id="totalPrice" class="blue-text">Total: </h4>
                </li>
            </ul>
        </form>
    </div>
</div>

<jsp:include page="modules/bestsellers.jsp" />
<jsp:include page="modules/footer.jsp" />
<spring:url value="/resources/js/cart.js" var="cartJs" />
<script src="${cartJs}"></script>