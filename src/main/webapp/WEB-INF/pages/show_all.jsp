<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="modules/header.jsp" />
<jsp:include page="modules/remote.jsp" />

<div class="section"></div>

<div class="row">
    <div class="col m10 offset-m1 s12">
        <h3 class="header blue-grey-text">View Products</h3>
        <hr>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col m4 l3">
                    <div class="card small">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="${product.imageUrl}">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">${product.name}<i class="material-icons right">more_vert</i></span>
                            <p><a href="/product?Id=${product.id}">View Product</a></p>
                            <p>${product.shortDescription}</p>
                        </div>
                        <div class="card-reveal">
                            <span class="card-title grey-text text-darken-4">${product.name}<i class="material-icons right">close</i></span>
                            <p>${product.longDescription}</p>
                            <div class="center">
                                <a href="/product?Id=${product.id}" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">send</i></a>
                                <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">shopping_basket</i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<jsp:include page="modules/footer.jsp" />