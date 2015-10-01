<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<footer class="page-footer light-blue">
  <div class="container">
    <div class="row">
      <div class="col l6 s12">
        <h5 class="white-text">About Sky Accessories</h5>
        <p class="grey-text text-lighten-4">
          Sky Accessories is the newest member of the Sky family. Find the latest in audio visual accessories and much much more, all from the convenience of whether you are in the world.</p>
      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Accounts</h5>
        <ul>
          <li><a class="white-text" href="/login">Log In</a></li>
          <li><a class="white-text" href="/account">Account Details</a></li>
        </ul>
      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Site Map</h5>
        <ul>
          <li><a class="white-text" href="/">Homepage</a></li>
          <li><a class="white-text" href="/show_all">View All Products</a></li>
          <li><a class="white-text" href="/product">Example Product</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="container">
      Made by <a class="pink-text text-lighten-3" href="#">Pink Velocity</a>
    </div>
  </div>
</footer>

<!--  Scripts-->
<spring:url value="/resources/js/jquery-2.1.1.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<!--
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
-->
<spring:url value="/resources/js/materialize/materialize.js" var="matJs" />
<script src="${matJs}"></script>
<spring:url value="/resources/js/init.js" var="initJs" />
<script src="${initJs}"></script>
<spring:url value="/resources/js/cart.js" var="cartJs" />
<script src="${cartJs}"></script>
</body>
</html>