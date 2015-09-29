<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<footer class="page-footer light-blue">
  <div class="container">
    <div class="row">
      <div class="col l6 s12">
        <h5 class="white-text">About Sky Accessories</h5>
        <p class="grey-text text-lighten-4">
          Sky Accessories is a traditional catalogue company based in the North-West of England. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt </p>
      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Settings</h5>
        <ul>
          <li><a class="white-text" href="#!">Link 1</a></li>
          <li><a class="white-text" href="#!">Link 2</a></li>
          <li><a class="white-text" href="#!">Link 3</a></li>
          <li><a class="white-text" href="#!">Link 4</a></li>
        </ul>
      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Connect</h5>
        <ul>
          <li><a class="white-text" href="#!">Link 1</a></li>
          <li><a class="white-text" href="#!">Link 2</a></li>
          <li><a class="white-text" href="#!">Link 3</a></li>
          <li><a class="white-text" href="#!">Link 4</a></li>
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
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<spring:url value="/resources/js/materialize/materialize.js" var="matJs" />
<script src="${matJs}"></script>
<spring:url value="/resources/js/init.js" var="initJs" />
<script src="${initJs}"></script>

</body>
</html>